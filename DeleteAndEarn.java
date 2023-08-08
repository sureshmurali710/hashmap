class Solution {
    public int deleteAndEarn(int[] nums) {
        //o(n) + max element in the arr 

        int max = Integer.MIN_VALUE;

        for(int i = 0; i< nums.length; i++){
            max = Math.max(nums[i], max);
        }

        int[] helper_arr = new int[max+1];

        int skip = 0;
        int take = 0;
        

        for(int num: nums){
            helper_arr[num] += num;
        }

        for(int i = 1; i< helper_arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = helper[i] + temp;
        }

        return Math.max(skip, take);
        
    }
}
