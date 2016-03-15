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

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class XmlModelContext extends EntityContext {

    public XmlModelContext(IEntity root) {
        super(root);
    }

    public XmlModelContext getProlog() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.prolog);
    }

    public void setProlog(XmlModelContext prolog) {
        wSet(XmlFeatureDescriptorEnum.prolog, prolog);
    }

    public XmlModelContext getElement() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.element);
    }

    public void setElement(XmlModelContext element) {
        wSet(XmlFeatureDescriptorEnum.element, element);
    }

    public XmlModelContext getXmlDecl() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.xmlDecl);
    }

    public void setXmlDecl(XmlModelContext xmlDecl) {
        wSet(XmlFeatureDescriptorEnum.xmlDecl, xmlDecl);
    }

    public XmlModelContext getDocTypeDecl() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.docTypeDecl);
    }

    public void setDocTypeDecl(XmlModelContext docTypeDecl) {
        wSet(XmlFeatureDescriptorEnum.docTypeDecl, docTypeDecl);
    }

    public XmlModelContext getMisc() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.misc);
    }

    public void setMisc(XmlModelContext misc) {
        wSet(XmlFeatureDescriptorEnum.misc, misc);
    }

    public XmlModelContext getVersion() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.version);
    }

    public void setVersion(XmlModelContext version) {
        wSet(XmlFeatureDescriptorEnum.version, version);
    }

    public XmlModelContext getEncoding() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.encoding);
    }

    public void setEncoding(XmlModelContext encoding) {
        wSet(XmlFeatureDescriptorEnum.encoding, encoding);
    }

    public XmlModelContext getStandalone() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.standalone);
    }

    public void setStandalone(XmlModelContext standalone) {
        wSet(XmlFeatureDescriptorEnum.standalone, standalone);
    }

    public XmlModelContext getName() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.name);
    }

    public void setName(XmlModelContext name) {
        wSet(XmlFeatureDescriptorEnum.name, name);
    }

    public XmlModelContext getExternalId() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.externalId);
    }

    public void setExternalId(XmlModelContext externalId) {
        wSet(XmlFeatureDescriptorEnum.externalId, externalId);
    }

    public XmlModelContext getSystemLiteral() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.systemLiteral);
    }

    public void setSystemLiteral(XmlModelContext systemLiteral) {
        wSet(XmlFeatureDescriptorEnum.systemLiteral, systemLiteral);
    }

    public XmlModelContext getPubidLiteral() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.pubidLiteral);
    }

    public void setPubidLiteral(XmlModelContext pubidLiteral) {
        wSet(XmlFeatureDescriptorEnum.pubidLiteral, pubidLiteral);
    }

    public XmlModelContext getInstruction() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.instruction);
    }

    public void setInstruction(XmlModelContext instruction) {
        wSet(XmlFeatureDescriptorEnum.instruction, instruction);
    }

    public XmlModelContext getText() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.text);
    }

    public void setText(XmlModelContext text) {
        wSet(XmlFeatureDescriptorEnum.text, text);
    }

    public XmlModelContext getTag() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.tag);
    }

    public void setTag(XmlModelContext tag) {
        wSet(XmlFeatureDescriptorEnum.tag, tag);
    }

    public XmlModelContext getAttributes() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.attributes);
    }

    public void setAttributes(XmlModelContext attributes) {
        wSet(XmlFeatureDescriptorEnum.attributes, attributes);
    }

    public XmlModelContext getContent() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.content);
    }

    public void setContent(XmlModelContext content) {
        wSet(XmlFeatureDescriptorEnum.content, content);
    }

    public XmlModelContext getValue() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.value);
    }

    public void setValue(XmlModelContext value) {
        wSet(XmlFeatureDescriptorEnum.value, value);
    }

    public XmlModelContext getNameSpace() {
        return (XmlModelContext) wGet(XmlFeatureDescriptorEnum.nameSpace);
    }

    public void setNameSpace(XmlModelContext nameSpace) {
        wSet(XmlFeatureDescriptorEnum.nameSpace, nameSpace);
    }
}
