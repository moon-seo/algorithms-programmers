package highScoreKit.Hash;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> m = new HashMap<>();
        // <옷종류, 해당종류의옷수>
        
        for (String[] s : clothes) {
            m.put(s[1], m.getOrDefault(s[1], 0) + 1);
        }
        
        for (String key : m.keySet()) {
            answer *= m.get(key) + 1;
        }   // 1을 더하는 이유는, 해당 종류의 옷을 아예 입지 않는 선택지도 포함하기 위함.
        answer -= 1;    // 아무것도 안 입은 경우 제외하기.
        
        return answer;
    }
}