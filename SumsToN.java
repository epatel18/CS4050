import java.util.Scanner;

public class SumsToN {

    public static void getSum(int n) {
        getSum(n, n, "");
    }

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int input = scan.nextInt();
        if (input > 0 && input != 0) {
            getSum(input);
        } else {
            System.out.println("Integer must be positve and non-zero. Please try again.");
            System.exit(0);
        }
    }

    private static void getSum(int n, int max, String sums) {
        if (n == 0) {
            System.out.println(sums);
            return;
        }
        for (int i = Math.min(max, n); i >= 1; i--) {
            getSum(n-i, i, sums + " " + i);
        }
    }
}

// Reference for method overloading: https://beginnersbook.com/2013/05/method-overloading/
// Reference for Math.min(): https://www.geeksforgeeks.org/java-math-min-method-examples/