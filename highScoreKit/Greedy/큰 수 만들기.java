package highScoreKit.Greedy;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        
        for (int i = 0; i < length; i++) {
            char current = number.charAt(i);    
            // toCharArray로 char[] 배열로 변환해도 되지만, 배열 변환 없이 charAt()를 바로 사용하는 방법도 있다.
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                // 스택이 차 있고, 
                // 아직 제거할 숫자 개수가 남아 있고(k > 0),
                // 현재 자리 숫자(current)의 바로 앞 자리 숫자(stack.peek())가 현재 자리의 숫자보다 작다면,
                // -> 그 숫자 빼고, (그 숫자보다 큰)현재 숫자를 스택에 집어 넣기
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        
        // 아직 제거할 숫자가 남아 있다면(k > 0) 뒤에서부터 제거한다.
        // (제거할 숫자가 남아있다는 것은 스택에 숫자들이 너무 많이 들어갔다는 것이고, 
        // 이는 스택에 넣어진 숫자들이 54321처럼 큰 숫자부터 내림차순으로 되어 있다는 것을 의미한다. 
        // -> 따라서 가장 작은 숫자(맨 뒤 숫자)부터 제거해야 한다.)
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택의 내용을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}