import java.util.*;
public class day14 {
    public static int countSubstringsWithKDistinct(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    private static int atMost(String s, int k) {
        int n = s.length(), left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < n; right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            while (freq.size() > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                if (freq.get(s.charAt(left)) == 0) freq.remove(s.charAt(left));
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstringsWithKDistinct("pqpqs", 2));
        System.out.println(countSubstringsWithKDistinct("aabacbebebe", 3));
        System.out.println(countSubstringsWithKDistinct("a", 1));
        System.out.println(countSubstringsWithKDistinct("abc", 3));
        System.out.println(countSubstringsWithKDistinct("abc", 2));
    }
}
