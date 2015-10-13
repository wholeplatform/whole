/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.figures;

import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.UpdateListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Caret;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.util.CaretUtils;

/** 
 * NB apply changes also on TextualNodeFigure
 * 
 * @author Riccardo Solmi, Enrico Persiani
 */
public class TextualFigure extends EntityFigure implements ITextualFigure {
	private static final int FLAG_RANGE_SELECTED = new Integer(Figure.MAX_FLAG << 1).intValue();
	protected static int MAX_FLAG = FLAG_RANGE_SELECTED;

	protected Label label;
	protected int caretPosition;
	protected Rectangle caretBounds;
	protected Caret caret;
	protected Point lastProximityPoint;
	protected int rangeStart;
	protected int rangeEnd;

	public TextualFigure() {
		this(LabelFactory.createContent());
	}
	public TextualFigure(Label label) {
		this(label, new MonoLayout().withMinorAlignment(Alignment.CENTER).withMajorAlignment(Alignment.CENTER));
	}
	public TextualFigure(Label label, LayoutManager manager) {
		setLayoutManager(manager);
		add(this.label = label);
		setBorder(TextMarginBorder.instance);
		resetLastProximityPoint();
	}

	public String getText() {
		return label.getText();
	}
	public void setText(String text) {
		label.setText(text);
	}
	public Rectangle getTextBounds() {
		return label.getTextBounds();
	}

	public int getCaretPosition() {
		return caretPosition;
	}

	public void setCaretPosition(int position) {
		caretPosition = position;
		updateCaret();
	}

	public void setSelectionRange(int start, int end) {
		this.rangeStart = start;
		this.rangeEnd = end;
		int caretPositions = getCaretPositions();
		setFlag(FLAG_RANGE_SELECTED, start >= 0 &&
				start <= end && end <= caretPositions);
		repaint();
	}
	public boolean hasSelectionRange() {
		return getFlag(FLAG_RANGE_SELECTED);
	}

	public Rectangle getCaretBounds() {
		return caretBounds;
	}
	protected void updateCaret() {
		getUpdateManager().runWithUpdate(getCaretUpdater());
	}

	private void updateCaretBounds() {
		getCaret().setBounds(CaretUtils.getAbsoluteCaretBounds(this, getCaretBounds()));
	}

	public int updateCaret(Point proximityPoint) {
		if (hasCaret() && updateCaretLocation(proximityPoint))
			updateCaretBounds();
		return caretPosition;
	}

	protected int getTextWidth(String text) {
		return FigureUtilities.getTextWidth(text, label.getFont());
	}

	protected boolean updateCaretLocation(Point location) {
		Point proximityPoint = location.getCopy();
		translateToRelative(proximityPoint);
		Rectangle labelBounds = getTextBounds();

		if (proximityPoint.equals(lastProximityPoint) || !labelBounds.contains(proximityPoint))
			return false;
		else
			lastProximityPoint = proximityPoint;
		
		String text = label.getText();
		Dimension caretSize = CaretUtils.getCaretSize(label.getFont());
		int line = CaretUtils.getCaretLine(proximityPoint, labelBounds, caretSize);
		int verticalCaretLocation = labelBounds.y+(caretSize.height*line);

		if (proximityPoint.x <= labelBounds.x) {
			caretPosition = CaretUtils.getStartingLinePosition(text, line);
			caretBounds = new Rectangle(labelBounds.x, verticalCaretLocation, caretSize.width, caretSize.height);
			return true;
		}
		if (proximityPoint.x > labelBounds.x + labelBounds.width) {
			caretPosition = CaretUtils.getEndingLinePosition(text, line);
			int xOffset = getTextWidth(CaretUtils.getLine(text, line));
			caretBounds = new Rectangle(labelBounds.x + xOffset, verticalCaretLocation, caretSize.width, caretSize.height);
			return true;
		}

		// calculate intermediate positions
		String textLine = CaretUtils.getLine(text, line);
		int left = labelBounds.x;
		int right = left;
		int width = 0;
		int index = 1;
		while (index <= textLine.length()) {
			width = getTextWidth(textLine.substring(index-1, index));
			right = left + width;
			if (left <= proximityPoint.x && proximityPoint.x < right)
				break;
			left = right;
			index++;
		}
		assert left <= right;
		int newPosition = CaretUtils.getStartingLinePosition(text, line)+index;
		if ((proximityPoint.x - left) <= width/2) {
			caretPosition = newPosition-1;
			caretBounds = new Rectangle(left, verticalCaretLocation, caretSize.width, caretSize.height);
		} else {
			caretPosition = index > textLine.length() ? newPosition-1 : newPosition;
			caretBounds = new Rectangle(right, verticalCaretLocation, caretSize.width, caretSize.height);
		}
		return true;
	}

	protected void updateCaretPosition() {
		String text = label.getText();
		if (text.length() < caretPosition) {
			caretPosition = text.length();
		}
		updateCaretPosition(caretPosition);
	}

	protected void updateCaretPosition(int position) {
		String text = label.getText();
		Rectangle labelBounds = getTextBounds();
		Dimension caretSize = CaretUtils.getCaretSize(label.getFont());
		int line = getLineFromPosition(position);
		int verticalCaretLocation = labelBounds.y+(caretSize.height*line);
		int xOffset = getTextWidth(text.substring(CaretUtils.getStartingLinePosition(text, line), position));
		caretBounds = new Rectangle(labelBounds.x + xOffset, verticalCaretLocation, caretSize.width, caretSize.height);
	}

	public Label getEmbeddedLabel() {
		return label;
	}

	public void deactivateCaret() {
		if (caret == null)
			return;
		resetLastProximityPoint();
		caret.setVisible(false);
		caret = null;
		getUpdateManager().removeUpdateListener(getCaretUpdateListener());
	}

	private void resetLastProximityPoint() {
		lastProximityPoint = null;
	}

	public void activateCaret(Caret caret) {
		getUpdateManager().addUpdateListener(getCaretUpdateListener());
		this.caret = caret;
		caret.setVisible(isVisible());
	}

	protected boolean hasCaret() {
		return caret != null;
	}

	protected Caret getCaret() {
		return caret;
	}

	public int getCaretPositions() {
		return getEmbeddedLabel().getText().length();
	}

	public int getCaretLines() {
		return CaretUtils.getCaretLines(label.getText());
	}
	
	public int getLineFromPosition(int position) {
		return CaretUtils.getLineFromPosition(label.getText(), position);
	}

	private UpdateListener caretUpdateListener;
	protected final UpdateListener getCaretUpdateListener() {
		if (caretUpdateListener == null)
			caretUpdateListener = createCaretUpdateListener();
		return caretUpdateListener;
	}
	protected CaretUpdateListener createCaretUpdateListener() {
		return new CaretUpdateListener();
	}

	private class CaretUpdateListener implements UpdateListener {
		@SuppressWarnings("rawtypes")
		public void notifyPainting(Rectangle damage, Map dirtyRegions) {
			updateCaret();
		}
		public void notifyValidating() {
		}
	}

	private CaretUpdater caretUpdater;
	protected final CaretUpdater getCaretUpdater() {
		if (caretUpdater == null)
			caretUpdater = createCaretUpdater();
		return caretUpdater;
	}
	protected CaretUpdater createCaretUpdater() {
		return new CaretUpdater();
	}

	private final class CaretUpdater implements Runnable {
		public void run() {
			if (hasCaret()) {
				updateCaretPosition();
				updateCaretBounds();
			}
		}
	}

	public void revealCaret() {
		getUpdateManager().runWithUpdate(new Runnable() {
			public void run() {
				CaretUtils.revealCaret(getCaret());
			}
		});
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		if (hasSelectionRange()) {
			graphics.setBackgroundColor(FigurePrefs.lightBlueColor);
			String text = label.getText();
			int startLine = CaretUtils.getLineFromPosition(text, rangeStart);
			int endLine = CaretUtils.getLineFromPosition(text, rangeEnd);
			int fontHeight = FigureUtilities.getFontMetrics(label.getFont()).getHeight();
			Rectangle bounds = getTextBounds();

			if (startLine == endLine) {
				// paint single line selection
				String initialPart = text.substring(CaretUtils.getStartingLinePosition(text, startLine), rangeStart);
				String selectionPart = text.substring(rangeStart, rangeEnd);
				int initialWidth = getTextWidth(initialPart);
				int selectionWidth = getTextWidth(selectionPart);
				Rectangle selection = bounds.getTranslated(initialWidth, startLine*fontHeight);
				selection.setSize(selectionWidth, fontHeight);
				graphics.fillRectangle(selection);
			} else {
				// paint first partial row
				int initialWidth = getTextWidth(text.substring(CaretUtils.getStartingLinePosition(text, startLine), rangeStart));
				Rectangle selection = bounds.getTranslated(initialWidth, startLine*fontHeight).resize(-initialWidth, 0);
				selection.height = fontHeight;
				graphics.fillRectangle(selection);
				// paint middle rows if any
				for (int i=startLine+1; i<endLine; i++) {
					selection = bounds.getTranslated(0, i*fontHeight);
					selection.height = fontHeight;
					graphics.fillRectangle(selection);
				}
				// paint last partial row
				int finalWidth = getTextWidth(text.substring(CaretUtils.getStartingLinePosition(text, endLine), rangeEnd));
				selection = bounds.getTranslated(0, endLine*fontHeight);
				selection.height = fontHeight;
				selection.width = finalWidth;
				graphics.fillRectangle(selection);
			}
		} else
			super.paintFigure(graphics);
	}
}
