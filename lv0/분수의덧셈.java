class 분수의덧셈 {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        // int[] answer = {};
        // 배열이 빈 배열로 초기화되어 있으므로 각 요소에 접근하려고 할 때 예외가 발생한다.
        // 배열의 크기를 미리 지정해야 한다.
        int[] answer = new int[2];

        int a = denum1 * num2 + denum2 * num1;
        int b = num1 * num2;

        int gcd = gcd(a, b);
        answer[0] = a / gcd;
        answer[1] = b / gcd;

        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
