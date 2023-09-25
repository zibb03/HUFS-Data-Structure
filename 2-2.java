// 피보나치 수열을 계산하는 아래 fib 메소드를 작성하시오.
public static long fib(int n) { //n = 6
    int first = 0;
    int second = 1;
    int previous = 0;
    
    for (int i = 0; i <= n - 2; i++) { //0, 1, 2, 3, 4 >> 5회
        previous = first + second;
        first = second;
        second = previous;
    }
    
    return second;
}
