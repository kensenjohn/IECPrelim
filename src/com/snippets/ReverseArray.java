package com.snippets;

import java.util.Arrays;

/**
 * Created by root on 8/25/15.
 */
public class ReverseArray {
    public static void main(String[] args) {

        int arrNumber[] = {1,2,3,4,5,6,7,8};

        int low = 0; // beginning of array index
        int high = arrNumber.length-1; // index of last element

        // swap elements at index low and high. Stop when you reach middle of array.
        while(low<=high) {

            int temp = arrNumber[low];
            arrNumber[low] = arrNumber[high];
            arrNumber[high] = temp;

            // increment and decrementing index. move towards
            // middle of the array
            low++;
            high--;

        }
        System.out.println(Arrays.toString(arrNumber));
    }
}
