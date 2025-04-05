// An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

// Given an integer n, return true if n is an ugly number.

 

// Example 1:

// Input: n = 6
// Output: true
// Explanation: 6 = 2 × 3
// Example 2:

// Input: n = 1
// Output: true
// Explanation: 1 has no prime factors.
// Example 3:

// Input: n = 14
// Output: false
// Explanation: 14 is not ugly since it includes the prime factor 7.

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        int[] divisors = {2, 3, 5};
        for (int d : divisors) {
            while (n % d == 0) {
                n /= d;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUgly(6));
        System.out.println(sol.isUgly(1));
        System.out.println(sol.isUgly(14));
    }
}