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
package org.whole.lang.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface IDataTypeWrapper {
	public <E extends IEntity> E createEntity(Object value);


	public static final IDataTypeWrapper identity = new IDataTypeWrapper() {
		@SuppressWarnings("unchecked")
		public <E extends IEntity> E createEntity(Object value) {
			return (E) value;
		}
	};
	public static final IDataTypeWrapper envSpecificValue = new IDataTypeWrapper() {
		@SuppressWarnings("unchecked")
		public <E extends IEntity> E createEntity(Object value) {
			return (E) BindingManagerFactory.instance.createSpecificValue(value);
		}
	};
	public static final IDataTypeWrapper envEnumValue = new IDataTypeWrapper() {
		@SuppressWarnings("unchecked")
		public <E extends IEntity> E createEntity(Object value) {
			return (E) BindingManagerFactory.instance.createValue((EnumValue) value);
		}
	};
	public static final IDataTypeWrapper envObjectValue = new IDataTypeWrapper() {
		@SuppressWarnings("unchecked")
		public <E extends IEntity> E createEntity(Object value) {
			return (E) BindingManagerFactory.instance.createValue(value);
		}
	};

	public static class CustomDatatypeWrapper implements IDataTypeWrapper {
		private String edUri;
		protected EntityDescriptor<?> ed;

		public CustomDatatypeWrapper(String edUri) {
			this.edUri = edUri;
		}
		public CustomDatatypeWrapper(EntityDescriptor<?> ed) {
			this(ed.getURI());
			this.ed = ed;
		}

		protected EntityDescriptor<?> getWrapperEntityDescriptor() {
			if (ed == null)
		    	ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, false, null);
			return ed;
		}

		@SuppressWarnings("unchecked")
		public <E extends IEntity> E createEntity(Object value) {
			return (E) GenericEntityFactory.instance.create(getWrapperEntityDescriptor(), value);
		}
	};
}
