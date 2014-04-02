package ctc.pd.apldist.proj2.cliente;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        CalculadoraWS_Service srv = new CalculadoraWS_Service();
        final CalculadoraWS ws = srv.getCalculadoraWSPort();
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Login login = new Login(ws);
            }
        });

    }

}
