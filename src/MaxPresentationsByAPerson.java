import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'maxPresentations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY scheduleStart
     *  2. INTEGER_ARRAY scheduleEnd
     */


    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {

        ArrayList<SetMe> me = new ArrayList();
        ArrayList<SetMe> results = new ArrayList();

        for (int i = 0; i < scheduleEnd.size(); i++) {
            me.add(new SetMe(scheduleStart.get(i), scheduleEnd.get(i)));
        }

        System.out.println("UNSORTED-------------" + me);


        Collections.sort(me);
        System.out.println("SORTED-------------" + me);


//        int iNew = 0;
//        int k = 0;
//        for (int i = 0; i < scheduleEnd.size(); i = i + 1 + iNew) {
//            results.add(k, me.get(i));
//            int diff = me.get(i).getDiff();
//            iNew = 0;
//            for (int j = i + 1; j < scheduleEnd.size(); j++) {
//                if (me.get(i).compareTo(me.get(j)) == 0) {
//                    iNew = iNew + 1;
//                    if (me.get(j).getDiff() < diff) {
//                        diff = me.get(j).getDiff();
//                        results.add(k, me.get(j));
//                    }
//                }
//            }
//            k++;
//
//        }//11 22 12 //12 23 34
        int iNew = 0;
        results.add(me.get(0));
        for (int i = 0; i < scheduleEnd.size(); i = i + iNew) {
            int previousEnd = me.get(i).end;
            for (int j = i + 1; j < scheduleEnd.size(); j++) {
                iNew++;
                if (me.get(j).start >= previousEnd) {
                    results.add(me.get(j));
                    break;
                }
            }


        }
        System.out.println("ANSWER-------------" + results);

        System.out.println("ANSWER-------------" + results.size());

        return results.size();
    }
}

class SetMe implements Comparable<SetMe> {
    int start;
    int end;

    public SetMe(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SetMe{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDiff() {
        return end - start;
    }

    @Override
    public int compareTo(SetMe o) {
        return this.getEnd() - o.getEnd();
    }
}

public class MaxPresentationsByAPerson {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Aastha\\HDH\\Random\\3.txt"));

        int scheduleStartCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scheduleStart = IntStream.range(0, scheduleStartCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int scheduleEndCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scheduleEnd = IntStream.range(0, scheduleEndCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int result = Result.maxPresentations(scheduleStart, scheduleEnd);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
