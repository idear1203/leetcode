LRU Cache
---------

参考链接：

<http://blog.csdn.net/snowwolf_yang/article/details/22179193>
 
[leetcode-cpp.pdf](https://github.com/soulmachine/leetcode/blob/master/C%2B%2B/chapLinearList.tex#L2835)

<https://github.com/tg123/leetcode/tree/gh-pages/lru-cache>

又是一道完全没有思路的题。我根本就不知道LRU是什么。操作系统过去太久了。

LRU由一张哈希表+一个双向链表组成。通过哈希表实现对`key`所对应元素的快速查询，双向链表实现快速插入和删除元素。

重要的是如何解决hash冲突。所以需要增加一个域保存所有哈希值相同的元素。即哈希表的每个表头是一个单链表。