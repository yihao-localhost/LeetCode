import java.util.HashMap;
import java.util.Map;

/* 205. Í¬¹¹×Ö·û´® */
public class Main_250425_01 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character x = s.charAt(i);
            Character y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x))
                return false;
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
