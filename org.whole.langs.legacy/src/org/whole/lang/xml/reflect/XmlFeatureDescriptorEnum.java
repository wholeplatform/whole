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
package org.whole.lang.xml.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class XmlFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int prolog_ord = 0;
    public static final int element_ord = 1;
    public static final int xmlDecl_ord = 2;
    public static final int docTypeDecl_ord = 3;
    public static final int misc_ord = 4;
    public static final int version_ord = 5;
    public static final int encoding_ord = 6;
    public static final int standalone_ord = 7;
    public static final int name_ord = 8;
    public static final int externalId_ord = 9;
    public static final int systemLiteral_ord = 10;
    public static final int pubidLiteral_ord = 11;
    public static final int instruction_ord = 12;
    public static final int text_ord = 13;
    public static final int tag_ord = 14;
    public static final int attributes_ord = 15;
    public static final int content_ord = 16;
    public static final int value_ord = 17;
    public static final int nameSpace_ord = 18;
    public static final XmlFeatureDescriptorEnum instance = new XmlFeatureDescriptorEnum();
    public static final FeatureDescriptor prolog = instance.valueOf(prolog_ord);
    public static final FeatureDescriptor element = instance.valueOf(element_ord);
    public static final FeatureDescriptor xmlDecl = instance.valueOf(xmlDecl_ord);
    public static final FeatureDescriptor docTypeDecl = instance.valueOf(docTypeDecl_ord);
    public static final FeatureDescriptor misc = instance.valueOf(misc_ord);
    public static final FeatureDescriptor version = instance.valueOf(version_ord);
    public static final FeatureDescriptor encoding = instance.valueOf(encoding_ord);
    public static final FeatureDescriptor standalone = instance.valueOf(standalone_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor externalId = instance.valueOf(externalId_ord);
    public static final FeatureDescriptor systemLiteral = instance.valueOf(systemLiteral_ord);
    public static final FeatureDescriptor pubidLiteral = instance.valueOf(pubidLiteral_ord);
    public static final FeatureDescriptor instruction = instance.valueOf(instruction_ord);
    public static final FeatureDescriptor text = instance.valueOf(text_ord);
    public static final FeatureDescriptor tag = instance.valueOf(tag_ord);
    public static final FeatureDescriptor attributes = instance.valueOf(attributes_ord);
    public static final FeatureDescriptor content = instance.valueOf(content_ord);
    public static final FeatureDescriptor value = instance.valueOf(value_ord);
    public static final FeatureDescriptor nameSpace = instance.valueOf(nameSpace_ord);

    private XmlFeatureDescriptorEnum() {
        putFeatureDescriptor(prolog_ord, "prolog");
        putFeatureDescriptor(element_ord, "element");
        putFeatureDescriptor(xmlDecl_ord, "xmlDecl");
        putFeatureDescriptor(docTypeDecl_ord, "docTypeDecl");
        putFeatureDescriptor(misc_ord, "misc");
        putFeatureDescriptor(version_ord, "version");
        putFeatureDescriptor(encoding_ord, "encoding");
        putFeatureDescriptor(standalone_ord, "standalone");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(externalId_ord, "externalId");
        putFeatureDescriptor(systemLiteral_ord, "systemLiteral");
        putFeatureDescriptor(pubidLiteral_ord, "pubidLiteral");
        putFeatureDescriptor(instruction_ord, "instruction");
        putFeatureDescriptor(text_ord, "text");
        putFeatureDescriptor(tag_ord, "tag");
        putFeatureDescriptor(attributes_ord, "attributes");
        putFeatureDescriptor(content_ord, "content");
        putFeatureDescriptor(value_ord, "value");
        putFeatureDescriptor(nameSpace_ord, "nameSpace");
    }
    private static final long serialVersionUID = 1;
}
