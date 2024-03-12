class TestGraph {
    private Graph testGraph;

    public TestGraph() {
        this.testGraph = new Graph(false, true);
        Vertex startNode = testGraph.addVertex("v0.0.0");
        Vertex v100 = this.testGraph.addVertex("v1.0.0");
        Vertex v200 = this.testGraph.addVertex("v2.0.0");

        Vertex v110 = this.testGraph.addVertex("v1.1.0");
        Vertex v120 = this.testGraph.addVertex("v1.2.0");
        Vertex v210 = this.testGraph.addVertex("v2.1.0");

        Vertex v111 = this.testGraph.addVertex("v1.1.1");
        Vertex v112 = this.testGraph.addVertex("v1.1.2");
        Vertex v121 = this.testGraph.addVertex("v1.2.1");
        Vertex v211 = this.testGraph.addVertex("v2.1.1");

        this.testGraph.addEdge(startNode, v100, null);
        this.testGraph.addEdge(startNode, v200, null);

        this.testGraph.addEdge(v100, v110, null);
        this.testGraph.addEdge(v100, v120, null);
        this.testGraph.addEdge(v200, v210, null);

        this.testGraph.addEdge(v110, v111, null);
        this.testGraph.addEdge(v110, v112, null);
        this.testGraph.addEdge(v120, v121, null);
        this.testGraph.addEdge(v210, v211, null);

        // create a cycle
        this.testGraph.addEdge(v211, v200, null);
    }

    public Vertex getStartingVertex() {
        return this.testGraph.getVertices().get(0);
    }

    public Graph getGraph() {
        return testGraph;
    }
}