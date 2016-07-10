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
package org.whole.lang.ui.notations.dynamic.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 * @author Riccardo Solmi
 */
public class DynamicPartFactory implements IEditPartFactory {
	protected Map<EntityDescriptor<?>, IOptionalPartFactoryMethod<DynamicPartFactory>> edFactoryMethodMap = new HashMap<>();
	protected Map<EntityKinds, IOptionalPartFactoryMethod<DynamicPartFactory>> kindFactoryMethodMap = new HashMap<>();
	protected IEditPartFactory defaultPartFactory = TablePartFactory.instance();

	public DynamicPartFactory(boolean generic) {
		if (generic)
			putFactoryMethod(CommonsEntityDescriptorEnum.Resolver, (pf, p, e) -> new PlaceHolderPart() );
	}

	public void setDefaultPartFactory(IEditPartFactory defaultPartFactory) {
		this.defaultPartFactory = defaultPartFactory;
	}
	public void putFactoryMethod(EntityKinds entityKind, IEntityPartFactoryMethod<DynamicPartFactory> factoryMethod) {
		kindFactoryMethodMap.put(entityKind, factoryMethod);
	}
	public void putFactoryMethod(EntityDescriptor<?> ed, IEntityPartFactoryMethod<DynamicPartFactory> factoryMethod) {
		edFactoryMethodMap.put(ed, factoryMethod);
	}
	public ChoosePartFactoryMethod<DynamicPartFactory> chooseFactoryMethod(EntityDescriptor<?> ed) {
		ChoosePartFactoryMethod<DynamicPartFactory> factoryMethod = new ChoosePartFactoryMethod<>();
		edFactoryMethodMap.put(ed, factoryMethod);
		return factoryMethod;
	}

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntityPart contextPart = (IEntityPart) context;
		IEntity entity = (IEntity) modelEntity;
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

		IOptionalPartFactoryMethod<DynamicPartFactory> factoryMethod = edFactoryMethodMap.get(ed);
		if (factoryMethod == null)
			factoryMethod = kindFactoryMethodMap.get(ed.getEntityKind());
		if (factoryMethod == null)
			return defaultPartFactory.createEditPart(contextPart, entity);

		return factoryMethod.apply(this, contextPart, entity).get();
	}
}
