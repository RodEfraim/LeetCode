package MergeTwoSortedLists;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedListsClean {
    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {

        ListNode head = null;//new ListNode();//null;
        ListNode tail = null;//new ListNode();//null;
        ListNode answer = null;//new ListNode(null, null);
        boolean curr1Greater = true;

        while(list1.next != null && list2.next != null){

//            System.out.println("curr1: " + curr1.val);
//            System.out.println("curr1: " + curr1);
//            System.out.println("curr2: " + curr2.val);
//            System.out.println("curr2: " + curr2);

            if(answer == null){
                if(list1.val >= list2.val) {
                    answer = new ListNode(list2.val, null);
                    list2 = list2.next;
                }
                else if(list1.val < list2.val) {
                    answer = new ListNode(list1.val, null);
                    list1 = list1.next;
                }
                head = helper(head, tail, answer);
                tail = head;
            }
            else{

                if(list1.val > list2.val){
                    curr1Greater = true;
                }
                else if(list1.val < list2.val){
                    curr1Greater = false;
                }

                if(answer.val <= list2.val && curr1Greater){
                    answer = new ListNode(list2.val, null);
                    list2 = list2.next;
                }
                else if(answer.val <= list1.val && !curr1Greater){
                    answer = new ListNode(list1.val, null);
                    list1 = list1.next;
                }
                tail = helper(head, tail, answer);
            }

//            System.out.println("answer: " + answer);
//            System.out.println("answer: " + answer.val);
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if(list1.next == null){
            while(list2.next != null){
                answer = new ListNode(list2.val, null);
                list2 = list2.next;
                tail = helper(head, tail, answer);
            }
        }
        else if(list2.next == null){

            while(list1.next != null){
                answer = new ListNode(list1.val, null);
                list1 = list1.next;
                tail = helper(head, tail, answer);
            }
        }

        return head;
    }

    public static ListNode helper(ListNode head, ListNode tail, ListNode answer){

        if(head == null){
            head = answer;
            tail = answer;
        }
        else
        {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = answer;
            //newNode will become new tail of the list
            tail = answer;
        }
        return tail;
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
