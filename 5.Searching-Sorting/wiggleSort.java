class wiggleSort {

    // just swap the neigbour odd - even indexes

    public static void convertToWave(int n, int[] a) {
        // if not given sorted -> just sort
        for(int i = 1; i<a.length ; i += 2){
            if(i<a.length){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
    }
}
