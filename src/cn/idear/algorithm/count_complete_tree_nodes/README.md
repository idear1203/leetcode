Count Complete Tree Nodes
-------------------------

参考<http://blog.csdn.net/ljiabin/article/details/45846527>

对于满二叉树，设其树高为`h`,则其节点个数为`2^h - 1`。

所以，先求左右子树的高度，如果高度相等，则为满二叉树，可以直接求出其节点个数，否则递归求左右子树的高度。