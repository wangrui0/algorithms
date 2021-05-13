package org.company.meituan.all.leet25;

import java.util.HashMap;
import java.util.Iterator;

/**
 * <p>LRU（Least Recently Used）最近最久未使用算法
 * <p>常见应用场景：内存管理中的页面置换算法、缓存淘汰中的淘汰策略等
 *
 * <p>　　底层结构：双向链表 + HashMap ，双向链表由特定的哈希节点组成。
 * <p>（1）访问节点时，将其从原来位置删除，插入到双向链表头部；
 * <p>（2）更新节点时，先删除原有缓存数据（即原有节点），然后更新map映射，再将更新值作为节点插入链表头；更新后，判断容量是否超过最大内存使用量
 * <p>（3）超过则执行淘汰；淘汰即删除双向链表最后一个节点，同时删除map中的映射
 * <p>（4）LRU实现中有频繁的查找节点并删除，为节省时间（链表查找目标节点需要遍历），使用HashMap保存键-节点映射关系，O(1)的查找+O(1)的删除
 * <p>（5）LRU实现中，要频繁的在头部插入，以及在尾部删除；因此，需要定义head、tail两个节点，方便操作
 *
 * @author: wangrui
 * @date: 2021/3/1
 */
public class LRU1<K, V> implements Iterable<K> {

  private Node head = new Node((K) "head");
//  private Node head = new Node( "head");
  private Node tail = new Node((K) "tail");
//  private Node tail = new Node( "tail");
  //记录K-Node映射，便于快速查找目标数据对应节点
  private HashMap<K, Node> map;
  private int maxSize;

  //哈希链表节点类 Node
  private class Node {

    Node pre;
    Node next;
    K k;
    V v;

    //Node对外提供构造方法
    public Node(K k, V v) {
      this.k = k;
      this.v = v;
    }

    public Node(K k) {
      this.k = k;
    }
  }

  //初始化时必须传入最大可用内存容量
  public LRU1(int maxSize) {
    this.maxSize = maxSize;
    //HashMap初始容量设置为 maxSize * 4/3，即达到最大可用内存时，HashMap也不会自动扩容浪费空间
    this.map = new HashMap<>(maxSize * 4 / 3);

    head.next = tail;
    tail.pre = head;

  }

  //获取指定数据


  private V get(K key) {
    //判断是否存在对应数据
    if (!map.containsKey(key)) {
      return null;

    }

    //最新访问的数据移动到链表头
    Node node = map.get(key);
    remove(node);
    addFirst(node);
    return node.v;

  }

  //更新旧数据或添加数据


  private void put(K key, V value) {
    //若存在旧数据则删除
    if (map.containsKey(key)) {
      Node node = map.get(key);
      remove(node);

    }

    //新数据对应节点插入链表头
    Node node = new Node(key, value);
    map.put(key, node);
    addFirst(node);

    //判断是否需要淘汰数据
    if (map.size() > maxSize) {
      removeLast();
      //数据节点淘汰后，同时删除map中的映射
      map.remove(node.k);

    }

  }

  //将指定节点插入链表头


  private void addFirst(Node node) {
    Node next = head.next;
    head.next = node;
    node.pre = head;
    node.next = next;
    next.pre = node;

  }

  //从链表中删除指定节点


  private void remove(Node node) {
    Node pre = node.pre;
    Node next = node.next;

    pre.next = next;
    next.pre = pre;

    node.next = null;
    node.pre = null;

  }

  //淘汰数据


  private Node removeLast() {
    //找到最近最久未使用的数据所对应节点
    Node node = tail.pre;

    //淘汰该节点
    remove(node);

    return node;

  }

  //通过迭代器遍历所有数据对应键
  @Override
  public Iterator<K> iterator() {
    return new Iterator<K>() {
      private Node cur = head.next;

      @Override
      public boolean hasNext() {
        return cur != tail;
      }

      @Override
      public K next() {
        Node node = cur;
        cur = cur.next;
        return node.k;

      }
    };
  }
}
