package eci.edu.cnyt;

public class OperationsMatriz {
    
    public ComplexMatriz sumaVectores(ComplexMatriz v1, ComplexMatriz v2) {
        ComplexMatriz newVector = new ComplexMatriz(v1.getlengthVector());

        for (int i=0; i<v1.getlengthVector();i++) {
            ComplexNumber temp = v1.getvector()[i].add(v2.getvector()[i]);
            newVector.getvector()[i]=temp;
        }
        return newVector;

    }

    public ComplexMatriz restaVectores(ComplexMatriz v1, ComplexMatriz v2) {
        ComplexMatriz newVector = new ComplexMatriz(v1.getlengthVector());

        for (int i=0; i<v1.getlengthVector();i++) {

            ComplexNumber temp = v1.getvector()[i].rest(v2.getvector()[i]);
            newVector.getvector()[i]=temp;
        }
        return newVector;

    }

    public ComplexMatriz productoEscalarVector(ComplexMatriz v1, ComplexNumber a) {
        ComplexMatriz newVector = new ComplexMatriz(v1.getlengthVector());
        for (int i=0; i<v1.getlengthVector();i++) {

            ComplexNumber temp = v1.getvector()[i].multiply(a);;
            newVector.getvector()[i]=temp;
        }

        return newVector;
    }

    public ComplexMatriz sumaComplexMatrizs(ComplexMatriz A, ComplexMatriz B) {
        if((A.getf()==B.getf()) && (A.getc()==B.getc())) {
            ComplexMatriz newMatriz= new ComplexMatriz(A.getf(),A.getc());

            for(int i=0;i<A.getf();i++) {

                for(int j=0;j<B.getc();j++) {

                    ComplexNumber temp = A.getmatriz()[i][j].add(B.getmatriz()[i][j]);
                    newMatriz.getmatriz()[i][j]=temp;
                }
            }
            return newMatriz;

        }
        else {
            return null;
        }

    }

    public ComplexMatriz restaComplexMatrizs(ComplexMatriz A, ComplexMatriz B) {
        if((A.getf()==B.getf()) && (A.getc()==B.getc())) {
            ComplexMatriz newMatriz = new ComplexMatriz(A.getf(),A.getc());

            for(int i=0;i<A.getf();i++) {

                for(int j=0;j<B.getc();j++) {

                    ComplexNumber temp = A.getmatriz()[i][j].rest(B.getmatriz()[i][j]);
                    newMatriz.getmatriz()[i][j]=temp;
                }
            }
            return newMatriz;
        }
        else {
            return null;
        }
    }

    public ComplexMatriz productoEscalarMatriz( ComplexNumber c, ComplexMatriz A) {
        ComplexMatriz newMatriz = new ComplexMatriz(A.getc(),A.getf());

        for(int i=0; i<A.getc();i++) {

            for (int j=0;j<A.getf();j++) {

                ComplexNumber temp = A.getmatriz()[i][j].multiply(c);
                newMatriz.getmatriz()[i][j]=temp;
            }
        }
        return newMatriz;
    }

    public ComplexMatriz transpuesta(ComplexMatriz A) {
        ComplexMatriz newMatriz = new ComplexMatriz(A.getf(),A.getc());

        for(int i=0; i<newMatriz.getc();i++) {
            for(int j=0; j<newMatriz.getf();j++) {
                newMatriz.getmatriz()[i][j]=A.getmatriz()[j][i];
            }
        }
        return newMatriz;
    }

    public ComplexMatriz conjugada(ComplexMatriz A) {
        ComplexMatriz newMatriz = new ComplexMatriz(A.getc(),A.getf());

        for(int i=0; i<newMatriz.getc();i++) {

            for(int j=0; j<newMatriz.getf();j++) {

                ComplexNumber temp = A.getmatriz()[i][j].conjugate();
                newMatriz.getmatriz()[i][j] = temp;
            }
        }
        return newMatriz;
    }

    public ComplexMatriz conjugadaVector(ComplexMatriz A) {
        ComplexMatriz newVector = new ComplexMatriz(A.getlengthVector());

        for(int i=0; i<newVector.getlengthVector();i++) {
            ComplexNumber temp = A.getvector()[i].conjugate();
            newVector.getvector()[i] = temp;
        }
        return newVector;
    }

    public ComplexMatriz adjunta(ComplexMatriz A) {
        return conjugada(transpuesta(A));
    }

    public ComplexMatriz multiplicacionMatrices(ComplexMatriz A, ComplexMatriz B) {
        ComplexMatriz newMatriz = new ComplexMatriz(A.getc(),B.getf());
        if(A.getf()==B.getc() && B.getc()>1) {
            for(int i=0; i<A.getc();i++) {
                for(int j=0; j<B.getf();j++) {
                    ComplexNumber temp = new ComplexNumber(0,0);
                    for(int k=0; k<B.getf();k++) {

                        ComplexNumber temp2 = A.getmatriz()[i][k].multiply(B.getmatriz()[k][j]);

                        temp=temp.add(temp2);
                    }

                    newMatriz.getmatriz()[i][j]=temp;
                }
            }
        }else {
            for(int i=0; i<A.getc();i++) {
                for(int j=0; j<B.getf();j++) {
                    ComplexNumber temp = new ComplexNumber(0,0);
                    for(int k=0; k<B.getf();k++) {

                        ComplexNumber temp2 = A.getmatriz()[i][k].multiply(B.getmatriz()[k][0]);

                        temp=temp.add(temp2);
                    }

                    newMatriz.getmatriz()[i][j]=temp;
                }
            }
        }
        return newMatriz;

    }

    public double distanciaVectores(ComplexMatriz v1, ComplexMatriz v2){

        ComplexMatriz temp1 = restaVectores(v1,v2);
        double dis = normaMatriz(v1);
        return dis;
    }

    public double normaMatriz(ComplexMatriz v1) {
        ComplexNumber temp = productoInterno(v1,v1);
        double norma = Math.sqrt(temp.realPart);
        return norma;

    }

    public Boolean Unitaria(ComplexMatriz A) {
        ComplexMatriz unitaria = new ComplexMatriz(A.getc(),A.getf());

        for(int i=0;i<unitaria.getc();i++) {

            for(int j=0;j<unitaria.getf();j++) {

                if(i==j) {
                    unitaria.getmatriz()[i][j]= new ComplexNumber(1,0);
                }
                else {
                    unitaria.getmatriz()[i][j]= new ComplexNumber(0,0);
                }
            }
        }
        ComplexMatriz newM = multiplicacionMatrices(adjunta(A),A);
        ComplexMatriz newM1 = multiplicacionMatrices(A,adjunta(A));


        if(newM.same(unitaria)&& newM1.same(unitaria)) {
            return true;
        }
        else {
            return false;
        }
    }

    public  Boolean Hermitiana(ComplexMatriz A) {

        if(adjunta(A).same(A)) {
            return true;
        }
        else {

            return false;
        }

    }

    public ComplexNumber productoInterno(ComplexMatriz v1, ComplexMatriz v2) {
        ComplexNumber temp = new ComplexNumber(0,0);

        ComplexMatriz conjv1 = conjugadaVector(v1);

        for(int i=0; i<conjv1.getlengthVector();i++) {

            ComplexNumber temp2 = conjv1.getvector()[i].multiply(v2.getvector()[i]);
            temp=temp.add(temp2);

        }
        return temp;

    }

    public ComplexMatriz productoTensor(ComplexMatriz A, ComplexMatriz B) {
        ComplexMatriz prodTensor= new ComplexMatriz(A.getc()*B.getc(),A.getf()*B.getf());
        for(int i=0; i<A.getc();i++) {
            for(int j=0; j<A.getf();j++) {
                for(int k=0;k<B.getc();k++) {
                    for(int l=0; l<B.getf();l++) {
                        ComplexNumber temp = A.getmatriz()[j][i].multiply(B.getmatriz()[l][k]);
                        prodTensor.getmatriz()[i*B.getc()+k][j*B.getf()+l]=temp;
                    }
                }
            }
        }
        return prodTensor;
    }
}
