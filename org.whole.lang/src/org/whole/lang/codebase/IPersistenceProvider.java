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
public interface IPersistenceProvider {
	public IPersistenceProvider withDefaultEncoding(String defaultEncoding);
	public String getEncoding();//TODO derive from getContentEncoding if available
	public IBindingManager getBindings();
	public void defineBindings(IBindingManager bm);

	public boolean canReopenStream();
	public void closeStream() throws Exception;
	public InputStream openInputStream() throws Exception;
	public OutputStream openOutputStream() throws Exception;
	public InputStream getInputStream() throws Exception;
	public OutputStream getOutputStream() throws Exception;

	public boolean exists();
	public boolean delete() throws Exception;
	//attributes()
	//bindAttributes()
}
