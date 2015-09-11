Binary Tree Postorder Traversal
-------------------------------

参考<https://github.com/tg123/leetcode/blob/gh-pages/binary-tree-inorder-traversal/README.md>

递归的思路很简单：

```
visit(current.left)
visit(current.right)
add(current.val)
```

模拟函数压栈/退栈的过程。

函数调用时，需要

- 存储局部变量
- 存储当前函数地址
- 被调函数参数压栈
- 跳转到被调函数地址

函数返回时，需要

- 恢复存储的局部变量
- 跳转到调用函数的调用点。context

