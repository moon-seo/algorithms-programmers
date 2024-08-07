package highScoreKit.Greedy;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int front = 0;  // 맨 앞 인덱스
        int back = people.length - 1;   // 맨 뒤 인덱스
        
        while (front <= back) {
            if (people[front] + people[back] <= limit) {
                answer++;
                front++; back--;
            }
            else {  // people[front] + people[back] > limit
                answer++;   // people[back]은 혼자 타야 됨
                back--;
            }
        }
        
        return answer;
    }
}