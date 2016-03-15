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
package org.whole.lang.frames.resources;

import org.whole.lang.frames.model.Frame;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.resources.ResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public class FrameRegistry extends CompoundResourceRegistry<Resource> {
	private static class SingletonHolder {
		private static final FrameRegistry instance = new FrameRegistry();
	}
	public static final FrameRegistry instance() {
		FrameRegistry registry = SingletonHolder.instance;

		String registryId = Frame.class.getName();
		if (!ResourceRegistry.hasRegistry(registryId))
			ResourceRegistry.putRegistry(registryId, registry);

		return registry;
	}

	protected FrameRegistry() {
	}

	public boolean addFrame(Frame frame) {
		return addResource(frame, frame.getUri().getValue(), false);
	}
	public boolean removeFrame(Frame frame) {
		return removeResource(frame.getUri().getValue());
	}

	public Frame getFrame(String uri, boolean loadOnDemand, String contextUri) {
		return getResourceModel(uri, loadOnDemand, contextUri);
	}
}
