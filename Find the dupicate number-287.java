class Solution {
    public int findDuplicate(int[] nums) {
        int dupNo=0;
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0){
                dupNo = Math.abs(nums[i]);
                break;
            }else{
                nums[index] = - Math.abs(nums[index]);
        }
    }
    return dupNo;
    }
}
O(n) with constant space.
