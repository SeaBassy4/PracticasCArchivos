import java.io.*;
public class LeerMatrices {
    public static void main(String[] args) throws IOException {
        DataInputStream fileA = new DataInputStream(new FileInputStream("a.mat"));
        int rowsInA = fileA.read();
        int columnsInA= fileA.read();
        double[][] arrayA = new double[rowsInA][columnsInA];
        DataInputStream fileB = new DataInputStream(new FileInputStream("b.mat"));
        int rowsInB= fileB.read();
        int columnsInB= fileB.read();
        double[][] arrrayB = new double[rowsInB][columnsInB];
        DataOutputStream fileC = new DataOutputStream(new FileOutputStream("c.mat"));
        double[][] arrayC = new double[rowsInA][columnsInB];
        for (int i = 0; i < rowsInA; i++) {  //fill out A
            for (int j = 0; j < columnsInA; j++) {
                arrayA[i][j] = fileA.readDouble();
            }
        }
        for (int i = 0; i < rowsInB; i++) { //fill out B
            for (int j = 0; j < columnsInB; j++) {
                arrrayB[i][j] = fileB.readDouble();
            }
        }
        int check1,check2;
        check1 = columnsInA;
        check2 = rowsInB;
        if(check1 == check2){
            for (int i = 0; i < rowsInA; i++) {
                for (int j = 0; j < columnsInB; j++) {
                    for (int k = 0; k < columnsInA; k++) {
                        arrayC[i][j] += arrayA[i][k] * arrrayB[k][j];
                    }
                }
            }
            fileA.close();
            fileB.close();
            fileC.write(rowsInA);
            fileC.write(columnsInB);
            for (int i = 0; i< rowsInA; i++) {     //fill out C
                for (int j = 0; j< columnsInB; j++) {
                    fileC.writeDouble(arrayC[i][j]);
                }
            }
            fileC.close();
        }else{
            System.out.println("Es imposible multiplicar dos matrices donde: Columnas en matrizA != Filas en matrizB");
        }
        System.out.println("El producto de las matrices A y B es:");
        for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < columnsInB; j++) {
                System.out.print(arrayC[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
