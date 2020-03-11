/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swiftsyntax.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator Whole
 */
public class SwiftSyntaxTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final SwiftSyntaxTemplateManager instance = new SwiftSyntaxTemplateManager();
    }

    public static SwiftSyntaxTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private SwiftSyntaxTemplateManager() {
        put("empty", new AbstractTemplateFactory<Token>() {

            public Token create() {
                return GenericEntityFactory.instance.create(SwiftSyntaxEntityDescriptorEnum.Token);
            }
        });
    }
}
