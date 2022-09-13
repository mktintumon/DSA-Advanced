import java.util.*;

public class balanceArray {
    public int solve(ArrayList<Integer> A) {
        int oddSum = 0;
        int evenSum = 0;
        for(int i = 0; i < A.size(); i++){
            if(i % 2 == 0){
                evenSum += A.get(i);
            } else {
                oddSum += A.get(i);
            }
        }
        
        int leftOddSum = 0;
        int leftEvenSum = 0;
        int ans = 0;
        for(int i = 0; i < A.size(); i++){
            if(i % 2 == 0){
                int rightEvenSum = evenSum - leftEvenSum - A.get(i);
                int rightOddSum = oddSum - leftOddSum;
                
                if(leftOddSum + rightEvenSum == leftEvenSum + rightOddSum){
                    ans++;
                }
                
                leftEvenSum += A.get(i);
            } else {
                int rightEvenSum = evenSum - leftEvenSum;
                int rightOddSum = oddSum - leftOddSum - A.get(i);
                
                if(leftOddSum + rightEvenSum == leftEvenSum + rightOddSum){
                    ans++;
                }
                
                leftOddSum += A.get(i);
            }
        }
        
        return ans;
    }
}
