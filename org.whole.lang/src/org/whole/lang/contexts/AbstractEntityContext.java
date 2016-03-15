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
package org.whole.lang.contexts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.whole.lang.builders.IteratorAdapter;
import org.whole.lang.commands.ICommand;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityContext implements IEntityContext, InternalIEntity {
//	protected IModelIterator iterator = NullIterator.instance; //FIXME intensional iterators
	protected IEntity rootEntity;
	protected int rootIndex;
    protected IEntity entity;
    protected int index;
    protected int contextTime = Integer.MAX_VALUE;

    public AbstractEntityContext() {
    	wSetRoot(CommonsEntityFactory.instance.createRootFragment(CommonsEntityFactory.instance.createResolver()), 0);
    }
    public AbstractEntityContext(IEntity rootEntity) {
    	this(rootEntity, 0);
    }
    public AbstractEntityContext(IEntity rootEntity, int rootIndex) {
    	wSetRoot(rootEntity, rootIndex);
    }
    

    protected abstract IEntity entityContext(IEntity entity);

    public Object wGetAdapter(Class<?> adapter) {
    	if (adapter.equals(Iterator.class))
    		return new IteratorAdapter(this);
    	return null;
    }

    public boolean wIsAdapter() {
    	return wGetEntity().wIsAdapter();
    }
    public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
    	return wGetEntity().wGetAdapter(ed);
    }
    public IEntity wGetAdaptee(boolean force) {
    	return wGetEntity().wGetAdaptee(false);
    }

    public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
    	return wGetEntity().wResolveWith(ed);
    }

    public IEntity wGetEntity() {
        return entity;
    }
    public int wGetIndex() {
    	return index;
    }
    public void wSetEntity(IEntity entity) {
    	this.entity = entity;
    }
	protected void wSetEntity(IEntity entity, int index) {
		this.entity = entity;
		this.index = index;
	}
	public void wSetRoot(IEntity rootEntity, int rootIndex) {
		wSetEntity(this.rootEntity = rootEntity, this.rootIndex = rootIndex);
	}
	public void wResetRoot() {
		wSetEntity(this.rootEntity, this.rootIndex);
	}
	public IEntity wGetResult() {
		IEntity result = rootEntity.wGet(rootIndex);
		rootEntity.wRemove(rootIndex);
		return result;
    }

    public void setContextTime(int contextTime) {
        this.contextTime = contextTime;
        childrenCache.clear();
        entity = wGetVersion(entity, contextTime);
    }
    public void setContextTime(IEntityContext context) {
    	setContextTime(context.wGetBindingTime());
    }
    public void setContextTimeToEntityBindingTime() {
    	setContextTime(wGetBindingTime());
    }

    public int wGetBindingTime() {
        return wGetBindingCommand().getExecutionTime();
    }
    public IEntity wGetVersion(int bindingTime) {
		return entityContext(wGetVersion(entity, bindingTime));	
	}
	public IEntity wGetVersion(IEntityContext other) {
        return wGetVersion(other.wGetBindingTime());
	}
    public IEntity wGetPrevVersion() {
		return entityContext(wGetPrevVersion(entity));
    }
/*    public IEntity wGetLastVersion() {
        return resultContext(entity.wGetLastVersion());
    }
*/
    public void wUndo() {
    	entity.wGetModel().getCompoundModel().getHistoryManager().undo();
    }
    public void wRedo() {
    	entity.wGetModel().getCompoundModel().getHistoryManager().redo();
    }


	public ILanguageKit wGetLanguageKit() {
		return entity.wGetLanguageKit();
	}
    public IEditorKit wGetEditorKit() {
    	return entity.wGetEditorKit();
    }
    public EntityDescriptor<?> wGetEntityDescriptor() {
    	return entity.wGetEntityDescriptor();
    }
    public int wGetEntityOrd() {
    	return entity.wGetEntityOrd();
    }
    public EntityKinds wGetEntityKind() {
    	return entity.wGetEntityKind();
    }

	public Serializable wGetPid() {
    	return entity.wGetPid();
    }
    public void wSetPid(Serializable pid) {
    	((InternalIEntity) entity).wSetPid(pid);
    }

//	public int hashCode() {
//		return entity.hashCode();
//	}
//	public boolean equals(Object obj) {
//		return entity.equals(obj);
//	}
    public int wHashCode() {
    	return entity.wHashCode();
    }
    public boolean wEquals(IEntity entity) {
    	return entity.wEquals(entity);
    }
	
	public IEntity wGetRoot() {
		return entityContext(entity.wGetRoot());
	}
	public final IEntity wGetParent() {
		return entityContext(wGetParentIEntity());
	}
	public IEntity wGetParentIEntity() {
		return entity.wGetParent();
	}

	public void wSetParent(IEntity parent) {
		((InternalIEntity) entity).wSetParent(parent);
	}
	public void wRemoveParent(IEntity parent) {
		((InternalIEntity) entity).wRemoveParent(parent);
	}
	public void wAddInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) entity).wAddInverseAdjacent(inverseAdjacent);
	}
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) entity).wRemoveInverseAdjacent(inverseAdjacent);
	}
	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		return entity.wAdd(fd, value, forceUnique);
	}
	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		return entity.wRemove(fd, value);
	}
	

/*
	public IEntityContext wSetIterator(IModelIterator iterator) {
		this.iterator = iterator;
		return this;
	}*/
	
	public void wParent() {
		IEntity child = entity;
        entity = wGetParentIEntity();
        index = entity.wIndexOf(child);//wGetBindingCommand().getSourceIndex();
	}
	public void wParent(EntityDescriptor<?> ed) {
		IEntity entityInScope = entity;
		do {
			entityInScope = entityInScope.wGetParent();
		} while (entityInScope.wGetEntityDescriptor().equals(ed));
		
		entity = entityInScope;
		index = 0;
	}
	public void wChild() {
		entity = wGetIEntity(index);
		index = 0;
	}
	public void wFirstChild() {
		entity = wGetIEntity(0);
		index = 0;
	}
	public void wLastChild() {
		entity = wGetIEntity(wSize()-1);
		index = 0;
	}

	public boolean wHasNext() {
		return index < wSize();
//		return iterator.wHasNext();
	}
	public void wNext() {
		index++;
//	    wSetEntity(iterator.wNext());
	}
	public void wFeature(int index) {
		this.index = index;
	}
	public void wFeature(FeatureDescriptor feature) {
		index = wIndexOf(feature);
	}
	public void wPrune() {
//		iterator.wPrune();
	}


	public FeatureDescriptor wCurrentGetFeatureDescriptor() {
		return wGetFeatureDescriptor(index);
	}
	public EntityDescriptor<?> wCurrentGetEntityDescriptor() {
		return wGetEntityDescriptor(index);
	}
	public int wCurrentIndexOf() {
		return index;
	}
	public boolean wCurrentAdd(IEntity entity) {
		wAdd(index, entity);
		return true;
	}
	public void wCurrentRemove() {
		wRemove(index);
	}
	public IEntity wCurrentGet() {
		return wGet(index);
	}
	public void wCurrentSet(IEntity entity) {
		wSet(index, entity);
	}


	public int wIndexOf(IEntityContext value) {
		return wIndexOf(((AbstractEntityContext) value).wGetEntity());
	}
	public FeatureDescriptor wGetFeatureDescriptor(IEntityContext child) {
		return wGetFeatureDescriptor(((AbstractEntityContext) child).wGetEntity());
	}
	public void wSet(IEntityContext oldChild, IEntityContext newChild) {
		wSet(((AbstractEntityContext) oldChild).wGetEntity(), ((AbstractEntityContext) newChild).wGetEntity());
	}
	
	public boolean wContains(IEntity child) {
		return entity.wContains(child);
	}
	public int wIndexOf(IEntity value) {
		return entity.wIndexOf(value);
	}
	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		return entity.wGetFeatureDescriptor(child);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		return entity.wGetEntityDescriptor(child);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(int index) {
		return entity.wGetEntityDescriptor(index);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		return entity.wGetEntityDescriptor(fd);
	}

	public boolean wAdd(IEntity child) {
		return entity.wAdd(child);
	}
	public boolean wRemove(IEntity child) {
		return entity.wRemove(child);
	}
	public IEntity wGet(IEntity child) {
		return entity.wGet(child);
	}
	public boolean wSet(IEntity oldChild, IEntity newChild) {
		return entity.wSet(oldChild, newChild);
	}
    public boolean wIsSet(IEntity child) {
        return entity.wIsSet(child);
    }
    public void wUnset(IEntity child) {
    	entity.wUnset(child);
    }


    public boolean wIsEmpty() {
    	return entity.wIsEmpty();
    }
	public int wSize() {
	    return entity.wSize();
	}
	public int wAdjacentSize() {
	    return entity.wAdjacentSize();
	}
	public int wInverseAdjacentSize() {
	    return entity.wInverseAdjacentSize();
	}
	public Iterable<IEntity> wInverseAdjacents() {
	    return entity.wInverseAdjacents();
	}
	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
		return entity.wGetAspectualFeatureDescriptors();
	}

	public boolean wContains(int index) {
		return entity.wContains(index);
	}
	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		return entity.wGetFeatureDescriptor(index);
	}
	public void wAdd(int index, IEntityContext value) {
		wAdd(index, ((AbstractEntityContext) value).wGetEntity());
	}
	public boolean wAdd(int index, IEntity value) {
		return entity.wAdd(index, value);
	}
	public boolean wRemove(int index) {
		return entity.wRemove(index);
	}
	public final IEntity wGet(int index) {
		return entityContext(wGetIEntity(index));
	}
	protected IEntity wGetIEntity(int index) {
		return entity.wGet(index);
	}
	public void wSet(int index, IEntityContext value) {
		wSet(index, ((AbstractEntityContext) value).wGetEntity());
	}
	public void/*boolean*/ wSet(int index, IEntity value) {
		/*return*/ entity.wSet(index, value);        
	}
    public boolean wIsSet(int index) {
        return entity.wIsSet(index);
    }
    public void wUnset(int index) {
    	entity.wUnset(index);
    }
	


	public boolean wContains(FeatureDescriptor feature) {
		return entity.wContains(feature);
	}
	public int wIndexOf(FeatureDescriptor feature) {
		return entity.wIndexOf(feature);
	}
	public boolean wRemove(FeatureDescriptor feature) {
		return entity.wRemove(feature);
	}
	public IEntity wGet(FeatureDescriptor feature) {
		return entityContext(entity.wGet(entity.wIndexOf(feature)));
	}
	public void wSet(FeatureDescriptor feature, IEntityContext value) {
		wSet(feature, ((AbstractEntityContext) value).wGetEntity());
	}
	public void wSet(FeatureDescriptor feature, IEntity value) {
		entity.wSet(entity.wIndexOf(feature), value);
	}
	public boolean wIsSet(FeatureDescriptor feature) {
		return entity.wIsSet(feature);
	}
	public void wUnset(FeatureDescriptor feature) {
		entity.wUnset(feature);
	}

	public boolean wContainsValue(Object value) {
		return entity.wContainsValue(value);
	}

	public boolean wBooleanValue() {
		return entity.wBooleanValue();
	}
	public byte wByteValue() {
		return entity.wByteValue();
	}
	public char wCharValue() {
		return entity.wCharValue();
	}
	public double wDoubleValue() {
		return entity.wDoubleValue();
	}
	public float wFloatValue() {
		return entity.wFloatValue();
	}
	public int wIntValue() {
		return entity.wIntValue();
	}
	public long wLongValue() {
		return entity.wLongValue();
	}
	public short wShortValue() {
		return entity.wShortValue();
	}
	public String wStringValue() {
		return entity.wStringValue();
	}
	public Date wDateValue() {
		return entity.wDateValue();
	}
	public EnumValue wEnumValue() {
		return entity.wEnumValue();
	}
	public Object wGetValue() {
		return entity.wGetValue();
	}
	public void wSetValue(boolean value) {
		entity.wSetValue(value);
	}
	public void wSetValue(byte value) {
		entity.wSetValue(value);
	}
	public void wSetValue(char value) {
		entity.wSetValue(value);
	}
	public void wSetValue(double value) {
		entity.wSetValue(value);
	}
	public void wSetValue(float value) {
		entity.wSetValue(value);
	}
	public void wSetValue(int value) {
		entity.wSetValue(value);
	}
	public void wSetValue(long value) {
		entity.wSetValue(value);
	}
	public void wSetValue(short value) {
		entity.wSetValue(value);
	}
	public void wSetValue(String value) {
		entity.wSetValue(value);
	}
	public void wSetValue(Date value) {
		entity.wSetValue(value);
	}
	public void wSetValue(EnumValue value) {
		entity.wSetValue(value);
	}
	public void wSetValue(Object value) {
		entity.wSetValue(value);
	}
	public boolean wIsSet() {
		return entity.wIsSet();
	}
	public void wUnset() {
		entity.wUnset();
	}


	private Map<IEntity, List<IEntity>> childrenCache = new WeakHashMap<IEntity, List<IEntity>>();
	
	protected IEntity wGetVersion(IEntity e, int contextTime) {
		ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
		if (cmd.getKind().isComposite()) {
			List<IEntity> children = wIndexedFeatures(cmd.getSource(), contextTime);
			return children.get(cmd.getSourceIndex());
		} else
			return cmd.getCommand(contextTime).getNewEntity();
	}
	protected IEntity wGetPrevVersion(IEntity e) {
		ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
		if (cmd.getKind().isComposite()) {
			IEntity source = cmd.getSource();
			List<IEntity> children = wIndexedFeatures(source, ((InternalIEntity) source).wGetLastCommand().getPrevCommand().getExecutionTime());
			return children.get(cmd.getSourceIndex());
		} else
			return cmd.getPrevCommand().getNewEntity();
	}
	@Deprecated
	public List<IEntity> wIndexedFeatures(IEntity e, int contextTime) {
		List<IEntity> result = childrenCache.get(e);
		if (result != null && this.contextTime == contextTime)
			return result;
		result = new ArrayList<IEntity>(e.wFeatures());
		ICommand cmd = ((InternalIEntity) e).wGetLastCommand();
		while (contextTime < cmd.getExecutionTime()) {
	    	switch (cmd.getKind()) {
	    	case ADD:
    			result.remove(cmd.getSourceIndex());
	    		break;
    		case REMOVE:
	    		result.add(cmd.getSourceIndex(), cmd.getOldEntity());
    			break;
    		case CHANGE:
    			result.set(cmd.getSourceIndex(), cmd.getOldEntity());
    			break;
	    	}
	    	cmd = cmd.getPrevCommand();			
		}
		if (this.contextTime == contextTime)
			childrenCache.put(e, result);
		return result;
	}
	
	public IEntity wShallowClone() {
		return entityContext(((InternalIEntity) entity).wShallowClone());
	}

	public IFragmentModel wGetModel() {
		return entity.wGetModel();
	}

	public void wSetModel(IFragmentModel model) {
		((InternalIEntity) entity).wSetModel(model);
	}

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
		entity.wAddRequestEventHandler(eventHandler);
	}
	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
		entity.wRemoveRequestEventHandler(eventHandler);
	}
	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
		entity.wAddChangeEventHandler(eventHandler);
	}
	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
		entity.wRemoveChangeEventHandler(eventHandler);
	}

	@Deprecated
	public List<IEntity> wFeatures() {
		return entity.wFeatures();
	}

	public Set<IEntity> wGetSharingSet() {
		return entity.wGetSharingSet();
	}

	@Deprecated
	public void wAccept(GenericMatcher matcher, IEntity other) {
		entity.wAccept(matcher, other);
	}

	public ICommand wGetBindingCommand() {
		return ((InternalIEntity) entity).wGetBindingCommand();
	}

	public void wSetBindingCommand(ICommand command) {
		((InternalIEntity) entity).wSetBindingCommand(command);
	}

	public ICommand wGetLastCommand() {
		return ((InternalIEntity) entity).wGetBindingCommand();
	}

	public ICommand wSetLastCommand(ICommand command) {
		return ((InternalIEntity) entity).wSetLastCommand(command);
	}
}
