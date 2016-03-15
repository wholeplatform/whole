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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class FilePersistenceProvider extends AbstractPersistenceProvider {
	private File file;

	public FilePersistenceProvider(File file) {
		this(file, null);
	}
	public FilePersistenceProvider(File file, IBindingManager bm) {
		super(bm);
		this.file = file;
		defineBindings(getBindings());
	}

	public void defineBindings(IBindingManager bm) {
		ResourceUtils.defineResourceBindings(bm, file);
	}

	public File getStore() {
		return file;
	}

	public InputStream openInputStream() throws Exception {
		return new BufferedInputStream(new FileInputStream(file));
	}

	public OutputStream openOutputStream() throws Exception {
	    String parent = file.getParent();
	    if (parent != null)
	    	new File(parent).mkdirs();

		return new FileOutputStream(file);
	}

	public boolean exists() {
		return file.exists();
	}

	public boolean delete() {
		return file.delete();
	}
}
