import java.util.HashMap;

public class CountOccurrenceOfAnagrams
{
    private static int countAnagrams (String str, String pat)
    {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> string = new HashMap<>();
        HashMap<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            char c = pat.charAt(i);
            if (pattern.containsKey(c)) {
                pattern.put(c, pattern.get(c) + 1);
            }
            else {
                pattern.put(c, 1);
            }
        }
        int count = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            if (string.containsKey(c)) {
                string.put(c, string.get(c) + 1);
            }
            else {
                string.put(c, 1);
            }

            if ((end - start + 1) < pat.length()) {
                end++;
            }
            else if ((end - start + 1) == pat.length()) {
                if (pattern.equals(string)){
                    count++;
                }
                int val = string.get(str.charAt(start))-1;
                if (val>0){
                    string.put(str.charAt(start),val);
                }else {
                    string.remove(str.charAt(start));
                }
                end++;
                start++;
            }
        }
        return count;
    }

    public static void main (String[] args)
    {
        System.out.println(countAnagrams("forxxorfxdofr","for"));
    }
}
