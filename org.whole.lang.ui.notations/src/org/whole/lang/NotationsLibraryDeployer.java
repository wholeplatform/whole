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
package org.whole.lang;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
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

		putFunctionCode("caretLeftText", caretLeftTextIterator());
		putFunctionCode("caretSelectedText", caretSelectedTextIterator());
		putFunctionCode("caretRightText", caretRightTextIterator());
		putFunctionCode("caretPositions", caretPositionsIterator());
		putFunctionCode("caretPosition", caretPositionIterator());
		putFunctionCode("caretPositionStart", caretPositionStartIterator());
		putFunctionCode("caretPositionEnd", caretPositionEndIterator());
	}

	protected abstract static class EntityPartPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			IEntityPart entityPart = null;

			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			entityPart = ModelObserver.getObserver(selfEntity, viewer.getEditPartRegistry());

			if (entityPart != null)
				setResult(bm, entityPart);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, IEntityPart entityPart);
	}
	protected abstract static class EntityPartSingleValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			bm.setResult(getProperty(entityPart));
		}
		protected abstract IEntity getProperty(IEntityPart entityPart);
	}
	protected abstract static class EntityPartMultiValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			bm.setResultIterator(getPropertyIterator(entityPart));
		}
		protected abstract IEntityIterator<?> getPropertyIterator(IEntityPart entityPart);
	}

	protected abstract static class TextualEntityPartSingleValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			if (entityPart instanceof ITextualEntityPart)
				bm.setResult(getProperty((ITextualEntityPart) entityPart));
		}
		protected abstract IEntity getProperty(ITextualEntityPart entityPart);
	}
	protected abstract static class TextualEntityPartMultiValuedPropertyRunnable extends EntityPartPropertyRunnable {
		protected void setResult(IBindingManager bm, IEntityPart entityPart) {
			if (entityPart instanceof ITextualEntityPart)
				bm.setResultIterator(getPropertyIterator((ITextualEntityPart) entityPart));
		}
		protected abstract IEntityIterator<?> getPropertyIterator(ITextualEntityPart entityPart);
	}

	public static IEntityIterator<IEntity> entityPartIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart);
			}
		});
	}

	public static IEntityIterator<IEntity> entityPartIsGraphicalIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart instanceof IGraphicalEntityPart);
			}
		});
	}

	public static IEntityIterator<IEntity> entityPartIsTextualIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(IEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart instanceof ITextualEntityPart);
			}
		});
	}

	public static IEntityIterator<IEntity> caretLeftTextIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				String textToSplit = DataTypeUtils.getAsPresentationString(entityPart.getModelEntity());
				int selectionStart = entityPart.getSelectionStart();
				if (selectionStart < 0)
					selectionStart = entityPart.getCaretPosition();
				String leftText = textToSplit.substring(0, selectionStart);
				return BindingManagerFactory.instance.createValue(leftText);
			}
		});
	}

	public static IEntityIterator<IEntity> caretSelectedTextIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
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

	public static IEntityIterator<IEntity> caretRightTextIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				String textToSplit = DataTypeUtils.getAsPresentationString(entityPart.getModelEntity());
				int selectionEnd = entityPart.getSelectionEnd();
				if (selectionEnd < 0)
					selectionEnd = entityPart.getCaretPosition();
				String rightText = textToSplit.substring(selectionEnd);
				return BindingManagerFactory.instance.createValue(rightText);
			}
		});
	}

	public static IEntityIterator<IEntity> caretPositionsIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart.getCaretPositions());
			}
		});
	}
	
	public static IEntityIterator<IEntity> caretPositionIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				return BindingManagerFactory.instance.createValue(entityPart.getCaretPosition());
			}
		});
	}
	
	public static IEntityIterator<IEntity> caretPositionStartIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				int selectionStart = entityPart.getSelectionStart();
				if (selectionStart < 0)
					selectionStart = entityPart.getCaretPosition();
				return BindingManagerFactory.instance.createValue(selectionStart);
			}
		});
	}
	
	public static IEntityIterator<IEntity> caretPositionEndIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new TextualEntityPartSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ITextualEntityPart entityPart) {
				int selectionEnd = entityPart.getSelectionEnd();
				if (selectionEnd < 0)
					selectionEnd = entityPart.getCaretPosition();
				return BindingManagerFactory.instance.createValue(selectionEnd);
			}
		});
	}
}
