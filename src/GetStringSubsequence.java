import java.util.*;

public class GetStringSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println(gss(scn.next()));

    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 1){
            ArrayList<String> me = new ArrayList<>();
            me.add(new String());
            me.add(str);
            return me;
        }

        ArrayList<String> res = gss(str.substring(1));
        int len = res.size();
        for (int i = 0; i < len; i++) {
            String s = res.get(i);
            res.add(str.substring(0,1) + s);

        }
      //  System.out.println(res);

        return res;
    }

}