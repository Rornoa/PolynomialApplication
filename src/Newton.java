public class Newton extends Polynomial {

    Polynomial result;

    public Newton(Grid grid){
        Point[] points = grid.getPoints();
        double[] dd = calcDD(points);

        // Nn(x) = f(x0) + f(x0,x1)*(x-x0) + f(x0,x1,x2)*(x-x0)*(x-x1) + ... + f(x0,x1,...,xn)*(x-x0)*(x-x1)...(x-xn-1)
        Polynomial Nn = new Polynomial();
        Nn.addMon(points[0].getY(),0); // f(x0)

        Polynomial tmp1 = new Polynomial();
        tmp1.addMon(0,0);

        Polynomial tmp2 = new Polynomial();
        tmp2.addMon(-1,0);
        tmp2.addMon(1,1);

        Polynomial tmp3 = new Polynomial();

        for (int i = 0; i < points.length-1; i++){ //f(x0,x1)*(x-x0) + f(x0,x1,x2)*(x-x0)*(x-x1) + ... + f(x0,x1,...,xn)*(x-x0)*(x-x1)...(x-xn-1)
            tmp3.addMon(-points[i].getX(),0);
            tmp2.addition(tmp3);
            tmp1.multiplication(tmp2);
            tmp1.multiply(dd[i]);
            this.addition(tmp1);
            tmp1.multiply(1/dd[i]);
        }
    }

    public double[] calcDD(Point[] points){
        int len = points.length;
        double[] res = new double[len];
        double[] tmp1 = new double[len];
        double[] tmp2 = new double[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                tmp2[j] = (tmp1[j + 1] - tmp1[j]) / (points[j + 1].getX() - points[j].getX());
            }
            res[i] = tmp2[i];
            tmp1 = tmp2;
            tmp2 = new double[len];
        }
        return res;
    }

    public Polynomial getResult() {
        return result;
    }
}
