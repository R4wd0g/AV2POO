import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaEntidade1 extends JDialog {
    private JList<Entidade1> listaEntidades;
    private JButton botaoAdicionar, botaoEditar, botaoRemover;
    private Repositorio repositorio;

    public JanelaEntidade1(JFrame parent, Repositorio repositorio) {
        super(parent, "Gerenciar Entidade1", true);
        this.repositorio = repositorio;

        setSize(400, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        listaEntidades = new JList<>(new DefaultListModel<>());
        atualizarListaEntidades();
        add(new JScrollPane(listaEntidades), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        
        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarEntidade();
                repositorio.gravarDados();  // Grava os dados após adicionar uma entidade
            }
        });
        painelBotoes.add(botaoAdicionar);

        botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarEntidade();
                repositorio.gravarDados();  // Grava os dados após editar uma entidade
            }
        });
        painelBotoes.add(botaoEditar);

        botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerEntidade();
                repositorio.gravarDados();  // Grava os dados após remover uma entidade
            }
        });
        painelBotoes.add(botaoRemover);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void atualizarListaEntidades() {
        DefaultListModel<Entidade1> modelo = (DefaultListModel<Entidade1>) listaEntidades.getModel();
        modelo.clear();
        for (Entidade1 entidade : repositorio.getEntidades1().values()) {
            modelo.addElement(entidade);
        }
    }

    private void adicionarEntidade() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome da Entidade1");
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição da Entidade1");
        if (nome != null && !nome.trim().isEmpty() && descricao != null && !descricao.trim().isEmpty()) {
            Entidade1 entidade = new Entidade1(nome, descricao);
            repositorio.addEntidade1(entidade);
            atualizarListaEntidades();
        } else {
            JOptionPane.showMessageDialog(this, "Nome ou descrição inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarEntidade() {
        Entidade1 entidadeSelecionada = listaEntidades.getSelectedValue();
        if (entidadeSelecionada != null) {
            String novoNome = JOptionPane.showInputDialog(this, "Digite o novo nome", entidadeSelecionada.getNome());
            String novaDescricao = JOptionPane.showInputDialog(this, "Digite a nova descrição", entidadeSelecionada.getDescricao());
            if (novoNome != null && !novoNome.trim().isEmpty() && novaDescricao != null && !novaDescricao.trim().isEmpty()) {
                entidadeSelecionada.setNome(novoNome);
                entidadeSelecionada.setDescricao(novaDescricao);
                atualizarListaEntidades();
            } else {
                JOptionPane.showMessageDialog(this, "Nome ou descrição inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma entidade para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerEntidade() {
        Entidade1 entidadeSelecionada = listaEntidades.getSelectedValue();
        if (entidadeSelecionada != null) {
            repositorio.getEntidades1().remove(entidadeSelecionada.getNome());
            atualizarListaEntidades();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma entidade para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
