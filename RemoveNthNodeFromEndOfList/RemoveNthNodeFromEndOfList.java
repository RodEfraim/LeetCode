package RemoveNthNodeFromEndOfList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * Removes the Nth node away from the last node of the linked list.
     * @param head: First node from the linked list.
     * @param n: The nth node from the end of the list
     * @return First node from the modified linked list.
     */
    public static ListNode removeNthNode(ListNode head, int n){

        ListNode beginning = head;
        // Grabs the length of the linked list by reaching the end of the loop.
        int linkedListLength = getLinkedListLength(head);
        int targetIndex = linkedListLength - n;

        if(linkedListLength == 1 && n == 1)
            return null;
        if(targetIndex == 0)
            return head.next;

        int i = 0;
        while(head != null){
            if(i == (targetIndex - 1)){
                ListNode upnext = head.next.next;
                head.next = upnext;
            }
            else
                head = head.next;
            i++;
        }

        head = beginning;
        return head;
    }

    /**
     * Gets the length of singly-linked list by iterating through the entire list until it reaches null.
     * @param head: First node from the linked list.
     * @return The length of the linked list.
     */
    public static int getLinkedListLength(ListNode head){
        int size = 0;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
            size++;
        }
        System.out.println("~~~~~~~~~~~~");
        return size;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        final long startTime = System.currentTimeMillis();
        ListNode modifiedLinkedList = removeNthNode(l1, 2);
        System.out.println("*******");
        System.out.println("Length of Linked List: " + getLinkedListLength(modifiedLinkedList));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
