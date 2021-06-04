import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Q4_QueueUsingStacks {

    static Stack<Integer> sNew = new Stack<>(), sOld = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1 - Add\n2 - Remove\n-1 to exit");
            ch = sc.nextInt();
            if (ch==-1) break;
            switch (ch) {
                case 1:
                    System.out.println("Enter element");
                    int v = sc.nextInt();
                    addElement(v);
                    break;
                case 2:
                    try {
                        int e = remove();
                        System.out.println(e);
                    }
                    catch (Exception ex) {
                        System.out.println("Empty Queue");
                    }

                    break;
            }
        }while (ch!=-1);
    }

    private static int remove() {
        if(!sOld.isEmpty()) return sOld.pop();
        else {
            while (!sNew.isEmpty()) {
                sOld.push(sNew.pop());
            }
            return sOld.pop();
        }
    }

    private static void addElement(int v) {
        sNew.push(v);
    }
}
