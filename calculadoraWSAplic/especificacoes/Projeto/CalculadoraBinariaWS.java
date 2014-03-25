/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cotuca.unicamp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;

/*
 Clicar em cima de CalculadoraWSBinaria, ir em propriedades, bibliotecas, adicionar JAR/Pasta
 * Procurar o arquivo sqljdbc4
 */


/**
 *
 * @author simone
 */
@WebService(serviceName = "CalculadoraBinariaWS")
public class CalculadoraBinariaWS {

     /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    @WebMethod(operationName = "Query")
    public String Query(@WebParam(name = "q") String q){
    Connection Conexao=null;
    Statement st=null;
    String url="";
    try {  
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        
        }
    catch(Exception e) {
         System.out.println(e.getMessage());
         return "Não rodou forName";
    }
    try {  
        url = "jdbc:sqlserver://regulus:1433;dataBaseName=simone;user=simone;password=simone"; 
        Conexao = DriverManager.getConnection(url);  
        }
     catch(Exception e) {
         System.out.println(e.getMessage());
         return "Não conectou";
     }

    try {
        st = Conexao.createStatement();
    }
       
    catch (Exception e) {  
    System.out.println(e.getMessage());                 
    return "Não rodou Statement";
    }
    
    try{
        ResultSet rs = st.executeQuery(q);
        if (rs.next()){
            rs = null;
            st = null;
            Conexao.close();
            return "Usuário conectado";
        }
        return "Usuário não encontrado";
    }
    catch (Exception e) {  
    System.out.println(e.getMessage());                 
    return "Não rodou Statement";
    }
         
   }
}
