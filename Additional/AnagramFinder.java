import java.util.*;

public class AnagramFinder {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            char[] a = sub.toCharArray();
            char[] b = p.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            
            if (Arrays.equals(a, b)) {
                res.add(i);
            }
        }
        System.out.println(res);
    }
}
