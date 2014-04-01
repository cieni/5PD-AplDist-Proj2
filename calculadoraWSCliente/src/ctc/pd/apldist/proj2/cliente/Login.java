package ctc.pd.apldist.proj2.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Login extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;

    public Login() {
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new MigLayout("", "[50px][][][][]", "[][][][][][]"));

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        panel.add(lblLogin, "cell 2 2,alignx right,aligny center");

        txtLogin = new JTextField();
        txtLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        panel.add(txtLogin, "cell 3 2,growx,aligny top");
        txtLogin.setColumns(10);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        panel.add(lblSenha, "cell 2 3,alignx right,aligny center");

        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        panel.add(txtSenha, "cell 3 3,growx,aligny top");

        JButton btLogar = new JButton("Logar");
        btLogar.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        btLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        panel.add(btLogar, "cell 3 4,alignx right");
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
