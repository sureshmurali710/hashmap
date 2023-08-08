class Solution {
    public int climbStairs(int n) {
        int p1 = 1;
        int p2 = 1;
        int sum = 0;

        if(n == 1) return 1;

        for(int i = 1; i < n;i++){
            sum = p1 + p2;
            p1 = p2;
            p2 = sum;
        }

        return sum;
        
    }
}
