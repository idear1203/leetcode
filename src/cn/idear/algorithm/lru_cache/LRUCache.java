package cn.idear.algorithm.lru_cache;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class LRUCache {

    private class Entry{
        /**
         * pre和next用于记录双向链表的前驱和后继。使用双向链表只需要知道结点本身就可以实现删除，而无需知道被删除结点的前驱和后继
         */
        private Entry pre;
        private Entry next;
        /**
         * hashNext用于存放hash值相同的下一个元素。
         */
        private Entry hashNext;
        /**
         * 用于存储数据。
         */
        private int value;
        /**
         * 用于存储key值
         */
        private int key;
    }

    /**
     * 用于记录当前cache存储的元素个数。
     */
    private int size;

    /**
     * 记录cache容量大小。
     */
    private int capcity;

    /**
     * 伪结点。实现快速插入和删除。
     */
    private Entry head, tail;

    /**
     * 用于存放哈希表
     */
    private Entry[] hashTable;

    /**
     * 计算key的hash值
     * @param key
     * @return
     */
    private int hash(int key){
        return key % capcity;
    }

    public LRUCache(int capacity) {
        this.capcity = capacity;
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
        /**
         * 注意new时数组元素为空。
         */
        hashTable = new Entry[capacity];
        for(int i = 0; i < capacity; i++)
            hashTable[i] = new Entry();
    }

    public int get(int key) {
        /**
         * get函数做两件事情，1是查找key对应的值，2.在存在的前提下，将value移动到链表表头。
         */
        Entry entry = getEntry(key);
        if(entry != null){
            deleteEntry(entry);
            moveToHead(entry);
            return entry.value;
        }
        return -1;
    }

    /**
     * move entry to head.
     */
    private void moveToHead(Entry entry) {
        entry.next = head.next;
        head.next.pre = entry;
        head.next = entry;
        entry.pre = head;
    }

    /**
     * delete the given entry.
     */
    private void deleteEntry(Entry entry){
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    private Entry getEntry(int key) {
        for(Entry cur = hashTable[hash(key)].hashNext; cur != null; cur = cur.hashNext)
            if(cur.key == key)
                return cur;
        return null;
    }

    /**
     * Set or insert the value if the key is not already present. When the cache reached its capacity,
     * it should invalidate the least recently used item before inserting a new item.
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        /**
         * do nothing.
         */
        if(capcity == 0) return;

        Entry entry = getEntry(key);
        /**
         * if the key is already present, set new value.
         */
        if(entry != null){
            entry.value = value;
            deleteEntry(entry);
            moveToHead(entry);
        }else{
            /**
             * case size < capacity,
             * 1. insert an entry after head
             * 2. put it in the correct slot in hash table
             */
            if(size < capcity){
                /**
                 * update size
                 */
                size++;
            }else{ //if size == capacity
                /**
                 * delete the least recently used node first, which is in front of the tail node.
                 * delete can be divided into two tasks:
                 * 1. delete from tail;
                 * 2. delete from hashTable;
                 */
                Entry toDelete = tail.pre;
                deleteEntry(toDelete);
                for(Entry cur = hashTable[hash(toDelete.key)]; cur.hashNext != null; cur = cur.hashNext){
                    if(cur.hashNext == toDelete) {
                        /**
                         * we find the node
                         */
                        cur.hashNext = cur.hashNext.hashNext;
                        break;
                    }
                }
            }
            /**
             * make an new entry.
             */
            entry = new Entry();
            entry.key = key;
            entry.value = value;
            /**
             * insert it after head.
             */
            moveToHead(entry);
            /**
             * put it in the correct slot in hash table
             */
            Entry cur;
            for(cur = hashTable[hash(key)]; cur.hashNext != null; cur = cur.hashNext);
            cur.hashNext = entry;
        }
    }
}
