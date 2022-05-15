public class coinChangeRecursive {

    public static int coinPermutateInfinity(int[] coins , int tar , String path){
        if(tar == 0){
            System.out.println(path);
            return 1;
        }

        int count = 0;
        for(int i=0 ; i<coins.length ; i++){
            if(tar - coins[i] >= 0){
              count += coinPermutateInfinity(coins , tar-coins[i] , path+coins[i]);
            }  
        }

        return count;
    }

    public static int coinsCombInfinity(int[] coins , int tar , int idx , String path){
        if(tar == 0){
            System.out.println(path);
            return 1;
        }

        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinsCombInfinity(coins, tar-coins[i], i , path + coins[i]);
            }
        }

        return count;
    }

    public static int coinsPermutateSingle(int[] coins , int tar , String path){
        if(tar == 0){
            System.out.println(path);
            return 1;
        }

        int count = 0;
        for(int i = 0; i<coins.length; i++){
            if(coins[i] > 0  &&  tar - coins[i] >= 0){ //  coins[i] < 0 --> visited
                int val = coins[i]; 

                //visited
                coins[i] = -coins[i];
                count += coinsPermutateSingle(coins, tar-val, path + val);
                coins[i] = -coins[i];
            }
        }

        return count;
    }

    public static int coinsCombSingle(int[] coins , int tar , int idx , String path){
        if(tar == 0){
            System.out.println(path);
            return 1;
        }

        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinsCombInfinity(coins, tar-coins[i], i+1 , path + coins[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int [] coins = {2,3,5,7};
        int tar = 10;

        //int ans = coinPermutateInfinity(coins , tar , "");
        //int ans = coinsCombInfinity(coins , tar , 0 , "");
        //int ans = coinsPermutateSingle(coins , tar , "");
        int ans = coinsCombSingle(coins , tar , 0 , "");
        System.out.println("Total count is -> " + ans);
    }
}
