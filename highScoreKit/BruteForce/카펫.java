package highScoreKit.BruteForce;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int width = 0; int height = 0;  // width >= height
        // brown = 2w + 2h - 4 -> w+h = (brown+4)/2
        // yellow = (h - 2) * (w - 2) = wh - 2(w+h) - 4 
        // wh = brown + yellow
        
        int sum = (brown + 4) / 2;
        int mul = brown + yellow;
        
        for(int h = 1; h < sum; h++) {
            int w = sum - h;
            if (w * h == mul) {
                width = w; height = h;
                break;
            }
        }
        
        return new int[]{width, height};
    }
}