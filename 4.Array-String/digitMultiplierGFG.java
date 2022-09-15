
class digitMultiplierGFG {

    static String getSmallest(Long N) {
        StringBuilder sb = new StringBuilder();
        
        if(N < 10) return N + ""; // self
        
        // ulta check krenge so we get smaller number
        for(int div = 9 ; div > 1 ; div--){
            while(N % div == 0){
                N = N / div;
                sb.append(div);
            }
        }
        
        // N >= 10 and N = prime
        if(N >= 10) return "-1";
        
        return sb.reverse().toString();
    }
};
