import java.util.HashMap;
import java.util.Map;

/* 383. ����� */
public class Main_250424_03 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i)))
                return false;
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) - 1);
            if (map.get(ransomNote.charAt(i)) < 0)
                return false;
        }
        return true;
    }
}
