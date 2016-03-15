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
package org.whole.lang.properties.codebase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesLanguageKit;
import org.whole.lang.properties.util.PropertiesUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class PropertiesTextPersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final PropertiesTextPersistenceKit instance = new PropertiesTextPersistenceKit();
	}
	public static final PropertiesTextPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private PropertiesTextPersistenceKit() {
		super("Properties text", "properties", PropertiesLanguageKit.URI);
	}
	
	public boolean isLossless() {
		return false;
	}
	public boolean isMultilanguage() {
		return false;
	}

	protected String getDefaultEncoding() {
		return "ISO-8859-1";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		InputStream is = pp.getInputStream();
		String encoding = pp.getEncoding();
		Charset charset = Charset.forName(encoding);
		Charset persistenceCharset = Charset.forName(getDefaultEncoding());

		if (!persistenceCharset.equals(charset))
			is = new ByteArrayInputStream(persistenceCharset.newEncoder().encode(
					CharBuffer.wrap(StringUtils.readAsString(is, encoding))).array());

		return PropertiesUtils.loadFromText(is);		
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		if (!model.wGetEntityDescriptor().equals(PropertiesEntityDescriptorEnum.Properties))
			throw new IllegalArgumentException("A Properties model is required. Was: "+model);

		OutputStream os = pp.getOutputStream();
		String encoding = pp.getEncoding();
		Charset charset = Charset.forName(encoding);
		Charset persistenceCharset = Charset.forName(getDefaultEncoding());

		if (!persistenceCharset.equals(charset)) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			PropertiesUtils.saveToText((Properties) model, baos, "");

			os.write(charset.newEncoder().encode(CharBuffer.wrap(
					baos.toString(persistenceCharset.name()))).array());
		} else
			PropertiesUtils.saveToText((Properties) model, os, "");
	}
}
