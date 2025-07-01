package DP;
import java.util.*;
class cutRibbon {
    public int ribbon (int n,int a,int b,int c){
        int []dp = new int [n+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp ,-1);
            dp[0]=0;
        }
        for(int i=0;i<n;i++){
            if (i>=a && dp[i-a]!=-1) 
            dp[i] = Math.max(dp[i],dp[i-a]+1);
            if (i>=b && dp[i-b]!=-1) 
            dp[i] = Math.max(dp[i],dp[i-b]+1);
            if (i>=c && dp[i-c]!=-1) 
            dp[i] = Math.max(dp[i],dp[i-c]+1);
        }
        return dp[n];
    }
}