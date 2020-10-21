package eci.edu.cnyt;

import java.util.ArrayList;

public class SimQuantum {
    OperationsMatriz operationsMatriz = new OperationsMatriz();


    /**
     * Calculo del estado de un sitema sistema despues de n clicks.
     * @param A matriz booleana que describe los caminos de las canicas
     * @param B matriz del estado inicial
     * @param n numero de clicks en los cuales se va a calcular el estado
     * @return tempM matriz de numeros complejos
     */

    public ComplexMatriz addClicks(ComplexMatriz A, ComplexMatriz B, int n) {
        ArrayList<ComplexMatriz> tempM = new ArrayList<ComplexMatriz>();
        tempM.add(A);
        for(int i=1;i<n;i++) {
            tempM.add(operationsMatriz.multiplicacionMatrices(A,tempM.get(0)));
            tempM.remove(0);
        }
//        System.out.println("jklhvvbjkkbvcvbnmv");
        ComplexMatriz tempFinal = operationsMatriz.multiplicacionMatrices(tempM.get(0), B);
        return tempFinal;
    }

    /**
     * Simulacion del experimento de multiples rendijas
     * @param splits Numero de Rendijas
     * @param targets Numero de Blancos
     * @return resp
     */

    public ComplexMatriz program321 (int splits, int targets) {
        int a = 1+splits+targets;
        ComplexMatriz resp= new ComplexMatriz(a,a);
        for(int i=0; i<resp.getc();i++) {
            for(int j=0;j<resp.getf();j++) {
                resp.putInMatriz(new ComplexNumber(0,0),i,j);
            }
        }
        float c = (float)1/splits;
        ComplexNumber probRend = new ComplexNumber(c,0);
        for(int k=1;k<splits;k++) {
            resp.putInMatriz(probRend, k, 0);
        }

        float d = (float) Math.ceil((float) targets/splits);
        float e = (float) 1/d;
        ComplexNumber probBlanco = new ComplexNumber (e,0);
        for(int l=splits+1;l<a;l++) {
            for(int m=1;m<splits;m++) {
                resp.putInMatriz(probBlanco, l, m);
            }
        }

        ComplexNumber f = new ComplexNumber(1,0);
        for(int n=splits+1;n<a;n++) {
            for(int o=splits+1;o<a;o++) {
                if(n==o) {
                    resp.putInMatriz(f, n, o);
                }
            }
        }
        return resp;

    }

    /**
     * Metodo que calcula las probabilidades de cada posicion del ket
     * @param numPos numero de posiciones que tiene el ket
     * @param ket estado inicial de la particula
     * @return probabilidad
     */


    public double calcularProbParticulaxPos(int numPos, ComplexMatriz ket) {
        double probabilidad = Math.pow(ket.getmatriz()[numPos][0].modull(), 2)/Math.pow(operationsMatriz.normaMatriz(ket), 2);
        return probabilidad;
    }


}
