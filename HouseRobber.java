//tree

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return helper(0, 0, nums);   
    }

    private int helper(int index, int amount, int[] nums){
        //base
        if(index >= nums.length) return amount;

        //logic
        
        //choose
        int case1 = helper(index+2, amount+nums[index], nums);

        //not choose
        int case2 = helper(++index, amount, nums);

        return Math.max(case1, case2);
        
    }
}

//dp array

class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i = 1; i< nums.length; i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); //skip
                dp[i][1] = nums[i] + dp[i-1][0];
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        
    }
}

//two variable
class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int skip = 0;
        int take = nums[0];

        for(int i = 1; i< nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i] + temp;
            
        }

        return Math.max(skip, take);
        
    }
}
