/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int minNum = prices[0];
        int difference = 0;
        for(int count = 0; count < prices.length; count++){
            if(minNum >= prices[count])
                minNum = prices[count];
            else if(difference < prices[count] - minNum)
                difference = prices[count] - minNum;
        }
        return difference;
    }

    public static void main(String[] var0) {
        //int[] input = new int[]{7,1,5,3,6,4};
        int[] input = new int[]{10,20,25,15,3,7,5,10,30,2,15,60,30};
        long startTime = System.currentTimeMillis();
        System.out.println("Best time to buy and sell stock: " + maxProfit(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
