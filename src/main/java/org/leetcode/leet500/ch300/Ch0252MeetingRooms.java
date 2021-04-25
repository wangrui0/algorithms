package org.leetcode.leet500.ch300;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p> 会议室
 * <p> Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * <p>determine if a person could attend all meetings.
 *
 * <p> Example 1:
 *
 * <p> Input: [[0,30],[5,10],[15,20]]
 * <p> Output: false
 * <p> Example 2:
 *
 * <p> Input: [[7,10],[2,4]]
 * <p> Output: true
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0252MeetingRooms {

  /**
   * 如果区间有重合就不能参加会议; 核心: 将时间段按照开始时间排序, 然后遍历数组, 判断相邻两个时间段之间是否有重叠
   */
  public boolean canAttendMeetings(int[][] intervals) {
    //按照开始时间升序排序
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    //从第二个时间段开始遍历, 判断相邻两个时间段之间是否有重叠
    for (int i = 1; i < intervals.length; i++) {
      //如果当前时间段的开始时间小于上一个时间段的结束时间, 说明区间有重合, 返回false
      if (intervals[i][0] < intervals[i - 1][1]) {
        return false;
      }
    }
    return true;
  }
}
