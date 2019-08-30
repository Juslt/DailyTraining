package com.example.juslt.retorfitdemo.sort;

/**
 * Created by Juslt on 2019/8/21
 */
public class BubbleSort {

    public int[] sort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            for(int j=a.length-1;j>i;j--){
                if(a[j] <a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        return a;
    }
}
