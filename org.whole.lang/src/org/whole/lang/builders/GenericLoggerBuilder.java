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
import java.util.logging.Logger;

import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public class GenericLoggerBuilder implements IBuilder {
	private static class SingletonHolder {
		private static final Logger logger = Logger.getLogger("org.whole.lang.builders");
		private static final GenericLoggerBuilder instance = new GenericLoggerBuilder();
	}
	public static final Logger logger() {
		return SingletonHolder.logger;
	}
	public static final IBuilder instance() {
		return SingletonHolder.instance;
	}
	public static final IBuilder instance(IBuilder builder) {
		return new GenericSequenceBuilder(instance(), builder);
	}
	private GenericLoggerBuilder() {
	}


	public void wSetBuilderContext(IBuilderContext context) {
    	logger().info(context.toString());
	}
	public void wSetEntityContext(IEntityContext context) {
    	logger().info(context.toString());
	}


	public void wEntity(EntityDescriptor<?> entityDesc) {
    	logger().info(entityDesc.toString());
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
    	logger().info(entityDesc.toString()+"_");
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
    	logger().info(entityDesc.toString()+"_");
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    	logger().info("_"+entityDesc.toString());
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
    	logger().info(entityDesc.toString()+"('"+value+"')");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
    	logger().info(entityDesc.toString()+"(\""+value+"\")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
    	logger().info(entityDesc.toString()+"("+value+")");
    }
	
    public void wEntity() {
    	logger().info("wEntity");
    }
    public void wEntity_() {
    	logger().info("wEntity_");
    }
    public void _wEntity() {
    	logger().info("_wEntity");
   }

	public void wDefault() {
    	logger().info("wDefault");
    }
	public void wDefault(int size) {
    	logger().info("wDefault("+size+")");
    }

	public void wFeature(int index) {
    	logger().info("wFeature("+index+")");
	}
	public void wFeature(FeatureDescriptor feature) {
		logger().info(feature.toString());
	}
	public void wFeature(ITemplate pattern) {
		logger().info(pattern.toString());
	}
}
