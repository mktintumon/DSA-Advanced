class majorityElement {

    // If majority element definetily exists
    public int majority_Element(int[] nums) {
        int count = 0;
        Integer me = null;

        for (int val : nums) {
            // majority element cancels out non majority elements
            if (count == 0) {
                me = val;
                count = 1;
            } else if (val == me) {
                // next element is same as majority element
                count++;
            } else {
                // next element is not same as majority element
                count--;
            }
        }

        return me;
    }

    // If majority element may or may not exists

    /*
     * MOORE VOTING ALGORITHM
        This is a two-step process:
      
        1)  The first step gives the element that may be the majority element in the
            array. If there is a majority element in an array, then this step will
            definitely return majority element, otherwise, it will return candidate for
            majority element.
        
        2)  Check if the element obtained from the above step is the majority element.
            This step is necessary as there might be no majority element.
     */

    public int majority_Element(int a[], int size) {
        int count = 0;
        int me = -1;
        for (int val : a) {
            if (count == 0) {
                me = val;
                count = 1;
            } else if (val == me) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < size; i++) {
            if (me == a[i]) {
                count++;
            }
        }

        // System.out.println(count);
        if (count > size / 2)
            return me;
        else
            return -1;
    }
}
