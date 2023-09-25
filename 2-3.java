public class memo {
    // public static void main(String[] args) {
    //     java.lang.System.out.println("안녕");
    //     java.lang.System.err.println("hello");
    // }

    static long[] memo = new long[71];
    public static long fib(int n) {
        // static long[] memo;
        if (n <= 1)
            return n;
        else if (memo[n] != 0)
            return memo[n];
        else
            return memo[n] = fib(n - 1) + fib(n - 2);
// 		long[] a = new long[n + 1];
// 		long result = 0;

// 		if (n <= 0) {
// 			a[0] = 0;
// 			return 0;
// 		}
// 		else if (n == 1) {
// 			a[1] = 1;
// 			return 1;
// 		}
		
// 		if (a[n - 2] != 0) {
// 			result = fib(n - 1) + a[n - 2];
// 			a[n] = result;
// 			return result;
// 		}
		
// 		result = fib(n - 1) + fib(n - 2);
// 		a[n] = result;
// 		return result;
    }
    // 코드 참조
    // https://hanhyx.tistory.com/34
    //근데 메모이제이션을 왜 밖에서 배열 범위 정해주고 함..
    //main 못건드리고

    public static void main(String[] args) {
        // all: for(int i = 0; i<10; i++) {
        //     outer: for(int j = 0; j<10; j++) {
        //         if(j>=5) {
        //             break outer;
        //         }
        //         System.out.println(i + " " + j);
        //     }
        // }

        // int a = 0;
        // int b = 7;
        // int c = (a + b) / 2;
        // int d = (a + b + 1) / 2;
        // System.out.println(c);
        // System.out.println(d);
        System.out.println(fib(70));
    } 
}