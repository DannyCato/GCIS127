package unit13.haunted;

import java.util.Collection;
import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;

public class EscapeBT implements Configuration<EscapeBT> {
    private BuildingFileParser bfp;
    private Area start;
    private Collection<Area> path;

    public EscapeBT(BuildingFileParser bfp) {
        this.bfp = bfp;
        this.start = bfp.getStartArea();
        path = new ArrayList<>();
        path.add(start);
    }

    public EscapeBT(BuildingFileParser bfp, Area start) {
        this.bfp = bfp;
        this.start = start;
        path = new ArrayList<>();
        path.add(start);
    }

    public EscapeBT(BuildingFileParser bfp, Collection<Area> path) {
        this.bfp = bfp;
        this.start = (Area) path.toArray()[path.size() - 1];
        this.path = path;

        // System.out.println("\t" + toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("The full path: ");
        String filename = sc.nextLine();
        BuildingFileParser bfp = new BuildingFileParser(filename);
        Area start = bfp.getStartArea();
        System.out.println(start);
        EscapeBT ebt = new EscapeBT(bfp,start);
        Backtracker<EscapeBT> bt = new Backtracker<>(false);

        EscapeBT solution = bt.solve(ebt);
        
        if (solution != null) {
            System.out.println(solution.toString());
        } else {
            System.out.println("There is no escape");
        }

        sc.close();
    }

    @Override
    public Collection<EscapeBT> getSuccessors() {
        // System.out.println("\n"+ toString());
        List<EscapeBT> list = new ArrayList<>();
        Collection<Area> passages = prune(bfp.getPassages().get(start));
        for (Area a : passages) {
            ArrayList<Area> copy = new ArrayList<>(path);
            copy.add(a);
            list.add(new EscapeBT(bfp, copy));
        }
        return list;
    }

    private Collection<Area> prune(Collection<Area> ars) {
        Set<Area> travelled = new HashSet<>(path);
        ars.removeAll(travelled);
        return ars;
    }

    @Override
    public boolean isValid() {
        int size = path.size();
        Area[] ar = new Area[size];
        if (path.toArray(ar)[size - 1].isHaunted()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        Area[] ar = new Area[path.size()];
        return (path.toArray(ar))[path.size() - 1].getType() == AreaType.EXIT;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(path.toArray());
    }
}
