package highScoreKit.StackAndQueue;

import java.util.*;

class Solution {
    boolean solution(String s) throws EmptyStackException {
        
        // 스택에서 (는 넣고, )는 빼고
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        
        try {
            for (char c : array) {
                if (c == '(') {
                    stack.push(1);
                }
                else {  // c == ')'
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                return false;
            }
        } catch(EmptyStackException e) {
            return false;
        }

        return true;
    }
}
