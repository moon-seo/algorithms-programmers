class Solution {
    public int solution(int[] array) {
        // 값의 범위가 0부터 999이므로 크기가 1000인 배열을 생성
        int[] count = new int[1000];
        
        // 배열을 순회하면서 각 숫자의 등장 횟수를 count 배열에 기록
        for (int num : array) {
            count[num]++;
        }
        
        // 최빈값과 그 등장 횟수를 저장할 변수
        int mode = -1;  // 최빈값은 영어로 mode
        int maxCount = 0;
        boolean multipleModes = false;
        
        // count 배열을 순회하면서 최빈값과 그 등장 횟수를 찾음
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
                multipleModes = false; // 새로운 최빈값이 발견되면 다시 초기화
            } else if (count[i] == maxCount) {
                multipleModes = true; // 최빈값이 여러 개인 경우 플래그 설정
            }
        }
        
        // 최빈값이 여러 개면 -1 반환, 아니면 최빈값 반환
        return multipleModes ? -1 : mode;
    }
}