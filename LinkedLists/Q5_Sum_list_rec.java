import java.util.Scanner;
public class Q5_Sum_list_rec {
    public static void main(String[] args) {
        LinkList p = new LinkList();
        LinkList q = new LinkList();

        p.insert_end(9);
        p.insert_end(7);
        p.insert_end(8);
        // p.insert_end(7);
        // p.insert_end(9);

        q.insert_end(6);
        q.insert_end(8);
        q.insert_end(5);

        LinkList sum = (new Q5_Sum_list_rec()).addList(p.head,q.head,0);
        sum.display();
    }

    public LinkList addList(Node p, Node q, int carry) {
        LinkList res = new LinkList();

        int sum = carry;

        if (p == null && q == null) {
            if(carry>0) res.insert_end(carry);
            return res;
        }

        if(p!=null) {
            sum+=p.num;
        }
        if(q!=null) {
            sum+=q.num;
        }

        res.insert_end(sum%10);

        if(p !=null || q !=null) {
            LinkList call = addList(p !=null ? p.next : null, q !=null ? q.next : null, sum/10 );
            res.addListEnd(call);
        }
        return res;
    }
}
