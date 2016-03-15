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
package org.whole.lang.model.adapters;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.whole.lang.commands.ICommand;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractEntityAdapter /*extends AbstractEntity*/ implements IEntityAdapter, InternalIEntity, Serializable, Cloneable {
	private IEntity adaptee;

	public AbstractEntityAdapter() {
		this(NullEntity.instance);//create(CommonsEntityDescriptorEnum.Any);
	}
	public AbstractEntityAdapter(IEntity adaptee) {
		wSetAdaptee(adaptee);
	}

	public IEntity wShallowClone() {
		try {
			IEntityAdapter result = (IEntityAdapter) super.clone();//super.wShallowClone();
			result.wSetAdaptee(((InternalIEntity) wGetAdaptee(false)).wShallowClone());
			return result;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

    public int wGetEntityOrd() {
    	return wGetEntityDescriptor().getOrdinal();
    }

	public void wAccept(GenericMatcher matcher, IEntity other) {
		matcher.match(this, other);
//		wGetAdaptee().wAccept(matcher, other);
	}

	public void wSetModel(IFragmentModel model) {
		((InternalIEntity) wGetAdaptee(false)).wSetModel(model);
	}
//    protected void wSetChildrenModel(IFragmentModel model) {
//    	((InternalIEntity) wGetAdaptee(false)).wSetModel(model);
//    }

    public boolean wIsAdapter() {
    	return true;
    }
    @SuppressWarnings("unchecked")
	public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
    	if (ed.isLanguageSupertypeOf(wGetEntityDescriptor()))
    		return (E) this;
    	else
    		return wGetAdaptee(false).wGetAdapter(ed);
    }

	public final IEntity wGetAdaptee(boolean force) {
		return adaptee;
	}
	public void wSetAdaptee(IEntity adaptee) {
		this.adaptee = adaptee;
	}

	protected FeatureDescriptor wGetAdapteeFeatureDescriptor(FeatureDescriptor fd) {
		//TODO remove when facade adapters are supported
		if (EntityUtils.isResolver(adaptee))
			return fd;

		ILanguageKit adapteeLanguageKit = adaptee.wGetLanguageKit();
		return fd.getLanguageKit().equals(adapteeLanguageKit) ?
				fd : adapteeLanguageKit.getFeatureDescriptorEnum().valueOf(fd.getName());
	}

	public boolean wContains(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
		return adapteeFeatureDescriptor == null ?
				false : wGetAdaptee(false).wContains(adapteeFeatureDescriptor);
	}

	public int wIndexOf(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
		return adapteeFeatureDescriptor == null ?
				-1 : wGetAdaptee(false).wIndexOf(adapteeFeatureDescriptor);
	}

	public boolean wRemove(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
		return adapteeFeatureDescriptor == null ?
				false : wGetAdaptee(false).wRemove(adapteeFeatureDescriptor);
	}

	public IEntity wGet(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
//		if (adapteeFeatureDescriptor == null)
//			throw new IllegalArgumentException("The feature: "+fd+" is not supported by the adaptee: "+adaptee.wGetEntityDescriptor());

		return wGetAdaptee(false).wGet(adapteeFeatureDescriptor == null ? fd : adapteeFeatureDescriptor);
	}

	public void wSet(FeatureDescriptor fd, IEntity value) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
//		if (adapteeFeatureDescriptor == null)
//			throw new IllegalArgumentException("The feature: "+fd+" is not supported by the adaptee: "+adaptee.wGetEntityDescriptor());

		wGetAdaptee(false).wSet(adapteeFeatureDescriptor == null ? fd : adapteeFeatureDescriptor, value);
	}

	public boolean wIsSet(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
		return adapteeFeatureDescriptor == null ?
				false : wGetAdaptee(false).wIsSet(adapteeFeatureDescriptor);
	}

	public void wUnset(FeatureDescriptor fd) {
		FeatureDescriptor adapteeFeatureDescriptor = wGetAdapteeFeatureDescriptor(fd);
		if (adapteeFeatureDescriptor != null)
			wGetAdaptee(false).wUnset(adapteeFeatureDescriptor);
	}


	public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
		return wGetAdaptee(false).wResolveWith(ed);
	}

	public void wSetParent(IEntity parent) {
		((InternalIEntity) wGetAdaptee(false)).wSetParent(parent);
	}
	public void wRemoveParent(IEntity parent) {
		((InternalIEntity) wGetAdaptee(false)).wRemoveParent(parent);
	}
	public void wAddInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) wGetAdaptee(false)).wAddInverseAdjacent(inverseAdjacent);
	}
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent) {
		((InternalIEntity) wGetAdaptee(false)).wRemoveInverseAdjacent(inverseAdjacent);
	}
	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		return wGetAdaptee(false).wAdd(fd, value, forceUnique);
	}
	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		return wGetAdaptee(false).wRemove(fd, value);
	}

	public ILanguageKit wGetLanguageKit() {
		return wGetAdaptee(false).wGetLanguageKit();
	}
	public IEditorKit wGetEditorKit() {
		return wGetAdaptee(false).wGetEditorKit();
	}

	public EntityKinds wGetEntityKind() {
		return wGetAdaptee(false).wGetEntityKind();
	}

	public IFragmentModel wGetModel() {
		return wGetAdaptee(false).wGetModel();
	}


	public Serializable wGetPid() {
		return wGetAdaptee(false).wGetPid();
	}

	public boolean wAdd(IEntity child) {
		return wGetAdaptee(false).wAdd(child);
	}

	public boolean wAdd(int index, IEntity child) {
		return wGetAdaptee(false).wAdd(index, child);
	}

	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
		wGetAdaptee(false).wAddChangeEventHandler(eventHandler);
	}

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
		wGetAdaptee(false).wAddRequestEventHandler(eventHandler);
	}

	public boolean wBooleanValue() {
		return wGetAdaptee(false).wBooleanValue();
	}

	public byte wByteValue() {
		return wGetAdaptee(false).wByteValue();
	}

	public char wCharValue() {
		return wGetAdaptee(false).wCharValue();
	}

	public boolean wContains(IEntity child) {
		return wGetAdaptee(false).wContains(child);
	}

	public boolean wContains(int index) {
		return wGetAdaptee(false).wContains(index);
	}

	public boolean wContainsValue(Object value) {
		return wGetAdaptee(false).wContainsValue(value);
	}

	public Date wDateValue() {
		return wGetAdaptee(false).wDateValue();
	}

	public double wDoubleValue() {
		return wGetAdaptee(false).wDoubleValue();
	}

	public EnumValue wEnumValue() {
		return wGetAdaptee(false).wEnumValue();
	}

	public boolean wEquals(IEntity entity) {
		return wGetAdaptee(false).wEquals(entity);
	}

	@Deprecated
	public List<IEntity> wFeatures() {
		return wGetAdaptee(false).wFeatures();
	}

	public float wFloatValue() {
		return wGetAdaptee(false).wFloatValue();
	}

	public IEntity wGet(IEntity child) {
		return wGetAdaptee(false).wGet(child);
	}

	public IEntity wGet(int index) {
		return wGetAdaptee(false).wGet(index);
	}

	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		return wGetAdaptee(false).wGetFeatureDescriptor(child);
	}

	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		return wGetAdaptee(false).wGetFeatureDescriptor(index);
	}

	public IEntity wGetParent() {
		return wGetAdaptee(false).wGetParent();
	}

	public IEntity wGetRoot() {
		return wGetAdaptee(false).wGetRoot();
	}

	public Set<IEntity> wGetSharingSet() {
		return wGetAdaptee(false).wGetSharingSet();
	}

	public Object wGetValue() {
		return wGetAdaptee(false).wGetValue();
	}

	public int wHashCode() {
		return wGetAdaptee(false).wHashCode();
	}

	public int wIndexOf(IEntity child) {
		return wGetAdaptee(false).wIndexOf(child);
	}

	public int wIntValue() {
		return wGetAdaptee(false).wIntValue();
	}

	public boolean wIsEmpty() {
		return wGetAdaptee(false).wIsEmpty();
	}

	public boolean wIsSet() {
		return wGetAdaptee(false).wIsSet();
	}

	public boolean wIsSet(IEntity child) {
		return wGetAdaptee(false).wIsSet(child);
	}

	public boolean wIsSet(int index) {
		return wGetAdaptee(false).wIsSet(index);
	}

	public long wLongValue() {
		return wGetAdaptee(false).wLongValue();
	}

	public boolean wRemove(IEntity child) {
		return wGetAdaptee(false).wRemove(child);
	}

	public boolean wRemove(int index) {
		return wGetAdaptee(false).wRemove(index);
	}

	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
		wGetAdaptee(false).wRemoveChangeEventHandler(eventHandler);
	}

	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
		wGetAdaptee(false).wRemoveRequestEventHandler(eventHandler);
	}

	public boolean wSet(IEntity child, IEntity newChild) {
		return wGetAdaptee(false).wSet(child, newChild);
	}

	public void wSet(int index, IEntity child) {
		wGetAdaptee(false).wSet(index, child);
	}

	public void wSetValue(boolean value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(byte value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(char value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(Date value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(double value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(EnumValue value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(float value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(int value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(long value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(Object value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(short value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public void wSetValue(String value) {
		wGetAdaptee(false).wSetValue(value);
	}

	public short wShortValue() {
		return wGetAdaptee(false).wShortValue();
	}

	public int wSize() {
		return wGetAdaptee(false).wSize();
	}

	public String wStringValue() {
		return wGetAdaptee(false).wStringValue();
	}

	public void wUnset() {
		wGetAdaptee(false).wUnset();
	}

	public void wUnset(IEntity child) {
		wGetAdaptee(false).wUnset(child);
	}

	public void wUnset(int index) {
		wGetAdaptee(false).wUnset(index);
	}

    @Override
    public String toString() {
    	return wGetAdaptee(false).toString();
    }

	public int wAdjacentSize() {
		return wGetAdaptee(false).wAdjacentSize();
	}
	
	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
		return wGetAdaptee(false).wGetAspectualFeatureDescriptors();
	}

	public EntityDescriptor<?> wGetEntityDescriptor(int index) {
		return wGetAdaptee(false).wGetEntityDescriptor(index);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		return wGetAdaptee(false).wGetEntityDescriptor(fd);
	}
	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		return wGetAdaptee(false).wGetEntityDescriptor(child);
	}

	public Iterable<IEntity> wInverseAdjacents() {
		return wGetAdaptee(false).wInverseAdjacents();
	}
	public int wInverseAdjacentSize() {
		return wGetAdaptee(false).wInverseAdjacentSize();
	}
	public ICommand wGetBindingCommand() {
		return ((InternalIEntity) wGetAdaptee(false)).wGetBindingCommand();
	}
	public ICommand wGetLastCommand() {
		return ((InternalIEntity) wGetAdaptee(false)).wGetLastCommand();
	}
	public void wSetBindingCommand(ICommand command) {
		((InternalIEntity) wGetAdaptee(false)).wSetBindingCommand(command);
	}
	public ICommand wSetLastCommand(ICommand command) {
		return ((InternalIEntity) wGetAdaptee(false)).wSetLastCommand(command);
	}
	public void wSetPid(Serializable pid) {
		((InternalIEntity) wGetAdaptee(false)).wSetPid(pid);
	}
}
