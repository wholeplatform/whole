/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.views.properties.tabbed;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class EntityPropertySource implements IPropertySource2 {
	protected IEntity entity;

	public EntityPropertySource(IEntity entity) {
		this.entity = entity;
	}

	public IEntity getModelEntity() {
		return entity;
	}

	public Object getEditableValue() {
		IEntity entity = getModelEntity();
		if (EntityUtils.isData(entity))
			return entity.wGetValue();
		else
			return entity.toString();
	}
	
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return createPropertyDescriptors(getModelEntity());
	}

	public Object getPropertyValue(Object id) {
		IEntity entity = getModelEntity();
		switch (entity.wGetEntityKind()) {
		case SIMPLE:
		case COMPOSITE:
			IEntity property = entity.wGet((FeatureDescriptor)id);
			if (EntityUtils.isData(property))
				return property.wGetValue();
			else
				return property.toString().replaceAll("\\s+", " ");
		case DATA:
			return entity.wGetValue();
		default:
			return null;
		}
	}

	public void setPropertyValue(Object id, Object value) {
		IEntity entity = getModelEntity();
		switch (entity.wGetEntityKind()) {
		case SIMPLE:
		case COMPOSITE:
			IEntity property = entity.wGet((FeatureDescriptor) id);
			property.wSetValue(value);
			break;
		case DATA:
			entity.wSetValue(value);
			break;
		}		
	}

	public boolean isPropertySet(Object id) {
		FeatureDescriptor fd = (FeatureDescriptor) id;
		IEntity child, entity = getModelEntity();

		if (CommonsFeatureDescriptorEnum.data_value.equals(fd)) {
			entity = (child = entity).wGetParent();
			fd = entity.wGetFeatureDescriptor(child);
		} else
			child = entity.wGet(fd);

		return !EntityUtils.isDefault(entity, fd, child);
	}
	public boolean isPropertyResettable(Object id) {
		return true;
	}
	public void resetPropertyValue(Object id) {
		FeatureDescriptor fd = (FeatureDescriptor) id;
		IEntity entity = getModelEntity();

		if (CommonsFeatureDescriptorEnum.data_value.equals(fd)) {
			IEntity child = entity;
			entity = child.wGetParent();
			fd = entity.wGetFeatureDescriptor(child);
			child.wSetValue(GenericEntityFactory.instance.cloneFeature(entity.wGetEntityDescriptor(), fd).wGetValue());
		} else
			EntityUtils.setDefault(entity, fd);
	}

	public IPropertyDescriptor[] createPropertyDescriptors(IEntity source) {
		switch (source.wGetEntityKind()) {
		case COMPOSITE:
			// FIXME merge with SIMPLE when typed FeatureDescriptors are implemented 
			return new IPropertyDescriptor[0];
		case SIMPLE:
			return createComplexPropertyDescriptor(source);
		case DATA:
			FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
			return new IPropertyDescriptor[] {createValuePropertyDescriptor(source, fd.getName(), fd)};
		default:
			return new IPropertyDescriptor[] {createDefaultPropertyDescriptor(source)};
		}
	}

	private IPropertyDescriptor createDefaultPropertyDescriptor(IEntity source, IEntity property, int propertyIndex) {
		FeatureDescriptor propertyId = source.wGetFeatureDescriptor(propertyIndex);
		String propertyName = propertyId.getName();
		return new ResolverPropertyDescriptor(propertyId, propertyName);
	}

	private IPropertyDescriptor createDefaultPropertyDescriptor(IEntity property) {
		String propertyName = property.wGetAdaptee(false).wGetEntityDescriptor().getName();
		Object propertyId = property.wGetEntityDescriptor();
		return new PropertyDescriptor(propertyId, propertyName);
	}

	private IPropertyDescriptor createValuePropertyDescriptor(IEntity source, IEntity property, int propertyIndex) {
		FeatureDescriptor propertyId = source.wGetFeatureDescriptor(propertyIndex);
		String propertyName = propertyId.getName();
		return createValuePropertyDescriptor(property, propertyName, propertyId);
	}

	private IPropertyDescriptor createValuePropertyDescriptor(IEntity property, String propertyName, Object propertyId) {
		EntityDescriptor<?> ed = property.wGetEntityDescriptor();
		switch (ed.getDataKind()) {
		case ENUM_VALUE:
			return new EnumValueDataPropertyDescriptor(propertyId, propertyName, ed);
		case BOOLEAN:
			return new BooleanDataPropertyDescriptor(propertyId, propertyName);
		case BYTE:
		case SHORT:
		case INT:
		case LONG:
		case FLOAT:
		case DOUBLE:
		case CHAR:
		case DATE:
		case STRING:
			return new DataPropertyDescriptor(propertyId, propertyName, ed);
		default:
			return new PropertyDescriptor(propertyId, propertyName);
		}
	}

	private IPropertyDescriptor[] createComplexPropertyDescriptor(IEntity source) {
		int size = source.wSize();
		List<IPropertyDescriptor> pd = new ArrayList<IPropertyDescriptor>(size);
		for(int i=0; i<size; i++) {
			IEntity property = source.wGet(i);
			if (!source.wGetEntityDescriptor().getEntityFeatureDescriptor(i).isReference())
				pd.add(EntityUtils.isData(property) ? 
					createValuePropertyDescriptor(source, property, i) :
					createDefaultPropertyDescriptor(source, property, i));
		}
		return pd.toArray(new IPropertyDescriptor[0]);
	}
}
