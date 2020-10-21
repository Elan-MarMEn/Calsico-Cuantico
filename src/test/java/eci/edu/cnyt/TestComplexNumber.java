package eci.edu.cnyt;

import junit.framework.TestCase;

public class TestComplexNumber extends TestCase {



    public void testadd(){
        ComplexNumber c= new ComplexNumber(12,14);
        ComplexNumber c2= new ComplexNumber(26,34);
        ComplexNumber res = c2.add(c);

        assertEquals(res.getRealPart(),38.0);
        assertEquals(res.getImaginaryPart(),48.0);
    }

    public void testadd2(){
        ComplexNumber c= new ComplexNumber(12,-24);
        ComplexNumber c2= new ComplexNumber(26,-43);
        ComplexNumber res = c2.add(c);

        assertEquals(res.getRealPart(),38.0);
        assertEquals(res.getImaginaryPart(),-1*(67.0));
    }

//    public void testadd3(){
//        ComplexNumber c= new ComplexNumber(a,b);
//        c.add(c);
//
//        assertEquals(c.getRealPart(),2*a);
//        assertEquals(c.getImaginaryPart(),2*b);
//    }

    public void testmultiply(){
        ComplexNumber c= new ComplexNumber(12,14);
        ComplexNumber c2= new ComplexNumber(26,34);
        ComplexNumber res =c.multiply(c2);

        assertEquals(res.getRealPart(),-164.0);
        assertEquals(res.getImaginaryPart(),772.0);
    }

    public void testmultiply2(){
        ComplexNumber c= new ComplexNumber(12,-45);
        ComplexNumber c2= new ComplexNumber(26,-26);
        ComplexNumber res = c.multiply(c2);
        assertEquals(res.getRealPart(),-858.0);
        assertEquals(res.getImaginaryPart(),-1*(1482.0));
    }

    public void testrest(){
        ComplexNumber c= new ComplexNumber(12,14);
        ComplexNumber c2= new ComplexNumber(26,34);
        ComplexNumber res =c2.rest(c);

        assertEquals(res.getRealPart(),14.0);
        assertEquals(res.getImaginaryPart(),20.0);
    }

    public void testrest2(){
        ComplexNumber c= new ComplexNumber(12,-98);
        ComplexNumber c2= new ComplexNumber(26,-102);
        ComplexNumber res =c2.rest(c);

        assertEquals(res.getRealPart(),14.0);
        assertEquals(res.getImaginaryPart(),-1*(4.0));
    }

    public void testdiv(){
        ComplexNumber c= new ComplexNumber(12,14);
        ComplexNumber c2= new ComplexNumber(26,34);
        ComplexNumber res = c.div(c2);
        double x =(12.0*26.0 + 14.0*34.0)/(26*26 + 34*34);
        double y =(14.0*26.0 -12.0*34.0)/(26*26 + 34*34);

        assertEquals(res.getRealPart(),x);
        assertEquals(res.getImaginaryPart(),y);
    }

    public void testmodul(){
        ComplexNumber c= new ComplexNumber(12,14);
        double y = Math.sqrt(12*12 + 14*14);

        assertEquals(c.modull(),y);
    }

    public void testconjugate(){
        ComplexNumber c= new ComplexNumber(12,14);
        ComplexNumber res =c.conjugate();

        assertEquals(res.getImaginaryPart(),-14.0);
    }

    public void testto_polarTo_Cartisian(){
        ComplexNumber c= new ComplexNumber(12,14);
        double r=c.modull();
        c.to_polar();

        assertEquals(c.getRealPart(),r);
    }

    public void testto_polarTo_Cartisian2(){
        ComplexNumber c= new ComplexNumber(12,14);
        double t = c.phase();
        c.to_polar();
        assertEquals(c.getImaginaryPart(),t);
    }






}
