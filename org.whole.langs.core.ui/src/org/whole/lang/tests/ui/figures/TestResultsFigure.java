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

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.tests.model.Result;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TestResultsFigure extends EntityFigure {
	protected ResultFigure expectedResult;
	protected ResultFigure actualResult;

	public TestResultsFigure(ActionListener linkAction) {
		super(new ColumnLayout().withMarginLeft(4));//FIXME .withMinorAutoresizeWeight(1f).withAutoresizeWeight(1f));

		add(expectedResult = new ResultFigure(linkAction) {
			@Override
			public void paint(Graphics graphics) {
				int alpha = graphics.getAlpha();
				graphics.setAlpha(96);
				super.paint(graphics);
				graphics.setAlpha(alpha);
			}
		});
		add(actualResult = new ResultFigure(linkAction));
	}

	public void update(Result expected, Result actual) {
		setVisible(EntityUtils.isImpl(actual));
		if (isVisible()) {
			expectedResult.update(expected);
			actualResult.update(actual);

			expectedResult.setVisible(EntityUtils.isImpl(expected) &&
					!Matcher.match(actual, expected));
		}
	}
}
