/*  form a specified F_n and multiply by input
    x
    (where arithmetic is specified Z_p such that
     alpha^n = 1 in Z_p
*/

import java.util.Scanner;
import java.io.*;

public class FormAndMultiply
{
  private static int n, p;
  private static PrintWriter out;

  public static void main(String[] args) throws Exception
  {
    out = new PrintWriter( new File( "temp.tex" ) );
    Scanner keys = new Scanner( System.in );
    System.out.print("enter n (size of Fourier matrix): ");
    n = keys.nextInt();

    System.out.print("enter p (arithmetic over Z_p): ");
    p = keys.nextInt();

    System.out.print("enter alpha: ");
    int alpha = keys.nextInt();

    int[][] f = new int[n][n];

    // inefficient, but who cares?
    for( int j=0; j<n; j++ )
      for( int k=0; k<n; k++ )
        f[j][k] = power( alpha, k*j );

    int[] x = new int[n];
    System.out.print("enter " + n + " values in Z_" + p + " for vector to multiplyx: " );
    for( int j=0; j<n; j++ )
      x[j] = keys.nextInt();

    int[] y = multiply( f, x );

    show( f, x, y );
  }

  private static int power( int alpha, int m )
  {
    int r = 1;
    for( int k=0; k<m; k++ )
      r = ( r * alpha ) % p;
    return r;
  }

  private static int[] multiply( int[][] f, int[] x )
  {
    int[] y = new int[ n ];
    for( int j=0; j<n; j++ )
    {
      y[j] = 0;
      for( int k=0; k<n; k++ )
      {
        y[j] +=  f[j][k] * x[k];
        y[j] = y[j] % p;
      }
    }
    return y;
  }

  private static void show( int[][] f, int[] x, int[] y )
  {
    out.println("\\left[\\matrix{");
    for( int j=0; j<n; j++ )
    {
      System.out.print("[");
      for( int k=0; k<n; k++ )
      {
        System.out.print( String.format("%4d", f[j][k] ) );
        if( k<n-1 )
          out.print( f[j][k] + "&" );
        else
          out.println( f[j][k] + "\\cr" );

      }
      System.out.print( String.format("] [%4d]", x[j] ) );
      System.out.print( String.format(" [%4d]", y[j] ) );
      System.out.println();
    }

    out.println("}\\right]");
    out.close();
  }

}
