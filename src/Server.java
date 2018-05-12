import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msgin = "", msgout = "";

        while(!msgin.equals("end")){
            msgin = din.readUTF();
            System.out.println(msgin);
            msgout = br.readLine();
            dout.writeUTF(msgout);
            dout.flush();
        }
        socket.close();
    }
}
