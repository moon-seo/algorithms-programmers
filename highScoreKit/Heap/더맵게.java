package highScoreKit.Heap;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       
        for (int s : scoville) 
            pq.add(s);
        
        while (true) {
            if (pq.peek() >= K) 
                break;
                
            else {
                if (pq.size() == 1) 
                    return -1;
                
                pq.add(pq.poll() + pq.poll() * 2);
                answer++;
            }
        }   
        
        return answer;
    }
}