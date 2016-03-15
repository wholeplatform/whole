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
package org.whole.lang.math.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.math.factories.MathDefaultEntityRegistryConfiguration;
import org.whole.lang.math.model.adapters.MathAdaptersEntityRegistry;
import org.whole.lang.math.model.impl.MathImplEntityRegistry;
import org.whole.lang.math.model.impl.MathStrictImplEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class MathLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Math";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.math";
	}

	public String getName() {
		return "Math";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return MathEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return MathFeatureDescriptorEnum.instance;
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new MathDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new MathImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new MathStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new MathAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return MathTemplateManager.instance();
	}
}
