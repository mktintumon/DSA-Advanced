import java.util.*;

class intersectionOfIntervals {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length){
            int low = Math.max(firstList[i][0] , secondList[j][0]);
            int high = Math.min(firstList[i][1] , secondList[j][1]);
            
            // equal sign required for adding -> [[5,5],[24,24],[25,25]]
            if(low <= high){
                ans.add(new int[]{low, high});
            }
            
            // kisko aage badhaye --> i ko ya j ko ?? --> move smaller interval
            if(firstList[i][1] < secondList[j][1]){
                i++; 
            }
            else{
                j++;
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}