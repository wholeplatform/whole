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

import java.io.InputStream;
import java.io.OutputStream;

import org.whole.lang.bindings.IBindingManager;

/**
 * @author Riccardo Solmi
 */
public class StreamPersistenceProvider extends AbstractPersistenceProvider {
	public StreamPersistenceProvider(InputStream inputStream) {
		this(inputStream, null, null);
	}
	public StreamPersistenceProvider(OutputStream outputStream) {
		this(null, outputStream, null);
	}
	public StreamPersistenceProvider(InputStream inputStream, OutputStream outputStream, IBindingManager bm) {
		super(bm);
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	public boolean canReopenStream() {
		return false;
	}

	@Override
	public void initBindingManager() {
		if (bindingManager != null) {
			if (bindingManager.wIsSet("inputStream"))
				inputStream = (InputStream) bindingManager.wGetValue("inputStream");
			if (bindingManager.wIsSet("outputStream"))
				outputStream = (OutputStream) bindingManager.wGetValue("outputStream");
		}

		super.initBindingManager();
	}

	public boolean exists() {
		return inputStream != null;
	}
	public boolean delete() throws Exception {
		return false;
	}
}
