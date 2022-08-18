import java.util.*;

/*  Learning from this question

 * Adding in arrayList at Particular index -> ans.add(0 , v) -> ans.add(1, v)
 * Sort ArrayList - > Collections.sort(ans)
 * Reverse ArrayList - > Collections.reverse(ans)
 
    --> adding v to the 0-th index because adding in post-order
    --> after all dfs calls JFK comes at last -> so adding in front is neccessary
    --> working like stack

    otherwise just add normally -> ans.add(v)
    and at last reverse the ArrayList
    
 */

class reconstruct_Itinerary {
    // lexical order of nbr -> need PQ
    HashMap<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();

        // making graph -> 
        // tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        for (List<String> t : tickets) {
            String src = t.get(0);
            String dest = t.get(1);

            if (map.containsKey(src) == true) {
                map.get(src).add(dest);
            } else {
                // not present
                map.put(src, new PriorityQueue<>());
                map.get(src).add(dest);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        dfs("JFK", ans);
        return ans;
    }

    public void dfs(String v, ArrayList<String> ans) {
        // reached destination
        if (map.containsKey(v) == false || map.get(v).size() == 0) {
            ans.add(0, v);
            return;
        }

        while (map.get(v).size() > 0) {
            String newSrc = map.get(v).remove();
            dfs(newSrc, ans);
        }

        //post-order working
        ans.add(0, v);
    }

    // Alternate implementation of dfs

    // public void dfs(String v, List<String> ans){
    //     while(map.containsKey(v) == true && map.get(v).size() > 0){
    //         String nbr = map.get(v).remove();
    //         dfs(nbr, ans);
    //     }
    //     ans.add(0, v);
    // }
}