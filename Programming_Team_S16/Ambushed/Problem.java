import java.awt.Polygon;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem {

	static class Point {
		public final double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Point sub(Point o) {
			return new Point(x - o.x, y - o.y);
		}

		boolean isCounterClockwise(Point b, Point c) {
			b = b.sub(this);
			c = c.sub(this);
			double cross = b.x * c.y - b.y * c.x;
			return cross > 0;
		}

		boolean isColinear(Point b, Point c) {
			b = b.sub(this);
			c = c.sub(this);
			double cross = b.x * c.y - b.y * c.x;
			return cross == 0;
		}

		double dist(Point o) {
			double dx = x - o.x;
			double dy = y - o.y;
			return Math.sqrt(dx * dx + dy * dy);
		}

		@Override
		public boolean equals(Object o) {
			Point p = (Point) o;
			return p.x == x && p.y == y;
		}
	}

	static final double EPS = 1e-10;
	// static void sortByAngle(Point base, ArrayList<Point> points) {
	// Collections.sort(points, new Comparator<Point>() {
	// public int compare(Point a, Point b) {
	// a = a.sub(base);
	// b = b.sub(base);
	// double theta1 = Math.atan2(a.y, a.x);
	// double theta2 = Math.atan2(b.y, b.x);
	// if (Math.abs(theta1 - theta2) < EPS) {
	// return Double.compare(base.dist(a), base.dist(b));
	// }
	// return Double.compare(theta1, theta2);
	// }
	// });
	// }

	static void sortByAngle(Point base, ArrayList<Point> points) {
		Collections.sort(points, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (base.isColinear(a, b)) {
					return Double.compare(base.dist(a), base.dist(b));
				}
				if (base.isCounterClockwise(a, b)) {
					return -1;
				}
				return 1;
			}
		});
	}

	static void undoRightTurns(Stack<Point> stack, Point candidate) {
		while (stack.size() >= 2) {
			Point a = stack.get(stack.size() - 2);
			Point b = stack.peek();
			if (a.isCounterClockwise(b, candidate)) {
				break;
			}
			stack.pop();
		}
	}

	static ArrayList<Point> convexHull(ArrayList<Point> points) {
		Point base = bottomLeft(points);
		sortByAngle(base, points);

		Stack<Point> stack = new Stack<Point>();
		stack.push(points.get(0));
		stack.push(points.get(1));

		for (int i = 2; i < points.size(); i++) {
			Point candidate = points.get(i);
			undoRightTurns(stack, candidate);
			stack.push(candidate);
		}
		return new ArrayList<Point>(stack);
	}

	static Point bottomLeft(ArrayList<Point> points) {
		Point bottom = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			Point p = points.get(i);
			if (p.y < bottom.y || (p.y == bottom.y && p.x < bottom.x)) {
				bottom = p;
			}
		}
		return bottom;
	}

	public static boolean contains(Point test, ArrayList<Point> points) {
		int i;
		int j;
		boolean result = false;
		for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
			if ((points.get(i).y > test.y) != (points.get(j).y > test.y)
					&& (test.x < (points.get(j).x - points.get(i).x) * (test.y - points.get(i).y)
							/ (points.get(j).y - points.get(i).y) + points.get(i).x)) {
				result = !result;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Point> cedric = new ArrayList<Point>();
		ArrayList<Point> arthur = new ArrayList<Point>();
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		for (int i = 0; i < a; i++) 
			cedric.add(new Point(scan.nextInt(), scan.nextInt()));
		

		for (int i = 0; i < b; i++) 
			arthur.add(new Point(scan.nextInt(), scan.nextInt()));
		
		int contains = 0;
		for(int i=0;i<arthur.size();i++)
		{
			//cedric.add(arthur.get(i));
			ArrayList<Point> hull = convexHull(cedric);
			if (contains(arthur.get(i), hull) )
			{
				boolean add = true;
				for (int j = 0; j < hull.size(); j++) {
					if (arthur.get(i).equals(hull.get(j))) {
						add = false;
						break;
					}
				}
				if (add)
					contains++;
			}
				
			//cedric.remove(cedric.size()-1);
		}
		System.out.println(arthur.size()-contains);

	}
}
