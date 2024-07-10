import java.util.Arrays;

class 중앙값구하기 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[array.length / 2];   
        // array.length >> 1 시프트연산도 가능 (성능 더 좋음. 큰 차이는 없지만)
        return answer;
    }
}