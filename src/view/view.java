/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author vinicius.rodrigues
 */

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import model.Subject;
import model.model;


public class view extends JFrame implements Observer{

	private JPanel jContentPane = null;
	private JTextField num1Field = null;
	private JTextField num2Field = null;
	private JButton equalButton = null;
        private JTextField resultField = null;
	private JComboBox comboOperacoes = null;
        
        private model dados;

	public view(model m) {
            super();	
            this.dados = m;
            dados.addObserver(this);
            inicializa();
	}
        
        private void inicializa(){
            this.setSize(333, 95);
            this.setContentPane(getJContentPane());
            this.setTitle("Calculadora");            
            this.num1Field.setText(dados.getNum1().toString());
            this.num2Field.setText(dados.getNum2().toString());
            this.resultField.setText(dados.getResult().toString());
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getNum1Field(), null);
			jContentPane.add(getNum2Field(), null);
			jContentPane.add(getEqualButton(), null);
                        jContentPane.add(getResultField(), null);
			jContentPane.add(getComboOperacoes(), null);
		}
		return jContentPane;
	}

	private JTextField getNum1Field() {
		if (num1Field == null) {
			num1Field = new JTextField();
			num1Field.setBounds(new Rectangle(11, 16, 49, 20));
		}
		return num1Field;
	}

	private JTextField getNum2Field() {
		if (num2Field == null) {
			num2Field = new JTextField();
			num2Field.setBounds(new Rectangle(113, 16, 50, 20));
		}
		return num2Field;
	}

	private JButton getEqualButton() {
		if (equalButton == null) {
			equalButton = new JButton();
			equalButton.setBounds(new Rectangle(174, 14, 54, 26));
			equalButton.setText("=");
		}
		equalButton.setActionCommand("equal");
		return equalButton;
	}
        
        private JTextField getResultField() {
		if (resultField == null) {
			resultField = new JTextField();
			resultField.setBounds(new Rectangle(243, 17, 54, 20));
		}
		return resultField;
	}

	private JComboBox getComboOperacoes() {
		if (comboOperacoes == null) {
			comboOperacoes = new JComboBox(new String [] {"+","-","/","*"});
			comboOperacoes.setBounds(new Rectangle(66, 17, 38, 20));
		}
		comboOperacoes.setActionCommand("combo");
		return comboOperacoes;
	}		
	
	public void configuraOuvinte(ActionListener ouvinte){
		equalButton.addActionListener(ouvinte);
	}
        
        public Double get_valor1(){
            String n = num1Field.getText();		
            Double num = null;
            if (!n.equals("")){
                num = Double.parseDouble(n);
            } else {
                num = 0.0;
            }
            return num;
        }
        
        public Double get_valor2(){
            String n = num2Field.getText();		
            Double num = null;
            if (!n.equals("")){
                num = Double.parseDouble(n);
            } else {
                num = 0.0;
            }
            return num;
        }
        
        public String get_op(){
            String operacao = (String)(comboOperacoes.getSelectedItem());
            return operacao;
        }

    @Override
    public void update(Subject o) {
        this.resultField.setText(dados.getResult().toString());
    }
}
