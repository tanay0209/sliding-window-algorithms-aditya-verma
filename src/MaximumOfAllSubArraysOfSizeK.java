import java.util.ArrayList;
import java.util.Arrays;

public class MaximumOfAllSubArraysOfSizeK
{
    private static ArrayList<Integer> maximumInSubArray (ArrayList<Integer> list, int size)
    {
        int start = 0;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        while (end < list.size()) {
            int n = list.get(end);
            while (temp.size() > 0 && n > temp.get(temp.size() - 1)) {
                temp.remove(temp.size() - 1);
            }
            temp.add(n);

            if ((end - start + 1) < size) {
                end++;
            }
            else if ((end - start + 1) == size) {
                result.add(temp.get(0));
                if (temp.get(0).equals(list.get(start))){
                    temp.remove(0);
                }
                start++;
                end++;
            }
        }

        return result;
    }

    public static void main (String[] args)
    {
        ArrayList<Integer> list =
            new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        int size = 2;
        System.out.println(maximumInSubArray(list, size));

    }
}
