public class Monomial {
    int pow;
    double coef;
    Monomial next;

    Monomial(double coef, int pow){
        this.pow = pow;
        this.coef = coef;
        next=null;
    }
}
