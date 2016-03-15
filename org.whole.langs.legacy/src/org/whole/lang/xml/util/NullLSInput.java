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
package org.whole.lang.xml.util;

import java.io.InputStream;
import java.io.Reader;

/**
 * @author Enrico Persiani
 */
public class NullLSInput {// workaround for Android compatibility implements LSInput {

	public Reader getCharacterStream() {
		return null;
	}
	public void setCharacterStream(Reader characterStream) {
	}

	public InputStream getByteStream() {
		return null;
	}
	public void setByteStream(InputStream byteStream) {
	}
	public String getEncoding() {
		return null;
	}
	public void setEncoding(String encoding) {
	}

	public String getStringData() {
		return null;
	}
	public void setStringData(String stringData) {
	}

	public String getSystemId() {
		return null;
	}
	public void setSystemId(String systemId) {
	}
	public String getBaseURI() {
		return null;
	}
	public void setBaseURI(String baseURI) {
	}

	public String getPublicId() {
		return null;
	}
	public void setPublicId(String publicId) {
	}

	public boolean getCertifiedText() {
		return false;
	}
	public void setCertifiedText(boolean certifiedText) {
	}
}
