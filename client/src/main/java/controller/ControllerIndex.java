package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import message.DeleteMessageParser;
import message.GetMessageParser;
import message.ListMessageParser;
import message.MessageParser;
import model.Pessoa;
import util.ConfigUtils;
import util.Connection;
import util.MessageDialog;
import util.Response;
import view.ViewIndex;

/**
 * @author AV2POO
 */
public class ControllerIndex extends Controller {

    private ViewIndex view;

    public ControllerIndex() {
        this(null);
    }
    
    public ControllerIndex(Controller caller) {
        super(caller);
        this.view = new ViewIndex();
        this.addActionListeners();
        this.addTableListeners();
        this.onSelectRow();
    }
    
    public void abreTela() {
        this.setIPPortFromConfig();
        this.getView().setVisible(true);
    }

    private void setIPPortFromConfig() {
        try {
            String config = ConfigUtils.getConfig();
            
            if (config != null && !config.isEmpty()) {
                String[] configs = config.split(":");
                this.getView().getFieldIP().setText(configs[0]);
                this.getView().getFieldPort().setText(configs[1]);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this.getView(), "Não foi possível ler o arquivo de configurações", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ViewIndex getView() {
        return view;
    }
    
    private void addActionListeners() {
        this.addActionListenerInsert();
        this.addActionListenerUpdate();
        this.addActionListenerDelete();
        this.addActionListenerGet();
        this.addActionListenerList();
        this.addActionListenerSaveIP();
        this.addActionListenerTestConnection();
        this.addActionListenerGerenciarEmpresas();
    }
    
    private void addTableListeners() {
        this.getView().getTable().getSelectionModel().addListSelectionListener((ListSelectionEvent listSelectionEvent) -> {
            this.onSelectRow();
        });
    }
    
    private void onSelectRow() {
        boolean enable = this.getView().getTable().getSelectedRowCount() == 1;
        this.getView().getButtonUpdate().setEnabled(enable);
        this.getView().getButtonDelete().setEnabled(enable);
        this.getView().getButtonGet().setEnabled(enable);
    }
    
    private void addActionListenerInsert() {
        this.getView().getButtonInsert().addActionListener((ActionEvent actionEvent) -> {
            (new ControllerFormPessoa(this)).abreTela();
        });
    }
    
    private void addActionListenerUpdate() {
        this.getView().getButtonUpdate().addActionListener((ActionEvent actionEvent) -> {
            (new ControllerFormPessoa(this, this.getSelectedModel())).abreTela();
        });
    }
    
    private void addActionListenerDelete() {
        this.getView().getButtonDelete().addActionListener((ActionEvent actionEvent) -> {
            Pessoa pessoa = this.getSelectedModel();
            
            Response retorno = this.delete();
            
            MessageDialog.show(this.getView(), retorno);
            
            if (retorno.isSuccess()) {
                this.getView().getTableModelPessoa().deleteData(pessoa);
            }
        });
    }
    
    private void addActionListenerGet() {
        this.getView().getButtonGet().addActionListener((ActionEvent actionEvent) -> {
            Response<Pessoa> retorno = this.get();
            
            if (retorno.isSuccess()) {
                (new ControllerFormPessoa(this, retorno.getTransmissible(), true)).abreTela();
            }
            else {
                MessageDialog.show(this.getView(), retorno);
            }
        });
    }
    
    private void addActionListenerList() {
        this.getView().getButtonList().addActionListener((ActionEvent actionEvent) -> {
            Response<Pessoa> retorno = ControllerIndex.list();
            
            if (retorno.isSuccess()) {
                this.getView().getTableModelPessoa().clearData();
                
                for (Pessoa pessoa : retorno.getTransmissibles()) {
                    this.getView().getTableModelPessoa().addData(pessoa);
                }
            }
            else {
                MessageDialog.show(this.getView(), retorno);
            }
        });
    }
    
    private void addActionListenerSaveIP() {
        this.getView().getButtonSaveIP().addActionListener((ActionEvent actionEvent) -> {
            try {
                String ip = this.getView().getFieldIP().getText();
                String port = this.getView().getFieldPort().getText();
                
                ConfigUtils.setConfig(ip.concat(":").concat(port));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.getView(), "Não foi possível ler o arquivo de configurações", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void addActionListenerTestConnection() {
        this.getView().getButtonTestConnection().addActionListener((ActionEvent actionEvent) -> {
            int timeout = 5000;
            try {
                try (Socket socket = (new Connection(timeout)).getInstanceSocket()) {
                    JOptionPane.showMessageDialog(this.getView(), "Conexão OK", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.getView(), "Conexão recusada (expirado tempo de espera de " + timeout + " milissegundo(s))", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void addActionListenerGerenciarEmpresas() {
        this.getView().getButtonGerenciarEmpresas().addActionListener((ActionEvent actionEvent) -> {
            (new ControllerGridEmpresa(this)).abreTela();
        });
    }
    
    private Pessoa getSelectedModel() {
        Pessoa retorno = null;
        if (this.getView().getTable().getSelectedRowCount() == 1) {
            retorno = this.getView().getTableModelPessoa().getData().get(this.getView().getTable().getSelectedRow());
        }
        return retorno;
    }
    
    private Response delete() {
        Response retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Pessoa> messageParser = new DeleteMessageParser<>(this.getSelectedModel());
            socket.getOutputStream().write(messageParser.getMessageBytes());
            
            InputStream inputStream = socket.getInputStream();
            byte[] dadosBrutos = new byte[1024];
            retorno = new Response(true, new String(dadosBrutos, 0, inputStream.read(dadosBrutos)));
        }
        catch (IOException ex) {
            retorno = new Response(false, "Houve um erro ao tentar conectar com o servidor");
        }
        return retorno;
    }
    
    private Response<Pessoa> get() {
        Response<Pessoa> retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Pessoa> messageParser = new GetMessageParser<>(this.getSelectedModel());
            socket.getOutputStream().write(messageParser.getMessageBytes());
            
            InputStream inputStream = socket.getInputStream();
            byte[] dadosBrutos = new byte[1024];
            String response = new String(dadosBrutos, 0, inputStream.read(dadosBrutos));
            retorno = new Response(response.split(";").length == 3, response);
            if (retorno.isSuccess()) {
                String[] dados = retorno.getMessage().split(";");
                retorno.setTransmissible(new Pessoa(dados[0], dados[1], dados[2]));
            }
        }
        catch (IOException ex) {
            retorno = new Response(false, "Houve um erro ao tentar conectar com o servidor");
        }
        return retorno;
    }
    
    public static Response<Pessoa> list() {
        Response<Pessoa> retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Pessoa> messageParser = new ListMessageParser<>(Pessoa.class);
            socket.getOutputStream().write(messageParser.getMessageBytes());
            
            InputStream inputStream = socket.getInputStream();
            
            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = inputStream.read(dadosBrutos);
            String dados = null;
            while (qtdBytesLidos >= 0) {
                dados = new String(dadosBrutos, 0, qtdBytesLidos);
                qtdBytesLidos = inputStream.read(dadosBrutos);
            }
            
            retorno = new Response(true, dados);
            
            String[] lines = retorno.getMessage().split("\n");

            int quantidade = Integer.valueOf(lines[0]);
            if (quantidade > 0) {
                for (int i = 1; i < lines.length; i++) {
                    String[] dadosPessoa = lines[i].split(";");
                    retorno.addTransmissible(new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2]));
                }
            }
        }
        catch (IOException ex) {
            retorno = new Response(false, "Houve um erro ao tentar conectar com o servidor");
        } catch (InstantiationException | IllegalAccessException ex) {
            retorno = new Response(false, "Houve um erro interno");
        }
        return retorno;
    }
    
}
