class reverseVowels {

    public String reverse_Vowels(String s) {
        String check = "aeiouAEIOU";
        
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = sb.length()-1;
        
        while(left < right){
            while(left < right && check.indexOf(sb.charAt(left)) == -1){
                left++;
            }
            
            while(left < right && check.indexOf(sb.charAt(right)) == -1){
                right--;
            }
            
            char temp = sb.charAt(left);
            sb.setCharAt(left , sb.charAt(right));
            sb.setCharAt(right , temp);
            
            left++;
            right--;
        }
        
        return sb.toString();
    }
}