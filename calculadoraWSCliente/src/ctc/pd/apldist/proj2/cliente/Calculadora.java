package ctc.pd.apldist.proj2.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 2283435774677721672L;
    private JTextField entrada1;
    private JTextField entrada2;

    private int atual = 0;

    private JTextField getCurrent() {
        return (atual % 2 == 0) ? entrada1 : entrada2;
    }

    private void setCurrent(Object t) {
        if (t != entrada1 && t != entrada2) {
            return;
        }
        if (t == entrada1) {
            atual = 0;
        } else {
            atual = 1;
        }
    }

    private void appendToCurrent(String s) {
        if (limpar) {
            entrada2.setText("");
            limpar = false;
        }
        getCurrent().setText(getCurrent().getText() + s);
    }

    private String metodo = "";
    private boolean limpar = false;

    private void setMetodo(String m) {
        metodo = m;
        atual++;
    }

    public Calculadora() {
        setTitle("Calculadora Binária");
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel pnEntrada = new JPanel();
        getContentPane().add(pnEntrada, BorderLayout.NORTH);
        pnEntrada.setLayout(new BoxLayout(pnEntrada, BoxLayout.LINE_AXIS));

        entrada1 = new JTextField();
        entrada1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setCurrent(e.getSource());
            }
        });
        entrada1.setFocusable(false);
        entrada1.setHorizontalAlignment(SwingConstants.RIGHT);
        entrada1.setBorder(new EmptyBorder(5, 5, 5, 5));
        entrada1.setFont(new Font("Segoe UI Light", Font.PLAIN, 36));
        pnEntrada.add(entrada1);
        entrada1.setColumns(10);

        entrada2 = new JTextField();
        entrada2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setCurrent(e.getSource());
            }
        });
        entrada2.setHorizontalAlignment(SwingConstants.RIGHT);
        entrada2.setFont(new Font("Segoe UI Light", Font.PLAIN, 36));
        entrada2.setFocusable(false);
        entrada2.setColumns(10);
        entrada2.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnEntrada.add(entrada2);
        pnEntrada.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{entrada1}));

        JPanel pnBotoes = new JPanel();
        pnBotoes.setBackground(Color.WHITE);
        getContentPane().add(pnBotoes, BorderLayout.CENTER);
        pnBotoes.setLayout(new GridLayout(2, 3, 0, 0));

        JLabel bt0 = new JLabel("");
        bt0.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/0Mouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                appendToCurrent("0");
            }
        });
        bt0.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/0.png")));
        pnBotoes.add(bt0);

        JLabel btSoma = new JLabel("");
        btSoma.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/+Mouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setMetodo("soma");
            }
        });
        btSoma.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/+.png")));
        pnBotoes.add(btSoma);

        JLabel btSub = new JLabel("");
        btSub.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/-Mouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setMetodo("sub");
            }
        });
        btSub.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/-.png")));
        pnBotoes.add(btSub);

        JLabel bt1 = new JLabel("");
        bt1.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/1mouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                appendToCurrent("1");
            }
        });
        bt1.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/1.png")));
        pnBotoes.add(bt1);

        JLabel btMult = new JLabel("");
        btMult.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/vezesMouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setMetodo("mult");
            }
        });
        btMult.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/vezes.png")));
        pnBotoes.add(btMult);

        JLabel btEq = new JLabel("");
        btEq.addMouseListener(new MouseAdapter() {
            Icon img = new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/=Mouse.png"));

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel me = (JLabel) (e.getSource());
                Icon novo = img;
                img = me.getIcon();
                me.setIcon(novo);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                entrada1.setText("");
                entrada2.setText("");

                limpar = true;
            }
        });
        btEq.setIcon(new ImageIcon(Calculadora.class.getResource("/ctc/pd/apldist/proj2/cliente/res/=.png")));
        pnBotoes.add(btEq);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
