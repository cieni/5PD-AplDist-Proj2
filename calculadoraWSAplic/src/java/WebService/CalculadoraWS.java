package WebService;

import BD.BD;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CalculadoraWS")
public class CalculadoraWS {

    @WebMethod(operationName = "conecta")
    public boolean conecta(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        try {
            BD bd = new BD("com.microsoft.sqlserver.jdbc.SQLServerDriver",
                    "jdbc:sqlserver://regulus:1433;databaseName=BD12175",
                    "BD12175", "BD12175");
            usuario = usuario.replace("'", "''");
            ResultSet rs = bd.execConsulta("SELECT COUNT(*) AS total FROM usuarioCalculadora WHERE loginUsuario='" + usuario + "' AND senhaUsuario='" + senha + "'");

            return rs.next() && rs.getInt("total") > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaBinario(String bin) {
        return bin.replace("1", "").replace("0", "").equals("");
    }

    @WebMethod(operationName = "soma")
    public String soma(@WebParam(name = "num1") String binario1, @WebParam(name = "num2") String binario2) throws Exception {
        if (validaBinario(binario1) && validaBinario(binario2)) {
            int valor1 = Integer.parseInt(binario1, 2); //transforma para decimal
            int valor2 = Integer.parseInt(binario2, 2);

            valor1 += valor2;
            String resultadoBinario = Integer.toString(valor1, 2); //transforma para binário

            return resultadoBinario;
        }

        throw new Exception("Os números inseridos são inválidos.");
    }

    @WebMethod(operationName = "subtracao")
    public String subtracao(@WebParam(name = "num1") String binario1, @WebParam(name = "num2") String binario2) throws Exception {
        if (validaBinario(binario1) && validaBinario(binario2)) {
            int valor1 = Integer.parseInt(binario1, 2); //transforma para decimal
            int valor2 = Integer.parseInt(binario2, 2);

            valor1 -= valor2;
            String resultadoBinario = Integer.toString(valor1, 2); //transforma para binário

            return resultadoBinario;
        }

        throw new Exception("Os números inseridos são inválidos.");
    }

    @WebMethod(operationName = "multiplicacao")
    public String multiplicacao(@WebParam(name = "num1") String binario1, @WebParam(name = "num2") String binario2) throws Exception {
        if (validaBinario(binario1) && validaBinario(binario2)) {
            int valor1 = Integer.parseInt(binario1, 2); //transforma para decimal
            int valor2 = Integer.parseInt(binario2, 2);

            valor1 *= valor2;
            String resultadoBinario = Integer.toString(valor1, 2); //transforma para binário

            return resultadoBinario;
        }

        throw new Exception("Os números inseridos são inválidos.");
    }

}
