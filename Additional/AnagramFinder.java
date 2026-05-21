import java.util.*;

public class AnagramFinder {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {

            sCount[s.charAt(i) - 'a']++;

            sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        AnagramFinder finder = new AnagramFinder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Anagram Index Finder ---");

        System.out.print("Enter the main string (s): ");
        String s = scanner.nextLine();

        System.out.print("Enter the pattern string (p): ");
        String p = scanner.nextLine();

        List<Integer> indices = finder.findAnagrams(s, p);

        if (indices.isEmpty()) {
            System.out.println("No anagrams found.");
        } else {
            System.out.println("Anagrams of \"" + p + "\" start at indices: " + indices);
        }

        scanner.close();
    }
}