

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphTraverser {

    /* depth first traversal:
        It recursively explores each vertex in the graph, traversing as far as possible along each branch before backtracking.     */
    public static void depthFirstTraversal(Vertex startVertex, ArrayList<Vertex> visitedVertices) {
        for (Edge edge : startVertex.getEdges()) {
            Vertex endVertex = edge.getEnd();

            if (!visitedVertices.contains(endVertex)) {
                visitedVertices.add(endVertex);
                GraphTraverser.depthFirstTraversal(endVertex, visitedVertices);
            }
        }
    }

    /*
    BreathFirstTraversal
     */
    public static void breathFirstTraversal(Vertex startVertex, ArrayList<Vertex> visitedVertices) {
        Queue<Vertex> visitQueue = new ArrayDeque<>();
        visitQueue.add(startVertex);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.remove();   // Removes head

            for (Edge edge : current.getEdges()) {
                Vertex endVertex = edge.getEnd();
                if (!visitedVertices.contains(endVertex)) {
                    visitedVertices.add(endVertex);
                    visitQueue.add(endVertex);
                }

            }

        }

    }

}
