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
public class GenericFailureBuilder extends GenericIdentityBuilder {
    public void wEntity(EntityDescriptor<?> entityDesc) {
    	throw new BuilderException();
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
    	throw new BuilderException();
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
    	throw new BuilderException();
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    	throw new BuilderException();
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
    	throw new BuilderException();
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
    	throw new BuilderException();
    }
	
    public void wEntity() {
    	throw new BuilderException();
    }
    public void wEntity_() {
    	throw new BuilderException();
    }
    public void _wEntity() {
    	throw new BuilderException();
    }

	public void wDefault() {
    	throw new BuilderException();
    }
	public void wDefault(int size) {
    	throw new BuilderException();
    }

	public void wFeature(int index) {
    	throw new BuilderException();
	}
	public void wFeature(FeatureDescriptor feature) {
    	throw new BuilderException();
	}
	public void wFeature(ITemplate pattern) {
    	throw new BuilderException();
	}
}
