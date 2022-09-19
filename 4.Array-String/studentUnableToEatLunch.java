class studentUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int countOne = 0;
        int countZero = 0;
        
        for(int val : students){
            if(val == 0) countZero++;
            else countOne++;
        }
        
        for(int val : sandwiches){
            if(val == 0){
                if(countZero == 0) return countOne;
                
                countZero--;
            }
            else{
                if(countOne == 0) return countZero;
                
                countOne--;
            }
        }
        
        return 0;
    }
}