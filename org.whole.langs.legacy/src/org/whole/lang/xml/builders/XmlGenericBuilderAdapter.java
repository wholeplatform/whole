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
package org.whole.lang.xml.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class XmlGenericBuilderAdapter extends GenericIdentityBuilder {
    private IXmlBuilder specificBuilder;

    public XmlGenericBuilderAdapter(IXmlBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public XmlGenericBuilderAdapter(IXmlBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case XmlFeatureDescriptorEnum.prolog_ord :
            specificBuilder.prolog();
            break;
            case XmlFeatureDescriptorEnum.element_ord :
            specificBuilder.element();
            break;
            case XmlFeatureDescriptorEnum.xmlDecl_ord :
            specificBuilder.xmlDecl();
            break;
            case XmlFeatureDescriptorEnum.docTypeDecl_ord :
            specificBuilder.docTypeDecl();
            break;
            case XmlFeatureDescriptorEnum.misc_ord :
            specificBuilder.misc();
            break;
            case XmlFeatureDescriptorEnum.version_ord :
            specificBuilder.version();
            break;
            case XmlFeatureDescriptorEnum.encoding_ord :
            specificBuilder.encoding();
            break;
            case XmlFeatureDescriptorEnum.standalone_ord :
            specificBuilder.standalone();
            break;
            case XmlFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case XmlFeatureDescriptorEnum.externalId_ord :
            specificBuilder.externalId();
            break;
            case XmlFeatureDescriptorEnum.systemLiteral_ord :
            specificBuilder.systemLiteral();
            break;
            case XmlFeatureDescriptorEnum.pubidLiteral_ord :
            specificBuilder.pubidLiteral();
            break;
            case XmlFeatureDescriptorEnum.instruction_ord :
            specificBuilder.instruction();
            break;
            case XmlFeatureDescriptorEnum.text_ord :
            specificBuilder.text();
            break;
            case XmlFeatureDescriptorEnum.tag_ord :
            specificBuilder.tag();
            break;
            case XmlFeatureDescriptorEnum.attributes_ord :
            specificBuilder.attributes();
            break;
            case XmlFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case XmlFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
            case XmlFeatureDescriptorEnum.nameSpace_ord :
            specificBuilder.nameSpace();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Document_ord :
            specificBuilder.Document();
            break;
            case XmlEntityDescriptorEnum.Prolog_ord :
            specificBuilder.Prolog();
            break;
            case XmlEntityDescriptorEnum.XMLDecl_ord :
            specificBuilder.XMLDecl();
            break;
            case XmlEntityDescriptorEnum.DocTypeDecl_ord :
            specificBuilder.DocTypeDecl();
            break;
            case XmlEntityDescriptorEnum.SystemId_ord :
            specificBuilder.SystemId();
            break;
            case XmlEntityDescriptorEnum.PublicId_ord :
            specificBuilder.PublicId();
            break;
            case XmlEntityDescriptorEnum.Misc_ord :
            specificBuilder.Misc();
            break;
            case XmlEntityDescriptorEnum.PI_ord :
            specificBuilder.PI();
            break;
            case XmlEntityDescriptorEnum.Comment_ord :
            specificBuilder.Comment();
            break;
            case XmlEntityDescriptorEnum.Element_ord :
            specificBuilder.Element();
            break;
            case XmlEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes();
            break;
            case XmlEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute();
            break;
            case XmlEntityDescriptorEnum.QualifiedName_ord :
            specificBuilder.QualifiedName();
            break;
            case XmlEntityDescriptorEnum.Content_ord :
            specificBuilder.Content();
            break;
            case XmlEntityDescriptorEnum.CDataSect_ord :
            specificBuilder.CDataSect();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Document_ord :
            specificBuilder.Document_();
            break;
            case XmlEntityDescriptorEnum.Prolog_ord :
            specificBuilder.Prolog_();
            break;
            case XmlEntityDescriptorEnum.XMLDecl_ord :
            specificBuilder.XMLDecl_();
            break;
            case XmlEntityDescriptorEnum.DocTypeDecl_ord :
            specificBuilder.DocTypeDecl_();
            break;
            case XmlEntityDescriptorEnum.SystemId_ord :
            specificBuilder.SystemId_();
            break;
            case XmlEntityDescriptorEnum.PublicId_ord :
            specificBuilder.PublicId_();
            break;
            case XmlEntityDescriptorEnum.Misc_ord :
            specificBuilder.Misc_();
            break;
            case XmlEntityDescriptorEnum.PI_ord :
            specificBuilder.PI_();
            break;
            case XmlEntityDescriptorEnum.Comment_ord :
            specificBuilder.Comment_();
            break;
            case XmlEntityDescriptorEnum.Element_ord :
            specificBuilder.Element_();
            break;
            case XmlEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes_();
            break;
            case XmlEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute_();
            break;
            case XmlEntityDescriptorEnum.QualifiedName_ord :
            specificBuilder.QualifiedName_();
            break;
            case XmlEntityDescriptorEnum.Content_ord :
            specificBuilder.Content_();
            break;
            case XmlEntityDescriptorEnum.CDataSect_ord :
            specificBuilder.CDataSect_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Document_ord :
            specificBuilder._Document();
            break;
            case XmlEntityDescriptorEnum.Prolog_ord :
            specificBuilder._Prolog();
            break;
            case XmlEntityDescriptorEnum.XMLDecl_ord :
            specificBuilder._XMLDecl();
            break;
            case XmlEntityDescriptorEnum.DocTypeDecl_ord :
            specificBuilder._DocTypeDecl();
            break;
            case XmlEntityDescriptorEnum.SystemId_ord :
            specificBuilder._SystemId();
            break;
            case XmlEntityDescriptorEnum.PublicId_ord :
            specificBuilder._PublicId();
            break;
            case XmlEntityDescriptorEnum.Misc_ord :
            specificBuilder._Misc();
            break;
            case XmlEntityDescriptorEnum.PI_ord :
            specificBuilder._PI();
            break;
            case XmlEntityDescriptorEnum.Comment_ord :
            specificBuilder._Comment();
            break;
            case XmlEntityDescriptorEnum.Element_ord :
            specificBuilder._Element();
            break;
            case XmlEntityDescriptorEnum.Attributes_ord :
            specificBuilder._Attributes();
            break;
            case XmlEntityDescriptorEnum.Attribute_ord :
            specificBuilder._Attribute();
            break;
            case XmlEntityDescriptorEnum.QualifiedName_ord :
            specificBuilder._QualifiedName();
            break;
            case XmlEntityDescriptorEnum.Content_ord :
            specificBuilder._Content();
            break;
            case XmlEntityDescriptorEnum.CDataSect_ord :
            specificBuilder._CDataSect();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Version_ord :
            specificBuilder.Version(value);
            break;
            case XmlEntityDescriptorEnum.Encoding_ord :
            specificBuilder.Encoding(value);
            break;
            case XmlEntityDescriptorEnum.SystemLiteral_ord :
            specificBuilder.SystemLiteral(value);
            break;
            case XmlEntityDescriptorEnum.PubidLiteral_ord :
            specificBuilder.PubidLiteral(value);
            break;
            case XmlEntityDescriptorEnum.Instruction_ord :
            specificBuilder.Instruction(value);
            break;
            case XmlEntityDescriptorEnum.CommentText_ord :
            specificBuilder.CommentText(value);
            break;
            case XmlEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
            case XmlEntityDescriptorEnum.NameSpace_ord :
            specificBuilder.NameSpace(value);
            break;
            case XmlEntityDescriptorEnum.Value_ord :
            specificBuilder.Value(value);
            break;
            case XmlEntityDescriptorEnum.CharData_ord :
            specificBuilder.CharData(value);
            break;
            case XmlEntityDescriptorEnum.CDataSectData_ord :
            specificBuilder.CDataSectData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Standalone_ord :
            specificBuilder.Standalone(value);
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case XmlEntityDescriptorEnum.Misc_ord :
            specificBuilder.Misc_(initialCapacity);
            break;
            case XmlEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes_(initialCapacity);
            break;
            case XmlEntityDescriptorEnum.Content_ord :
            specificBuilder.Content_(initialCapacity);
            break;
            case XmlEntityDescriptorEnum.CDataSect_ord :
            specificBuilder.CDataSect_(initialCapacity);
            break;
        }
    }
}
