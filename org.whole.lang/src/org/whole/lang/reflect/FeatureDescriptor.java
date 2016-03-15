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
package org.whole.lang.reflect;



/**
 * @author Riccardo Solmi
 */
public interface FeatureDescriptor extends Descriptor {
	public boolean isEntityFeatureDescriptor();
	public FeatureDescriptor getFeatureDescriptor();
	public FeatureDescriptorEnum getFeatureDescriptorEnum();


//EntityFeatureDescriptor only APIs

	public boolean isOptional();
	public boolean isId();
	public boolean isReference();
	public boolean isDerived();
	public boolean isShared();
	public boolean isToMany();

	public EntityDescriptor<?> getParentEntityDescriptor();
	public void setParentEntityDescriptor(EntityDescriptor<?> ed);
	public FeatureDescriptor getOppositeFeatureDescriptor();
	public EntityDescriptor<?> getEntityDescriptor();
}
