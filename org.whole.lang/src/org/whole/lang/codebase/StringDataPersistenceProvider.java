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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class StringDataPersistenceProvider extends AbstractPersistenceProvider {
	private IEntity stringData;

	public StringDataPersistenceProvider() {
		this("");
	}
	public StringDataPersistenceProvider(String string) {
		this(string, null);
	}
	public StringDataPersistenceProvider(IEntity stringData) {
		this(stringData, null);
	}
	public StringDataPersistenceProvider(String string, IBindingManager bm) {
		this(BindingManagerFactory.instance.createValue(string), bm);
	}
	public StringDataPersistenceProvider(IEntity stringData, IBindingManager bm) {
		super(bm);
		this.stringData = stringData;
	}

	public IEntity getStore() {
		return stringData;
	}

	public InputStream openInputStream() throws Exception {
		return new ByteArrayInputStream(stringData.wStringValue().getBytes(getEncoding()));
	}

	@Override
	public OutputStream getOutputStream() throws Exception {
		return super.getOutputStream();
	}
	public OutputStream openOutputStream() throws Exception {
		return new ByteArrayOutputStream(4096) {
			@Override
			public void close() throws IOException {
				super.close();
				try {
					stringData.wSetValue(toString(getEncoding()));
				} catch (UnsupportedEncodingException e) {
					throw new IOException(e);
				}
			}
		};
	}

	public boolean exists() {
		return true;
	}

	public boolean delete() {
		stringData.wSetValue("");
		return false;
	}

}
