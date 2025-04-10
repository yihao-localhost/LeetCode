import java.util.ArrayList;
import java.util.List;

/* 6. Z ×ÖÐÎ±ä»» */
public class Main_250410_03 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        boolean flag = true;
        for (Character c: s.toCharArray()) {
            if (flag) {
                list.get(i).append(c);
                i++;
                if (i == numRows) {
                    flag = false;
                    i -= 2;
                }
            } else {
                list.get(i).append(c);
                i--;
                if (i == -1) {
                    flag = true;
                    i += 2;
                }
            }
        }
        for (int j = 0; j < numRows; j++) {
            ans.append(list.get(j).toString());
        }
        System.out.println(ans);
        return ans.toString();
    }

    public static void main(String[] args) {
        new Main_250410_03().convert("PAYPALISHIRING", 3);
    }
}
