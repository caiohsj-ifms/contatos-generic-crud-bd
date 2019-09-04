/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contatos.generic.crud.bd;

import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Caio
 */
public class ContatoController extends GenericCRUDController<Contato> {

    public ContatoController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
    }

    @Override
    public void dadosViewParaModel(Contato t, JPanel pn) {
        ContatoForm form = (ContatoForm) pn;
        t.setNome(form.getCampoNome().getText());
        t.setEmail(form.getCampoEmail().getText());
        t.setTelefone(form.getCampoTelefone().getText());
    }

    @Override
    public void dadosModelParaView(Contato t, JPanel pn) {
        ContatoForm form = (ContatoForm) pn;
        form.getCampoNome().setText(t.getNome());
        form.getCampoEmail().setText(t.getEmail());
        form.getCampoTelefone().setText(t.getTelefone());
    }
    
}
