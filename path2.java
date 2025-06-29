package DP;

class path2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] memo = new int [m][n];
        for(int i =0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return unique(m-1,n-1,obstacleGrid,memo);

    }
    public int unique (int i , int j,int [][]obstacleGrid,int memo[][]){
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i==0 && j==0) return 1;

        if(memo[i][j] != -1) return memo[i][j];
        int up = unique(i-1,j,obstacleGrid,memo);
        int left = unique(i,j-1,obstacleGrid,memo);
        return memo[i][j]=up + left;
    }
}