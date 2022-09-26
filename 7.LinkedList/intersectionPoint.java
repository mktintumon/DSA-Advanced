public class intersectionPoint {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // DUPLICATE ALLOWED
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while (curr1 != curr2) {
            curr1 = (curr1 == null) ? headB : curr1.next;
            curr2 = (curr2 == null) ? headA : curr2.next;
        }

        return curr1;
    }
}

/*

public static int findIntersection(LinkedList one, LinkedList two){
    Node c1 = one.head;
    Node c2 = two.head;

    int diff = Math.abs(one.size - two.size);

    if(one.size > two.size){
       for(int i=0 ; i<diff ; i++){
          c1 = c1.next;
       }
    }
     else{
       for(int i=0 ; i<diff ; i++){
          c2 = c2.next;
     }  
    }

    while(c1!=c2){
      c1 = c1.next;
      c2 = c2.next;
    }

    return c1.data;
 }



*/
