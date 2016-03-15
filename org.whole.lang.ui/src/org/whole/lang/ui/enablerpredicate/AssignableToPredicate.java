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
package org.whole.lang.ui.enablerpredicate;

import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
public final class AssignableToPredicate implements IEnablerPredicate {
	private final EntityDescriptor<?> ed;

	public AssignableToPredicate(EntityDescriptor<?> ed) {
		this.ed = ed;
	}
	public boolean evaluate(IEntityPart selectedPart, Object userdata) {
		return ed.isPlatformSupertypeOf(selectedPart.getModelEntity().wGetEntityDescriptor());
	}
	public String toString() {
		return "selectedEntity assignableTo "+ed.getName();
	}
	public EntityDescriptor<?> getEntityDescriptor() {
		return ed;
	}
}