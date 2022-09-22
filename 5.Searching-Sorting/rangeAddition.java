public class rangeAddition {
/* 
Given:
length = 5,
updates = 
[
[1,  3,  2],
[2,  4,  3],
[0,  2, -2]
]

return [-2, 0, 3, 5, 3]

Explanation:
Initial state:
[ 0, 0, 0, 0, 0 ]
After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]
After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]
After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]

*/
    
    public int[] getModifiedArray(int length, int[][] updates){
        int[] ans = new int[length];

        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int toAdd = update[2];

            ans[start] += toAdd;
            if(end + 1 < ans.length){
                ans[end + 1] -= toAdd;
            }
        }

        // prefix sum array will be ans array
        for(int i = 1; i < ans.length; i++){
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}