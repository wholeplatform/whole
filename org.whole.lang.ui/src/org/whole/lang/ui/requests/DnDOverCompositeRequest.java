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

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.util.OneElementIterator;


/**
 * dragging over a composite
 * a part at a time is dropped
 *
 * @author Riccardo Solmi
 */
public class DnDOverCompositeRequest extends PartRequest {
	private IEntityPart dndChild;
	private IEntity dndChildEntity;
	private IEntityPart compositePrevChild;
	
	public DnDOverCompositeRequest(String requestType, IEntityPart overCompositePart, IEntity dndChildEntity, IEntityPart compositePrevChild) {
		super(requestType, overCompositePart);
		this.dndChildEntity = dndChildEntity;
		this.compositePrevChild = compositePrevChild;
	}
	public DnDOverCompositeRequest(String requestType, IEntityPart overCompositePart, IEntityPart dndChild, IEntityPart compositePrevChild) {
		this(requestType, overCompositePart, (IEntity) dndChild.getModelEntity(), compositePrevChild);
		this.dndChild = dndChild;
	}

	public IEntity getDnDChildEntity() {
		return dndChildEntity;
	}

	public IEntityPart getCompositePrevChild() {
		return compositePrevChild;
	}
	
	public Iterator<IEntityPart> iterator() {
		if (dndChild == null) {
			dndChild = new AbstractPart() {
				@Override
				protected IFigure createFigure() {
					return null;
				}
				@SuppressWarnings("unchecked")
				@Override
				public IEntity getModelEntity() {
					return dndChildEntity;
				}
			};
		}
		return new OneElementIterator<IEntityPart>(dndChild);
	}
	public int size() {
		return 1;
	}
}
