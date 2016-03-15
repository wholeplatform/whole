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
package org.whole.lang.ui.notations.tree.editparts;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class GenericEmbeddingStrategy implements IEmbeddingStrategy {
	public static final IEmbeddingStrategy instance = new GenericEmbeddingStrategy();
	protected GenericEmbeddingStrategy() {
	}

	public boolean embedChildren(IEntity entity) {
		return embedChildren(entity.wGetEntityDescriptor());
	}
	public boolean embedChildren(EntityDescriptor<?> ed) {
		switch (ed.getEntityKind()) {
		case SIMPLE:
			for (FeatureDescriptor ced : ed.getEntityFeatureDescriptors())
				if (!embedChildrenInSimple(ced.getEntityDescriptor()))
					return false;
			return true;
		case COMPOSITE:
			EntityDescriptor<?> ced = ed.getEntityDescriptor(0);
			return !ced.isPolymorphic() && embedChildrenInComposite(ced);
		case DATA:
			return true;
		default:
			return false;
		}
	}
	protected boolean embedChildrenInSimple(EntityDescriptor<?> ed) {
		switch (ed.getEntityKind()) {
		case DATA:
			return true;
		case SIMPLE:
		case COMPOSITE:
		default:
			return false;
		}
	}
	protected boolean embedChildrenInComposite(EntityDescriptor<?> ed) {
		switch (ed.getEntityKind()) {
		case SIMPLE:
			for (FeatureDescriptor ced : ed.getEntityFeatureDescriptors())
				if (!embedChildrenInSimple(ced.getEntityDescriptor()))
					return false;
		case DATA:
			return true;
		case COMPOSITE:
		default:
			return false;
		}
	}

	public boolean embedChild(EntityDescriptor<?> ed, int i) {
		return ed.getEntityDescriptor(i).getEntityKind().isData();
	}

	public boolean isEmbedded(IEntity entity) {
		IEntity parent = entity.wGetParent();
		switch (parent.wGetEntityKind()) {
		case SIMPLE:
			return parent.wGetEntityDescriptor(entity).getEntityKind().isData();
		case COMPOSITE:
			return embedChildren(parent);
		default:
			return false;
		}
	}
}
