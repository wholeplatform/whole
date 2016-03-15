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
package org.whole.langs.legacy;

import org.whole.lang.java.reflect.JavaLanguageDeployer;
import org.whole.lang.javascript.reflect.JavaScriptLanguageDeployer;
import org.whole.lang.json.reflect.JSONLanguageDeployer;
import org.whole.lang.properties.reflect.PropertiesLanguageDeployer;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.scripts.reflect.ScriptsLanguageDeployer;
import org.whole.lang.text.reflect.TextLanguageDeployer;
import org.whole.lang.xml.reflect.XmlLanguageDeployer;
import org.whole.lang.xsd.mapping.reflect.MappingLanguageDeployer;
import org.whole.lang.xsd.reflect.XsdLanguageDeployer;

/**
 * @author Riccardo Solmi
 */
public class LegacyLanguagesDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE;
	}

	@SuppressWarnings("unchecked")
	public LegacyLanguagesDeployer() {
		super(
			JavaLanguageDeployer.class,
			PropertiesLanguageDeployer.class,
			TextLanguageDeployer.class,
			XmlLanguageDeployer.class,
			XsdLanguageDeployer.class,
			MappingLanguageDeployer.class,
			ScriptsLanguageDeployer.class,
			JavaScriptLanguageDeployer.class,
			JavaPersistenceDeployer.class,
			JSONLanguageDeployer.class,
			JSONPersistenceDeployer.class,
			DefaultPersistenceDeployer.class
		);
	}

	public void deploy(ReflectionFactory platform) {
		super.deploy(platform);
//		new PersistenceLibraryDeployer().deploy(platform);
	}
}
