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
package org.whole.lang.xml.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.xml.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class XmlEntityFactory extends GenericEntityFactory {
    public static final XmlEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static XmlEntityFactory instance(IEntityRegistryProvider provider) {
        return new XmlEntityFactory(provider);
    }

    protected XmlEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Document createDocument() {
        return create(XmlEntityDescriptorEnum.Document);
    }

    public Document createDocument(Prolog prolog, Element element) {
        return create(XmlEntityDescriptorEnum.Document, prolog, element);
    }

    public IEntityBuilder<Document> buildDocument() {
        return new EntityBuilder<Document>(create(XmlEntityDescriptorEnum.Document));
    }

    public Prolog createProlog() {
        return create(XmlEntityDescriptorEnum.Prolog);
    }

    public Prolog createProlog(XMLDecl xmlDecl, DocTypeDecl docTypeDecl, Misc misc) {
        return create(XmlEntityDescriptorEnum.Prolog, xmlDecl, docTypeDecl, misc);
    }

    public IEntityBuilder<Prolog> buildProlog() {
        return new EntityBuilder<Prolog>(create(XmlEntityDescriptorEnum.Prolog));
    }

    public XMLDecl createXMLDecl() {
        return create(XmlEntityDescriptorEnum.XMLDecl);
    }

    public XMLDecl createXMLDecl(Version version, Encoding encoding, Standalone standalone) {
        return create(XmlEntityDescriptorEnum.XMLDecl, version, encoding, standalone);
    }

    public IEntityBuilder<XMLDecl> buildXMLDecl() {
        return new EntityBuilder<XMLDecl>(create(XmlEntityDescriptorEnum.XMLDecl));
    }

    public Version createVersion() {
        return create(XmlEntityDescriptorEnum.Version);
    }

    public Version createVersion(String value) {
        return create(XmlEntityDescriptorEnum.Version, value);
    }

    public Encoding createEncoding() {
        return create(XmlEntityDescriptorEnum.Encoding);
    }

    public Encoding createEncoding(String value) {
        return create(XmlEntityDescriptorEnum.Encoding, value);
    }

    public Standalone createStandalone() {
        return create(XmlEntityDescriptorEnum.Standalone);
    }

    public Standalone createStandalone(boolean value) {
        return create(XmlEntityDescriptorEnum.Standalone, value);
    }

    public DocTypeDecl createDocTypeDecl() {
        return create(XmlEntityDescriptorEnum.DocTypeDecl);
    }

    public DocTypeDecl createDocTypeDecl(IName name, IExternalId externalId) {
        return create(XmlEntityDescriptorEnum.DocTypeDecl, name, externalId);
    }

    public IEntityBuilder<DocTypeDecl> buildDocTypeDecl() {
        return new EntityBuilder<DocTypeDecl>(create(XmlEntityDescriptorEnum.DocTypeDecl));
    }

    public SystemId createSystemId() {
        return create(XmlEntityDescriptorEnum.SystemId);
    }

    public SystemId createSystemId(SystemLiteral systemLiteral) {
        return create(XmlEntityDescriptorEnum.SystemId, systemLiteral);
    }

    public SystemLiteral createSystemLiteral() {
        return create(XmlEntityDescriptorEnum.SystemLiteral);
    }

    public SystemLiteral createSystemLiteral(String value) {
        return create(XmlEntityDescriptorEnum.SystemLiteral, value);
    }

    public PublicId createPublicId() {
        return create(XmlEntityDescriptorEnum.PublicId);
    }

    public PublicId createPublicId(PubidLiteral pubidLiteral, SystemLiteral systemLiteral) {
        return create(XmlEntityDescriptorEnum.PublicId, pubidLiteral, systemLiteral);
    }

    public IEntityBuilder<PublicId> buildPublicId() {
        return new EntityBuilder<PublicId>(create(XmlEntityDescriptorEnum.PublicId));
    }

    public PubidLiteral createPubidLiteral() {
        return create(XmlEntityDescriptorEnum.PubidLiteral);
    }

    public PubidLiteral createPubidLiteral(String value) {
        return create(XmlEntityDescriptorEnum.PubidLiteral, value);
    }

    public Misc createMisc() {
        return create(XmlEntityDescriptorEnum.Misc);
    }

    public Misc createMisc(IMisc... entities) {
        return create(XmlEntityDescriptorEnum.Misc, (IEntity[]) entities);
    }

    public Misc createMisc(int initialSize) {
        return clone(XmlEntityDescriptorEnum.Misc, initialSize);
    }

    public PI createPI() {
        return create(XmlEntityDescriptorEnum.PI);
    }

    public PI createPI(IName name, Instruction instruction) {
        return create(XmlEntityDescriptorEnum.PI, name, instruction);
    }

    public IEntityBuilder<PI> buildPI() {
        return new EntityBuilder<PI>(create(XmlEntityDescriptorEnum.PI));
    }

    public Instruction createInstruction() {
        return create(XmlEntityDescriptorEnum.Instruction);
    }

    public Instruction createInstruction(String value) {
        return create(XmlEntityDescriptorEnum.Instruction, value);
    }

    public Comment createComment() {
        return create(XmlEntityDescriptorEnum.Comment);
    }

    public Comment createComment(CommentText text) {
        return create(XmlEntityDescriptorEnum.Comment, text);
    }

    public CommentText createCommentText() {
        return create(XmlEntityDescriptorEnum.CommentText);
    }

    public CommentText createCommentText(String value) {
        return create(XmlEntityDescriptorEnum.CommentText, value);
    }

    public Element createElement() {
        return create(XmlEntityDescriptorEnum.Element);
    }

    public Element createElement(IName tag, Attributes attributes, IContent content) {
        return create(XmlEntityDescriptorEnum.Element, tag, attributes, content);
    }

    public IEntityBuilder<Element> buildElement() {
        return new EntityBuilder<Element>(create(XmlEntityDescriptorEnum.Element));
    }

    public Attributes createAttributes() {
        return create(XmlEntityDescriptorEnum.Attributes);
    }

    public Attributes createAttributes(Attribute... entities) {
        return create(XmlEntityDescriptorEnum.Attributes, (IEntity[]) entities);
    }

    public Attributes createAttributes(int initialSize) {
        return clone(XmlEntityDescriptorEnum.Attributes, initialSize);
    }

    public Attribute createAttribute() {
        return create(XmlEntityDescriptorEnum.Attribute);
    }

    public Attribute createAttribute(IName name, Value value) {
        return create(XmlEntityDescriptorEnum.Attribute, name, value);
    }

    public IEntityBuilder<Attribute> buildAttribute() {
        return new EntityBuilder<Attribute>(create(XmlEntityDescriptorEnum.Attribute));
    }

    public Name createName() {
        return create(XmlEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(XmlEntityDescriptorEnum.Name, value);
    }

    public QualifiedName createQualifiedName() {
        return create(XmlEntityDescriptorEnum.QualifiedName);
    }

    public QualifiedName createQualifiedName(NameSpace nameSpace, Name name) {
        return create(XmlEntityDescriptorEnum.QualifiedName, nameSpace, name);
    }

    public IEntityBuilder<QualifiedName> buildQualifiedName() {
        return new EntityBuilder<QualifiedName>(create(XmlEntityDescriptorEnum.QualifiedName));
    }

    public NameSpace createNameSpace() {
        return create(XmlEntityDescriptorEnum.NameSpace);
    }

    public NameSpace createNameSpace(String value) {
        return create(XmlEntityDescriptorEnum.NameSpace, value);
    }

    public Value createValue() {
        return create(XmlEntityDescriptorEnum.Value);
    }

    public Value createValue(String value) {
        return create(XmlEntityDescriptorEnum.Value, value);
    }

    public Content createContent() {
        return create(XmlEntityDescriptorEnum.Content);
    }

    public Content createContent(IContent... entities) {
        return create(XmlEntityDescriptorEnum.Content, (IEntity[]) entities);
    }

    public Content createContent(int initialSize) {
        return clone(XmlEntityDescriptorEnum.Content, initialSize);
    }

    public CharData createCharData() {
        return create(XmlEntityDescriptorEnum.CharData);
    }

    public CharData createCharData(String value) {
        return create(XmlEntityDescriptorEnum.CharData, value);
    }

    public CDataSect createCDataSect() {
        return create(XmlEntityDescriptorEnum.CDataSect);
    }

    public CDataSect createCDataSect(CDataSectData... entities) {
        return create(XmlEntityDescriptorEnum.CDataSect, (IEntity[]) entities);
    }

    public CDataSect createCDataSect(int initialSize) {
        return clone(XmlEntityDescriptorEnum.CDataSect, initialSize);
    }

    public CDataSectData createCDataSectData() {
        return create(XmlEntityDescriptorEnum.CDataSectData);
    }

    public CDataSectData createCDataSectData(String value) {
        return create(XmlEntityDescriptorEnum.CDataSectData, value);
    }
}
