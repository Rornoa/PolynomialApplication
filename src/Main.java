public class Main {
    public static void main(String[] args) {

        int steps = 6;
        Grid grid = new Grid(6, 1, 7);
        Point[] points = grid.getPoints();

        Lagrange lP = new Lagrange(grid);
        Polynomial resL = lP.getResult();
        System.out.println("Lagrange ");
        resL.print();

        Newton nP = new Newton(grid);
        Polynomial resN = nP.getResult();
        System.out.println("Newton ");
        resN.print();

        System.out.println("");
        System.out.printf("%15s%15s%15s%15s%15s%15s\n",     "",     "X",        "Y",        "f(X)",     "LAGRANGE",     "NEWTON");
        for (int i = 0; i < points.length-1; i++) {
            System.out.printf("%4d%16.6e%16.6e%16.6e%16.6e%16.6e%n",
                    i, points[i].getX(), points[i].getY()
                    );

        }
    }
}
