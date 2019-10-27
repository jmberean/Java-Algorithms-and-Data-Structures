

import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
public class ExtendedEuclidsAlgorithm{
    public static void main(String[] args)throws Exception{

        int n = 60;
        int m = 24;
        gcd(n,m);
        System.out.println(n * Example.a + m * Example.b);
        
        n = 300;
        m = 252;
        gcd(n,m);
        System.out.println(n * Example.a + m * Example.b);
        
        n = 1492721703;
        m = 91869921;
        gcd(n,m);
        System.out.println(n * Example.a + m * Example.b);
    }
    static void gcd(int n, int m){
        int aTemp;
        int bTemp;
        int r;
        int q;
        
        if(n == m || m == 0){
            Example.a = 1;
            Example.b = 0;
        }
        else{
        r = n%m;
        q = n/m;
        
        gcd(m,r);
        
        aTemp = Example.b;
        bTemp = Example.a - Example.b * q;
        Example.a = aTemp;
        Example.b = bTemp;
        }
    }
}
class Example {
    public static int a;
    public static int b;
}









