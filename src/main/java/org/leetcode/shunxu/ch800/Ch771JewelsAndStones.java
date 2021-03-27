package org.leetcode.shunxu.ch800;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>771. 宝石与石头
 *
 * <p> 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * <p>J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * <p>示例 1:
 *
 * <p>输入: J = "aA", S = "aAAbbbb"
 * <p>输出: 3
 *
 * <p>示例 2:
 *
 * <p>输入: J = "z", S = "ZZ"
 * <p>输出: 0
 *
 * <p>注意:
 *
 * <p>    S 和 J 最多含有50个字母。
 * <p>     J 中的字符不重复。
 *
 * <p>通过次数136,777
 * <p>提交次数160,799
 * <p>https://leetcode-cn.com/problems/jewels-and-stones/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch771JewelsAndStones {

  /**
   * <p>  复杂度分析
   *
   * <p> 时间复杂度：O(mn)，其中 m 是字符串 jewels 的长度，nnn 是字符串 stones 的长度。遍历字符串 stones 的时间复杂度是 O(n)，
   * <p> 对于 stones 中的每个字符，需要遍历字符串jewels 判断是否是宝石，时间复杂度是 O(m)，因此总时间复杂度是 O(mn)。
   *
   * <p> 空间复杂度：O(1)。只需要维护常量的额外空间。
   *
   * @param jewels
   * @param stones
   * @return
   */
  public int numJewelsInStones(String jewels, String stones) {
    int jewelsCount = 0;
    int jewelsLength = jewels.length(), stonesLength = stones.length();
    for (int i = 0; i < stonesLength; i++) {
      char stone = stones.charAt(i);
      for (int j = 0; j < jewelsLength; j++) {
        char jewel = jewels.charAt(j);
        if (stone == jewel) {
          jewelsCount++;
          break;
        }
      }
    }
    return jewelsCount;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(m+n)，其中 m 是字符串 jewels 的长度，n 是字符串 stone 的长度。遍历字符串 jewels 将其中的字符存储到哈希集合中，
   * <p>  时间复杂度是 O(m)，然后遍历字符串 stones，对于stones 中的每个字符在 O(1) 的时间内判断当前字符是否是宝石，时间复杂度是 O(n)，因此总时间复杂度是 O(m+n)。
   * <p> 空间复杂度：O(m)，其中 m 是字符串 jewels 的长度。使用哈希集合存储字符串 jewels\ 中的字符。
   *
   * @param jewels
   * @param stones
   * @return
   */
  public int numJewelsInStones_2(String jewels, String stones) {
    int jewelsCount = 0;
    Set<Character> jewelsSet = new HashSet<Character>();
    int jewelsLength = jewels.length(), stonesLength = stones.length();
    for (int i = 0; i < jewelsLength; i++) {
      char jewel = jewels.charAt(i);
      jewelsSet.add(jewel);
    }
    for (int i = 0; i < stonesLength; i++) {
      char stone = stones.charAt(i);
      if (jewelsSet.contains(stone)) {
        jewelsCount++;
      }
    }
    return jewelsCount;
  }

  public int numJewelsInStones_3(String jewels, String stones) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < jewels.length(); i++) {
      set.add(jewels.charAt(i));
    }
    int count = 0;
    for (int i = 0; i < stones.length(); i++) {
      if (set.contains(stones.charAt(i))) {
        count++;
      }
    }
    return count;
  }


}
