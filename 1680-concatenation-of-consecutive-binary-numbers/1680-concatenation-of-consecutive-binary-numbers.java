class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        int length = 0; // bit length of addends
        long result = 0; // long accumulator
        for (int i = 1; i <= n; i++) {
            // when meets power of 2, increase the bit length
            if (Math.pow(2, (int) (Math.log(i) / Math.log(2))) == i) {
                length++;
            }
            result = ((result * (int) Math.pow(2, length)) + i) % MOD;
        }
        return (int) result;
    }
}