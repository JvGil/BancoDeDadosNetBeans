package br.com.foursys.banco.controller;

import br.com.foursys.banco.dao.AlunoDAO;
import br.com.foursys.banco.model.Aluno;

import br.com.foursys.banco.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jgil
 */
public class AlunoController {

    public void inserirAluno(String nome, String cidade, String idade) {
        Connection bd = ConnectionFactory.getConnection();
        AlunoDAO dao = new AlunoDAO(bd);
        Aluno aluno = new Aluno(nome, cidade, Integer.parseInt(idade));

        try {
            dao.inserir(aluno);
            JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso");
            bd.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o aluno");
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Aluno> buscarAlunos() {
        Connection bd = ConnectionFactory.getConnection();
        AlunoDAO dao = new AlunoDAO(bd);
        List<Aluno> listaAlunos = null;
        try {
            listaAlunos = dao.buscarTodos();
            bd.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listaAlunos;
    }
    
    public void alterarAluno(String nome, String cidade, String idade) {
        Connection bd = ConnectionFactory.getConnection();
        AlunoDAO dao = new AlunoDAO(bd);
        Aluno aluno = new Aluno(nome, cidade, Integer.parseInt(idade));
        
        try {
            dao.alterar(aluno);
            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
            bd.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o aluno");
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirAluno(String nome, String cidade, String idade) {
        Connection bd = ConnectionFactory.getConnection();
        AlunoDAO dao = new AlunoDAO(bd);
        Aluno aluno = new Aluno(nome, cidade, Integer.parseInt(idade));
        
         try {
             int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir?");
             
             if (opcao == 0) {
                dao.excluir(aluno);
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso");  
             }
             
             
             
            bd.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o aluno");
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
