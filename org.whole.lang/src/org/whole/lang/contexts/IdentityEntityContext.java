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
import java.util.Collections;
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
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class IdentityEntityContext implements IEntityContext {

	public Object wGetAdapter(Class<?> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSetRoot(IEntity rootEntity, int rootIndex) {
		// TODO Auto-generated method stub
		
	}

	public IEntity wGetResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setContextTime(int contextTime) {
		// TODO Auto-generated method stub
		
	}

	public void setContextTime(IEntityContext context) {
		// TODO Auto-generated method stub
		
	}

	public void setContextTimeToEntityBindingTime() {
		// TODO Auto-generated method stub
		
	}

	public int wGetBindingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IEntity wGetPrevVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity wGetVersion(int contextTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity wGetVersion(IEntityContext other) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wUndo() {
		// TODO Auto-generated method stub
		
	}

	public void wRedo() {
		// TODO Auto-generated method stub
		
	}

	public void wParent() {
		// TODO Auto-generated method stub
		
	}

	public void wParent(EntityDescriptor<?> ed) {
		// TODO Auto-generated method stub
		
	}

	public void wChild() {
		// TODO Auto-generated method stub
		
	}

	public void wFirstChild() {
		// TODO Auto-generated method stub
		
	}

	public void wLastChild() {
		// TODO Auto-generated method stub
		
	}

	public boolean wHasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public void wNext() {
		// TODO Auto-generated method stub
		
	}

	public void wFeature(int index) {
		// TODO Auto-generated method stub
		
	}

	public void wFeature(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		
	}

	public void wPrune() {
		// TODO Auto-generated method stub
		
	}

	public FeatureDescriptor wCurrentGetFeatureDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityDescriptor<?> wCurrentGetEntityDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public int wCurrentIndexOf() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean wCurrentAdd(IEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wAdd(IEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wCurrentRemove() {
		// TODO Auto-generated method stub
		
	}

	public IEntity wCurrentGet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void wCurrentSet(IEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public int wIndexOf(IEntityContext value) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FeatureDescriptor wGetFeatureDescriptor(IEntityContext child) {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<?> wGetType(IEntityContext child) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wRemove(IEntityContext child, IEntityContext emptyReplacement) {
		// TODO Auto-generated method stub
		
	}

	public void wSet(IEntityContext oldChild, IEntityContext newChild) {
		// TODO Auto-generated method stub
		
	}

	public void wAdd(int index, IEntityContext value) {
		// TODO Auto-generated method stub
		
	}

	public void wSet(int index, IEntityContext value) {
		// TODO Auto-generated method stub
		
	}

	public void wSet(FeatureDescriptor feature, IEntityContext value) {
		// TODO Auto-generated method stub
		
	}

	public IEntity wShallowClone() {
		// TODO Auto-generated method stub
		return null;
	}

	public ILanguageKit wGetLanguageKit() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEditorKit wGetEditorKit() {
		// TODO Auto-generated method stub
		return null;
	}

	public int wGetEntityOrd() {
		// TODO Auto-generated method stub
		return 0;
	}

	public EntityDescriptor<?> wGetEntityDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityKinds wGetEntityKind() {
		// TODO Auto-generated method stub
		return null;
	}

	public IFragmentModel wGetModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSetModel(IFragmentModel model) {
		// TODO Auto-generated method stub
		
	}

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
		// TODO Auto-generated method stub
		
	}

	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
		// TODO Auto-generated method stub
		
	}

	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
		// TODO Auto-generated method stub
		
	}

	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
		// TODO Auto-generated method stub
		
	}

	public List<IEntity> wFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<IEntity> wGetSharingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable wGetPid() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPid(Serializable pid) {
		// TODO Auto-generated method stub
		
	}

	public int wHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean wEquals(IEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wAccept(GenericMatcher matcher, IEntity other) {
		// TODO Auto-generated method stub
		
	}

	public <E extends IEntity> E wGetAspect(EntityDescriptor<E> ed) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand wGetBindingCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSetBindingCommand(ICommand command) {
		// TODO Auto-generated method stub
		
	}

	public ICommand wGetLastCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand wSetLastCommand(ICommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity wGetRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity wGetParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean wContains(IEntity child) {
		// TODO Auto-generated method stub
		return false;
	}

	public int wIndexOf(IEntity child) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<?> wGetType(IEntity child) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean wRemove(IEntity child) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wRemove(IEntity child, IEntity emptyReplacement) {
		// TODO Auto-generated method stub
		
	}

	public IEntity wGet(IEntity child) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean wSet(IEntity child, IEntity newChild) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wIsSet(IEntity child) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wUnset(IEntity child) {
		// TODO Auto-generated method stub
		
	}

	public int wSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int wAdjacentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int wInverseAdjacentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterable<IEntity> wInverseAdjacents() {
		return Collections.<IEntity>emptyList();
	}

	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
		return Collections.emptySet();
	}

	public boolean wIsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wContains(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean wAdd(int index, IEntity child) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wRemove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public IEntity wGet(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSet(int index, IEntity child) {
		// TODO Auto-generated method stub
		
	}

	public boolean wIsSet(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wUnset(int index) {
		// TODO Auto-generated method stub
		
	}

	public boolean wContains(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public int wIndexOf(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void wAdd(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		
	}

	public boolean wRemove(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public IEntity wGet(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSet(FeatureDescriptor feature, IEntity value) {
		// TODO Auto-generated method stub
		
	}

	public boolean wIsSet(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public void wUnset(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		
	}

	public boolean wContainsValue(Object otherValue) {
		return false;
	}

	public boolean wBooleanValue() {
		// TODO Auto-generated method stub
		return false;
	}

	public byte wByteValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public char wCharValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double wDoubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float wFloatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int wIntValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long wLongValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public short wShortValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String wStringValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date wDateValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public EnumValue wEnumValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object wGetValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public void wSetValue(boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(byte value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(char value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(double value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(float value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(int value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(long value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(short value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(String value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(Date value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(EnumValue value) {
		// TODO Auto-generated method stub
		
	}

	public void wSetValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	public boolean wIsSet() {
		// TODO Auto-generated method stub
		return false;
	}

	public void wUnset() {
		// TODO Auto-generated method stub
		
	}

	public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
		// TODO Auto-generated method stub
		return null;
	}

	public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity wGetAdaptee(boolean force) {
		// TODO Auto-generated method stub
    	return null;
    }

	public boolean wIsAdapter() {
		// TODO Auto-generated method stub
		return false;
	}

	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityDescriptor<?> wGetEntityDescriptor(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		// TODO Auto-generated method stub
		return false;
	}

}
