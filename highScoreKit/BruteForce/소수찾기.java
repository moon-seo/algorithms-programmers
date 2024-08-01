package highScoreKit.BruteForce;

import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();  // 소수 저장
        permutation("", numbers, primes);
        return primes.size();
    }
    
    // 문자열로부터 순열 생성 & 소수면 해시셋에 저장
    public void permutation(String prefix, String remaining, Set<Integer> primes) {
        if (!prefix.isEmpty())     // prefix가 있으면
            if (isPrime(Integer.parseInt(prefix)))   // prefix가 소수인지 판별
                primes.add(Integer.parseInt(prefix));    // prefix가 소수면 해시셋에 추가
        
        for (int i = 0; i < remaining.length(); i++) // prefix에 숫자 붙이기
            permutation(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1, remaining.length()), primes);
    }
    
    // 소수 판별
    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) 
            if (num % i == 0)
                return false;
        
        return true;
    }
}
