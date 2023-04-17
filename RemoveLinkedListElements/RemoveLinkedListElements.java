package RemoveLinkedListElements;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {

        ListNode newLinkedList = null;//new ListNode();
        ListNode reset = newLinkedList;//null;

        boolean firstEncounter = false;
        while(head != null){
            System.out.println("head: " + head.val);
            if(head.val != val && firstEncounter == false){
                newLinkedList = new ListNode(head.val);
                reset = newLinkedList;
                firstEncounter = true;
            }
            else if(head.val != val){
                newLinkedList.next = new ListNode(head.val);
                newLinkedList = newLinkedList.next;
            }
            head = head.next;
        }

        newLinkedList = reset;
        return newLinkedList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(8);

        ListNode newL = removeElements(l1, 8);

        while(newL != null){
            System.out.println("new HEAD: " + newL.val);
            newL = newL.next;
        }
    }

}
