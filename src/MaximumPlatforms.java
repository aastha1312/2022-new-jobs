import java.util.Arrays;

public class MaximumPlatforms {

    public static void main(String[] args) {
        int[] A = {900, 940, 950, 1100, 1500, 1800};                //{50, 120, 200, 550, 700, 850};
        int[] D = {910, 1200, 1120, 1130, 1900, 2000};              //{500, 550, 600, 700, 900, 1000};

        System.out.println(getMinimumPlatforms(A, D));
        System.out.println("-----------------------------------------------------");
    }

    private static int getMinimumPlatforms(int[] A, int[] D) {
        int max = 0;
        int current = 0;


        int k = 0;
        int j = k;
        Arrays.sort(A);
        Arrays.sort(D);
        for (int i = 0; i < A.length; i++) {
            System.out.println("train: " + i);
            int ik = k;
            System.out.println("value of j: " + j);
            for (; j < i; j++) {
                if (A[i] > D[j]) {
                    current--;
                    k++;

                } else {
                    break;
                }
            }
            System.out.println("stations made vacant: " + (k - ik));
            current++;

            if (k == ik && current > max) {
                max++;
            }
            System.out.println("current: " + current);
            System.out.println("max: " + max);
            System.out.println("-----------------------------------------------------");
        }
        return max;
    }
}
