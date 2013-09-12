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
package org.whole.lang.e4.ui.parts;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.whole.lang.e4.ui.api.IUIConstants;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class E4VariablesGraphicalPart extends E4GraphicalPart {
	@Inject
	@Optional
	private void getNotified(@UIEventTopic(IUIConstants.TOPIC_UPDATE_VARIABLES) IEntity results) {
		if (results != null)
			viewer.setEntityContents(results);
		else	
			viewer.setContents(null, createDefaultContents());
	}
}
