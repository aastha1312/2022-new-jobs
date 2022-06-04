import java.util.ArrayList;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        //int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1, 3, 2, 5, 25, 24, 5};

        System.out.println(maxArea(height));

    }

//    public static int maxArea(int[] height) {
//        int result = 0;
//        int areaHere = 0;
//        int k = 0;
//        int i = 0;
//        int oldI = 0;
//
//        while (i < height.length) {
//            if (height[oldI] <= height[i]) {
//                for (int j = height.length - 1; j >= i; j--) {
//                    if (height[j] >= height[i]) {
//                        areaHere = height[i] * (j - i);
//                        result = getResult(result, areaHere, i, j);
//                        k = j;
//                        break;
//                    }
//                }
//
//                k = k + 1;
//                while (k < height.length) {
//                    while (k < height.length - 1 && height[k + 1] > height[k]) {
//                        k = k + 1;
//                    }
//                    areaHere = height[k] * (k - i);
//                    result = getResult(result, areaHere, i, k);
//                    k = k + 1;
//                }
//                oldI = i;
//            }
//            i++;
//        }
//
//        return result;
//    }

//    private static int getResult(int result, int areaHere) {
//        if (result < areaHere) {
//            result = areaHere;
//        }
//        return result;
//
//    }

    public static int maxArea(int[] height) {
        int result = 0;
        int intialPoint = 0;
        int finalPoint = 0;

        int areaHere = 0;
        int k = 0;
        int i = 0;
        int oldI = -1;
        while (i < height.length) {
            // do {
            if (oldI == -1 || height[oldI] < height[i]) {
                for (int j = height.length - 1; j >= i; j--) {
                    if (height[j] >= height[i]) {
                        System.out.println("for i: " + i);
                        System.out.println("1st j: " + j);
                        areaHere = height[i] * (j - i);
                        result = getResult(result, areaHere, i, j);
                        k = j;
                        break;
                    }
                }

                k = k + 1;
                while (k < height.length) {
                    while (k < height.length - 1 && height[k + 1] > height[k]) {
                        k = k + 1;
                    }
                    areaHere = height[k] * (k - i);
                    result = getResult(result, areaHere, i, k);
                    k = k + 1;
                }
                oldI = i;
            }
            i++;
        }
        // while (i < height.length);

        return result;
    }

    private static int getResult(int result, int areaHere, int i, int j) {
        //int intialPoint = 0;
        //  int finalPoint = 0;

        if (result < areaHere) {
            result = areaHere;
            //  intialPoint = i;
            //  finalPoint = j;
        }
        System.out.println("areaHere: " + areaHere + " i: " + i + " j: " + j);

        return result;

    }
}
