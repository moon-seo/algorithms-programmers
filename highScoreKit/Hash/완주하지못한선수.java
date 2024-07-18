package highScoreKit.Hash;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> hm = new HashMap<>();  
        // <참가자이름, 해당이름을가진사람수>
        
        for (String p : participant) {
            // if (hm.containsKey(p))
            //     hm.put(p, hm.get(p) + 1);      
            // else
            //     hm.put(p, 1);
            
            // 한 줄의 코드로 묶었다.
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            if (hm.get(c) == 1) {
                hm.remove(c);
            }
            else {
                hm.put(c, hm.get(c) - 1);
            }
        }
        
        String answer = "";
        
        for (String name : hm.keySet()) {
            answer = name;
        }
        
        return answer;
    }
}