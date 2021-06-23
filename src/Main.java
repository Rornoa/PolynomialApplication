public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(6, 1, 7);
        Point[] points = grid.getPoints();

        Polynomial lagrange = new Lagrange(grid);
        System.out.printf("Lagrange polynomial:\t");
        lagrange = ((Lagrange) lagrange).getResult();
        lagrange.print();
        Grid lGrid = new Grid(6, 1, 7);

        Polynomial newton = new Newton(grid);
        System.out.printf("Newton polynomial:\t");
        newton = ((Newton) newton).getResult();
        newton.print();
        Grid nGrid = new Grid(6,1,7);

        Grid control = new Grid(6, 1, 7);

        System.out.println("\n");
        System.out.printf("%4s\t%-16s%-16s%-16s%-16s%-16s%n", "Point", "x", "y", "f(x)", "Lagrange", "Newton");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%4d%16e%16e%16e%16e%16e%n", i, control.getPoints()[i].getX(), grid.getPoints()[i].getY(), control.getPoints()[i].getY(), lGrid.getPoints()[i].getY(), nGrid.getPoints()[i].getY());
        }
    }
}
