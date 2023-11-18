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
}

