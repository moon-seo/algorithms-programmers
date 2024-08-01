package highScoreKit.BruteForce;

class Solution {
    private int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        goAdventure(dungeons, k, 0, visited);
        return maxCount;
    }
    
    public void goAdventure(int[][] dungeons, int k, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                goAdventure(dungeons, k - dungeons[i][1], count+1, visited);
                visited[i] = false;
            }
        }
    }
}