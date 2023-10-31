package myfx.newtrianglefx;

import javafx.beans.property.SimpleDoubleProperty;

public class OTriangle {
            SimpleDoubleProperty a,b,c;
        public OTriangle(double a, double b, double c) throws Exception {

            if (a <= 0 || b <= 0 || c <= 0)
                throw new Exception("Ненатуральная длина");
            if (a+b < c || b+c < a || a+c < b)
                throw new Exception("Невозможный треугольник");

            this.a = new SimpleDoubleProperty(a);
            this.b = new SimpleDoubleProperty(b);
            this.c = new SimpleDoubleProperty(c);

            this.a.addListener((val, old, newval)-> System.out.println(old+" ===> "+newval));
        }

       public double getPerim() {
            return a.get() + b.get() + b.get();
        }
       public double getArea() {
            double p = 0.5*getPerim(); //S= √ p ⋅ (p− a) ⋅ (p− b) ⋅ (p− c).
            double triangleSquare = Math.sqrt((p*(p- a.get())*(p- b.get())*(p- b.get())));
            return triangleSquare;
        }

        @Override
        public String toString() {
            return "myfx.newtrianglefx.OTriangle{" +
                    "a=" + a.get() +
                    ", b=" + b.get() +
                    ", c=" + c.get() +
                    '}';
        }

    public double getA() {
        return a.get();
    }

    public void setA(double a) {
        this.a.set(a);
    }

    public void setB(double b) {
        this.b.set(b);
    }

    public void setC(double c) {
        this.c.set(c);
    }

    public SimpleDoubleProperty aProperty() {
        return a;
    }

    public double getB() {
        return b.get();
    }

    public SimpleDoubleProperty bProperty() {
        return b;
    }

    public double getC() {
        return c.get();
    }

    public SimpleDoubleProperty cProperty() {
        return c;
    }
}
