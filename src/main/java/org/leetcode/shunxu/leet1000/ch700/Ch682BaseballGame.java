package org.leetcode.shunxu.leet1000.ch700;

import java.util.Stack;

/**
 * <p>682. 棒球比赛
 * <p>你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * <p>比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * <p>整数 x - 表示本回合新获得分数 x
 * <p>"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * <p>"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * <p>"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * <p>请你返回记录中所有得分的总和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：ops = ["5","2","C","D","+"]
 * <p>输出：30
 * <p>解释：
 * <p>"5" - 记录加 5 ，记录现在是 [5]
 * <p>"2" - 记录加 2 ，记录现在是 [5, 2]
 * <p>"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * <p>"D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * <p>"+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * <p>所有得分的总和 5 + 10 + 15 = 30
 * <p>示例 2：
 *
 * <p>输入：ops = ["5","-2","4","C","D","9","+","+"]
 * <p>输出：27
 * <p>解释：
 * <p>"5" - 记录加 5 ，记录现在是 [5]
 * <p>"-2" - 记录加 -2 ，记录现在是 [5, -2]
 * <p>"4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * <p>"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * <p>"D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * <p>"9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * <p>"+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * <p>"+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * <p> 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 * <p> 示例 3：
 *
 * <p>输入：ops = ["1"]
 * <p>输出：1
 *
 *
 * <p>提示：
 *
 * <p>1 <= ops.length <= 1000
 * <p>ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 104, 3 * 104]
 * <p>对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数
 * <p>对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数
 * <p>通过次数37,565提交次数54,334
 * <p>https://leetcode-cn.com/problems/baseball-game/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:29 下午
 */
public class Ch682BaseballGame {

  /**
   * <p> 复杂度分析
   *
   * <p>  复杂度分析：O(N)，其中 N 是 ops 的长度。我们解析给定数组中的每个元素，然后每个元素执行 O(1) 的工作。
   *
   * <p>   空间复杂度：O(N)，用于存储 stack 的空间。
   *
   * @param ops
   * @return
   */
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack();

    for (String op : ops) {
      if (op.equals("+")) {
        int top = stack.pop();
        int newtop = top + stack.peek();
        stack.push(top);
        stack.push(newtop);
      } else if (op.equals("C")) {
        stack.pop();
      } else if (op.equals("D")) {
        stack.push(2 * stack.peek());
      } else {
        stack.push(Integer.valueOf(op));
      }
    }

    int ans = 0;
    for (int score : stack) {
      ans += score;
    }
    return ans;
  }

  public static int calPoints2(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < ops.length; i++) {
      String op = ops[i];
      if (op.equals("+")) {
        Integer pop = stack.pop();
        Integer peek = stack.peek();
        stack.push(pop);
        stack.push(pop + peek);
      } else if (op.equals("C")) {
        stack.pop();
      } else if (op.equals("D")) {
        stack.push(stack.peek() * 2);
      } else {
        stack.push(Integer.valueOf(op));
      }
    }
    int ans = 0;
    while (!stack.isEmpty()){
      ans += stack.pop();

    }
    return ans;
  }

}