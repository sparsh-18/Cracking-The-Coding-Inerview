import java.util.Scanner;
public class permutationPalin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char inp[] = s.toCharArray();

        int a_nume_val = Character.getNumericValue('a');
        int z_nume_val = Character.getNumericValue('z');

        int table[] = new int[z_nume_val - a_nume_val +1];

        for(char ch: inp) {
            int ch_nume_val = Character.getNumericValue(ch);
            if(ch_nume_val <= z_nume_val && ch_nume_val>= a_nume_val) {
                table[ch_nume_val - a_nume_val]++;
            }
        }

        int odd = 0;
        for(int i: table) {
            if(i%2!=0){
                if(odd == 1){
                    odd++;
                    break;
                }
                odd++;
            }
        }

        if (odd<2) {
            System.out.println("Per");
        } else {
            System.out.println("Not per");
        }
    }
}
