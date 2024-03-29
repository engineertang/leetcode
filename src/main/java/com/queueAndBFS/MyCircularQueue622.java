package com.queueAndBFS;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

//MyCircularQueue
class MyCircularQueue622 {
    private final Integer[] data;
    // two pointer to indicate the start position and end position, index between [0, n-1]
    private Integer p_start;
    private Integer p_end;
    private final int length;

    public MyCircularQueue622(int k) {
        data = new Integer[k];
        length = k;
    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            p_start = 0;
            p_end = 0;
            data[p_start] = value;
            return true;
        } else if (this.isFull()) {
            return false;
        } else {
            p_end = (p_end + 1 == length) ? 0 : (p_end + 1);
            data[p_end] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        } else {
            data[p_start] = null;
            if (p_start == p_end) {
                p_start = null;
                p_end = null;
                return true;
            }
            p_start = p_start + 1 == length ? 0 : p_start + 1;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[p_start];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else
            return data[p_end];
    }

    public boolean isEmpty() {
        return p_start == null || p_end == null;
    }

    public boolean isFull() {
        return !this.isEmpty() && (this.p_end + 1) % (this.length - 1) == this.p_end;
        //(p_start < p_end && p_end - p_start == length-1) || (p_start>p_end&& p_start-p_end==1);
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class myclass = Class.forName("com.queueAndBFS.MyCircularQueue622");
        String[] excution = {"MyCircularQueue", "enQueue", "Rear", "Rear", "deQueue", "enQueue", "Rear", "deQueue", "Front", "deQueue", "deQueue", "deQueue"};
        Integer[] parameters = {6, 6, null, null, null, 5, null, null, null, null, null, null};

        MyCircularQueue622 myCircularQueue = null;
        for (int i = 0; i < excution.length; i++) {
            if (i == 0) {
                myCircularQueue = new MyCircularQueue622(parameters[i]);
            } else if (excution[i].equalsIgnoreCase("enQueue")) {
                Object object = myCircularQueue.enQueue(parameters[i]);
                System.out.println(object);
            } else {
                Method method = myclass.getMethod(excution[i]);
                Object object = method.invoke(myCircularQueue);
                System.out.println(object.toString());
            }
        }


        Queue<Integer> q = new LinkedList();

    }
}