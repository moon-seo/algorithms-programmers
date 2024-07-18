package highScoreKit.Hash;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> pokemons = new HashMap<>();
        // <종류, 해당종류포켓몬수> hashmap에서 key는 유니크해야함
        
        for(int i = 0; i < nums.length; i++) {
            int tmp = pokemons.getOrDefault(nums[i], 0);    // getOrDefault
            pokemons.put(nums[i], ++tmp);
        }
        
        int num = (nums.length) / 2;    // 내가 선택할 포켓몬 수
        
        // 1 <= answer <= N/2, pokemons.size()
        answer = (num < pokemons.size())? num : pokemons.size();    // 더 작은 거 선택
        
        return answer;
    }
}