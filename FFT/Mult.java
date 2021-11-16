/*  
   multiplication table for Z_n
*/

import java.util.Scanner;

public class Mult {

   private static int n;

   public static void main(String[] args) {
      System.out.print("enter n: " );
      Scanner keys = new Scanner( System.in );
      n = keys.nextInt();

      System.out.print("      ");
      for (int c=1; c<n; c++ ) {
         System.out.printf("%5d", c );
      }
      System.out.println();
      
      System.out.print("     -");
      for (int c=1; c<n; c++ ) {
         System.out.print("-----" );
      }
      System.out.println();

      for (int r=1; r<n; r++) {
         System.out.printf("%5d|", r );
         for (int c=1; c<n; c++) {
            System.out.printf("%5d", (r*c) % n );
         }
         System.out.println();
      }
   }
}
