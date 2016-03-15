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

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesLanguageKit;
import org.whole.lang.properties.util.PropertiesUtils;

/**
 * @author Riccardo Solmi
 */
public class PropertiesXmlPersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final PropertiesXmlPersistenceKit instance = new PropertiesXmlPersistenceKit();
	}
	public static final PropertiesXmlPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private PropertiesXmlPersistenceKit() {
		super("Properties xml", "xml", PropertiesLanguageKit.URI);
	}
	
	public boolean isLossless() {
		return false;
	}
	public boolean isMultilanguage() {
		return false;
	}

	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		//TODO ? cannot use getEncoding()
		return PropertiesUtils.loadFromXML(pp.getInputStream());
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		if (!model.wGetEntityDescriptor().equals(PropertiesEntityDescriptorEnum.Properties))
			throw new IllegalArgumentException("A Properties model is required. Was: "+model);

		PropertiesUtils.saveToXml((Properties) model, pp.getOutputStream(), "", pp.getEncoding());
	}
}
