Gas Station
-----------

参考链接：

<https://github.com/tg123/leetcode/blob/gh-pages/gas-station/README.md>

<http://www.cnblogs.com/felixfang/p/3814463.html>

这个问题是要找到 *唯一* 的`i`，满足以下关系式：

- `SUM(gas[0] - cost[0], ..., gas[i - 1] - cost[i - 1]) + SUM(gas[i] - cost[i], ... , gas[end] - cost[end]) >= 0`
 
- `SUM(gas[0] - cost[0], ..., gas[i - 1] - cost[i - 1]) < 0`

第一个式子保证了整个数组有解。

第二个式子说明从`i`开始`sum`可以一直保持为正数。(实际是就是求公共子序列最大和的起点)

数学原理：

对于一个循环数组，如果这个数组整体和`SUM >= 0`，那么必然可以在数组中找到这么一个元素：从这个数组元素出发，绕数组一圈，
能保证累加和一直是出于非负状态。