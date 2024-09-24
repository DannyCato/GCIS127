package unit10.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E>{
    private Map<E, Vertex<E>> vertices;

    public AdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        vertices.put(value, new Vertex<E>(value));
    }

    public Vertex<E> getVertexFromValue(E value) {
        if (vertices.keySet().contains(value)) {
            return vertices.get(value);
        }
        return null;
    }

    protected Map<E, Vertex<E>> getVertcies() {
        return vertices;
    }

    @Override
    public boolean contains(E value) {
        for (E val : vertices.keySet()) {
            if (val.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> first = vertices.get(a);
        Vertex<E> other = vertices.get(b);
        first.connect(other);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> first = vertices.get(a);
        Vertex<E> other = vertices.get(b);
        first.connect(other);
        other.connect(first);
    }

    @Override
    public boolean connected(E a, E b) {
        return vertices.get(a).connected(vertices.get(b));
    }
    
    @Override
    public List<E> bfSearch(E start, E end) {
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        // make queue
        LinkedList<Vertex<E>> queue = new LinkedList<>();
        queue.add(startVertex);

        // make predecessor map
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();
        predecessors.put(startVertex, null);

        while (!queue.isEmpty()) {
            Vertex<E> V = queue.remove();
            if (!V.equals(endVertex)) {
                for (Vertex<E> N : V.getNeighbors()) {
                    if (!predecessors.keySet().contains(N)) {
                        queue.add(N);
                        predecessors.put(N, V);
                    }
                }
            } else {
                break;
            }

        }
        return makePath(predecessors, endVertex);
    }

    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> end) {
        if (predecessors.containsKey(end)) {
            LinkedList<E> path = new LinkedList<>();
            Vertex<E> current = end;
            while (current != null) {
                path.addFirst(current.getValue());
                current = predecessors.get(current);
            }
            return path;
        }
        return null;
    }

    @Override
    public String toString() {
        String retString = "" + size() + "\n";
        for (E value : vertices.keySet()) {
            retString += value.toString();
            for (Vertex<E> vertex: getVertexFromValue(value).getNeighbors()) {
                retString += " " + vertex.getValue().toString();
            }
            retString += "\n";
        }
        return retString;
    }

    @Override
    public int countConnectedComponents() {
        int answer = 0;
        Set<Vertex<E>> ranThrough = new HashSet<>();
        for (E startVert : vertices.keySet()) {
            if (ranThrough.contains(vertices.get(startVert))) {
                continue;
            
            } else {
                boolean end = false;
                for (Vertex<E> vert : getVertexFromValue(startVert).getNeighbors()) {
                    if (ranThrough.contains(vert)) {
                        ranThrough.addAll(getVertexFromValue(startVert).getNeighbors());
                        ranThrough.add(getVertexFromValue(startVert));
                        end = true;
                        break;
                    }
                }
                if (end) {
                    continue;
                }
                ranThrough.addAll(getVertexFromValue(startVert).getNeighbors());
                ranThrough.add(getVertexFromValue(startVert));
                answer++;
            }
        }
        return answer;
    }

    @Override
    public List<E> dfSearch(E start, E end) {
        Vertex<E> startVertex = vertices.get(start);
        Vertex<E> endVertex = vertices.get(end);

        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(startVertex);

        return visitDFS(startVertex, endVertex, visited);
    }

    private List<E> visitDFS(Vertex<E> V, Vertex<E> E, Set<Vertex<E>> visited) {
        if (V == E) {
            List<E> ret = new LinkedList<>();
            ret.add(E.getValue());
            return ret;
        }
        for (Vertex<E> N : V.getNeighbors()) {
            if (!visited.add(N)) {
                continue;
            }
            LinkedList<E> ret = (LinkedList<E>) visitDFS(N, E, visited);
            if (ret != null) {
                ret.addFirst(V.getValue());
                return ret;
            }
        }
        return null;

    }
}
