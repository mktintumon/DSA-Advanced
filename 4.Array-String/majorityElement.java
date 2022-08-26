class majorityElement {

    /*

     *  TC -> O(n)
     *  SC -> O(1)
     *  Given -> majority element with exists > n/2
     
     */

    public int majority_Element(int[] nums) {
        int count = 0;
        Integer me = null;
        
        for(int val : nums){
            // majority element cancels out non majority elements
            if(count == 0){
                me = val;
                count = 1;
            }
            else if(val == me){
                // next element is same as majority element
                count++;
            }
            else{
                // next element is not same as majority element
                count--;
            }
        }
        
        return me;
    }
}
