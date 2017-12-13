package sortTest;

public class SellectSort {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
		HeapSort.HeapSortCore(arr);
		for(int ele:arr){
			System.out.print(ele+" ");
		}
	}
	
	//1.堆排序(形成堆结构，每次输出最值，剩下的元素继续形成堆结构，重复输出完成排序)
	public static class HeapSort{
		//一次筛选过程，保证父节点值大于子节点
		private static void HeapAdjust(int[] arr,int parent,int length){
			int temp = arr[parent];//保存当前根节点
			int child = 2*parent+1;//获得左孩子(2*n+1,完全二叉树性质)
			//存在孩子节点
			while(child<length){
				//存在右孩子节点且右孩子大于左孩子，则替换选取右孩子
				if(child+1<length && arr[child+1]>arr[child]){
					child++;
				}
				//父节点最大，平衡状态，直接退出
				if(temp>arr[child])
					break;
				//把子节点值赋给父节点
				arr[parent]=arr[child];
				//选取孩子节点及该孩子的左孩子节点，继续向下搜索
				parent = child;
				child = 2*child+1;
			}
			//最初元素归为当前节点值
			arr[parent]=temp;
		}
		
		public static void HeapSortCore(int[] arr){
			//循环筛选前一半元素以初始化堆
			for(int i=arr.length/2;i>=0;i--){
				HeapAdjust(arr, i, arr.length);
			}
			//进行n-1次循环，保证输出最大值后剩下的元素再次形成堆结构
			for(int i=arr.length-1;i>0;i--){
				//R[0]与R[i]交换(不断输出最大值)
				int temp=arr[i];
				arr[i]=arr[0];
				arr[0]=temp;
				//将剩下的i-1个元素重新筛选成堆结构
				HeapAdjust(arr, 0, i);
			}
		}
	}
	
	
	
	
}
