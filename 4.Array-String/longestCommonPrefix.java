class longestCommonPrefix{

    // GFG -> EASY
    String longestCommon_Prefix(String arr[], int n){
        int j = 0;
    
         while(j < arr[0].length())
         {
         char ch = arr[0].charAt(j);
         for(int i = 1 ; i < n ; i++)
         {
             if(j < arr[i].length() && arr[i].charAt(j) == ch ) 
             {
                continue;
             }
             else 
             {
                 if(j == 0) return "-1";
                 return arr[i].substring(0,j);
             }
             
         }
         j++;
     }
     
     return arr[0].substring(0,j);
    
    }
}