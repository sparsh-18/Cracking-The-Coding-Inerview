import java.util.ArrayList;
import java.util.Scanner;

public class Q3_SetOfStacks {

    ArrayList<Stackk> array = new ArrayList<>();
    int sizeOfEachStack;

    Q3_SetOfStacks(int si) {
        sizeOfEachStack=si;
    }

    class Stackk {
        int ar[], size, top=-1;
        Stackk (int size) {
            this.size = size;
            ar = new int[size];
        }

        public boolean isfull() {
            if(ar.length-1 == top) return true;
            else return false;
        }

        public boolean isEmpty() {
            if(top==-1) return true;
            else return false;
        }
    }

    public void push(int n) {
        if(array.size() == 0) {
            Stackk newStack = new Stackk(sizeOfEachStack);
            array.add(newStack);
        }
        Stackk s = array.get(array.size()-1);
        if(!s.isfull()) {
            s.top++;
            s.ar[s.top] = n;
        } else {
            array.add(new Stackk(sizeOfEachStack));
            push(n);
        }
    }

    public int pop(){
        if(array.size() == 0) return -9999;
        int indexOfArray = array.size() -1;
        while(array.size()!=0 && array.get(indexOfArray).isEmpty()) {
            array.remove(indexOfArray);
            indexOfArray--;
        }
        if (indexOfArray < 0) return -9999;
        Stackk st = array.get(indexOfArray);
        int e = st.ar[st.top];
        st.top--;
        return e;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of each set stack");
        int n = sc.nextInt();

        Q3_SetOfStacks ob = new Q3_SetOfStacks(n);

        int ch;
        do {
            System.out.println("1-push\n2-pop\n-1 to exit");
            ch = sc.nextInt();

            switch (ch){
                case 1:
                    System.out.println("Enter element");
                    int value = sc.nextInt();
                    ob.push(value);
                    break;
                case 2:
                    int e = ob.pop();
                    if(e==-9999) System.out.println("Stak Empty");
                    else System.out.println(e);
                    break;
            }
        }while (ch!=-1);
    }
}
