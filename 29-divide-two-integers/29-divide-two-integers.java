class Solution {
    private static int HALF_INT_MIN = -1073741824;// -2**30;

    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        ArrayList<Integer> doubles = new ArrayList<>();
        ArrayList<Integer> powersOfTwo = new ArrayList<>();

        int powerOfTwo = -1;
        while (divisor >= dividend) {
            doubles.add(divisor);
            powersOfTwo.add(powerOfTwo);
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        int quotient = 0;

        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) >= dividend) {
                quotient += powersOfTwo.get(i);
                dividend -= doubles.get(i);
            }
        }

        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}