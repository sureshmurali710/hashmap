class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int max = Integer.MIN_VALUE;
        int min = 0;
        int week = 0;
        int month = 0;

        HashSet<Integer> Set = new HashSet<>();

        for(int i = 0; i< days.length;i++){
            Set.add(days[i]);
        }

        for(int i = 0; i < days.length;i++){
            max = Math.max(max, days[i]);
        }

        int[] dp = new int[max+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            if(Set.contains(i)){
                if( i - 7 > 0) week = dp[i-7];
                else week = dp[0];

                if(i - 30 > 0) month = dp[i-30];
                else month = dp[0];

                dp[i] = Math.min(costs[0] + dp[i-1], Math.min(costs[1] + week, costs[2] + month));
            }else{
                dp[i] = dp[i-1];
            }
        }

        return dp[dp.length-1];
        
    }
}

//TC: O(max element in days)
//SC: O(max element in days)

