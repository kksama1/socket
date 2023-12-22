package Server;


// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public Client() {
    }

    private static void n(String msg) {
        System.out.println( msg + "Васильев");
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Инициализируем с stream socket и подключаеся к порту в (9001) в указанной сети (127.0.0.1)
        Socket so = new Socket("127.0.0.1", 9001);

        // сощдаём буфферизированный поток (??) хз как это обозвать
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));

        // тут я думаю понятно
        String message = "И лампа не горит. И врут календари.";
        System.out.println("Трунь:\n" + message);

        // помещаем данные в поток
        out.write(message, 0, message.length());
        out.newLine();

        // отправляем
        out.flush();

        // закрываем сокет и поток
        so.close();
        out.close();

        //______________________________________________________________________

        ServerSocket s = new ServerSocket(9002);

        // Устанавливаем в слушающий режим (он ждёт кога к нему обратятся)
        Socket soc = s.accept();

        // Читаем сообщение
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String msg = in.readLine();
        n(msg);

        soc.close();
        s.close();

    }
}
