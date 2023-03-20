package com.ep.AcWing;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-20 16:20
 */
public class AcWing803_区间合并 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            points.add(new Point(l,r));
        }
        System.out.println(merge(points));
    }
    static int merge(List<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY()) return 1;
                    else return -1;
                }
            }
        });
        ArrayList<Point> ans = new ArrayList<>();
        int start = points.get(0).getX(), end = points.get(0).getY();
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getX() > end) {
                ans.add(points.get(i));
                start = points.get(i).getX();
                end = points.get(i).getY();
            } else {
                end = Math.max(points.get(i).getY(), end);
            }
        }
        ans.add(new Point(start, end));
        return ans.size();
    }
}
class Point {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
