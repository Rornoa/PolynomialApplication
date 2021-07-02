public class Newton extends Polynomial {

     Newton(Point[] points){
        double[] dd = calcDD(points);

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        p1.addMon(1,0);
        p2.addMon(-1,0);
        p2.addMon(1,1);
         p2.change(-points[0].getX());
         p1.multiplication(p2);
         p1.multiply(dd[0]);
         addition(p1);
        for (int i = 1; i < points.length-1; i++) {
            p2.change(-points[i].getX());
            p1.multiplication(p2);
            p1.multiply(dd[i]/dd[i-1]);
            addition(p1);
        }
        deleteZeros();
    }

   private double[] calcDD(Point[] points) {
       int len = points.length;
       double[] res = new double[len - 1];
       double[] tmp1 = new double[len - 1];
       double[] tmp2 = new double[len - 2];

       for (int i = 0; i < len - 1; i++)
           tmp1[i] = (points[i + 1].getY() - points[i].getY()) / (points[i + 1].getX() - points[i].getX());

       res[0] = tmp1[0];
       len = len - 1;
       for (int i = 2; i < points.length; i++) {
           for (int j = 0; j < len - 1; j++)
               tmp2[j] = (tmp1[j + 1] - tmp1[j]) / (points[j + i].getX() - points[j].getX());
           res[i - 1] = tmp2[0];
           tmp1 = tmp2;
           len = len - 1;
       }
       return res;
   }

    @Override
    public void print() {
        System.out.print("Newton polynomial");
        super.print();
    }
}
