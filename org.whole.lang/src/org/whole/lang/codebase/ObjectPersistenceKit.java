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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi
 */
public class ObjectPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final ObjectPersistenceKit instance = new ObjectPersistenceKit();
	}
	public static final ObjectPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private ObjectPersistenceKit() {
		super("Binary (Java Object Persistence)", "ser");
	}

	protected String getDefaultEncoding() {
		return null;
	}
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(pp.getInputStream()) {
			@Override
			public void close() throws IOException {
			}
		});
		IEntity model = (IEntity) ois.readObject();
		ois.close();
		return model;
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(pp.getOutputStream()) {
			@Override
			public void close() throws IOException {
				flush();
			}
		});
		IHistoryManager hm = ReflectionFactory.getHistoryManager(model);
		try {
			hm.begin();
			IEntity parent = model.wGetParent();
			if (!EntityUtils.isNull(parent))
				parent.wRemove(model);
			out.writeObject(model);
		} finally {
			hm.rollback();
		}
		out.close();
	}
}
