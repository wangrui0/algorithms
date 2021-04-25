package org.leetcode.leet1500.ch1450;

/**
 * <p>1422. 分割字符串的最大得分
 *
 * <p>给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * <p>「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "011101"
 * <p>输出：5
 * <p>解释：
 * <p>将字符串 s 划分为两个非空子字符串的可行方案有：
 * <p>左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * <p>左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * <p>左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * <p>左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * <p>左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 *
 * <p>示例 2：
 *
 * <p>输入：s = "00111"
 * <p>输出：5
 * <p>解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 *
 * <p>示例 3：
 *
 * <p>输入：s = "1111"
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= s.length <= 500
 * <p>    字符串 s 仅由字符 '0' 和 '1' 组成。
 *
 * <p>通过次数8,918
 * <p>提交次数16,465
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1422MaximumScoreAfterSplittingAString {

  public int maxScore(String s) {
    int res = 0, cnt1 = 0, cnt0 = 0;        //cnt1统计右边1的个数，同理cnt0左边0的个数
    for (int i = 0; i < s.length(); i++) {
      cnt1 += s.charAt(i) - '0';            //先统计1的个数
    }                                       //由于左右区域的数至少为1，所以i不能等于len-1
    for (int i = 0; i < s.length() - 1; i++) {  //点i分为左右两个区域
      if (s.charAt(i) == '0') {
        cnt0++;      //遇到01就统计，动态更新左右区域01个数
      } else {
        cnt1--;
      }
      res = Math.max(res, cnt0 + cnt1);
    }
    return res;
  }

  public int maxScore_3(String s) {
    char[] chs = s.toCharArray();
    int len = chs.length;
    int l = 0, r = 0;
    if (chs[0] == '0') {
      l++;
    }
    int max = l + r;
    for (int i = 1; i < len - 1; i++) {
      if (chs[i] == '1') {
        r--;
      } else {
        max = Math.max(max, ++l + r);
      }
    }
    if (chs[len - 1] == '1') {
      r--;
    }
    return max - r;
  }

  public static void main(String[] args) {
    System.out.println(maxScore_4("011101"));
  }
  public static int maxScore_4(String s) {
    int ans = 0, count0 = 0, count1 = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i)=='1'){
        count1++;
      }
    }
    for (int i = 0; i <s.length()-1 ; i++) {
      if(s.charAt(i)=='0'){
        count0++;
      }else{
        count1--;
      }
      ans=Math.max(ans,count0+count1);
    }
    return ans;

  }
}
