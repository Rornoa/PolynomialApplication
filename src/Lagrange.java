public class Lagrange extends Polynomial {

    Polynomial result = new Polynomial();

    public Lagrange(Grid grid){
        Point[] points = grid.getPoints();
        double k=1;
        int len = points.length;
        Polynomial bi = new Polynomial();
        bi.addMon(-1,0);
        bi.addMon(1,1);

        for (int i = 0; i < len; i++) {
            Polynomial base = new Polynomial();
            base.addMon(1,0);

            for (int j = 0; j < i; j++) {
                bi.change(-points[j].getX());
                base.multiplication(bi);
            }
            for (int j = i+1; j < len; j++) {
                bi.change(-points[j].getX());
                base.multiplication(bi);
            }
            for (int j = 0; j < i; j++){
                k/= points[i].getX() - points[j].getX();
            }
            for (int j = i+1; j < len ; j++) {
                k/=points[i].getX()-points[j].getX();
            }

            k *= points[i].getY();
            base.multiply(k);
            result.addition(base);
        }
        result.deleteZeros();
    }

    public Polynomial getResult() {
        return result;
    }
}
