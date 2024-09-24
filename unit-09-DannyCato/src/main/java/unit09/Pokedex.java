package unit09;

public class Pokedex {
    private NodeBST<Pokemon> binarySearchTree;

    public Pokedex() {
        binarySearchTree = new NodeBST<Pokemon>();
    }

    public boolean containsPokemon(Pokemon poke) {
        return binarySearchTree.search(poke);
    }

    public void addPokemon(Pokemon poke) {
        if (binarySearchTree.getRoot() == null) {
            binarySearchTree.insert(poke);
        }
        if (!containsPokemon(poke)) {
            binarySearchTree.insert(poke);
        }
    }

    public String toString() {
        return binarySearchTree.toString();
    }

    public static void main(String[] args) {
        Pokedex poke = new Pokedex();

        for (int i = 1; i < 16; i++) {
            poke.addPokemon(new Pokemon(10, "" + i));
        }

        poke.addPokemon(new Pokemon(10000, "shidden"));
        System.out.println(poke);
        System.out.println(poke.containsPokemon(new Pokemon(10000, "shidden")));
        
    }
}
