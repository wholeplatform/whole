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
package org.whole.lang.xml.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class XmlAdaptersEntityRegistry extends AbstractEntityRegistry {

    public XmlAdaptersEntityRegistry() {
        super(XmlEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new DocumentAdapter());
        put(new PrologAdapter());
        put(new XMLDeclAdapter());
        put(new VersionAdapter());
        put(new EncodingAdapter());
        put(new StandaloneAdapter());
        put(new DocTypeDeclAdapter());
        put(new SystemIdAdapter());
        put(new SystemLiteralAdapter());
        put(new PublicIdAdapter());
        put(new PubidLiteralAdapter());
        put(new MiscAdapter());
        put(new PIAdapter());
        put(new InstructionAdapter());
        put(new CommentAdapter());
        put(new CommentTextAdapter());
        put(new ElementAdapter());
        put(new AttributesAdapter());
        put(new AttributeAdapter());
        put(new NameAdapter());
        put(new QualifiedNameAdapter());
        put(new NameSpaceAdapter());
        put(new ValueAdapter());
        put(new ContentAdapter());
        put(new CharDataAdapter());
        put(new CDataSectAdapter());
        put(new CDataSectDataAdapter());
        put(new IContentAdapter());
        put(new IExternalIdAdapter());
        put(new IMiscAdapter());
        put(new INameAdapter());
    }
}
