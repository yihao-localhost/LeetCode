import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 202. ¿ìÀÖÊı */
public class Main_250426_03 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        if (n == 1)
            return true;
        int next = getNext(n);
        while (!set.contains(next)) {
            set.add(next);
            next = getNext(next);
            if (next == 1)
                return true;
        }
        return false;
    }

    public int getNext(int n) {
        int ans = 0;
        while(n > 0) {
            ans += (n%10) * (n%10);
            n = n / 10;
        }
        return ans;
    }
}
