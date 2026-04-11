import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

public class CadastroClientes extends JFrame {

    private JTextField txtNome, txtEmail;
    private JFormattedTextField txtCpf, txtData, txtCelular;

    private JButton btnSalvar, btnExibir;

    private JTable tabela;
    private DefaultTableModel modelo;

    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public CadastroClientes() {
        setTitle("Cadastro de Clientes");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(6, 2, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        txtNome = new JTextField();
        txtEmail = new JTextField();

        try {
            txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
            txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        painelForm.add(new JLabel("Nome:"));
        painelForm.add(txtNome);

        painelForm.add(new JLabel("Data de Nascimento:"));
        painelForm.add(txtData);

        painelForm.add(new JLabel("CPF:"));
        painelForm.add(txtCpf);

        painelForm.add(new JLabel("Email:"));
        painelForm.add(txtEmail);

        painelForm.add(new JLabel("Celular:"));
        painelForm.add(txtCelular);

        btnSalvar = new JButton("Salvar");
        btnExibir = new JButton("Exibir na Tabela");

        painelForm.add(btnSalvar);
        painelForm.add(btnExibir);

        add(painelForm, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"Nome", "Data", "CPF", "Email", "Celular"}, 0);
        tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Evento salvar
        btnSalvar.addActionListener(e -> salvarCliente());

        // Evento exibir
        btnExibir.addActionListener(e -> atualizarTabela());
    }

    private void salvarCliente() {
        String nome = txtNome.getText();
        String data = txtData.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String celular = txtCelular.getText();

        if (nome.isEmpty() || data.contains(" ") || cpf.contains(" ") || email.isEmpty() || celular.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente!");
            return;
        }

        if (!validarCPF(cpf)) {
            JOptionPane.showMessageDialog(this, "CPF inválido!");
            return;
        }

        Cliente c = new Cliente(nome, data, cpf, email, celular);
        listaClientes.add(c);

        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");

        limparCampos();
    }

    private void atualizarTabela() {
        modelo.setRowCount(0);

        for (Cliente c : listaClientes) {
            modelo.addRow(new Object[]{
                    c.nome,
                    c.dataNascimento,
                    c.cpf,
                    c.email,
                    c.celular
            });
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtData.setValue(null);
        txtCpf.setValue(null);
        txtEmail.setText("");
        txtCelular.setValue(null);
    }

    // Validação simples de CPF
    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) return false;

        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++)
                soma += (cpf.charAt(i) - '0') * (10 - i);

            int dig1 = 11 - (soma % 11);
            if (dig1 >= 10) dig1 = 0;

            soma = 0;
            for (int i = 0; i < 10; i++)
                soma += (cpf.charAt(i) - '0') * (11 - i);

            int dig2 = 11 - (soma % 11);
            if (dig2 >= 10) dig2 = 0;

            return dig1 == (cpf.charAt(9) - '0') &&
                    dig2 == (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new CadastroClientes().setVisible(true));
    }

    // Classe Cliente
    static class Cliente {
        String nome, dataNascimento, cpf, email, celular;

        public Cliente(String nome, String dataNascimento, String cpf, String email, String celular) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
            this.email = email;
            this.celular = celular;
        }
    }
}