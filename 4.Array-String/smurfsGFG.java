class smurfsGFG {

    /* Three colors of smurfs -> R , G , B
     * The smurfs possess a very magical property.
     * When two smurfs of different colors meet with other,
     * they gets converted into a smurf of the third color.
     * How many minimum number of smurfs will be remaining
     * after this transformation? The question looked
     * simple to geek. However, the smurfs put another constraint
     * to make the geek think more. The two smurfs must be
     * adjacent to each other to make the transformation take place.
     * There are n smurfs the colors of which are given in an array a[].
     */

    static int minFind(int n, String a[]) {
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].charAt(0) == 'G')
                g++;
            if (a[i].charAt(0) == 'R')
                r++;
            if (a[i].charAt(0) == 'B')
                b++;
        }

        // LOGIC
        if (r == n || g == n || b == n)
            return n;
        if (r % 2 == 0 && g % 2 == 0 && b % 2 == 0)
            return 2;
        if (r % 2 == 1 && g % 2 == 1 && b % 2 == 1)
            return 2;
        return 1;

    }
}