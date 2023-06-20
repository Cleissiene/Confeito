package Dominio;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Telas {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String produtoSelecionado;
    private String massaSelecionada;
    private String recheioSelecionado;
    private Integer quantidade = 0;

    public void tela1() {
        JFrame frame = new JFrame("Cadastro de Cliente: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);


        JLabel labNome = new JLabel("Nome: ");
        labNome.setBounds(50, 50, 100, 20);
        JFormattedTextField txtNome = new JFormattedTextField(getNomeMaskFormatter());
        txtNome.setBounds(160, 50, 150, 20);

        JLabel labSobreNome = new JLabel("Sobrenome: ");
        labSobreNome.setBounds(50, 80, 100, 20);
        JFormattedTextField txtSobrenome = new JFormattedTextField(getSobrenomeMaskFormatter());
        txtSobrenome.setBounds(160, 80, 150, 20);

        JLabel labTelefone = new JLabel("Telefone: ");
        labTelefone.setBounds(50, 110, 100, 20);
        JFormattedTextField txtTelefone = new JFormattedTextField(getTelefoneMaskFormatter());
        txtTelefone.setBounds(160, 110, 150, 20);

        JButton btnProximo = new JButton("Próximo: ");
        btnProximo.setBounds(160, 140, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome = txtNome.getText();
                sobrenome = txtSobrenome.getText();
                telefone = txtTelefone.getText();
                telaProduto();
                frame.setVisible(false);

            }
        });

        janela.add(labNome);
        janela.add(txtNome);
        janela.add(labSobreNome);
        janela.add(txtSobrenome);
        janela.add(labTelefone);
        janela.add(txtTelefone);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private MaskFormatter getNomeMaskFormatter() {
        MaskFormatter mascaraNome = null;
        try {
            mascaraNome = new MaskFormatter("U*********************");
            //mascaraNome.setPlaceholderCharacter(' ');

        } catch (ParseException ex) {
            System.err.println("Presta atenção na formatação fdp: " + ex.getMessage());
            System.exit(-1);
        }
        return mascaraNome;
    }

    private MaskFormatter getSobrenomeMaskFormatter() {
        MaskFormatter mascaraSobrenome = null;
        try {
            mascaraSobrenome = new MaskFormatter("U*********************");
            //mascaraSobrenome.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            System.err.println("Ô carai, errou de novo a formatação: " + ex.getMessage());
            System.exit(-1);
        }
        return mascaraSobrenome;
    }

    private MaskFormatter getTelefoneMaskFormatter() {
        MaskFormatter mascaraTelefone = null;
        try {
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            //mascaraTelefone.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            System.err.println("mano...desisto docê: " + ex.getMessage());
            System.exit(-1);
        }
        return mascaraTelefone;

    }

    public void telaProduto() {
        JFrame frame = new JFrame("Produtos: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel labProduto = new JLabel("Selecione o produto:");
        labProduto.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Bolo", "CupCake", "Dunet"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 110, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoSelecionado = (String) comboBox.getSelectedItem();
                telaMassaBolo();
                frame.setVisible(false);
            }
        });

        janela.add(labProduto);
        janela.add(comboBox);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void telaMassaBolo() {
        JFrame frame = new JFrame("Massas: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblMassa = new JLabel("Selecione a massa:");
        lblMassa.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Chocolate", "Baunilha"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 110, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massaSelecionada = (String) comboBox.getSelectedItem();
                telaRecheio();
                frame.setVisible(false);
            }
        });

        janela.add(lblMassa);
        janela.add(comboBox);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void telaRecheio() {
        JFrame frame = new JFrame("Recheios: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblRecheio = new JLabel("Selecione o recheio:");
        lblRecheio.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Nutella", "Ninho", "Coco", "Doce de Leite"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 180, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recheioSelecionado = (String) comboBox.getSelectedItem();
                telaFinal();
                frame.setVisible(false);
            }
        });

        JLabel lblQuantidade = new JLabel("Quantidade: 0");
        lblQuantidade.setBounds(50, 140, 100, 20);

        JButton btnMais = new JButton("Adicionar");
        btnMais.setBounds(160, 140, 100, 20);
        btnMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantidade++;
                lblQuantidade.setText("Quantidade: " + quantidade);
            }
        });

        JButton btnMenos = new JButton("Remover");
        btnMenos.setBounds(280, 140, 100, 20);
        btnMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantidade > 0) {
                    quantidade--;
                    lblQuantidade.setText("Quantidade: " + quantidade);
                }
            }
        });

        janela.add(lblRecheio);
        janela.add(comboBox);
        janela.add(btnProximo);
        janela.add(lblQuantidade);
        janela.add(btnMais);
        janela.add(btnMenos);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void telaFinal() {
        JFrame frame = new JFrame("Resumo do Pedido: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel labNome = new JLabel("Nome: " + nome);
        labNome.setBounds(50, 50, 200, 20);

        JLabel labSobrenome = new JLabel("Sobrenome: " + sobrenome);
        labSobrenome.setBounds(50, 80, 200, 20);

        JLabel labTelefone = new JLabel("Telefone: " + telefone);
        labTelefone.setBounds(50, 110, 200, 20);

        JLabel labProduto = new JLabel("Produto: " + produtoSelecionado);
        labProduto.setBounds(50, 140, 200, 20);

        JLabel labMassa = new JLabel("Massa: " + massaSelecionada);
        labMassa.setBounds(50, 170, 200, 20);

        JLabel labRecheio = new JLabel("Recheio: " + recheioSelecionado);
        labRecheio.setBounds(50, 200, 200, 20);

        JLabel labQuantidade = new JLabel("Quantidade: " + quantidade);
        labQuantidade.setBounds(50, 230, 200, 20);

        Double valorFinal = 10.00 * quantidade;
        JLabel labValorFinal = new JLabel("Valor Final: R$ " + valorFinal);
        labValorFinal.setBounds(50, 260, 200, 20);


        String path = "C:\\Faculdade\\Teste\\Cofeitos\\src\\Pedido.txt";
        JOptionPane.showMessageDialog(null, "Seu pedido foi salvo em: " + path, "Pedido", JOptionPane.PLAIN_MESSAGE);
        try {
            FileWriter escreva = new FileWriter(path);
            escreva.write("Nome: " + nome + "\n");
            escreva.write("Sobrenome: " + sobrenome + "\n");
            escreva.write("Telefone: " + telefone + "\n");
            escreva.write("Produto: " + produtoSelecionado + "\n");
            escreva.write("Massa: " + massaSelecionada + "\n");
            escreva.write("Recheio: " + recheioSelecionado + "\n");
            escreva.write("Quantidade: " + +quantidade + "\n");
            escreva.write("Valor Final: R$ " + valorFinal + "\n");
            escreva.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        janela.add(labNome);
        janela.add(labSobrenome);
        janela.add(labTelefone);
        janela.add(labProduto);
        janela.add(labMassa);
        janela.add(labRecheio);
        janela.add(labQuantidade);
        janela.add(labValorFinal);


        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}
