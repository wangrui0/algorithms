package org.leetcode.leet500.ch450;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 401. 二进制手表
 *
 * <p>二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * <p> 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * <p>例如，上面的二进制手表读取 “3:25”。
 *
 * <p> 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *
 *
 * <p> 示例：
 *
 * <p> 输入: n = 1
 * <p> 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 *
 *
 * <p>提示：
 *
 * <p>     输出的顺序没有要求。
 * <p>    小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * <p>    分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * <p>    超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * <p>https://leetcode-cn.com/problems/binary-watch/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch401BinaryWatch {

  /**
   * <p>8 4 2 1
   * <p>o o x x
   * <p>32 16 8 4 2 1
   * <p>x  o  o x x o
   * <p>小时 0-11，分钟 0-59
   *
   * @param num
   * @return
   */
  public  List<String> readBinaryWatch(int num) {
    List<String> timeList = new ArrayList<>();
    for (int hour = 0; hour <= Math.min(num, 3); hour++) {
      if (num - hour <= 5) {
        String[] hoursList = getHoursList(hour);
        String[] minutesList = getMinutesList(num - hour);
        for (String hourNum : hoursList) {
          for (String minNum : minutesList) {
            StringBuilder sb = new StringBuilder();
            sb.append(hourNum).append(":").append(minNum);
            timeList.add(sb.toString());
          }
        }
      }
    }
    return timeList;
  }

  public  String[] getHoursList(int num) {
    switch (num) {
      case 0:
        return new String[]{"0"};
      case 1:
        return new String[]{"1", "2", "4", "8"};
      case 2:
        return new String[]{"3", "5", "6", "9", "10"};
      default:
        return new String[]{"7", "11"};
    }
  }

  public  String[] getMinutesList(int num) {
    switch (num) {
      case 0:
        return new String[]{"00"};
      case 1:
        return new String[]{"01", "02", "04", "08", "16", "32"};
      case 2:
        return new String[]{"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33",
            "34", "36", "40", "48"};
      case 3:
        return new String[]{"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35",
            "37", "38", "41", "42", "44", "49", "50", "52", "56"};
      case 4:
        return new String[]{"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53",
            "54", "57", "58"};
      default:
        return new String[]{"31", "47", "55", "59"};
    }
  }}
