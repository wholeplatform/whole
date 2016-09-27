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
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ChangeBoundsCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.requests.DnDOverCompositeRequest;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.PartRequest;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeFreeformLayoutEditPolicy extends XYLayoutEditPolicy {
	protected ICommandFactory commandFactory;

	public WholeFreeformLayoutEditPolicy(XYLayout xyLayout, ICommandFactory commandFactory) {
		setXyLayout(xyLayout);
		this.commandFactory = commandFactory;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new WholeResizableEditPolicy();
	}

	protected Command getCreateCommand(CreateRequest request) {
		Object newObject = request.getNewObject();
		
		if (newObject instanceof IEntity) {
			IEntity newEntity = (IEntity) newObject;

			IEntityPart hostPart = (IEntityPart) getHost();
			IEntity compositeEntity = hostPart.getModelEntity().wGet(0);  //FIXME workaround
			if (!compositeEntity.wGetEntityDescriptor(0).isPlatformSupertypeOf(newEntity.wGetEntityDescriptor()))
				return null;

			Rectangle constraint = (Rectangle) getConstraintFor(request);
			return getConstrainedCompositeAddCommand(newEntity, constraint);
		}
		return null;
	}

	protected Command getCloneCommand(ChangeBoundsRequest request) {
		return getCompoundConstrainedCompositeAddCommand(request);
	}

	protected Command getAddCommand(Request generic) {
		ChangeBoundsRequest request = (ChangeBoundsRequest) generic;
		return getCompoundConstrainedCompositeAddCommand(request);
	}

	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		return createChangeConstraintCommand((IEntity) child.getModel(), (Rectangle) constraint);
	}

	protected Command getConstrainedCompositeAddCommand(IEntity entity, Rectangle constraint) {
		CompoundCommand compound = new CompoundCommand();
		compound.add(createChangeConstraintCommand(entity, constraint));		
		compound.add(commandFactory.create(createDnDOverCompositeRequest(entity)));
		return compound;
	}
	protected DnDOverCompositeRequest createDnDOverCompositeRequest(IEntity entity) {
		return new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD, (IEntityPart) getHost(), entity, null);
	}

	protected Command getCompoundConstrainedCompositeAddCommand(ChangeBoundsRequest request) {
		CompoundCommand command = new CompoundCommand();
		for (Object editPart : request.getEditParts()) {
			Rectangle constraint = (Rectangle) getConstraintFor(request);
			IGraphicalEntityPart entityPart = (IGraphicalEntityPart) editPart;
			IEntity newEntity = EntityUtils.clone(entityPart.getModelEntity());
			command.add(getConstrainedCompositeAddCommand(newEntity, constraint));
		}
		return command.unwrap();
	}

	protected Object getConstraintFor(ChangeBoundsRequest request) {
		IFigure figure = getLayoutContainer();

		Point where = request.getLocation().getCopy();

		figure.translateToRelative(where);
		figure.translateFromParent(where);
		where.translate(getLayoutOrigin().getNegated());

		return getConstraintFor(where);
	}
	protected Command createChangeConstraintCommand(IEntity entity, Rectangle constraint) {
		try {
			ChangeBoundsCommand cmd = new ChangeBoundsCommand();
			cmd.setEntity(entity);
			cmd.setConstraint(constraint.x, constraint.y, constraint.width, constraint.height);
			return cmd;
		} catch (Exception e) {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
