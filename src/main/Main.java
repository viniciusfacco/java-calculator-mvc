/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.controller;
import model.model;
import view.resultado;
import view.view;

/**
 *
 * @author vinicius.rodrigues
 */
public class Main {
    
    private static model Modelo;
    private static view Visao;
    private static controller Controlador;
    private static resultado Resultado;
    
    public static void main(String[] args){
     
        Modelo = new model();
        Modelo.inicializa();
        
        Visao = new view(Modelo);
        Resultado = new resultado(Modelo);
        
        Controlador = new controller(Visao, Resultado, Modelo);
        Controlador.inicializa();
        
    }    
}
