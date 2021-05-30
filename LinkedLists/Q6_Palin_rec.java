class Result {
    Node node;
    boolean palin;

    public Result(Node head, boolean b) {
        node=head;
        palin=b;
    }
}

public class Q6_Palin_rec {
    public static void main(String[] args) {
        LinkList ob = new LinkList();
        ob.insert_end(1);
        ob.insert_end(2);
        ob.insert_end(0);
        ob.insert_end(2);
        ob.insert_end(1);

        Result res = (new Q6_Palin_rec()).isPalinRec(ob.head, ob.lengthList());
        System.out.println("Palin: "+res.palin);
    }

    public Result isPalinRec(Node head, int l) {

        if(head==null || l==0) return new Result(head,true);
        else if(l==1) return  new Result(head.next,true);

        Result r = isPalinRec(head.next,l-2);

        if(r.node == null || r.palin == false) return  r;

        if(r.node.num != head.num) {
            r.palin = false;
        }

        r.node = r.node.next;

        return r;
    }
}
