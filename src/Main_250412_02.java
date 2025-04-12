import java.util.ArrayList;
import java.util.List;

/* 68. �ı����Ҷ��� */
//����ûд������д���о�д���ջ񲻴�ֱ�ӽ��õĹٷ����
public class Main_250412_02 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int right = 0, n = words.length;
        while (true) {
            int left = right; // ��ǰ�еĵ�һ�������� words ��λ��
            int sumLen = 0; // ͳ����һ�е��ʳ���֮��
            // ѭ��ȷ����ǰ�п��ԷŶ��ٵ��ʣ�ע�ⵥ��֮��Ӧ������һ���ո�
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // ��ǰ�������һ�У���������룬�ҵ���֮��Ӧֻ��һ���ո�����ĩ���ʣ��ո�
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // ��ǰ��ֻ��һ�����ʣ��õ�������룬����ĩ���ʣ��ո�
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            // ��ǰ�в�ֻһ������
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // ƴ�Ӷ����һ���ո�ĵ���
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // ƴ�����൥��
            ans.add(sb.toString());
        }
    }

    // blank ���س���Ϊ n ���ɿո���ɵ��ַ���
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // join ������ sep ƴ�� [left, right) ��Χ�ڵ� words ��ɵ��ַ���
    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}
