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
import java.util.List;

import org.whole.lang.ui.editparts.IEntityPart;


/*
 * dragging over a part
 * all parts are dropped at once
 * 
 * @author Riccardo Solmi
 */
public class DnDOverPartRequest extends PartRequest {
	private List<IEntityPart> dndParts;

	public DnDOverPartRequest(String requestType, IEntityPart overPart, List<IEntityPart> dndParts) {
		super(requestType, overPart);
		this.dndParts = dndParts;
	}

	public Iterator<IEntityPart> iterator() {
		return dndParts.iterator();
	}
	public int size() {
		return dndParts.size();
	}
}
