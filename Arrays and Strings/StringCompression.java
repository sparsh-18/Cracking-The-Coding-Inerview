import java.util.Scanner;
public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder s2 = new StringBuilder();
        int count=0;
        for(int i=0;i<=s.length()-1;i++) {
            char ch=s.charAt(i);
            count++;
            if(i+1>=s.length() || ch != s.charAt(i+1)) {
                s2.append(ch);
                s2.append(count);
                count=0;
            }
        }

        if(s2.length() > s.length() ) {
            System.out.println(s);
        }else
            System.out.println(s2);
    }
}
