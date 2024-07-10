class 짝수는싫어요 {
    public int[] solution(int n) {
        int num = 0;    // num은 홀수 개수
        
        if (n % 2 == 0)
            num = n / 2;
        else
            num = n / 2 + 1;
        
        int[] answer = new int[num];
        
        for (int i = 0; i < num; i++)
            answer[i] = 2 * i + 1;
        
        return answer;
    }
}

/* 
아래 처럼 그냥 바로바로 계산하면서 홀수를 출력하는 방법도 있는데,
내 방법의 시간 복잡도는 O(num)이고, 아래 방법의 시간 복잡도는 O(n)이다.
num은 n의 약 1/2배이므로, 내 방법이 더 빠르긴 하지만,
n의 범위가 1~100으로 주어졌고, n이 엄청 큰 수는 아니기 때문에 사실상 별로 차이는 없다.
그래도 잘한 건 잘한 거야 ~~~

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i % 2 == 1){
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}
*/
