public class Polynomial {

    Monomial head;

    public void addMon(double coef, int pow) {
        if (head == null)
            head = new Monomial(
                    coef,
                    pow);
        if (head != null && pow > head.pow) {
            Monomial tmp = head;
            head = new Monomial(
                    coef,
                    pow);
            head.next = tmp;
        }
    }

    public void print() {
        Monomial tmp = head;
        System.out.println("");
        while (tmp != null) {
            System.out.print(tmp.coef + "X^" + tmp.pow + " + ");
            tmp = tmp.next;
        }
    }

    public double solveByHorner(double x) {
        Monomial tmp = this.head;
        int max = tmp.pow;
        double y = 0;
        for (int i = max; i > 0; i--) {
            if (tmp != null && tmp.pow == i) {
                y += tmp.coef;
                y *= x;
                tmp = tmp.next;
            } else y *= x;
        }
        if (tmp != null && tmp.pow == 0)
            y += tmp.coef;
        return y;
    }


    public void multiply(double c) {
        if (head == null)
            return;
        if (c == 0)
            head = null;
        Monomial tmp = head;
        while (head != null) {
            head.coef *= c;
            head = head.next;
        }
        head = tmp;
    }

    public void addition(Polynomial p1) {
        if (p1.head == null) return;
        if (head == null) {
            head = new Monomial(
                    p1.head.coef,
                    p1.head.pow);
            for (Monomial i = p1.head.next; i != null; i = i.next) {
                head.next = new Monomial(
                        i.coef,
                        i.pow);
                head = head.next;
            }
            return;
        }
        Monomial cur1 = head;
        Monomial cur2 = p1.head;

        head = new Monomial(0, 0);
        Monomial c = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.pow == cur2.pow) {
                c.next = cur1;
                c = c.next;
                cur1.coef += cur2.coef;
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else {
                if (cur1.pow > cur2.pow) {
                    c.next = cur1;
                    cur1 = cur1.next;
                } else {
                    c.next = new Monomial(
                            cur2.coef,
                            cur2.pow);
                    cur2 = cur2.next;
                }
                c = c.next;
            }
        }
        if (cur1 != null)
            c.next = cur1;
        if (cur2 != null) {
            Monomial h = new Monomial(
                    cur2.coef,
                    cur2.pow);
            Monomial j = h;
            for (Monomial i = cur2.next; i != null; i = i.next) {
                j.next = new Monomial(
                        i.coef,
                        i.pow);
                j = j.next;
            }
            c.next = h;
        }
        head = head.next;
    }

    public void change(double coef) {
        Monomial m = head;
        while (m.next != null)
            m = m.next;
        m.coef = coef;
    }

    public void multiplication(Polynomial p1) {
        if (p1.head == null || head == null) return;


        Monomial resH = new Monomial(
                p1.head.coef * head.coef,
                p1.head.pow + head.pow);
        Monomial curR = resH;

        for (Monomial i = head.next; i != null; i = i.next) {
            curR.next = new Monomial(
                    p1.head.coef * i.coef,
                    p1.head.pow + i.pow);
            curR = curR.next;
        }

        for (Monomial cur2 = p1.head.next; cur2 != null; cur2 = cur2.next) {
            curR = resH;
            for (Monomial cur1 = head; cur1 != null; cur1 = cur1.next) {
                Monomial tmp = new Monomial(
                        cur2.coef * cur1.coef,
                        cur2.pow + cur1.pow
                );
                Monomial prev = null;
                while (curR != null && tmp.pow < curR.pow) {
                    prev = curR;
                    curR = curR.next;
                }
                if (curR != null && tmp.pow == curR.pow) {
                    curR.coef += tmp.coef;
                } else {
                    prev.next = tmp;
                    tmp.next = curR;
                }
            }
        }
        head = resH;
    }

    public void deleteZeros() {
        Monomial t1 = head;
        Monomial t2 = head.next;
        while (t2 != null) {
            if (Math.abs(t2.coef) < 1e-8) {
                t1.next = t2.next;
                t2 = t1.next;
            } else {
                t1 = t2;
                t2 = t2.next;
            }
        }
    }
}
