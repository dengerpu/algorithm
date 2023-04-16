package com.ep.LeetCode_Type.BackTracking;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-16 9:41
 */
public class exercise13_332_重新安排行程 {
    static LinkedList<String> res;
    static LinkedList<String> path;
    public static List<String> findItinerary(List<List<String>> tickets) {
        path = new LinkedList<>();
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        boolean[] used = new boolean[tickets.size()];
        path.add("JFK");
        backTracking((ArrayList) tickets, used);
        return res;
    }

    public static boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;
                if (backTracking(tickets, used)) {
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<List<String>>();
        tickets.add(new LinkedList<String>(){
            {add("JFK"); add("KUL");}
        });
        tickets.add(new LinkedList<String>(){
            {add("JFK"); add("NRT");}
        });
        tickets.add(new LinkedList<String>(){
            {add("NRT"); add("JFK");}
        });
        findItinerary(tickets);
    }
}
