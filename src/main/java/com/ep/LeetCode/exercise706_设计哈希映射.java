package com.ep.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-23 9:12
 */
public class exercise706_设计哈希映射 {
    class MyHashMap {
        private class Pair {
            private int key;
            private int val;

            public Pair(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public int getKey() {
                return key;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }
        }
        private static final int BASE = 769;
        private LinkedList[] data;

        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<Pair>();
            }
        }

        public void put(int key, int value) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
               Pair pair = iterator.next();
               if (pair.getKey() == key) {
                   pair.setVal(value);
                   return;
               }
            }
            data[h].offerLast(new Pair(key, value));
        }

        public int get(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    return pair.getVal();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    data[h].remove(pair);
                    return;
                }
            }
        }
        private  int hash(int key) {
            return key % BASE;
        }
    }
}
