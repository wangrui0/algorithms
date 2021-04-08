package org.leetcode.shunxu.ch1100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * *<p>LeetCode 1086. 前五科的均分（map + 优先队列）
 * <p>1. 题目
 * <p>给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 *
 * <p>对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。
 * <p> 平均分请采用整数除法计算。
 *
 * <p>示例：
 * <p>输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * <p>输出：[[1,87],[2,88]]
 * <p>解释：
 * <p>id = 1 的学生平均分为 87。
 * <p>id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *
 * <p>提示：
 * <p>1 <= items.length <= 1000
 * <p>items[i].length == 2
 * <p>学生的 ID 在 1 到 1000 之间
 * <p>学生的分数在 1 到 100 之间
 * <p>每个学生至少有五个分数
 * <p>https://leetcode-cn.com/problems/high-five/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1086HighFive {

  /**
   * @param items
   * @return
   */
  public static int[][] highFive_self(int[][] items) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int[] item : items) {
      PriorityQueue<Integer> queue = map.getOrDefault(item[0], new PriorityQueue<>((a, b) -> b - a));
      queue.offer(item[1]);
      map.put(item[0], queue);
    }
    int[][] ans = new int[map.size()][2];
    int j = 0;
    for (Integer key : map.keySet()) {
      PriorityQueue<Integer> queue = map.get(key);
      int sum = 0;
      for (int i = 0; i < 5; i++) {
        sum += queue.poll();
      }
      ans[j][0] = key;
      ans[j][1] = sum / 5;
      j++;
    }
    return ans;
  }

  /**
   * 有问题，这个 主要看看优先对列的用法
   *
   * @param items
   * @return
   */
  public int[][] highFive(int[][] items) {

    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for (int[] item : items) {
      int id = item[0];
      int score = item[1];

      if (!map.containsKey(id)) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
        pq.offer(score);
        map.put(id, pq);
      } else {
        PriorityQueue<Integer> pq = map.get(id);
        pq.offer(score);
        if (pq.size() > 5) {
          pq.poll();
        }
        map.put(id, pq);
      }
    }

    int index = 0;

    int[][] res = new int[map.size()][2];

    for (int id : map.keySet()) {

      res[index][0] = id;

      PriorityQueue<Integer> pq = map.get(id);
      int sum = 0;
      int size = pq.size();

      while (!pq.isEmpty()) {
        sum += pq.poll();
      }

      res[index][1] = sum / size;

      index++;

    }

    return res;
  }
}
