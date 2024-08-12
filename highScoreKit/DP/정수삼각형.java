package highScoreKit.DP;

public class Solution {
    public int solution(int[][] triangle) {
        
        // DP 테이블 초기화
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        // 삼각형의 꼭대기에서 시작하여 DP 테이블을 초기화
        dp[0][0] = triangle[0][0];
        
        // 타뷸레이션을 사용하여 DP 테이블 채우기
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 왼쪽 끝
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    // 오른쪽 끝
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    // 중간 부분
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        // DP 테이블의 마지막 행에서 최대값을 찾기
        int answer = 0;
        for (int value : dp[triangle.length - 1]) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}