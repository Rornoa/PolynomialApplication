public class Grid {

    private Point[] points;

    public Grid(int amount, double a, double b){
        points = new Point[amount];
        points[0] = new Point(a,0);
        points[amount-1] = new Point(b,f(b));
        for (int i = 0; i < amount; i++) {
            points[i] = new Point(a +(i*((b-a) / (amount-1))),f(i+2));
        }
    }

    public double f(double x){
        return Math.sin(x);
    }

    public Point[] getPoints() {
        return points;
    }
}
