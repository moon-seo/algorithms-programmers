package highScoreKit.Greedy;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost); Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            int index = Arrays.binarySearch(reserve, lost[i]);
            if (index >= 0) { // 값이 있으면
                answer++; 
                lost[i] = -1; reserve[index] = -1; 
                continue;
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1)  // 이미 빌린 학생 건너뛰기  
                continue;   
            
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1)   // 이미 빌려준 학생 건너뛰기
                    continue;
                
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    reserve[j] = -1;    // lost[i] = -1; // 정렬된 배열이라 할 필요는 없음
                    answer++; break;
                }
            }
        }
        
        return answer;
    }
}