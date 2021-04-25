package org.leetcode.leet500.ch350;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>这道题定义了一个MovingAverage类，里面可以存固定个数字，然后我们每次读入一个数字，
 * <p> 如果加上这个数字后总个数大于限制的个数，那么我们移除最早进入的数字，然后返回更新后的平均数，
 * <p>这种先进先出的特性最适合使用队列queue来做，而且我们还需要一个double型的变量sum来记录当前所有数字之和，
 * <p> 这样有新数字进入后，如果没有超出限制个数，则sum加上这个数字，如果超出了，那么sum先减去最早的数字，再加上这个数字，
 * <p>然后返回sum除以queue的个数即可：
 * <p>MovingAverage m = new MovingAverage(3);
 *
 * <p> m.next(1) = 1
 *
 * <p>m.next(10) = (1 + 10) / 2
 *
 * <p>m.next(3) = (1 + 10 + 3) / 3
 *
 * <p> m.next(5) = (10 + 3 + 5) / 3
 * <p>https://leetcode-cn.com/problems/moving-average-from-data-stream/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch346MovingAverage {

  private Queue<Integer> queue;
  private int maxSize;
  private double previousSum = 0.0;

  public Ch346MovingAverage(int maxSize) {
    this.queue = new LinkedList<>();
    this.maxSize = maxSize;
  }

  public double next(int num) {
    if (queue.size() == maxSize) {
      previousSum -= queue.remove();
    }
    queue.offer(num);
    previousSum += num;
    return previousSum / queue.size();
  }
}
