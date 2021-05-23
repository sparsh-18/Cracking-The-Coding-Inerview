
import java.util.Scanner;
public class zeromat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m and n then matrix");
        int m=sc.nextInt();
        int n=sc.nextInt();

        int mat[][] = new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        boolean firstRowZero = false, firstColZero = false;

        for (int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 0) {
                firstRowZero=true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if(mat[0][i] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 0) {
                nullifyrow(mat,i);
            }
        }

        for (int j = 0; j < n; j++) {
            if(mat[0][j] == 0) {
                nullifycol(mat,j);
            }
        }

        if(firstRowZero) nullifyrow(mat, 0);

        if (firstColZero) {
            nullifycol(mat, 0);
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

    }

    private static void nullifycol(int[][] mat, int j) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][j] = 0;
        }
    }

    private static void nullifyrow(int[][] mat, int i) {
        for (int j = 0; j < mat[i].length; j++) {
            mat[i][j] = 0;
        }
    }
}
