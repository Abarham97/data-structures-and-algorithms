package graph;

import java.util.*;

public class Graph {
    private final Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public class Edge {
        int targetVertex;
        int weight;

        public Edge(int targetVertex, int weight) {
            this.targetVertex = targetVertex;
            this.weight = weight;
        }
    }

    public int addVertex(int value) {
        if (adjacencyList.containsKey(value)) {
            throw new DuplicateVertexException("Vertex already exists in the graph.");
        }
        adjacencyList.put(value, new ArrayList<>());
        return value;
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        validateVerticesExist(vertex1, vertex2);
        validateNoSelfLoop(vertex1, vertex2);

        List<Edge> edges1 = adjacencyList.get(vertex1);
        List<Edge> edges2 = adjacencyList.get(vertex2);

        if (edges1.stream().noneMatch(edge -> edge.targetVertex == vertex2)) {
            edges1.add(new Edge(vertex2, weight));
            edges2.add(new Edge(vertex1, weight));
        }
    }

    public Collection<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    public List<Edge> getNeighbors(int vertex) {
        validateVertexExists(vertex);
        return adjacencyList.get(vertex);
    }

    public int size() {
        return adjacencyList.size();
    }

    public List<Integer> breadthFirst(int startVertex) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            result.add(currentVertex);

            for (Edge edge : adjacencyList.get(currentVertex)) {
                if (!visited.contains(edge.targetVertex)) {
                    queue.add(edge.targetVertex);
                    visited.add(edge.targetVertex);
                }
            }
        }

        return result;
    }

    private void validateVerticesExist(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            throw new IllegalArgumentException("Both vertices should already be in the graph.");
        }
    }

    private void validateVertexExists(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new VertexNotFoundException("Vertex not found in the graph.");
        }
    }

    private void validateNoSelfLoop(int vertex1, int vertex2) {
        if (vertex1 == vertex2) {
            throw new SelfLoopException("Self-loops are not allowed in the graph.");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        int vertex1 = graph.addVertex(1);
        int vertex2 = graph.addVertex(2);
        int vertex3 = graph.addVertex(3);
        int vertex4 = graph.addVertex(4);

        graph.addEdge(vertex1, vertex2, 10);
        graph.addEdge(vertex1, vertex3, 15);
        graph.addEdge(vertex2, vertex4, 20);

        System.out.println("Vertices: " + graph.getVertices());
        System.out.println("Neighbors of vertex 1: " + graph.getNeighbors(vertex1));

        List<Integer> bfsResult = graph.breadthFirst(vertex1);
        System.out.println("Breadth-First Traversal: " + bfsResult);
        System.out.println("Graph Size: " + graph.size());
    }
}

class DuplicateVertexException extends RuntimeException {
    public DuplicateVertexException(String message) {
        super(message);
    }
}

class VertexNotFoundException extends RuntimeException {
    public VertexNotFoundException(String message) {
        super(message);
    }
}

class SelfLoopException extends RuntimeException {
    public SelfLoopException(String message) {
        super(message);
    }
}
