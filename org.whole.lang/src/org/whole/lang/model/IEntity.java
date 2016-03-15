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

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public interface IEntity {
    public ILanguageKit wGetLanguageKit();
    public IEditorKit wGetEditorKit();
    public int wGetEntityOrd();
	public EntityDescriptor<?> wGetEntityDescriptor();
    public EntityKinds wGetEntityKind();
    
    public boolean wIsAdapter();
    public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed);
	public IEntity wGetAdaptee(boolean force);
	public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed);

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler);
	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler);
	public void wAddChangeEventHandler(IChangeEventHandler eventHandler);
	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler);


	public Serializable wGetPid();
	public int wHashCode();
    public boolean wEquals(IEntity entity);
    public void wAccept(GenericMatcher matcher, IEntity other); //TODO remove


	public boolean wIsEmpty();
	public int wSize(); //number of children values (domain features only)
	public int wAdjacentSize(); //number of adjacent values (domain features only)
	public int wInverseAdjacentSize();
	public Iterable<IEntity> wInverseAdjacents();
	public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors();
	@Deprecated
	public List<IEntity> wFeatures();
	public Set<IEntity> wGetSharingSet();


//	** containment features methods **

	public IFragmentModel wGetModel();
    public IEntity wGetRoot();
	public IEntity wGetParent();


//	** by index features methods **

	public boolean wContains(int index);
	public FeatureDescriptor wGetFeatureDescriptor(int index);
	public EntityDescriptor<?> wGetEntityDescriptor(int index);
	public boolean wAdd(int index, IEntity child);
	public boolean wRemove(int index);
	public IEntity wGet(int index);
	public void wSet(int index, IEntity child); //TODO boolean result or old value
	public boolean wIsSet(int index);
	public void wUnset(int index);


//	** by name (descriptor) features methods **

	public boolean wContains(FeatureDescriptor fd);
	public EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd);
	public int wIndexOf(FeatureDescriptor fd);
	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique);
	public boolean wRemove(FeatureDescriptor fd, IEntity value);
	public boolean wRemove(FeatureDescriptor fd);
	public IEntity wGet(FeatureDescriptor fd);
	public void wSet(FeatureDescriptor fd, IEntity value);
	public boolean wIsSet(FeatureDescriptor fd);
	public void wUnset(FeatureDescriptor fd);


//	** by child/adjacent value features methods **

	public boolean wContains(IEntity child);
	public int wIndexOf(IEntity child);
	public FeatureDescriptor wGetFeatureDescriptor(IEntity child);
	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child);
	public boolean wAdd(IEntity child);
	public boolean wRemove(IEntity child);
	public IEntity wGet(IEntity child);
	public boolean wSet(IEntity child, IEntity newChild);
	public boolean wIsSet(IEntity child);
	public void wUnset(IEntity child);

	
//	** by data value features methods **

	public boolean wContainsValue(Object value);
	public boolean wBooleanValue();
	public byte wByteValue();
	public char wCharValue();
	public double wDoubleValue();
	public float wFloatValue();
	public int wIntValue();
	public long wLongValue();
	public short wShortValue();
	public String wStringValue();
	public Date wDateValue();
	public EnumValue wEnumValue();
	public Object wGetValue();
	public void wSetValue(boolean value);
	public void wSetValue(byte value);
	public void wSetValue(char value);
	public void wSetValue(double value);
	public void wSetValue(float value);
	public void wSetValue(int value);
	public void wSetValue(long value);
	public void wSetValue(short value);
	public void wSetValue(String value);
	public void wSetValue(Date value);
	public void wSetValue(EnumValue value);
	public void wSetValue(Object value);
	public boolean wIsSet();
	public void wUnset();
}
