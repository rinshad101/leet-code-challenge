// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

var reverse = function (x) {
  const INT_MAX = 2 ** 31 - 1;
  const INT_MIN = -(2 ** 31);

  let rev = 0;
  let sign = x < 0 ? -1 : 1;
  x = Math.abs(x);

  while (x !== 0) {
    let digit = x % 10;
    x = Math.floor(x / 10);

    if (
      rev > Math.floor(INT_MAX / 10) ||
      (rev === Math.floor(INT_MAX / 10) && digit > 7)
    ) {
      return 0;
    }
    if (
      rev < Math.ceil(INT_MIN / 10) ||
      (rev === Math.ceil(INT_MIN / 10) && digit > 8)
    ) {
      return 0;
    }

    rev = rev * 10 + digit;
  }

  return rev * sign;
};

console.log(reverse(123)); // Output: 321
console.log(reverse(-123)); // Output: -321
console.log(reverse(120)); // Output: 21
console.log(reverse(1534236469)); // Output: 0 (overflow case)
