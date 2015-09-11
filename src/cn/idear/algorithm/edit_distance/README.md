Edit Distance
-------------

学习了博文<https://github.com/tg123/leetcode/blob/gh-pages/edit-distance/README.md>

### 递归方程

用`f[i][j]`来表示`A[0, i]`到`B[0,j]`之间的编辑距离。`c`是`A[i]`位置上的字符，`d`是`B[j]`位置上的字符。则

```
f[i][j] = f[i - 1][j - 1], c == d

        = min(f[i][j - 1], f[i - 1][j], f[i - 1][j - 1]) + 1, c != d
```

即`f[i][j]`分为4种情况：

- `f[i - 1][j - 1]`，当`c`和`d`相同时，编辑距离不变。
- `f[i - 1][j] + 1`，从A串中删除字符`c`，故而编辑距离+1。
- `f[i][j - 1] + 1`，从B串中删除字符`d`，故而编辑距离+1。
- `f[i - 1][j - 1] + 1` 将`c`替换成`d`。

添加是另一种思考问题的角度，与删除是类似的。