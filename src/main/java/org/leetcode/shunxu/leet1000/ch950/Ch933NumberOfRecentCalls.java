package org.leetcode.shunxu.leet1000.ch950;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>933. 最近的请求次数
 *
 * <p>写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * <p>请你实现 RecentCounter 类：
 *
 * <p>   RecentCounter() 初始化计数器，请求数为 0 。
 * <p>  int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 *
 * <p> 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>["RecentCounter", "ping", "ping", "ping", "ping"]
 * <p>[[], [1], [100], [3001], [3002]]
 * <p>输出：
 * <p>[null, 1, 2, 3, 3]
 *
 * <p>解释：
 * <p>RecentCounter recentCounter = new RecentCounter();
 * <p>recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * <p>recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * <p>recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * <p> recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 * <p>https://leetcode-cn.com/problems/number-of-recent-calls/
 *
 * @author: wangrui
 * @date: 2021/3/21
 */
public class Ch933NumberOfRecentCalls {

  private Queue<Integer> queue;

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(Q)，其中 Q 是 ping 的次数。
   *
   * <p>  空间复杂度：O(W)，其中 W=3000是队列中最多存储的 ping 的记录数目。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/number-of-recent-calls/solution/zui-jin-de-qing-qiu-ci-shu-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public Ch933NumberOfRecentCalls() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.offer(t);
    while (queue.peek() < t - 3000) {
      queue.poll();
    }
    return queue.size();
  }

  public int ping2(int t) {
    queue.add(t);
    while (queue.peek() < t - 3000) {
      queue.poll();
    }
    return queue.size();
  }

}
