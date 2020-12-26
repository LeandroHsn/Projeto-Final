package iftm.edu.br.classes;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;

public abstract class TeamViewer {

    public JFrame teamViewer;
    protected JTextField boxInserirId;
    protected JTextField boxInserirIdParceiro;
    protected JTextField textFieldEmail;
    protected JPasswordField passwordField;
    protected JPasswordField passwordFieldConectar;
    protected JInternalFrame controleRemoto = new JInternalFrame(""); // Criando a JInternalFrame do controle remoto.
    protected JInternalFrame remoteManegement = new JInternalFrame(""); // Criando a JInternalFrame do remote

    protected void iniciar() {
        definirStatusTeam();
        iniciarMenuSupeior();
        iniciarMenuLateral();
    }

    protected abstract void iniciarDesktop();

    protected abstract void definirStatusTeam();

    protected abstract void iniciarMenuSupeior();

    protected abstract void telaDelogarPrincipal();

    protected abstract void iniciarMenuLateral();
}