package com.shy.javatest.zuseduilie;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by ShangHongyu on 2018/7/18.
 */
public class Blocking {
    public static void main(String[] args){
        ArrayBlockingQueue<String> strings=new ArrayBlockingQueue<>(200);
        ArrayBlockingQueue fairqueue=new ArrayBlockingQueue(2000,true);

        BlockingQueue blockingQueue=new BlockingQueue() {
            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public void put(Object o) throws InterruptedException {

            }

            @Override
            public boolean offer(Object o, long l, TimeUnit timeUnit) throws InterruptedException {
                return false;
            }

            @Override
            public Object take() throws InterruptedException {
                return null;
            }

            @Override
            public Object poll(long l, TimeUnit timeUnit) throws InterruptedException {
                return null;
            }

            @Override
            public int remainingCapacity() {
                return 0;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int drainTo(Collection collection) {
                return 0;
            }

            @Override
            public int drainTo(Collection collection, int i) {
                return 0;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] objects) {
                return new Object[0];
            }

            @Override
            public boolean containsAll(Collection collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}
