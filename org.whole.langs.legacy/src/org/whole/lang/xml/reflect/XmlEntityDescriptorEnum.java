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

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class XmlEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Document_ord = 0;
    public static final int Prolog_ord = 1;
    public static final int XMLDecl_ord = 2;
    public static final int Version_ord = 3;
    public static final int Encoding_ord = 4;
    public static final int Standalone_ord = 5;
    public static final int DocTypeDecl_ord = 6;
    public static final int SystemId_ord = 7;
    public static final int SystemLiteral_ord = 8;
    public static final int PublicId_ord = 9;
    public static final int PubidLiteral_ord = 10;
    public static final int Misc_ord = 11;
    public static final int PI_ord = 12;
    public static final int Instruction_ord = 13;
    public static final int Comment_ord = 14;
    public static final int CommentText_ord = 15;
    public static final int Element_ord = 16;
    public static final int Attributes_ord = 17;
    public static final int Attribute_ord = 18;
    public static final int Name_ord = 19;
    public static final int QualifiedName_ord = 20;
    public static final int NameSpace_ord = 21;
    public static final int Value_ord = 22;
    public static final int Content_ord = 23;
    public static final int CharData_ord = 24;
    public static final int CDataSect_ord = 25;
    public static final int CDataSectData_ord = 26;
    public static final int IContent_ord = 27;
    public static final int IExternalId_ord = 28;
    public static final int IMisc_ord = 29;
    public static final int IName_ord = 30;
    public static final XmlEntityDescriptorEnum instance = new XmlEntityDescriptorEnum();
    public static final EntityDescriptor<Document> Document = (EntityDescriptor<Document>) instance.valueOf(Document_ord);
    public static final EntityDescriptor<Prolog> Prolog = (EntityDescriptor<Prolog>) instance.valueOf(Prolog_ord);
    public static final EntityDescriptor<XMLDecl> XMLDecl = (EntityDescriptor<XMLDecl>) instance.valueOf(XMLDecl_ord);
    public static final EntityDescriptor<Version> Version = (EntityDescriptor<Version>) instance.valueOf(Version_ord);
    public static final EntityDescriptor<Encoding> Encoding = (EntityDescriptor<Encoding>) instance.valueOf(Encoding_ord);
    public static final EntityDescriptor<Standalone> Standalone = (EntityDescriptor<Standalone>) instance.valueOf(Standalone_ord);
    public static final EntityDescriptor<DocTypeDecl> DocTypeDecl = (EntityDescriptor<DocTypeDecl>) instance.valueOf(DocTypeDecl_ord);
    public static final EntityDescriptor<SystemId> SystemId = (EntityDescriptor<SystemId>) instance.valueOf(SystemId_ord);
    public static final EntityDescriptor<SystemLiteral> SystemLiteral = (EntityDescriptor<SystemLiteral>) instance.valueOf(SystemLiteral_ord);
    public static final EntityDescriptor<PublicId> PublicId = (EntityDescriptor<PublicId>) instance.valueOf(PublicId_ord);
    public static final EntityDescriptor<PubidLiteral> PubidLiteral = (EntityDescriptor<PubidLiteral>) instance.valueOf(PubidLiteral_ord);
    public static final EntityDescriptor<Misc> Misc = (EntityDescriptor<Misc>) instance.valueOf(Misc_ord);
    public static final EntityDescriptor<PI> PI = (EntityDescriptor<PI>) instance.valueOf(PI_ord);
    public static final EntityDescriptor<Instruction> Instruction = (EntityDescriptor<Instruction>) instance.valueOf(Instruction_ord);
    public static final EntityDescriptor<Comment> Comment = (EntityDescriptor<Comment>) instance.valueOf(Comment_ord);
    public static final EntityDescriptor<CommentText> CommentText = (EntityDescriptor<CommentText>) instance.valueOf(CommentText_ord);
    public static final EntityDescriptor<Element> Element = (EntityDescriptor<Element>) instance.valueOf(Element_ord);
    public static final EntityDescriptor<Attributes> Attributes = (EntityDescriptor<Attributes>) instance.valueOf(Attributes_ord);
    public static final EntityDescriptor<Attribute> Attribute = (EntityDescriptor<Attribute>) instance.valueOf(Attribute_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<QualifiedName> QualifiedName = (EntityDescriptor<QualifiedName>) instance.valueOf(QualifiedName_ord);
    public static final EntityDescriptor<NameSpace> NameSpace = (EntityDescriptor<NameSpace>) instance.valueOf(NameSpace_ord);
    public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance.valueOf(Value_ord);
    public static final EntityDescriptor<Content> Content = (EntityDescriptor<Content>) instance.valueOf(Content_ord);
    public static final EntityDescriptor<CharData> CharData = (EntityDescriptor<CharData>) instance.valueOf(CharData_ord);
    public static final EntityDescriptor<CDataSect> CDataSect = (EntityDescriptor<CDataSect>) instance.valueOf(CDataSect_ord);
    public static final EntityDescriptor<CDataSectData> CDataSectData = (EntityDescriptor<CDataSectData>) instance.valueOf(CDataSectData_ord);
    public static final EntityDescriptor<IContent> IContent = (EntityDescriptor<IContent>) instance.valueOf(IContent_ord);
    public static final EntityDescriptor<IExternalId> IExternalId = (EntityDescriptor<IExternalId>) instance.valueOf(IExternalId_ord);
    public static final EntityDescriptor<IMisc> IMisc = (EntityDescriptor<IMisc>) instance.valueOf(IMisc_ord);
    public static final EntityDescriptor<IName> IName = (EntityDescriptor<IName>) instance.valueOf(IName_ord);

    private XmlEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Document_ord, "Document", Document.class, false).withFeature(XmlFeatureDescriptorEnum.prolog, Prolog_ord).withFeature(XmlFeatureDescriptorEnum.element, Element_ord);
        putSimpleEntity(Prolog_ord, "Prolog", Prolog.class, false).withFeature(XmlFeatureDescriptorEnum.xmlDecl, XMLDecl_ord, true, false, false, false, false).withFeature(XmlFeatureDescriptorEnum.docTypeDecl, DocTypeDecl_ord, true, false, false, false, false).withFeature(XmlFeatureDescriptorEnum.misc, Misc_ord, true, false, false, false, false);
        putSimpleEntity(XMLDecl_ord, "XMLDecl", XMLDecl.class, false).withFeature(XmlFeatureDescriptorEnum.version, Version_ord).withFeature(XmlFeatureDescriptorEnum.encoding, Encoding_ord, true, false, false, false, false).withFeature(XmlFeatureDescriptorEnum.standalone, Standalone_ord, true, false, false, false, false);
        putDataEntity(Version_ord, "Version", Version.class, false, String.class);
        putDataEntity(Encoding_ord, "Encoding", Encoding.class, false, String.class);
        putDataEntity(Standalone_ord, "Standalone", Standalone.class, false, boolean.class);
        putSimpleEntity(DocTypeDecl_ord, "DocTypeDecl", DocTypeDecl.class, false).withFeature(XmlFeatureDescriptorEnum.name, IName_ord).withFeature(XmlFeatureDescriptorEnum.externalId, IExternalId_ord, true, false, false, false, false);
        putSimpleEntity(SystemId_ord, "SystemId", SystemId.class, false).withFeature(XmlFeatureDescriptorEnum.systemLiteral, SystemLiteral_ord);
        putDataEntity(SystemLiteral_ord, "SystemLiteral", SystemLiteral.class, false, String.class);
        putSimpleEntity(PublicId_ord, "PublicId", PublicId.class, false).withFeature(XmlFeatureDescriptorEnum.pubidLiteral, PubidLiteral_ord).withFeature(XmlFeatureDescriptorEnum.systemLiteral, SystemLiteral_ord);
        putDataEntity(PubidLiteral_ord, "PubidLiteral", PubidLiteral.class, false, String.class);
        putCompositeEntity(
		Misc_ord, "Misc", Misc.class, false, IMisc_ord, true, false);
        putSimpleEntity(PI_ord, "PI", PI.class, false).withFeature(XmlFeatureDescriptorEnum.name, IName_ord).withFeature(XmlFeatureDescriptorEnum.instruction, Instruction_ord);
        putDataEntity(Instruction_ord, "Instruction", Instruction.class, false, String.class);
        putSimpleEntity(Comment_ord, "Comment", Comment.class, false).withFeature(XmlFeatureDescriptorEnum.text, CommentText_ord);
        putDataEntity(CommentText_ord, "CommentText", CommentText.class, false, String.class);
        putSimpleEntity(Element_ord, "Element", Element.class, false).withFeature(XmlFeatureDescriptorEnum.tag, IName_ord).withFeature(XmlFeatureDescriptorEnum.attributes, Attributes_ord, true, false, false, false, false).withFeature(XmlFeatureDescriptorEnum.content, IContent_ord, true, false, false, false, false);
        putCompositeEntity(
		Attributes_ord, "Attributes", Attributes.class, false, Attribute_ord, true, true);
        putSimpleEntity(Attribute_ord, "Attribute", Attribute.class, false).withFeature(XmlFeatureDescriptorEnum.name, IName_ord, false, true, false, false, false).withFeature(XmlFeatureDescriptorEnum.value, Value_ord);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putSimpleEntity(QualifiedName_ord, "QualifiedName", QualifiedName.class, false).withFeature(XmlFeatureDescriptorEnum.nameSpace, NameSpace_ord, false, true, false, false, false).withFeature(XmlFeatureDescriptorEnum.name, Name_ord, false, true, false, false, false);
        putDataEntity(NameSpace_ord, "NameSpace", NameSpace.class, false, String.class);
        putDataEntity(Value_ord, "Value", Value.class, false, String.class);
        putCompositeEntity(
		Content_ord, "Content", Content.class, false, IContent_ord, true, false);
        putDataEntity(CharData_ord, "CharData", CharData.class, false, String.class);
        putCompositeEntity(
		CDataSect_ord, "CDataSect", CDataSect.class, false, CDataSectData_ord, true, false);
        putDataEntity(CDataSectData_ord, "CDataSectData", CDataSectData.class, false, String.class);
        putSimpleEntity(IContent_ord, "IContent", IContent.class, true, Comment_ord, PI_ord, CharData_ord, CDataSect_ord, Content_ord, Element_ord);
        putSimpleEntity(IExternalId_ord, "IExternalId", IExternalId.class, true, PublicId_ord, SystemId_ord);
        putSimpleEntity(IMisc_ord, "IMisc", IMisc.class, true, Comment_ord, PI_ord);
        putSimpleEntity(IName_ord, "IName", IName.class, true, QualifiedName_ord, Name_ord);
    }
}
