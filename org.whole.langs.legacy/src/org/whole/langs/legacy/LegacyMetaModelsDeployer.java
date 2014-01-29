/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.java.reflect.JavaLanguageKit;
import org.whole.lang.javascript.reflect.JavaScriptLanguageKit;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.properties.reflect.PropertiesLanguageKit;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.scripts.reflect.ScriptsLanguageKit;
import org.whole.lang.text.reflect.TextLanguageKit;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xsd.mapping.reflect.MappingLanguageKit;
import org.whole.lang.xsd.reflect.XsdLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class LegacyMetaModelsDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.setMetaModelTemplate(JavaLanguageKit.URI, "org.whole.lang.models.codebase.Java5Model");
		platform.setMetaModelTemplate(PropertiesLanguageKit.URI, "org.whole.lang.models.codebase.PropertiesModel");
		platform.setMetaModelTemplate(TextLanguageKit.URI, "org.whole.lang.models.codebase.TextModel");
		platform.setMetaModelTemplate(XmlLanguageKit.URI, "org.whole.lang.models.codebase.XmlModel");
		platform.setMetaModelTemplate(XsdLanguageKit.URI, "org.whole.lang.models.codebase.XsdModel");
		platform.setMetaModelTemplate(MappingLanguageKit.URI, "org.whole.lang.models.codebase.XsdMappingModel");
		platform.setMetaModelTemplate(ScriptsLanguageKit.URI, "org.whole.lang.models.codebase.ScriptsModel");
		platform.setMetaModelTemplate(JavaScriptLanguageKit.URI, "org.whole.lang.models.codebase.JavaScriptModel");
		platform.setMetaModelTemplate(JSONLanguageKit.URI, "org.whole.lang.models.codebase.JSONModel");
	}

	public void undeploy(ReflectionFactory platform) {
		platform.unsetMetaModelTemplate(JavaLanguageKit.URI);
		platform.unsetMetaModelTemplate(PropertiesLanguageKit.URI);
		platform.unsetMetaModelTemplate(TextLanguageKit.URI);
		platform.unsetMetaModelTemplate(XmlLanguageKit.URI);
		platform.unsetMetaModelTemplate(XsdLanguageKit.URI);
		platform.unsetMetaModelTemplate(MappingLanguageKit.URI);
		platform.unsetMetaModelTemplate(ScriptsLanguageKit.URI);
		platform.unsetMetaModelTemplate(JavaScriptLanguageKit.URI);
		platform.unsetMetaModelTemplate(JSONLanguageKit.URI);
	}
}
