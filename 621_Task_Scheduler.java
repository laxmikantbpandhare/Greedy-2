    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/task-scheduler/
    Time Complexity for operators : o(n) .. n is the length of the nums array
    Extra Space Complexity for operators : o(1) Hashmap is size of 26 which is constant
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create a hashmap which has frequency of elememnts. Also, main maxFreq variable to get maximum frequnce.
                    B) then, iterate thru hashmap values to check is it has multiple characters that has same frequence.
                    C) At last calculate, partition, empty, pending, idle
                    D) Return idle + tasks.length.
    */ 
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> hm = new HashMap<>(26);
        
        int maxFreq = 0;
        int maxCount = 0;
        for(char x : tasks){
            hm.put(x, hm.getOrDefault(x,0)+1);
            if(hm.get(x) > maxFreq){
                maxFreq = hm.get(x);
            }
        }
        
        for(int x : hm.values()){
            if(x == maxFreq){
                maxCount += 1;
            }
        }
        
        int partition = maxFreq - 1;
        int empty = (n - (maxCount - 1)) * partition;
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty-pending);
        
        return idle + tasks.length;
    }
}