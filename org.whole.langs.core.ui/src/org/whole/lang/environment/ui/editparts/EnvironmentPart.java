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
package org.whole.lang.environment.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.environment.model.BindingsModel;
import org.whole.lang.environment.model.Environment;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.ui.figures.EnvironmentFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class EnvironmentPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		Environment entity = getModelEntity();
		return new EnvironmentFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Environment entity = getModelEntity();
				ModelTransactionCommand command = new ModelTransactionCommand(entity);
				try {
					command.begin();
					IBindingManager bm = entity.getBindingManager().getValue();
					if (Matcher.match(EnvironmentEntityDescriptorEnum.Bindings, entity.getBindings()))
						entity.setBindings((BindingsModel) BindingManagerFactory.instance.createFlatScopedBindingsModel(bm));
					else
						entity.setBindings((BindingsModel) BindingManagerFactory.instance.createFlatBindingsModel(bm));

					command.commit();
					getViewer().getEditDomain().getCommandStack().execute(command);
				} catch (Exception e) {
					command.rollbackIfNeeded();
				}
			}
		}, Matcher.matchImpl(EnvironmentEntityDescriptorEnum.ScopedBindings, entity.getBindings()));
	}

	@Override
	protected List<IEntity> getModelSpecificChildren() {
		Environment entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(3);
		list.add(entity.getName());
		list.add(entity.getFilter());
		list.add(entity.getBindings());
		return list;
	}
}
