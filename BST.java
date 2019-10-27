/*****************************************
 / *
 / * Assignment BST Assingment
 / *
 / * Author      John Berean (20018)
 /*
 /*****************************************/

/*
 assignment on BST
 Posted on: Saturday, October 6, 2018 5:28:58 PM EDT
 
 The assignment is to estimate the average number of data comparisons
 
 that BST performs on a list of length n.
 
 Let n = 50, 100, 150, 200, ..., 5000 (or more)
 
 For each n,
 
 let k = 1, 2, ...., 20
 
 For each k, generate a random permutation s(n,k) of 1,2, ...., n. (see below).
 
 Run Quicksort on the input list s(n,k), and compute c(n,k), the total number of data comparisons for Quicksort to sort list s(n,k).
 
 This requires a counter in the Split routine. Don't forget to correctly re-initialize this count for each new permutation.
 
 Add c(n,k) to a total count t(n). So t(n) = c(n,1) + .... + c(n,20).
 
 Compute E(n), the estimated average runtime of Quicksort on lists of length n:  E(n) = t(n)/20.
 
 Print  n, E(n),  E(n)/n^2,   E(n)/nlog(n)
 
 As n gets larger and larger, do either of the last 2 columns stabilize (approach some positive, finite constant)?
 
 If so, the corresponding denominator gives the order of magnitude of E(n). The denominators chosen correspond
 
 to the worst case and the best case, so we are studying whether the average is close to either of these cases.
 
 (The actual average runtime for Quicksort is already posted on Blackboard, and your estimated average will hopefully
 
 have the same order, even though we are only using 20 out of n! permutations for each n - a tiny sample.)
 
 Random permutation of the list x: 1, ...., n
 
 For k = n downto 2:
 
 Let j = Random(k) (a random integer in the range 1,,,,,, ,k)
 
 Swap( x{k], x[j] )
 
 Example: n = 5
 
 Initialize x:   1   2   3   4   5
 
 k = 5  Suppose  j = Random(5) gives j =2. Swap( x[5], x[2]):
 
 x:     1    5   3   4   [2]     ( 2 is in its final position)
 
 k = 4   Suppose j = Random(4) gives j = 2.  Swap(x[4],x[2]):
 
 x:     1   4   3   [5]  [2]     (5 is in its final position)
 
 k = 3   Suppose j = Random( 3)   gives j = 1  (Swap(x[3],x[1]):
 
 x:    3   4   [1]  [5]  [2]
 
 k  = 2  Suppose j = Random(2) gives j =2.   Swap(x[2],x[2]):
 
 x:     3   [4]  [1]   [5]  [2]
 
 So the "random" permutation is   3   4   1   5   2
 
 This becomes the input list for the sort.
 */

import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.concurrent.ThreadLocalRandom;

class BST{
    private treeNode root;
    private treeNode currTN;
    private int size;
    
    public int getSize(){
        return size;
    }
    public treeNode getRoot(){
        return root;
    }
    public void setSize(int s){
        size = s;
    }
    public void setRoot(treeNode r){
        root = r;
    }
    public void Pre(treeNode curr, int leftDir, treeNode save){
        if(curr != null){
            treeNode newNode = new treeNode(curr.getData());
            if(save != null){
                if(leftDir == 1){
                    save.setLeft(newNode);
                }
                else{
                    save.setRight(newNode);
                }
            }
            save = newNode;
            Pre(curr.getLeft(), 1, save);
            Pre(curr.getRight(), 0, save);
        }
    }
    //constructor
    public BST(){
        //initialize an empty binary search tree
        root = null;
        size = 0;
    }
    //copy constructor
    public BST(BST x){
        size = x.getSize();
        treeNode xroot = x.getRoot();
        root = new treeNode(xroot.getData());
        Pre(xroot.getLeft(), 1, root);
        Pre(xroot.getRight(), 0, root);
    }
    //member methods
    public void insert(int y)
    {
        treeNode newNode = new treeNode(y);
        assert(newNode != null);
        size++;
        
        //initialize the new node
        if(root == null){
            root = newNode; //insertion into previously empty tree
        }
        else{
            int leftDir = 0;
            treeNode save = null;
            treeNode curr = root; //initialize current node with root
            while(curr != null){ //loop to locate insertion position
                save = curr; //save the address of the current node
                Example.c0 = Example.c0 + 1;
                if(y <= curr.getData()){ //compare y to data of current node
                    curr = curr.getLeft(); //if y smaller than current data, continue left
                    leftDir = 1;
                }
                else{
                    curr = curr.getRight();//if y greater than current data, continue right
                    leftDir = 0;
                }
            }
            if(leftDir == 1){
                save.setLeft(newNode); //insert a left child
            }
            else{
                save.setRight(newNode); //insert a right child
            }
        }
    }
    public void trav(){
        //System.out.println("inorder traversal of the BST: " );
        inorder(root); //initial call for recursive inorder traversal
    }
    public void inorder(treeNode ptr){
        Stack<treeNode> stack1 = new Stack<>();
        currTN = ptr;
        boolean completedInorderTrav = false;
        
        while(completedInorderTrav != true){
            if(currTN != null){
                stack1.push(currTN);
                currTN = currTN.getLeft();
            }
            else{
                if(currTN == null && stack1.size() > 0){
                    currTN = stack1.pop();
                    //System.out.println(currTN.getData());
                    currTN = currTN.getRight();
                }
                else{
                    completedInorderTrav = true;
                }
            }
        }
    }
    //class methods
    public static BST CombineBST(BST A, BST B, int x){
    //precondition: largest element of A <= x < smallest element of B
        BST Acopy = new BST(A);
        BST Bcopy = new BST(B);
        BST C = new BST(); //empty BST
        treeNode r = new treeNode(x);
        C.setRoot(r);
        r.setLeft(Acopy.getRoot());
        r.setRight(Bcopy.getRoot());
        C.setSize(A.getSize()+B.getSize()+1);
        return C;
    }
}
class treeNode{
    private int data;
    private treeNode left;
    private treeNode right;
    
    public treeNode(int y){
        data = y;
        left = null;
        right = null;
    }
    public int getData(){
        return data;
    }
    public treeNode getLeft(){
        return left;
    }
    public treeNode getRight(){
        return right;
    }
    public void setData(int y){
        data = y;
    }
    public void setLeft(treeNode leftChild){
        left = leftChild;
    }
    public void setRight(treeNode rightChild){
        right = rightChild;
    }
}
public class BST{
    public static void main(String[] args){

        double sum = 0;
        int counter = 50;
        int[] a;
        List<Integer> l = new ArrayList<>();
        
        System.out.println("\n Build BST on the input list s(n,k), and compute c(n,k), the total number of data comparisons for BST to build tree and inOrder traversal on list s(n,k).\n\n PROGRAM START \n\n");
        
        System.out.printf("%-4s%13s%15s%15s","n","E(n)","E(n)/n^2","E(n)/nlog(n)");
        System.out.println("\n--------------------------------------------------\n");
        
        for(int i = 50; i <= 5000; i = i + 50){
            for(int k = 0; k < 20; k++){
                // create array of 1 - i
                for(int p = 1; p <= i; p++){
                    l.add(p);
                }
                // shuffle array
                Collections.shuffle(l);
                // turn List back into array
                a = new int[i];
                for(int pp = 0; pp < l.size(); pp++){
                    a[pp] = (int)l.get(pp);
                }
                // build BST
                BST ab = new BST();
                for(int ie =0; ie<a.length;ie++){
                    ab.insert(a[ie]);
                }
                //System.out.println("BST a");
                ab.trav();
                // add number of data comparisons 20 times to sum
                sum += Example.c0;
                Example.c0 = 0;
                l.clear();
            }
            System.out.printf("%-10d%10.3f%10.5f%10.5f",i,(sum/20),(sum/20)/(Math.pow(i,2)),(sum/20)/(i*(Math.log(i)/Math.log(2))));
            System.out.println();
            sum = 0;
        }
    }
    static void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
class Example {
    public static int c0 = 0;
    public static int c1 = 0;
    public static int c2 = 0;
    public static int smallest = 10000;
    public static int[] smallestSeq;
}
