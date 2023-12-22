package Server;


// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public Client() {
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
    }
}
