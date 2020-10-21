package eci.edu.cnyt;

import junit.framework.TestCase;

public class OperationsMatrizTest extends TestCase {

    private OperationsMatriz op = new OperationsMatriz();
    private ComplexNumber c;
    private ComplexNumber c2;
    private ComplexMatriz m1;
    private ComplexMatriz m2;

    public void testSumaVectores() {

        c= new ComplexNumber(10,5);
        c2= new ComplexNumber(6,0);
        m1 = new ComplexMatriz(2);
        m1.putInVector(c, 0);
        m1.putInVector(c2, 1);
        m2 = new ComplexMatriz(2);
        m2.putInVector(c, 0);
        m2.putInVector(c2, 1);

        ComplexMatriz res = op.sumaVectores(m1,m2);

        assertEquals(res.getvector()[0].getRealPart(),20.0);
        assertEquals(res.getvector()[0].getImaginaryPart(),10.0);
        assertEquals(res.getvector()[1].getRealPart(),12.0);

    }

    public void testRestaVectores() {
        c= new ComplexNumber(10,5);
        c2= new ComplexNumber(6,0);
        m1 = new ComplexMatriz(2);
        m1.putInVector(c, 0);
        m1.putInVector(c2, 1);
        m2 = new ComplexMatriz(2);
        m2.putInVector(c, 0);
        m2.putInVector(c2, 1);

        ComplexMatriz res = op.restaVectores(m1,m2);

        assertEquals(res.getvector()[0].getRealPart(),0.0);
        assertEquals(res.getvector()[0].getImaginaryPart(),0.0);
        assertEquals(res.getvector()[1].getRealPart(),0.0);
    }

    public void testProductoEscalarVector() {
        c= new ComplexNumber(12,14);
        c2= new ComplexNumber(26,34);
        m1 = new ComplexMatriz(2);
        m1.putInVector(c, 0);
        m1.putInVector(c, 1);


        ComplexMatriz res = op.productoEscalarVector(m1,c2);

        assertEquals(res.getvector()[0].getRealPart(),-164.0);
        assertEquals(res.getvector()[0].getImaginaryPart(),772.0);

    }



    public void testSumaComplexMatrizs() {
        c= new ComplexNumber(10,5);
        c2= new ComplexNumber(6,0);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(c,1,1);
        m2 = new ComplexMatriz(2,2);
        m2.putInMatriz(c2,0,0);
        m2.putInMatriz(c2,0,1);
        m2.putInMatriz(c2,1,0);
        m2.putInMatriz(c2,1,1);
        ComplexMatriz res = op.sumaComplexMatrizs(m1,m2);

        assertEquals(res.getmatriz()[0][0].getRealPart(),16.0);
        assertEquals(res.getmatriz()[1][1].getImaginaryPart(),5.0);
    }

    public void testRestaComplexMatrizs() {
        c= new ComplexNumber(10,5);
        c2= new ComplexNumber(6,0);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(c,1,1);
        m2 = new ComplexMatriz(2,2);
        m2.putInMatriz(c2,0,0);
        m2.putInMatriz(c2,0,1);
        m2.putInMatriz(c2,1,0);
        m2.putInMatriz(c2,1,1);
        ComplexMatriz res = op.restaComplexMatrizs(m1,m2);

        assertEquals(res.getmatriz()[0][0].getRealPart(),4.0);
        assertEquals(res.getmatriz()[1][1].getImaginaryPart(),5.0);
    }

    public void testProductoEscalarMatriz() {
        c= new ComplexNumber(12,-45);
        c2= new ComplexNumber(26,-26);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(c,1,1);
        ComplexMatriz res = op.productoEscalarMatriz(c2,m1);

        assertEquals(res.getmatriz()[0][0].getRealPart(),-858.0);
        assertEquals(res.getmatriz()[1][1].getImaginaryPart(),-1*(1482.0));
    }

    public void testTranspuesta() {
        c= new ComplexNumber(1,3);
        c2= new ComplexNumber(2,4);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c2,1,0);
        m1.putInMatriz(c2,1,1);
        ComplexMatriz res = op.transpuesta(m1);
        assertEquals(res.getmatriz()[0][1].getRealPart(),2.0);
        assertEquals(res.getmatriz()[1][0].getImaginaryPart(),3.0);

    }

    public void testConjugada() {
        c= new ComplexNumber(1,3);
        c2= new ComplexNumber(2,4);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c2,1,0);
        m1.putInMatriz(c2,1,1);

        ComplexMatriz res = op.conjugada(m1);

        assertEquals(res.getmatriz()[0][0].getImaginaryPart(),-3.0);
        assertEquals(res.getmatriz()[1][0].getImaginaryPart(),-4.0);
    }

    public void testConjugadaVector() {
        c= new ComplexNumber(1,4);
        c2= new ComplexNumber(6,3);
        m1 = new ComplexMatriz(2);
        m1.putInVector(c, 0);
        m1.putInVector(c2, 1);


        ComplexMatriz res = op.conjugadaVector(m1);

        assertEquals(res.getvector()[0].getImaginaryPart(),-4.0);
        assertEquals(res.getvector()[1].getImaginaryPart(),-3.0);
    }

    public void testAdjunta() {
        c= new ComplexNumber(1,3);
        c2= new ComplexNumber(2,4);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c2,1,0);
        m1.putInMatriz(c2,1,1);
        ComplexMatriz res = op.adjunta(m1);
        assertEquals(res.getmatriz()[0][1].getImaginaryPart(),-4.0);
        assertEquals(res.getmatriz()[1][0].getImaginaryPart(),-3.0);
    }

    public void testMultiplicacionMatrices() {
        c= new ComplexNumber(1,5);
        c2= new ComplexNumber(2,2);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(c,1,1);
        m2 = new ComplexMatriz(2,2);
        m2.putInMatriz(c2,0,0);
        m2.putInMatriz(c2,0,1);
        m2.putInMatriz(c2,1,0);
        m2.putInMatriz(c2,1,1);
        ComplexMatriz res = op.multiplicacionMatrices(m1,m2);
        assertEquals(res.getmatriz()[0][0].getRealPart(),-16.0);
        assertEquals(res.getmatriz()[1][1].getImaginaryPart(),24.0);

    }

    public void testDistanciaVectores() {
    }

    public void testNormaMatriz() {
        c= new ComplexNumber(0,0);
        c2= new ComplexNumber(2,0);

        m1 = new ComplexMatriz(2);
        m1.putInVector(c, 0);
        m1.putInVector(c2, 1);

        Double res = op.normaMatriz(m1);

        assertEquals(res,2.0);

    }

    public void testUnitaria() {
        Double val = 1/Math.sqrt(2);
        c = new ComplexNumber(0,val);
        c2 = new ComplexNumber(0,-val);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(c,0,0);
        m1.putInMatriz(c2,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(c,1,1);

        boolean res = op.Unitaria(m1);

        assertEquals(res,true);

    }

    public void testHermitiana() {
        ComplexNumber z = new ComplexNumber(1,0);
        ComplexNumber z1 = new ComplexNumber(-1,0);
        c = new ComplexNumber(0,1);
        c2 = new ComplexNumber(0,-1);
        m1 = new ComplexMatriz(2,2);
        m1.putInMatriz(z1,0,0);
        m1.putInMatriz(c2,0,1);
        m1.putInMatriz(c,1,0);
        m1.putInMatriz(z,1,1);

        boolean res = op.Hermitiana(m1);

        assertEquals(res,true);

    }

    public void testProductoInterno() {
        c= new ComplexNumber(2,1);
        c2= new ComplexNumber(1,-3);
        ComplexNumber z= new ComplexNumber(0,1);
        ComplexNumber z1= new ComplexNumber(1,0);
        ComplexNumber z2= new ComplexNumber(2,0);

        m1 = new ComplexMatriz(3);
        m1.putInVector(z1, 0);
        m1.putInVector(z, 1);
        m1.putInVector(c2, 2);

        m2 = new ComplexMatriz(3);
        m2.putInVector(c, 0);
        m2.putInVector(z, 1);
        m2.putInVector(z2, 2);

        ComplexNumber res = op.productoInterno(m1,m2);

        assertEquals(res.getRealPart(),5.0);
        assertEquals(res.getImaginaryPart(),7.0);

    }

    public void testProductoTensor() {
    }
}