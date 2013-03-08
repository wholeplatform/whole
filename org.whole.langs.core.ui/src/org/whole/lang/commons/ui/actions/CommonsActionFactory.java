/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.commons.ui.actions;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.actions.CompositeAddAction;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.actions.ReplaceChildAction;
import org.whole.lang.ui.editor.ActionFactory;
import org.whole.lang.util.DefaultCopyTransformer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CommonsActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final CommonsActionFactory instance = new CommonsActionFactory();
	}
	public static CommonsActionFactory instance() {
		return SingletonHolder.instance;
	}
	protected CommonsActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.SameStageFragment, "SameStageFragment", wrapIn0},
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.StageDownFragment, "StageDownFragment", wrapIn0},
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.StageUpFragment, "StageUpFragment", wrapIn0}
		};
	}

	@Override
	public SelectionAction createAddAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> addEntityDescriptor) {
		if (CommonsEntityDescriptorEnum.Variable.equals(addEntityDescriptor) ||
				CommonsEntityDescriptorEnum.InlineVariable.equals(addEntityDescriptor))
			return new CompositeAddAction(workbenchPart, EnablerPredicateFactory.instance.alwaysTrue(),
					addEntityDescriptor, toPresentationName(addEntityDescriptor.getName())) {
				
				protected IEntity configureNewChild(IEntity selectedEntity, IEntity newChild) {
					EntityDescriptor<?> elementED = selectedEntity.wGetEntityDescriptor(0);
					((Variable) newChild).getVarType().wSetValue(elementED);
					return newChild;
				}
			};
		else
			return super.createAddAction(workbenchPart, addEntityDescriptor);
	}

	@Override
	public SelectionAction createReplaceAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> replaceEntityDescriptor) {
		if (CommonsEntityDescriptorEnum.Variable.equals(replaceEntityDescriptor) ||
				CommonsEntityDescriptorEnum.InlineVariable.equals(replaceEntityDescriptor))
			return new ReplaceChildAction(workbenchPart, EnablerPredicateFactory.instance.alwaysTrue(), 
					replaceEntityDescriptor, toPresentationName(replaceEntityDescriptor.getName()),
					new DefaultCopyTransformer() {

				public void transform(IEntity selectedEntity, IEntity newEntity) {
					if (CommonsEntityDescriptorEnum.Variable.equals(selectedEntity.wGetEntityDescriptor()) ||
							 CommonsEntityDescriptorEnum.InlineVariable.equals(selectedEntity.wGetEntityDescriptor()))
						super.transform(selectedEntity, newEntity);
					else {
						newEntity.wGet(CommonsFeatureDescriptorEnum.varName).wSetValue(selectedEntity.wGetParent().wGetFeatureDescriptor(selectedEntity).getName());
						newEntity.wGet(CommonsFeatureDescriptorEnum.varType).wSetValue(
								EntityUtils.isResolver(selectedEntity) ? selectedEntity.wGetParent().wGetEntityDescriptor(selectedEntity) : //TODO workaround for resolver container descriptor
								selectedEntity.wGetEntityDescriptor());
					}
				}
			});
		else
			return super.createReplaceAction(workbenchPart, replaceEntityDescriptor);
	};
}
