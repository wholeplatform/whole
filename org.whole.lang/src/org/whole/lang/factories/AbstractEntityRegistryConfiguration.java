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
package org.whole.lang.factories;

import java.util.Date;
import java.util.List;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityRegistryConfiguration implements IEntityRegistryConfiguration {	
	public void apply(IEntityRegistry er) {
		for (EntityDescriptor<?> ed : er.getEntityDescriptorEnum())
			if (!ed.isAbstract())
				apply(er, ed, er.get(ed));
	}
	protected void apply(IEntityRegistry er, EntityDescriptor<?> ed, IEntity prototype) {
	}

	public static void fillSimpleEntitiesWithResolvers(EntityDescriptor<?> ed, IEntity prototype) {
		if (ed.getEntityKind().isSimple()) {
			List<FeatureDescriptor> eds = ed.getEntityFeatureDescriptors();
			for (int i=0, size=eds.size(); i<size; i++)
				prototype.wSet(i,
						CommonsEntityAdapterFactory.createResolver(eds.get(i).getEntityDescriptor()));
		}
	}
	public static void fillCompositeEntitiesWithResolver(EntityDescriptor<?> ed, IEntity prototype) {
		if (ed.getEntityKind().isComposite() && prototype.wSize() == 0)
			prototype.wAdd(CommonsEntityAdapterFactory.createResolver(ed.getEntityDescriptor(0)));
	}
	public static void fillDataEntitiesWithDefaults(EntityDescriptor<?> ed, IEntity prototype) {
		if (ed.getEntityKind().isData()) {
			switch (ed.getDataKind()) {
			case STRING:
				prototype.wSetValue(StringUtils.toLowerCap(ed.getName()));
				break;
			case ENUM_VALUE:
				prototype.wSetValue(ed.getDataEnumType().valueOf(0));
				break;
			case DATE:
				prototype.wSetValue(new Date());
				break;
			case OBJECT:
//				prototype.wSetValue(DataTypeUtils.getDataTypeManager(ed, DataTypeManagers.PERSISTENCE).create(ed));
				break;
			}
		}
	}

	public static void enforceMandatoryFeatures(IEntityRegistry er) {
		boolean[] isEnforced = new boolean[er.getEntityDescriptorEnum().size()];
		for (EntityDescriptor<?> ed : er.getEntityDescriptorEnum())
			if (!ed.isAbstract())
				enforceMandatoryFeatures(er, ed, er.get(ed), isEnforced);
	}

	public static void enforceMandatoryFeatures(IEntityRegistry er, EntityDescriptor<?> ed, IEntity prototype, boolean[] isEnforced) {
		if (isEnforced[ed.getOrdinal()])
			return;
		isEnforced[ed.getOrdinal()] = true;

		if (ed.getEntityKind().isSimple()) {
			List<FeatureDescriptor> eds = ed.getEntityFeatureDescriptors();
			for (int i=0, size=eds.size(); i<size; i++) {
				FeatureDescriptor efd = eds.get(i);
				EntityDescriptor<?> fed = efd.getEntityDescriptor();
				if (fed.isPolymorphic() || efd.isOptional() || efd.isReference())
					 continue;
				
				IEntity child = prototype.wGet(i);
				if (!EntityUtils.isResolver(child))
					continue;

				if (fed.isAbstract())
					 continue;

				child = er.get(fed);
				enforceMandatoryFeatures(er, fed, child, isEnforced);
				child = EntityUtils.clone(child);
				prototype.wSet(i, child);

//				if (fed.getEntityKind().isComposite() && !fed.getEntityFeatureDescriptor(0).isOptional())
//					try {
//						child.wAdd(CommonsEntityAdapterFactory.createResolver(fed.getEntityDescriptor(0)));
//					} catch (UnsupportedOperationException e) {
//						//FIXME workaround for Map entity
//					}
			}
//		} else if (ed.getEntityKind().isComposite() && !ed.getEntityFeatureDescriptor(0).isOptional()) {
//			try {
//				prototype.wAdd(CommonsEntityAdapterFactory.createResolver(ed.getEntityDescriptor(0)));
//			} catch (UnsupportedOperationException e) {
//				//FIXME workaround for Map entity
//			}
		}
	}
}
