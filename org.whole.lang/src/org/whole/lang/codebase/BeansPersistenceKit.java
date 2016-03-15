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

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;


/**
 * @author Riccardo Solmi
 */
public class BeansPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final BeansPersistenceKit instance = new BeansPersistenceKit();
	}
	public static final BeansPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private BeansPersistenceKit() {
		super("XML (Long Term JavaBeans Persistence)", "xml");
	}

	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		//TODO cannot use getEncoding()
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(pp.getInputStream()) {
			@Override
			public void close() throws IOException {
			}
		}, null,
			new ExceptionListener() {
				public void exceptionThrown(Exception e) {
					// do nothing
				}
			}, ReflectionFactory.getPlatformClassLoader());
		IEntity model = (IEntity) decoder.readObject();
		decoder.close();
		return model;
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		//TODO cannot use getEncoding()
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(pp.getOutputStream()) {
			@Override
			public void close() throws IOException {
				flush();
			}
		});
		encoder.writeObject(model);
		encoder.close();
	}
}
