import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;

    private boolean isWeighted;

    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;

        vertices = new ArrayList<>();
        // Vertex amsterdam = addVertex("Amsterdam");
        // Vertex utrecht = addVertex("Utrecht");
        // Vertex groningen = addVertex("Groningen");
        //
        // addEdge(amsterdam, utrecht, 250);
        // addEdge(utrecht, groningen, 500);

        // for (int i = 0; i < vertices.size(); i++) {
        //     if (i < vertices.size() - 1) {
        //         addEdge(vertices.get(i), vertices.get(i + 1), 10);
        //     }

        // }

    }

    public void addEdge(Vertex startVertex, Vertex endVertex, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }

        startVertex.addEdge(endVertex, weight);

        if (!isDirected) {
            endVertex.addEdge(startVertex, weight);
        }
    }

    public void removeEdge(Vertex startVertex, Vertex endVertex) {
        startVertex.removeEdge(endVertex);

        if (!isDirected) {
            endVertex.removeEdge(startVertex);
        }
    }


    public Vertex addVertex(String data) {
        Vertex vertex = new Vertex(data);
        vertices.add(vertex);
        return vertex;
    }

    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }

    public Vertex getVertexByValue(String value) {
        return vertices.stream().filter(vertex -> vertex.getData().equals(value)).findAny().orElse(null);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }


    public void printGraph() {
        vertices.forEach(vertex -> vertex.print(isWeighted));
    }

}

// A Graph lists all vertices

// directed graphs: Peter only likes Cody, cody only likes Jordan etc

// weighted graphs: weights on the edges, so for example peter -> Cody with a value of 10, Cody -> Joran with value of 5 etc.

