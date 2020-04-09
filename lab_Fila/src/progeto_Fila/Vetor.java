
package progeto_Fila;
public class Vetor {

     int[] A; // armazena os elementos do vetor
     int capacity; // capacidade do vetor
     int size; // elementos no vetor

    public Vetor(int capacity) {
        A = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        // verifica se o vetor estÃ¡ vazio
        // ou return (size == 0);    
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // retorna a qtde de elementos no vetor
        return size;
    }

    public int get(int i) throws Exception {
        // para um Ã­ndice vÃ¡lido i, retorna o elemento dessa posiÃ§Ã£o do vetor
        if (i >= size) {
            throw new Exception("Posicao Invalida para consulta!!");
        }
        return A[i];
    }

    public int set(int i, int n) throws Exception {
        // i = posiÃ§Ã£o no vetor ; n = novo valor para a posiÃ§Ã£o
        // para um Ã­ndice vÃ¡lido i, altera o elemento para n e retorna o elemento armazenado
        if (i >= size) {
            throw new Exception("Posicao invalida para alteracao!!");
        }
        A[i] = n;
        return n;
    }

    public void add(int i, int n) throws Exception {
        // adiciona o elemento n em uma posiÃ§Ã£o i vÃ¡lida
        if (size == capacity) {
            throw new Exception("Lista Cheia!!");
        }
        if (i > size) {
            throw new Exception("Posicao de insercao invalida!");
        }

        for (int j = size - 1; j >= i; j--) {
            A[j + 1] = A[j];
        }
        A[i] = n;
        size++;
    }

    public void remove(int i) throws Exception {
        // remove o conteÃºdo da posiÃ§Ã£o i vÃ¡lida
        if (isEmpty()) {
            throw new Exception("Lista vazia! Impossivel remover!");
        }
        if (i >= size) {
            throw new Exception("Posicao invalida para remocao!");
        }

        for (int j = i; j <= size - 1; j++) {
            A[j] = A[j + 1];
        }
        size--;
    }

    public int search(int n) throws Exception {
        // busca sequencialmente o elemento n no vetor
        if (isEmpty()) {
            throw new Exception("Lista vazia! Impossivel consultar!");
        }
        for (int i = 0; i < size; i++) {
            if (A[i]==n) {
                return i;
            }
        }
        return -1;
    }

    public int[] getArray() {
        return A;
    }
}