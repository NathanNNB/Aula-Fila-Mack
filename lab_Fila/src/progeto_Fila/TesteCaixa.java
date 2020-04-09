package progeto_Fila;
import java.util.Random;

public class TesteCaixa {
    public static void main(String[] args) throws Exception {
        Fila clientes = new Fila(1000);
        Vetor espera = new Vetor(1000);
        Random g = new Random();
        int k = 0; //numero de clientes que entram na fila a cada minuto
        int tempo = 480; //duração de funcionamento
        int atend = 0; //clientes atendidos
        k = 3;
        for(int min =0;min<tempo;min++){
            
            if(!clientes.isEmpty()){//caso a fila tenha alguém
                espera.add(espera.size,clientes.front());
                clientes.dequeue();//cliente sai da fila
                k = g.nextInt(3);
                
                atend++;//adiciona em clientes atendidos
                while(k>0){
                    clientes.enqueue(clientes.size);
                    k--;
                }
            }
            else{//Caso a fila estaja vazia, ningoém é atendido e k é sorteado
                k = g.nextInt(3);
                while(k>0){
                    clientes.enqueue(1);
                    k--;
                }
            }
    }   
        float tempoM = 0;//tempo medio espera
        int tempoT = 0;//tempo total espera
        int cont = espera.size; 
        int tempoMax = 0;//Tempo máximo de espera
        
        
        
        for(int x =0;x<cont;x++){//percorre o vetor de espera
            System.out.println("Tempo de espera: "+espera.get(x));
            tempoT= espera.get(x) + tempoT;
            
            if(espera.get(x)>tempoMax){//atualiza o tempoMax
                tempoMax = espera.get(x);
            }
        }
        tempoM = tempoT/atend;
        
        
        
        System.out.println("tamanho da fila: "+clientes.size);
        System.out.println("atendidos: "+atend);
        System.out.println("Tempo total de espera: "+tempoT);
        System.out.println("Tempo medio de espera: "+tempoM);
        System.out.println("Maior tempo de espera: "+tempoMax);
    
}
}
