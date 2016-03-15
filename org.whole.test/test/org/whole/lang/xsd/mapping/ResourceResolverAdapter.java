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
package org.whole.lang.xsd.mapping;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.whole.lang.util.ResourceLoader;
import org.whole.lang.xml.util.InputStreamInput;
import org.whole.lang.xml.util.ResourceResolver;

/**
 * @author Enrico Persiani
 */
public class ResourceResolverAdapter implements LSResourceResolver {
	private ResourceResolver rr;

	public ResourceResolverAdapter(ResourceLoader loader) {
		rr = new ResourceResolver(loader);
	}

	public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
		return new InputStreamInputAdapter(rr.resolveResource(type, namespaceURI, publicId, systemId, baseURI));
	}

	private static class InputStreamInputAdapter implements LSInput {
		private InputStreamInput isi;

		public InputStreamInputAdapter(InputStreamInput isi) {
			this.isi = isi;
		}

		public String getBaseURI() {
			return isi.getBaseURI();
		}
		public InputStream getByteStream() {
			return isi.getByteStream();
		}
		public boolean getCertifiedText() {
			return isi.getCertifiedText();
		}
		public Reader getCharacterStream() {
			return isi.getCharacterStream();
		}
		public String getEncoding() {
			return isi.getEncoding();
		}
		public String getPublicId() {
			return isi.getPublicId();
		}
		public String getStringData() {
			return isi.getStringData();
		}
		public String getSystemId() {
			return isi.getSystemId();
		}

		public void setBaseURI(String baseURI) {
			isi.setBaseURI(baseURI);
		}
		public void setByteStream(InputStream is) {
			isi.setByteStream(is);
		}
		public void setCertifiedText(boolean certifiedText) {
			isi.setCertifiedText(certifiedText);
		}
		public void setCharacterStream(Reader characterStream) {
			isi.setCharacterStream(characterStream);
		}
		public void setEncoding(String encoding) {
			isi.setEncoding(encoding);
		}
		public void setPublicId(String publicId) {
			isi.setPublicId(publicId);
		}
		public void setStringData(String stringData) {
			isi.setStringData(stringData);
		}
		public void setSystemId(String systemId) {
			isi.setSystemId(systemId);
		}
	}
}
