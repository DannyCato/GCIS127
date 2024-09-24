package unit08.mcf;

public class NodeQueue<E> implements Queue<E> {
    private Node front;
    private Node back;
    private int size;
    
    public NodeQueue(Node front) {
        this.front = front;
        Node end = front;
        int count = 1; 
        while (end.getNext() != null) {
            end = end.getNext();
            count++;
        }
        this.back = end;
        this.size = count;
    }

    public void enqueue(E value) {
        Node nue = new Node("" + value.toString());
        if (front == null) {
            front = nue;
        }
        if (back != null) {
            back.setNext(nue);
        }
        
        back = nue;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        Node target = front;
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        return (E) target.getValue();  
    }

    @Override
    public String toString() {
        boolean begin = true;
        String answer = "";
        Node currentNode = front;
        while (currentNode != null) {
            if (!begin) {
                answer += " -> ";
            }
            begin = false;

            answer += currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        // System.out.print("" + size + ", " + answer + " -> null");

        return "" + size + ", " + answer + " -> null";
    }

    public int size() {
        return size;
    }
}
