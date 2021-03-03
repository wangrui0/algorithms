package org.leetcode.shunxu.ch400;

import java.util.HashMap;

/**
 * <p> 题目：
 *
 * <p> Design a logger system that receive stream of messages along with its timestamps, each message should be printed
 * if and only if it is not printed in the last 10 seconds.
 *
 * <p> Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the
 * given timestamp, otherwise returns false.
 *
 * <p>It is possible that several messages arrive roughly at the same time.
 *
 * <p> Example:
 *
 * <p>Logger logger = new Logger();
 *
 * <p>// logging string "foo" at timestamp 1
 * <p>logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * <p>// logging string "bar" at timestamp 2
 * <p>logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * <p>// logging string "foo" at timestamp 3
 * <p>logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * <p>// logging string "bar" at timestamp 8
 * <p>logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * <p> // logging string "foo" at timestamp 10
 * <p> logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * <p> // logging string "foo" at timestamp 11
 * <p> logger.shouldPrintMessage(11,"foo"); returns true;
 * <p> 题解：
 *
 * <p> 再次看到这题就像回到了当年的战场.
 *
 * <p>维护一个HashMap, key 是message, value 是该message的timestamp
 *
 * <p> 没出现过的message加到HashMap中, return true.
 *
 * <p> 出现过并没有超过10的message return false.
 *
 * <p>出现过并超过10的message, 跟新HashMap, return true.
 *
 * <p> Time Complexity: shouldPrintMessage O(1).
 *
 * <p> Space: HashMap的大小.
 */
public class Ch359LoggerRateLimiter {

  HashMap<String, Integer> hm;

  public Ch359LoggerRateLimiter() {
    hm = new HashMap<String, Integer>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false. 10         If this
   * method returns false, the message will not be printed. 11         The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!hm.containsKey(message)) {
      hm.put(message, timestamp);
      return true;
    } else if (timestamp - hm.get(message) < 10) {
      return false;
    } else {
      hm.put(message, timestamp);
      return true;
    }
  }
}
