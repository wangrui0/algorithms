package org.leetcode.leet500.ch450;

import java.util.List;

/**
 * <p>有效的单词方块
 * <p>给定一个单词序列，检查它是否构成有效的单词方块。
 * <p>如果第k行和第k列读取完全相同的字符串，其中0≤k<max（numRows，numColumns），则一个单词序列形成一个有效的单词正方形。
 * <p>注：
 * <p>给出的字数至少为1，且不超过500。
 * <p> 字长至少为1且不超过500。
 * <p>每个单词只包含小写英文字母a-z。
 * <p> 例1：
 * <p> 输入：
 * <p>[
 * <p>   “abcd”,
 * <p>   “bnrt”,
 * <p>   “crmy”,
 * <p>   “dtye”
 * <p>]
 * <p>输出：
 * <p>是的
 * <p>说明：
 * <p> 第一行和第一列都是“abcd”。
 * <p>第二行和第二列都是“bnrt”。
 * <p>第三行和第三列都是“crmy”。
 * <p>第四行和第四列都是“dtye”。
 * <p> 因此，它是一个有效的平方字。
 * <p> 例2：
 * <p> 输入：
 * <p>[
 * <p>  “abcd”,
 * <p>  “bnrt”,
 * <p>“crm”,
 * <p>“dt”
 * <p>]
 * <p>说明：
 * <p> 第一行和第一列都是“abcd”。
 * <p> 第二行和第二列都是“bnrt”。
 * <p>第三行和第三列都是“crm”。
 * <p>第四行和第四列都是“dt”。
 * <p> 因此，它是一个有效的平方字。
 * <p>例3：
 * <p> 输入：
 * <p>[
 * <p> “ball”,
 * <p> “area”,
 * <p> “read”,
 * <p> “lady”
 * <p> ]
 * <p>输出：
 * <p>假
 * <p> 说明：
 * <p>第三行读“read”，第三列读“lead”。
 * <p>因此，它不是一个有效的单词方块。
 * <p> https://leetcode-cn.com/problems/valid-word-square/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch422ValidWordSquare {

  public boolean validWordSquare(List<String> words) {
    if (words.size() == 0) {
      return true;
    }
    if (words.size() != words.get(0).length()) {
      return false;
    }

    for (int i = 0; i < words.size(); i++) {
      String tempStr = words.get(i);
      if (tempStr.length() > words.size()) {
        return false;
      }
      for (int j = 0; j < tempStr.length(); j++) {
        if (words.get(j).length() <= i) {
          return false;
        }
        if (words.get(j).charAt(i) != tempStr.charAt(j)) {
          return false;
        }

      }
    }

    return true;
  }

  /**
   * 题解：
   *
   * 检查是否关于对角线对称.
   *
   * 每一个char 都要检查一遍. 这里注意内层loop j 不是从 i 开始而是从0开始.
   *
   * 原本想只检查右上部分在左下部分是否有对称即可，但忽略了这里不一定size是对称的，如果左下有这个char而右上没有这个char就不能检测出false.
   *
   * Time Complexity: O(m * n). m = words.size(). n 是最长string的length.
   *
   * Space: O(1).
   * @param words
   * @return
   */
  public boolean validWordSquare2(List<String> words) {
    if (words == null || words.size() == 0) {
      return true;
    }
    int m = words.size();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        if (j >= m || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }
}

