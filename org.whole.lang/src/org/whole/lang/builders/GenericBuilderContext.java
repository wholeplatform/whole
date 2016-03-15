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

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.whole.lang.commands.ICommand;
import org.whole.lang.contexts.EntityContext;
import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.contexts.IdentityEntityContext;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericBuilderContext extends GenericForwardStrategyBuilder implements IBuilderContext, InternalIEntity {
    private Stack<IBuilder> builderStrategyStack = new Stack<IBuilder>();

    public GenericBuilderContext() {
    	this(new GenericIdentityBuilder(), new IdentityEntityContext());
    }
    public GenericBuilderContext(IBuilder strategy) {
    	this(strategy, new EntityContext());
    }
    public GenericBuilderContext(IBuilder strategy, IEntityContext entityContext) {
    	super(strategy);
    	wSetBuilderContext(this);
		wSetEntityContext(entityContext);
    }

	protected ModelBuilder createModelBuilder() {
		return new ModelBuilder(RegistryConfigurations.RESOLVER);
	}

	private EntityContext entityModelContext;
	private IBuilder entityModelBuilder;
	protected void wBuildEntity_(EntityDescriptor<?> ed) {
		if (entityModelContext == null)
			entityModelContext = new EntityContext();
		else
			entityModelContext.wResetRoot();

		if (entityModelBuilder == null) {
			entityModelBuilder = new GenericEntityScopeBuilder(
				new GenericBuilderContext(createModelBuilder(), entityModelContext));
			entityModelBuilder.wSetBuilderContext(this);
		}
		entityModelBuilder.wEntity_(ed);
	}
	protected IEntity _wBuildEntity(EntityDescriptor<?> ed) {
		return entityModelContext.wGetResult();
	}

    public void topDown() {
		if (wGetEntityKind().isData()) {
			switch (wGetEntityDescriptor().getDataKind()) {
			case BOOLEAN:
				wEntity(wGetEntityDescriptor(), wBooleanValue());
				break;
			case BYTE:
				wEntity(wGetEntityDescriptor(), wByteValue());
				break;
			case CHAR:
				wEntity(wGetEntityDescriptor(), wCharValue());
				break;
			case DOUBLE:
				wEntity(wGetEntityDescriptor(), wDoubleValue());
				break;
			case FLOAT:
				wEntity(wGetEntityDescriptor(), wFloatValue());
				break;
			case INT:
				wEntity(wGetEntityDescriptor(), wIntValue());
				break;
			case LONG:
				wEntity(wGetEntityDescriptor(), wLongValue());
				break;
			case SHORT:
				wEntity(wGetEntityDescriptor(), wShortValue());
				break;
			case STRING:
				wEntity(wGetEntityDescriptor(), wStringValue());
				break;
			case DATE:
				wEntity(wGetEntityDescriptor(), wDateValue());
				break;
			case ENUM_VALUE:
				wEntity(wGetEntityDescriptor(), wEnumValue());
				break;
			case OBJECT:
				wEntity(wGetEntityDescriptor(), wGetValue());
				break;
			}
		} else if (wIsEmpty())
			wEntity(wGetEntityDescriptor());
		else {
			switch (wGetEntityKind()) {
			case COMPOSITE:
				wEntity_(wGetEntityDescriptor(), wSize());
				break;
			default://case EntityKindEnum.Entity:
				wEntity_(wGetEntityDescriptor());
				break;
			}
			while (wHasNext())
				topDown();
			_wEntity(wGetEntityDescriptor());
			
		}
    }
    
    
	public void wPushBuilderStrategy(IBuilder strategy) {
		builderStrategyStack.push(builderStrategy);
		super.wSetBuilderStrategy(strategy);
	}
	public void wPopBuilderStrategy() {
		super.wSetBuilderStrategy(builderStrategyStack.pop());
	}

    public boolean wIsAdapter() {
    	return entityContext.wIsAdapter();
    }
    public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
    	return entityContext.wGetAdapter(ed);
    }
    public IEntity wGetAdaptee(boolean force) {
    	return entityContext.wGetAdaptee(false);
    }

    public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
    	return entityContext.wResolveWith(ed);
    }

	public void wSetRoot(IEntity rootEntity, int rootIndex) {
		entityContext.wSetRoot(rootEntity, rootIndex);
	}
	public IEntity wGetResult() {
        return entityContext.wGetResult();
    }

	public void wDefault() {
        builderStrategy.wDefault();
        wNext();
    }
    public void wEntity() {
        builderStrategy.wEntity();
    	wNext();
    }
    public void wEntity_() {
        builderStrategy.wEntity_();
    	wChild();
    }
    public void _wEntity() {
        builderStrategy._wEntity();
		wParent();
    	wNext();
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        builderStrategy.wEntity(entityDesc);
    	wNext();
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
        builderStrategy.wEntity_(entityDesc);
    	wChild();
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        builderStrategy.wEntity_(entityDesc, initialCapacity);
    	wChild();
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
        builderStrategy._wEntity(entityDesc);
		wParent();
    	wNext();
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		DataKinds dataKind = entityDesc.getDataKind();
		//FIXME workaround move responsibility into generated spec builder adapters
		if (dataKind.isString())
			builderStrategy.wEntity(entityDesc, value);
		else {
			IDataTypeParser dataTypeParser = DataTypeUtils.getDataTypeParser(entityDesc, DataTypeParsers.PERSISTENCE);
			switch (dataKind) {
			case DATE:
				builderStrategy.wEntity(entityDesc, dataTypeParser.parseDate(entityDesc, value));
				break;
			case ENUM_VALUE:
				builderStrategy.wEntity(entityDesc, dataTypeParser.parseEnumValue(entityDesc, value));
				break;
			case OBJECT:
				builderStrategy.wEntity(entityDesc, dataTypeParser.parseObject(entityDesc, value));
				break;
			}
		}
		wNext();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
        builderStrategy.wEntity(entityDesc, value);
        wNext();
    }


	public void setContextTime(IEntityContext context) {
		entityContext.setContextTime(context);
	}
	public void setContextTime(int contextTime) {
		entityContext.setContextTime(contextTime);
	}
	public void setContextTimeToEntityBindingTime() {
		entityContext.setContextTimeToEntityBindingTime();
	}
	@Deprecated
	public void wAccept(GenericMatcher matcher, IEntity other) {
		entityContext.wAccept(matcher, other);
	}
	public boolean wCurrentAdd(IEntity entity) {
		return entityContext.wCurrentAdd(entity);
	}
	public boolean wAdd(IEntity entity) {
		return entityContext.wAdd(entity);
	}
	public boolean wAdd(int index, IEntity child) {
		return entityContext.wAdd(index, child);
	}
	public void wAdd(int index, IEntityContext value) {
		entityContext.wAdd(index, value);
	}
	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
		entityContext.wAddRequestEventHandler(eventHandler);
	}
	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
		entityContext.wRemoveRequestEventHandler(eventHandler);
	}
	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
		entityContext.wAddChangeEventHandler(eventHandler);
	}
	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
		entityContext.wRemoveChangeEventHandler(eventHandler);
	}
	public boolean wBooleanValue() {
		return entityContext.wBooleanValue();
	}
	public byte wByteValue() {
		return entityContext.wByteValue();
	}
	public char wCharValue() {
		return entityContext.wCharValue();
	}
	public Date wDateValue() {
		return entityContext.wDateValue();
	}
	public EnumValue wEnumValue() {
		return entityContext.wEnumValue();
	}
	public void wChild() {
		entityContext.wChild();
	}
	
	public Serializable wGetPid() {
    	return entityContext.wGetPid();
    }
    public void wSetPid(Serializable pid) {
    	((InternalIEntity) entityContext).wSetPid(pid);
    }
    public int wHashCode() {
    	return entityContext.wHashCode();
    }
    public boolean wEquals(IEntity entity) {
    	return entityContext.wEquals(entity);
    }
	public boolean wContains(int index) {
		return entityContext.wContains(index);
	}
	public boolean wContains(IEntity child) {
		return entityContext.wContains(child);
	}
	public double wDoubleValue() {
		return entityContext.wDoubleValue();
	}
	public void wFeature(FeatureDescriptor feature) {
		builderStrategy.wFeature(feature);
		entityContext.wFeature(feature);
	}
	public void wFeature(int index) {
		builderStrategy.wFeature(index);
		entityContext.wFeature(index);
	}
	@Deprecated
	public List<IEntity> wFeatures() {
		return entityContext.wFeatures();
	}
	public void wFirstChild() {
		entityContext.wFirstChild();
	}
	public float wFloatValue() {
		return entityContext.wFloatValue();
	}
	public IEntity wCurrentGet() {
		return entityContext.wCurrentGet();
	}
	public IEntity wGet(FeatureDescriptor feature) {
		return entityContext.wGet(feature);
	}
	public IEntity wGet(IEntity child) {
		return entityContext.wGet(child);
	}
	public IEntity wGet(int index) {
		return entityContext.wGet(index);
	}
	public Object wGetAdapter(Class<?> adapter) {
		return entityContext.wGetAdapter(adapter);
	}
	
	public ICommand wGetBindingCommand() {
		return ((InternalIEntity) entityContext).wGetBindingCommand();
	}
	public int wGetBindingTime() {
		return entityContext.wGetBindingTime();
	}
	public FeatureDescriptor wCurrentGetFeatureDescriptor() {
		return entityContext.wCurrentGetFeatureDescriptor();
	}
	public EntityDescriptor<?> wCurrentGetEntityDescriptor() {
		return entityContext.wCurrentGetEntityDescriptor();
	}
	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		return entityContext.wGetFeatureDescriptor(child);
	}
	public FeatureDescriptor wGetFeatureDescriptor(IEntityContext child) {
		return entityContext.wGetFeatureDescriptor(child);
	}
	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		return entityContext.wGetFeatureDescriptor(index);
	}
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return entityContext.wGetEntityDescriptor();
	}
	public EntityKinds wGetEntityKind() {
		return entityContext.wGetEntityKind();
	}
	public int wGetEntityOrd() {
		return entityContext.wGetEntityOrd();
	}
	public ILanguageKit wGetLanguageKit() {
		return entityContext.wGetLanguageKit();
	}
	public IEditorKit wGetEditorKit() {
		return entityContext.wGetEditorKit();
	}
	public ICommand wGetLastCommand() {
		return ((InternalIEntity) entityContext).wGetLastCommand();
	}
	public IFragmentModel wGetModel() {
		return entityContext.wGetModel();
	}
	public IEntity wGetParent() {
		return entityContext.wGetParent();
	}
	public void wSetParent(IEntity parent) {
		((InternalIEntity) entityContext).wSetParent(parent);
	}
	public void wRemoveParent(IEntity parent) {
		((InternalIEntity) entityContext).wRemoveParent(parent);
	}
	public void wAddInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) entityContext).wAddInverseAdjacent(inverseAdjacent);
	}
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) entityContext).wRemoveInverseAdjacent(inverseAdjacent);
	}
	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		return entityContext.wAdd(fd, value, forceUnique);
	}
	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		return entityContext.wRemove(fd, value);
	}

	public IEntity wGetPrevVersion() {
		return entityContext.wGetPrevVersion();
	}
	public IEntity wGetRoot() {
		return entityContext.wGetRoot();
	}
	public Set<IEntity> wGetSharingSet() {
		return entityContext.wGetSharingSet();
	}
	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		return entityContext.wGetEntityDescriptor(child);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(int index) {
		return entityContext.wGetEntityDescriptor(index);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		return entityContext.wGetEntityDescriptor(fd);
	}
	public Object wGetValue() {
		return entityContext.wGetValue();
	}
	public IEntity wGetVersion(IEntityContext other) {
		return entityContext.wGetVersion(other);
	}
	public IEntity wGetVersion(int contextTime) {
		return entityContext.wGetVersion(contextTime);
	}
	public boolean wContains(FeatureDescriptor feature) {
		return entityContext.wContains(feature);
	}
	public boolean wHasNext() {
		return entityContext.wHasNext();
	}
	public int wCurrentIndexOf() {
		return entityContext.wCurrentIndexOf();
	}
	public int wIndexOf(FeatureDescriptor feature) {
		return entityContext.wIndexOf(feature);
	}
	public int wIndexOf(IEntity child) {
		return entityContext.wIndexOf(child);
	}
	public int wIndexOf(IEntityContext value) {
		return entityContext.wIndexOf(value);
	}
	public int wIntValue() {
		return entityContext.wIntValue();
	}
	public boolean wIsEmpty() {
		return entityContext.wIsEmpty();
	}
	public boolean wIsSet(FeatureDescriptor feature) {
		return entityContext.wIsSet(feature);
	}
	public void wLastChild() {
		entityContext.wLastChild();
	}
	public long wLongValue() {
		return entityContext.wLongValue();
	}
	public void wNext() {
		entityContext.wNext();
	}
	public void wParent() {
		entityContext.wParent();
	}
	public void wParent(EntityDescriptor<?> ed) {
		entityContext.wParent(ed);
	}
	public void wPrune() {
		entityContext.wPrune();
	}
	public void wRedo() {
		entityContext.wRedo();
	}
	public void wCurrentRemove() {
		entityContext.wCurrentRemove();
	}
	public boolean wRemove(FeatureDescriptor feature) {
		return entityContext.wRemove(feature);
	}
	public boolean wRemove(IEntity child) {
		return entityContext.wRemove(child);
	}
	public boolean wRemove(int index) {
		return entityContext.wRemove(index);
	}
	public boolean wSet(IEntity oldChild, IEntity newChild) {
		return entityContext.wSet(oldChild, newChild);
	}
	public void wSet(IEntityContext oldChild, IEntityContext newChild) {
		entityContext.wSet(oldChild, newChild);
	}
	public void wSet(FeatureDescriptor feature, IEntity value) {
		entityContext.wSet(feature, value);
	}
	public void wSet(FeatureDescriptor feature, IEntityContext value) {
		entityContext.wSet(feature, value);
	}
	public void wCurrentSet(IEntity entity) {
		entityContext.wCurrentSet(entity);
	}
	public void/*boolean*/ wSet(int index, IEntity child) {
		/*return*/ entityContext.wSet(index, child);
	}
	public void wSet(int index, IEntityContext value) {
		entityContext.wSet(index, value);
	}
	public void wSetBindingCommand(ICommand command) {
		((InternalIEntity) entityContext).wSetBindingCommand(command);
	}
	public ICommand wSetLastCommand(ICommand command) {
		return ((InternalIEntity) entityContext).wSetLastCommand(command);
	}
	public void wSetModel(IFragmentModel model) {
		((InternalIEntity) entityContext).wSetModel(model);
	}

	public boolean wContainsValue(Object value) {
		return entityContext.wContainsValue(value);
	}

	public void wSetValue(boolean value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(byte value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(char value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(double value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(float value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(int value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(long value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(Object value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(short value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(String value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(Date value) {
		entityContext.wSetValue(value);
	}
	public void wSetValue(EnumValue value) {
		entityContext.wSetValue(value);
	}
	public IEntity wShallowClone() {
		return ((InternalIEntity) entityContext).wShallowClone();
	}
	public short wShortValue() {
		return entityContext.wShortValue();
	}
	public int wSize() {
		return entityContext.wSize();
	}
	public int wAdjacentSize() {
		return entityContext.wAdjacentSize();
	}
	public int wInverseAdjacentSize() {
		return entityContext.wInverseAdjacentSize();
	}
	public Iterable<IEntity> wInverseAdjacents() {
		return entityContext.wInverseAdjacents();
	}
	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
		return entityContext.wGetAspectualFeatureDescriptors();
	}
	public String wStringValue() {
		return entityContext.wStringValue();
	}
	public void wUndo() {
		entityContext.wUndo();
	}
    public boolean wIsSet(IEntity child) {
        return entityContext.wIsSet(child);
    }
    public void wUnset(IEntity child) {
    	entityContext.wUnset(child);
    }

    public boolean wIsSet(int index) {
        return entityContext.wIsSet(index);
    }
    public void wUnset(int index) {
    	entityContext.wUnset(index);
    }

	public void wUnset(FeatureDescriptor feature) {
		entityContext.wUnset(feature);
	}
	public boolean wIsSet() {
		return entityContext.wIsSet();
	}
	public void wUnset() {
		entityContext.wUnset();
	}

}
