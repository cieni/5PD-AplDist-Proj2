/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService;

import BD.BD;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author u12175
 */
@WebService(serviceName = "CalculadoraWS")
public class CalculadoraWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "conecta")
    public boolean conecta(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        try {
            BD bd = new BD("com.microsoft.sqlserver.jdbc.SQLServerDriver",
                    "jdbc:sqlserver://regulus:1433;databaseName=BD12175",
                    "BD12175", "BD12175");
            usuario = usuario.replace("'","");
            ResultSet resultadoLogin = bd.execConsulta("select count(*) from usuarioCalculadora where loginUsuario='"+usuario+"' and senhaUsuario='"+senha+"'");
            resultadoLogin.next();
            int qtosResultados = Integer.parseInt(resultadoLogin.getString(1));
            if (qtosResultados>=1) //existe login com tal senha
                return true;
            return false;                
        } catch (Exception ex) {
            Logger.getLogger(CalculadoraWS.class.getName()).log(Level.SEVERE, null, ex);
        };
        return false;
    }
    
     @WebMethod(operationName = "soma")
    public String soma(String binario1, String binario2){
        int valor1 = Integer.parseInt(binario1,2); //transforma para decimal
        int valor2 = Integer.parseInt(binario2,2);
        int resultado = valor1 + valor2;
        String resultadoBinario = Integer.toString(resultado,2); //transforma para binário
        return resultadoBinario;
    }
    
     @WebMethod(operationName = "subtracao")
    public String subtracao(String binario1, String binario2){
        int valor1 = Integer.parseInt(binario1,2); //transforma para decimal
        int valor2 = Integer.parseInt(binario2,2);
        int resultado = valor1 - valor2;
        String resultadoBinario = Integer.toString(resultado,2); //transforma para binário
        return resultadoBinario;
    }
    
     @WebMethod(operationName = "multiplicacao")
    public String multiplicacao(String binario1, String binario2){
        int valor1 = Integer.parseInt(binario1,2); //transforma para decimal
        int valor2 = Integer.parseInt(binario2,2);
        int resultado = valor1 * valor2;
        String resultadoBinario = Integer.toString(resultado,2); //transforma para binário
        return resultadoBinario;
    }
    
    
}
