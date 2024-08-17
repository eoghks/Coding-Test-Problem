class Solution {
    public int maxProfit(int[] prices, int fee) {
        int oldBuy = - prices[0];
        int oldSell = 0 ;
        for(int price: prices) {
            int newBuy = 0;
            int newSell = 0;
            
            if(oldSell - price > oldBuy)
                newBuy = oldSell - price;
            else
                newBuy = oldBuy;
            
            if(oldBuy + price - fee > oldSell)
                newSell = oldBuy + price -fee;
            else
                newSell = oldSell;
                
                
            oldBuy = newBuy;
            oldSell = newSell;
        }
        return oldSell;
    }
}