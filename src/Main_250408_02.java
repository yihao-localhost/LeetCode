import java.util.HashMap;
import java.util.Map;

/* 13. 罗马数字转整数 */
public class Main_250408_02 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int val = map.get(s.charAt(i));
            if (i < n - 1 && val < map.get(s.charAt(i + 1))){
                ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            }else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }
}
