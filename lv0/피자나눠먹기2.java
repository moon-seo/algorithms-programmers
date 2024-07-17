class 피자나눠먹기2 {
    public int solution(int n) {
        int answer = 0;
        
        // 전체조각수 = 6 * 판수 = n * 인당조각수
        // 전체조각수 = 6과 n의 최소공배수
        // 판수 = (6과 n의 최소공배수) / 6
        // lcm = (a * b) / gcd
        
        // int gcd = (6 > n) ? gcd(6, n) : gcd(n, 6);
        // 둘 중에 큰 수가 어디에 오는지는 상관 없음. 어차피 결과 똑같아짐!!
        
        int gcd = gcd(6, n);
        answer = n / gcd; // = (6 * n) / gcd / 6
        
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else {
            // int tmp = b;
            // b = a % b;
            // a = tmp;
            // return gcd(a, b);

            // 한 줄로 간결화 가능
            return gcd(b, a % b);
        }
    }

    /*
    이 방법도 가능! 
    근데 내 방법(유클리드호제법)의 시간 복잡도는 O(log(min(a,b)))=O(logn)이고,
    이 방법은 (최악의 경우) O(n)이라 내 방법이 더 빠르긴 하다.
    근데 이렇게 쉽고 간단하게 접근할 수도 있다는 거 기억하기!!!

    public int solution(int n) {
        int answer = 1;

        while(true){
            if(6*answer%n==0) break;
            answer++;
        }

        return answer;
    }
    */
}