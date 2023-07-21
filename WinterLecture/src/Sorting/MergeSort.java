package Sorting;

import java.util.Arrays;

public class MergeSort {
    int[] sorted;

    //    public void divide(int[] arr,int left, int right) {
//        if(left < right){
//            int mid = (left + right) / 2;
//            divide(arr,left,mid);
//            divide(arr,mid + 1,right);
//
//            //나뉘어진 배열의 맨 왼쪽 idx
//            int p1 = left;
//            int p2 = mid + 1;
//
//            //병합하기 위한 변수
//            int p3 = left;
//
//            while (p1 <= mid && p2 <= right) {
//                if(arr[p1] <= arr[p2]) sorted[p3++] = arr[p1++];
//                else sorted[p3++] = arr[p2++];
//            }
//
//            while(p1 <= mid) sorted[p3++] = arr[p1++];
//            while(p2 <= right) sorted[p3++] = arr[p2++];
//
//            for (int i = left; i <= right; i++) {
//                arr[i] = sorted[i];
//            }
//        }
//    }
    public void divide(int[] arr, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;
            divide(arr,left,mid);
            divide(arr,mid + 1,right);

            int p1 = left;
            int p2 = mid + 1;
            int p3 = left;
            while(p1 <= mid && p2 <= right) {
                if (arr[p1] <= arr[p2]) sorted[p3++] = arr[p1++];
                else sorted[p3++] = arr[p2++];
            }
            while(p1 <= mid) sorted[p3++] = arr[p1++];
            while(p2 <= right) sorted[p3++] = arr[p2++];

            for (int i = left; i <= right; i++) {
                arr[i] = sorted[i];
            }
        }
    }

    public int[] sort(int[] arr){
        sorted = new int[arr.length];
        divide(arr, 0, arr.length - 1);
        for(int x : arr) System.out.print(x + " ");
        System.out.println();
        return arr;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(new int[]{3, 2, 7, 9, 1, 5, 6, 8, 7});
    }
}
