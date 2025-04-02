// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

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