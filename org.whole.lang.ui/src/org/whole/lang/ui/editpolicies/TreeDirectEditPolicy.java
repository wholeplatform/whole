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
package org.whole.lang.ui.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editors.TreeDirectEditRequest;
import org.whole.lang.ui.editparts.ITreeEntityPart;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class TreeDirectEditPolicy extends AbstractEditPolicy {
	public Command getCommand(Request request) {
		if (RequestConstants.REQ_DIRECT_EDIT == request.getType())
			return getDirectEditCommand((TreeDirectEditRequest) request);
		return null;
	}

	private Command getDirectEditCommand(TreeDirectEditRequest request) {
		IEntity entity = getTreeEntityPart().getModelEntity();
		ModelTransactionCommand mtc = new ModelTransactionCommand(entity);
		try {
			mtc.setLabel("edit");
			mtc.begin();
			DataTypeUtils.setFromPersistenceString(entity, request.getValue());
			mtc.commit();
			if (mtc.canUndo())
				getTreeEntityPart().getViewer().getEditDomain().getCommandStack().execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
		} finally {
		}

		return null;
	}
	
	private ITreeEntityPart getTreeEntityPart() {
		return (ITreeEntityPart) getHost();
	}

	@Override
	public boolean understandsRequest(Request request) {
		if (RequestConstants.REQ_DIRECT_EDIT.equals(request.getType()))
			return true;
		return super.understandsRequest(request);
	}
}
