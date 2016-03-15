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
package org.whole.lang.grammars.ui.actions;

import static org.eclipse.draw2d.PositionConstants.EAST;
import static org.eclipse.draw2d.PositionConstants.NORTH;
import static org.eclipse.draw2d.PositionConstants.SOUTH;
import static org.eclipse.draw2d.PositionConstants.WEST;

import java.util.List;

import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.keys.DefaultKeyHandler;
import org.whole.lang.ui.tools.EditPoint;
import org.whole.lang.ui.tools.IEditPointProvider;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GrammarsKeyHandler extends DefaultKeyHandler {
	private static class SingletonHolder {
		private static final GrammarsKeyHandler instance = new GrammarsKeyHandler();
	}
	public static GrammarsKeyHandler instance() {
		return SingletonHolder.instance;
	}
	protected GrammarsKeyHandler() {
	}

	public EditPoint findNeighbour(IEditPointProvider editPointProvider, EditPoint editPoint, int direction) {
		int caret = editPoint.caret;
		IEntityPart focusPart = editPoint.focus;
		IEntity focusEntity = focusPart.getModelEntity();
		
		switch (focusEntity.wGetEntityOrd()) {
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
		case GrammarsEntityDescriptorEnum.As_ord:
			switch (direction) {
			case NORTH:
				switch (caret) {
					case 0:
					case 1:
						return findInParent(editPointProvider, editPoint, focusEntity, direction);
					case 2:
					case 3:
						return editPoint.caret(caret-2);
				}
			case SOUTH:
				switch (caret) {
					case 2:
					case 3:
						return findInParent(editPointProvider, editPoint, focusEntity, direction);
					case 0:
					case 1:
						return editPoint.caret(caret+2);
				}
			case EAST:
				switch (caret) {
					case 0:
						return findInChild(editPointProvider, editPoint, focusEntity.wGet(0), direction);
					case 2:
						return findInChild(editPointProvider, editPoint, focusEntity.wGet(1), direction);
					case 1:
					case 3:
						return findInParent(editPointProvider, editPoint, focusEntity, direction);
				}
			case WEST:
				switch (caret) {
					case 1:
						return findInChild(editPointProvider, editPoint, focusEntity.wGet(0), direction);
					case 3:
						return findInChild(editPointProvider, editPoint, focusEntity.wGet(1), direction);
					case 0:
					case 2:
						return findInParent(editPointProvider, editPoint, focusEntity, direction);
				}
		}			
		}
		return null;
	}

	public EditPoint findInParent(IEditPointProvider editPointProvider, EditPoint editPoint, IEntity child, int direction) {
		IEntity parentEntity = child.wGetParent();

		if (EntityUtils.isNull(parentEntity))
			return editPointProvider.getEditPoint();

		switch (parentEntity.wGetEntityOrd()) {
		case GrammarsEntityDescriptorEnum.As_ord:
			switch (direction) {
			case NORTH:
				if (parentEntity.wGet(1) == child)
					return findInChild(editPointProvider, editPoint, parentEntity.wGet(0), direction);
				else
					return findInParent(editPointProvider, editPoint, parentEntity, direction);
			case SOUTH:
				if (parentEntity.wGet(0) == child)
					return findInChild(editPointProvider, editPoint, parentEntity.wGet(1), direction);
				else
					return findInParent(editPointProvider, editPoint, parentEntity, direction);
			case EAST:
			case WEST:
				return findInParent(editPointProvider, editPoint, parentEntity, direction);
			}
		}
		return editPointProvider.getEditPoint();
	}

	public EditPoint findInChild(IEditPointProvider editPointProvider, EditPoint editPoint, IEntity child, int direction) {
		//TODO
		
		return editPointProvider.getEditPoint();
	}

	public int indexOf(IEntityPart parent, IEntityPart child) {
		return parent.getChildren().indexOf(child);//FIXME content pane aware
	}
	public IEntityPart getChild(IEntity part, int index) {
		return (IEntityPart) part.wGet(index);//FIXME content pane aware
	}
	public IEntityPart getLastChild(IEntityPart part) {
		List children = part.getChildren();//FIXME content pane aware
		return (IEntityPart)children.get(children.size()-1);
	}
}
