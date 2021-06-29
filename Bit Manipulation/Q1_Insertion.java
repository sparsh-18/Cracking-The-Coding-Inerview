import java.util.Scanner;

public class Q1_Insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 512; // 100000000
        int m = 11;  // 1011
/**
        left ->  11111111 then shift 6+1 times 11000000

        right ->  00000001 << 2 = 00000010  -1 means add 2s cpmpliment of 1

        2s compl of 1 =   00000001 .. 1s = 1111110  +1 = 1111111

        adding this to right =  00000010
                                11111111
                               ___________
                                00000001

        mask =  11000000 | 00000001 =  11000001


*/
        int j = 6, i= 3;

        int left = (~0) << (j+1);

        int right = (1 << i) - 1;

        int mask = left | right;

        int clrN = n & mask;

        System.out.println(Integer.toBinaryString(clrN));

        int shiftM = m << i;

        int insertM = clrN | shiftM;

        System.out.println(Integer.toBinaryString(insertM));
    }
}
