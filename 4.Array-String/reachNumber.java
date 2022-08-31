class reachNumber {
    /*
      APPROACH --> 1 (Little slower than approach - 2)

      GIVEN --> target and start from n = 0
            --> for n -->  sum = n(n+1) / 2 --> Range = ( -sum to +sum)
            --> (Nature means ODD or EVEN)
            --> If target is within range
                --> if sum = ODD 
                        -> target Nature is also ODD --> its ans
                --> if sum = EVEN
                        -> target Nature is also EVEN --> its ans         
    */   
                  
    public int reach_Number_1(int target) {
        int n = 0;
        target = Math.abs(target);
        int targetNature = target % 2;
        
        while(true){
            int range = (n*(n+1))/2;
            int rangeNature = range % 2;
            
            if(target <= range){
                if(targetNature == rangeNature){
                    break;
                }
            }
            n++;
        }
        
        return n;
    }

    // APPROACH -- > 2 (FASTER)
    public int reachNumber_2(int target) {
        int sum = 0;
        int jump = 1;
        target = Math.abs(target);
        
        while(sum < target){
            sum += jump;
            jump++;
        }
        if((sum - target) % 2 == 0){
            return jump - 1;
        }else if((sum + jump - target) % 2 == 0){
            return jump;
        }
        else
            return jump + 1;
        
    }

}
