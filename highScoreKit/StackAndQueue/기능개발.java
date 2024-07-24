package highScoreKit.StackAndQueue;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] answer = new int[progresses.length];
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int answerIndex = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }  
        
        while (!q.isEmpty()) {
            for (int i = q.peek(); i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while (!q.isEmpty() && progresses[q.peek()] >= 100) {
                q.remove();
                count++;
            }
            if (count > 0) {
                answer[answerIndex++] = count;
                count = 0;
            }
        }
        
        // 배열 0 전까지 어떻게 잘라야 할지 모르겠어
        int n = 0;
        for (int num : answer) {
            if (num != 0)  n++;
        }
        int[] realAnswer = new int[n];
        for (int i = 0; i < n; i++) {
            realAnswer[i] = answer[i];
        }
        
        return realAnswer;
    }
}