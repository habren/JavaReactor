package com.jasongj.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

  public static void main(String[] args) throws IOException, InterruptedException {
    SocketChannel socketChannel = SocketChannel.open();
    InetSocketAddress address = new InetSocketAddress("localhost", 1234);
    socketChannel.connect(address);

    ByteBuffer buffer = ByteBuffer.wrap("NIO Client".getBytes());
    socketChannel.write(buffer);
    buffer.flip();
    Thread.sleep(3000);
    socketChannel.write(buffer);
    socketChannel.close();
  }
}
