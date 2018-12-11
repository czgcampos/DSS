/*
 * Calculadora.java
 *
 * Created on March 27, 2004, 3:15 PM
 *
 * @author  José Creissac Campos (rev. 9/2016)
 */

import java.util.Observable;

public class Calculadora extends Observable {
    
    private double val_ant, val_act; // os dois operandos das operações binárias
    private boolean new_number;      // indica que se vai começar a "ler" um novo número
    private char opr;                // memória com a operação a aplicar
    
    /** Creates a new instance of Calculadora */
    public Calculadora() {
        this.val_ant = this.val_act = 0;
        this.new_number = true;
        this.opr = '=';
        /** o notifyObservers serve para comunicar o novo valor da calculadora */
        this.setChanged();
        this.notifyObservers(this.val_act);
    }
    
    public void processa(int d) {
        if (this.new_number) {
            this.val_act = d;
            this.new_number = false;
        } else {
            this.val_act = this.val_act*10+d;
        }
        /** o notifyObservers serve para comunicar o novo valor da calculadora */
        this.setChanged();
        this.notifyObservers(this.val_act);
    }
    
    public void processa(char opr) {
        switch (this.opr) {
            case '=': this.val_ant = this.val_act;
                      break;
            case '+': this.val_ant += this.val_act;
                      break;
            case '-': this.val_ant -= this.val_act;
                      break;
            case '*': this.val_ant *= this.val_act;
                      break;
            case '/': this.val_ant /= this.val_act;  // Exercício: Acrescente tratamento da divisão por zero!
                      break;
        };
        this.opr = opr;
        this.new_number = true;
        this.val_act = this.val_ant;
        /** o notifyObservers serve para comunicar o novo valor da calculadora */
        this.setChanged();
        this.notifyObservers(this.val_act);
    }
    
    public void clear() {
        this.val_ant = this.val_act = 0;
        this.new_number = true;        
        /** o notifyObservers serve para comunicar o novo valor da calculadora */
        this.setChanged();
        this.notifyObservers(this.val_act);
    }    
    
}
