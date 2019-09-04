/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contatos.generic.crud.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Caio
 */
public class ContatoDAO {
    private static final String BD_URL = "jdbc:mysql://localhost/contatos";
    private static final String BD_USUARIO = "root";
    private static final String BD_SENHA = "";
    private static final String USE_TIME_ZONE = "true";
    private static final String SERVER_TIME_ZONE = "UTC";
    private Connection conn;
    
    public ContatoDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Properties props = new Properties();
        props.setProperty("user", BD_USUARIO);
        props.setProperty("password", BD_SENHA);
        props.setProperty("useTimezone", USE_TIME_ZONE);
        props.setProperty("serverTimezone", SERVER_TIME_ZONE);
        conn = DriverManager.getConnection(BD_URL, props);
        conn.setAutoCommit(false);
    }
    
    public List<Contato> getContatos() throws SQLException{
        String query = "SELECT * FROM contatos";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        List<Contato> contatos = new ArrayList<Contato>();
        Contato contato;
        
        while (rs.next()) {
            contato = new Contato();
            contato.setId(rs.getInt("id"));
        }
        return contatos;
    }
    
    public void salvarContato(Contato contato) throws Exception {
        String query = "INSERT INTO contatos (nome,email,telefone)"
                + "VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, contato.getNome());
        ps.setString(2, contato.getEmail());
        ps.setString(3, contato.getTelefone());
        ps.execute();
        conn.commit();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        contato.setId(rs.getInt(1));
    }
}
