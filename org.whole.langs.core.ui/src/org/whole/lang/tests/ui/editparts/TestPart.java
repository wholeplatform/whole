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
package org.whole.lang.tests.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.Test;
import org.whole.lang.tests.ui.figures.TestFigure;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class TestPart extends AbstractTestPart {
	protected IFigure createFigure() {
		return new TestFigure((event) -> {
			String location = (String) ((Clickable) event.getSource()).getModel().getUserData();
			Test test = getModelEntity();
			IEntity root = EntityUtils.getFragmentRoot(test);
			IEntityPartViewer viewer = getViewer();
			viewer.getControl().getDisplay().asyncExec(() ->
					viewer.selectAndReveal(EntityUtils.getEntity(root, location)));
		});
	}

	@Override
	public TestFigure getFigure() {
		return (TestFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("expectedResult") ||
				evt.getPropertyName().equals("actualResult"))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		Test entity = getModelEntity();
		getFigure().updateResult(entity.getExpectedResult(), entity.getActualResult());
	}
	protected List<IEntity> getModelSpecificChildren() {
		Test entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(3);
		list.add(entity.getDescription());
		list.add(entity.getName());
		list.add(entity.getBody());
		return list;
	}
}
