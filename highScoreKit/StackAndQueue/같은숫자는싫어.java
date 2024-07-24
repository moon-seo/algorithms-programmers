package highScoreKit.StackAndQueue;

import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> s = new Stack<>();
        int i = 0;
        
        for (int num : arr) {
            if (s.isEmpty() || s.peek() != num) {
                s.push(num);
            }
        }
        
        int[] answer = new int[s.size()];
        int j = 0;
        for (Integer num : s) {
            answer[j++] = num;
        }
        
        return answer;
    }
}
