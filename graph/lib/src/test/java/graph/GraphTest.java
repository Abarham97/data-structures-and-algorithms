package graph;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void testAddVertex() {
        Graph graph = new Graph();
        int vertex = graph.addVertex(1);
        assertEquals(1, vertex);
    }

    @Test
    void testAddEdge() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);
        int vertex2 = graph.addVertex(2);
        graph.addEdge(vertex1, vertex2, 10);
        List<Graph.Edge> neighbors = graph.getNeighbors(vertex1);
        assertEquals(1, neighbors.size());
        assertEquals(vertex2, neighbors.get(0).targetVertex);
        assertEquals(10, neighbors.get(0).weight);
    }

    @Test
    void testGetVertices() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        Collection<Integer> vertices = graph.getVertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains(1));
        assertTrue(vertices.contains(2));
    }

    @Test
    void testGetNeighbors() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);
        int vertex2 = graph.addVertex(2);
        graph.addEdge(vertex1, vertex2, 10);
        List<Graph.Edge> neighbors = graph.getNeighbors(vertex1);
        assertEquals(1, neighbors.size());
        assertEquals(vertex2, neighbors.get(0).targetVertex);
        assertEquals(10, neighbors.get(0).weight);
    }

    @Test
    void testSize() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        assertEquals(2, graph.size());
    }

    @Test
    void testGraphWithSingleVertexAndEdge() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);

        assertThrows(SelfLoopException.class, () -> graph.addEdge(vertex1, vertex1, 5));
    }

    @Test
    void testSelfLoopException() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);

        assertThrows(SelfLoopException.class, () -> graph.addEdge(vertex1, vertex1, 5));
    }

    @Test
    void testBreadthFirstTraversal() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);
        int vertex2 = graph.addVertex(2);
        int vertex3 = graph.addVertex(3);
        int vertex4 = graph.addVertex(4);
        int vertex5 = graph.addVertex(5);

        graph.addEdge(vertex1, vertex2, 10);
        graph.addEdge(vertex1, vertex3, 15);
        graph.addEdge(vertex2, vertex4, 20);
        graph.addEdge(vertex3, vertex5, 25);

        List<Integer> bfsResult = graph.breadthFirst(vertex1);
        assertEquals(List.of(1, 2, 3, 4, 5), bfsResult);
    }


    @Test
    void testBusinessTripWithSingleCity() {
        Graph graph = new Graph();
        int vertex1 = graph.addVertex(1);

        List<Integer> cities = List.of(vertex1);

        assertThrows(IllegalArgumentException.class, () -> graph.businessTrip(cities));
    }
}
