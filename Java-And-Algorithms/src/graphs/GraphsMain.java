package graphs;

import java.util.ArrayList;

public class GraphsMain {
    public static void startGraphs() {
        // Graphs.Graph graph = new Graphs.Graph(true, true);
        var testGraph = new TestGraph();
        Graph graph = testGraph.getGraph();

        Vertex startingVertex = graph.getVertices().get(0);
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        System.out.println("\n" + " DepthFirstTraversal:");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
        visitedVertices.add(0, startingVertex);

        for (Vertex vertex : visitedVertices) {
            System.out.println(vertex.getData());
        }

        ArrayList<Vertex> visitedVertices2 = new ArrayList<>();
        System.out.println("\n" + " BreathFirstTraversal:");
        GraphTraverser.breathFirstTraversal(startingVertex, visitedVertices2);
        visitedVertices2.add(0, startingVertex);
        for (Vertex vertex : visitedVertices2) {
            System.out.println(vertex.getData());
        }
    }
}
