import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Ex20 {
    final static int INF = 99999;

    public static int solve(int[] A) {
        int[][] MV = new int[A.length][A.length];
        String[][] table = initTable(A.length);

        for (int interval = 0; interval < A.length; interval++) {
            for (int i = 0, j = interval; j < A.length; i++, j++) {
                int a, b, c;
                if (i + 2 <= j) {
                    a = MV[i + 2][j];
                } else {
                    a = 0;
                }
            
                if (i + 1 <= j - 1) {
                    b = MV[i + 1][j - 1];
                } else {
                    b = 0;
                }
            
                if (i <= j - 2) {
                    c = MV[i][j - 2];
                } else {
                    c = 0;
                }
            
                MV[i][j] = Math
                        .max(A[i] + Math.min(a, b), A[j] + Math.min(b, c));
                int F = A[i] + Math.min(a, b);
                int L = A[j] + Math.min(b, c);
                if (F > L) {
                    table[i][j] = MV[i][j] + " (F)";
                } else if (F == L) {
                    table[i][j] = MV[i][j] + " (0)";
                } else {
                    table[i][j] = MV[i][j] + " (L)";
                }
            }
        }
        printTable(table);
        return MV[0][A.length - 1];
    }
    private static String[][] initTable(int size) {
        String[][] table = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = "0 (-)";
            }
        }
        return table;
    }
    private static void printTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            if (i == 0) {
                System.out.printf("%5s", "");
                for (int k = 0; k < table.length; k++) {
                    System.out.printf("%10d ", (k + 1));
                }
                System.out.println();
            }
            System.out.printf("%5d %s", (i + 1), "|");
            for (int j = 0; j < table.length; j++) {
                System.out.printf("%11s", table[i][j]);
            }
            System.out.println("\n");
        }
    }

    static int optimalStrategy(int[] arr, int n) {
        int F[][] = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {

                x = ((i + 2) <= j)? F[i + 2][j]: 0;
                y = ((i + 1) <= (j - 1))? F[i + 1][j - 1]: 0;
                z = (i <= (j - 2))? F[i][j - 2]: 0;

                F[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        printSolution(F);
        return F[0][n - 1];
    }

    static void printSolution(int F[][]) {
        System.out.println("Order of choices: ");
        for (int i = 0; i<F.length; ++i) {
            for (int j=0; j<F.length; ++j) {
                if (F[i][j]==INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(F[i][j]+" ");
                }
            }
            System.out.println("\n");
        }
    }

    private static int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many positive integers are in the list:");
        int length =  scanner.nextInt();
        int[] numArray = new int[length];
        System.out.println("Please enter the positive integers:");
        for (int i=0; i < length; i++) {
            int userInput = scanner.nextInt();
            numArray[i] = userInput;
        }
        return numArray;
    }

    public static void main(String[] args) {
        int[] A = getUserInput();
        System.out.println(Arrays.toString(A) + "\n");
        System.out.println("The optimal score is [ " + solve(A) + " ]");
    }
}
