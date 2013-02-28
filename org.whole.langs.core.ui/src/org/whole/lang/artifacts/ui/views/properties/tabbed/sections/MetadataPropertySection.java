/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.artifacts.ui.views.properties.tabbed.sections;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.views.properties.tabbed.EntityPropertySource;
import org.whole.lang.ui.views.properties.tabbed.WholeAdvancedPropertySection;

/**
 * @author Enrico Persiani
 */
public class MetadataPropertySection extends WholeAdvancedPropertySection {
	public void setInput(IWorkbenchPart part, ISelection selection) {
		IEntityPart entityPart = (IEntityPart) ((IStructuredSelection) selection).getFirstElement();
		IEntity entity = entityPart.getModelEntity().wGet(ArtifactsFeatureDescriptorEnum.metadata);
		selection = new StructuredSelection(new EntityPropertySource(entity));
		super.setInput(part, selection);
		page.selectionChanged(part, selection);
	}
}
