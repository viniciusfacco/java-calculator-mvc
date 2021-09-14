/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.model;
import view.resultado;
import view.view;

/**
 *
 * @author vinicius.rodrigues
 */
public class controller implements ActionListener {

    private view visao;
    private resultado result;
    private model modelo;
	
    public controller(view visao, resultado result, model modelo){
        this.visao = visao;
        this.modelo = modelo;
        this.result = result;
	visao.configuraOuvinte(this);
        visao.setVisible(true);
    }
    
    public void inicializa(){
        visao.setVisible(true);
        result.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Double n1 = visao.get_valor1();
        Double n2 = visao.get_valor2();
        String op = visao.get_op();
        Double re = null;        
        if (op.equals("+")) {
            re = n1 + n2;
        } else if (op.equals("-")) {
            re = n1 - n2;
        } else if (op.equals("*")) {
            re = n1 * n2;
        } else{
            re = n1 / n2;
        }
        modelo.atualiza(n1, n2, re, op);
    }
    
}
