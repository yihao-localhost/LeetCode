import com.sun.tools.javac.Main;
/* 58. ���һ�����ʵĳ��� */
public class Main_250409_01 {
    public int lengthOfLastWord(String s) {
        String[] parts = s.trim().split(" ");
//        System.out.println("parts = " + parts[parts.length-1]);
        return parts[parts.length - 1].length();
    }

    public static void main(String[] args) {
        new Main_250409_01().lengthOfLastWord("   Hello    world  ");
    }
}
