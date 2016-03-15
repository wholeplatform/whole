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
package org.whole.lang.xml.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class XmlImplEntityRegistry extends AbstractEntityRegistry {

    public XmlImplEntityRegistry() {
        super(XmlEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new DocumentImpl());
        put(new PrologImpl());
        put(new XMLDeclImpl());
        put(new VersionImpl());
        put(new EncodingImpl());
        put(new StandaloneImpl());
        put(new DocTypeDeclImpl());
        put(new SystemIdImpl());
        put(new SystemLiteralImpl());
        put(new PublicIdImpl());
        put(new PubidLiteralImpl());
        put(new MiscImpl());
        put(new PIImpl());
        put(new InstructionImpl());
        put(new CommentImpl());
        put(new CommentTextImpl());
        put(new ElementImpl());
        put(new AttributesImpl());
        put(new AttributeImpl());
        put(new NameImpl());
        put(new QualifiedNameImpl());
        put(new NameSpaceImpl());
        put(new ValueImpl());
        put(new ContentImpl());
        put(new CharDataImpl());
        put(new CDataSectImpl());
        put(new CDataSectDataImpl());
    }
}
