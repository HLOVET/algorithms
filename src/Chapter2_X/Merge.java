package Chapter2_X;

/**
 * Created by xie on 2017/4/23.
 *归并排序:分而治之的思想，将问题不断分化，解决最小的那个
 *大规模的归并只需分解调用merge方法
 */
public class Merge {  //最小规模的归并   最小规模的数据必须是已排序的   
    static int [] aux; //辅助数组
    /*
    * a:要排序的数组
    * lo,mid,hi组成了a[lo...mid]  和 a[mid+1....hi]这两个待归并的数组
    * */
    public static void merge(int[] a,int lo,int mid,int hi){
    	int i = lo,j = mid+1;
    	for(int k=lo;k<=hi;k++){
    		aux[k] = a[k];    //将a[lo...hi]复制到aux[lo...hi]
    	}
    	for(int k=lo;k<hi;k++){
    		if(i<mid) a[k]=aux[j++];		//两半数组有一半先完
    		else if(j>hi) a[k]=aux[i++];
    		else if(aux[i]<aux[j]) a[k]=aux[i++];  //归并过程
    		else a[k]=aux[j++];
    	}
    }
    
    
    
    
    //快速排序
    /**
     * 关键在于将数据分为两部分，取其中一位，保证左边的都小于它，右边都大于它
     * 这样递归下去就可以实现数据的整体有序，与归并不同的是它每次的两部分并不是相同大小的
     * 而实现的方法就是左右部分分别两个指针，左边的碰到比a[v]大的停下，右边碰到比a[v]小的停下
     * 最后两个指针指向的值交换(不断循环进行，直到两个指针相遇)
     * 相遇后交换a[lo]和a[j]
     */
    //一次切分排序，最后的结果是对于这个切分点来说，左边的都比他小，右边的都比他大
    public static void partition(int[] a,int lo,int hi){
    	//将数组分成a[lo..i-1] a[i] a[i+1...hi]
    	int i = lo,j = hi+1;
    	int v = a[lo];    //取得第一个为切分点
    	int temp;
    	while(true){
    		while(a[++i]<v){
    			if(i==hi) break; //寻找左边符合条件的值
    		}
    		while(a[--j]>v){	//一直寻找右边符合添加的值
    			if(j==lo) break;
    		}
    		if(i>=j) break;	//相遇条件
    		temp = a[i];  //左右两边满足条件后交换这两个值
    		a[i] = a[j];
    		a[j] = temp;
    	}
    	temp = a[lo];  //最后将切分点与相遇点交换
    	a[lo] = a[j];
    	a[j] = temp;
    }
}

