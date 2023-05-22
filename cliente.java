import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socketCliente = new Socket("localhost", 1234); // direccion y puerto del servidor
        System.out.println("Conectado al servidor...");
        
        // objetos para enviar y recibir mensajes
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
        
        // lectura de mensajes del usuario
        BufferedReader mensajeUsuario = new BufferedReader(new InputStreamReader(System.in));
        String mensajeSalida;
        while ((mensajeSalida = mensajeUsuario.readLine()) != null) { // enviando mensajes al servidor
            salida.println(mensajeSalida);
            System.out.println("Servidor dice: " + entrada.readLine()); // mostrando respuesta del servidor
        }
        
        // cerrando conexiones
        entrada.close();
        salida.close();
        mensajeUsuario.close();
        socketCliente.close();
    }
}
