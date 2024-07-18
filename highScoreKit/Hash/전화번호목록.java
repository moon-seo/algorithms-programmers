package highScoreKit.Hash;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numbers = new HashSet<>();
        
        for (String s : phone_book) {
            numbers.add(s);
        }
        
        for (String s : phone_book) {
		        // s의 접두어가 되려면, s보다 길이가 짧은 문자열이어야 한다.
		        // s가 다른 전화번호(문자열)를 접두어로 가지고 있었는지 확인한다.
            for (int i = 1; i < s.length(); i++) {
                if (numbers.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}