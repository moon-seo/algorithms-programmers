package highScoreKit.BruteForce;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstPattern = {1, 2, 3, 4, 5};
        int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        int[] count = new int[3];   
        
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int first = firstPattern[i % firstPattern.length];
            int second = secondPattern[i % secondPattern.length];
            int third = thirdPattern[i % thirdPattern.length];
            
            if(first == answer)
                count[0]++;
            if(second == answer)
                count[1]++;
            if(third == answer)
                count[2]++;
        }
        
        int max = 0;
        List<Integer> winners = new ArrayList<>();
        
        for(int i = 0; i < count.length; i++) {
            if (count[i] > max)
                max = count[i];
        }
        for(int i = 0; i < count.length; i++) {
            if (count[i] == max)
                winners.add(i + 1);
        }
        
        return winners.stream().mapToInt(Integer::intValue).toArray();
    }
}