package highScoreKit.StackAndQueue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        boolean decrease = false;

        for (int i = 0; i < prices.length; i++) {
            decrease = false;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    decrease = true;
                    answer[i] = j - i;
                    break;
                }
            }
            if (!decrease) {
                answer[i] = (prices.length - 1) - i;
            }
        }

        return answer;
    }
}