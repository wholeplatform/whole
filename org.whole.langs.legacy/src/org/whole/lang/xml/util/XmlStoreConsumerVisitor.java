/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.xml.util;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.model.Element;
import org.whole.lang.xml.model.Name;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.XmlTraverseAllVisitor;

/**
 * @author Riccardo Solmi, Matteo Necci
 */
public class XmlStoreConsumerVisitor extends XmlTraverseAllVisitor {
	private IBuilder targetBuilder;
	private IBindingManager bindings;
	private Map<String, EntityDescriptorEnum> entityDescriptorEnumMap = new HashMap<String, EntityDescriptorEnum>();
	private EntityDescriptorEnum entityDescriptorEnumDefault = null;
	private EntityDescriptor<?> entityDescriptor;
	private String valueAttr = null;
	private String initialCapacityAttr = null;

	public XmlStoreConsumerVisitor(IBuilderOperation targetOperation) {
		targetBuilder = targetOperation.wGetBuilder(CommonsLanguageKit.URI);//FIXME generic call
		this.bindings = targetOperation.getBindings();
	}

	public String getContextURI() {
		return bindings != null && bindings.wIsSet("contextURI") ?
				bindings.wStringValue("contextURI") : null;
	}

	protected EntityDescriptorEnum getEntityDescriptorEnum(String uri) {
		return ReflectionFactory.getLanguageKit(uri, true, getContextURI()).getEntityDescriptorEnum();
	}

	protected EntityDescriptor<?> getEntityDescriptor(String name) {
		return getEntityDescriptor(entityDescriptorEnumDefault, name);
	}
	protected EntityDescriptor<?> getEntityDescriptor(EntityDescriptorEnum edEnum, String name) {
		EntityDescriptor<?> ed = edEnum.valueOf(name);
		if (ed == null)
			throw new IllegalArgumentException("Missing entity type \""+name+"\" from \""+
					edEnum.getLanguageKit().getName()+"\" language");
		return ed;
	}
	
	public void visit(Document entity) {
		entity.getElement().accept(this);
	}

	public void visit(Element entity) {
//		bManager.enterScope();
		entity.getAttributes().accept(this);
		entity.getTag().accept(this);

		if (entity.getContent().wIsEmpty() && initialCapacityAttr == null) {
			if (valueAttr != null) {
				buildLeaf(entity);		
				valueAttr = null;
			} else 
				targetBuilder.wEntity(entityDescriptor);
		} else {
			buildStructure(entity);
		}
//		bManager.exitScope();
	}

	public void visit(QualifiedName entity) {
		String nameSpace = entity.getNameSpace().wStringValue();
		String qualifiedString = entity.getName().wStringValue();
		EntityDescriptorEnum edEnum = (EntityDescriptorEnum) entityDescriptorEnumMap.get(nameSpace);
		entityDescriptor = getEntityDescriptor(edEnum, qualifiedString);
	}

	public void visit(Name entity) {
		entityDescriptor = getEntityDescriptor(entity.getValue());
	}	

	public void visit(Attribute entity) {
		IEntity name = entity.getName();
		switch (name.wGetEntityDescriptor().getOrdinal()) {
		case XmlEntityDescriptorEnum.Name_ord:
			if (name.wStringValue().equals("value"))
				valueAttr = entity.getValue().wStringValue();
			if (name.wStringValue().equals("initialCapacity"))
				initialCapacityAttr = entity.getValue().wStringValue();
			if (name.wStringValue().equals("xmlns")) {
				entityDescriptorEnumDefault = getEntityDescriptorEnum(entity.getValue().wStringValue());
			}
			break;
		case XmlEntityDescriptorEnum.QualifiedName_ord:
			QualifiedName qName = (QualifiedName)name;
			if (qName.getNameSpace().wStringValue().equals("xmlns")) {
				String descrString = qName.getName().wStringValue();
				if (!entityDescriptorEnumMap.containsKey(descrString))
					entityDescriptorEnumMap.put(descrString, getEntityDescriptorEnum(entity.getValue().wStringValue()));
			}
			break;
		}
	}

	private void buildLeaf(Element entity) {
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(entityDescriptor, DataTypeParsers.PERSISTENCE);
		switch (entityDescriptor.getDataKind()) {
		case BOOLEAN:
			targetBuilder.wEntity(entityDescriptor, parser.parseBoolean(entityDescriptor, valueAttr));
			break;
		case BYTE:
			targetBuilder.wEntity(entityDescriptor, parser.parseByte(entityDescriptor, valueAttr));
			break;
		case CHAR:
			targetBuilder.wEntity(entityDescriptor, parser.parseChar(entityDescriptor, valueAttr));
			break;
		case DATE:
			targetBuilder.wEntity(entityDescriptor, parser.parseDate(entityDescriptor, valueAttr));
			break;
		case DOUBLE:
			targetBuilder.wEntity(entityDescriptor, parser.parseDouble(entityDescriptor, valueAttr));
			break;
		case FLOAT:
			targetBuilder.wEntity(entityDescriptor, parser.parseFloat(entityDescriptor, valueAttr));
			break;
		case INT:
			targetBuilder.wEntity(entityDescriptor, parser.parseInt(entityDescriptor, valueAttr));
			break;
		case LONG:
			targetBuilder.wEntity(entityDescriptor, parser.parseLong(entityDescriptor, valueAttr));
			break;
		case SHORT:
			targetBuilder.wEntity(entityDescriptor, parser.parseShort(entityDescriptor, valueAttr));
			break;
		case STRING:
			targetBuilder.wEntity(entityDescriptor, parser.parseString(entityDescriptor, valueAttr));
			break;
		case OBJECT:
			targetBuilder.wEntity(entityDescriptor, parser.parseObject(entityDescriptor, valueAttr));
			break;
		case ENUM_VALUE:
			targetBuilder.wEntity(entityDescriptor, parser.parseEnumValue(entityDescriptor, valueAttr));
			break;
		}
	}
	
	private void buildStructure(Element entity) {
		EntityDescriptor<?> ed = entityDescriptor;
		if (initialCapacityAttr == null) {
			targetBuilder.wEntity_(ed);
			entity.getContent().accept(this);
			targetBuilder._wEntity(ed);			
		} else {
			int initialCapacity = Integer.valueOf(initialCapacityAttr).intValue();
			initialCapacityAttr = null;
			targetBuilder.wEntity_(ed, initialCapacity);
			entity.getContent().accept(this);
			targetBuilder._wEntity(ed);
		}
	}
}
