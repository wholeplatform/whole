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
package org.whole.lang.xsd.templates;

import static org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum.NSContainer;
import static org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum.maxOccurs;
import static org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum.namespaceSpecs;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class XsdModelTemplate extends XsiModelTemplate {

	public XsdModelTemplate(IEntity model, String encoding) {
		super(model, encoding);
	}

	public XsdModelTemplate(IEntity model) {
		super(model);
	}

	@Override
	protected void applyAttributes(IEntity entity, int fromIndex) {
		// create all namespace declarations
		if (Matcher.isAssignableAsIsFrom(NSContainer, entity)) {//TODO test was isAssignableFrom
			IEntity child = entity.wGet(fromIndex);
			final int size = child.wSize();
			for (int i=0; i<size; i++) {
				IEntity child2 = child.wGet(i);
					createNamespaceDeclaration(getNamespaceDeclPrefix(child2), getNamespaceDeclURI(child2));
			}
			super.applyAttributes(entity, fromIndex+1);
		} else
			super.applyAttributes(entity, fromIndex);
	}

	private final String getNamespaceDeclURI(IEntity entity) {
		return entity.wGet(1).wStringValue();
	}

	private String getNamespaceDeclPrefix(IEntity entity) {
		IEntity child = entity.wGet(0);
		return EntityUtils.isResolver(child) ?
				NamespaceUtils.DEFAULT_NAMESPACE_PREFIX :
					child.wStringValue();
	}

	@Override
	protected boolean hasNamespacePrefix(IEntity entity, String uri) {
		// update namespace prefix map
		if (Matcher.isAssignableAsIsFrom(NSContainer, entity)) {//TODO test was isAssignableFrom
			IEntity child = entity.wGet(0);
			final int size = child.wSize();
			for (int i=0; i<size; i++) {
				IEntity child2 = child.wGet(i);
				putNamespacePrefix(getNamespaceDeclURI(child2), getNamespaceDeclPrefix(child2));
			}
		}
		return true;
	}

	@Override
	protected String getNamespacePrefix(IEntity entity, String uri) {
		try {
			return super.getNamespacePrefix(entity, uri);
		} catch (IllegalArgumentException e) {
			//FIXME workaround for XSD partial models
			return "xsd";
		}
	}

	@Override
	protected boolean needSchemaLocationDeclaration(IMappingStrategy strategy, EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return false;
	}

	@Override
	protected String toAttributeValue(IEntity entity, IMappingStrategy strategy) {
		switch (entity.wGetEntityOrd()) {
		case XsdEntityDescriptorEnum.Unbounded_ord:
			return "unbounded";
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
			return "##any";
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			StringBuilder sb = new StringBuilder();
			int size = entity.wSize();
			for (int i=0; i<size; i++) {
				sb.append(entity.wGet(i).wStringValue());
				if (i < size)
					sb.append(' ');
			}
			return sb.toString();
		case XsdEntityDescriptorEnum.DerivationAll_ord:
			return "#all";
		case XsdEntityDescriptorEnum.DerivationList_ord:
			sb = new StringBuilder();
			size = entity.wSize();
			for (int i=0; i<size; i++) {
				sb.append(entity.wGet(i).wStringValue());
				if (i < size)
					sb.append(' ');
			}
			return sb.toString();
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
			return "##other";
		default:
			return super.toAttributeValue(entity, strategy);
		}
	}

	protected String getElementNCName(IEntity entity) {
		switch (entity.wGetEntityDescriptor().getOrdinal()) {
		case XsdEntityDescriptorEnum.ElementRef_ord:
		case XsdEntityDescriptorEnum.ElementDecl_ord:
			return "element";
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
			return "attribute";
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
			return "attributeGroup";
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			return "group";
		default:
			return super.getElementNCName(entity);
		}
	}

	@Override
	protected String getAttributeNCName(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		if (namespaceSpecs.equals(fd))
			return "namespace";
		else if (maxOccurs.equals(fd))
			return "maxOccurs";
		else
			return super.getAttributeNCName(strategy, context, ed, fd);
	}

	@Override
	protected boolean isElementMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		switch (ed.getOrdinal()) {
		case XsdEntityDescriptorEnum.ElementRef_ord:
		case XsdEntityDescriptorEnum.ElementDecl_ord:
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			return true;
		default:
			return super.isElementMapping(strategy, context, ed, fd);
		}
	}

	@Override
	protected boolean isAttributeMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		switch (ed.getOrdinal()) {
		case XsdEntityDescriptorEnum.Unbounded_ord:
		case XsdEntityDescriptorEnum.Bounded_ord:
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
		case XsdEntityDescriptorEnum.MemberTypes_ord:
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			return true;
		default:
			return super.isAttributeMapping(strategy, context, ed, fd);
		}
	}
}
