import java.util.Arrays;
import java.util.Scanner;

class SwachBharat {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int noOfBags = s.nextInt();
        double[] weightOfBag = new double[noOfBags];
        for (int i = 0; i < noOfBags; i++) {

            weightOfBag[i] = s.nextDouble();
        }
        Arrays.sort(weightOfBag);
        int startJ = noOfBags;
        int tripsNeeded = 0;
        for (int i = 0; i < noOfBags; i++) {
            //  System.out.println(weightOfBag[i]);

            double maxRemaining = 3.0 - weightOfBag[i];

            for (int j = startJ - 1; j >= i; j--) {
                if (weightOfBag[j] <= maxRemaining) {
                    startJ = j;
                    tripsNeeded = tripsNeeded + 1;
                    break;
                } else {
                    if (j == i) {
                        tripsNeeded = tripsNeeded + 1;
                    }
                    tripsNeeded = tripsNeeded + 1;
                }

            }
        }

        System.out.println(tripsNeeded);
    }

}