package iftm.edu.br.testes;

import java.awt.EventQueue;
import iftm.edu.br.classes.JanelaPrincipal;

public class Principal {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaPrincipal window = new JanelaPrincipal();
                    window.teamViewer.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
