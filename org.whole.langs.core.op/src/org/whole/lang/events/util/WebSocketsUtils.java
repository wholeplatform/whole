/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.events.util;

import java.net.URI;
import java.security.cert.CertificateException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.net.ssl.SSLException;

import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.events.EventSourceManager;
import org.whole.lang.events.IEventSourceManager;
import org.whole.lang.json.codebase.JSONLDPersistenceKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ReflectionFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author Riccardo Solmi
 */
public class WebSocketsUtils {
	public static Channel serverChannel;
    public static Channel clientChannel;
    public static ChannelGroup peerChannels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	protected static EventLoopGroup bossGroup;
	protected static EventLoopGroup workerGroup;
    protected static EventLoopGroup clientGroup;

    public static BlockingQueue<IEntity> peerEventQueue = new LinkedBlockingDeque<>();
    public static void putPeerEvent(IEntity value) {
    	try {
			peerEventQueue.put(value);
		} catch (InterruptedException e) {
			throw new OperationCanceledException();
		}
    }
    public static IEntity receive() {
    	try {
			return peerEventQueue.take();
		} catch (InterruptedException e) {
			throw new OperationCanceledException();
		}
    }
    public static void clear() {
    	peerEventQueue.clear();
    }


	public static void startServer() {
		startServer(false);
	}
	public static void startServer(boolean useSSL) {
		startServer(useSSL, useSSL? 8443 : 8080);
	}
	public static void startServer(boolean useSSL, int port) {
		if (serverChannel != null)
			stopServer();

        final SslContext sslCtx;
        if (useSSL) {
			try {
				SelfSignedCertificate ssc = new SelfSignedCertificate();
				sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
			} catch (CertificateException|SSLException e) {
				// TODO test only
				e.printStackTrace();
				return;
			}
        } else {
            sslCtx = null;
        }

        bossGroup = new NioEventLoopGroup(1);
    	workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new WebSocketEventSourceServerInitializer(sslCtx));

            serverChannel = b.bind(port).sync().channel();

            System.out.println("Open your web browser and navigate to " +
                    (useSSL? "https" : "http") + "://127.0.0.1:" + port + '/');
        } catch (InterruptedException e) {
        	stopServer();
		}		
	}

	public static void stopServer() {
    	if (serverChannel != null) {
	    	serverChannel.writeAndFlush(new CloseWebSocketFrame());
	        try {
				serverChannel.closeFuture().sync();
			} catch (InterruptedException e) {
			}
	        serverChannel = null;
    	}
    	if (bossGroup != null) {
	        bossGroup.shutdownGracefully();
	        bossGroup = null;
    	}
    	if (workerGroup != null) {
	        workerGroup.shutdownGracefully();
	        workerGroup = null;
    	}
	}


    public static void startClient() throws Exception {
    	startClient("ws://127.0.0.1:8080/websocket");
    }
    public static void startClient(String URL) throws Exception {
    	if (clientChannel != null)
    		stopClient();

        URI uri = new URI(URL);
        String scheme = uri.getScheme() == null ? "ws" : uri.getScheme();
        final String host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
        final int port;
        if (uri.getPort() == -1) {
            if ("ws".equalsIgnoreCase(scheme)) {
                port = 80;
            } else if ("wss".equalsIgnoreCase(scheme)) {
                port = 443;
            } else {
                port = -1;
            }
        } else {
            port = uri.getPort();
        }

        if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
            System.err.println("Only WS(S) is supported.");
            return;
        }

        final boolean ssl = "wss".equalsIgnoreCase(scheme);
        final SslContext sslCtx;
        if (ssl) {
            sslCtx = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }

        clientGroup = new NioEventLoopGroup();

        try {
            final WebSocketEventSourceClientHandler handler = new WebSocketEventSourceClientHandler(WebSocketClientHandshakerFactory.newHandshaker(
            		uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders()));

            Bootstrap b = new Bootstrap();
            b.group(clientGroup)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) {
                     ChannelPipeline p = ch.pipeline();
                     if (sslCtx != null) {
                         p.addLast(sslCtx.newHandler(ch.alloc(), host, port));
                     }
                     p.addLast(
                             new HttpClientCodec(),
                             new HttpObjectAggregator(8192),
                             WebSocketClientCompressionHandler.INSTANCE,
                             handler);
                 }
             });

            clientChannel = b.connect(uri.getHost(), port).sync().channel();
            handler.handshakeFuture().sync();
        } catch (Exception e) {
        	stopClient();
        }
    }

    public static void stopClient() {
    	if (clientChannel != null) {
	    	clientChannel.writeAndFlush(new CloseWebSocketFrame());
	        try {
				clientChannel.closeFuture().sync();
			} catch (InterruptedException e) {
			}
	        clientChannel = null;
    	}
    	if (clientGroup != null) {
    		clientGroup.shutdownGracefully();
    		clientGroup = null;
    	}
    }

    public static void send(String message) throws Exception {
    	for (Channel ch : peerChannels)
	    	ch.writeAndFlush(new TextWebSocketFrame(message));
    	if (clientChannel != null && clientChannel.isActive())
    		clientChannel.writeAndFlush(new TextWebSocketFrame(message));
    }

    public static void shareEventSource(IEntity entity, String endPoint) {
    	//TODO move eventSource
    	IEventSourceManager eventSourceManager = ReflectionFactory.getEventSourceManager(entity);
    	entity.wGetModel().getCompoundModel().setEventSourceManager(new EventSourceSynchronizer());
    }

    public static class EventSourceSynchronizer extends EventSourceManager {
    	private static final long serialVersionUID = 1L;

    	@Override
		public void addEvent(IEntity event) {
    		super.addEvent(event);

    		//TODO if getChannel() != null
    		//TODO ensure asynch
    		StringPersistenceProvider pp = new StringPersistenceProvider();
    		try {
				JSONLDPersistenceKit.instance().writeModel(event, pp);
			} catch (Exception e) {
				throw new IllegalStateException();
			}
    		String message = pp.getStore();
    		try {
				WebSocketsUtils.send(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
