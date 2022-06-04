import java.util.Arrays;

class FindAllPairsWithASum {

    public static void main(String[] args) {
        // int[] arr = {1, 5, 7, 1};

        int[] arr = {1, 4, 4, 5, 5, 5, 6, 6, 10, 11};

        System.out.println(getPairsCount(arr, arr.length, 11));
        System.out.println(pairs_count(arr, arr.length, 11));

    }

    static int getPairsCount(int[] arr, int n, int k) {
        int result = 0;
        int j = n - 1;
        Arrays.sort(arr);
        int i = 0;
        while (i < n && j > i) {
            //   if (j > i) {
            while (j > i && arr[i] + arr[j] > k) {
                j--;
            }
            if (arr[i] + arr[j] == k) {
                System.out.println("i: " + i + " j: " + j);
                int iCount = 1;
                int jCount = 1;
                while (arr[i + 1] == arr[i]) {
                    i++;
                    iCount++;
                }
                while (arr[j - 1] == arr[j]) {
                    j--;
                    jCount++;
                }
                if (arr[i] == arr[j]) {
                    result = result + (iCount * (iCount - 1) / 2);
                    break;
                } else {
                    result = result + (iCount * jCount);
                    i++;
                    j--;
                }

            } else {
                i++;
            }
            //      } else break;
        }
        return result;
    }


    static int pairs_count(int arr[], int n, int sum) {
        // To store the count of pairs
        int ans = 0;

        // Sort the given array
        Arrays.sort(arr);

        // Take two pointers
        int i = 0, j = n - 1;

        while (i < j) {

            // If sum is greater
            if (arr[i] + arr[j] < sum)
                i++;

                // If sum is lesser
            else if (arr[i] + arr[j] > sum)
                j--;

                // If sum is equal
            else {

                // Find the frequency of arr[i]
                int x = arr[i], xx = i;
                while ((i < j) && (arr[i] == x))
                    i++;

                // Find the frequency of arr[j]
                int y = arr[j], yy = j;
                while ((j >= i) && (arr[j] == y))
                    j--;

                // If arr[i] and arr[j] are same
                // then remove the extra number counted
                if (x == y) {
                    int temp = i - xx + yy - j - 1;
                    ans += (temp * (temp + 1)) / 2;
                } else
                    ans += (i - xx) * (yy - j);
            }
        }

        // Return the required answer
        return ans;
    }



}