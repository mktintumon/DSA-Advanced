import java.util.*;

// similar code as count inversion --> result[a[i].idx] += b.length - j;

class countSmallerAfterSelf {
    
    class Pair{
            int idx;
            int val;
            
            Pair(int idx , int val){
                this.idx = idx;
                this.val = val;
            }
    }
    
    int result[];
    
    public List<Integer> countSmaller(int[] nums) {
        //we will keep the val and idx in pair -> 
        // as val changes in sorting but idx didnt
        Pair[] pairs = new Pair[nums.length];
        for(int i=0 ; i<pairs.length ; i++){
            pairs[i] = new Pair(i , nums[i]);
        }
        
        // stores how many element smaller after self
        result = new int[pairs.length];
        
        // decreasing order sorting --> we didint care about sorted array
        merge_Sort(pairs , 0 , pairs.length-1);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : result){
            ans.add(val);
        }
        
        return ans;
    }
    
    
    public Pair[] merge_Sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) {
            Pair[] base = new Pair[1];
            base[0] = arr[(int) lo];
            return base;
        }

        int mid = (lo + hi) / 2;

        Pair[] left = merge_Sort(arr, lo, mid);
        Pair[] right = merge_Sort(arr, mid + 1, hi);

        return mergeTwoSortedArrays(left, right);
    }
    
    
    
    public Pair[] mergeTwoSortedArrays(Pair[] a, Pair[] b) {
        Pair[] ans = new Pair[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i].val > b[j].val) {
                ans[k] = a[i];
                
                // this code is only different from count inversion
                result[a[i].idx] += b.length - j;
                
                i++;
                k++;
            } else {
                ans[k] = b[j];
                j++;
                k++;
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