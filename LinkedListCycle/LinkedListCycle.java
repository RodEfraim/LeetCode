package LinkedListCycle;

import java.util.HashMap;
import java.util.Map;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be
 * reached again by continuously following the next pointer. Internally, pos is used to
 * denote the index of the node that tail's next pointer is connected to. Note that pos is
 * not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        // Use a hash map to keep track if the node has been visited already.
        Map<ListNode, Boolean> nodeMap = new HashMap<>();
        boolean hasCycle = false;
        ListNode tracker = head;

        while(true){

            // If tracker is equal to null this means you have reached the end of the linked list.
            if(tracker == null)
                break;
            else
                System.out.println("tracker.val: " + tracker.val);

            if(nodeMap.containsKey(tracker))
            {
                System.out.println("Identified a loop on linked list.");
                hasCycle = true;
                break;
            }else
                nodeMap.put(tracker, false);

            tracker = tracker.next;
        }

        return hasCycle;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        // This will make the LinkedList have a cycle.
        l1.next.next.next.next = l1.next;

        final long startTime = System.currentTimeMillis();
        System.out.println( hasCycle(l1));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
