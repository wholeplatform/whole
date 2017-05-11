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
package org.whole.lang.tests.ui.figures;

import java.util.Optional;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.tests.model.OutcomeEnum;
import org.whole.lang.tests.model.Result;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ResultFigure extends EntityFigure {
	protected OutcomeFigure outcomeFigure;
	protected EntityButton buttonFigure;

	public ResultFigure(ActionListener linkAction) {
		super(new RowLayout());

		add(this.outcomeFigure = new OutcomeFigure());
		add(this.buttonFigure = new EntityButton(linkAction));
	}

	public void update(Result result) {
		Optional<String> cause = Optional.ofNullable(EntityUtils.safeStringValue(result.getCause(), null));
		Optional<String> location = Optional.ofNullable(EntityUtils.safeStringValue(result.getLocation(), null));
		update(result.getOutcome().getValue(), cause, location);
	}

	public void update(OutcomeEnum.Value outcome,
			Optional<String> cause, Optional<String> location) {
		this.outcomeFigure.update(outcome);
		this.setToolTip(cause.isPresent() ? new EntityLabel(cause.get()) : null);
		this.buttonFigure.getModel().setUserData(location.orElse(""));
		this.buttonFigure.setVisible(location.isPresent());
		repaint();
	}
}
