import java.util.Scanner;
public class Q5_Sum_Lists {
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

        LinkList sum = (new Q5_Sum_Lists()).calculate(p.head,q.head);
        sum.display();
    }

    public LinkList calculate(Node p, Node q) {
        LinkList res = new LinkList();
        int carry = 0;
        int number = 0, i=0;

        while(p!=null || q!=null) {
            int sumOfRem =  carry;

            if(p!=null) {
                sumOfRem += p.num;
                p=p.next;
            }
            if(q!=null) {
                sumOfRem+=q.num;
                q=q.next;
            }

            int lastDigit = sumOfRem%10;
            number = number + lastDigit * (int)Math.pow(10,i);
            i++;
            carry = sumOfRem/10;

            res.insert_end(lastDigit);

            // p=p.next;
            // q=q.next;
        }

        if(carry != 0) {
            number = number + carry*(int)Math.pow(10,i);

            res.insert_end(carry);
        }

        System.out.println(number);

        return res;
    }
}
