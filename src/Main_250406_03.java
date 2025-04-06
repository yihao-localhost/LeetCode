/* 134. ����վ */
public class Main_250406_03 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, currentGas = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
