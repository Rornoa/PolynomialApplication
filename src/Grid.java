 class Grid {

    private Point[] points;
   private double gap;
     Grid(int amount, double a, double b){
        points = new Point[amount];
        gap = (b-a)/(amount - 1);
        for (int i = 0; i < amount; i++)
            points[i] = new Point(a + (i*gap),f(a+(i*gap)));
    }

   double f(double x){
        return Math.sin(x*x/2);
    }

     Point[] getPoints() {
        return points;
    }

      double getGap() {
         return gap;
     }
 }
