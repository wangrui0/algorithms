package org.search.基本有序;

/**
 * @author: wangrui
 * @date: 2020/10/25
 */
public class MaoPao {

  public static void main(String[] args) {
    int[] a={2,1,2,6};

    maoPao(a);
  }

  public static void maoPao(int[] array){
    for (int i = 0; i <array.length-1 ; i++) {
      if(array[i]>array[i+1]){
        int a=array[i];
        array[i]=array[i+1];
        array[i+1]=a;
      }
    }

  }

}
