import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters
{
    private static int lengthOfLongestSubstring(String s){
        int start = 0;
        int end = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        while(end<s.length()){
            char c = s.charAt(end);
            if (set.add(c)){
                len = Math.max(len,end-start+1);
                end++;
            }else{
                while (set.contains(c)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(c);
                end++;
            }
        }
        return len;
    }

    public static void main (String[] args)
    {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
