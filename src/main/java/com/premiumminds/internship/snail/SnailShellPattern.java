package com.premiumminds.internship.snail;

import java.util.concurrent.Future;

// Para colocar o array em formato Future<int[] array>
import java.util.concurrent.CompletableFuture;


/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
  * Method to get snailshell pattern
  * 
  * @param matrix matrix of numbers to go through
  * @return order array of values thar represent a snail shell pattern
  */

  public Future<int[]> getSnailShell(int[][] matrix) {

    int numRows = matrix.length; // número de linhas

    int[] array = new int[numRows * numRows]; // array criado com dimensão igual ao número de elementos da matriz

    int elementos = numRows * numRows;

    int contador = 0;


    // Representam os limites das linhas e colunas
    int linha_cima = 0;

    int linha_baixo = numRows - 1;

    int coluna_esq = 0;

    int coluna_dirt = numRows - 1;

    // Este counter serve para o programa ler só os elementos
    // que faltam de uma determinada linha ou coluna garantido que não se repetem valores
    int counter = 0;


    // O programa não termina até passar por todos os elementos da matriz
    while (contador < elementos) {

      // percorre os elementos de uma linha da esquerda para a direita
      while(counter < coluna_dirt - coluna_esq + 1) {
        array[contador] = matrix[linha_cima][coluna_esq + counter];
        contador++;
        counter++;
      }  

      linha_cima++;
      counter = 0;

      // percorre os elementos de uma coluna de cima para baixo
      while(counter < linha_baixo - linha_cima + 1) {
        array[contador] = matrix[linha_cima + counter][coluna_dirt];
        contador++;
        counter++;
      }

      coluna_dirt--;
      counter = 0;


      // percorre os elementos de uma linha da direita para a esquerda
      while(counter < coluna_dirt - coluna_esq + 1) {
        array[contador] = matrix[linha_baixo][coluna_dirt - counter];
        contador++;
        counter++;
      }

      linha_baixo--;
      counter = 0;

      // percorre os elementos de uma coluna de cima para baixo
      while(counter < linha_baixo - linha_cima + 1) {
        array[contador] = matrix[linha_baixo - counter][coluna_esq];
        contador++;
        counter++;
      }

      coluna_esq++;
      counter = 0;

    }

    CompletableFuture<int[]> array_ = new CompletableFuture<>();
    array_.complete(array); // Definir o resultado no Future

    // Retorna o array pedido
    return array_;
  };

 
}

