package com.example.juslt.retorfitdemo.sort;

/**
 * Created by Juslt on 2019/8/21
 */
public class InsertSort {
    public void sort(int[] a){
        int i,j ,insertNote;
        for(i=1;i<a.length;i++){
            insertNote = a[i];
            j=i-1;
            while (j>=0 && a[j]>insertNote){
                a[j+1] = a[j];
                j--;
            }
            j++;
            a[j] = insertNote;
        }
    }
}
