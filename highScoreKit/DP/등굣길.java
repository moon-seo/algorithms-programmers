package highScoreKit.DP;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // dp 테이블 정의
        int[][] dp = new int[m + 1][n + 1]; // 해당 인덱스 위치까지 도달할 수 있는 (최단)경로 개수
        dp[1][1] = 1;   // 출발 위치
        
        // dp 테이블에서 웅덩이 있는 곳은 갈 수 없으니까 -1으로 표시
        for (int[] puddle : puddles) {
		        // HashSet 삭제한 대신 dp테이블로 웅덩이도 관리해야 한다.
            dp[puddle[0]][puddle[1]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {   // 웅덩이가 있는 곳이라면
                    dp[i][j] = 0;   // 값이 -1인 상태 그대로라면 나중에 이 값을 더하게 될 때 경로 개수가 오히려 줄어드는 문제가 발생한다.
                }
                else {  // 웅덩이 있는 곳이 아니라면(= 정상 길이라면)
                    if (i != 1) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j != 1) {
                        dp[i][j] += dp[i][j-1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        
        // int answer = dp[m][n] % 1000000007;
        // return answer;
        return dp[m][n];
    }
}