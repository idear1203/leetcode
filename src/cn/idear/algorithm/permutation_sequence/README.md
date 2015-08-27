Permutation Sequence
--------------------

解法参考<https://github.com/tg123/leetcode/blob/gh-pages/permutation-sequence/README.md>

真是绝了！

copy paste至此。

问题的关键是如何找到第`k`个排列。最简单的方法不断调用`next_permution`函数。



使用维基百科的例子，寻找`[1, 2, 3, 4, 5, 6, 7]`的第`2982`个排列.

### 把`k`转为factorial-based

```
k = 2982
n = 7
```

从`n - 1`开始：

```
2982 / 6! = 4 and remainder 102     |  4
102  / 5! = 0 and remainder 102     |  0
102  / 4! = 4 and remainder 6       |  4
6    / 3! = 1 and remainder 0       |  1
0    / 2! = 0 and remainder 0       |  0
0    / 1! = 0 and remainder 0       |  0
0    / 0! = 0 and remainder 0       |  0
```

所以, `2982(10base) = 4041000(!base)`

### 将数字转换为排列

```



index:  0  1  2  3  4  5  6
chars: [1, 2, 3, 4, 5, 6, 7]
final: []


number: 4041000
        ^
        |

Move chars[4] to the end of final


chars: [1, 2, 3, 4, 5, 6, 7]  BEFORE
index:  0  1  2  3  4  5, 6
final: [5]
chars: [1, 2, 3, 4, 6, 7]     AFTER


number: 4041000
         ^
         |

Move chars[0] to the end of final

chars: [1, 2, 3, 4, 6, 7]     BEFORE
index:  0  1  2  3  4  5
final: [5, 1]
chars: [2, 3, 4, 6, 7]        AFTER

number: 4041000
          ^
          |

Move chars[4] to the end of final

chars: [2, 3, 4, 6, 7]       BEFORE
index:  0  1  2  3  4
final: [5, 1, 7]
chars: [2, 3, 4, 6]          AFTER



number: 4041000
           ^
           |

Move chars[1] to the end of final

chars: [2, 3, 4, 6]          BEFORE
index:  0  1  2  3
final: [5, 1, 7, 3]
chars: [2, 4, 6]             AFTER



number: 4041000
            ^
            |

Move chars[0] to the end of final

chars: [2, 4, 6]             BEFORE
index:  0  1  2
final: [5, 1, 7, 3, 2]
chars: [4, 6]                AFTER



number: 4041000
             ^
             |

Move chars[0] to the end of final

chars: [4, 6]                BEFORE
index:  0  1
final: [5, 1, 7, 3, 2, 4]
chars: [6]                   AFTER


number: 4041000
              ^
              |

Move chars[0] to the end of final

chars: [6]                   BEFORE
index:  0
final: [5, 1, 7, 3, 2, 4, 6]
chars: []                    AFTER


```

The 2982th permutation of `[1, 2, 3, 4, 5, 6, 7]` is `[5, 1, 7, 3, 2, 4, 6]`

真是太神奇了！