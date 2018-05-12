import java.io.*;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 7777);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msgin = "", msgout = "";

        while (!msgin.equals("end")) {
            msgout = br.readLine();
            dout.writeUTF(msgout);
            dout.flush();
            msgin = din.readUTF();
            System.out.println(msgin);
        }
    }
}
