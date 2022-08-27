class longPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        
        while(i < typed.length()){
            if(j < name.length() && typed.charAt(i) == name.charAt(j)){
                i++;
                j++;
            } else if(i > 0 && typed.charAt(i) == typed.charAt(i - 1)){
                //pichle wale ke saath same h
                i++;
            } else {
                // t=ssaaedd  n=saeed
                return false; 
            }
        }
        
        return j == name.length(); // t=aalexx  n=alexa
    }
}
