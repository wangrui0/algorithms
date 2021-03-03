package org.leetcode.shunxu.ch400;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*** <p>387. 字符串中的第一个唯一字符
 *
 * <p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * <p> 示例：
 *
 * <p> s = "leetcode"
 * <p> 返回 0
 *
 * <p> s = "loveleetcode"
 * <p> 返回 2
 *
 *
 *
 * <p>提示：你可以假定该字符串只包含小写字母。
 * <p>https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch387FirstUniqueCharacterInAString {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是字符串 s 的长度。我们需要进行两次遍历。
   *
   * <p>   空间复杂度：O(∣Σ∣)，其中 ∣Σ∣ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public int firstUniqChar(String s) {
    Map<Character, Integer> frequency = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < s.length(); ++i) {
      if (frequency.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是字符串 s 的长度。第一次遍历字符串的时间复杂度为 O(n)，第二次遍历哈希映射的时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，因此 O(∣Σ∣)
   * <p>  在渐进意义下小于 O(n)，可以忽略。
   *
   * <p> 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public int firstUniqChar2(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      char ch = s.charAt(i);
      if (position.containsKey(ch)) {
        position.put(ch, -1);
      } else {
        position.put(ch, i);
      }
    }
    int first = n;
    for (Map.Entry<Character, Integer> entry : position.entrySet()) {
      int pos = entry.getValue();
      if (pos != -1 && pos < first) {
        first = pos;
      }
    }
    if (first == n) {
      first = -1;
    }
    return first;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 是字符串 s 的长度。遍历字符串的时间复杂度为 O(n)，而在遍历的过程中我们还维护了一个队列，
   * <p>     由于每一个字符最多只会被放入和弹出队列最多各一次，因此维护队列的总时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，
   * <p>     因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
   *
   * <p>    空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射以及队列。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
   * <p>  来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public int firstUniqChar3(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    Queue<Pair> queue = new LinkedList<Pair>();
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      char ch = s.charAt(i);
      if (!position.containsKey(ch)) {
        position.put(ch, i);
        queue.offer(new Pair(ch, i));
      } else {
        position.put(ch, -1);
        while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
          queue.poll();
        }
      }
    }
    return queue.isEmpty() ? -1 : queue.poll().pos;
  }

  class Pair {

    char ch;
    int pos;

    Pair(char ch, int pos) {
      this.ch = ch;
      this.pos = pos;
    }
  }
}

