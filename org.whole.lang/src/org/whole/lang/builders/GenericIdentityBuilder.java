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

import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public class GenericIdentityBuilder extends AbstractBuilder {

	public void wEntity(EntityDescriptor<?> entityDesc) {
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
    }
	
    public void wEntity() {
    }
    public void wEntity_() {
    }
    public void _wEntity() {
    }

	public void wDefault() {
    }
	public void wDefault(int size) {
    }

	public void wFeature(int index) {
	}
	public void wFeature(FeatureDescriptor feature) {
	}
	public void wFeature(ITemplate pattern) {
	}
}
