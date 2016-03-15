/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.java.factories.JavaDefaultEntityRegistryConfiguration;
import org.whole.lang.java.model.adapters.JavaAdaptersEntityRegistry;
import org.whole.lang.java.model.impl.JavaImplEntityRegistry;
import org.whole.lang.java.model.impl.JavaStrictImplEntityRegistry;
import org.whole.lang.java.parsers.JavaDataTypePersistenceParser;
import org.whole.lang.java.parsers.JavaDataTypePresentationParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class JavaLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Java";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.java";
	}

	public String getName() {
		return "Java";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return JavaEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return JavaFeatureDescriptorEnum.instance;
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new JavaDefaultEntityRegistryConfiguration().apply(er);
    	return er;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new JavaImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new JavaStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new JavaAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return JavaDataTypePersistenceParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return JavaDataTypePresentationParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return JavaTemplateManager.instance();
	}
}
