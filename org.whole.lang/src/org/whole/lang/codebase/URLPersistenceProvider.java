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
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.whole.lang.bindings.IBindingManager;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class URLPersistenceProvider extends AbstractPersistenceProvider {
	private URL url;

	public URLPersistenceProvider(URL url) {
		this(url, null);
	}
	public URLPersistenceProvider(URL url, IBindingManager bm) {
		super(bm);
		this.url = url;
	}

	public URL getStore() {
		return url;
	}

	public InputStream openInputStream() throws Exception {
		URLConnection connection = url.openConnection();

		if (connection instanceof HttpURLConnection) {
			HttpURLConnection httpConnection = (HttpURLConnection) connection;

			int code = httpConnection.getResponseCode();
			if (code != HttpURLConnection.HTTP_OK)
				throw new IOException("unexpected HTTP response code " + code);

			parseHeaders(httpConnection);
		}

		InputStream is = connection.getInputStream();
		return is.markSupported() ? is : new BufferedInputStream(is);
	}

	public OutputStream openOutputStream() throws Exception {
		URLConnection connection = url.openConnection();

		if (connection instanceof HttpURLConnection) {
			String mediaType = getBindings().wIsSet("mediaType") ?
					getBindings().wStringValue("mediaType") : "text/plain";

			final HttpURLConnection httpConnection = (HttpURLConnection) connection;
			httpConnection.setRequestMethod("PUT");
			httpConnection.setDoOutput(true);
			httpConnection.setRequestProperty("Content-Type", mediaType+";charset="+getEncoding());

			OutputStream outputStream = httpConnection.getOutputStream();

			return new FilterOutputStream(outputStream) {
				public void close() throws IOException {
					super.close();
					int code = httpConnection.getResponseCode();
					if (code != HttpURLConnection.HTTP_OK &&
							code != HttpURLConnection.HTTP_CREATED &&
							code != HttpURLConnection.HTTP_NO_CONTENT)
						throw new IOException("unexpected HTTP response code " + code);
				};
			};
		} else
			return connection.getOutputStream();
	}

	public boolean exists() {
		if (head() == null)
			try {
				openInputStream().close();
			} catch (Exception e) {
				return false;
			}
		return true;
	}
	
	public Date getLastModified() throws IOException {
		HttpURLConnection connection = head();
		if (connection == null)
			throw new IOException("missing resource");

		long millis = connection.getLastModified();
		return new Date(millis == 0L ?System.currentTimeMillis(): millis);
	}
	public long getContentLength() throws IOException {
		HttpURLConnection connection = head();
		if (connection == null)
			throw new IOException("missing resource");

		return connection.getContentLength();
	}

	public boolean delete() throws Exception {
		URLConnection connection = url.openConnection();
		if (connection instanceof HttpURLConnection) {
			HttpURLConnection httpConnection = (HttpURLConnection) connection;
			httpConnection.setRequestMethod("DELETE");
			int code = httpConnection.getResponseCode();
			return code == HttpURLConnection.HTTP_OK || code == HttpURLConnection.HTTP_ACCEPTED
					|| code == HttpURLConnection.HTTP_NO_CONTENT;
		}
		return false;
	}

	protected void parseHeaders(HttpURLConnection httpConnection) {
		String mediaType = null; 

		String contentType = httpConnection.getContentType();
		int indexOfSemicolon = contentType.indexOf(';');

		if (indexOfSemicolon != -1) {
			mediaType = contentType.substring(0, indexOfSemicolon).trim();

			String parameter = contentType.substring(indexOfSemicolon+1).trim();
			if (parameter.startsWith("charset="))
				withDefaultEncoding(parameter.substring(parameter.indexOf('=')+1).trim());
		} else
			mediaType = contentType.trim();

		getBindings().wDefValue("mediaType", mediaType);
	}
	protected HttpURLConnection head() {
		try {
			URLConnection connection = url.openConnection();

			if (connection instanceof HttpURLConnection) {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.setRequestMethod("HEAD");
				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
					return httpConnection;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
