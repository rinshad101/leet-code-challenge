// Given a string s, return whether s is a valid number.

// For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

// Formally, a valid number is defined using one of the following definitions:

// An integer number followed by an optional exponent.
// A decimal number followed by an optional exponent.
// An integer number is defined with an optional sign '-' or '+' followed by digits.

// A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:

// Digits followed by a dot '.'.
// Digits followed by a dot '.' followed by digits.
// A dot '.' followed by digits.
// An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

// The digits are defined as one or more digits.

 

// Example 1:

// Input: s = "0"

// Output: true

// Example 2:

// Input: s = "e"

// Output: false

// Example 3:

// Input: s = "."

// Output: false

class Solution {
    public static boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                numSeen = true;
                if (eSeen) numAfterE = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numAfterE = false;
            } else {
                return false; 
            }
        }

        return numSeen && numAfterE;
    }

    public static void main(String[] args) {
        String[] validNumbers = {
            "2", "0089", "-0.1", "+3.14", "4.", "-.9",
            "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"
        };
        String[] invalidNumbers = {
            "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", ".", "e"
        };

        System.out.println("Valid numbers:");
        for (String s : validNumbers) {
            System.out.println(s + ": " + isNumber(s));
        }

        System.out.println("\nInvalid numbers:");
        for (String s : invalidNumbers) {
            System.out.println(s + ": " + isNumber(s));
        }
    }
}