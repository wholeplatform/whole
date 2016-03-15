/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.frames.visitors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.frames.model.Frame;
import org.whole.lang.frames.model.ReusePoint;
import org.whole.lang.frames.model.URI;
import org.whole.lang.frames.resources.FrameRegistry;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class FramesInterpreterVisitor extends FramesIdentityDefaultVisitor {
    @Override
    public void visit(Frame entity) {
    	FrameRegistry.instance().addFrame(entity);
    	setResult(BindingManagerFactory.instance.createVoid());
    }

    @Override
    public void visit(ReusePoint entity) {
    	entity.getFrame().accept(this);
    	String frameUri = getResult().wStringValue();
    	String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;

    	Frame frame = FrameRegistry.instance().getFrame(frameUri, true, contextUri);
    	frame = EntityUtils.clone(frame);

    	//TODO resolve variability
    	//TODO bind pointcuts
    	//TODO apply advices

    	setResult(frame.getContent());
    }

    @Override
    public void visit(URI entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
    }
}
