/* 121. 买卖股票的最佳时机 */
public class Main_250331_01 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i-1], 0);
        }
        return sum;
    }
}
