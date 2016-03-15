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
import java.io.InputStream;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ClasspathPersistenceProvider extends AbstractPersistenceProvider {
	private String resourceClasspath;

	public ClasspathPersistenceProvider(String resourceClasspath) {
		this(resourceClasspath, null);
	}
	public ClasspathPersistenceProvider(String resourceClasspath, IBindingManager bm) {
		super(bm);
		this.resourceClasspath = resourceClasspath;
		defineBindings(getBindings());
	}

	public void defineBindings(IBindingManager bm) {
		ResourceUtils.defineResourceBindings(bm, resourceClasspath);
	}

	public String getStore() {
		return resourceClasspath;
	}

	public InputStream openInputStream() throws Exception {
		InputStream is = ReflectionFactory.getClassLoader(getBindings()).getResourceAsStream(resourceClasspath);
		return is.markSupported() ? is : new BufferedInputStream(is);
	}

	public boolean exists() {
		return ReflectionFactory.getClassLoader(getBindings()).getResource(resourceClasspath) != null;
	}

	public boolean delete() {
		return false;
	}
}
