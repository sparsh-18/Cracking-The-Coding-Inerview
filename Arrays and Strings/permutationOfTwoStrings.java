import java.util.Scanner;

/**
 * permutationOfTwoStrings
 */
public class permutationOfTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        boolean permutation = true;

        if (s1.length() != s2.length()) {
            System.out.println("Not Permutation");
            System.exit(0);
        }

        int s1_arr[] = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            s1_arr[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i);
            s1_arr[index]--;

            if (s1_arr[index] < 0) {
                permutation = false;
                break;
            }
        }

        if (permutation)
            System.out.println("Permutation");
        else
            System.out.println("Not Permutation");

    }
}