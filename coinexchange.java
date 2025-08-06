package DP;
import java.util.*;
class coinexchange {
    public int coin (int []coin ,int amount ){
        int max = amount+1;
        int [] dp = new int [amount + 1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i =1;i<=amount;i++){
            for(int j =0;j<coin.length;j++){
                if(coin[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coin[j]]+1);
                }
            }
        }
        return dp[amount]>amount ?-1:dp[amount];
    }

}