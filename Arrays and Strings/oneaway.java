import java.util.Scanner;
public class oneaway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next(),s2=sc.next();
        boolean found = false, flag=false;

        if(s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)){
                    if(found) {
                        found = true;
                        flag=true;
                        break;
                    }
                    found=true;
                }
            }
        } else {
            if(s1.length() > s2.length()) {
                int i1=0,i2=0;
                while(i1<s1.length() && i2<s2.length()) {
                    if(s1.charAt(i1) != s2.charAt(i2)){
                        if(found){
                            found=true;
                            flag=true;
                            break;
                        }
                        found=true;
                        i1++;
                    }
                    i1++;
                    i2++;
                }
            }
            if(s2.length() > s1.length()) {
                int i1=0,i2=0;
                while(i1<s1.length() && i2<s2.length()) {
                    if(s1.charAt(i1) != s2.charAt(i2)){
                        if(found){
                            found=true;
                            flag=true;
                            break;
                        }
                        found=true;
                        i2++;
                    }
                    i1++;
                    i2++;
                }
            }
        }
        if(!flag) System.out.println("one away");
        else System.out.println("Not");
    }
}
