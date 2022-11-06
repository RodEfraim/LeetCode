package ReverseLinkedList;
import java.util.Stack;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        if(head == null)
            return null;

        ListNode tracker = head;
        Stack<Integer> nodeStack = new Stack<Integer>();

        while(true){

            // If tracker is equal to null this means you have reached the end of the linked list.
            if(tracker == null)
                break;
            else
                System.out.println("tracker.val: " + tracker.val);

            nodeStack.add(tracker.val);
            tracker = tracker.next;
        }

        ListNode returnListNode = new ListNode(nodeStack.pop());
        tracker = returnListNode;

        while(!nodeStack.empty()){
            returnListNode.next = new ListNode(nodeStack.pop(), returnListNode.next);
            returnListNode = returnListNode.next;
        }

        return tracker;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);

        final long startTime = System.currentTimeMillis();
        ListNode reversal = reverseList(l1);
        System.out.println(reversal.val);
        System.out.println(reversal.next.val);
        System.out.println(reversal.next.next.val);
        System.out.println(reversal.next.next.next.val);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
