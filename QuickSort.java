/*****************************************
 / *
 / * Assignment QS Extra Credit
 / *
 / * Author      John Berean (20018)
 /*
 /*****************************************/        
 
		// {2,0,1}
        // int [] arr = {6,3,5};
  
        // {3,2,0,1} 
        // int [] arr = {7,6,3,5};
 
        // {7,6,3,5,0,1,2,4}
        //int [] arr = {7,6,3,5,0,1,2,4};
        
        //{biggest, second biggest, smllest, third biggest}
        // {3,2,0,1} 
        // int [] arr = {7,6,3,5};
        // {2,0,1}
        // int [] arr = {6,3,5};
        
        //int [] arr = {7,6,3,5,0,1,2,4};

        /*  
            This function takes first element as pivot, 
            places the pivot element at its correct position in sorted array, 
            and places all smaller (smaller than pivot) to left of pivot 
            and all greater elements to right of pivot 
        
        int [] arr = {7,6,3,5,0,1,2,4};
        int [] arr = {6,3,5,0,1,2,4,7};
        int [] arr = {3,5,0,1,2,4,6,7};
        int [] arr = {5,0,1,2,3,4,6,7};
        int [] arr = {0,1,2,3,4,5,6,7};
        
        */

        // int [] arr = {0}; ***
        // int [] arr = {0,1}; ***
        // int [] arr = {2,0,1}; ***
        // int [] arr = {3,2,0,1}; ***
        // int [] arr = {4,3,0,1,2}; ***
        // int [] arr = {5,3,0,1,2,4}; ***
        // int [] arr = {7,6,5,3,0,1,2,4}; ***
		        
		// int [] arr = {15,14,13,12,11, 6,7,3,5,9,10, 0,1,2,4,8}; 41
        // int [] arr = {15,14,13,12,11, 7,6,3,5,9,10, 0,1,2,4,8}; 40
        // int [] arr = {15,14,13,12,11, 10,7,6,3,5,9, 0,1,2,4,8}; 39
 
       
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.lang.*;
import java.text.*;
public class QuickSort{
    public static void main(String[] args)throws Exception{

        int [] arr = {7,6,3,5,0,1,2,4};
        int [] arr1 = {9,14,15,2,12,3,0,11,13,5,6,1,4,2,16,7};

        quickSort(arr, 0, arr.length-1);
        int n = 8;
        System.out.println("\n\nFor n = " + 8 + " \nCalculated smallest # rec calls: " + Example.c0);
        System.out.println("(n+1)log2(n) + 2(1 - n) = " + ((n+1)*(Math.log(n)/Math.log(2))+2*(1-n)));
        Example.c0 = 0;
        System.out.println("\nSequence requiring smallest number of recursive calls: 7,6,3,5,0,1,2,4");

        quickSort(arr1, 0, arr1.length-1);
        n = 16;
        System.out.println("\n\nFor n = " + 8 + " \nCalculated smallest # rec calls: " + Example.c0);
        System.out.println("(n+1)log2(n) + 2(1 - n) = " + ((n+1)*(Math.log(n)/Math.log(2))+2*(1-n)));
        System.out.println("\nSequence requiring smallest number of recursive calls: 9,14,15,2,12,3,0,11,13,5,6,1,4,2,16,6");
        System.out.println("\n\n");

    }
static void quickSort(int[] arr, int low, int high){
    if (low < high){
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}
   static int partition (int[] arr, int low, int high){
       // pivot (Element to be placed at right position)
       int pivot = arr[high];  
       int i = (low - 1);  // Index of smaller element
       for (int j = low; j <= high- 1; j++){
        Example.c0 = Example.c0 + 1;   
        if (arr[j] <= pivot){
               i++;    // increment index of smaller element
               //swap arr[i] and arr[j];
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
           }
       }
       //swap arr[i + 1] and arr[high]);
       int temp = arr[i+1];
       arr[i+1] = arr[high];
       arr[high] = temp;
       return (i + 1);
   }
}
class Example {
    public static int c0 = 0;
    
}
