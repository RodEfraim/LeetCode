package CloneGraph;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    private static void printNeighbors(List<Node> neighbors){
        int count = 0;
        for(Node node : neighbors){
            count++;
            System.out.println("node #" + count + ": " + node.val);
        }
    }

    public static Node cloneGraph(Node node) {

        //Queue<Node> queue = new PriorityQueue<Node>();
        Queue<Node> queue = new ArrayDeque<Node>();
        Map<Node, Node> hashMap = new HashMap<Node, Node>();

        ArrayList<Node> listOfNodes = new ArrayList<Node>();

        System.out.println("Adding first node to the queue.");
        queue.add(node);

        //Put the node into the HashMap
        hashMap.put(node,new Node(node.val));

        //System.out.println(node.val);
        System.out.println("queue.peek().val: " + queue.peek().val);

        while(!queue.isEmpty()){

            Node currentNode = queue.remove();
            //Node nodeCopy = new Node (currentNode.val, new ArrayList<Node>(currentNode.neighbors));

            System.out.println("currentNode.val: " + currentNode.val);
            printNeighbors(currentNode.neighbors);

            Node cloneNodeU = hashMap.get(currentNode);

            // TODO: Based on the hashmap that will be used to track whether nodes have already been visited.
            // queue.add by individual nodes instead of queue.addAll. If the node is repeated then add that
            // node as part of the current node's neighbor, but make sure you do not add it onto the queue.

            if(currentNode != null){

                List<Node> currentNodeNeighbors = currentNode.neighbors;

                for(Node neighbor : currentNodeNeighbors){
                    Node cloneNodeG = hashMap.get(neighbor);
                    if(cloneNodeG == null){
                        queue.add(neighbor);
                        cloneNodeG = new Node(neighbor.val);
                        hashMap.put(neighbor, cloneNodeG);
                    }
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }

//            if(hashMap.containsKey(currentNode)){
//                System.out.println("This node has already been repeated...");
//            }else{
//                hashMap.put(currentNode, currentNode);
//                Node nodeCopy = new Node (currentNode.val, new ArrayList<Node>(currentNode.neighbors));
//                listOfNodes.add(nodeCopy);
//                queue.addAll(currentNode.neighbors);
//            }
        }

        System.out.println("~~~~~ print out the arraylist ~~~~~ ");
        return hashMap.get(node);
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
