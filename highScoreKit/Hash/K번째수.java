package highScoreKit.Hash;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        
        for (int n = 0; n < commands.length; n++) {
            int index = 0;

            int[] tmp = new int[commands[n][1]-commands[n][0]+1];
            for (int i = commands[n][0]-1; i < commands[n][1]; i++) {
                tmp[index++] = array[i];
            }
            // 아래 한 줄로 배열 복사 코드(반복문) 대체 가능
            // int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

            Arrays.sort(tmp); 
            answer[answerIndex++] = tmp[commands[n][2]-1];  // 뒤에 -1 하는 거 잘 보기...
        }
        
        return answer;
    }
}