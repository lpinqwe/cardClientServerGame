import com.google.gson.Gson;
import factory.CommandFactory;
import gameLogic.MainRoom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerForGame {
    public void runServer() {
        MainRoom mainRoom =new MainRoom();
        CommandFactory factory = new CommandFactory();
        final Gson gson = new Gson();

        try {
            // Создаем ServerSocketChannel и привязываем его к порту
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(5000));

            System.out.println("RUNSERVER & WAITING...");

            while (true) {
                // Ожидаем подключения клиента
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("CONNECTION CREATED  " + socketChannel.getRemoteAddress());

                // Создаем буфер для чтения данных
                ByteBuffer buffer = ByteBuffer.allocate(256);

                // Читаем данные от клиента
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead > 0) {
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    System.out.println("GET FROM CLIENT: " + new String(data));
                    Object tmp =factory.executeCommand(new String(data),mainRoom);
                    String resp = gson.toJson(tmp);

                    // Отправляем ответ клиенту
                    buffer.clear();
                    //buffer.put("Привет от сервера!".getBytes());
                    buffer.put(resp.getBytes());
                    buffer.flip();
                    socketChannel.write(buffer);
                }

                // Закрываем соединение с клиентом
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


