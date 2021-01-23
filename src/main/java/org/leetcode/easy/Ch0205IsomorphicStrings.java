package org.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * <p> 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * <p> 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * <p> 示例 1:
 *
 * <p> 输入：s = "egg", t = "add"
 * <p> 输出：true
 *
 * <p> 示例 2：
 *
 * <p> 输入：s = "foo", t = "bar"
 * <p> 输出：false
 *
 * <p> 示例 3：
 *
 * <p> 输入：s = "paper", t = "title"
 * <p> 输出：true
 *
 *
 *
 * <p> 提示：
 *
 * <p>     可以假设 s 和 t 长度相同。
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/22
 */
public class Ch0205IsomorphicStrings {

  /**
   * <p> 此题是「290. 单词规律」的简化版，需要我们判断 s 和 t 每个位置上的字符是否都一一对应，即 s 的任意一个字符被 t 中唯一的字符对应，同时 t 的任意一个字符被 s 中唯一的字符对应。这也被称为「双射」的关系。
   *
   * <p> 以示例 2 为例，t 中的字符 a 和 r 虽然有唯一的映射 o，但对于 s 中的字符 o 来说其存在两个映射 {a,r}，故不满足条件。
   *
   * <p> 因此，我们维护两张哈希表，第一张哈希表 s2t 以 s 中字符为键，映射至 t 的字符为值，第二张哈希表 t2s 以 ttt 中字符为键，映射至 s
   * <p> 的字符为值。从左至右遍历两个字符串的字符，不断更新两张哈希表，如果出现冲突（即当前下标 index 对应的字符 s[index] 已经存在映射且不为 t[index] 或当前下标 index 对应的字符 t[index]
   * <p> 已经存在映射且不为 s[index]）时说明两个字符串无法构成同构，返回 false。
   *
   * <p> 如果遍历结束没有出现冲突，则表明两个字符串是同构的，返回 true 即可。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/tong-gou-zi-fu-chuan-by-leetcode-solutio-s6fd/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * ===============
   * <p> 时间复杂度：O(n)，其中 n为字符串的长度。我们只需同时遍历一遍字符串 s和 t 即可。
   * <p> 空间复杂度：O(∣Σ∣)，其中 Σ 是字符串的字符集。哈希表存储字符的空间取决于字符串的字符集大小，最坏情况下每个字符均不相同，需要 O(∣Σ∣) 的空间。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; ++i) {
      char x = s.charAt(i), y = t.charAt(i);
      if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
        return false;
      }
      s2t.put(x, y);
      t2s.put(y, x);
    }
    return true;
  }
}
