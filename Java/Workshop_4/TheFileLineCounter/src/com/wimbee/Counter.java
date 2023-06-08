package com.wimbee;

public class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public Counter(int count) {
        this.count = 0;
    }

    public void setCount(int count) {
        this.count = count;
    }

    synchronized void increment(int number){
        count += number;
    }
    
}