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

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.whole.lang.e4.ui.actions.ClearContentsAction;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IUpdatableAction;

/**
 * @author Enrico Persiani
 */
public class E4ResultsGraphicalPart extends E4GraphicalPart {
	private IUpdatableAction clearContentsAction;

	@Inject
	@Optional
	private void getNotified(@UIEventTopic(IE4UIConstants.TOPIC_UPDATE_RESULTS) IEntity results) {
		getViewer().setEntityContents(results);
		getClearContentsAction().update();
	}

	public IUpdatableAction getClearContentsAction() {
		if (clearContentsAction == null)
			clearContentsAction = new ClearContentsAction(context);
		return clearContentsAction;
	}
}
