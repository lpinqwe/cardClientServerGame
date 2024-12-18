import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class Client {

        public void runCli(String msg) {
            try {
                // Создаем SocketChannel и подключаемся к серверу
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress("localhost", 5000));

                // Создаем буфер для отправки данных
                ByteBuffer buffer = ByteBuffer.allocate(256);
                //buffer.put("Привет от клиента!".getBytes());
                buffer.put(msg.getBytes());
                buffer.flip();
                socketChannel.write(buffer);

                // Очищаем буфер для чтения ответа от сервера
                buffer.clear();

                // Читаем ответ от сервера
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead > 0) {
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    System.out.println("READ FROM SERVER: " + new String(data));
                }

                // Закрываем соединение с сервером
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

