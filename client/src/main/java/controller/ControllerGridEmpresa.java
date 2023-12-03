package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.swing.event.ListSelectionEvent;
import message.DeleteMessageParser;
import message.GetMessageParser;
import message.ListMessageParser;
import message.MessageParser;
import model.Empresa;
import model.Pessoa;
import util.Connection;
import util.DateUtils;
import util.MessageDialog;
import util.Response;
import view.ViewGridEmpresa;

/**
 * @author AV2POO
 */
public class ControllerGridEmpresa extends Controller {

    private ViewGridEmpresa view;
    
    public ControllerGridEmpresa(Controller caller) {
        super(caller);
        this.view = new ViewGridEmpresa();
        this.addActionListeners();
        this.addTableListeners();
        this.onSelectRow();
    }
    
    public void abreTela() {
        this.getView().setVisible(true);
    }

    public ViewGridEmpresa getView() {
        return view;
    }
    
    private void addActionListeners() {
        this.addActionListenerInsert();
        this.addActionListenerUpdate();
        this.addActionListenerDelete();
        this.addActionListenerGet();
        this.addActionListenerList();
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
            (new ControllerFormEmpresa(this)).abreTela();
        });
    }
    
    private void addActionListenerUpdate() {
        this.getView().getButtonUpdate().addActionListener((ActionEvent actionEvent) -> {
            (new ControllerFormEmpresa(this, this.getSelectedModel())).abreTela();
        });
    }
    
    private void addActionListenerDelete() {
        this.getView().getButtonDelete().addActionListener((ActionEvent actionEvent) -> {
            Empresa empresa = this.getSelectedModel();
            
            Response retorno = this.delete();
            
            MessageDialog.show(this.getView(), retorno);
            
            if (retorno.isSuccess()) {
                this.getView().getTableModelEmpresa().deleteData(empresa);
            }
        });
    }
    
    private void addActionListenerGet() {
        this.getView().getButtonGet().addActionListener((ActionEvent actionEvent) -> {
            Response<Empresa> retorno = this.get();
            
            if (retorno.isSuccess()) {
                (new ControllerFormEmpresa(this, retorno.getTransmissible(), true)).abreTela();
            }
            else {
                MessageDialog.show(this.getView(), retorno);
            }
        });
    }
    
    private void addActionListenerList() {
        this.getView().getButtonList().addActionListener((ActionEvent actionEvent) -> {
            Response<Empresa> retorno = this.list();
            
            if (retorno.isSuccess()) {
                this.getView().getTableModelEmpresa().clearData();
                
                for (Empresa empresa : retorno.getTransmissibles()) {
                    this.getView().getTableModelEmpresa().addData(empresa);
                }
            }
            else {
                MessageDialog.show(this.getView(), retorno);
            }
        });
    }
    
    private Empresa getSelectedModel() {
        Empresa retorno = null;
        if (this.getView().getTable().getSelectedRowCount() == 1) {
            retorno = this.getView().getTableModelEmpresa().getData().get(this.getView().getTable().getSelectedRow());
        }
        return retorno;
    }
    
    private Response delete() {
        Response retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Empresa> messageParser = new DeleteMessageParser<>(this.getSelectedModel());
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
    
    private Response<Empresa> get() {
        Response<Empresa> retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Empresa> messageParser = new GetMessageParser<>(this.getSelectedModel());
            socket.getOutputStream().write(messageParser.getMessageBytes());
            
            InputStream inputStream = socket.getInputStream();
            byte[] dadosBrutos = new byte[1024];
            String response = new String(dadosBrutos, 0, inputStream.read(dadosBrutos));
            retorno = new Response(response.split(";").length == 4, response);
            
            String[] dados = retorno.getMessage().split(";");
            Empresa empresa = new Empresa(dados[0], dados[1], DateUtils.stringToDate(dados[2]));

            if (dados.length == 4) {
                ArrayList<String> cpfPessoasRelacionadas = new ArrayList<>(Arrays.asList(dados[3].split(",")));
                for (Pessoa pessoa : ControllerIndex.list().getTransmissibles()) {
                    if (cpfPessoasRelacionadas.contains(pessoa.getCpf())) {
                        empresa.addPessoa(pessoa);
                        cpfPessoasRelacionadas.remove(pessoa.getCpf());
                        if (cpfPessoasRelacionadas.size() <= 0) {
                            break;
                        }
                    }
                }
            }
            retorno.setTransmissible(empresa);
        }
        catch (IOException ex) {
            retorno = new Response(false, "Houve um erro ao tentar conectar com o servidor");
        }
        return retorno;
    }
    
    private Response<Empresa> list() {
        Response<Empresa> retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Empresa> messageParser = new ListMessageParser<>(Empresa.class);
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
            
            ArrayList<Pessoa> allPessoas = ControllerIndex.list().getTransmissibles();
            String[] lines = retorno.getMessage().split("\n");
            
            int quantidade = Integer.valueOf(lines[0]);
            if (quantidade > 0) {
                for (int i = 1; i < lines.length; i++) {
                    String[] dadosEmpresa = lines[i].split(";");
                    
                    Empresa empresa = new Empresa(dadosEmpresa[0], dadosEmpresa[1], DateUtils.stringToDate(dadosEmpresa[2]));
                    retorno.addTransmissible(empresa);
                    
                    if (dadosEmpresa.length == 4) {
                        ArrayList<String> cpfPessoasRelacionadas = new ArrayList<>(Arrays.asList(dadosEmpresa[3].split(",")));
                        for (Pessoa pessoa : allPessoas) {
                            if (cpfPessoasRelacionadas.contains(pessoa.getCpf())) {
                                empresa.addPessoa(pessoa);
                            }
                        }
                    }
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