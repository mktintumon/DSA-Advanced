import java.util.*;

class largestNumberLC {
    
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i=0 ; i<strArr.length ; i++){
            strArr[i] = nums[i] + "";
        }
        
        Arrays.sort(strArr , (a,b) ->{
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1);
        });
        
        if(strArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String val : strArr){
            sb.append(val);
        }
        
        return sb.toString();
    }
}
