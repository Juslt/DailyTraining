package com.example.juslt.retorfitdemo.sort;

import java.util.HashMap;

/**
 * Created by Juslt on 2019/8/21
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {1,1,2,0,8,3,7,9,5,4,7};
//        int[] a = {0,1,2,3};
//        BubbleSort sort = new BubbleSort();
//        sort.sort(a);

//        QuickSort sort = new QuickSort();
//        sort.sort(a,0,a.length-1);
//        InsertSort sort = new InsertSort();
//        sort.sort(a);
        SelectSort sort = new SelectSort();
        sort.sort(a);
        for (int i:a){
            System.out.println(a[i]);
        }
        HashMap hashMap = new HashMap<String,String>();
    }
}
