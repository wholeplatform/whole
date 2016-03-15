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

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;


/**
 * @author Riccardo Solmi
 */
public interface IEntityContext extends IEntity {
    public Object wGetAdapter(Class<?> adapter);

	public void wSetRoot(IEntity rootEntity, int rootIndex);
	public IEntity wGetResult(); //one time

//  ** intensional methods **
//  One step traversals: intensional axis
    public void setContextTime(int contextTime);
    public void setContextTime(IEntityContext context);
    public void setContextTimeToEntityBindingTime();

	public int wGetBindingTime();
    public IEntity wGetPrevVersion();
	public IEntity wGetVersion(int contextTime);
	public IEntity wGetVersion(IEntityContext other);
	
	public void wUndo();
	public void wRedo();
	
	
//*** One step traversal methods

//	public IEntityContext wSetIterator(IModelIterator iterator);

// parent/child axis traversals
	public void wParent();
	public void wParent(EntityDescriptor<?> ed);
	public void wChild();
	public void wFirstChild();
	public void wLastChild();

// sibling axis traversals (current feature selection)
	public boolean wHasNext();
	public void wNext();
	public void wFeature(int index);
	public void wFeature(FeatureDescriptor feature);
//	public void wFeature_(int index);
//	public void wFeature_(FeatureDescriptor feature);
	public void wPrune();


// current feature methods
 	public FeatureDescriptor wCurrentGetFeatureDescriptor();
 	public EntityDescriptor<?> wCurrentGetEntityDescriptor();
 	public int wCurrentIndexOf();
	public boolean wCurrentAdd(IEntity entity);
	public void wCurrentRemove();
	public IEntity wCurrentGet();
	public void wCurrentSet(IEntity entity);


// IEntityContext adapter methods
	public int wIndexOf(IEntityContext value);
	public FeatureDescriptor wGetFeatureDescriptor(IEntityContext child);
	public void wSet(IEntityContext oldChild, IEntityContext newChild);

	public void wAdd(int index, IEntityContext value);
	public void wSet(int index, IEntityContext value);
	public void wSet(FeatureDescriptor feature, IEntityContext value);
}
