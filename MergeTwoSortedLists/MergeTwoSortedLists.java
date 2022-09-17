package MergeTwoSortedLists;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode head = null;
        ListNode tail = null;
        ListNode answer = null;

        boolean curr1Greater = true;

        while(curr1.next != null && curr2.next != null){

            if(answer == null){
                if(curr1.val >= curr2.val) {
                    answer = new ListNode(curr2.val, null);
                    curr2 = curr2.next;
                }
                else if(curr1.val < curr2.val) {
                    answer = new ListNode(curr1.val, null);
                    curr1 = curr1.next;
                }
            }
            else{

                if(curr1.val > curr2.val){
                    curr1Greater = true;
                }
                else if(curr1.val < curr2.val){
                    curr1Greater = false;
                }

                if(answer.val <= curr2.val && curr1Greater){
                    answer = new ListNode(curr2.val, null);
                    curr2 = curr2.next;
                }
                else if(answer.val <= curr1.val && !curr1Greater){
                    answer = new ListNode(curr1.val, null);
                    curr1 = curr1.next;
                }
            }

            //tail = helper(head, tail, answer);
            if(head == null){
                head = answer;
                tail = answer;
            }
            else
            {
                tail.next = answer;
                tail = answer;
            }
        }

        if(curr1.next == null){
            while(curr2.next != null){
                answer = new ListNode(curr2.val, null);
                curr2 = curr2.next;
                if(head == null){
                    head = answer;
                    tail = answer;
                }
                else
                {
                    tail.next = answer;
                    tail = answer;
                }
            }
        }
        else if(curr2.next == null){

            while(curr1.next != null){
                answer = new ListNode(curr1.val, null);
                curr1 = curr1.next;
                if(head == null){
                    head = answer;
                    tail = answer;
                }
                else
                {
                    tail.next = answer;
                    tail = answer;
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {

////        ListNode l1 = new ListNode(1, new ListNode());
////        l1.next = new ListNode(3, new ListNode());
////        l1.next.next = new ListNode(12, new ListNode());
//
//        ListNode l1 = new ListNode(1, new ListNode());
//        l1.next = new ListNode(2, new ListNode());
//        l1.next.next = new ListNode(4, new ListNode());
//
//        System.out.println("l1: " + l1);
//        System.out.println(l1.val);
//        System.out.println(l1.next.val);
//        System.out.println(l1.next.next.val);
//
////        ListNode l2 = new ListNode(5, new ListNode());
////        l2.next = new ListNode(10, new ListNode());
////        l2.next.next = new ListNode(15, new ListNode());
//
//        ListNode l2 = new ListNode(1, new ListNode());
//        l2.next = new ListNode(3, new ListNode());
//        l2.next.next = new ListNode(4, new ListNode());
//
//        System.out.println("l2: " + l2);
//        System.out.println(l2.val);
//        System.out.println(l2.next.val);
//        System.out.println(l2.next.next.val);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//        ListNode answer = mergeTwoSortedLists(l1, l2);
//        System.out.println("answer: " + answer);
//        System.out.println(answer.val);
//        System.out.println(answer.next.val);
//        System.out.println(answer.next.next.val);
//        System.out.println(answer.next.next.next.val);
//        System.out.println(answer.next.next.next.next.val);
//        System.out.println(answer.next.next.next.next.next.val);

        ListNode l1 = new ListNode(-9, new ListNode());
        l1.next = new ListNode(3, new ListNode());

        System.out.println("l1: " + l1);
        System.out.println(l1.val);
        System.out.println(l1.next.val);

        ListNode l2 = new ListNode(5, new ListNode());
        l2.next = new ListNode(7, new ListNode());

        System.out.println("l2: " + l2);
        System.out.println(l2.val);
        System.out.println(l2.next.val);

        ListNode answer = mergeTwoSortedLists(l1, l2);
        System.out.println("answer: " + answer);
        System.out.println(answer.val);
        System.out.println(answer.next.val);
        System.out.println(answer.next.next.val);
        System.out.println(answer.next.next.next.val);
    }
}
