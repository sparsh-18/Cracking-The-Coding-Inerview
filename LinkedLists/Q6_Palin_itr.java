import java.util.Stack;

public class Q6_Palin_itr {
    public static void main(String[] args) {
        LinkList ob = new LinkList();
        ob.insert_end(1);
        ob.insert_end(2);
        ob.insert_end(0);
        ob.insert_end(2);
        ob.insert_end(1);

        boolean res = (new Q6_Palin_itr()).isPalin(ob.head);
        System.out.println("Palin: "+res);
    }

    private boolean isPalin(Node head) {
        Node fast = head, slow=head;

        Stack<Integer> st = new Stack<Integer>();

        while(fast!=null && fast.next !=null) {
            fast = fast.next.next;
            st.push(slow.num);
            slow=slow.next;
        }
        if(fast!=null && fast.next==null) slow = slow.next;

        while(slow != null) {
            if(slow.num != st.pop()) return false;
            slow=slow.next;
        }
        return true;
    }
}
