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
package org.whole.lang.e4.ui.parts;

import javax.inject.Singleton;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;


/**
 * @author Enrico Persiani
 */
@Singleton
public class E4DetailsGraphicalPart extends AbstractE4DerivedGraphicalPart {
	protected String getDerivationFunction() {
		return "whole:org.whole.lang:ViewDerivationLibrary#deriveDetailsViewContents";
	}
	
	@Override
	protected IEclipseContext configureSelectionLinkable(IEclipseContext params) {
		params = super.configureSelectionLinkable(params);
		params.set(ILinkableSelectionListener.SHARE_EDIT_DOMAIN, true);
		return params;
	}
}
