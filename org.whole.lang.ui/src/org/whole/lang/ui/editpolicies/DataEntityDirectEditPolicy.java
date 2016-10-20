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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.util.DataTypeUtils;

/** 
 * @author Riccardo Solmi
 */
public class DataEntityDirectEditPolicy extends DirectEditPolicy {
	@Override
	protected Label getHostFigure() {
		IFigure f = super.getHostFigure();
		if (f instanceof Label)
			return (Label) f;
		else
			return (Label) (((IEntityFigure) f).getContentPane(0));
	}

	protected final String getCellEditorValue(DirectEditRequest request) {
		return (String) request.getCellEditor().getValue();
	}

	protected void showCurrentEditValue(DirectEditRequest request) {
		getHostFigure().setText(getCellEditorValue(request));
	}

	protected Command getDirectEditCommand(DirectEditRequest request) {
		IEntity hostEntity = (IEntity) getHost().getModel();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(hostEntity, DataTypeParsers.PRESENTATION);
		
		try {
			return getDirectEditCommand(hostEntity, getCellEditorValue(request), parser);
		} catch (Exception e) {
			return UnexecutableCommand.INSTANCE;
		}
	}
	protected Command getDirectEditCommand(IEntity hostEntity, String value, IDataTypeParser parser) {
		ModelTransactionCommand command = new ModelTransactionCommand(hostEntity);
		try {
			command.begin();
			hostEntity.wSetValue(parser.parse(hostEntity.wGetEntityDescriptor(), value));
			command.commit();
			return command;
		} catch (Exception e) {
			command.rollbackIfNeeded();
			return UnexecutableCommand.INSTANCE;
		}
	}
}
