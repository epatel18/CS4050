/*  compute powers of
    all members of Z_n
    for n prime
*/

import java.util.Scanner;

public class Powers {

   private static int n;

   public static void main(String[] args) {
      System.out.print("enter n: " );
      Scanner keys = new Scanner( System.in );
      n = keys.nextInt();

      int kToN = 0;

      for (int j=1; j<n; j++ ) {
            System.out.printf("%4d ", j );
      }
      System.out.print("\n" );
      for (int j=1; j<5*n; j++ ) {
            System.out.print("_" );
      }
      System.out.print("\n" );
      
      
      for (int k=2; k<n; k++ ) {
         kToN = k;
         for (int j=1; kToN != 1 && j<n; j++) {
            System.out.printf("%4d ", kToN );
            kToN = (kToN * k) % n;
         }
         System.out.printf("%4d\n", kToN );
      }

   }
}
