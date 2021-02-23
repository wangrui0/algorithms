package org.leetcode.shunxu.ch200;

/**
 * https://www.cnblogs.com/grandyang/p/5174322.html
 * <p>这道题给了我们一个 Read4 函数，每次可以从一个文件中最多读出4个字符，
 * <p> 如果文件中的字符不足4个字符时，返回准确的当前剩余的字符数。现在让实现一个最多能读取n个字符的函数。
 * <p> 这题有迭代和递归的两种解法，先来看迭代的方法，思路是每4个读一次，然后把读出的结果判断一下，如果为0的话，
 * <p> 说明此时的 buf 已经被读完，跳出循环，直接返回 res 和n之中的较小值。否则一直读入，直到读完n个字符，循环结束，最后再返回 res 和n之中的较小值，
 * <p> 参见代码如下：
 *
 * @author: wangrui
 * @date: 2020/12/10
 */
public class Ch0157Read4 {

  //  https://segmentfault.com/a/1190000003794420
  /*临时数组法
      复杂度
      时间 O(N) 空间 O(1)
      思路
      用一个临时数组，存放每次read4读到字符，再用一个指针标记buf数组目前存储到的位置，然后将这个临时数组的内容存到buf相应的位置就行了。这里需要注意两个corner case：
      如果本次读到多个字符，但是我们只需要其中一部分就能完成读取任务时，我们要拷贝的长度是本次读到的个数和剩余所需个数中较小的
      如果read4没有读满4个，说明数据已经读完，这时候对于读到的数据长度，因为也可能存在我们只需要其中一部分的情况，所以要返回总所需长度和目前已经读到的长度的较小的
  */
  /*public class Solution extends Reader4 {

    public int read(char[] buf, int n) {
      for (int i = 0; i < n; i += 4) {
        char[] tmp = new char[4];
        // 将数据读入临时数组
        int len = read4(tmp);
        // 将临时数组拷贝至buf数组，这里拷贝的长度是本次读到的个数和剩余所需个数中较小的
        System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
        // 如果读不满4个，说明已经读完了，返回总所需长度和目前已经读到的长度的较小的
        if (len < 4) {
          return Math.min(i + len, n);
        }
      }
      // 如果循环内没有返回，说明读取的字符是4的倍数
      return n;
    }
  }*/

  /**
   * 队列法
   * 复杂度
   * 时间 O(N) 空间 O(1)
   * 思路
   * 因为要调用多次，这里又多了一些corner case：
   * 第一次调用时，如果read4读出的多余字符我们要先将其暂存起来，这样第二次调用时先读取这些暂存的字符
   * 第二次调用时，如果连暂存字符都没读完，那么这些暂存字符还得留给第三次调用时使用
   * 所以，难点就在于怎么处理这个暂存字符。因为用数组和指针控制对第二种情况比较麻烦，且这些字符满足先进先出，所以我们可以用一个队列暂存这些字符。这样，只要队列不为空，就先读取队列。
   */
 /* public class Solution extends Reader4 {
    Queue<Character> remain = new LinkedList<Character>();

    public int read(char[] buf, int n) {
      int i = 0;
      // 队列不为空时，先读取队列中的暂存字符
      while(i < n && !remain.isEmpty()){
        buf[i] = remain.poll();
        i++;
      }
      for(; i < n; i += 4){
        char[] tmp = new char[4];
        int len = read4(tmp);
        // 如果读到字符多于我们需要的字符，需要暂存这些多余字符
        if(len > n - i){
          System.arraycopy(tmp, 0, buf, i, n - i);
          // 把多余的字符存入队列中
          for(int j = n - i; j < len; j++){
            remain.offer(tmp[j]);
          }
          // 如果读到的字符少于我们需要的字符，直接拷贝
        } else {
          System.arraycopy(tmp, 0, buf, i, len);
        }
        // 同样的，如果读不满4个，说明数据已经读完，返回总所需长度和目前已经读到的长度的较小的
        if(len < 4) return Math.min(i + len, n);
      }
      // 如果到这里，说明都是完美读取，直接返回n
      return n;
    }
  }*/

}
