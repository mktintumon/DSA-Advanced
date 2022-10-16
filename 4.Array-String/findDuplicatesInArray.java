import java.util.*;

class findduplicatesInArray {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
       ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }
        
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) >= 2)
                ans.add(i);
        }
        
        if(ans.size() > 0) return ans;
        else{
            ans.add(-1);
            return ans;
        }
    }
}