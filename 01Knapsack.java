//TC: O(n*c) SC: O(n*c)

public class Knapsack {
    public static int knapSack(int c, int[] weight, int[] values){
        int m = values.length;
        int[][] dp = new int[m+1][c+1];
        
        for(int i = 1; i< m+1;i++){
            for(int j = 0; j <c+1; j++){
                if(j < weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
        
        return dp[m][c];
    }
	
	

	// Driver code
	public static void main(String args[])
	{
		int values[] = new int[] { 10, 15, 20};
        int weight[] = new int[] { 1, 2, 3 };
        int c = 6;
		System.out.println(knapSack(c, weight, values));
	}
}



//TC: o(values * capacity) SC: o2(n) -> o(n) - capacity

public class Knapsack {
    public static int knapSack(int c, int[] weight, int[] values) {
        int n = values.length;
        int[] dp1 = new int[c + 1];
        int[] dp2 = new int[c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < weight[i - 1]) {
                    dp2[j] = dp1[j];
                } else {
                    dp2[j] = Math.max(dp1[j], values[i - 1] + dp1[j - weight[i - 1]]);
                }
            }
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
            
        }
        

        return dp1[c];
    }
	
	

	// Driver code
	public static void main(String args[])
	{
		int values[] = new int[] { 10, 15, 20};
        int weight[] = new int[] { 1, 2, 3 };
        int c = 6;
		System.out.println(knapSack(c, weight, values));
	}
}

