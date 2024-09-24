package unit09;

public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value) {
        this.value = value;
    }

    public String infixTraversal() {
        String empty = "";
        if (left != null) {
            empty += left.infixTraversal();
        }
        empty += "" + value + " ";
        if (right != null) {
            empty += right.infixTraversal();
        }
        return empty;
    }

    public boolean search(E target) {
        if (value.equals(target)) {
            return true;
        }
        if (left != null && target.toString().compareTo(this.getValue().toString()) < 0) {
            if (left.search(target)) {
                return true;
            }
        }
        if (right != null && target.toString().compareTo(this.getValue().toString()) > 0) {
            if (right.search(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + value + ", left=" + left + ", right=" + right + "}";
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }

    public static void main(String[] args) {
        // make tree on slide 9.1
        BinaryNode<Integer> val2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> val3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> val7 = new BinaryNode<Integer>(7);
        val2.setLeft(val3);
        val2.setRight(val7);

        // subtree of 3
        BinaryNode<Integer> val9 = new BinaryNode<Integer>(9);
        BinaryNode<Integer> val4 = new BinaryNode<Integer>(4);
        val3.setLeft(val9);
        val3.setRight(val4);

        // subtree of 7
        BinaryNode<Integer> val1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> val6 = new BinaryNode<Integer>(6);
        val7.setLeft(val1);
        val7.setRight(val6);

        System.out.println(val2.toString());
        System.out.println(val2.infixTraversal());

        System.out.println(val2.search(7));
        System.out.println(val2.search(4));
        System.out.println(val2.search(10));
    } 

    
}
