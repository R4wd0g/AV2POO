package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import message.InsertMessageParser;
import message.MessageParser;
import message.UpdateMessageParser;
import model.Pessoa;
import util.Connection;
import util.MessageDialog;
import util.Response;
import view.ViewFormPessoa;

/**
 * @author AV2POO
 */
public class ControllerFormPessoa extends Controller {

    private ViewFormPessoa view;
    private Pessoa model;
    private boolean modelAlreadyExists = false;
    private boolean readOnly = false;

    public ControllerFormPessoa(Controller caller, Pessoa model, boolean readOnly) {
        this(caller, model);
        this.readOnly = readOnly;
    }
    
    public ControllerFormPessoa(Controller caller, Pessoa model) {
        this(caller);
        this.model = model;
        this.modelAlreadyExists = !model.getCpf().isEmpty();
    }

    public ControllerFormPessoa(Controller caller) {
        super(caller);
        this.view = new ViewFormPessoa();
        this.addActionListeners();
    }

    public void abreTela() {
        this.beanView();
        if (this.readOnly) {
            this.disableFields();
        }
        if (this.getModel().getCpf() != null) {
            this.getView().getFieldCpf().setEnabled(false);
        }
        this.getView().setVisible(true);
    }

    private void beanView() {
        this.getView().getFieldCpf().setText(this.getModel().getCpf());
        this.getView().getFieldNome().setText(this.getModel().getNome());
        this.getView().getFieldEndereco().setText(this.getModel().getEndereco());
    }
    
    private void beanModel() {
        this.getModel().setCpf(this.getView().getFieldCpf().getText())
                       .setNome(this.getView().getFieldNome().getText())
                       .setEndereco(this.getView().getFieldEndereco().getText());
    }
    
    private void disableFields() {
        this.getView().getFieldCpf().setEnabled(false);
        this.getView().getFieldNome().setEnabled(false);
        this.getView().getFieldEndereco().setEnabled(false);
        this.getView().getButtonConfirmar().setEnabled(false);
    }

    public ViewFormPessoa getView() {
        return view;
    }

    public Pessoa getModel() {
        if (this.model == null) {
            this.model = new Pessoa();
        }
        return model;
    }

    public void setModel(Pessoa model) {
        this.model = model;
    }

    private void addActionListeners() {
        this.addActionListenerButtonConfirmar();
        this.addActionListenerButtonCancelar();
    }

    private void addActionListenerButtonConfirmar() {
        this.getView().getButtonConfirmar().addActionListener((ActionEvent actionEvent) -> {
            this.beanModel();
            
            Pessoa pessoa = this.getModel();
            int i = 0;
            if (this.getCaller() instanceof ControllerIndex) {
                i = ((ControllerIndex) this.getCaller()).getView().getTableModelPessoa().getData().indexOf(pessoa);
            }
            
            Response retorno = this.modelAlreadyExists ? this.update() : this.insert();
            
            MessageDialog.show(this.getView(), retorno);
            
            if (this.getCaller() instanceof ControllerIndex) {
                if (this.modelAlreadyExists) {
                    ((ControllerIndex) this.getCaller()).getView().getTableModelPessoa().updateData(i, pessoa);
                }
                else {
                    ((ControllerIndex) this.getCaller()).getView().getTableModelPessoa().addData(pessoa);
                }
            }
            
            this.getView().dispose();
        });
    }

    private void addActionListenerButtonCancelar() {
        this.getView().getButtonCancelar().addActionListener((ActionEvent actionEvent) -> {
            this.getView().dispose();
        });
    }

    private Response update() {
        Response retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Pessoa> messageParser = new UpdateMessageParser<>(this.getModel());
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

    private Response insert() {
        Response retorno;
        try {
            Socket socket = (new Connection()).getInstanceSocket();
            
            MessageParser<Pessoa> messageParser = new InsertMessageParser<>(this.getModel());
            socket.getOutputStream().write(messageParser.getMessageBytes());
            
            retorno = new Response(true, "Pessoa inserida com sucesso");
        }
        catch (IOException ex) {
            retorno = new Response(false, "Houve um erro ao tentar conectar com o servidor");
        }
        return retorno;
    }

}
