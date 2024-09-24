package unit09;

import java.util.Comparator;

public class PokemonComparator implements Comparator<Pokemon>{
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        String p1_name = p1.getName();
        String p2_name = p2.getName();
        return p1_name.toLowerCase().compareTo(p2_name.toLowerCase());
    }
}
