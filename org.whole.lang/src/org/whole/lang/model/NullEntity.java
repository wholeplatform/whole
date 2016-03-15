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
package org.whole.lang.model;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.whole.lang.commands.ICommand;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityFeatureDescriptorImpl;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.WholeMessages;

public class NullEntity implements InternalIEntity, Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	public static final NullEntity instance = new NullEntity();
	public NullEntity() {
	}
	public Object readResolve() throws ObjectStreamException {
		return NullEntity.instance;
	}

	public Object clone() {
		return this;
	}

	public IEntity wShallowClone() {
		return this;
	}

	public void wSetParent(IEntity parent) {
	}
	public void wRemoveParent(IEntity parent) {
	}
	public void wAddInverseAdjacent(IEntity inverseAdjacent) {
	}
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent) {
	}
	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		return false;
	}
	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		return false;
	}

	public Serializable wGetPid() {
		return null;
	}
	public void wSetPid(Serializable pid) {
	}
	
	public ICommand wGetBindingCommand() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public ICommand wGetLastCommand() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetBindingCommand(ICommand command) {
		//throw new IllegalStateException(WholeMessages.null_model);
	}

	public ICommand wSetLastCommand(ICommand command) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetModel(IFragmentModel model) {
		//throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wAccept(GenericMatcher matcher, IEntity other) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wAdd(IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wAdd(int index, IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wAdd(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wBooleanValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public byte wByteValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public char wCharValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wContains(IEntity child) {
		if (child.wGetParent() == this)
			return true;

		return false;
	}

	public boolean wContains(int index) {
		return false;
	}

	public boolean wContains(FeatureDescriptor fd) {
		return false;
	}

	public boolean wContainsValue(Object value) {
		return false;
	}

	public Date wDateValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public double wDoubleValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public EnumValue wEnumValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wEquals(IEntity entity) {
		return entity.equals(this);
	}

	public List<IEntity> wFeatures() {
		List<IEntity> emptyList = Collections.emptyList();
		return emptyList;
	}

	public float wFloatValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public IEntity wGet(IEntity child) {
		if (child.wGetParent() == this)
			return child;

		throw new IllegalStateException(WholeMessages.null_model);
	}

	public IEntity wGet(int index) {
		throw new IndexOutOfBoundsException(WholeMessages.null_model);
	}

	public IEntity wGet(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public IEntity wGetAdaptee(boolean force) {
		return this;
	}

	public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
//    	if (ed.isAssignableFrom(wGetEntityDescriptor()))
//    		return (E) this;
//    	else
    		return CommonsEntityAdapterFactory.create(ed, this);
    	//throw new IllegalStateException(WholeMessages.null_model);
	}

	public <E extends IEntity> E wGetAspect(EntityDescriptor<E> ed) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
		throw new IllegalStateException(WholeMessages.null_model);		
	}

	public IEditorKit wGetEditorKit() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public EntityDescriptor<?> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Any;//TODO
	}

	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		if (child.wGetParent() == this)
			return CommonsEntityDescriptorEnum.Any;

		throw new WholeIllegalArgumentException(WholeMessages.null_model);
	}

	public EntityDescriptor<?> wGetEntityDescriptor(int index) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public EntityKinds wGetEntityKind() {
		return EntityKinds.SIMPLE;//WAS RESOLVER;
	}

	public int wGetEntityOrd() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		if (child.wGetParent() == this)
			return new EntityFeatureDescriptorImpl(
					wGetEntityDescriptor(), null, null, child.wGetEntityDescriptor(),
					false, false, false, false, false);

		throw new IllegalStateException(WholeMessages.null_model);
	}

	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public ILanguageKit wGetLanguageKit() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public IFragmentModel wGetModel() {
		return NullFragmentModel.instance;
	}

	public IEntity wGetParent() {
		return this;
	}

	public IEntity wGetRoot() {
		return NullEntity.instance;
	}

	public Set<IEntity> wGetSharingSet() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public Object wGetValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public int wHashCode() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public int wIndexOf(IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public int wIndexOf(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public int wIntValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wIsAdapter() {
		return false;
	}

	public boolean wIsEmpty() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wIsSet(IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wIsSet(int index) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wIsSet(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wIsSet() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public long wLongValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public boolean wRemove(IEntity child) {
		return false;
	}

	public boolean wRemove(int index) {
		return false;
	}

	public boolean wRemove(FeatureDescriptor fd) {
		return false;
	}

	public boolean wSet(IEntity child, IEntity newChild) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSet(int index, IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSet(FeatureDescriptor fd, IEntity value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(boolean value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(byte value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(char value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(double value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(float value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(int value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(long value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(short value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(String value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(Date value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(EnumValue value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wSetValue(Object value) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public short wShortValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public int wSize() {
		return 0;
	}
	public int wAdjacentSize() {
		return 0;
	}
	public int wInverseAdjacentSize() {
		return 0;
	}
	public Iterable<IEntity> wInverseAdjacents() {
		return Collections.<IEntity>emptyList();
	}
	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
		return Collections.emptySet();
	}

	public String wStringValue() {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wUnset(IEntity child) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wUnset(int index) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wUnset(FeatureDescriptor fd) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public void wUnset() {
		throw new IllegalStateException(WholeMessages.null_model);
	}
}
