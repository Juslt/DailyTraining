package com.example.juslt.retorfitdemo.sort;

/**
 * Created by Juslt on 2019/8/21
 */
public class SelectSort {
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j]<temp){
                    temp = a[j];
                    index = j;
                }
            }
            if(index!=i){
                a[index] = a[i];
                a[i] = temp;
            }

        }
    }
}
