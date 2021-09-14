/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import view.Observer;

/**
 *
 * @author vinicius.rodrigues
 */
public class model implements Subject{
    
        private Double num1;
	private Double num2;
	private Double result;
	private String operacao;
        
        private ArrayList observers = new ArrayList();        
        
        public void inicializa(){
            num1 = 0.0;
            num2 = 0.0;
            result = 0.0;
        }
	
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Double getNum1() {
		return num1;
	}
	public void setNum1(Double num1) {
		this.num1 = num1;
	}
	public Double getNum2() {
		return num2;
	}
	public void setNum2(Double num2) {
		this.num2 = num2;
	}
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
        public void atualiza(Double n1, Double n2, Double re, String op){
                this.setOperacao(op);    
                this.num1 = n1;
                this.num2 = n2;
                this.result = re;
                notifyObservers();
        }

    @Override
    public void addObserver(Observer o) {
        observers.add( o );
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove( o );
    }

    private void notifyObservers() {
        Iterator i = observers.iterator();
            while( i.hasNext() ) {
                  Observer o = ( Observer ) i.next();
                  o.update( this );
        }
    }
}
