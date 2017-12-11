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
    
    
    
    
    //快排
    /**
     * 关键在于将数据分为两部分，取其中一位，保证左边的都小于它，右边都大于它
     * 这样递归下去就可以实现数据的整体有序，与归并不同的是它每次的两部分并不是相同大小的
     * 而实现的方法就是左右部分分别两个指针，左边的碰到比a[v]大的停下，右边碰到比a[v]小的停下
     * 最后两个指针指向的值交换(不断循环进行，直到两个指针相遇)
     * 相遇后交换a[lo]和a[j]
     */
    public static void quSort(int[] a,int left,int right){
    	int _left = left,_right=right;
    	int temp =0;
    	while(_left<right){
    		temp = a[left];
    		while(temp<=a[right] && left<right){
    			right--;
    		}
    		a[left]=a[right];
    		while(temp>=a[left] && left<right){
    			left++;
    		}
    		a[right]=a[left];
    	}
    	a[right]=temp;
    	quSort(a,left,_left-1);
    	quSort(a,_right+1,right);
    }
    public static void main(String[] args) {
		int[] a = {};
	}
}

