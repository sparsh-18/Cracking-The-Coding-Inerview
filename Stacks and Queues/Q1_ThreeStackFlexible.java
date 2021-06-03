public class Q1_ThreeStackFlexible {
    int array[], size[], capacity[], start[], n, noOfStacks;
    public Q1_ThreeStackFlexible (int n, int noOfStacks) {
        this.n = n;
        this.noOfStacks = noOfStacks;
        array = new int[n];
        size = new int[noOfStacks];
        capacity = new int[noOfStacks];
        start = new int[noOfStacks];
        int sum=0;
        for (int i = 0; i < noOfStacks-1; i++) {
            capacity[i] = n/noOfStacks;
            sum+=n/noOfStacks;
            start[i] = i>0 ? capacity[i-1] + start[i-1] : 0;
        }
        capacity[noOfStacks-1] = n-sum;
        start[noOfStacks-1] = capacity[noOfStacks-2] + start[noOfStacks-2];
    }

    public int adjust(int index) {
        index = ((index % array.length) + array.length) % array.length;
        return index;
    }

    public boolean fullarray() {
        int sum = 0;
        for (int i = 0; i < size.length; i++) {
            sum+=size[i];
        }
        if (sum == array.length) return true;
        else  return false;
    }

    public boolean inRange(int i, int stack) {
        if(i < 0 || i > array.length) return false;

        int in = i < start[stack] ? array.length + i : i;

        if (start[stack] <= in && in < start[stack]+capacity[stack]) return true;
        else return false;
    }

    public void shift(int stack) {
        if (size[stack] == capacity[stack]){
            shift((stack+1)%noOfStacks);
            capacity[stack]++;
        }
        int index = adjust(start[stack] + capacity[stack] -1);
        while (inRange(index, stack)) {
            array[index] = array[adjust(index-1)];
            index = adjust(index-1);
        }
        array[adjust(index+1)] = 0;
        start[stack] = adjust(start[stack] + 1);
        capacity[stack]--;
    }

    public void push(int stackNumber, int value) {
        if(fullarray()) System.out.println("All stacks full");
        else {
            if(size[stackNumber] == capacity[stackNumber]) {
                shift((stackNumber+1) % noOfStacks);
                capacity[stackNumber]++;
            }
            int index = adjust(start[stackNumber] + size[stackNumber]);
            array[index] = value;
            size[stackNumber]++;
        }
    }

    public int pop(int stackNumber) {
        if(size[stackNumber] == 0) return -9999;

        int in = adjust(start[stackNumber] + size[stackNumber] -1);
        int e = array[in];
        size[stackNumber]--;
        return  e;
    }

}
