import java.util.Scanner;

public class TargetSumSubset {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();

        }
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, -1, "", 0, tar);


    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {
// if I put this condition here without a return statement, even if the base case is hit,
// it would continue to check for more solutions which will be needed if there are 0s or negative numbers
// and it would give all answers but the order wouldn't match the answer because we are printing not from the leaves of recurrsion tree but
// even if the answers are found in the middle.
// writing this condition in the post area would give as the exact order.

        // if(sos==tar){
        //     System.out.println(asf + ".");
        //     // return;
        // }

// we want to check this condition before we even make a new call , see line 35
        // if(sos>tar){
        //     return;
        // }

        for (int i = idx + 1; i < arr.length; i++) {
            if (sos + arr[i] <= tar) {
                printTargetSumSubsets(arr, i, asf + arr[i] + ", ", sos + arr[i], tar);
            }

        }

        if (sos == tar) {
            System.out.println(asf + ".");
            // return;
        }

    }

}