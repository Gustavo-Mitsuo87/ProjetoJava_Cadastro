package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;
import view.TelaAluno;

public class AlunoController {

    private TelaAluno tela;
    private AlunoDAO alunoDAO;

    public AlunoController(TelaAluno tela) {
        this.tela = tela;
        this.alunoDAO = new AlunoDAO(); 
    }

    public void salvar() {
        String nome = tela.getTxtNome().getText().trim();
        String nomeSocial = tela.getTxtNomeSocial().getText().trim();
        String cpf = tela.getTxtCPF().getText().trim();
        String genero = tela.getCbGenero().getSelectedItem().toString().trim();
        String afro = tela.getCbAfro().getSelectedItem().toString().trim();
        String escolaridade = tela.getCbEscolaridade().getSelectedItem().toString().trim();
        String dtNascimento = tela.getTxtdtNascimento().getText().trim();
        String nascionalidade = tela.getTxtNacionalidade().getText().trim();
        String nmResponsavel = tela.getTxtResponsavel().getText().trim();
        String grauParentesco = tela.getTxtGrauDeParentesco().getText().trim();
        String habilitacao = tela.getCbHabilitacao().getSelectedItem().toString().trim();
        String serie = tela.getCbSerie().getSelectedItem().toString().trim();
        String periodo = tela.getCbPeriodo().getSelectedItem().toString().trim();
        
        String rua = tela.getTxtRua().getText().trim();
        String complemento = tela.getTxtComplemento().getText().trim();
        String apto = tela.getTxtApto().getText().trim();
        String bloco = tela.getTxtBloco().getText().trim();
        String bairro = tela.getTxtBairro().getText().trim();
        String cidade = tela.getTxtCidade().getText().trim();
        String cep = tela.getTxtCep().getText().trim();
        String tel = tela.getTxtTel().getText().trim();
        String email = tela.getTxtEmail().getText().trim();


        if (nome.isEmpty() || cpf.isEmpty() || dtNascimento.isEmpty() || nascionalidade.isEmpty() || nmResponsavel.isEmpty() || grauParentesco.isEmpty() ||
        rua.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || cep.isEmpty() || tel.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                tela,
                "Preencha os campos.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        


    }


    public void limpar() {
        tela.getTxtId().setText("");
        tela.getTxtNome().setText("");
        tela.getTxtNomeSocial().setText("");
        tela.getTxtCPF().setText("");
        tela.getCbGenero().setSelectedIndex(0);
        tela.getCbAfro().setSelectedIndex(0);
        tela.getCbEscolaridade().setSelectedIndex(0);
        tela.getTxtdtNascimento().setText("");
        tela.getTxtNacionalidade().setText("");
        tela.getTxtResponsavel().setText("");
        tela.getTxtGrauDeParentesco().setText("");
        tela.getCbHabilitacao().setSelectedIndex(0);
        tela.getCbSerie().setSelectedIndex(0);
        tela.getCbPeriodo().setSelectedIndex(0);

        tela.getTxtRua().setText("");
        tela.getTxtComplemento().setText("");
        tela.getTxtApto().setText("");
        tela.getTxtBloco().setText("");
        tela.getTxtBairro().setText("");
        tela.getTxtCidade().setText("");
        tela.getTxtCep().setText("");
        tela.getTxtTel().setText("");
        tela.getTxtEmail().setText("");
        tela.getTxtEmail().setText("");
        tela.getTxtNome().requestFocus(); 
        tela.getTabelaAlunos().clearSelection();
    }
}
