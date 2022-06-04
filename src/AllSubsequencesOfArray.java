import java.util.ArrayList;

public class AllSubsequencesOfArray {
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    static {
        arr.add(3);
        arr.add(1);
        arr.add(2);
    }

    public static void main(String[] args) {
        printAllSubsequences(0);
    }

    public static void printAllSubsequences(int index) {
        if (index == arr.size()) {
            printArray(result);
            return;
        }
        result.add(arr.get(index));
        printAllSubsequences(index + 1);
        result.remove(arr.get(index));
        printAllSubsequences(index + 1);
    }

    private static void printArray(ArrayList<Integer> result) {
        if (result.size() == 0) {
            System.out.print("{}");
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
}
