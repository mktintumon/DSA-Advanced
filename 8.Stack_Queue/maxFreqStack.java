import java.util.*;

class maxFreqStack {
    HashMap<Integer , Integer> freqMap;
    HashMap<Integer , Stack<Integer>> dataMap;
    int maxFreq;

    public maxFreqStack() {
        freqMap = new HashMap<>();
        dataMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        //increase freq. of val ---> put in freqMap --> update maxFreq
        int freq = freqMap.getOrDefault(val ,0) + 1;
        freqMap.put(val , freq);
        maxFreq = Math.max(freq , maxFreq);

        //putting in dataMap
        if(dataMap.containsKey(freq) == false){
            dataMap.put(freq , new Stack<>());
        }
        dataMap.get(freq).push(val);
    }
    
    public int pop() {
        // popping maxfreq val from stack --> reducing freq in freqMap
        int val = dataMap.get(maxFreq).pop();

        if(dataMap.get(maxFreq).size() == 0){
            maxFreq--;
        }

        freqMap.put(val , freqMap.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
