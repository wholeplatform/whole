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

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.java.codebase.Factorial;
import org.whole.lang.java.model.JavaSystemSoftware;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class JavaTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final JavaTemplateManager instance = new JavaTemplateManager();
	}

	public static JavaTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private JavaTemplateManager() {
		put("empty", new AbstractTemplateFactory<JavaSystemSoftware>() {
			public JavaSystemSoftware create() {
                return GenericEntityFactory.instance.create(JavaEntityDescriptorEnum.JavaSystemSoftware);
			}
		});
		put("Factorial", new Factorial());
	}
}