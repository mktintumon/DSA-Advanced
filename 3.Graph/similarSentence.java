import java.io.*;
import java.util.*;

public class similarSentence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine());

        String[] sentence1 = br.readLine().split(" ");
        String[] sentence2 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());

        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
            pairs[i] = br.readLine().split(" ");
        }

        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

    }

    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;

    public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        // making self sets of given similar words
        for (int i = 0; i < pairs.length; i++) {
            if (parent.containsKey(pairs[i][0]) == false) {
                parent.put(pairs[i][0], pairs[i][0]);
                rank.put(pairs[i][0], 0);
            }

            if (parent.containsKey(pairs[i][1]) == false) {
                parent.put(pairs[i][1], pairs[i][1]);
                rank.put(pairs[i][1], 0);
            }
        }

        // making sets of given similar words
        for (int i = 0; i < pairs.length; i++) {
            String s1 = find(pairs[i][0]);
            String s2 = find(pairs[i][1]);

            if (s1.equals(s2) == false) {
                union(s1, s2);
            }
        }

        // sentences are of different lengths
        if(Sentence1.length != Sentence2.length) {
            return false;
        }

        for(int i=0 ; i < Sentence1.length ; i++) {
            String w1 = Sentence1[i];
            String w2 = Sentence2[i];

            // words not exist in the hashmap
            if(w1.equals(w2)){
                continue;
            } else if(parent.containsKey(w1) == false  || parent.containsKey(w2) == false){
                return false;
            }

            String w1Lead = find(w1);
            String w2Lead = find(w2);

            if(w1Lead.equals(w2Lead) == false){
                return false;
            }
        }

        return true;

    }

    public static String find(String x) {
        if (parent.get(x).equals(x)) {
            return x;
        } else {
            String parentOfX = parent.get(x);
            String setLead = find(parentOfX);
            parent.put(x, setLead);
            return setLead;
        }
    }

    public static void union(String x, String y) {
        if (rank.get(x) < rank.get(y)) {
            parent.put(x, y);
        } else if (rank.get(y) < rank.get(x)) {
            parent.put(y, x);
        } else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }

}
