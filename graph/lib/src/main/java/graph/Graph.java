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

    public List<Integer> depthFirst(int startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        depthFirstTraversal(startVertex, visited, result);

        return result;
    }

    private void depthFirstTraversal(int currentVertex, Set<Integer> visited, List<Integer> result) {
        visited.add(currentVertex);
        result.add(currentVertex);

        for (Edge edge : adjacencyList.get(currentVertex)) {
            if (!visited.contains(edge.targetVertex)) {
                depthFirstTraversal(edge.targetVertex, visited, result);
            }
        }
    }

    public Integer businessTrip(List<Integer> cities) {
        if (cities == null || cities.size() < 2) {
            throw new IllegalArgumentException("At least two cities are required for a business trip.");
        }

        int totalCost = 0;

        for (int i = 0; i < cities.size() - 1; i++) {
            int currentCity = cities.get(i);
            int nextCity = cities.get(i + 1);

            List<Edge> edges = adjacencyList.get(currentCity);
            boolean directFlightExists = false;

            for (Edge edge : edges) {
                if (edge.targetVertex == nextCity) {
                    directFlightExists = true;
                    totalCost += edge.weight;
                    break;
                }
            }

            if (!directFlightExists) {
                return null;
            }
        }

        return totalCost;
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

    // ... (existing code)
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