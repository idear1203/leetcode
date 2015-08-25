Longest Palindromic Substring
-----------------------------

经典动态规划问题。

分析见[Longest Palindromic Substring Part I](http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html)


递归方程：

```
f(i,j) = true, j == i
       s[i] == s[j], j == i + 1
       s[i] = s[j] && f(i + 1, j - 1), j > i + 1
```
