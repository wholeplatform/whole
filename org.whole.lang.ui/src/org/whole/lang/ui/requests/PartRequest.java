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
package org.whole.lang.ui.requests;

import java.util.Iterator;

import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class PartRequest implements Iterable<IEntityPart> {
	public static final String DELETE = "DELETE";
	public static final String MOVE_CHILD = "MOVE_CHILD";
	public static final String MOVE_ORPHAN_CHILD = "MOVE_ORPHAN_CHILD";
	public static final String MOVE_ADD_CHILD = "MOVE_ADD_CHILD";
	public static final String SHARE_CHILD = "SHARE_CHILD";
	public static final String CLONE_CHILD = "CLONE_CHILD";

	protected String requestType;
	protected IEntityPart part;

	public PartRequest(String requestType, IEntityPart part) {
		this.requestType = requestType;
		this.part = part;
	}

	public String getRequestType() {
		return requestType;
	}

	public IEntityPart getPart() {
		return part;
	}
	public IEntity getModelEntity() {
		return part.getModelEntity();
	}

	public IEntity getParentModelEntity() {
		return part.getParentModelEntity();
	}

	public abstract Iterator<IEntityPart> iterator();
	public abstract int size();
}
