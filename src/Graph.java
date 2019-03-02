import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>class DiGraph</h1>
 *
 * <p>
 *     Define a directed graph using <em>Adjacency List Representation</em>.
 * </p>
 *
 */
public class Graph {
    private Map<Node, List<Node>> adjacentNodes;

    /**
     * <h2>Class constructor.</h2>
     */
    Graph() {
        this.adjacentNodes = new HashMap<Node, List<Node>>();
    }

    /**
     * <h2>void addNode(String label)</h2>
     * <p>
     *     This method adds nodes to the graph with given label when the node is absent.
     * </p>
     * @param label label attached to the node to be added
     */
    void addNode(String label) {
        adjacentNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    /**
     * <h2>void removeNode(String label)</h2>
     * <p>
     *     This method removes a node from the graph with given label.
     * </p>
     * @param label label attached to the node to be removed
     */
    void removeNode(String label) {
        Node n = new Node(label);
        adjacentNodes.values().stream().map(e -> e.remove(n)).collect(Collectors.toList());
        adjacentNodes.remove(new Node(label));
    }

    /**
     * <h2>void addArc(String label1, String label2)</h2>
     * <p>
     *     This method adds a directed arc to the graph with given start node and end node label.
     * </p>
     * @param label1 start node label
     * @param label2 end node label
     */
    void addArc(String label1, String label2) {
        Node n1 = new Node(label1);
        Node n2 = new Node(label2);
        adjacentNodes.get(n1).add(n2);
    }

    /**
     * <h2>void removeArc(String label1, String label2)</h2>
     * <p>
     *     This method removes a directed arc from the graph with given start node and end node labels.
     * </p>
     * @param label1 start node label
     * @param label2 end node label
     */
    void removeArc(String label1, String label2) {
        Node n1 = new Node(label1);
        Node n2 = new Node(label2);
        List<Node> n1Neighbors = adjacentNodes.get(n1);
        if (n1Neighbors != null)
            n1Neighbors.remove(n2);
    }

    /**
     * <h2>List<Node> getNeighbors(String label)</h2>
     * <p>
     *     This method can get the neighbor nodes of a particular node.
     * </p>
     * @param label query node label
     * @return a list of neighbor nodes of given node
     */
    List<Node> getNeighbors(String label) {
        return adjacentNodes.get(new Node(label));
    }

    String printGraph() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Node n1: adjacentNodes.keySet()) {
            if (!adjacentNodes.get(n1).isEmpty()){
                for (Node n2: adjacentNodes.get(n1)) {
                    if (!adjacentNodes.get(n2).contains(n1)) {
                        stringBuffer.append(n1);
                        stringBuffer.append("->");
                        stringBuffer.append(n2);
                        stringBuffer.append("\n");
                    } else if (adjacentNodes.get(n2).contains(n1)) {
                        if (stringBuffer.indexOf(n2+"<->"+n1) == -1) {
                            stringBuffer.append(n1);
                            stringBuffer.append("<->");
                            stringBuffer.append(n2);
                            stringBuffer.append("\n");
                        }
                    }
                }
            }
        }

        return stringBuffer.toString();
    }

    /**
     * <h2>class Node</h2>
     * <p>A simple node class identified by a String label.</p>
     */
    class Node {
        String label;

        Node(String label) {
            this.label = label;
        }
        @Override
        public boolean equals(Object object) {
            Node node = (Node) object;
            return node.label == label;
        }
        @Override
        public int hashCode() {
            return label.hashCode();
        }
        @Override
        public String toString() {
            return label;
        }
    }
}