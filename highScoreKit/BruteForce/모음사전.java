package highScoreKit.BruteForce;

class Solution {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1}; // 각 자리의 가중치
        char[] letters = {'A', 'E', 'I', 'O', 'U'};
        int position = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (c == letters[j]) {
                    position += weights[i] * j;
                    break;
                }
            }
            position++; // 현재 자리의 단어 포함
        }

        return position;
    }
}