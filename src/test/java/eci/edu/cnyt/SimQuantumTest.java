package eci.edu.cnyt;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;


public class SimQuantumTest{
    private SimQuantum simQuantum = new SimQuantum();
    private OperationsMatriz op = new OperationsMatriz();
    private ComplexNumber c;
    private ComplexNumber c2;
    private ComplexMatriz m1;
    private ComplexMatriz m2;



    @Test
    public void addClicks() {
        m1 = new ComplexMatriz(6,6);
        m2 = new ComplexMatriz(6,1);
        m1.putInMatriz(new ComplexNumber(0,0), 0, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 2, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 0);
        m1.putInMatriz(new ComplexNumber(1,0), 5, 0);

        m1.putInMatriz(new ComplexNumber(0,0), 0, 1);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 1);
        m1.putInMatriz(new ComplexNumber(1,0), 2, 1);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 1);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 1);
        m1.putInMatriz(new ComplexNumber(0,0), 5, 1);


        m1.putInMatriz(new ComplexNumber(0,0), 0, 2);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 2);
        m1.putInMatriz(new ComplexNumber(0,0), 2, 2);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 2);
        m1.putInMatriz(new ComplexNumber(1,0), 4, 2);
        m1.putInMatriz(new ComplexNumber(0,0), 5, 2);


        m1.putInMatriz(new ComplexNumber(0,0), 0, 3);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 3);
        m1.putInMatriz(new ComplexNumber(0,0), 2, 3);
        m1.putInMatriz(new ComplexNumber(1,0), 3, 3);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 3);
        m1.putInMatriz(new ComplexNumber(0,0), 5, 3);

        m1.putInMatriz(new ComplexNumber(0,0), 0, 4);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 4);
        m1.putInMatriz(new ComplexNumber(0,0), 2, 4);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 4);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 4);
        m1.putInMatriz(new ComplexNumber(1,0), 5, 4);

        m1.putInMatriz(new ComplexNumber(0,0), 0, 5);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 5);
        m1.putInMatriz(new ComplexNumber(1,0), 2, 5);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 5);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 5);
        m1.putInMatriz(new ComplexNumber(0,0), 5, 5);


        m2.putInMatriz(new ComplexNumber(6,0),0,0);
        m2.putInMatriz(new ComplexNumber(2,0),1,0);
        m2.putInMatriz(new ComplexNumber(1,0),2,0);
        m2.putInMatriz(new ComplexNumber(5,0),3,0);
        m2.putInMatriz(new ComplexNumber(3,0),4,0);
        m2.putInMatriz(new ComplexNumber(10,0),5,0);


        ComplexMatriz m3= new ComplexMatriz(6,1);
        m3.putInMatriz(new ComplexNumber(0,0),0 ,0 );
        m3.putInMatriz(new ComplexNumber(0,0),1 ,0 );
        m3.putInMatriz(new ComplexNumber(12,0),2 ,0 );
        m3.putInMatriz(new ComplexNumber(5,0),3 ,0 );
        m3.putInMatriz(new ComplexNumber(1,0),4 ,0 );
        m3.putInMatriz(new ComplexNumber(9,0),5 ,0 );


        assertEquals(true,
                simQuantum.addClicks(m1,m2,1).getmatriz()[2][0].imaginaryPart==m3.getmatriz()[2][0].imaginaryPart);

        //        ComplexMatriz m4 = new ComplexMatriz(6,1);
        m3.putInMatriz(new ComplexNumber(0,0),0 ,0 );
        m3.putInMatriz(new ComplexNumber(0,0),1 ,0 );
        m3.putInMatriz(new ComplexNumber(9,0),2 ,0 );
        m3.putInMatriz(new ComplexNumber(5,0),3 ,0 );
        m3.putInMatriz(new ComplexNumber(12,0),4 ,0 );
        m3.putInMatriz(new ComplexNumber(1,0),5 ,0 );


        assertEquals(true,
                simQuantum.addClicks(m1,m2,1).getmatriz()[4][0].imaginaryPart==m3.getmatriz()[4][0].imaginaryPart);


        m3.putInMatriz(new ComplexNumber(0,0),0 ,0 );
        m3.putInMatriz(new ComplexNumber(0,0),1 ,0 );
        m3.putInMatriz(new ComplexNumber(1,0),2 ,0 );
        m3.putInMatriz(new ComplexNumber(5,0),3 ,0 );
        m3.putInMatriz(new ComplexNumber(9,0),4 ,0 );
        m3.putInMatriz(new ComplexNumber(12,0),5 ,0 );

        assertEquals(true,
                simQuantum.addClicks(m1,m2,1).getmatriz()[5][0].imaginaryPart==m3.getmatriz()[5][0].imaginaryPart);

    }

    @Test
    public void program321() {
        System.out.println("Prueba 3.2.2");
        int r=2;
        int b=5;
        System.out.println("Numero de rendijas: "+r);
        System.out.println("Numero de blancos: "+b);
        ComplexMatriz m2 = simQuantum.program321(r, b);

        ComplexMatriz m1 = new ComplexMatriz(8,1);
        m1.putInMatriz(new ComplexNumber(1,0), 0, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 1, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 2, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 3, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 4, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 5, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 6, 0);
        m1.putInMatriz(new ComplexNumber(0,0), 7, 0);
        System.out.println(m1);
        assertEquals(true,m2.getmatriz()[0][0].imaginaryPart==m1.getmatriz()[0][0].imaginaryPart);

    }


//    @Test
//    public void calcularProbParticulaxPos() {
//        m1 = new ComplexMatriz(4,1);
//        m1.putInMatriz(new ComplexNumber(-3,-1), 0, 0);
//        m1.putInMatriz(new ComplexNumber(0,-2), 1, 0);
//        m1.putInMatriz(new ComplexNumber(0,1), 2, 0);
//        m1.putInMatriz(new ComplexNumber(2,0), 3, 0);
//
//        ComplexMatriz m2 = new ComplexMatriz(4,1);
//        m2.putInMatriz(new ComplexNumber(0.5263157894736842,0), 0, 0);
//        m2.putInMatriz(new ComplexNumber(0.21052631578947364,0), 1, 0);
//        m2.putInMatriz(new ComplexNumber(0.05263157894736841,0), 2, 0);
//        m2.putInMatriz(new ComplexNumber(0.21052631578947364,0), 3, 0);
//
//        int p = 2;
//        System.out.println(simQuantum.calcularProbParticulaxPos(2, m1));
//
////        assertEquals(m2.getmatriz()[p][0].realPart,simQuantum.calcularProbParticulaxPos(p, m1),1);
//        assertEquals();
//    }
}