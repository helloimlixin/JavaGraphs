/**
 * <h1>class Tester</h1>
 * <p>
 *     Tester class to test graph functionality.
 * </p>
 */
public class Tester {
    public static void main(String[] args) {
        Graph G = new Graph();
        GraphTraversal T = new GraphTraversal();
//        G.addNode("Xin Li");
//        G.addNode("Xueying Wang");
//        G.addNode("Ari Trachtenberg");
//        G.addNode("Angel");
//        G.addArc("Xin Li", "Xueying Wang");
//        G.addArc("Xin Li", "Ari Trachtenberg");
//        G.addArc("Xueying Wang", "Xin Li");
//        G.addArc("Ari Trachtenberg", "Xin Li");
//        G.addArc("Xueying Wang", "Angel");
        G.addNode("Bob");
        G.addNode("Alice");
        G.addNode("Mark");
        G.addNode("Rob");
        G.addNode("Maria");
        G.addArc("Bob", "Alice");
        G.addArc("Bob", "Rob");
        G.addArc("Alice", "Mark");
        G.addArc("Rob", "Mark");
        G.addArc("Alice", "Maria");
        G.addArc("Rob", "Maria");

        System.out.println("==============================\nGraph Structure:");
        System.out.println(G.printGraph());
        System.out.println("==============================\nDepth-First Traversal:");
        System.out.println(T.DFS(G, "Bob").toString());
        System.out.println("\n==============================\nBreadth-First Traversal:");
        System.out.println(T.DFS(G, "Bob").toString());
        System.out.println("\n==============================");
    }
}
