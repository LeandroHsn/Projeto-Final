package iftm.edu.br.classes;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;

public class AbrirDesktop extends JanelaPrincipal {

    private JFrame desktopLeandro;

    public void iniciarDesktop() {

        desktopLeandro = new JFrame();
        desktopLeandro.setTitle("Desktop Leandro");
        desktopLeandro.getContentPane().setBackground(Color.WHITE);
        desktopLeandro.getContentPane().setLayout(null);
        desktopLeandro.setVisible(true);
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\leand\\Desktop\\desktop.png"));
        lblNewLabel.setBounds(0, 0, 1980, 1080);
        desktopLeandro.getContentPane().add(lblNewLabel);
        desktopLeandro.setIconImage(Toolkit.getDefaultToolkit().getImage(
                "C:\\Users\\leand\\Desktop\\kisspng-teamviewer-computer-icons-computer-software-micros-icon-svg-teamviewer-5ab105f3a4bec3.2754451515215508356748 (1).jpg"));
        desktopLeandro.setBounds(100, 100, 1920, 1080);

    }
}
