class 피자나눠먹기1 {
    public int solution(int n) {
        int answer = 0;
        
        // 전체조각수 = 피자판수 * 7
        // n명이니까 .. 전체 조각수 >= n
        // 피자판수 >= n / 7
        
        answer = (n % 7 == 0) ? (n / 7) : (n / 7 + 1);
        
        return answer;
    }
}