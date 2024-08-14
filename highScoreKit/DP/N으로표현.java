package highScoreKit.DP;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        HashSet<Integer>[] numbers = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            numbers[i] = new HashSet<>();   // i개의 N으로 만들 수 있는 숫자들을 저장하는 HashSet
            sb.append(N);
            numbers[i].add(Integer.parseInt(sb.toString()));   // 연산기호 없이 숫자 N만으로 이루어진 숫자 넣기
        }
        
        // 연산기호 사용해서 나오는 숫자들 저장하기
        for (int i = 1; i < 9; i++) {   // N을 몇 개 쓸 건지 (numbers[1]은 할 필요 없으므로 건너뜀(인 줄 알았는데 이러면 answer = N인 경우를 못잡으므로 i = 1부터 해야 한다.))
            for (int j = 1; j < i; j++) {   // 그중에서 몇 개의 N만을 가지고 하나의 숫자를 만들건지 aka 한 덩어리 숫자 중 제일 큰 숫자가 몇 개의 N으로 이루어져 있는지 (e.g. j = 3면 NNN)
                
                // j개의 N으로 만든 숫자들이 이미 있는 상태에서,, 우리는 (i-j)개의 N을 더 써야 하므로,
                // j개의 N으로 만든 숫자들에 (i-j)개의 N을 이용한 연산을 덧붙이는 형식으로, 총 i개의 N으로 만들 수 있는 숫자들을 찾아보자.
                for (int a : numbers[j]) {  // 전체 j개의 N으로 만들 수 있는 숫자들
                    for (int b : numbers[i - j]) {  // 연산에 사용할 수 있는 남은 N의 개수(i-j)로 만들 수 있는 숫자들
                        numbers[i].add(a + b);
                        numbers[i].add(a - b);
                        numbers[i].add(a * b);
                        if (b != 0)
                            numbers[i].add(a / b);
                        // -와 /의 경우 a와 b의 순서에 따라 값이 바뀔 수 있지만, 어차피 (i-j)의 값이 반복문을 돌며 계속 바뀔 것이기 때문에 한쪽에서 값이 들어가므로 굳이 중복해서 a-b와 b-a를 매번 넣어줄 필요는 없다.
                    }
                }
            }
            
            if (numbers[i].contains(number))
                return i;
        }
        
        return -1;
    }
}