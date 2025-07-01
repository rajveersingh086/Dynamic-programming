package DP;
import java.util.*;
class knapsack01 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapRec(W,val,wt,n,dp);
    }
    static int knapRec(int W,int val[],int wt[],int n,int [][]dp){
        if(n==0||W==0) return 0;
        if (dp[n][W] != -1) return dp[n][W];
        if(wt[n-1]<=W){
            
            int take = val[n-1]+knapRec(W-wt[n-1],val,wt,n-1,dp);
            int pick = knapRec(W,val,wt,n-1,dp);
            dp[n][W]=Math.max(take ,pick);
            }
            else{
                dp[n][W]=knapRec(W,val,wt,n-1,dp);
        }
        return dp[n][W];
        
    }
}
