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
package org.whole.lang.ui.editparts;

import org.eclipse.gef.EditPartViewer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.views.WholeEditDomain;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityTypePart extends AbstractOverQualifiedDataEntityPart {
	protected String getQualifierPart(String qname) {		
		String uri = ResourceUtils.getResourcePart(qname);
		if (uri != null) {
			if (ReflectionFactory.hasLanguageKit(uri, true, null))
				return ResourceUtils.getSimpleName(ReflectionFactory.getLanguageKit(uri, false, null));
			else {
				//TODO in both branches
				EditPartViewer viewer = getViewer();
				if (viewer instanceof WholeGraphicalViewer) {
					WholeEditDomain wed = (WholeEditDomain) viewer.getEditDomain();
					WholeGraphicalEditor wge = (WholeGraphicalEditor) wed.getEditorPart();
					if (wge != null)
						wge.getReferencedResources().add(uri);
				}
			}
		}
		return uri;
	}
}