package unit09;

public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E>{
    private BinaryNode<E> root;
    private int size;

    public NodeBST() {
        root = null;

    }

    @Override
    public void insert(E value) {
        if (root == null) {
            root = new BinaryNode<E>(value);
        } else {
            binaryInsert(root, value);
        }
        size++;
    } 

    private void binaryInsert(BinaryNode<E> node, E value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<E>(value));
            } else {
                binaryInsert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryNode<E>(value));
            } else {
                binaryInsert(node.getRight(), value); 
            }
        }
    }

    public BinaryNode<E> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean search(E target) {
        return root.search(target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return (root != null) ? root.infixTraversal() : "<empty>";
    }

    public static void main(String[] args) {
        NodeBST<Integer> nodeTree = new NodeBST<Integer>();
        System.out.println(nodeTree);
    }
}
