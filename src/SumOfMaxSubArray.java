import java.util.ArrayList;
import java.util.List;

public class SumOfMaxSubArray {

    public static void main(String[] args)  {
        // [-2,1,-3,4,-1,2,1,-5,4, 23]
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4,23};
        bruteForce(arr);

    }

    private static void bruteForce(int[] arr) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length ; j++) {
                sum = sum + arr[j];
                answer = Math.max(answer,sum);
            }
        }
        System.out.println(answer);
    }

}
