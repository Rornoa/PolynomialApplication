public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(6, 0, Math.PI);
        Point[] points = grid.getPoints();

        Polynomial lagrange = new Lagrange(points);
        lagrange.print();
        lagrange = ((Lagrange) lagrange).getResult();

        Polynomial newton = new Newton(points);
        newton.print();
        newton = ((Newton) newton).getResult();

        System.out.println("\n");
        System.out.printf("%4s\t%-16s%-16s%-16s%-16s%-16s%n", "Point", "x", "y", "f(x)", "Lagrange", "Newton");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%4d%16e%16e%16e%16e%16e%n", i, grid.getPoints()[i].getX(), grid.getPoints()[i].getY(), grid.getPoints()[i].getY(), lagrange.solveByHorner(grid.getPoints()[i].getX()), newton.solveByHorner(grid.getPoints()[i].getX()));
        }
    }
}
