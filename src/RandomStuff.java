import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RandomStuff {


    public static void main(String[] args) {
//        Integer num1 = 100;
//        Integer num2 = 100;
//        if (num1 == num2) {
//            System.out.println("num1 == num2");
//        } else {
//            System.out.println("num1 != num2");
//        }

        Integer[] me = new Integer[4];

//        me[0] = 1;
//        me[1] = 2;
//
//        compute(me);
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(me[i]);
//        }

        double myDouble = 1.1;
        myDouble = (int) myDouble;
        System.out.println(myDouble);
        ComFu();


        Optional<Integer> iCouldBeNull = null;

        iCouldBeNull.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                ///
            }
        });

        iCouldBeNull.map(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return null;
            }
        });

    }

    private static CompletableFuture<Double> ComFu() {
        CompletableFuture<Double> futureResult = new CompletableFuture<>();
        new Thread(() -> {
            try {
                //some long process
                futureResult.complete(10.0);
            } catch (Exception e) {
                futureResult.completeExceptionally(e);
            }
        }).start();
        return futureResult;
    }

    static void compute(Object[] obj) {
        obj[2] = "3";
    }


}

class Solution123 {
    public int solution(int[] arr) {
        // write your code in Java SE 8

        int result = 1;
        int negativeInt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeInt++;
            }
            if (arr[i] == 0) {
                result = 0;
                return result;
            }

        }
        if (negativeInt % 2 != 0) {
            result = -1;
        }
        return result;
    }
}