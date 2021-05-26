package CTCI.LinkedList;
import java.util.Scanner;
public class Q1_RemoveDup {

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
        System.out.println();
        (new Q1_RemoveDup()).remove_dup(ob);
        System.out.println();
        ob.display();
    }

    public void remove_dup(LinkList ob) 
    {
        if(ob.head == null || ob.head.next == null) System.exit(0);

        else {
            Node i = ob.head;
            // System.out.println(ob.head.num);
            while(i.next != null) {
                Node j = i;
                while( j.next != null) {
                    if(i.num == j.next.num) {
                        j.next = j.next.next;
                    }else
                        j=j.next;
                }
                i=i.next;
            }
        } 
    }
    
}
