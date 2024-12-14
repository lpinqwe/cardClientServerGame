import com.google.gson.Gson;
import factory.CommandFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerForGame {
    public void runServer() {
        CommandFactory factory = new CommandFactory();
        final Gson gson = new Gson();

        try {
            // Создаем ServerSocketChannel и привязываем его к порту
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(5000));

            System.out.println("Сервер запущен и ждет подключения...");

            while (true) {
                // Ожидаем подключения клиента
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Подключение установлено с " + socketChannel.getRemoteAddress());

                // Создаем буфер для чтения данных
                ByteBuffer buffer = ByteBuffer.allocate(256);

                // Читаем данные от клиента
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead > 0) {
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    System.out.println("Получено от клиента: " + new String(data));
                    String resp = gson.toJson(factory.executeCommand(new String(data)));

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


