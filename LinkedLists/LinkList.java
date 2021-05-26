
public class LinkList {
    Node head;

    public void insert_beg(int n) {
        Node ob = new Node();
        ob.num = n;
        
        if(head == null) {
            head = ob;
            ob.next = null;
        }
        else {
            ob.next = head;
            head = ob;
        }
    }

    public void insert_end(int n) {
        Node ob = new Node();
        ob.num = n;
        ob.next = null;

        if(head == null) {
            head = ob;
        }
        else {
            Node t = head;
            while(t.next != null) {
                t=t.next;
            }
            t.next = ob;
        }
    }

    public int del_end() {
        Node t = head;
        int num = -9999;
        if(t==null) return -9999;

        else if(t.next == null) {
            num = t.num;
            head = null;
            return num;
        }

        else {
            while(t.next.next != null) {
                t=t.next;
            }

            num = t.next.num;
            t.next = null;
        }
        return num;
    }

    public int del_beg() {
       // Node t = head;
        int num = -9999;
        
        if(head==null) return -9999;

        else {
            num = head.num;
            head = head.next;
            return num;
        }
    }

    public void display() {
        Node t = head;
        while(t!=null) {
            System.out.print(t.num+" ");
            t=t.next;
        }
    }

    public static void main(String args[]) {
        LinkList obj = new LinkList();
        obj.insert_end(10);
        obj.insert_end(20);
        obj.insert_end(30);
        System.out.println(obj.del_beg());
        System.out.println(obj.del_beg());
        System.out.println(obj.del_beg());
        //obj.display();
    }
}
