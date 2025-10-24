class Solution {
     public int helper(String str1,String str2,int i,int j,int dp[][]){
         if(i < 0){
             return j+1;
         }
         if(j < 0){
             return i+1;
         }
         if(dp[i][j] != -1)return dp[i][j];
         //if match
         if(str1.charAt(i) == str2.charAt(j)){
             return dp[i][j] = 0 + helper(str1,str2,i-1,j-1,dp);
         }
         //agar match nhi hua to mere paas 3 option h
         //insert->
         int insert = helper(str1,str2,i,j-1,dp);
         //delete->
         int delete = helper(str1,str2,i-1,j,dp);
         //replace->
        int replace = helper(str1,str2,i-1,j-1,dp);

         return 1 + Math.min(insert,Math.min(delete,replace));

     }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        //return helper(word1,word2,n-1,m-1,dp);
        //tabulation approach
        //initialization step->
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
        }
        else{
            dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
        }
            }
        }
        return dp[n][m];

    }
}
