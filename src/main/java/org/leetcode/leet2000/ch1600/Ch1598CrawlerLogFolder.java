package org.leetcode.leet2000.ch1600;

import java.util.Stack;

/**
 * <p>1598. 文件夹操作日志搜集器
 *
 * <p>每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 *
 * <p>下面给出对变更操作的说明：
 *
 * <p>    "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * <p>    "./" ：继续停留在当前文件夹。
 * <p>    "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 *
 * <p>给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 *
 * <p>文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 *
 * <p>执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：logs = ["d1/","d2/","../","d21/","./"]
 * <p>输出：2
 * <p>解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * <p>示例 2：
 *
 * <p>输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * <p>输出：3
 *
 * <p>示例 3：
 *
 * <p>输入：logs = ["d1/","../","../","../"]
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= logs.length <= 103
 * <p>    2 <= logs[i].length <= 10
 * <p>    logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * <p>    logs[i] 符合语句中描述的格式
 * <p>    文件夹名称由小写英文字母和数字组成
 *
 * <p>通过次数8,998
 * <p>提交次数13,437
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/crawler-log-folder/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1598CrawlerLogFolder {
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/", "../", "../", "../"}));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            String operation = logs[i];
            if (operation.equals("../")) {
                if (count >= 1) {
                    count--;
                }
                continue;
            } else if (operation.equals("./")) {
                continue;
            } else {
                count++;
            }

        }
        return count;
    }

    public static int minOperations_2(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            String operation = logs[i];
            if (operation.equals("../")) {
                if (stack.size() >= 1) {
                    stack.pop();
                }
                continue;
            } else if (operation.equals("./")) {
                continue;
            } else {
                stack.push(operation);
            }

        }
        return stack.size();
    }

}
