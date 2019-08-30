package com.example.juslt.retorfitdemo.sort;

/**
 * Created by Juslt on 2019/8/21
 */
public class QuickSort {
    public void sort(int[] a, int low, int height) {
        int i = low;
        int j = height;
        if(low>height){
            return;
        }

        int index = a[i];

        while (i<j){
            while (i<j && a[j]>=index)
                j--;
            if(i<j)
                a[i++] =a[j];
            while (i<j && a[i]<index)
                i++;
            if(i<j)
                a[j--] = a[i];
        }
        a[i] =index;
        sort(a,low,i-1);
        sort(a,i+1,height);
    }
}
