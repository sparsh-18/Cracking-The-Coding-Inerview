/**
 * uniqueAlphabets
 */
import java.util.Scanner;
public class uniqueCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean notUnique = false;
        boolean alphabets[] = new boolean[128];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(alphabets[ch]) {
                notUnique = true;
                break;
            }
            else alphabets[ch] = true;
        }
        if(!notUnique) System.out.println("Unique");
        else System.out.println("Not Unique");
    }
}
