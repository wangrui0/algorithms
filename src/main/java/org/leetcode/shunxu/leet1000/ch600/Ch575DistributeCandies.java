package org.leetcode.shunxu.leet1000.ch600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>575. 分糖果
 *
 * <p>给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * <p>示例 1:
 *
 * <p>输入: candies = [1,1,2,2,3,3]
 * <p>输出: 3
 * <p>解析: 一共有三种种类的糖果，每一种都有两个。
 * <p>     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 * <p>示例 2 :
 *
 * <p>输入: candies = [1,1,2,3]
 * <p>输出: 2
 * <p>解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 *
 * <p>注意:
 *
 *
 * <p>    数组的长度为[2, 10,000]，并且确定为偶数。
 * <p>    数组中数字的大小在范围[-100,000, 100,000]内。
 *
 * <p>通过次数34,066
 * <p>提交次数49,968
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/distribute-candies/
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 */
public class Ch575DistributeCandies {
    /**
     * <p>时间复杂度：O(n)。整个 candies 数组只遍历一次。这里，nn 表示 candies 数组的大小。
     * <p>空间复杂度：O(n),在最坏的情况下，set 的大小为 nn。
     *
     * <p>作者：LeetCode
     * <p>链接：https://leetcode-cn.com/problems/distribute-candies/solution/fen-tang-guo-by-leetcode/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(nlogn)。排序需要 O(nlogn) 的时间。
     * 空间复杂度：O(1)。
     * @param candyType
     * @return
     */
    public int distributeCandies2(int[] candyType) {
        Arrays.sort(candyType);
        int count = 1;
        for (int i = 1; i < candyType.length && count < candyType.length / 2; i++) {
            if (candyType[i] > candyType[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
