import java.util.Stack;

public class Q5_SortStack {
    Stack<Integer> s = new Stack<>();

    void pushElement(int v) {
        s.push(v);
    }

    void sort() {
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()){
            int temp = s.pop();
            while (!tempStack.isEmpty() && temp < tempStack.peek()){
                s.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()) s.push(tempStack.pop());
    }
}
