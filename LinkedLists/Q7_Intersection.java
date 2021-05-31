public class Q7_Intersection {
    public static void main(String[] args) {
        LinkList p = new LinkList();
        LinkList q = new LinkList();

        p.insert_end(3);
        p.insert_end(1);
        p.insert_end(5);
        p.insert_end(9);
        p.insert_end(7);
        p.insert_end(2);
        p.insert_end(1);

        q.insert_end(4);
        q.insert_end(6);
        q.head.next.next = p.head.next.next.next.next;

        p.display();
        System.out.println();
        q.display();
        System.out.println();

        Node i = (new Q7_Intersection()).intersectionNode(p.head,p.lengthList(),q.head,q.lengthList());

        if(i!=null) System.out.println(i.num);
        else System.out.println("No intersection");
    }

    private Node intersectionNode(Node p,int lp, Node q, int lq) {
        if(p==null || q==null) return null;

        while (lp>lq) {
            p=p.next;
            lp--;
        }

        while (lq>lp) {
            q=q.next;
            lq--;
        }

        while(p != q) {
            p=p.next;
            q=q.next;
        }

        return  p;
    }

}
