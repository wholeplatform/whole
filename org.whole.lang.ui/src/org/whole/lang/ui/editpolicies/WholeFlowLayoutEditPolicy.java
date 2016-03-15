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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IFragmentPart;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.requests.DnDOverCompositeRequest;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.PartRequest;


public class WholeFlowLayoutEditPolicy extends FlowLayoutEditPolicy {
	private ICommandFactory commandFactory;

	public WholeFlowLayoutEditPolicy(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child instanceof IFragmentPart)
			return new WholeResizableEditPolicy();
		else
			return new WholeNonResizableEditPolicy();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected EditPart getInsertionReference(Request request) {
		int index = toModelIndex(getFeedbackIndexFor(request));
		if (index != -1) {
			List<EditPart> children = getHost().getChildren();

			if (request.getType().equals(RequestConstants.REQ_CREATE))
				return children.get(index);
			
			List<?> selection = getHost().getViewer().getSelectedEditParts();
			do {
				EditPart editpart = children.get(index);
				if (!selection.contains(editpart))
					return editpart;
			} while (++index < children.size());
		}
		return null; //Not found, add at the end.
	}

	protected int toModelIndex(int index) {
		if (isModelChildrenReversed()) {
			int childrenSize = getHost().getChildren().size();
			if (index == childrenSize)
				index = 0;
			else if (index == -1)
				index = childrenSize-1;
			else
				index = index-1;
		}
		return index;
	}
	@Override
	protected int getFeedbackIndexFor(Request request) {
		return FeedbackEditPolicyStrategy.instance.getFeedbackIndexFor(
				(GraphicalEditPart) getHost(),
				getLocationFromRequest(request),
				isHorizontal());
	}

	protected Command createAddCommand(EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_CHILD,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command getCreateCommand(CreateRequest request) {
		Object newObject = request.getNewObject();
		if (newObject instanceof IEntity) {
			IEntityPart compositePart = (IEntityPart) getHost();
			IEntityPart afterPart = (IEntityPart) getInsertionReference(request);

			return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD,
					compositePart, (IEntity) newObject, afterPart));
			
//			CompositeAddCommand cmd = new CompositeAddCommand();
//			cmd.setComposite(compositePart.getModelEntity());
//			cmd.setNewChild((IEntity) newObject);
//			cmd.setPrevChild(afterPart == null ? null : afterPart.getModelEntity());
//			return cmd;
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command getDeleteDependantCommand(Request request) {
		return null;//UnexecutableCommand.INSTANCE;
	}

	private Command createCloneChildCommand(String reqType, EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(reqType,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command getCloneCommand(ChangeBoundsRequest request) {
		String reqType = request.getType() == WholeDragEditPartsTracker.REQ_SHARE ? PartRequest.SHARE_CHILD : PartRequest.CLONE_CHILD;

		CompoundCommand command = new CompoundCommand();
		List<?> editParts = ((ChangeBoundsRequest)request).getEditParts();
		
		EditPart insertionReference = getInsertionReference(request);
		for (int i = 0; i < editParts.size(); i++) {
			EditPart child = (EditPart)editParts.get(i);
			command.add(createCloneChildCommand(reqType, child, insertionReference));
		}
		return command.unwrap();
	}

	protected Point getLocationFromRequest(Request request) {
		if (request instanceof DropRequest)
			return ((DropRequest) request).getLocation();
		else
			return null;
	}

	@Override
	protected boolean isHorizontal() {
		IFigure figure = ((GraphicalEditPart) getHost()).getContentPane();
		return ((IEntityLayout) figure.getLayoutManager()).isHorizontal();
	}

	protected boolean isModelChildrenReversed() {
		return ((IEntityPart) getHost()).isModelChildrenReversed();
	}

	@Override
	protected void showLayoutTargetFeedback(Request request) {
		Point location = getLocationFromRequest(request);
		if (location == null)
			return;

		FeedbackEditPolicyStrategy.instance.updateTargetFeedback(
				(GraphicalEditPart) getHost(), 
				location, 
				isHorizontal(),
				getFeedbackFigure());
	}

	private IFigure feedbackFigure;
	protected IFigure getFeedbackFigure() {
		if (feedbackFigure == null)
			addFeedback(
					feedbackFigure = FeedbackEditPolicyStrategy.instance.createFeedbackFigure());
		return feedbackFigure;
	}

	@Override
	protected void eraseLayoutTargetFeedback(Request request) {
		if (feedbackFigure != null) {
			removeFeedback(feedbackFigure);
			feedbackFigure = null;
		}
	}
	
	@Override
	public void deactivate() {
		if (feedbackFigure != null)
			removeFeedback(feedbackFigure);
		super.deactivate();
	}
}
