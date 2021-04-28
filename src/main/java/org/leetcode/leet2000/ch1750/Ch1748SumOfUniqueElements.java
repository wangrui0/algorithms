package org.leetcode.leet2000.ch1750;

import java.util.HashMap;

/**
 * <p>1748. 唯一元素的和
 *
 * <p>给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 *
 * <p>请你返回 nums 中唯一元素的 和 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3,2]
 * <p>输出：4
 * <p>解释：唯一元素为 [1,3] ，和为 4 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,1,1,1,1]
 * <p>输出：0
 * <p>解释：没有唯一元素，和为 0 。
 *
 * <p>示例 3 ：
 *
 * <p>输入：nums = [1,2,3,4,5]
 * <p>输出：15
 * <p>解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数7,449
 * <p>提交次数9,906
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sum-of-unique-elements/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:04 下午
 */
public class Ch1748SumOfUniqueElements {

  public int sumOfUnique_self(int[] nums) {
    int[] count = new int[101];
    for (int num : nums) {
      count[num]++;
    }
    int ans = 0;
    for (int i = 0; i <= 100; i++) {
      if (count[i] == 1) {
        ans += i;
      }
    }
    return ans;
  }

  public int sumOfUnique_2(int[] nums) {
    int[] count = new int[101];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]] = count[nums[i]] + 1;
    }
    //此处定义一个空数组count长度为101内容全为0，
    //nums数组中输入什么数(one)，count数组的第one位就
    //会变为1，若输入的数相同，有几个相同的数，count数组
    //的第one位就会变为几
    int res = 0;
    for (int i = 1; i < 101; i++) {
      if (count[i] == 1) {    //if (count[i] == 2){
        res = res + i;     //res =res+ i*2;}出现两次
      }
    }
    //此处判断nums数组中输入数的次数，count[i] == 1就表示
    //这个数出现了一次，count[i] == 2就表示这个数出现了二次
    //且count[i] == 1中的i就是nums数组中的元素
    return res;
  }

  public int sumOfUnique_3(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    for (int j : map.keySet()) {
      if (map.get(j) == 1) {
        sum += j;
      }
    }
    return sum;
  }

  public int sumOfUnique_4(int[] nums) {
    HashMap<Integer, Integer> mapper = new HashMap<>();
    int ans = 0; // 返回值
    for (int num : nums) {
      if (!mapper.containsKey(num)) {
        // 如果之前没出现过，那么就加上它
        ans += num;
        // 然后在哈希表中记录下来出现的次数
        mapper.put(num, 1);
      } else if (mapper.containsKey(num) && mapper.get(num) == 1) {
        // 如果出现过一次，就减去它，然后记录次数
        ans -= num;
        mapper.put(num, mapper.get(num) + 1);
      }
    }
    return ans;
  }


}
