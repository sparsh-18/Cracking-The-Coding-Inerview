package CTCI.LinkedList;
import java.util.Scanner;
public class Q2_kthToLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkList ob = new LinkList();
        int n;
        do {
            System.out.println("Enter numbers .. -1 o exit");
            n = sc.nextInt();
            if(n!=-1)
                ob.insert_end(n);
        }while(n!=-1);

        ob.display();
        System.out.println("Enter k");
        int k = sc.nextInt();

        int t = (new Q2_kthToLast()).kToL( k, ob.head);
        
        System.out.println();

        (new Q2_kthToLast()).kToL_itr(ob.head, k);
    }

    //recursion
    public int kToL(int k, Node head) {

        int index;

        if(head == null) return 0;

        index = kToL(k, head.next) + 1;
        
        if(index == k) System.out.println(k+"th Element is "+ head.num);

        return index;
    }

    //iterative

    public void kToL_itr(Node head, int k) {
        Node p1 = head, p2 = head;

        for (int i = 0; i < k; i++) {
            if(p2==null) System.exit(0);

            else p2=p2.next;
        }

        while(p2 != null) {
            p1=p1.next;
            p2=p2.next;
        }

        System.out.println(k+"th Element is "+ p1.num);
    }
}
