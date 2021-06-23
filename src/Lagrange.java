public class Lagrange {
    Polynomial result = new Polynomial();
    public Lagrange(Grid grid) {
        Point[] points = grid.getPoints();
        int len = points.length;
        double x = 0;
        double num = 0;
        Polynomial tmp1 = new Polynomial();
        Polynomial tmp2 = new Polynomial();

        Polynomial tmp3 = new Polynomial();

        for (int i = 0; i < len; ) {
            x = points[i].getX();
            tmp1.addMon(1, 1);

            for (int j = 0; j < len - 1; j++) {
                if (j == i || (i == 0 && j == 1)){
                    continue;
                }
                tmp2.addMon(1, 1);
                num *= (x - points[j].getX());
                tmp3.addMon(points[j].getX(), 0);
                tmp2.addition(tmp3);
                tmp1.multiplication(tmp2);
            }
            tmp1.multiply(points[i].getY() / num);
            result.addition(tmp1);
        }
    }

    public Polynomial getResult() {
        return result;
    }
}
