class longestHappyPrefix {

   // find LPS array of pattern->string

    public String longestPrefix(String s) {
        int[] LPS = new int[s.length()];
        
        int i = 1;
        int length = 0;
        
        while(i < LPS.length){
            
            if(s.charAt(i) == s.charAt(length)){
                LPS[i] = length + 1;
                length++;
                i++;
            }
            else if(length == 0){
                LPS[i] = 0;
                length = 0;
                i++;
            }
            else{
                length = LPS[length - 1];
            }
        }
        
        
        int k = LPS[s.length() - 1];
        return s.substring(0 , k);
    }
}
