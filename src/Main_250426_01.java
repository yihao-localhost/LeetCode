import com.sun.tools.javac.Main;

import java.util.*;

/* 49. ×ÖÄ¸ÒìÎ»´Ê·Ö×é */
public class Main_250426_01 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        if (strs.length == 0)
            return list;
        int i = 0;
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key))
                list.get(map.get(key)).add(s);
            else {
                map.put(key, i);
                System.out.println(chars);
                List<String> temp = new ArrayList<>();
                temp.add(s);
                list.add(temp);
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Main_250426_01().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
