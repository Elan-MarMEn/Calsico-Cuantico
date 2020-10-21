package eci.edu.cnyt;

public class ComplexNumber {
    double realPart;
    double imaginaryPart;


    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber c){
        double r = c.realPart + realPart;
        double i = c.imaginaryPart + imaginaryPart;
        ComplexNumber res = new ComplexNumber(r,i);
        return res;
    }

    public ComplexNumber multiply(ComplexNumber c){
        double realtemp=realPart;

        double r=(realPart*c.realPart - imaginaryPart*c.imaginaryPart);
        double i=(imaginaryPart*c.realPart + realtemp*c.imaginaryPart);
        ComplexNumber res = new ComplexNumber(r,i);
        return res;
    }

    public ComplexNumber rest(ComplexNumber c){
        double r=realPart - c.realPart;
        double i=imaginaryPart - c.imaginaryPart;
        ComplexNumber res = new ComplexNumber(r,i);
        return res;
    }

    public ComplexNumber div(ComplexNumber c){
        double x=c.realPart*c.realPart + c.imaginaryPart*c.imaginaryPart;
        double realtemp=realPart;

        double r=(realPart*c.realPart + imaginaryPart*c.imaginaryPart)/x;
        double i=(imaginaryPart*c.realPart - realtemp*c.imaginaryPart)/x;
        ComplexNumber res = new ComplexNumber(r,i);
        return res;
    }

    public double modull(){
        double m = Math.sqrt(realPart*realPart + imaginaryPart*imaginaryPart);
        return m;
    }

    public ComplexNumber conjugate(){
        double i=-1*imaginaryPart;
        ComplexNumber res = new ComplexNumber(realPart,i);
        return res;
    }

    public void to_polar(){
        double p=phase();
        realPart=modull();
        imaginaryPart=p;
    }

    public void to_cartesian(){
        double realtemp=realPart;
        realPart=realPart*Math.cos(imaginaryPart);
        imaginaryPart=realtemp*Math.sin(imaginaryPart);
    }

    public double phase(){
        double f = Math.atan(imaginaryPart/realPart);
        return f;
    }



}
