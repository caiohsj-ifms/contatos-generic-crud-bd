/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contatos.generic.crud.bd;

/**
 *
 * @author Caio
 */
public class Main {
    public static void main(String[] args) {
        ContatoView view = new ContatoView();
        ContatoModel model = new ContatoModel();
        ContatoController controller = new ContatoController(model, view);
    }
}
