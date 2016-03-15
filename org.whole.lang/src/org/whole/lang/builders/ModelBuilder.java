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
package org.whole.lang.builders;

import java.util.Date;

import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ModelBuilder extends AbstractBuilder {
	private final IEntityFactory entityFactory;
	private final IEntityFactory resolverEntityFactory;
	
	public ModelBuilder() {
		this(RegistryConfigurations.DEFAULT);
	}
	public ModelBuilder(IEntityRegistryProvider provider) {
		entityFactory = GenericEntityFactory.instance(provider);
		resolverEntityFactory = GenericEntityFactory.instance(RegistryConfigurations.RESOLVER);
	}
	public ModelBuilder(IEntityContext entityContext) {
		this(entityContext, RegistryConfigurations.DEFAULT);
	}
	public ModelBuilder(IEntityContext entityContext, IEntityRegistryProvider provider) {
		this(provider);
		wSetEntityContext(entityContext);
	}

	public void wFeature(int index) {
		entityContext.wFeature(index);
	}
	public void wFeature(FeatureDescriptor feature) {
		entityContext.wFeature(feature);
	}
	public void wFeature(ITemplate pattern) {
		//TODO
	}

	protected IEntity wClonePrototype() {
		return entityFactory.create(entityContext.wCurrentGetEntityDescriptor());
	}
	protected <T extends IEntity> T wClone(EntityDescriptor<T> entityDesc) {
		return entityFactory.create(entityDesc);
	}
	protected <T extends IEntity> T wShallowClone(EntityDescriptor<T> entityDesc) {
		return entityFactory.shallowClone(entityDesc);
	}
	protected IEntity wCloneFeature(EntityDescriptor<?> entityDesc) {
		return entityFactory.cloneFeature(
				entityDesc, entityContext.wCurrentIndexOf());
	}
	protected IEntity wCloneFeature() {
		return wCloneFeature(entityContext.wGetAdaptee(false).wGetEntityDescriptor());
	}


	public void wDefault() {
		if (entityContext.wHasNext())
			entityContext.wCurrentSet(wCloneFeature());
		else
			entityContext.wCurrentSet(wClonePrototype());
    }
    public void wEntity() {
    	entityContext.wCurrentSet(wClonePrototype());
    }
    public void wEntity_() {
    	entityContext.wCurrentSet(wClonePrototype());
    }
    public void _wEntity() {
    	_wEntity(entityContext.wGetEntityDescriptor());
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
    	entityContext.wCurrentSet(wClone(entityDesc));
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
    	entityContext.wCurrentSet(wShallowClone(entityDesc));
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
//        wEntity_(entityDesc);
    	entityContext.wCurrentSet(resolverEntityFactory.shallowClone(entityDesc));
        //TODO ensureCapacity
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    	if (EntityUtils.isSimple(entityDesc)) {
	    	IEntity prototype = entityFactory.getEntityRegistry(entityDesc).get(entityDesc);
	    	int index = 0;
	    	entityContext.wFeature(0);
			while (entityContext.wHasNext()) {
				if (entityContext.wCurrentGet() == prototype.wGet(index++))
					entityContext.wCurrentSet(wCloneFeature(entityDesc));
				entityContext.wNext();
			}
    	} else
			while (entityContext.wHasNext()) {
				entityContext.wCurrentSet(wCloneFeature());
				entityContext.wNext();
			}
   }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
//TODO moved responsibility to GenericBuilderContext
//	    if (entityDesc.getDataKind().isString())
	    	valueEntity.wSetValue(value);
//	    else
//	    	DataTypeUtils.setFromPersistenceString(valueEntity, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
	    IEntity valueEntity = wClone(entityDesc);
	    entityContext.wCurrentSet(valueEntity);
	    valueEntity.wSetValue(value);
    }
}
