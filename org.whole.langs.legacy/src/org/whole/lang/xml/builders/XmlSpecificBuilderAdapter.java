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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class XmlSpecificBuilderAdapter extends GenericBuilderContext implements IXmlBuilder {

    public XmlSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public XmlSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void nameSpace() {
        wFeature(XmlFeatureDescriptorEnum.nameSpace);
    }

    public void value() {
        wFeature(XmlFeatureDescriptorEnum.value);
    }

    public void content() {
        wFeature(XmlFeatureDescriptorEnum.content);
    }

    public void attributes() {
        wFeature(XmlFeatureDescriptorEnum.attributes);
    }

    public void tag() {
        wFeature(XmlFeatureDescriptorEnum.tag);
    }

    public void text() {
        wFeature(XmlFeatureDescriptorEnum.text);
    }

    public void instruction() {
        wFeature(XmlFeatureDescriptorEnum.instruction);
    }

    public void pubidLiteral() {
        wFeature(XmlFeatureDescriptorEnum.pubidLiteral);
    }

    public void systemLiteral() {
        wFeature(XmlFeatureDescriptorEnum.systemLiteral);
    }

    public void externalId() {
        wFeature(XmlFeatureDescriptorEnum.externalId);
    }

    public void name() {
        wFeature(XmlFeatureDescriptorEnum.name);
    }

    public void standalone() {
        wFeature(XmlFeatureDescriptorEnum.standalone);
    }

    public void encoding() {
        wFeature(XmlFeatureDescriptorEnum.encoding);
    }

    public void version() {
        wFeature(XmlFeatureDescriptorEnum.version);
    }

    public void misc() {
        wFeature(XmlFeatureDescriptorEnum.misc);
    }

    public void docTypeDecl() {
        wFeature(XmlFeatureDescriptorEnum.docTypeDecl);
    }

    public void xmlDecl() {
        wFeature(XmlFeatureDescriptorEnum.xmlDecl);
    }

    public void element() {
        wFeature(XmlFeatureDescriptorEnum.element);
    }

    public void prolog() {
        wFeature(XmlFeatureDescriptorEnum.prolog);
    }

    public void visit() {
    }

    public void Document() {
        wEntity(XmlEntityDescriptorEnum.Document);
    }

    public void Document_() {
        wEntity_(XmlEntityDescriptorEnum.Document);
    }

    public void _Document() {
        _wEntity(XmlEntityDescriptorEnum.Document);
    }

    public void Prolog() {
        wEntity(XmlEntityDescriptorEnum.Prolog);
    }

    public void Prolog_() {
        wEntity_(XmlEntityDescriptorEnum.Prolog);
    }

    public void _Prolog() {
        _wEntity(XmlEntityDescriptorEnum.Prolog);
    }

    public void XMLDecl() {
        wEntity(XmlEntityDescriptorEnum.XMLDecl);
    }

    public void XMLDecl_() {
        wEntity_(XmlEntityDescriptorEnum.XMLDecl);
    }

    public void _XMLDecl() {
        _wEntity(XmlEntityDescriptorEnum.XMLDecl);
    }

    public void Version() {
        wEntity(XmlEntityDescriptorEnum.Version);
    }

    public void Version(String value) {
        wEntity(XmlEntityDescriptorEnum.Version, value);
    }

    public void Encoding() {
        wEntity(XmlEntityDescriptorEnum.Encoding);
    }

    public void Encoding(String value) {
        wEntity(XmlEntityDescriptorEnum.Encoding, value);
    }

    public void Standalone() {
        wEntity(XmlEntityDescriptorEnum.Standalone);
    }

    public void Standalone(boolean value) {
        wEntity(XmlEntityDescriptorEnum.Standalone, value);
    }

    public void DocTypeDecl() {
        wEntity(XmlEntityDescriptorEnum.DocTypeDecl);
    }

    public void DocTypeDecl_() {
        wEntity_(XmlEntityDescriptorEnum.DocTypeDecl);
    }

    public void _DocTypeDecl() {
        _wEntity(XmlEntityDescriptorEnum.DocTypeDecl);
    }

    public void SystemId() {
        wEntity(XmlEntityDescriptorEnum.SystemId);
    }

    public void SystemId_() {
        wEntity_(XmlEntityDescriptorEnum.SystemId);
    }

    public void _SystemId() {
        _wEntity(XmlEntityDescriptorEnum.SystemId);
    }

    public void SystemLiteral() {
        wEntity(XmlEntityDescriptorEnum.SystemLiteral);
    }

    public void SystemLiteral(String value) {
        wEntity(XmlEntityDescriptorEnum.SystemLiteral, value);
    }

    public void PublicId() {
        wEntity(XmlEntityDescriptorEnum.PublicId);
    }

    public void PublicId_() {
        wEntity_(XmlEntityDescriptorEnum.PublicId);
    }

    public void _PublicId() {
        _wEntity(XmlEntityDescriptorEnum.PublicId);
    }

    public void PubidLiteral() {
        wEntity(XmlEntityDescriptorEnum.PubidLiteral);
    }

    public void PubidLiteral(String value) {
        wEntity(XmlEntityDescriptorEnum.PubidLiteral, value);
    }

    public void Misc() {
        wEntity(XmlEntityDescriptorEnum.Misc);
    }

    public void Misc_() {
        wEntity_(XmlEntityDescriptorEnum.Misc);
    }

    public void Misc_(int initialCapacity) {
        wEntity_(XmlEntityDescriptorEnum.Misc, initialCapacity);
    }

    public void _Misc() {
        _wEntity(XmlEntityDescriptorEnum.Misc);
    }

    public void PI() {
        wEntity(XmlEntityDescriptorEnum.PI);
    }

    public void PI_() {
        wEntity_(XmlEntityDescriptorEnum.PI);
    }

    public void _PI() {
        _wEntity(XmlEntityDescriptorEnum.PI);
    }

    public void Instruction() {
        wEntity(XmlEntityDescriptorEnum.Instruction);
    }

    public void Instruction(String value) {
        wEntity(XmlEntityDescriptorEnum.Instruction, value);
    }

    public void Comment() {
        wEntity(XmlEntityDescriptorEnum.Comment);
    }

    public void Comment_() {
        wEntity_(XmlEntityDescriptorEnum.Comment);
    }

    public void _Comment() {
        _wEntity(XmlEntityDescriptorEnum.Comment);
    }

    public void CommentText() {
        wEntity(XmlEntityDescriptorEnum.CommentText);
    }

    public void CommentText(String value) {
        wEntity(XmlEntityDescriptorEnum.CommentText, value);
    }

    public void Element() {
        wEntity(XmlEntityDescriptorEnum.Element);
    }

    public void Element_() {
        wEntity_(XmlEntityDescriptorEnum.Element);
    }

    public void _Element() {
        _wEntity(XmlEntityDescriptorEnum.Element);
    }

    public void Attributes() {
        wEntity(XmlEntityDescriptorEnum.Attributes);
    }

    public void Attributes_() {
        wEntity_(XmlEntityDescriptorEnum.Attributes);
    }

    public void Attributes_(int initialCapacity) {
        wEntity_(XmlEntityDescriptorEnum.Attributes, initialCapacity);
    }

    public void _Attributes() {
        _wEntity(XmlEntityDescriptorEnum.Attributes);
    }

    public void Attribute() {
        wEntity(XmlEntityDescriptorEnum.Attribute);
    }

    public void Attribute_() {
        wEntity_(XmlEntityDescriptorEnum.Attribute);
    }

    public void _Attribute() {
        _wEntity(XmlEntityDescriptorEnum.Attribute);
    }

    public void Name() {
        wEntity(XmlEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(XmlEntityDescriptorEnum.Name, value);
    }

    public void QualifiedName() {
        wEntity(XmlEntityDescriptorEnum.QualifiedName);
    }

    public void QualifiedName_() {
        wEntity_(XmlEntityDescriptorEnum.QualifiedName);
    }

    public void _QualifiedName() {
        _wEntity(XmlEntityDescriptorEnum.QualifiedName);
    }

    public void NameSpace() {
        wEntity(XmlEntityDescriptorEnum.NameSpace);
    }

    public void NameSpace(String value) {
        wEntity(XmlEntityDescriptorEnum.NameSpace, value);
    }

    public void Value() {
        wEntity(XmlEntityDescriptorEnum.Value);
    }

    public void Value(String value) {
        wEntity(XmlEntityDescriptorEnum.Value, value);
    }

    public void Content() {
        wEntity(XmlEntityDescriptorEnum.Content);
    }

    public void Content_() {
        wEntity_(XmlEntityDescriptorEnum.Content);
    }

    public void Content_(int initialCapacity) {
        wEntity_(XmlEntityDescriptorEnum.Content, initialCapacity);
    }

    public void _Content() {
        _wEntity(XmlEntityDescriptorEnum.Content);
    }

    public void CharData() {
        wEntity(XmlEntityDescriptorEnum.CharData);
    }

    public void CharData(String value) {
        wEntity(XmlEntityDescriptorEnum.CharData, value);
    }

    public void CDataSect() {
        wEntity(XmlEntityDescriptorEnum.CDataSect);
    }

    public void CDataSect_() {
        wEntity_(XmlEntityDescriptorEnum.CDataSect);
    }

    public void CDataSect_(int initialCapacity) {
        wEntity_(XmlEntityDescriptorEnum.CDataSect, initialCapacity);
    }

    public void _CDataSect() {
        _wEntity(XmlEntityDescriptorEnum.CDataSect);
    }

    public void CDataSectData() {
        wEntity(XmlEntityDescriptorEnum.CDataSectData);
    }

    public void CDataSectData(String value) {
        wEntity(XmlEntityDescriptorEnum.CDataSectData, value);
    }
}
