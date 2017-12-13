package sortTest;

public class InsertSort {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
		ShellSort.sortCore(arr);
		for(Integer ele:arr){
			System.out.print(ele+" ");
		}
	}
	//1.简单插入排序，像一个有序序列中不断插入元素o(n2)
		//选择排序，插入排序等
	
	//2.shell排序(属于插入排序)，逐步缩小增量      多种增量序列供选择{n/2,(n/2)/2,...,1}等   最差O(n2)
	public static class ShellSort{
		public static void sortCore(int[] arr){
			//逐步缩小增量gap
			for(int gap=arr.length/2;gap>0;gap/=2){
				//将数组分成以gap为步长的多个数组，逐个对小分组进行直接插入排序
				for(int i=gap;i<arr.length;i++){
					int j = i;
					//左边元素大于右边，交换继续
					while(j-gap>=0 && arr[j]<arr[j-gap]){
						swap(arr,j,j-gap);
						j-=gap;
					}
				}
			}
		}
		private static void swap(int[] arr,int a,int b){
			  arr[a] = arr[a]+arr[b];
	          arr[b] = arr[a]-arr[b];
	          arr[a] = arr[a]-arr[b];
		}
	}
	
	
	
}
