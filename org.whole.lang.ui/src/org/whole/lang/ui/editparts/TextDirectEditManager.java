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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.figures.ITextFigure;
import org.whole.lang.ui.viewers.HistoryCommandStack;

/**
 * @author Enrico Persiani
 */
public class TextDirectEditManager extends DirectEditManager implements IActionRedirection {
	protected Font scaledFont;

	protected TextDirectEditManager(IGraphicalEntityPart source, Class<?> editorType, CellEditorLocator locator) {
		super(source, editorType, locator);
	}

	@Override
	public boolean isActive() {
		return getCellEditor() != null 
				&& getCellEditor().isActivated();
	}

	public void performCopy() {
		if (getCellEditor().isCopyEnabled())
			getCellEditor().performCopy();
	}
	public void performCut() {
		if (getCellEditor().isCutEnabled()) {
			getCellEditor().performCut();
			getCommandStack().forceRefresh();
		}
	}
	public void performPaste() {
		if (getCellEditor().isPasteEnabled()) {
			getCellEditor().performPaste();
			getCommandStack().forceRefresh();
		}
	}

	public void performUndo() {
		if (getCellEditor().isUndoEnabled()) {
			getCellEditor().performUndo();
			getCommandStack().forceRefresh();
		}

	}
	public void performRedo() {
		if (getCellEditor().isRedoEnabled()) {
			getCellEditor().performRedo();
			getCommandStack().forceRefresh();
		}
	}

	public void performSelectAll() {
		if (getCellEditor().isSelectAllEnabled())
			getCellEditor().performSelectAll();
	}

	@Override
	protected IGraphicalEntityPart getEditPart() {
		return (IGraphicalEntityPart) super.getEditPart();
	}
	protected HistoryCommandStack getCommandStack() {
		return (HistoryCommandStack) getEditPart().getViewer().getCommandStack();
	}

	protected void bringDown() {
		Font disposeFont = scaledFont;
		scaledFont = null;
		super.bringDown();
		if (disposeFont != null)
			disposeFont.dispose();
	}

	public void showFeedback() {
		showDefaultFeedback();
	}

	protected void showDefaultFeedback() {
		super.showFeedback();
	}

	protected CellEditor createCellEditorOn(Composite composite) {
		return new TextCellEditor(composite, SWT.MULTI | SWT.WRAP);
	}
	protected CellEditor createDefaultCellEditorOn(Composite composite) {
		return super.createCellEditorOn(composite);
	}

	protected void initCellEditor() {
		initCellEditor((Text) getCellEditor().getControl());
	}
	protected void initCellEditor(Text text) {
		ITextFigure textFigure = (ITextFigure) getEditPart().getFigure();
		String initialLabelText = textFigure.getText();

		getCellEditor().setValue(initialLabelText);
		IFigure figure = getEditPart().getFigure();
		scaledFont = figure.getFont();
		
		FontData data = scaledFont.getFontData()[0];
		Dimension fontSize = new Dimension(0, data.getHeight());
		textFigure.translateToAbsolute(fontSize);
		data.setHeight(fontSize.height);
		scaledFont = new Font(null, data);
		text.setFont(scaledFont);
	}
}
