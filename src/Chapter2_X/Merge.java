package Chapter2_X;

/**
 * Created by xie on 2017/4/23.
 *归并
 *
 */
public class Merge {  
	
	
	   public static void main(String[] args) {
		   int[] a = {6,8,1,9,43,12,51,3,10};
		  //mergeSortCore(a,0,a.length-1);
		   quSort(a,0,a.length-1);
		   for(Integer ele:a){
			   System.out.print(ele+" ");
		   }
	   }
	//1.合并(两个有序数组合并成一个)
    private static void mergeSort(int[] a,int low,int mid,int high){
    	int i = low,j = mid+1,k=0;
    	int[] temp = new int[high-low+1];//排序后接受存储数据的临时数组
    	
    	while(i<=mid && j<=high){	//将更小的入栈
    		if(a[i]<a[j]){
    			temp[k]=a[i];
    			i++;k++;
    		}else{
    			temp[k]=a[j];
    			j++;k++;
    		}
    	}
    	while(i<=mid){		//剩下的全部入栈（如果有）
    		temp[k]=a[i];
			i++;k++;
    	}
    	while(j<=high){		//剩下的全部入栈（如果有）
    		temp[k]=a[j];
    		j++;k++;
    	}
    	for(k=0;k<temp.length;k++){		//输出至原数组
    		a[low+k]=temp[k];
    	}
    }
    //2.分治
    private static void mergeSortCore(int[] a,int low,int high){
    	if(low==high){
    		return;
    	}
    	int mid = (low+high)/2;		//分成两个数组
    	mergeSortCore(a,low,mid);	//左半部分递归调用
    	mergeSortCore(a,mid+1,high);//右半部分递归调用
    	mergeSort(a,low,mid,high);	//当前数组(递归回来时已部分有序)的排序
    }
    


	
    //快排
    /**
     * 关键在于将数据分为两部分，取其中一位，保证左边的都小于它，右边都大于它
     * 这样递归下去就可以实现数据的整体有序，与归并不同的是它每次的两部分并不是相同大小的
     * 而实现的方法就是左右部分分别两个指针，左边的碰到比a[v]大的停下，右边碰到比a[v]小的停下
     * 最后两个指针指向的值交换(不断循环进行，直到两个指针相遇)
     * 相遇后交换a[lo]和a[j]
     */
    
    
    public static void quSort(int[] a,int _left,int _right){
    	int left = _left,right=_right;
    	int temp =0;
    	if(left<right){	//两指针相遇表示完成一次重排序
    		temp = a[left];	//保存基点值
    		while(left != right){	
    			while(temp<=a[right] && left<right){	//右指针若大于基点值，继续左移
    				right--;
    			}
    			a[left]=a[right];	//右指针小于基点，停下并与将值“拆”下，“补”到左指针处
    			while(temp>=a[left] && left<right){
    				left++;
    			}
    			a[right]=a[left];	//左边同理向右移
    		}
    		a[right]=temp;			//基点元素重新放回中间位置
    		quSort(a,_left,left-1);	//左半部分递归调用
    		quSort(a,right+1,_right);//右半部分递归调用
    	}
    }
}

