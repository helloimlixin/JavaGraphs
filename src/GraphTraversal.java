import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * <h1>class GraphTraversal</h1>
 * <p>
 *     This is a class that implements a number of graph traversal algorithms.
 * </p>
 */
public class GraphTraversal {
    /**
     * <h2>Set<String> DFS(Graph graph, String root)</h2>
     * <p>
     *     This method implements a <em>Depth-First Traversal</em> over the graph.
     * </p>
     * @param graph graph object to traverse
     * @param root start node of the graph traversal
     * @return a `String` set of traversed nodes
     */
    static Set<String> DFS(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Graph.Node n : graph.getNeighbors(node)) {
                    stack.push(n.label);
                }
            }
        }
        return visited;
    }

    /**
     * <h2>Set<String> BFS(Graph graph, String root)</h2>
     * <p>
     *     This method implements a <em>Breadth-First Traversal</em> over the graph.
     * </p>
     * @param graph graph object to traverse
     * @param root start node of the graph traversal
     * @return a `String` set of traversed nodes
     */
    static Set<String> BFS(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        ((LinkedList<String>) queue).add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (Graph.Node n: graph.getNeighbors(node)) {
                if (!visited.contains(n.label)) {
                    visited.add(n.label);
                    ((LinkedList<String>) queue).add(n.label);
                }
            }
        }

        return visited;
    }
}
