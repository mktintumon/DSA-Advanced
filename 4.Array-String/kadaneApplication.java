class kadaneApplication {

    static int getVal(char[] x, int[] b, char c) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == c) {
                return b[i];
            }
        }
        return (int) c; // type cast
    }

    static String maxSum(String w, char x[], int b[], int n) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int idx = 0;
        int strStart = 0;
        int strEnd = 0;

        for (int i = 0; i < w.length(); i++) {
            currSum += getVal(x, b, w.charAt(i));

            if (currSum < 0) {
                currSum = 0;
                idx = i + 1;
            } else if (currSum > maxSum) {
                maxSum = currSum;
                strStart = idx;
                strEnd = i;
            }
        }

        return w.substring(strStart, strEnd + 1);
    }
}