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
package org.whole.lang.ui.editparts;

import java.util.EventObject;

/**
 * @author Enrico Persiani
 */
public class EntityPartEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	private IEntityPart entityPart;

	public EntityPartEvent(Object source) {
		super(source);
	}

	public EntityPartEvent(Object source, IEntityPart entityPart) {
		super(source);
		this.entityPart = entityPart;
	}

	public IEntityPart getEntityPart() {
		return entityPart;
	}

	void setEditPart(IEntityPart entityPart) {
		this.entityPart = entityPart;
	}
}
