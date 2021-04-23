package org.leetcode.shunxu.leet2000.ch1550;

/**
 * <p>1528. 重新排列字符串
 *
 * <p>给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * <p>请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * <p>返回重新排列后的字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * <p>输出："leetcode"
 * <p>解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abc", indices = [0,1,2]
 * <p>输出："abc"
 * <p>解释：重新排列后，每个字符都还留在原来的位置上。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "aiohn", indices = [3,1,4,2,0]
 * <p>输出："nihao"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * <p>输出："arigatou"
 *
 * <p>示例 5：
 *
 * <p>输入：s = "art", indices = [1,0,2]
 * <p>输出："rat"
 *
 *
 *
 * <p>提示：
 *
 * <p>    s.length == indices.length == n
 * <p>    1 <= n <= 100
 * <p>    s 仅包含小写英文字母。
 * <p>    0 <= indices[i] < n
 * <p>    indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 *
 * <p>通过次数26,330
 * <p>提交次数33,624
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/shuffle-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1528ShuffleString {

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N为字符串 s 的长度。我们只需对字符串 s执行一次线性扫描即可。
   *
   * <p>   空间复杂度：O(1) 或 O(N)O(N)O(N)。除开辟的存储答案的字符串外，我们只需要常数空间存放若干变量。如果使用的语言不允许对字符串进行修改，我们还需要 O(N) 的空间临时存储答案。
   *
   * @param s
   * @param indices
   * @return
   */
  public String restoreString(String s, int[] indices) {
    int length = s.length();
    char[] result = new char[length];

    for (int i = 0; i < length; i++) {
      result[indices[i]] = s.charAt(i);
    }
    return new String(result);
  }
//    string restoreString(string s, vector<int>& indices) {
//    int length = s.length();
//    for (int i = 0; i < length; i++) {
//      if (indices[i] != i) {
//        char ch = s[i]; // 当前需要被移动的字符
//        int idx = indices[i]; // 该字符需要被移动的目标位置
//        while (idx != i) {
//          swap(s[idx], ch); // 使用 swap 函数，在覆写 s[idx] 之前，先将其原始值赋给变量 ch
//          swap(indices[idx], idx); // 将封闭路径中的 indices 数组的值设置成下标自身
//        }
//        // 退出循环后，还要再覆写起点处的字符
//        s[i] = ch;
//        indices[i] = i;
//      }
//    }
//    return s;


}
