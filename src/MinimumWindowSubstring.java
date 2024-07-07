import java.util.HashMap;

public class MinimumWindowSubstring
{
    private static String minimumWindow (String s, String t)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int start = 0;
        int end = 0;
        int si = -1;
        int len = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)-1);
                if (map.get(c) == 0) count--;
            }
            if(count==0){
                while(true){
                    char ch = s.charAt(start);
                    if (!map.containsKey(ch)) start++;
                    else if (map.get(ch)<0) {
                        map.put(ch,map.get(ch)+1);
                        start++;
                    }else break;
                }
                if ((end-start+1) < len){
                    len = end-start+1;
                    si = start;
                }
            }
            end++;
        }
        return si == -1 ? "" : s.substring(si,si+len);
    }

    public static void main (String[] args)
    {
        System.out.println(minimumWindow("bba", "ab"));
    }
}
