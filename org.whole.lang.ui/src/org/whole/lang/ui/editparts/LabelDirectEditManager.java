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

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class LabelDirectEditManager extends TextDirectEditManager {
	protected Label label;
	protected VerifyListener verifyListener;

	public LabelDirectEditManager(IGraphicalEntityPart source, Class<?> editorType, CellEditorLocator locator, Label label) {
		super(source, editorType, locator);
		this.label = label;
	}

	public void showFeedback() {
		showDefaultFeedback();
	}
	protected CellEditor createCellEditorOn(Composite composite) {
		return createDefaultCellEditorOn(composite);
	}

	protected void initCellEditor(Text text) {
		verifyListener = new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Text text = (Text) getCellEditor().getControl();
				String oldText = text.getText();
				String leftText = oldText.substring(0, event.start);
				String rightText = oldText.substring(event.end, oldText.length());
				String newText = leftText + event.text + rightText;
				Font font = text.getFont();
				if (newText.length() > 0) {
					Point size = text.computeSize(FigureUtilities.getTextWidth(newText, font), SWT.DEFAULT);
					text.setSize(size);
				}
			}
		};
 		text.addVerifyListener(verifyListener);

 		getCellEditor().setValue(DataTypeUtils.getAsPresentationString(getEditPart().getModelEntity()));
		scaledFont = label.getFont();

		FontData data = scaledFont.getFontData()[0];
		Dimension fontSize = new Dimension(0, data.getHeight());
		label.translateToAbsolute(fontSize);
		data.setHeight(fontSize.height);
		scaledFont = new Font(null, data);
		text.setFont(scaledFont);
	}
}
