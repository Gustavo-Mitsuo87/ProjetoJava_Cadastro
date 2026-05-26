package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {
	
	public void salvar(Aluno aluno) {
		//O conn faz a conexão com o BD, e o comando prepara e manda o comando para o BD
		Connection conn = null;
		PreparedStatement comando = null;
		
		String sql = "INSERT INTO aluno (nome, nome_social, cpf, genero, afrodescendente, escolaridade_publica, data_nascimento, local_nascimento, nacionalidade, pais_origem, filiacao_1, filiacao_2, responsavel_legal, grau_parentesco, habilitacao, serie, periodo, rua, bairro, cidade, CEP, telefone, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//Local de Nascimento e Nome Social são opcionais
		try {
			conn = Conexao.conectar();
			comando = conn.prepareStatement(sql);
			comando.setString(1, aluno.getNome());
			//Essa estrutura é porque o campo nome_social é opcional o preenchimento. Caso esteja preenchido irá pro BD, se n, irá como NULL
			if (aluno.getNome_social() != null) {
				comando.setString(2, aluno.getNome_social());
			} else {
				comando.setNull(2, java.sql.Types.VARCHAR);
			}
			comando.setString(3, aluno.getCpf());
			comando.setString(4, aluno.getGenero());
			comando.setBoolean(5, aluno.isAfrodescendente());
			comando.setBoolean(6, aluno.isEscolaridade_publica());
			comando.setDate(7, aluno.getData_nascimento());
			if (aluno.getLocal_nascimento() != null) {
				comando.setString(8, aluno.getLocal_nascimento());
			} else {
				comando.setNull(8, java.sql.Types.VARCHAR);
			}
			comando.setString(9, aluno.getNacionalidade());
			comando.setString(10, aluno.getPais_origem());
			comando.setString(11, aluno.getFiliacao_1());
			comando.setString(12, aluno.getFiliacao_2());
			comando.setString(13, aluno.getResponsavel_legal());
			comando.setString(14, aluno.getGrau_parentesco());
			comando.setString(15, aluno.getHabilitacao());
			comando.setString(16, aluno.getSerie());
			comando.setString(17, aluno.getPeriodo());
			comando.setString(18, aluno.getRua());
			comando.setString(19, aluno.getBairro());
			comando.setString(20, aluno.getCidade());
			comando.setString(21, aluno.getCEP());
			comando.setString(22, aluno.getTelefone());
			comando.setString(23, aluno.getEmail());
			comando.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar no Banco de Dados: " + e.getMessage());
		} finally {
			try {
				if (comando != null) {
					comando.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atualizar(Aluno aluno) {
		Connection conn = null;
		PreparedStatement comando = null;
		
		String sql = "UPDATE aluno SET nome = ?, nome_social = ?, cpf = ?, genero = ?, afrodescendente = ?, escolaridade_publica = ?, data_nascimento = ?, local_nascimento = ?, nacionalidade = ?, pais_origem = ?, filiacao_1 = ?, filiacao_2 = ?, responsavel_legal = ?, grau_parentesco = ?, habilitacao = ?, serie = ?, periodo = ?, rua = ?, bairro = ?, cidade = ?, CEP = ?, telefone = ?, email = ? WHERE id = ?";

		try {
			conn = Conexao.conectar();
			comando = conn.prepareStatement(sql);
			comando.setString(1, aluno.getNome());
			if (aluno.getNome_social() != null) {
				comando.setString(2, aluno.getNome_social());
			} else {
				comando.setNull(2, java.sql.Types.VARCHAR);
			}
			comando.setString(3, aluno.getCpf());
			comando.setString(4, aluno.getGenero());
			comando.setBoolean(5, aluno.isAfrodescendente());
			comando.setBoolean(6, aluno.isEscolaridade_publica());
			comando.setDate(7, aluno.getData_nascimento());
			if (aluno.getLocal_nascimento() != null) {
				comando.setString(8, aluno.getLocal_nascimento());
			} else {
				comando.setNull(8, java.sql.Types.VARCHAR);
			}
			comando.setString(9, aluno.getNacionalidade());
			comando.setString(10, aluno.getPais_origem());
			comando.setString(11, aluno.getFiliacao_1());
			comando.setString(12, aluno.getFiliacao_2());
			comando.setString(13, aluno.getResponsavel_legal());
			comando.setString(14, aluno.getGrau_parentesco());
			comando.setString(15, aluno.getHabilitacao());
			comando.setString(16, aluno.getSerie());
			comando.setString(17, aluno.getPeriodo());
			comando.setString(18, aluno.getRua());
			comando.setString(19, aluno.getBairro());
			comando.setString(20, aluno.getCidade());
			comando.setString(21, aluno.getCEP());
			comando.setString(22, aluno.getTelefone());
			comando.setString(23, aluno.getEmail());
			comando.setInt(24, aluno.getId());
			comando.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar dados no Banco de Dados: " + e.getMessage());
		} finally {
			try {
				if (comando != null) {
					comando.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void excluir(int id) {
		Connection conn = null;
		PreparedStatement comando = null;
		
		String sql = "DELETE FROM aluno WHERE id = ?";
		
		try {
			conn = Conexao.conectar();
			comando = conn.prepareStatement(sql);
			comando.setInt(1, id);
			comando.executeUpdate();
		} catch (Exception e) {
            throw new RuntimeException("Erro ao excluir cliente: " + e.getMessage());
        } finally {
            try {
                if (comando != null) {
                    comando.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		
		Connection conn = null;
		PreparedStatement comando = null;
		//o rs serve para mostrar o resultado, o SELECT
		ResultSet rs = null;
		
		String sql = "SELECT * FROM aluno ORDER BY id DESC";
		
		try {
			conn = Conexao.conectar();
			comando = conn.prepareStatement(sql);
			rs = comando.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNome_social(rs.getString("nome_social"));
				aluno.setCpf(rs.getString("CPF"));
				aluno.setGenero(rs.getString("genero"));
				aluno.setAfrodescendente(rs.getBoolean("afrodescendente"));
				aluno.setEscolaridade_publica(rs.getBoolean("escolaridade_publica"));
				aluno.setData_nascimento(rs.getDate("data_nascimento"));
				aluno.setLocal_nascimento(rs.getString("local_nascimento"));
				aluno.setNacionalidade(rs.getString("nacionalidade"));
				aluno.setPais_origem(rs.getString("pais_origem"));
				aluno.setFiliacao_1(rs.getString("filiacao_1"));
				aluno.setFiliacao_2(rs.getString("filiacao_2"));
				aluno.setResponsavel_legal(rs.getString("responsavel_legal"));
				aluno.setGrau_parentesco(rs.getString("grau_parentesco"));
				aluno.setHabilitacao(rs.getString("habilitacao"));
				aluno.setSerie(rs.getString("serie"));
				aluno.setPeriodo(rs.getString("periodo"));
				aluno.setRua(rs.getString("rua"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setCEP(rs.getString("CEP"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				lista.add(aluno);
			}
		} catch (Exception e) {
            throw new RuntimeException("Erro ao listar alunos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (comando != null) {
                    comando.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return lista;
		
	}

}
