package ctc.pd.apldist.proj2.cliente;

import javax.swing.SwingUtilities;

public class Principal {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Calculadora();
            }
        });
        
    }
    
}
