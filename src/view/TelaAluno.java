package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;



public class TelaAluno extends JFrame {

    private static final long serialVersionUID = 1L;
	private JLabel lblId;
    private JLabel lblNome;
    private JLabel lblNomeSocial;
    private JLabel lblCPF;
    private JLabel lblGenero;
    private JLabel lblAfrodescendencia;
    private JLabel lblEscolaridade;
    private JLabel lbldtNascimento;
    private JLabel lblNacionalidade;
    private JLabel lblResponsavel;
    private JLabel lblGrauDeParentesco;
    private JLabel lblHabilitacao;
    private JLabel lblSerie;
    private JLabel lblPeriodo;
    
    private JLabel lblRua;
    private JLabel lblComplemento;
    private JLabel lblApto;
    private JLabel lblAptoBloco;
    private JLabel lblBairro;
    private JLabel lblCidade;
    private JLabel lblCep;
    private JLabel lblTel;
    private JLabel lblEmail;
    
    
   

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtNomeSocial;
    private JTextField txtCPF;
    
    
    
    private JTextField txtdtNascimento;
    private JTextField txtNacionalidade;
    private JTextField txtResponsavel;
    private JTextField txtGrauDeParentesco;
    private JTextField txtHabilitacao;
    private JTextField txtSerie;
    private JTextField txtPeriodo;
    
    private JTextField txtRua;
    private JTextField txtComplemento;
    private JTextField txtApto;
    private JTextField txtAptoBloco;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtCep;
    private JTextField txtTel;
    private JTextField txtEmail;
   
    

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    private JTable tabelaClientes;
    private DefaultTableModel modeloTabela;
    
    private AlunoController controller;

    public TelaAluno() {
    	setTitle("Cadastro de Alunos");
    	setSize(700,600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        criarComponentes();
        
        controller = new AlunoController(this);
        configurarEventos();
        controller.carregarTabela;
        
    }
    
    private void criarComponentes() {
    	JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
    	painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados Dos Alunos"));
    	
    	lblId = new JLabel("ID:");
        txtId = new JTextField();
        txtId.setEditable(false);

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        
        lblNomeSocial = new JLabel("NomeSocial:");
        txtNomeSocial = new JTextField();
        
        lblCPF = new JLabel("CPF:");
        txtCPF = new JTextField();
        
        lblGenero = new JLabel("Genero:");
        txtNome = new JTextField();
        
        lblAfrodescendencia = new JLabel("Afrodescendencia:");
        txtNome = new JTextField();
        
        lblEscolaridade = new JLabel("Escolaridade:");
        txtNome = new JTextField();
        
        lbldtNascimento = new JLabel("Data de Nascimento:");
        txtdtNascimento = new JTextField();
        
        lblNacionalidade = new JLabel("Nacionalidade:");
        txtNacionalidade = new JTextField();
        
        lblResponsavel = new JLabel("Nome Do Responsavel:");
        txtResponsavel = new JTextField();
        
        lblGrauDeParentesco = new JLabel("Grau De Parentesco:");
        txtGrauDeParentesco = new JTextField();
        
        lblHabilitacao = new JLabel("Habilitação:");
        txtHabilitacao = new JTextField();
        
        lblSerie = new JLabel("Serie:");
        txtSerie = new JTextField();
        
        lblPeriodo = new JLabel("Periodo:");
        txtPeriodo = new JTextField();
        
        lblRua = new JLabel("Rua:");
        txtRua = new JTextField();
        
        lblComplemento = new JLabel("Complemento:");
        txtComplemento = new JTextField();
        
        lblApto = new JLabel("Apto:");
        txtApto = new JTextField();
        
        lblAptoBloco = new JLabel("Bloco:");
        txtAptoBloco = new JTextField();
        
        lblBairro = new JLabel("Bairro:");
        txtBairro = new JTextField();
        
        lblCidade = new JLabel("Cidade:");
        txtCidade = new JTextField();
        
        lblCep = new JLabel("CEP:");
        txtCep = new JTextField();
        
        lblTel = new JLabel("Telefone: DDD + número");
        txtTel = new JTextField();
        
        lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField();
        
        painelFormulario.add(lblId);
        painelFormulario.add(txtId);
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblNomeSocial);
        painelFormulario.add(txtNomeSocial);
        painelFormulario.add(lblCPF);
        painelFormulario.add(txtCPF);
        painelFormulario.add(lblGenero);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblAfrodescendencia);
        painelFormulario.add(txtEmail);
        painelFormulario.add(lblEscolaridade);
        painelFormulario.add(txtId);
        painelFormulario.add(lbldtNascimento);
        painelFormulario.add(txtdtNascimento);
        painelFormulario.add(lblNacionalidade);
        painelFormulario.add(txtNacionalidade);
        painelFormulario.add(lblResponsavel);
        painelFormulario.add(txtResponsavel);
        painelFormulario.add(lblGrauDeParentesco);
        painelFormulario.add(txtGrauDeParentesco);
        
        painelFormulario.add(lblHabilitacao);
        painelFormulario.add(txtHabilitacao);
        painelFormulario.add(lblSerie);
        painelFormulario.add(txtSerie);
        painelFormulario.add(lblPeriodo);
        painelFormulario.add(txtPeriodo);
        
        painelFormulario.add(lblRua);
        painelFormulario.add(txtRua);
        painelFormulario.add(lblComplemento);
        painelFormulario.add(txtComplemento);
        painelFormulario.add(lblApto);
        painelFormulario.add(txtApto);
        
        painelFormulario.add(lblAptoBloco);
        painelFormulario.add(txtAptoBloco);
        painelFormulario.add(lblBairro);
        painelFormulario.add(txtBairro);
        painelFormulario.add(lblCidade);
        painelFormulario.add(txtCidade);
        
        painelFormulario.add(lblCep);
        painelFormulario.add(txtCep);
        painelFormulario.add(lblTel);
        painelFormulario.add(txtTel);
        painelFormulario.add(lblEmail);
        painelFormulario.add(txtEmail);
    }
    
    



}
