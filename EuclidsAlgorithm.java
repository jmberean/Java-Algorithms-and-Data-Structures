/*
 
 Chap 1 Introduction 1
 
 1.1 What Is an Algorithm? 3 // Exercises 1.1 7
 
 1.1 Algorithm’s
 
 An algorithm is a sequence of unambiguous instructions for solving a problem, i.e., for obtaining a required output for any legitimate input in a finite amount of time.
 
 •	The non-ambiguity requirement for each step of an algorithm cannot be compromised.
 
 •	The range of inputs for which an algorithm works has to be specified carefully.
 •	The same algorithm can be represented in several different ways.
 •	There may exist several algorithms for solving the same problem.
 
 Recall that the greatest common divisor of two nonnegative, not-both-zero integers m and n, denoted gcd(m, n), is defined as the largest integer that divides both m and n evenly, i.e., with a remainder of zero. Euclid of Alexandria (third century b.c.) outlined an algorithm for solving this problem in one of the volumes of his Elements most famous for its systematic exposition of geometry. In modern terms, Euclid’s algorithm is based on applying repeatedly the equality
 gcd(m, n) = gcd(n, m mod n),
 where m mod n is the remainder of the division of m by n, until m mod n is equal to 0. Since gcd(m, 0) = m (why?), the last value of m is also the greatest common divisor of the initial m and n.
 For example, gcd(60, 24) can be computed as follows: gcd(60, 24) = gcd(24, 12) = gcd(12, 0) = 12.
 
 */


import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
public class EuclidsAlgorithm{
    public static void main(String[] args)throws Exception{
        int n = 60;
        int m = 24;
        gcd(n,m);
    }
    static int gcd(int m, int n){
        if(n == m || n == 0){
            return m;
        }
        return gcd(n,m%n);
    }
}


// Divison Theorom

// Given integers mand n both greater than zero, there exists unique integers q, r; 0 <= r < m, such that

// n = m * q + r
// q = n / m
// r = n % m

// n = 60
// m = 24

// r = 60 % 24 = 12
// q = 60 / 24 = 2
// n = 24 * 2 + 12 = 48 + 12 = 60 = n
/*
 
 'Mathematical induction' // is a mathematical proof technique. It is essentially used to prove that a property P holds for every natural number n, i.e. for n = 0, 1, 2, 3, and so on.
 
 // prove
 p = a;
 
 // assume
 p = k;
 
 // Show
 p = k + 1;
 
*/














