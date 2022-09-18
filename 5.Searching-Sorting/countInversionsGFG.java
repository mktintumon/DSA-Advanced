class countInversionsGFG {

    // merge sort code --> only add -> count += (a.length - i);

    static long count;

    public static long inversionCount(long arr[], long N) {
        count = 0;
        merge_Sort(arr, 0, arr.length - 1);
        return count;
    }

    public static long[] merge_Sort(long[] arr, int lo, int hi) {
        if (lo == hi) {
            long[] base = new long[1];
            base[0] = arr[(int) lo];
            return base;
        }

        int mid = (lo + hi) / 2;

        long[] left = merge_Sort(arr, lo, mid);
        long[] right = merge_Sort(arr, mid + 1, hi);

        return mergeTwoSortedArrays(left, right);
    }

    // used for merging two sorted arrays
    public static long[] mergeTwoSortedArrays(long[] a, long[] b) {
        long[] ans = new long[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                ans[k] = a[i];
                i++;
                k++;
            } else {
                ans[k] = b[j];
                j++;
                k++;

                count += (a.length - i);
            }
        }

        while (i < a.length) {
            ans[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            ans[k] = b[j];
            k++;
            j++;
        }

        return ans;
    }
}
