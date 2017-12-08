/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_sorting;

import java.util.Scanner;

/**
 *
 * @author 16550477
 */
public class EVA3_1_SORTING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] iArre = new int[6];
        for (int i = 0; i < iArre.length; i++) {
            iArre[i] = (int) (Math.random() * 10 + 1);
        }
        imprimirArreglo(iArre);
        /*System.out.println("Selection Sort");
         selectionSort(iArre);
         imprimirArreglo(iArre);
         System.out.println("Insertion Sort");
         insertionSort(iArre);
         imprimirArreglo(iArre);*/
        /*System.out.println("Bubble Sort");
         bubbleSort(iArre);
         imprimirArreglo(iArre);
         /*Scanner dato = new Scanner(System.in);
         System.out.println("Ingresa un valor a buscar");
         int iVal = dato.nextInt();
         System.out.println("Posición del dato: " + binarySearch(iArre, iVal));
         System.out.println("Posición del dato: " + secuencialSearch(iArre, iVal));*/
        /*System.out.println("Merge Sort");
         mergeSort(iArre, 0, iArre.length - 1);
         imprimirArreglo(iArre);*/
        System.out.println("Quick Sort");
        quickSort(iArre, 0, iArre.length - 1);
        imprimirArreglo(iArre);
    }

    public static void imprimirArreglo(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            System.out.print("[" + iArre[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < iArre.length; j++) {//Buscar más pequeño
                if (iArre[j] < iArre[iMin]) {
                    iMin = j; //Guardar posición más pequeño
                }
            }//Terminamos de buscar
            //Intercambiar
            int iTemp = iArre[iMin];
            iArre[iMin] = iArre[i];
            iArre[i] = iTemp;
        }
    }

    public static void insertionSort(int[] iArre) {
        for (int i = 1; i < iArre.length; i++) {
            int iTemp = iArre[i], iPoint = i;
            for (int j = i - 1; j >= 0; j--) {
                if (iArre[j] > iTemp) {
                    iArre[j + 1] = iArre[j];
                    iPoint--;
                    if (iPoint == 0) {
                        iArre[iPoint] = iTemp;
                    }

                } else {
                    iArre[iPoint] = iTemp;
                }
            }
        }
    }

    public static void bubbleSort(int[] iArre) {
        for (int i = 0; i < iArre.length; i++) {
            for (int j = i + 1; j < iArre.length; j++) {
                int iTemp = iArre[i];
                if (iArre[i] > iArre[j]) {
                    iArre[i] = iArre[j];
                    iArre[j] = iTemp;
                }
            }
        }
    }

    public static void merge(int A[], int izq, int m, int der) { //Sacado de internet (indicaciones en clase)
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    public static void mergeSort(int A[], int izq, int der) { //Sacado de internet (indicaciones en clase)
        if (izq < der) {
            int m = (izq + der) / 2;
            mergeSort(A, izq, m);
            mergeSort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public static void quickSort(int[] iArre, int izq, int der) {
            int iPivote= iArre[izq];
        int tooBig=izq; //Valores mayores
        int tooSmall=der; //Valores menores
        int iAux;
        
        while(tooBig<tooSmall){
            while(iArre[tooBig]<= iPivote && tooBig<tooSmall) tooBig++; //Avanza
            while(iArre[tooSmall]> iPivote && tooSmall>0) tooSmall--; //Retrocede
                if(tooBig<tooSmall){ //Terminan de avanzar y compara
                    iAux= iArre[tooBig]; 
                    iArre[tooBig]=iArre[tooSmall]; //Swap
                    iArre[tooSmall]=iAux;
                }
                
        }
        iArre[izq]= iArre[tooSmall];
        iArre[tooSmall]=iPivote; //Swap
        if(izq<tooSmall-1)
            quickSort(iArre, izq, tooSmall-1); //Ordenar los menores
        if(tooSmall+1< der) //Ordenar los mayores
            quickSort(iArre, tooSmall+1, der);
        
    }

    public static int binarySearch(int[] arreglo, int iValorBuscar) {
        return binSearchRec(arreglo, iValorBuscar, 0, arreglo.length - 1);
    }

    private static int binSearchRec(int[] arreglo, int iValorBuscar, int iLo, int iHi) {
        int iPos = -1;
        int iMid = iLo + ((iHi - iLo) / 2);
        if (iValorBuscar == arreglo[iMid]) {//Lo encontramos
            iPos = iMid;
        } else if (iValorBuscar < arreglo[iMid]) { //Buscar en la parte inferior
            iPos = binSearchRec(arreglo, iValorBuscar, iLo, iMid - 1);
        } else if (iValorBuscar > arreglo[iMid]) { //Buscar en la parte inferior
            iPos = binSearchRec(arreglo, iValorBuscar, iMid + 1, iHi);
        }
        return iPos;
    }

    public static int secuencialSearch(int[] iArre, int iVal) {
        int iPos = -1;
        for (int i = 0; i < iArre.length; i++) {
            if (iArre[i] == iVal) {
                iPos = i;
                break;
            }
        }
        return iPos;
    }
}
