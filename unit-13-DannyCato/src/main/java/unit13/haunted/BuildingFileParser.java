package unit13.haunted;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuildingFileParser {
    private Random RNG;
    private Collection<Area> safeArea;
    private Collection<Area> exitArea;
    private Collection<Area> hauntedArea;
    private Map<Area, Collection<Area>> passages;

    public BuildingFileParser(String filename) throws IOException {
        RNG = new Random();
        safeArea = new ArrayList<>();
        exitArea = new ArrayList<>();
        hauntedArea = new ArrayList<>();
        passages = new HashMap<>();
        Map<String, Area> allAreas = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String line = reader.readLine();
        while (line != null) {
            String[] areas = line.split(",");
            ArrayList<Area> connected = new ArrayList<>();

            connected.clear();
            for (String a : areas) {
                String[] info = a.split("-");
                String name = info[0];
                String type = info[1];
                Area ar = null;

                if (!(allAreas.keySet().contains(name))) {
                    if (type.equals("ROOM")) {
                        ar = new Area(name, AreaType.ROOM);
                        allAreas.put(name, ar);
                        connected.add(ar);
                        safeArea.add(ar);
                    }
                    else if (type.equals("EXIT")) {
                        ar = new Area(name, AreaType.EXIT);
                        allAreas.put(name, ar);
                        connected.add(ar);
                        exitArea.add(new Area(name, AreaType.EXIT));
                        
                    }
                    else if (type.equals("HALLWAY")) {
                        ar = new Area(name, AreaType.HALLWAY);
                        allAreas.put(name, ar);
                        connected.add(ar);
                        safeArea.add(ar);
                    }
                } else {
                    connected.add(allAreas.get(name));
                }
                if (ar != null) {
                    if (ar.getType() != AreaType.EXIT) {
                        if (RNG.nextInt(100) < 40) {
                            safeArea.remove(ar);
                            ar.haunt("EVIL!");
                            hauntedArea.add(ar);
                        }
                    }
                }
            }

            String[] info = areas[0].split("-");
            Area poi = allAreas.get(info[0]);
            Set<Area> addMe = new HashSet<>(connected);
            addMe.remove(poi);
            passages.put(poi, addMe);

            line = reader.readLine();
        }
    }

    public Collection<Area> getSafeArea() {
        return safeArea;
    }

    public Collection<Area> getExitArea() {
        return exitArea;
    }

    public Collection<Area> getHauntedArea() {
        return hauntedArea;
    }

    public Map<Area, Collection<Area>> getPassages() {
        return passages;
    }

    public Area getStartArea() {
        int num = RNG.nextInt(safeArea.size());
        return (Area) safeArea.toArray()[num];
    }
}
