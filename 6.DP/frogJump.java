import java.util.*;

class frogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer , HashSet<Integer>> hm = new HashMap<>();

        for(int stone : stones){
            hm.put(stone , new HashSet<>());
        }

        hm.get(0).add(1); // seeding

        // travel till last second stone
        for(int i=0 ; i<stones.length-1 ; i++){
            int stone = stones[i];
            for(int step : hm.get(stone)){
                int reach = stone + step;

                if(reach == stones[stones.length-1]){
                    return true;
                }
                else if(hm.containsKey(reach) == true){
                    HashSet<Integer> steps = hm.get(reach);
                    if(step - 1 > 0) steps.add(step-1);
                    steps.add(step);
                    steps.add(step+1);
                }
            }
        }

        return false;
    }
}