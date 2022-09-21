class shortestPalindrome {

    public String shortest_Palindrome(String str) {

        String newStr = str + "$" + new StringBuilder(str).reverse().toString();
    
        int[] lps = new int[newStr.length()];
        int len = 0;
        int i = 1;
        while(i < lps.length){
            if(newStr.charAt(i) == newStr.charAt(len)){
                lps[i] = len + 1;
                len++;
                i++;
            } else if(len > 0){
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                len = 0;
                i++;
            }
        }

        // longest palindrome prefix present at this idx
        int k = lps[lps.length - 1];
        String right = str.substring(k);
        
        return new StringBuilder(right).reverse().toString() + str;
    }
}