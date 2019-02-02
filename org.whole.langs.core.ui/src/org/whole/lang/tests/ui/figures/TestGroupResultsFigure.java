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
package org.whole.lang.tests.ui.figures;

import static org.whole.lang.tests.reflect.TestsEntityDescriptorEnum.Results;

import java.util.Arrays;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.whole.lang.tests.model.OutcomeEnum;
import org.whole.lang.tests.model.OutcomeEnum.Value;
import org.whole.lang.tests.model.Results;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TestGroupResultsFigure extends TableFigure {
	private static final int RESULTS_FEATURES = Results.featureSize();

	protected IEntityFigure[] expectedResults;
	protected IEntityFigure[] actualResults;

	public TestGroupResultsFigure() {
		super(new TableLayout(RESULTS_FEATURES) {
			public int getAscent(int height) {
				return height - getRow(0).getAscent() - 1;
			};
		}.withColumnSpacing(9).withMarginLeft(4));
		
		TableRowFigure exptectedRow = new TableRowFigure() {
			@Override
			public void paint(Graphics graphics) {
				int alpha = graphics.getAlpha();
				graphics.setAlpha(96);
				super.paint(graphics);
				graphics.setAlpha(alpha);
			}
		};
		Arrays.setAll(this.expectedResults = new IEntityFigure[RESULTS_FEATURES], (i) -> {
			EntityFigure cell = new EntityFigure(new RowLayout().withSpacing(2));
			cell.add(cell.addContent(""));
			cell.add(createOutcomeFigure(i));
			return exptectedRow.add(cell);
		});
		add(exptectedRow);

		TableRowFigure actualRow = new TableRowFigure();
		Arrays.setAll(this.actualResults = new IEntityFigure[RESULTS_FEATURES], (i) -> {	
			EntityFigure cell = new EntityFigure(new RowLayout().withSpacing(2));
			cell.add(cell.addContent(""));
			cell.add(createOutcomeFigure(i));
			return actualRow.add(cell);
		});
		add(actualRow);
	}

	protected IFigure createOutcomeFigure(int i) {
		Value value = OutcomeEnum.instance.valueOf(i);
		return new OutcomeFigure(value);
	}

	public void update(Results expected, Results actual) {
		setVisible(EntityUtils.isImpl(actual));
		if (isVisible()) {
			for (int i=0; i<RESULTS_FEATURES; i++) {
				Label actualLabel = (Label) actualResults[i].getChildren().get(0);
				actualLabel.setText(EntityUtils.isImpl(actual) ? 
						DataTypeUtils.getAsPresentationString(actual.wGet(i)) : "0");

				Label expectedLabel = (Label) expectedResults[i].getChildren().get(0);
				expectedLabel.setText(EntityUtils.isImpl(expected) ?
						DataTypeUtils.getAsPresentationString(expected.wGet(i)) : "0");

				IEntityFigure expectedOutcome = (IEntityFigure) expectedResults[i].getChildren().get(1);
				expectedOutcome.setVisible(EntityUtils.isImpl(expected) &&
						!actualLabel.getText().equals(expectedLabel.getText()));

				if (!expectedOutcome.isVisible())
					expectedLabel.setText("");
			}
		}
	}
}
