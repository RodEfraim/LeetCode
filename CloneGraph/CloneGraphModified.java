package CloneGraph;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraphModified {

    private static void printNeighbors(List<Node> neighbors){
        int count = 0;
        for(Node node : neighbors){
            count++;
            System.out.println("node #" + count + ": " + node.val);
        }
    }

    public static Node cloneGraph(Node node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        // An HashMap to keep track of all the
        // nodes which have already been created
        HashMap<Node,Node> hm = new HashMap<Node,Node>();

        //Put the node into the HashMap
        hm.put(node,new Node(node.val));

        while (!q.isEmpty())
        {
            // Get the front node from the queue
            // and then visit all its neighbours
            Node u = q.poll();

            // Get corresponding Cloned Graph Node
            Node cloneNodeU = hm.get(u);
            if (u.neighbors != null)
            {
                List<Node> v = u.neighbors;
                for (Node graphNode : v)
                {
                    // Get the corresponding cloned node
                    // If the node is not cloned then we will
                    // simply get a null
                    Node cloneNodeG = hm.get(graphNode);

                    // Check if this node has already been created
                    if (cloneNodeG == null)
                    {
                        q.add(graphNode);

                        // If not then create a new Node and
                        // put into the HashMap
                        cloneNodeG = new Node(graphNode.val);
                        hm.put(graphNode,cloneNodeG);
                    }

                    // add the 'cloneNodeG' to neighbour
                    // vector of the cloneNodeG
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }

        // Return the reference of cloned source Node
        return hm.get(node);
    }


    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // This is the graph structure that the LeetCode #133 problem shows.
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

//        node1.neighbors.add(node2);
//        node1.neighbors.add(node3);
//
//        node3.neighbors.add(node4);
//        node4.neighbors.add(node5);
//
//        //node5.neighbors.add(node2);
//        // If node 5 points to node 3 then it will cause an infinite loop.
//        node5.neighbors.add(node3);

        final long startTime = System.currentTimeMillis();
        System.out.println("CloneGraph: " + cloneGraph(node1));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
