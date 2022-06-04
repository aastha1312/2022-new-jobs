public class MaxLengthWith0Sum {

    public static void main(String[] args) {
        System.out.println(largestSubarray(new int []{0, -3, 3, -1, 6, -5}));
    }

    public static int largestSubarray(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                int count = 0;
                for (int k = i; k <= j; k++) {
                    count++;
                    sum = sum + nums[k];

                }
                if (sum == 0) {
                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }
}

