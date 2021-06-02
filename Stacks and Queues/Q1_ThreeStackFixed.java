import java.util.Scanner;

public class Q1_ThreeStackFixed {

    int noOfStacks;
    int array[];
    int n;
    int size[];
    int maxSize[];

    public Q1_ThreeStackFixed(int n, int noOfStacks) {
        this.noOfStacks = noOfStacks;
        array = new int[n];
        this.n = n;
        size = new int[noOfStacks];
        maxSize = new int[noOfStacks];
        int sum=0;
        for (int i = 0; i < noOfStacks -1; i++) {
            maxSize[i] = n/noOfStacks;
            sum+=maxSize[i];
        }
        maxSize[noOfStacks-1] = n - sum;
    }

    public void push(int StackNumber, int value) {
        int stackIndex = StackNumber-1;
        if(size[stackIndex] < maxSize[stackIndex]) {

            int index=0;
            for (int i = 0; i <= stackIndex-1; i++) {
                index = index + maxSize[i];
            }
            index+=size[stackIndex];
            array[index] = value;

            size[stackIndex]++;

            System.out.println("Success");
        } else {
            System.out.println("Full");
        }
    }

    public int pop(int StackNumber) {
        int stackIndex = StackNumber-1;

        if(size[stackIndex] == 0) return  -9999;
        else {
            int index = 0;
            for (int i = 0; i < stackIndex; i++) {
                index+=maxSize[i];
            }
            size[stackIndex]--;

            index+=size[stackIndex];
            int e = array[index];

            return  e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size");
        int n = sc.nextInt();
        System.out.println("Enter  number of stack");
        int s = sc.nextInt();

        Q1_ThreeStackFixed stack = new Q1_ThreeStackFixed(n,s);

        int ch;
        do {
            System.out.println("1 - Push\n2 - Pop\n-1 to exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter stack number followed by value");
                    int sno = sc.nextInt();
                    int v = sc.nextInt();
                    stack.push(sno,v);
                    break;

                case 2:
                    System.out.println("Enter stack number");
                    sno = sc.nextInt();
                    int e = stack.pop(sno);
                    System.out.println(e == -9999? "EMPTY" : e);
                    break;
            }

        }while(ch!=-1);

    }
}
