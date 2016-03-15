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
package org.whole.lang.codebase;

import java.io.PrintStream;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class DataTypePersistenceKit extends AbstractGenericPersistenceKit {
		private static class SingletonHolder {
			private static final DataTypePersistenceKit instance = new DataTypePersistenceKit();
		}
		public static final DataTypePersistenceKit instance() {
			return SingletonHolder.instance;
		}
		private DataTypePersistenceKit() {
			super("Datatype Persistence", "data");
		}

		@Override
		public boolean canApply(IEntity model) {
			return EntityUtils.isData(model);
		}

		@Override
		protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
			EntityDescriptor<?> ed = null;

			IBindingManager bindings = pp.getBindings();
			if (bindings.wIsSet("entityDescriptor"))
				ed = (EntityDescriptor<?>) bindings.wGetValue("entityDescriptor");
			else if (bindings.wIsSet("entityDescriptorName")) {
				String edName = bindings.wStringValue("entityDescriptorName");
				ed = CommonsDataTypePersistenceParser.parseEntityDescriptor(edName);
			}

			String data = StringUtils.readAsString(pp.getInputStream(), pp.getEncoding());
			if (ed != null)
				return DataTypeUtils.createFromPersistenceString(ed, data);
			else
				return BindingManagerFactory.instance.createValue(data);
		}

		@Override
		protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
			String data = DataTypeUtils.getAsPersistenceString(model);
			PrintStream printStream = new PrintStream(pp.getOutputStream(), false, pp.getEncoding());
			printStream.print(data);
			printStream.flush();
		}
}
