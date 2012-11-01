package org.whole.lang.xml.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class XmlIdentitySwitchVisitor extends AbstractVisitor
		implements IXmlVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case XmlEntityDescriptorEnum.Document_ord:
			visit((Document) entity);
			break;
		case XmlEntityDescriptorEnum.Prolog_ord:
			visit((Prolog) entity);
			break;
		case XmlEntityDescriptorEnum.XMLDecl_ord:
			visit((XMLDecl) entity);
			break;
		case XmlEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case XmlEntityDescriptorEnum.Encoding_ord:
			visit((Encoding) entity);
			break;
		case XmlEntityDescriptorEnum.Standalone_ord:
			visit((Standalone) entity);
			break;
		case XmlEntityDescriptorEnum.DocTypeDecl_ord:
			visit((DocTypeDecl) entity);
			break;
		case XmlEntityDescriptorEnum.SystemId_ord:
			visit((SystemId) entity);
			break;
		case XmlEntityDescriptorEnum.SystemLiteral_ord:
			visit((SystemLiteral) entity);
			break;
		case XmlEntityDescriptorEnum.PublicId_ord:
			visit((PublicId) entity);
			break;
		case XmlEntityDescriptorEnum.PubidLiteral_ord:
			visit((PubidLiteral) entity);
			break;
		case XmlEntityDescriptorEnum.Misc_ord:
			visit((Misc) entity);
			break;
		case XmlEntityDescriptorEnum.PI_ord:
			visit((PI) entity);
			break;
		case XmlEntityDescriptorEnum.Instruction_ord:
			visit((Instruction) entity);
			break;
		case XmlEntityDescriptorEnum.Comment_ord:
			visit((Comment) entity);
			break;
		case XmlEntityDescriptorEnum.CommentText_ord:
			visit((CommentText) entity);
			break;
		case XmlEntityDescriptorEnum.Element_ord:
			visit((Element) entity);
			break;
		case XmlEntityDescriptorEnum.Attributes_ord:
			visit((Attributes) entity);
			break;
		case XmlEntityDescriptorEnum.Attribute_ord:
			visit((Attribute) entity);
			break;
		case XmlEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case XmlEntityDescriptorEnum.QualifiedName_ord:
			visit((QualifiedName) entity);
			break;
		case XmlEntityDescriptorEnum.NameSpace_ord:
			visit((NameSpace) entity);
			break;
		case XmlEntityDescriptorEnum.Value_ord:
			visit((Value) entity);
			break;
		case XmlEntityDescriptorEnum.Content_ord:
			visit((Content) entity);
			break;
		case XmlEntityDescriptorEnum.CharData_ord:
			visit((CharData) entity);
			break;
		case XmlEntityDescriptorEnum.CDataSect_ord:
			visit((CDataSect) entity);
			break;
		case XmlEntityDescriptorEnum.CDataSectData_ord:
			visit((CDataSectData) entity);
			break;
		}
	}
}
