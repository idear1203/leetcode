package cn.idear.algorithm.peeking_iterator;

import java.util.Iterator;

/**
 * Created by wangdongwei on 10/3/15.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private boolean hasPeeked;

    private Integer hold;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeeked){
            hold = iterator.next();
            hasPeeked = true;
        }
        return hold;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!hasPeeked)
            hold = iterator.next();
        hasPeeked = false;
        return  hold;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
        if(hasPeeked)
            return true;
        return iterator.hasNext();
    }
}
