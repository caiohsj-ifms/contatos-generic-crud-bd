/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contatos.generic.crud.bd;

import java.util.List;
import javax.swing.JOptionPane;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author Caio
 */
public class ContatoModel extends GenericCRUDModel<Contato> {
    private ContatoDAO dao;
    
    public ContatoModel(){
        try {
            dao = new ContatoDAO();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
        }
    }
    
    @Override
    public void salvarEmBaseDeDados(Contato t) {
        try {
            dao.salvarContato(t);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar contato!");
        }
    }

    @Override
    public void removerEmBaseDeDados(Contato t) {
        
    }

    @Override
    public List<Contato> carregarLista() {
        try {
            return dao.getContatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar contatos!");
        }
        
        return null;
    }
    
}
