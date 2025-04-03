import java.util.Arrays;

/* 274. H Ö¸Êý */
public class Main_250403_02 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int i = len;
        while (i >= 1){
            if(citations[len - i] < i){
                i--;
            }else {
                return i;
            }
        }
        return 0;
    }
}
