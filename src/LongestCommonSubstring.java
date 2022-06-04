import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LongestCommonSubstring {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution1 ob = new Solution1();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}

class Solution1 {
    String shorterString;
    int shorterStringLength;
    String longerString;

    int longestCommonSubstr(String s1, String s2, int n, int m) {

        if (n < m) {
            shorterString = s1;
            shorterStringLength = n;
            longerString = s2;
        } else {
            shorterString = s2;
            shorterStringLength = m;
            longerString = s1;
        }

        String[][] myArray = new String[shorterStringLength][shorterStringLength];

        int stringStart = 0;
        for (int i = 0; i < shorterStringLength; i++) {
            int jStart = stringStart;
            for (int j = shorterStringLength; j > stringStart; j--) {


                myArray[i][jStart] = shorterString.substring(stringStart, j);
                //  System.out.println(shorterString.substring(stringStart, j));
                jStart++;
            }
            stringStart++;
        }

        for (int i = 0; i < shorterStringLength; i++) {
            for (int j = 0; j < shorterStringLength; j++) {
                System.out.printf(myArray[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < shorterStringLength; i++) {
            for (int j = 0; j < shorterStringLength; j++) {
                if (myArray[j][i] != null) {
                    if (longerString.contains(myArray[j][i])) {
                        System.out.println(myArray[j][i] + "    " + longerString);
                        return myArray[j][i].length();
                    }
                }
            }
        }

        return 0;
    }
}