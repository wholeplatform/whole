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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class DeletePartRequest extends PartRequest {
	protected List<IEntityPart> entityParts;

	public DeletePartRequest(String requestType, IEntityPart part, List<EditPart> editParts) {
		super(requestType, part);
		entityParts = new ArrayList<IEntityPart>(editParts.size());
		for (EditPart editPart : editParts)
			if (editPart instanceof IEntityPart)
				entityParts.add((IEntityPart) editPart);
	}
	public DeletePartRequest(String requestType, IEntityPart part) {
		super(requestType, part);
		entityParts = Collections.singletonList(part);
	}

	public Iterator<IEntityPart> iterator() {
		return entityParts.iterator();
	}

	public int size() {
		return entityParts.size();
	}
}
