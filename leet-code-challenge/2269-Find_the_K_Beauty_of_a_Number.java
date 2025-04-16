// The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

// It has a length of k.
// It is a divisor of num.
// Given integers num and k, return the k-beauty of num.

// Note:

// Leading zeros are allowed.
// 0 is not a divisor of any value.
// A substring is a contiguous sequence of characters in a string.

 

// Example 1:

// Input: num = 240, k = 2
// Output: 2
// Explanation: The following are the substrings of num of length k:
// - "24" from "240": 24 is a divisor of 240.
// - "40" from "240": 40 is a divisor of 240.
// Therefore, the k-beauty is 2.
// Example 2:

// Input: num = 430043, k = 2
// Output: 2
// Explanation: The following are the substrings of num of length k:
// - "43" from "430043": 43 is a divisor of 430043.
// - "30" from "430043": 30 is not a divisor of 430043.
// - "00" from "430043": 0 is not a divisor of 430043.
// - "04" from "430043": 4 is not a divisor of 430043.
// - "43" from "430043": 43 is a divisor of 430043.
// Therefore, the k-beauty is 2.

class Solution {
    public static int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;

        for (int i = 0; i <= numStr.length() - k; i++) {
            String subStr = numStr.substring(i, i + k);
            int subNum = Integer.parseInt(subStr);

            if (subNum != 0 && num % subNum == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int num1 = 240, k1 = 2;
        int num2 = 430043, k2 = 2;

        System.out.println("K-beauty of" + num1 + "with k=" + k1 + ":" + divisorSubstrings(num1, k1));
        System.out.println("K-beauty of" + num2 + "with k=" + k2 + ":" + divisorSubstrings(num2, k2));
    }
}