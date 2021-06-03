import java.util.Scanner;
import java.util.Stack;

public class Q2_StackMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        Stack<Integer> minBelowEach = new Stack<>();

        int ch;
        do {
            System.out.println("1 - Push\n2 - Pop\n3 - Minimum\n -1 to exit\n");
            ch = sc.nextInt();

            if(ch==-1) break;

            switch (ch) {
                case 1:
                    System.out.println("Enter element to be pushed");
                    int n = sc.nextInt();
                    st.push(n);
                    if(minBelowEach.size() == 0) minBelowEach.push(n);
                    else if (n < minBelowEach.peek()) minBelowEach.push(n);
                    break;

                case 2:
                    if(st.size() <= 0) {
                        System.out.println("Empty Stack");
                        break;
                    }
                    int e = st.pop();
                    if(e == minBelowEach.peek()) minBelowEach.pop();
                    System.out.println(e + " is popped");
                    break;

                case 3:
                    System.out.println(minBelowEach.peek());
                    break;
            }
        }while (ch!=-1);
    }
}
