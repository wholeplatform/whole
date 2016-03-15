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
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.BackspaceTextCommand;
import org.whole.lang.ui.commands.DeleteTextCommand;
import org.whole.lang.ui.commands.ITextCommand;
import org.whole.lang.ui.commands.InsertTextCommand;
import org.whole.lang.ui.commands.OverwriteTextCommand;
import org.whole.lang.ui.commands.TextTransactionCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.TextualRequest;

/** 
 * @author Riccardo Solmi, Enrico Persiani
 */
public class TextualDirectEditEditPolicy extends GraphicalEditPolicy {
	ICommandFactory commandFactory;

	public TextualDirectEditEditPolicy(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public Command getCommand(Request request) {
		assert getHost() instanceof ITextualEntityPart;

		if (TextualRequest.REQ_INSERT == request.getType())
			return getInsertTextCommand((TextualRequest)request);
		if (TextualRequest.REQ_OVERWRITE == request.getType()) {
			ITextualEntityPart hostPart = (ITextualEntityPart) getHost();
			if (hostPart.getCaretPosition() < hostPart.getCaretPositions())
				return getOverwriteTextCommand((TextualRequest)request);
			else
				return getInsertTextCommand((TextualRequest)request);
		}
		if (TextualRequest.REQ_BACKSPACE == request.getType())
			return getBackspaceCommand((TextualRequest)request);
		if (TextualRequest.REQ_DELETE == request.getType())
			return getDeleteCommand((TextualRequest)request);

		return null;
	}

	private Command getDeleteCommand(TextualRequest request) {
		Command command;
		ITextualEntityPart textualEntityPart = (ITextualEntityPart) getHost();
		if (textualEntityPart.hasSelectionRange()) {
			command = createDeleteSelectionCommand(textualEntityPart);
		} else {
			DeleteTextCommand delete = new DeleteTextCommand();
			delete.setEntity(textualEntityPart.getModelTextEntity());
			delete.setViewer(textualEntityPart.getViewer());
			delete.setLength(1);
			command = delete;
		}
		return command;
	}

	private Command getBackspaceCommand(TextualRequest request) {
		Command command;
		ITextualEntityPart textualEntityPart = (ITextualEntityPart) getHost();
		if (textualEntityPart.hasSelectionRange()) {
			command = createDeleteSelectionCommand(textualEntityPart);
		} else {
			BackspaceTextCommand backspace = new BackspaceTextCommand();
			backspace.setEntity(textualEntityPart.getModelTextEntity());
			backspace.setViewer(textualEntityPart.getViewer());
			backspace.setLength(1);
			command = backspace;
		}
		return command;
	}

	private Command getInsertTextCommand(TextualRequest request) {
		Command command;
		ITextualEntityPart textualEntityPart = (ITextualEntityPart) getHost();
		String contentToInsert = request.getContent();
		if (textualEntityPart.hasSelectionRange()) {
			command = createInsertOverSelectionCommand(textualEntityPart, contentToInsert);
		} else {
			InsertTextCommand insert = new InsertTextCommand();
			insert.setEntity(textualEntityPart.getModelTextEntity());
			insert.setViewer(textualEntityPart.getViewer());
			insert.setData(contentToInsert);
			command = insert;
		}
		return command;
	}

	private Command getOverwriteTextCommand(TextualRequest request) {
		Command command;
		ITextualEntityPart textualEntityPart = (ITextualEntityPart) getHost();
		String contentToOverwrite = request.getContent();
		if (textualEntityPart.hasSelectionRange()) {
			command = createInsertOverSelectionCommand(textualEntityPart, contentToOverwrite);
		} else {
			OverwriteTextCommand overwrite = new OverwriteTextCommand();
			overwrite.setEntity(textualEntityPart.getModelTextEntity());
			overwrite.setViewer(textualEntityPart.getViewer());
			overwrite.setData(contentToOverwrite);
			command = overwrite;
		}
		return command;
	}

	private Command createDeleteSelectionCommand(ITextualEntityPart textualEntityPart) {
		Command command;
		int start = textualEntityPart.getSelectionStart();
		int end = textualEntityPart.getSelectionEnd();
		int length = end-start;
		int caretPosition = textualEntityPart.getCaretPosition();
		if (caretPosition >= end) {
			BackspaceTextCommand backspace = new BackspaceTextCommand();
			backspace.setEntity(textualEntityPart.getModelTextEntity());
			backspace.setViewer(textualEntityPart.getViewer());
			backspace.setLength(length);
			command = backspace;
		} else {
			DeleteTextCommand delete = new DeleteTextCommand();
			delete.setEntity(textualEntityPart.getModelTextEntity());
			delete.setViewer(textualEntityPart.getViewer());
			delete.setLength(length);
			command = delete;
		}
		return command;
	}

	private Command createInsertOverSelectionCommand(ITextualEntityPart textualEntityPart, String contentToInsert) {
		IEntity textEntity  = textualEntityPart.getModelTextEntity();
		TextTransactionCommand transactionCommand = new TextTransactionCommand();
		transactionCommand.setModel(textEntity);
		transactionCommand.merge((ITextCommand) createDeleteSelectionCommand(textualEntityPart));

		InsertTextCommand insert = new InsertTextCommand();
		insert.setEntity(textEntity);
		insert.setViewer(textualEntityPart.getViewer());
		insert.setData(contentToInsert);
		transactionCommand.merge(insert);

		transactionCommand.setLabel(insert.getLabel());

		return transactionCommand;
	}

	@Override
	public boolean understandsRequest(Request request) {
		if (RequestConstants.REQ_DIRECT_EDIT.equals(request.getType()))
			return true;
		return super.understandsRequest(request);
	}
}
