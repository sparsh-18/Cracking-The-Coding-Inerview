import java.util.Scanner;
public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        int ar[][] = new int[n][n];

        System.out.println("Enter matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j <= n-i-2; j++) {
                int temp = ar[i][j];
                ar[i][j] = ar[n-1-j][i];
                ar[n-1-j][i] = ar[n-1-i][n-1-j];
                ar[n-1-i][n-1-j] = ar[j][n-1-i];
                ar[j][n-1-i] = temp; 
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ar[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
