package unit08.mcf;

public class NodeStack implements Stack{
    private Node firstNode;
    private Node top;
    private int size;

    public NodeStack(String n) {
        Node node = new Node(n);
        this.firstNode = node;
        this.top = node;
        int size = 1;
        while (top.getNext() != null) {
            top = top.getNext();
            size++;
        }        
        this.size = size;
    }

    public NodeStack(Node node) {
        this.firstNode = node;
        this.top = node;
        int size = 1;
        while (top.getNext() != null) {
            top = top.getNext();
            size++;
        }        
        this.size = size;
    }

    public void push(String value) {
        Node newNode = new Node(value);
        top.setNext(newNode);
        top = newNode;
        size++;
    }

    public String pop() {
        size = 1;
        String temp = top.getValue();
        top = firstNode;
        while (top.getNext().getNext() != null) {
            top = top.getNext();
            size++;
        }
        top.setNext(null);;
        
        return temp;
    }

    public String top() {
        return top.getValue();
    }

    @Override
    public String toString() {
        boolean begin = true;
        String answer = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (!begin) {
                answer += " -> ";
            }
            begin = false;

            answer += currentNode.getValue();
            currentNode = currentNode.getNext();
        }      

        return "" + size + ", " + answer + " -> null";
    }

    public int size() {
        return size;
    }
}
