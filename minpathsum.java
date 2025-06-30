package DP;
import java.util.*;
class minpathsum {
    public int minPathSum(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int [][]memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return minPath(m-1,n-1,grid,memo);
    }
    public int minPath(int i,int j,int [][]grid,int [][]memo){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];
        if(memo[i][j]!=-1) return memo[i][j];
        int up = minPath(i-1,j,grid,memo);
        int left = minPath(i,j-1,grid,memo);
        memo[i][j]= Math.min(up,left) + grid[i][j];
        return memo[i][j];
    }
}