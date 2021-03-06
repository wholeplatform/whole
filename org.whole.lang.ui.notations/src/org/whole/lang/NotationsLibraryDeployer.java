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
package org.whole.lang;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.util.FigureUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;

/**
 * @author Enrico Persiani
 */
public class NotationsLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:NotationsLibrary";

	@Override
	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("entityPart", entityPartIterator());
		putFunctionCode("entityPartIsGraphical", entityPartIsGraphicalIterator());
		putFunctionCode("entityPartIsTextual", entityPartIsTextualIterator());

		putFunctionCode("entityPartParent", entityPartParentIterator());
		putFunctionCode("entityPartChildren", entityPartChildrenIterator());
		putFunctionCode("entityPartClosestAbove", entityPartClosestAboveIterator());
		putFunctionCode("entityPartClosestBelow", entityPartClosestBelowIterator());

		putFunctionCode("entityPartNorthwards", entityPartNorthwardsIterator());
		putFunctionCode("entityPartSouthwards", entityPartSouthwardsIterator());
		putFunctionCode("entityPartWestwards", entityPartWestwardsIterator());
		putFunctionCode("entityPartEastwards", entityPartEastwardsIterator());

		putFunctionCode("modelEntity", modelEntityIterator());
		putFunctionCode("parentModelEntity", parentModelEntityIterator());

		putFunctionCode("caretLeftText", caretLeftTextIterator());
		putFunctionCode("caretSelectedText", caretSelectedTextIterator());
		putFunctionCode("caretRightText", caretRightTextIterator());
		putFunctionCode("caretPositions", caretPositionsIterator());
		putFunctionCode("caretPosition", caretPositionIterator());
		putFunctionCode("caretPositionStart", caretPositionStartIterator());
		putFunctionCode("caretPositionEnd", caretPositionEndIterator());

		putFunctionCode("entityFigure", entityFigureIterator());
		putFunctionCode("entityFigureParent", entityFigureParentIterator());
		putFunctionCode("entityFigureChildren", entityFigureChildrenIterator());
		putFunctionCode("entityFigureIsVisible", entityFigureIsVisibleIterator());
		putFunctionCode("entityFigureIsShowing", entityFigureIsShowingIterator());
		putFunctionCode("entityFigureClosestAbove", entityFigureClosestAboveIterator());
		putFunctionCode("entityFigureClosestBelow", entityFigureClosestBelowIterator());

		putFunctionCode("entityFigureBounds", entityFigureBoundsIterator());
		putFunctionCode("entityFigureBoundsClosestAbove", entityFigureBoundsClosestAboveIterator());
		putFunctionCode("entityFigureBoundsClosestBelow", entityFigureBoundsClosestBelowIterator());
	}

	protected abstract static class EntityPartPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			IEntityPart entityPart = null;

			if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof IEntityPart)
				entityPart = (IEntityPart) selfEntity.wGetValue();
			else {
				IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
				entityPart = ModelObserver.getObserver(selfEntity, viewer.getEditPartRegistry());
			}

			if (entityPart != null)
				setResult(bm, entityPart);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, IEntityPart entityPart);
	}
	protected abstract static class EntityPartSingleValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			bm.setResult(getProperty((IEntityPartViewer) bm.wGetValue("viewer"), entityPart));
		}
		protected abstract IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart);
	}
	protected abstract static class EntityPartMultiValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			bm.setExecutableResult(getPropertyIterator((IEntityPartViewer) bm.wGetValue("viewer"), entityPart));
		}
		protected abstract IExecutable getPropertyIterator(IEntityPartViewer viewer, IEntityPart entityPart);
	}
	protected abstract static class TextualEntityPartSingleValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			if (entityPart instanceof ITextualEntityPart)
				bm.setResult(getProperty((IEntityPartViewer) bm.wGetValue("viewer"), (ITextualEntityPart) entityPart));
		}
		protected abstract IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart);
	}

	protected abstract static class EntityFigurePropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			IFigure figure = null;

			if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof IFigure)
				figure = (IFigure) selfEntity.wGetValue();
			else {
				IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
				IEntityPart entityPart = ModelObserver.getObserver(selfEntity, viewer.getEditPartRegistry());
				if (entityPart instanceof IGraphicalEntityPart)
					figure = ((IGraphicalEntityPart) entityPart).getFigure();
			}

			if (figure instanceof IEntityFigure)
				setResult(bm, (IEntityFigure) figure);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, IEntityFigure entityFigure);
	}
	protected abstract static class EntityFigureSingleValuedPropertyRunnable extends EntityFigurePropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityFigure entityFigure) {
			bm.setResult(getProperty((IEntityPartViewer) bm.wGetValue("viewer"), entityFigure));
		}
		protected abstract IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure);
	}
	protected abstract static class EntityFigureMultiValuedPropertyRunnable extends EntityFigurePropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityFigure entityFigure) {
			bm.setExecutableResult(getPropertyIterator((IEntityPartViewer) bm.wGetValue("viewer"), entityFigure));
		}
		protected abstract IExecutable getPropertyIterator(IEntityPartViewer viewer, IEntityFigure entityFigure);
	}

	protected abstract static class EntityFigureBoundsPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			Rectangle bounds = null;

			if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof Rectangle)
				bounds = (Rectangle) selfEntity.wGetValue();
			else {
				IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
				IEntityPart entityPart = ModelObserver.getObserver(selfEntity, viewer.getEditPartRegistry());
				if (entityPart instanceof IGraphicalEntityPart)
					bounds = ((IGraphicalEntityPart) entityPart).getFigure().getBounds().getCopy();
			}

			if (bounds instanceof Rectangle)
				setResult(bm, (Rectangle) bounds);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, Rectangle bounds);
	}
	protected abstract static class EntityFigureBoundsSingleValuedPropertyRunnable extends EntityFigureBoundsPropertyRunnable {
		protected void setResult(IBindingManager bm, Rectangle bounds) {
			bm.setResult(getProperty((IEntityPartViewer) bm.wGetValue("viewer"), bounds));
		}
		protected abstract IEntity getProperty(IEntityPartViewer viewer, Rectangle bounds);
	}

	public static IExecutable entityPartIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart);
			}
		});
	}

	public static IExecutable entityPartIsGraphicalIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart instanceof IGraphicalEntityPart);
			}
		});
	}

	public static IExecutable entityPartIsTextualIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart instanceof ITextualEntityPart);
			}
		});
	}

	public static IExecutable entityPartParentIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				IEntityPart parent = (IEntityPart) entityPart.getParent();
				return parent != null ? BindingManagerFactory.instance.createValue(parent) : null;
			}
		});
	}

	public static IExecutable entityPartChildrenIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityPartMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(IEntityPartViewer viewer, IEntityPart entityPart) {
				return ExecutableFactory.instance.createCollection(
						entityPart.getChildren(),
						IDataTypeWrapper.envObjectValue);
			}
		});
	}

	public static IExecutable entityPartClosestAboveIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosestAbove(viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable entityPartClosestBelowIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosestBelow(viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable entityPartNorthwardsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosest(PositionConstants.NORTH, viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable entityPartSouthwardsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosest(PositionConstants.SOUTH, viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable entityPartWestwardsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosest(PositionConstants.WEST, viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable entityPartEastwardsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart instanceof IGraphicalEntityPart ?
						BindingManagerFactory.instance.createValue(
								FigureUtils.getClosest(PositionConstants.EAST, viewer, (IGraphicalEntityPart) entityPart)) : null;
			}
		});
	}

	public static IExecutable modelEntityIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart.getModelEntity();
			}
		});
	}

	public static IExecutable parentModelEntityIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityPart entityPart) {
				return entityPart.getParentModelEntity();
			}
		});
	}

	public static IExecutable caretLeftTextIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				String textToSplit = DataTypeUtils.getAsPresentationString(entityPart.getModelEntity());
				int selectionStart = entityPart.getSelectionStart();
				if (selectionStart < 0)
					selectionStart = entityPart.getCaretPosition();
				String leftText = textToSplit.substring(0, selectionStart);
				return BindingManagerFactory.instance.createValue(leftText);
			}
		});
	}

	public static IExecutable caretSelectedTextIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				String textToSplit = DataTypeUtils.getAsPresentationString(entityPart.getModelEntity());
				int selectionStart = entityPart.getSelectionStart();
				int selectionEnd = entityPart.getSelectionEnd();
				if (selectionStart < 0 || selectionEnd < 0)
					selectionStart = selectionEnd = entityPart.getCaretPosition();
				String selectedText = textToSplit.substring(selectionStart, selectionEnd);
				return BindingManagerFactory.instance.createValue(selectedText);
			}
		});
	}

	public static IExecutable caretRightTextIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				String textToSplit = DataTypeUtils.getAsPresentationString(entityPart.getModelEntity());
				int selectionEnd = entityPart.getSelectionEnd();
				if (selectionEnd < 0)
					selectionEnd = entityPart.getCaretPosition();
				String rightText = textToSplit.substring(selectionEnd);
				return BindingManagerFactory.instance.createValue(rightText);
			}
		});
	}

	public static IExecutable caretPositionsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart.getCaretPositions());
			}
		});
	}

	public static IExecutable caretPositionIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart.getCaretPosition());
			}
		});
	}

	public static IExecutable caretPositionStartIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				int selectionStart = entityPart.getSelectionStart();
				if (selectionStart < 0)
					selectionStart = entityPart.getCaretPosition();
				return BindingManagerFactory.instance.createValue(selectionStart);
			}
		});
	}

	public static IExecutable caretPositionEndIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, ITextualEntityPart entityPart) {
				int selectionEnd = entityPart.getSelectionEnd();
				if (selectionEnd < 0)
					selectionEnd = entityPart.getCaretPosition();
				return BindingManagerFactory.instance.createValue(selectionEnd);
			}
		});
	}

	public static IExecutable entityFigureIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return BindingManagerFactory.instance.createValue(entityFigure);
			}
		});
	}

	public static IExecutable entityFigureParentIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				IEntityFigure parent = (IEntityFigure) entityFigure.getParent();
				return parent != null ? BindingManagerFactory.instance.createValue(entityFigure) : null;
			}
		});
	}

	public static IExecutable entityFigureChildrenIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityFigureMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return ExecutableFactory.instance.createCollection(
						entityFigure.getChildren(),
						IDataTypeWrapper.envObjectValue);
			}
		});
	}

	public static IExecutable entityFigureIsVisibleIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return BindingManagerFactory.instance.createValue(entityFigure.isVisible());
			}
		});
	}

	public static IExecutable entityFigureIsShowingIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return BindingManagerFactory.instance.createValue(entityFigure.isShowing());
			}
		});
	}

	public static IExecutable entityFigureClosestAboveIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return BindingManagerFactory.instance.createValue(FigureUtils.getClosestAbove(viewer, entityFigure));
			}
		});
	}

	public static IExecutable entityFigureClosestBelowIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, IEntityFigure entityFigure) {
				return BindingManagerFactory.instance.createValue(FigureUtils.getClosestBelow(viewer, entityFigure));
			}
		});
	}

	public static IExecutable entityFigureBoundsIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureBoundsSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, Rectangle bounds) {
				return BindingManagerFactory.instance.createValue(bounds);
			}
		});
	}

	public static IExecutable entityFigureBoundsClosestAboveIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureBoundsSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, Rectangle bounds) {
				return BindingManagerFactory.instance.createValue(FigureUtils.getClosestAbove(viewer, bounds));
			}
		});
	}

	public static IExecutable entityFigureBoundsClosestBelowIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityFigureBoundsSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPartViewer viewer, Rectangle bounds) {
				return BindingManagerFactory.instance.createValue(FigureUtils.getClosestBelow(viewer, bounds));
			}
		});
	}
}
