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
package org.whole.lang.types.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.types.model.TypeSystem;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator Whole
 */
public class TypesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final TypesTemplateManager instance = new TypesTemplateManager();
    }

    public static TypesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private TypesTemplateManager() {
        put("empty", new AbstractTemplateFactory<TypeSystem>() {

            public TypeSystem create() {
                return GenericEntityFactory.instance.create(TypesEntityDescriptorEnum.TypeSystem);
            }
        });
    }
}
