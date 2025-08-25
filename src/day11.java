import java.util.*;
public class day11 {
    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // skip already used chars
            if (used[i]) continue;

            // skip duplicates (important when chars[i] == chars[i-1])
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // choose
            used[i] = true;
            current.append(chars[i]);

            // explore
            backtrack(chars, used, current, result);

            // unchoose
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // Test the function
    public static void main(String[] args) {
        String s = "abc";
        List<String> permutations = permute(s);
        System.out.println("Permutations of \"" + s + "\":");
        for (String p : permutations) {
            System.out.println(p);
        }
    }
}
