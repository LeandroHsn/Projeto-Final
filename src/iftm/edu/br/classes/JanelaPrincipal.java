package iftm.edu.br.classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URI;
import java.awt.Desktop;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends TeamViewer {

    public JanelaPrincipal() {
        iniciar();
    }

    protected void iniciarDesktop() {
        AbrirDesktop abrir = new AbrirDesktop();
        abrir.iniciarDesktop();
        teamViewer.setExtendedState(JFrame.ICONIFIED);
    }

    protected final void definirStatusTeam() {
        teamViewer = new JFrame();
        teamViewer.setResizable(false);
        teamViewer.setAlwaysOnTop(true);
        teamViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\logo.jpg"));
        teamViewer.getContentPane().setBackground(new Color(255, 255, 255));
        teamViewer.setTitle("TeamViewer");
        teamViewer.setBounds(100, 100, 783, 640);
        teamViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamViewer.getContentPane().setLayout(null);
    }

    protected final void iniciarMenuSupeior() {
        JPanel menuSupeior = new JPanel();
        menuSupeior.setBounds(0, 0, 774, 46);
        menuSupeior.setBackground(Color.BLUE);
        teamViewer.getContentPane().add(menuSupeior);
        menuSupeior.setLayout(null);

        JButton btnConectar = new JButton("Conectar");
        btnConectar.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\botaoconectar.png"));
        btnConectar.setBounds(664, 10, 98, 26);
        menuSupeior.add(btnConectar);
        btnConectar.addActionListener(new ActionListener() {
            private String conectar;
            private int conectarInt;

            public void actionPerformed(ActionEvent e) {
                conectar = boxInserirId.getText();
                conectarInt = Integer.parseInt(conectar);
                System.out.println(conectar);

                if (conectarInt == 123) {

                    controleRemoto.setVisible(false);
                    JDesktopPane desktopPane = new JDesktopPane();
                    desktopPane.setBackground(new Color(240, 255, 255));
                    desktopPane.setBounds(348, 229, 282, 130);
                    teamViewer.getContentPane().add(desktopPane);

                    JLabel inserirSenha = new JLabel("Insira a Senha:");
                    inserirSenha.setFont(new Font("Arial", Font.BOLD, 17));
                    inserirSenha.setBounds(72, 12, 198, 34);
                    desktopPane.add(inserirSenha);

                    passwordFieldConectar = new JPasswordField();
                    passwordFieldConectar.setBounds(34, 46, 206, 34);
                    desktopPane.add(passwordFieldConectar);

                    JButton btnNewButton = new JButton("Conectar");
                    btnNewButton.addActionListener(new ActionListener() {

                        private String senha;
                        private int senhaInt;

                        public void actionPerformed(ActionEvent e) {

                            senha = passwordFieldConectar.getText();
                            senhaInt = Integer.parseInt(senha);

                            System.out.println(senha);

                            if (senhaInt == 321) {
                                iniciarDesktop();
                            }
                        }
                    });
                    btnNewButton.setBounds(84, 92, 98, 26);
                    desktopPane.add(btnNewButton);
                }
            }
        });

        String placeholder = "Inserir a ID do parceiro";

        boxInserirId = new JTextField(placeholder);
        boxInserirId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (boxInserirId.getText().isEmpty()) {
                    boxInserirId.setText(placeholder);
                }
            }

            public void focusGained(FocusEvent e) {
                if (boxInserirId.getText().equals(placeholder)) {
                    boxInserirId.setText("");
                }
            }

        });
        boxInserirId.setHorizontalAlignment(SwingConstants.CENTER);
        boxInserirId.setText("Inserir a ID do parceiro");
        boxInserirId.setBounds(503, 9, 158, 28);
        menuSupeior.add(boxInserirId);
        boxInserirId.setColumns(10);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLUE);
        menuBar.setForeground(Color.BLUE);
        menuBar.setBounds(0, 0, 326, 48);
        menuSupeior.add(menuBar);

        JMenu menuConexao = new JMenu("Conex\u00E3o");
        menuConexao.setForeground(Color.WHITE);
        menuBar.add(menuConexao);

        JMenuItem mntmNewMenuItem = new JMenuItem("Sair do TeamViewer");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuConexao.add(mntmNewMenuItem);

        JMenu menuExtras = new JMenu("Extras");
        menuExtras.setForeground(Color.WHITE);
        menuExtras.setBackground(Color.WHITE);
        menuBar.add(menuExtras);

        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setForeground(Color.WHITE);
        menuBar.add(menuAjuda);

        JMenu menuComentario = new JMenu("Comentário");
        menuComentario.setForeground(Color.WHITE);
        menuComentario.setBackground(Color.WHITE);
        menuBar.add(menuComentario);
    }

    protected final void telaDelogarPrincipal() {

        remoteManegement.setBounds(229, 12, 545, 599);
        teamViewer.getContentPane().add(remoteManegement);
        remoteManegement.setBorder(null);
        remoteManegement.setBackground(Color.WHITE);
        remoteManegement.setForeground(Color.WHITE);
        remoteManegement.getContentPane().setLayout(null);
        remoteManegement.setVisible(true);
        controleRemoto.setVisible(false);

        JLabel labelEmail = new JLabel("E-mail");
        labelEmail.setFont(new Font("Dialog", Font.BOLD, 16));
        labelEmail.setBounds(12, 52, 55, 16);
        remoteManegement.getContentPane().add(labelEmail);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setFont(new Font("Dialog", Font.BOLD, 16));
        labelSenha.setBounds(12, 128, 55, 16);
        remoteManegement.getContentPane().add(labelSenha);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(12, 80, 224, 36);
        remoteManegement.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(12, 156, 224, 36);
        remoteManegement.getContentPane().add(passwordField);

        JButton btnIniciarSessao = new JButton("Iniciar Sesssão");
        btnIniciarSessao.setBounds(12, 204, 160, 47);
        remoteManegement.getContentPane().add(btnIniciarSessao);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Mantenhe-me conectado");
        chckbxNewCheckBox.setSelected(true);
        chckbxNewCheckBox.setBounds(12, 276, 177, 24);
        remoteManegement.getContentPane().add(chckbxNewCheckBox);

        JLabel lblNewLabel = new JLabel("J\u00E1 \u00E9 um cliente TeamViewer?");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNewLabel.setBounds(264, 39, 208, 47);
        remoteManegement.getContentPane().add(lblNewLabel);

        JLabel lblConecteseAquiCom = new JLabel("Conecte-se aqui com sua conta");
        lblConecteseAquiCom.setFont(new Font("Arial", Font.PLAIN, 14));
        lblConecteseAquiCom.setBounds(274, 75, 208, 47);
        remoteManegement.getContentPane().add(lblConecteseAquiCom);

        JLabel lblTeamviwerParaUsar = new JLabel("TeamViwer para usar a funcionalidade");
        lblTeamviwerParaUsar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTeamviwerParaUsar.setBounds(274, 95, 269, 47);
        remoteManegement.getContentPane().add(lblTeamviwerParaUsar);

        JLabel lblTotal = new JLabel("total.");
        lblTotal.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTotal.setBounds(276, 115, 208, 47);
        remoteManegement.getContentPane().add(lblTotal);

        JLabel iconeVerde = new JLabel("");
        iconeVerde.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\botaoverde.png"));
        iconeVerde.setBounds(19, 502, 20, 16);
        remoteManegement.getContentPane().add(iconeVerde);

        JLabel prontoParaConexao = new JLabel("Pronto para a conexão (conexão segura).");
        prontoParaConexao.setBounds(39, 489, 347, 44);
        remoteManegement.getContentPane().add(prontoParaConexao);
        remoteManegement.setFont(new Font("Arial", Font.PLAIN, 17));

        Panel linhaHorizontal = new Panel();
        linhaHorizontal.setBounds(0, 479, 549, 1);
        remoteManegement.getContentPane().add(linhaHorizontal);
        linhaHorizontal.setBackground(Color.LIGHT_GRAY);

    }

    protected final void iniciarMenuLateral() {
        JPanel painelMenuLateral = new JPanel();
        painelMenuLateral.setBounds(0, 45, 227, 566);
        painelMenuLateral.setBackground(new Color(173, 216, 230));
        teamViewer.getContentPane().add(painelMenuLateral);
        painelMenuLateral.setLayout(null);

        // ****************** Botão controle remoto ******************//

        JButton btnControleRemoto = new JButton("Controle Remoto");
        btnControleRemoto.setBounds(0, 61, 227, 50);
        painelMenuLateral.add(btnControleRemoto);
        btnControleRemoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btnControleRemoto) {
                    controleRemoto.setVisible(true);
                    remoteManegement.setVisible(false);
                }
            }
        });

        controleRemoto.setVisible(true);
        controleRemoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controleRemoto.setEnabled(false);
        controleRemoto.setForeground(Color.WHITE);
        controleRemoto.setBackground(Color.WHITE);
        controleRemoto.setBorder(null);
        controleRemoto.setBounds(225, 22, 549, 589);
        teamViewer.getContentPane().add(controleRemoto);
        controleRemoto.getContentPane().setLayout(null);

        JTextPane senhaControleRemoto = new JTextPane();
        senhaControleRemoto.setEditable(false);
        senhaControleRemoto.setBounds(39, 163, 178, 22);
        controleRemoto.getContentPane().add(senhaControleRemoto);
        senhaControleRemoto.setText("asd575");
        senhaControleRemoto.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel permitirControle = new JLabel("Permitir controle remoto");
        permitirControle.setBounds(19, 12, 198, 75);
        controleRemoto.getContentPane().add(permitirControle);
        permitirControle.setFont(new Font("Arial", Font.BOLD, 17));

        JLabel labelSuaId = new JLabel("Sua ID");
        labelSuaId.setBounds(19, 82, 90, 33);
        controleRemoto.getContentPane().add(labelSuaId);

        JTextPane idControleRemoto = new JTextPane();
        idControleRemoto.setBounds(39, 109, 178, 22);
        controleRemoto.getContentPane().add(idControleRemoto);
        idControleRemoto.setEditable(false);
        idControleRemoto.setFont(new Font("Arial", Font.BOLD, 20));
        idControleRemoto.setText("192 168 924");

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setBounds(19, 130, 90, 33);
        controleRemoto.getContentPane().add(labelSenha);

        JLabel acessoSupervisionado = new JLabel("Acesso não supervisionado");
        acessoSupervisionado.setBounds(19, 196, 216, 75);
        controleRemoto.getContentPane().add(acessoSupervisionado);
        acessoSupervisionado.setFont(new Font("Arial", Font.BOLD, 17));

        JCheckBox checkboxIniciar = new JCheckBox("Iniciar o TeamViwer com Windows");
        checkboxIniciar.setBounds(19, 258, 226, 24);
        controleRemoto.getContentPane().add(checkboxIniciar);

        JCheckBox checkboxConcederAcesso = new JCheckBox("Conceder acesso fácil");
        checkboxConcederAcesso.setBounds(19, 286, 226, 24);
        controleRemoto.getContentPane().add(checkboxConcederAcesso);

        Panel linhaVertical = new Panel();
        linhaVertical.setBounds(268, -20, 1, 500);
        controleRemoto.getContentPane().add(linhaVertical);
        linhaVertical.setBackground(Color.LIGHT_GRAY);

        Panel linhaHorizontal = new Panel();
        linhaHorizontal.setBounds(0, 479, 549, 1);
        controleRemoto.getContentPane().add(linhaHorizontal);
        linhaHorizontal.setBackground(Color.LIGHT_GRAY);

        JLabel controlarComputador = new JLabel("Controlar computador remoto");
        controlarComputador.setFont(new Font("Arial", Font.BOLD, 17));
        controlarComputador.setBounds(287, 12, 198, 75);
        controleRemoto.getContentPane().add(controlarComputador);

        JLabel idParceiro = new JLabel("ID de parceiro");
        idParceiro.setBounds(287, 71, 90, 33);
        controleRemoto.getContentPane().add(idParceiro);

        boxInserirIdParceiro = new JTextField();
        boxInserirIdParceiro.setBounds(285, 99, 226, 33);
        controleRemoto.getContentPane().add(boxInserirIdParceiro);
        boxInserirIdParceiro.setColumns(10);

        JRadioButton jRadioControleRemoto = new JRadioButton("Controle Remoto");
        jRadioControleRemoto.setSelected(true);
        jRadioControleRemoto.setBounds(287, 140, 121, 24);
        controleRemoto.getContentPane().add(jRadioControleRemoto);

        JRadioButton jRadioTransferenciaDeArquivo = new JRadioButton("Transferência de arquivo");
        jRadioTransferenciaDeArquivo.setBounds(287, 168, 167, 24);
        controleRemoto.getContentPane().add(jRadioTransferenciaDeArquivo);

        JButton btnConectarPrincipal = new JButton("");
        btnConectarPrincipal.setBounds(287, 218, 160, 33);
        controleRemoto.getContentPane().add(btnConectarPrincipal);
        btnConectarPrincipal.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\conectar.png"));
        btnConectarPrincipal.addActionListener(new ActionListener() {

            private String conectar;
            private int conectarInt;

            public void actionPerformed(ActionEvent e) {
                conectar = boxInserirIdParceiro.getText();
                conectarInt = Integer.parseInt(conectar);
                System.out.println(conectar);

                if (conectarInt == 123) {

                    controleRemoto.setVisible(false);
                    JDesktopPane desktopPane = new JDesktopPane();
                    desktopPane.setBackground(new Color(240, 255, 255));
                    desktopPane.setBounds(348, 229, 282, 130);
                    teamViewer.getContentPane().add(desktopPane);

                    JLabel inserirSenha = new JLabel("Insira a Senha:");
                    inserirSenha.setFont(new Font("Arial", Font.BOLD, 17));
                    inserirSenha.setBounds(72, 12, 198, 34);
                    desktopPane.add(inserirSenha);

                    passwordFieldConectar = new JPasswordField();
                    passwordFieldConectar.setBounds(34, 46, 206, 34);
                    desktopPane.add(passwordFieldConectar);

                    JButton btnNewButton = new JButton("Conectar");
                    btnNewButton.addActionListener(new ActionListener() {

                        private String senha;
                        private int senhaInt;

                        public void actionPerformed(ActionEvent e) {
                            senha = passwordFieldConectar.getText();
                            senhaInt = Integer.parseInt(senha);

                            System.out.println(senha);

                            if (senhaInt == 321) {

                                iniciarDesktop();

                            }
                        }
                    });

                    btnNewButton.setBounds(84, 92, 98, 26);
                    desktopPane.add(btnNewButton);

                }
            }
        });

        JLabel iconeVerde = new JLabel("");
        iconeVerde.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\botaoverde.png"));
        iconeVerde.setBounds(19, 502, 20, 16);
        controleRemoto.getContentPane().add(iconeVerde);

        JLabel prontoParaConexao = new JLabel("Pronto para a conexão (conexão segura).");
        prontoParaConexao.setBounds(39, 489, 347, 44);
        controleRemoto.getContentPane().add(prontoParaConexao);
        prontoParaConexao.setFont(new Font("Arial", Font.PLAIN, 17));

        // ****************** Botão Remote Manegement ******************//

        JButton btnRemoteManegement = new JButton("Remote Manegement");
        btnRemoteManegement.setBounds(0, 115, 227, 50);
        painelMenuLateral.add(btnRemoteManegement);
        btnRemoteManegement.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRemoteManegement) {
                    telaDelogarPrincipal();
                }
            }
        });

        JButton btnReuniao = new JButton("Reunião");
        btnReuniao.setBounds(0, 169, 227, 50);
        painelMenuLateral.add(btnReuniao);
        btnReuniao.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnReuniao) {
                    telaDelogarPrincipal();
                }
            }
        });

        JButton btnComputadores = new JButton("Computadores & contatos");
        btnComputadores.setBounds(0, 223, 227, 50);
        painelMenuLateral.add(btnComputadores);
        btnComputadores.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnComputadores) {
                    telaDelogarPrincipal();
                }
            }
        });

        JButton btnRealidadeAumentada = new JButton("Realidade aumentada");
        btnRealidadeAumentada.setBounds(0, 333, 227, 50);
        painelMenuLateral.add(btnRealidadeAumentada);
        btnRealidadeAumentada.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRealidadeAumentada) {
                    telaDelogarPrincipal();
                }
            }
        });

        JButton btnBatePapo = new JButton("Bate-papo");
        btnBatePapo.setBounds(0, 278, 227, 50);
        painelMenuLateral.add(btnBatePapo);
        btnBatePapo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBatePapo) {
                    telaDelogarPrincipal();
                }
            }
        });

        JButton btnInicio = new JButton("Início");
        btnInicio.setBounds(0, 391, 227, 50);
        painelMenuLateral.add(btnInicio);
        btnInicio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnInicio) {
                    telaDelogarPrincipal();
                }
            }
        });

        JLabel labelIniciarSessao = new JLabel("    Iniciar sessao");
        labelIniciarSessao.setBounds(-22, 0, 215, 66);
        labelIniciarSessao.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\icone.png"));
        labelIniciarSessao.setHorizontalAlignment(SwingConstants.CENTER);
        painelMenuLateral.add(labelIniciarSessao);

        JButton logoTeamViewer = new JButton();
        logoTeamViewer.setIcon(new ImageIcon(
                "C:\\Users\\leand\\Desktop\\Faculdade\\Lucas Moura\\Projeto Final\\Projeto final\\src\\iftm\\edu\\br\\imagens\\logoTeam.png"));
        logoTeamViewer.setBounds(12, 496, 202, 58);
        logoTeamViewer.setOpaque(false);
        logoTeamViewer.setBorderPainted(false);
        logoTeamViewer.setContentAreaFilled(false);
        logoTeamViewer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logoTeamViewer) {
                    try {
                        URI link = new URI("https://www.teamviewer.com/pt-br/");
                        Desktop.getDesktop().browse(link);
                    } catch (Exception erro) {
                        System.out.println(erro);
                    }
                }
            }
        });
        painelMenuLateral.add(logoTeamViewer);
    }
}
