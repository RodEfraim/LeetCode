package IntersectionOfTwoLinkedLists;

import java.util.Stack;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at
 * which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 */
public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // The trick would be to place each linked list into their own stack. Then we would pop both stacks
        // at the same time until we find nodes that are distinct from each other.

        Stack<ListNode> nodeStackA = new Stack<ListNode>();
        Stack<ListNode> nodeStackB = new Stack<ListNode>();

        while(headA !=  null){
            System.out.println("headA: " +  headA.val);
            nodeStackA.push(headA);
            headA = headA.next;
        }

        while(headB !=  null){
            System.out.println("headB: " + headB.val);
            nodeStackB.push(headB);
            headB = headB.next;
        }

        ListNode save = null;
        while(!nodeStackA.empty()){
            ListNode a = nodeStackA.pop();
            ListNode b = nodeStackB.pop();

            System.out.println("headA stack ( " + a.val + ")  VS  headB stack(" + b.val + ")");
            System.out.println("headA stack ( " + a + ")  VS  headB stack(" + b + ")");

            if(a != b && nodeStackA.empty() && nodeStackB.empty())
                return null;
            if(a == b && (nodeStackA.empty() || nodeStackB.empty()))
                return a;
            if(a != b)
                return save;

            save = a;
        }

        return null;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(1);
        l2.next.next.next = l1.next.next;
        l2.next.next.next.next = l1.next.next.next;
        l2.next.next.next.next.next = l1.next.next.next.next;

        System.out.println("intersection: " + getIntersectionNode(l1, l2).val);
    }
}
