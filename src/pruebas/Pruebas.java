/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.Arrays;

/**
 *
 * @author JORGE_HP
 */
public class Pruebas {

    public int palomar(int[] listaNumeros) {
        int tortuga = listaNumeros[0];
        int liebre = listaNumeros[0];
        boolean iguales = false;
        while (!iguales) {
            tortuga = listaNumeros[tortuga];
            liebre = listaNumeros[listaNumeros[liebre]];
            if (tortuga == liebre) {
                iguales = true;
            }
        }

        int puntero1 = listaNumeros[0];
        int puntero2 = tortuga;

        while (puntero1 != puntero2) {
            puntero1 = listaNumeros[puntero1];
            puntero2 = listaNumeros[puntero2];
        }

        return puntero1;
    }

    private boolean comprobacion(int[] valores) {

        int ceros = 0;

        for (int i = 0; i < valores.length; i++) {

            if (valores[i] == 0) {

                ceros++;

            }

        }

        if (ceros == valores.length) {

            return true;

        }

        return false;

    }

    private int[] eliminarValoresEncontrados(int[][] matriz, int[] valoresYaEncontrados) {

        //recorremos el array verticalmente
        for (int i = 0; i < matriz.length; i++) {

            //lo recorremos horizontalmente
            for (int j = 0; j < matriz[0].length; j++) {

                //Recorremos el array con todos los numeros del 1 al 9
                for (int q = 0; q < valoresYaEncontrados.length; q++) {

                    if (matriz[i][j] == valoresYaEncontrados[q]) {

                        valoresYaEncontrados[q] = 0;

                    }

                }

            }

        }

        return valoresYaEncontrados;

    }

//private boolean chequeaSudoku(int[][] matriz){
//
//      int[] valoresYaEncontrados = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//      valoresYaEncontrados = eliminarValoresEncontrados(matriz, valoresYaEncontrados);
//
//       boolean matrizComprobada = comprobacion(valoresYaEncontrados);
//
//       if(matrizComprobada){
//
//              return true;
//
//       }
//
//              return false;
//
//}
    private boolean chequeaSudoku(int[][] matriz) {
        //Método Miguel Ángel
        int numero = 0;
        boolean repetido = false;
        for (int i = 1; i < 10; i++) {
            repetido = false;
            for (int j = 0; j < matriz[0].length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    if (repetido == false && matriz[j][k] == i) {
                        numero++;
                        repetido = true;
                    }
                }
            }
        }
        if (numero == 9) {
            return true;
        }
        return false;
    }

    private int chequeaSudoku2(int[][] matriz) {
        int num = 0;
        //for (int i = 1; i < 10; i++) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                //  if (matriz[j][k] == i) {
                num +=  matriz[j][k] * matriz[j][k] * matriz[j][k] * matriz[j][k] * matriz[j][k];
                // }
            }
        }
        //}
        System.out.println(num);
        return num;

    }
    
    private boolean chequeaSudoku3(int[][] matriz) {
        int num = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                num +=  matriz[j][k] * matriz[j][k] * matriz[j][k] * matriz[j][k] * matriz[j][k];
            }
        }
        return num == 120825;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pruebas pr = new Pruebas();
        System.out.println(pr.palomar(new int[]{2, 3, 2, 4, 2}));
        System.out.println(pr.palomar(new int[]{1, 2, 3, 4, 5, 5}));

        System.out.println( pr.chequeaSudoku3(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}) );

        
        //comprueba uno a uno (fuerza bruta) todas las combinaciones posibles de 9 elementos; permite repetidos
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                for (int k = 1; k < 10; k++) {
//                    for (int l = 1; l < 10; l++) {
//                        for (int m = 1; m < 10; m++) {
//                            for (int n = 1; n < 10; n++) {
//                                for (int p = 1; p < 10; p++) {
//                                    for (int q = 1; q < 10; q++) {
//                                        for (int r = 1; r < 10; r++) {
//                                            if (pr.chequeaSudoku2(new int[][]{{i, j, k}, {l, m, n}, {p, q, r}}) == 120825 ){//con este sí que salen:  15333){// 67731333){ // 574304985) {
//                                                if (!pr.chequeaSudoku(new int[][]{{i, j, k}, {l, m, n}, {p, q, r}})) {
//                                                    System.out.println(i + " " + j + " " + k + " " + l + " " + m + " " + n + " " + p + " " + q + " " + r + " ");
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
        //

    }

}
