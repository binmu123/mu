package cn.neu.niuke.leetcode.arrayType;

import java.util.ArrayList;

public class Main1 {
    //从一个已排序的数组中移除重复的数组
	//从头开始遍历，时间复杂度为O（n）
	public static void removeDuplicate(int[] array){
		//空间复杂度有点高，可以直接使用原数组来进行修改
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(array[0]);
		for(int i=0;i<array.length-1;i++){
			if(array[i]!=array[i+1])
				arr.add(array[i+1]);
		}
		for(int i:arr)
			System.out.print(i+" ");
	}
	//变式  允许数字最大出现两次  也很简单，弄一个标志位，但是如果没有排序的话建议使用map
	public static void removeDuplicateII(int[] array){
		boolean flag=true;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(array[0]);
		for(int i=0;i<array.length-1;i++){
			if(array[i]!=array[i+1])
			{	arr.add(array[i+1]);
			    flag=true;
			}else if(array[i]==array[i+1]&&flag){
				arr.add(array[i+1]);
				flag=false;
			}
		}
		for(int i:arr)
			System.out.print(i+" ");
	}
	//变式的标志位来允许数组最多重复出现2次，方法挺好，但是扩展性太差，如果允许出现3次就无法适用了
	public static void removeDuplicateII2(int[] array){
		int index=2;
		for(int i=2;i<array.length;i++){//只需要把起始（就是i、index和index-x）改下
			if(array[i]!=array[index-2]){
				array[index++]=array[i];
			}
		}
		for(int i=0;i<index;i++)
			System.out.print(array[i]+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] array={1,1,2,3,3,3,3,4,4,4,5,6};
        removeDuplicateII2(array);
	}

}
