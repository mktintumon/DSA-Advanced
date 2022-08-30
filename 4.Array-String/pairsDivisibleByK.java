class pairsDivisibleByK {
    // O(n)
    public int numPairsDivisibleBy60(int[] time){
        // K = 60
        int[] map = new int[60];
        
        int count = 0;
        for(int num : time){
            int val = num%60;
            if(val == 0){
                count += map[0];
            }
            else{
                count += map[60-val];
            }
            
            map[val]++;
        }
        
        return count;
    }
}

/* 
---------> TLE

public int numPairsDivisibleBy60(int[] time) {
    int n = time.length;
    int count = 0;
    for(int i=0 ; i<n ; i++){
        for(int j=i+1 ; j<n ; j++){
            int val = time[i] + time[j];
            if(val % 60 == 0){
                count++;
            }
        }
    }
    
    return count;
}

*/
