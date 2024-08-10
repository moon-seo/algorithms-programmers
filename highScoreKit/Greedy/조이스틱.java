package highScoreKit.Greedy;

class Solution {
    public int solution(String name) {
            
        char[] cName = name.toCharArray();
        int length = name.length();
        
        // 걍 따로따로
        // 블럭1에서는 좌우이동 횟수 따로 구하고
        // 블럭2에서는 상하이동 횟수 따로 구하고
        
        // 좌우이동 횟수 계산
        int horizontal = length - 1;    // 기본적으로 오른쪽으로만 가는 경우
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && cName[next] == 'A') {
                next++;
            }   // next는 연속된 ‘A’ 이후의 첫 번째 ‘A’가 아닌 문자의 위치
            // 현재 위치에서 오른쪽 끝까지 가서 다시 왼쪽으로 돌아오는 경우를 고려
            horizontal = Math.min(horizontal, i + length - next + Math.min(i, length - next));
        }
        
        // 상하이동 횟수 구하기
        int vertical = 0;
        for (char c : cName) {
            // 더 간결한 버전
            int up = c - 'A';
            int down = 1 + 'Z' - c;
            vertical += Math.min(up, down);
        }
        
        return horizontal + vertical;
    }
}