public class day8 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        String output = reverseWords(input);
        System.out.println(output);
    }
}
