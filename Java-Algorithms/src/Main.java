import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Graph graph = new Graph(true, true);
        var testGraph = new TestGraph();
        Graph graph = testGraph.getGraph();
        // graph.printGraph();

        // System.out.println("Depth First Traversal");
        // System.out.println("");
        //
        //
        // Vertex startingVertex = graph.getVertices().get(0);
        // ArrayList<Vertex> visitedVertices = new ArrayList<>();
        // GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
        // visitedVertices.add(0, startingVertex);
        //
        // System.out.println("");
        // System.out.println("RESULT: Depth First Traversal");
        //
        // for (Vertex vertex : visitedVertices) {
        //     System.out.println(vertex.getData());
        // }

        Vertex startingVertex = graph.getVertices().get(0);
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        System.out.println("\n" + " DepthFirstTraversal:");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
        visitedVertices.add(0, startingVertex);

        for (Vertex vertex : visitedVertices) {
            System.out.println(vertex.getData());
        }

        ArrayList<Vertex>    visitedVertices2 = new ArrayList<>();
        System.out.println("\n" + " BreathFirstTraversal:");
        GraphTraverser.breathFirstTraversal(startingVertex, visitedVertices2);
        visitedVertices2.add(0, startingVertex);
        for (Vertex vertex : visitedVertices2) {
            System.out.println(vertex.getData());
        }
    }


}