import java.util.*;
public class MergeSort{
    public static void mergeSort(int[] array){

        
    }
    public static void mergeSort(int[] x, int l, int r){
        if(r<=l){
            return;
        }
        else{
            m=(l+r)/2;
            mergeSort(x,l,m);
            mergeSort(x,m+1,r);
            merge(x,l,r);
            
        }
    }
    public static void merge(int[] x, int l, int r){
        int [] temp = new int[100];
        
        if(x.atIndex(l)<=x.atIndex(r)){
            temp[k] = x.atIndex(l);
            l++;
        }
        else{
            temp[k] = x.atIndex(r);
            r++;
        }
        
    }
}