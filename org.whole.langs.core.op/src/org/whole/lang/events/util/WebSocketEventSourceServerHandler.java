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

import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.json.codebase.JSONLDPersistenceKit;
import org.whole.lang.model.IEntity;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

/**
 * @author Riccardo Solmi
 */
public class WebSocketEventSourceServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);

		WebSocketsUtils.peerChannels.add(ctx.channel());
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);

		WebSocketsUtils.peerChannels.remove(ctx.channel());
	}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        if (frame instanceof TextWebSocketFrame) {
            String frameText = ((TextWebSocketFrame) frame).text();
            StringPersistenceProvider pp = new StringPersistenceProvider(frameText);
            IEntity event = JSONLDPersistenceKit.instance().readModel(pp);
            WebSocketsUtils.putPeerEvent(event);
        } else if (frame instanceof CloseWebSocketFrame) {
            ctx.channel().close();
        }
    }
}
