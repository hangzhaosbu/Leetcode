class Solution {
    public boolean isPowerOfFour(int n) {
        //log4(n) = log10(n)/log10(4)
        return Math.log10(n)/Math.log10(4) % 1 == 0;
    }
}