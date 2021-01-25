package org.search.基本有序;

/**
 * @author: wangrui
 * @date: 2020/10/25
 *
 *
 */
public class erfenfa {

  public static void main(String[] args) {


  }
  public int two1(int[] array,int left,int right,int target){
    int mid=(left+right)/2;
    while(left<=right){
      if(array[mid]==target){
        return mid;

      }else if(array[mid]<target){
        left=mid+1;
      }else {
        right=mid-1;
      }
    }

  return -1;


  }


  public int two(int[] array,int right,int left,int target ){
    int mid=(left+right)/2;

    if(left>right){
      return -1;
    }
    if(array[mid]==target){
      return mid;
    }else  if(array[mid]<target){
      return two(array,mid+1,left,target);

    }else{
      return two(array,right,mid-1,target);
    }

  }

}
