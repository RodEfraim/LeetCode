package AddTwoNumbers;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int currVal = 0;
        int carryOn = 0;
        int stay = 0;
        ListNode head = null;
        ListNode tail = null;
        boolean curr1NextNotNull = true;
        boolean curr2NextNotNull = true;
        ListNode answer = new ListNode(stay, null);

        while(curr1 != null && curr2 != null){

            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            //System.out.println("curr1: " + curr1.val);
            //System.out.println("curr2: " + curr2.val);
            currVal = curr1.val + curr2.val + carryOn;
            //System.out.println("currVal: " + currVal);

            if(currVal > 9){
                carryOn = currVal / 10;
                stay = currVal % 10;
            }
            else{
                stay = currVal;
                carryOn = 0;
            }

            //System.out.println("carryOn: " + carryOn);
            //System.out.println("stay: " + stay);

            answer = new ListNode(stay, null);

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

            //System.out.println("answer: " + answer.val);

            curr1 = curr1.next;
            curr2 = curr2.next;

            if(curr1 == null){
                //System.out.println("CURR1.NEXT IS NULL");
                curr1NextNotNull = false;
            }
            if(curr2 == null){
                //System.out.println("CURR2.NEXT IS NULL");
                curr2NextNotNull = false;
            }
        }

        //System.out.println("curr1NextNotNull: " + curr1NextNotNull);
        //System.out.println("curr2NextNotNull: " + curr2NextNotNull);

        if(curr1NextNotNull){
            while(curr1 != null)
            {
                //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //System.out.println("curr1: " + curr1.val);
                //System.out.println("carryOn: " + carryOn);
                currVal = curr1.val + carryOn;
                //System.out.println("currVal: " + currVal);

                if(currVal > 9){
                    System.out.println("SHALOM!");
                    carryOn = currVal / 10;
                    stay = currVal % 10;
                }
                else{
                    stay = currVal;
                    carryOn = 0;
                }

                //System.out.println("carryOn: " + carryOn);
                //System.out.println("stay: " + stay);

                answer = new ListNode(stay, null);

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

                //System.out.println("answer: " + answer.val);
                curr1 = curr1.next;
            }
        }

        if(curr2NextNotNull){
            while(curr2 != null)
            {
                //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //System.out.println("curr2: " + curr2.val);
                //System.out.println("carryOn: " + carryOn);
                currVal = curr2.val + carryOn;
                //System.out.println("currVal: " + currVal);

                if(currVal > 9){
                    carryOn = currVal / 10;
                    stay = currVal % 10;
                }
                else{
                    stay = currVal;
                    carryOn = 0;
                }

                //System.out.println("carryOn: " + carryOn);
                //System.out.println("stay: " + stay);

                answer = new ListNode(stay, null);

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

                //System.out.println("answer: " + answer.val);
                curr2 = curr2.next;
            }
        }

        if(carryOn != 0){
            currVal = carryOn;
            stay = currVal;
            answer = new ListNode(stay, null);
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
        }

        return head;
    }

    public static void main(String[] args) {

        //ListNode l1
        //ListNode l2
        ListNode l1 = new ListNode(2, new ListNode());
        l1.next = new ListNode(4, new ListNode());
        l1.next.next = new ListNode(3, new ListNode());

        System.out.println("l1: " + l1);
        System.out.println(l1.val);
        System.out.println(l1.next.val);
        System.out.println(l1.next.next.val);

        ListNode l2 = new ListNode(5, new ListNode());
        l2.next = new ListNode(6, new ListNode());
        l2.next.next = new ListNode(4, new ListNode());

        System.out.println("l2: " + l2);
        System.out.println(l2.val);
        System.out.println(l2.next.val);
        System.out.println(l2.next.next.val);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        final long startTime = System.currentTimeMillis();
        ListNode lsum = addTwoNumbers(l1, l2);
        System.out.println(lsum.val);
        System.out.println(lsum.next.val);
        System.out.println(lsum.next.next.val);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
