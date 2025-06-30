package DP;
import java.util.*;
public class lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] memo = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return lcs(text1,text2,m-1,n-1,memo);
    }
    public int lcs(String s1,String s2,int i ,int j,int[][]memo){   
        if(i<0|| j<0) return 0;
        if(memo[i][j]!=-1)  return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j]= 1 + lcs(s1,s2,i-1,j-1,memo);
        }
        else{
            return Math.max(lcs(s1,s2,i-1,j,memo),lcs(s1,s2,i,j-1,memo));
        }
        return memo[i][j];
    }
}