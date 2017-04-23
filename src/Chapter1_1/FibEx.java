package Chapter1_1;

/**
 * Created by xie on 2017/4/11.
 * 菲波那切数列的求值
 */
public class FibEx {
    public static long F(int N)  //未优化，巨慢(因为每一次都会重复计算前面的所有数据)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static long Fib(int N) //优化，用一个数组存储已经算好的值，后一步直接调用即可
    {
        long[] f = new long[N+1];
        return Fib(N, f);
    }

    public static long Fib(int N, long[] f) //实际的递归流程
    {
        if (f[N] == 0)
        {
            if (N == 1)
                f[N] = 1;
            else if (N > 1)
                f[N] = Fib(N-1, f) + Fib(N-2, f);
        }

        return f[N];
    }

    public static void main(String[] args)
    {
//        for (int N = 0; N < 100; N++)
//            StdOut.println(N + " " + F(N));
        for (int N = 0; N < 100; N++)
             System.out.println(N + "---- " + Fib(N));
    }
}
