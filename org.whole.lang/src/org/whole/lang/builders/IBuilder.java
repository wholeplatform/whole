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

import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public interface IBuilder {
	public void wSetBuilderContext(IBuilderContext context);
	public void wSetEntityContext(IEntityContext context);

	public void wDefault();
    public void wEntity();
    public void wEntity_();
    public void _wEntity();

    public void wEntity(EntityDescriptor<?> entity);
    public void wEntity_(EntityDescriptor<?> entity);
    public void wEntity_(EntityDescriptor<?> entity, int initialCapacity);
    public void _wEntity(EntityDescriptor<?> entity);

	public void wEntity(EntityDescriptor<?> entity, boolean value);
	public void wEntity(EntityDescriptor<?> entity, byte value);
	public void wEntity(EntityDescriptor<?> entity, char value);
	public void wEntity(EntityDescriptor<?> entity, double value);
	public void wEntity(EntityDescriptor<?> entity, float value);
	public void wEntity(EntityDescriptor<?> entity, int value);
	public void wEntity(EntityDescriptor<?> entity, long value);
	public void wEntity(EntityDescriptor<?> entity, short value);
	public void wEntity(EntityDescriptor<?> entity, String value);
	public void wEntity(EntityDescriptor<?> entity, Date value);
	public void wEntity(EntityDescriptor<?> entity, EnumValue value);
	public void wEntity(EntityDescriptor<?> entity, Object value);

	public void wFeature(int index);
	public void wFeature(FeatureDescriptor feature);
	public void wFeature(ITemplate template);

//TODO    public void wAspect(EntityDescriptor<?> entity);
}
