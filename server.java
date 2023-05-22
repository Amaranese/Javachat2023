import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234); // puerto del servidor
        System.out.println("Servidor iniciado en el puerto 1234...");
        
        Socket socketCliente = serverSocket.accept(); // esperando la conexion del cliente
        System.out.println("Cliente conectado desde " + socketCliente.getInetAddress().getHostName());
        
        // objetos para enviar y recibir mensajes
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
        
        String mensajeEntrada;
        while ((mensajeEntrada = entrada.readLine()) != null) { // esperando mensajes del cliente
            System.out.println("Cliente dice: " + mensajeEntrada);
            salida.println("Servidor dice: " + mensajeEntrada); // enviando respuesta al cliente
        }
        
        // cerrando conexiones
        entrada.close();
        salida.close();
        socketCliente.close();
        serverSocket.close();
    }
}