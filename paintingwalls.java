package DP;
import java.util.*;
public class paintingwalls {
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int [][]dp = new int [n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return wall(0,0,cost,time,dp);
    }
    public int wall(int i ,int j,int[]cost,int[]time,int [][]dp){
        int n = cost.length;
        if(j>=n) return 0;
        if(i==n) return (int) 1e9;

        if(dp[i][j] != -1) return dp[i][j];

        int hire = cost[i] + wall(i+1,j+1 + time[i],cost ,time,dp);
        int free = wall(i+1 ,j,cost,time,dp);
        return dp[i][j]= Math.min(hire,free);
    }
}