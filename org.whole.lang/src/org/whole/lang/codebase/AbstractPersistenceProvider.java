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
import java.nio.charset.Charset;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * Bindings:
 *   inputStream (arg), outputStream (arg), encoding (arg)
 *
 * @author Riccardo Solmi
 */
public abstract class AbstractPersistenceProvider implements IPersistenceProvider {
	protected IBindingManager bindingManager;
	protected String defaultEncoding;
	protected InputStream inputStream;
	protected OutputStream outputStream;

	//bindingManager can be null
	public AbstractPersistenceProvider(IBindingManager bm) {
		if (bm != null) {
			this.bindingManager = BindingManagerFactory.instance.createBindingManager();
			this.bindingManager.wEnterScope(bm, true);
			initBindingManager();
		}
	}

	public void defineBindings(IBindingManager bm) {
	}

	public IPersistenceProvider withDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
		return this;
	}
	public String getDefaultEncoding() {
		return defaultEncoding != null ? defaultEncoding : Charset.defaultCharset().name();
	}
	public String getEncoding() {
		String result = null;
		if (bindingManager != null && getBindings().wIsSet("encoding"))
			result = getBindings().wStringValue("encoding");
		if (result == null)
			result = getDefaultEncoding();

		return result;
	}

	public Object getStore() {
		throw new UnsupportedOperationException();
	}

	public boolean canReopenStream() {
		return true;
	}

	public void closeStream() throws Exception {
		if (inputStream != null) {
			inputStream.close();
			inputStream = null;
		}

		if (outputStream != null) {
			outputStream.close();
			outputStream = null;
		}
	}

	public InputStream getInputStream() throws Exception {
		if (inputStream == null)
			inputStream = openInputStream();
		return inputStream;
	}
	public InputStream openInputStream() throws Exception {
		throw new UnsupportedOperationException();
	}

	public OutputStream getOutputStream() throws Exception {
		if (outputStream == null)
			outputStream = openOutputStream();
		return outputStream;
	}
	public OutputStream openOutputStream() throws Exception {
		throw new UnsupportedOperationException();
	}

	public IBindingManager getBindings() {
		if (bindingManager == null) {
			bindingManager = BindingManagerFactory.instance.createBindingManager();
			initBindingManager();
		}

		return bindingManager;
	}
	public void initBindingManager() {
		bindingManager.wDefValue("inputStream", (Object) null);
		bindingManager.wGet("inputStream").wAddRequestEventHandler(new IdentityRequestEventHandler() {
			public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
				return inputStream;
			}
		});

		bindingManager.wDefValue("outputStream", (Object) null);
		bindingManager.wGet("outputStream").wAddRequestEventHandler(new IdentityRequestEventHandler() {
			public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
				return outputStream;
			}
		});

		if (!bindingManager.wIsSet("encoding")) {
			bindingManager.wDefValue("encoding", "");
			bindingManager.wGet("encoding").wAddRequestEventHandler(new IdentityRequestEventHandler() {
				public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
					return getDefaultEncoding();
				}
			});
		}
	}
}
