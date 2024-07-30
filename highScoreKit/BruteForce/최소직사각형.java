package highScoreKit.BruteForce;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0; int height = 0;
        int maxWidth = 0; int maxHeight = 0;
        
        for (int[] size : sizes) {
            width = Math.max(size[0], size[1]);
            height = Math.min(size[0], size[1]);

            if (width > maxWidth)
                maxWidth = width;

            if (height > maxHeight)
                maxHeight = height;
        }
        
        int answer = maxWidth * maxHeight;
        return answer;
    }
}
