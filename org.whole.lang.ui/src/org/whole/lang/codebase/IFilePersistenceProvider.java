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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.ui.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class IFilePersistenceProvider extends AbstractPersistenceProvider {
	private IFile file;

	public IFilePersistenceProvider(IFile file) {
		this(file, null);
	}
	public IFilePersistenceProvider(IFile file, IBindingManager bm) {
		super(bm);
		this.file = file;
		defineBindings(getBindings());
	}

	public void defineBindings(IBindingManager bm) {
		ResourceUtils.defineResourceBindings(bm, file);
	}

	public IFile getStore() {
		return file;
	}

	public InputStream openInputStream() throws Exception {
		return new BufferedInputStream(file.getContents(true));
	}

	public OutputStream openOutputStream() throws Exception {
		return new ByteArrayOutputStream(4096) {
			@Override
			public void close() throws IOException {
				super.close();

				int updateFlags = IResource.FORCE;
				if (getBindings().wIsSet("derived"))
					updateFlags |= IResource.DERIVED;

				try {
					InputStream is = new ByteArrayInputStream(toByteArray());
					if (file.exists())
						file.setContents(is, updateFlags|IResource.KEEP_HISTORY, ResourceUtils.getProgressMonitor(getBindings()));
					else
						file.create(is, updateFlags, ResourceUtils.getProgressMonitor(getBindings()));

					if (getBindings().wIsSet("readonly")) {
						ResourceAttributes attributes = file.getResourceAttributes();
						if (attributes != null) {
							attributes.setReadOnly(true);
							file.setResourceAttributes(attributes);
						}
					}

				} catch (CoreException e) {
					throw new IOException(e);
				}
			}
		};
	}

	public boolean exists() {
		return file.exists();
	}

	public boolean delete() throws Exception {
		file.delete(true, ResourceUtils.getProgressMonitor(getBindings()));
		return true;
	}
}
