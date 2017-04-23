package Chapter2_1;

/**
 * Created by xie on 2017/4/18.
 */
//希尔排序  思想是将数组变成多个相隔h的有序数组,最终(h=1时)使用插入排序将局部有序的数组进行排序
// 排序之初子数组都很短且都是部分有序的，这两个特点适合插入排序
public class Shell {
   public static void sort(Comparable[] a){
       int N = a.length;
       int h = 1;
       while(h < N/3) h = 3*h + 1; //1 4 13 40 .....
       while(h >= 1){
           for(int i=h;i<N;i++){
              // for(int j=i;j >= h && less(a[j],a[j-h]);j-=h){
              //     exch(a,j,j-h);    //less()比较两个数大小，exch()交换两个数位置
             //  }
           }
           h = h/3;
       }
   }
}
