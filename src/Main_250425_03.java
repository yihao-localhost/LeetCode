import java.util.HashMap;
import java.util.Map;

/* 242. 有效的字母异位词 */
public class Main_250425_03 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        System.out.println(mapT.toString());
        System.out.println(mapS.toString());
        if (mapS.equals(mapT))
            return true;
        return false;
    }

    public static void main(String[] args) {
        new Main_250425_03().isAnagram("anagram", "nagaram");
    }
}
