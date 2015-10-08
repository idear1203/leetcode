Single Number II
----------------

参考资料：

<https://github.com/tg123/leetcode/blob/gh-pages/single-number-ii/Solution.java>

[leetcode-cpp.pdf](https://github.com/soulmachine/leetcode/blob/master/C%2B%2B/chapLinearList.tex#L1911)

<https://github.com/snowwolfyang/leetcode/blob/master/SingleNumberII.cpp>

这个题在位运算时模3清零。

1. 创建一个长度为`Integer.SIZE`的数组`count`,`count[i]`表示在在`i`位`mod 3`后出现的1的次数。

2. 用`one`记录到当前处理的元素为止,二进制1出现“1 次”(`mod 3`)的二进制位;
用two记录到当前计算的变量为止,二进制1出现“2 次”(`mod 3`)的二进制位。
当one和two中的某一位同时为1时表示该二进制位上1出现了3次,此时需要清零。即用二进制模拟三进制运算。最终 one 记录的是最终结果。
