package Chapter2_1;

/**
 * Created by xie on 2017/4/13.
 * 选择排序:不断地选择剩下元素的最小值
 */
public class Selection {
    public static void sort(Comparable[] a ){
        int N = a.length;
        for(int i=0;i<N;i++){
            int min = i;      //最小元素的索引
            for(int j=i+1;j<N;j++){
//                if(a[j]<a[i]) min = j;    //最小元素索引的重新赋值
//            exch(a[i],a[j]);              //交换两个数
            }

        }
    }
}

//插入排序:斗地主时你是怎么整理牌的？
class Insertion{
    public static void sort(Comparable[] a ){
        int N = a.length;
        for(int i=1;i<N;i++){     //每个元素向前比较
//            for(int j=i;j>0 && less(a[j],a[j-1]) ;j--){    //less()中a[j] > a[j-1] 则返回false 反之为true
//                exch(a[j],a[j-1]);                  //未达到跳出循环的条件则将 j 前移一位(严格意义上是j-1后移一位，一开始就把j独立保存)
//            }
        }
    }
}
