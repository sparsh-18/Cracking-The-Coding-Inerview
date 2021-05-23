/**
 * urlify
 */
import java.util.Scanner;
public class urlify {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int truelength = sc.nextInt();
        char ch[] = s.toCharArray();

        int bck_index = ch.length-1;
        for (int i = truelength-1; i >= 0; i--) {
            if(ch[i] != ' ') {
                ch[bck_index--] = ch[i];
            } else {
                ch[bck_index--] = '0';
                ch[bck_index--] = '2';
                ch[bck_index--] = '%';
            }
        }

        System.out.println(ch);
    }
}