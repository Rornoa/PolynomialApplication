public class Newton extends Polynomial {

    Polynomial result = new Polynomial();

    public Newton(Point[] points){
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
            tmp2.change(-points[i].getX());
            tmp1.multiplication(tmp2);
            tmp1.multiply(dd[i]);
            result.addition(tmp1);
            tmp1.multiply(1/dd[i]);
        }
        result.deleteZeros();
    }

    public double[] calcDD(Point[] points){

        int len = points.length;
        double[] res = new double[len];
        double[] tmp1 = new double[len];
        double[] tmp2 = new double[len];

        res[0]=points[0].getY();
        for (int i = 1; i < points.length-1; i++) {
            tmp1[i]= (points[i+1].getY() - points[i].getY()) / (points[i+1].getX() - points[i].getX());
        }
        len=len-1;
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len-1; j++) {
                tmp2[j] = (tmp1[j + 1] - tmp1[j]) / (points[j + i].getX() - points[j].getX());
            }
            res[i+1] = tmp2[0];
            tmp1 = tmp2;
            len=len-1;
        }
        return res;
    }

    public Polynomial getResult() {
        return result;
    }
}
