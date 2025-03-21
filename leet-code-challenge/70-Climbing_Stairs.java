class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 1; i <= n-2; i++){
            int t = a+b;
            a = b;
            b = t;
        }
        return b;

    }
}