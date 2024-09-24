package unit10.weighted;

import java.util.HashMap;
import java.util.Map;

public class WAdjacencyGraph<E> implements WGraph<E> {
    private final Map<E, WVertex<E>> vertices;
    
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }

    @SuppressWarnings("all")
    @Override
    public WPath<E> dijkstrasPath(E start, E end) {
        WVertex<E> startVertex = vertices.get(start);
        WVertex<E> endVertex = vertices.get(end);

        Map<WVertex<E>, PathTuple<E>> map = new HashMap<>();
        TupleQueue<E> tupleQueue = new TupleQueue<>();
        for (WVertex<E> vert : vertices.values()) {
            PathTuple<E> pt = new PathTuple<>(vert);
            map.put(vert, pt);
            tupleQueue.enqueue(pt);
        }
        map.get(startVertex).update(null, 0);
        

        return null;
    }
}
