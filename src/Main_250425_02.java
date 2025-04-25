import java.util.HashMap;
import java.util.Map;

/* 290. µ¥´Ê¹æÂÉ */
public class Main_250425_02 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        String[] str = s.split(" ");
        if (str.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (p2s.containsKey(pattern.charAt(i)) && !p2s.get(pattern.charAt(i)).equals(str[i]))
                return false;
            if (s2p.containsKey(str[i]) && s2p.get(str[i]) != pattern.charAt(i))
                return false;
            p2s.put(pattern.charAt(i), str[i]);
            s2p.put(str[i], pattern.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        new Main_250425_02().wordPattern("abba", "dog cat cat dog");
    }
}
