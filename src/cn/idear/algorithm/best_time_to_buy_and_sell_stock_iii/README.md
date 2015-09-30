Best Time to Buy and Sell Stock III
-----------------------------------

best time系列的题，我一个都不会解。写到三有一种深深的挫败感。

参考资料：

<http://leetcode.tgic.me/best-time-to-buy-and-sell-stock-iii/index.html>

<http://blog.csdn.net/snowwolf_yang/article/details/23854251>

对于某个特定的`i`，将`a[0....end]`分成`a[0...i]`和`a[i+1..end]`两部分。
对于这两部分分别采用`best time to buy and sell stock`的算法，求得两部分最大值之和即为由`i`决定的出手两次的最大值。

`i`的范围是`[0..end]`。因此是这是一个`O(n^2)`的算法。

用空间来换时间。首先用缓存来记录左右两侧的最大值。最后扫一遍数组求最终的最大值，可获得`O(n)`的算法。
