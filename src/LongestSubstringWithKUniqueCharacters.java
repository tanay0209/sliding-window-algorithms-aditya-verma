import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters
{
    private static int longestSubstring (String s, int k){
        int start= 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int len = Integer.MIN_VALUE;
        while (end<s.length()){
            char c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.size()<k){
                end++;
            }else if (map.size() == k){
                len = Math.max(len,end-start);
                end++;
            }else{
                while (map.size()>k){
                    char ch = s.charAt(start);
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch) == 0){
                        map.remove(ch);
                    }
                    start++;
                }
                end++;

            }
        }
        return len == Integer.MIN_VALUE? -1 : len;
    }

    public static void main (String[] args)
    {
        String s =  "aaaa";
        int  k =2;
        System.out.println(longestSubstring(s,k));
    }
}
