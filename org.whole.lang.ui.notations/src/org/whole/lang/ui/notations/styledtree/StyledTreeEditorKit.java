/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.notations.styledtree;

import org.whole.lang.ui.editor.AbstractGenericEditorKit;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.styledtree.editparts.StyledTreePartFactory;

/**
 * @author Riccardo Solmi
 */
public class StyledTreeEditorKit extends AbstractGenericEditorKit {
	private static final long serialVersionUID = 1L;
	public static final String ID = StyledTreeEditorKit.class.getName();

	public String getId() {
		return ID;
	}

	public String getName() {
		return "Styled Tree";
	}

	public IEditPartFactory getPartFactory() {
		return StyledTreePartFactory.instance();
	}	
}
