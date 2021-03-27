package org.leetcode.shunxu.ch800;

import java.util.Arrays;

/**
 * 一、应用场景-字符串匹配问题 字符串匹配问题:
 * <p>
 * 有一个字符串 str1= ““硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好””，和一个子串 str2=“尚硅谷你尚硅你” 现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
 *
 * @author: wangrui
 * @date: 2021/3/27
 */
public class Ch796ViolenceMatch {

  /**
   * <p> 暴力匹配算法实现
   * <p>如果用暴力匹配的思路，并假设现在 str1 匹配到 i 位置，子串 str2 匹配到 j 位置，则有:
   *
   * <p> 如果当前字符匹配成功(即str1[i]==str2[j])，则i++，j++，继续匹配下一个字符
   * <p>如果失配(即str1[i]!=str2[j])，令i=i-(j-1)，j=0。相当于每次匹配失败时，i回溯，j被置为0。
   * <p>用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量
   * <p>的时间。(不可行!)
   * <p>暴力匹配算法实现.
   * 代码
   *
   * @param str1
   * @param str2
   * @return
   */
  private static int violenceMatch(String str1, String str2) {
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();

    int s1Len = s1.length;
    int s2Len = s2.length;

    int i = 0; // i索引指向s1
    int j = 0; // j索引指向s2

    while (i < s1Len && j < s2Len) {// 保证匹配时，不越界
      if (s1[i] == s2[j]) {//匹配 ok
        i++;
        j++;
      } else { //没有匹配成功
        //如果失配(即 str1[i]! = str2[j])，令 i = i - (j - 1)，j = 0。
        i = i - (j - 1);
        j = 0;
      }
    }

    //判断是否匹配成功
    if (j == s2Len) {
      return i - j;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    String str1 = "BBC ABCDAB ABCDABCDABDE";
    String str2 = "ABCDABD";
    //String str2 = "BBC";
    int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
    System.out.println("next=" + Arrays.toString(next));
    int index = kmpSearch(str1, str2, next);
    System.out.println("index=" + index); // 15 了

  }


  /**
   * @param str1 源字符串
   * @param str2 子串
   * @param next 部分匹配表, 是子串对应的部分匹配表
   * @return 如果是-1 就是没有匹配到，否则返回第一个匹配的位置
   */
  public static int kmpSearch(String str1, String str2, int[] next) {
    //遍历
    for (int i = 0, j = 0; i < str1.length(); i++) {
      //需要处理 str1.charAt(i) != str2.charAt(j), 去调整 j 的大小
      //KMP 算法核心点, 可以验证...
      while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
        j = next[j - 1];
      }

      if (str1.charAt(i) == str2.charAt(j)) {
        j++;
      }
      if (j == str2.length()) {//找到了 // j = 3 i
        return i - j + 1;
      }
    }
    return -1;
  }

  //获取到一个字符串(子串) 的部分匹配值表
  public static int[] kmpNext(String dest) {
    //创建一个 next 数组保存部分匹配值
    int[] next = new int[dest.length()];
    next[0] = 0; //如果字符串是长度为 1 部分匹配值就是 0
    for (int i = 1, j = 0; i < dest.length(); i++) {
      //当 dest.charAt(i) != dest.charAt(j) ，我们需要从 next[j-1]获取新的 j
      //直到我们发现 有 dest.charAt(i) == dest.charAt(j)成立才退出
      //这时 kmp 算法的核心点
      while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
        j = next[j - 1];
      }

      //当 dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
      if (dest.charAt(i) == dest.charAt(j)) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }

}
