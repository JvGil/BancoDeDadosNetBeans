package br.com.foursys.banco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.banco.model.Aluno;

public class AlunoDAO {
	
	private Connection bd;
	
	public AlunoDAO(Connection bd) {
		this.bd = bd;
	}
	
	public void inserir(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno(nome,cidade,idade) VALUES(?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		
		comando.setString(1, aluno.getNome());
		comando.setString(2, aluno.getCidade());
		comando.setInt(3, aluno.getIdade());
		comando.execute();
		
	}
	
	public void alterar(Aluno aluno) throws SQLException {
		String sql = "UPDATE aluno SET idade=?, cidade=? WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		
		comando.setInt(1, aluno.getIdade());
		comando.setString(2, aluno.getCidade());
		comando.setString(3, aluno.getNome());
		comando.execute();
	}
	
	public void excluir(Aluno aluno) throws SQLException {
		String sql = "DELETE FROM aluno WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		
		comando.setString(1, aluno.getNome());
		comando.execute();
	}
	
	public List<Aluno> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM aluno ORDER BY nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		while (cursor.next()) {
			Aluno aluno = new Aluno();
			aluno.setNome(cursor.getString("nome"));
			aluno.setCidade(cursor.getString("cidade"));
			aluno.setIdade(cursor.getInt("idade"));
			listaAlunos.add(aluno);
		}
		return listaAlunos;
		
	}
}
