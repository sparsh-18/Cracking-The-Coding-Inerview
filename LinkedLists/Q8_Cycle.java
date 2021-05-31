public class Q8_Cycle {
    public static void main(String[] args) {
        LinkList ob = new LinkList();

        ob.insert_end(1);
        ob.insert_end(2);
        ob.insert_end(3);
        ob.insert_end(4);
        ob.insert_end(5);

        ob.head.next.next.next.next.next = ob.head.next.next;

        Node t = (new Q8_Cycle()).loopdetection(ob.head);
        if(t!=null) System.out.println(t.num);
        else System.out.println("no loop");
    }

    private Node loopdetection(Node head) {
        Node slow = head, fast = head;
        boolean collide=false;
        while(fast != null || fast.next!=null) {

            slow=slow.next;
            fast=fast.next.next;

            if(slow == fast) {
                collide = true;
                break;
            }
        }
        if (collide) {
            slow=head;
            while (slow!=fast) {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}
