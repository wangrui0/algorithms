package org.leetcode.shunxu.ch650;

/**
 * <p>605. 种花问题
 * <p>假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * <p>给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：flowerbed = [1,0,0,0,1], n = 1
 * <p>输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>1 <= flowerbed.length <= 2 * 104
 * <p>flowerbed[i] 为 0 或 1
 * <p> flowerbed 中不存在相邻的两朵花
 * <p> 0 <= n <= flowerbed.length
 * <p>通过次数83,027提交次数244,817
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:13 下午
 */
public class Ch605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return true;
    }
}
