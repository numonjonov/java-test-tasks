package word_counter;

import java.util.*;

public class Main {
    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the words: ");
        String text = scString.nextLine();
        System.out.print("Enter the n: ");
        int n = scInt.nextInt();

        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
            else if (!sb.isEmpty()) {
                words.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty()) words.add(sb.toString());

        for (int i = 0; i < words.size(); i++) {
            String w = words.get(i);
            if (w == null) continue;

            int count = 1;
            for (int j = i + 1; j < words.size(); j++) {
                if (w.equals(words.get(j))) {
                    count++;
                    words.set(j, null);
                }
            }
            if (count == n) System.out.println(w);
        }
    }
}
