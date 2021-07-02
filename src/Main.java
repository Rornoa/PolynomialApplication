public class Main {
    public static void main(String[] args) {
        int len = 7;
        Grid grid = new Grid(len, 0, 1);
        Point[] points = grid.getPoints();

        Polynomial lagrange = new Lagrange(points);
        lagrange.print();

        Polynomial newton = new Newton(points);
        newton.print();

        System.out.println();
        System.out.printf("%4s\t%-16s%-16s%-16s%-16s%-16s%n", "Point", "x", "y", "f(x)", "Lagrange", "Newton");
        for (int i = 0; i < len; i++) {
            double x = grid.getPoints()[i].getX();
            System.out.printf("%4d%16e%16e%16e%16e%16e%n", i*2, x, grid.getPoints()[i].getY(), grid.f(x), lagrange.solveByHorner(x), newton.solveByHorner(x));
            double extraX = grid.getPoints()[i].getX()+grid.getGap()/2;
            System.out.printf("%4d%16e%32e%16e%16e%n", i*2+1, extraX, grid.f(extraX), lagrange.solveByHorner(extraX), newton.solveByHorner(extraX));
        }
    }
}
