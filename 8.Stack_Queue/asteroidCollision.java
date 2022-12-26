import java.util.*;

class asteroidCollision {
    
    public int[] asteroid_Collision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<asteroids.length ; i++){
            int e = asteroids[i];
            
            if(st.size() == 0){
                st.push(e);
            }
            else if(e > 0){
                st.push(e);
            }
            else if(st.peek() < 0){
                st.push(e);
            }
            else{
                // now peek is +ve and e is -ve

                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(e)){
                    st.pop();
                }

                if(st.size() == 0){
                    // 2,5,7,-8
                    st.push(e);
                }
                else if(st.peek() < 0){
                    // -5,2,5,7,-8
                    st.push(e);
                }
                else if(st.peek() == Math.abs(e)){
                    // +5,-5
                    st.pop();
                }
                else if(st.peek() > Math.abs(e)){
                    // -5,12,2,-8
                    // DO NOTHING
                }
            }
        }

        int[] ans = new int[st.size()];
        for(int i=ans.length-1 ; i>=0 ; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}
