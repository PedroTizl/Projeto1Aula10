package br.edu.uniso;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class UnisoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public UnisoDialog() {
        setContentPane(contentPane);
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
       // JOptionPane.showConfirmDialog(this, "ESSA JANELA EH MODAL");
        JFileChooser seletorArquivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Escolha seu arquivo de imagem",
                "jpg","jpeg","gif","png","bmp");
        seletorArquivo.setFileFilter(filtro);
        seletorArquivo.setAcceptAllFileFilterUsed(false);
        int retorno = seletorArquivo.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION){
            System.out.println("o arquivo escolhido foi "+ seletorArquivo.getSelectedFile().getName());
        }
        dispose();

    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        UnisoDialog dialog = new UnisoDialog();
        dialog.pack();
        dialog.setVisible(true);

    }
}

