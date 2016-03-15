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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.builders.XmlGenericBuilderAdapter;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class XsiModelTemplate extends AbstractVisitor implements ITemplate {
	protected IEntity model;
	protected IXmlBuilder builder;
	protected String encoding;
	protected IBindingManager nsPrefixes;
	protected FreshNameGenerator fnGen;

	public XsiModelTemplate(IEntity model) {
		this(model, "UTF-8");
	}
	public XsiModelTemplate(IEntity model, String encoding) {
		this.model = model;
		this.encoding = encoding;
		nsPrefixes = BindingManagerFactory.instance.createBindingManager();
		fnGen = new FreshNameGenerator();
	}

	protected void putNamespacePrefix(String uri, String prefix) {
		nsPrefixes.wDefValue(uri, prefix);
	}
	protected String getNamespacePrefix(IEntity entity, String uri) {
		if (!hasNamespacePrefix(entity, uri))
			putNamespacePrefix(uri, fnGen.nextFreshName("ns"));//FIXME add a preferred prefix registry
		return nsPrefixes.wStringValue(uri);
	}
	protected boolean hasNamespacePrefix(IEntity entity, String uri) {
		return nsPrefixes.wIsSet(uri);
	}

	protected void addNamespaceDeclaration(IEntity entity, String languageURI) {
		if (!NamespaceUtils.isInternalNamespace(languageURI))
			createNamespaceDeclaration(getNamespacePrefix(entity, languageURI), languageURI);
	}
	protected void addSchemaLocationDeclaration(IEntity entity, String languageURI) {
		if (NamespaceUtils.isInternalNamespace(languageURI))
			createNoNamespaceSchemalLocation(entity, languageURI);
		else
			createSchemalLocation(entity, languageURI);
	}
	protected boolean needSchemaLocationDeclaration(IMappingStrategy strategy, EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		//TODO check for imported or explicitly referenced namespaces when any types are implemented
		// by now testing for a parent RootFragment will suffice
		return CommonsEntityDescriptorEnum.RootFragment.equals(context);
	}

	public void apply(IBuilderOperation operation) {
		IXmlBuilder builder = (IXmlBuilder) operation.wGetBuilder(XmlLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) operation.wGetBuilder(CommonsLanguageKit.URI);

		if (EntityUtils.hasParent(model) && MappingStrategyUtils.hasElementNCName(model)) {
			builder.Document_();
			builder.Prolog_();
			builder.XMLDecl_();
			builder.Version("1.0");
			builder.Encoding(encoding);
			cb.Resolver();
	        builder._XMLDecl();
			cb.Resolver();
			cb.Resolver();
			builder._Prolog();

			apply(builder);

			builder._Document();
		} else
			apply(builder);
	}

	public void apply(IXmlBuilder builder) {
		this.builder = builder;
		visit(model);
	}

	public void visit(IEntity entity) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> adapteeEd = adaptee.wGetEntityDescriptor();

		if (adapteeEd.getLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (adapteeEd.getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
				return;
			case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			case CommonsEntityDescriptorEnum.RootFragment_ord:
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			case CommonsEntityDescriptorEnum.StageUpFragment_ord:
//				String lang = entity.wGetLanguageKit().getURI();
				IEntity root = entity.wGetRoot();
				if (XmlLanguageKit.URI.equals(root.wGetLanguageKit().getURI())) {
					ModelTemplate template = new ModelTemplate(root);
					template.apply(new XmlGenericBuilderAdapter(builder));
				} else
					visit(root);
				return;
			}
		}

		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

		EntityDescriptor<?> context;
		FeatureDescriptor fd;
		String languageURI;

		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(parent) ||
				CommonsEntityDescriptorEnum.RootFragment.equals(parent.wGetEntityDescriptor()) || 
				CommonsEntityDescriptorEnum.StageUpFragment.equals(parent.wGetEntityDescriptor())) {
			context = CommonsEntityDescriptorEnum.RootFragment;
			fd = CommonsFeatureDescriptorEnum.rootEntity;
			// get languageURI from parent entity descriptor but from RootFragment
			languageURI = ed.getLanguageKit().getURI();
		} else {
			context = parent.wGetEntityDescriptor();

			// always skip SameStageFragment parent
			if (CommonsEntityDescriptorEnum.SameStageFragment.equals(context)) {
				IEntity parentParent = parent.wGetParent();
				context = parentParent.wGetEntityDescriptor();
				fd = parentParent.wGetFeatureDescriptor(parent);
				languageURI = context.getLanguageKit().getURI();
			} else {
				fd = parent.wGetFeatureDescriptor(entity);
				languageURI = parent.wGetEntityDescriptor().getLanguageKit().getURI();
			}
		}

		IMappingStrategy strategy = getXsiMappingStrategy(languageURI);

		//FIXME workaround
//		if (!hasNCName(strategy, context, ed, fd)) {
		if (getElementNCName(entity) == null) {
			if (isMixedType(strategy, context, ed))
				builder.CharData(toContentValue(entity, strategy));
			else {
				final int size = entity.wSize();
				for (int i=0; i<size; i++)
					visit(entity.wGet(i));
			}
		} else {
			nsPrefixes.wEnterScope();

			boolean needNamespacePrefix = (strategy.isElementsFormQualified() /*TODO or we are the root of an anyType mapping */) && !NamespaceUtils.isInternalNamespace(languageURI);
			boolean needNamespaceDeclaration = needNamespacePrefix && !hasNamespacePrefix(entity, strategy.getNamespace());

			builder.Element_();

			String tagName = getElementNCName(entity);
			if (needNamespacePrefix) {
				String prefix = getNamespacePrefix(entity, languageURI);
				builder.QualifiedName_();
				builder.NameSpace(prefix);
				builder.Name(tagName);
				builder._QualifiedName();
			} else
				builder.Name(tagName);

			builder.Attributes_();
			if (needNamespaceDeclaration)
				addNamespaceDeclaration(entity, languageURI);
			if (needSchemaLocationDeclaration(strategy, context, ed, fd))
				addSchemaLocationDeclaration(entity, languageURI);

			if (entity.wGetEntityKind().isData()) {
				builder._Attributes();
				builder.CharData(toContentValue(entity, strategy));
			} else {
				applyAttributes(entity, 0);
				builder._Attributes();

				builder.Content_();
				final int size = entity.wSize();
				for (int i=0; i<size; i++) {
					context = entity.wGetEntityDescriptor();
					fd = context.getEntityFeatureDescriptor(i);
					IEntity child = entity.wGet(i);
					ed = child.wGetEntityDescriptor();
					if (!isAttributeMapping(strategy, context, ed, fd)) {
						if (isContentMapping(strategy, context, ed, fd))
							builder.CharData(toContentValue(child, strategy));
						else
							visit(child);
					}
				}
				builder._Content();
			}

			builder._Element();
			nsPrefixes.wExitScope();
		}
	}

	protected void applyAttributes(IEntity entity, int fromIndex) {
		final int size = entity.wSize();
		for (int i=fromIndex; i<size; i++) {
			EntityDescriptor<?> context = entity.wGetEntityDescriptor();
			FeatureDescriptor fd = entity.wGetFeatureDescriptor(i);
			IEntity child = entity.wGet(i);

			EntityDescriptor<?> ed = child.wGetEntityDescriptor();
			String languageURI = ed.getLanguageKit().getURI();

			//FIXME workaround for resolvers and other adapted entities
			if (CommonsLanguageKit.URI.equals(ed.getLanguageKit().getURI())) {
				ed = child.wGetParent().wGetEntityDescriptor();
				languageURI = ed.getLanguageKit().getURI();
			}

			IMappingStrategy strategy = getXsiMappingStrategy(languageURI);
			
			if (isAttributeMapping(strategy, context, ed, fd)) {
				if (!EntityUtils.isResolver(child) || !fd.isOptional()) {
					builder.Attribute_();

					String attrName = getAttributeNCName(strategy, context, ed, fd);
					//TODO add any attribute support
					boolean needNamespacePrefix = strategy.isAttributesFormQualified() && !NamespaceUtils.isInternalNamespace(languageURI);
					if (needNamespacePrefix) {
						String prefix = getNamespacePrefix(child, languageURI);
						builder.QualifiedName_();
						builder.NameSpace(prefix);
						builder.Name(attrName);
						builder._QualifiedName();
					} else
						builder.Name(attrName);

					builder.Value(toAttributeValue(child, strategy));
					builder._Attribute();
				}
			}
		}
	}

	protected String getAttributeNCName(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return strategy.getAttributeNCName(context, ed, fd);
	}
	protected String getElementNCName(IEntity entity) {
		return MappingStrategyUtils.getElementNCName(entity);
	}
	protected boolean hasNCName(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return isElementMapping(strategy, context, ed, fd) || isAttributeMapping(strategy, context, ed, fd);
	}
	protected boolean isElementMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return strategy.isElementMapping(context, ed, fd);
	}
	protected boolean isAttributeMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return strategy.isAttributeMapping(context, ed, fd);
	}
	protected boolean isContentMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return strategy.isContentMapping(context, ed, fd);
	}
	protected boolean isMixedStructuralMapping(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return strategy.isMixedStructuralMapping(context, ed, fd);
	}
	protected boolean isMixedType(IMappingStrategy strategy, EntityDescriptor<?> context,
			EntityDescriptor<?> ed) {
		return strategy.isMixedType(context) && ed.equals(strategy.getMixedDataType());
	}

	protected String toAttributeValue(IEntity entity, IMappingStrategy strategy) {
		switch (entity.wGetEntityKind()) {
		case DATA:
			return toContentValue(entity, strategy);
		case COMPOSITE:
			StringBuilder sb = new StringBuilder();
			
			final int size = entity.wSize();
			for (int i=0; i<size; i++) {
				if (i>0)
					sb.append(' ');
				sb.append(toContentValue(entity.wGet(i), strategy));
			}
			return sb.toString();
		default:
			throw new IllegalStateException("Wrong entity kind");
		}
	}

	protected String toContentValue(IEntity entity, IMappingStrategy strategy) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		DataKinds dataKind = ed.getDataKind();
		if (!dataKind.isNotAData()) {
			IDataTypeParser dataTypeParser = ed.getLanguageKit().getDataTypeParser(DataTypeParsers.PERSISTENCE);
			switch (dataKind) {
			case BOOLEAN:
				return dataTypeParser.unparseBoolean(ed, entity.wBooleanValue());
			case BYTE:
				return dataTypeParser.unparseByte(ed, entity.wByteValue());
			case SHORT:
				return dataTypeParser.unparseShort(ed, entity.wShortValue());
			case INT:
				return dataTypeParser.unparseInt(ed, entity.wIntValue());
			case LONG:
				return dataTypeParser.unparseLong(ed, entity.wLongValue());
			case DOUBLE:
				return dataTypeParser.unparseDouble(ed, entity.wDoubleValue());
			case FLOAT:
				return dataTypeParser.unparseFloat(ed, entity.wFloatValue());
			case STRING:
				return dataTypeParser.unparseString(ed, entity.wStringValue());
			case OBJECT:
				return dataTypeParser.unparseObject(ed, entity.wGetValue());
			case ENUM_VALUE:
				return dataTypeParser.unparseEnumValue(ed, entity.wEnumValue());
			case DATE:
			case CHAR:
			}
		}
		throw new IllegalStateException(WholeMessages.no_data_type);
	}

	protected IMappingStrategy getXsiMappingStrategy(String uri) {
		IMappingStrategy strategy = MappingStrategyUtils.getMappingStrategy(uri);
			if (strategy == null)
				throw new IllegalArgumentException("cannot find a mapping strategy for "+uri);
		return strategy;
	}

	protected void createNamespaceDeclaration(String prefix, String languageURI) {
		// never "xml" namespace declarations
		if (NamespaceUtils.isXmlNamespace(languageURI))
			return;
		builder.Attribute_();
		if (NamespaceUtils.isDefaultNamespacePrefix(prefix))
			builder.Name("xmlns");
		else {
			builder.QualifiedName_();
			builder.NameSpace("xmlns");
			builder.Name(prefix);
			builder._QualifiedName();
		}
		builder.Value(languageURI);
		builder._Attribute();
	}

	protected void createXsiDirective(IEntity entity, String directive, String value) {
		if (!hasNamespacePrefix(entity, NamespaceUtils.XSI_NAMESPACE_URI)) {
			createNamespaceDeclaration("xsi", NamespaceUtils.XSI_NAMESPACE_URI);
			putNamespacePrefix(NamespaceUtils.XSI_NAMESPACE_URI, "xsi");
		}
		builder.Attribute_();

		builder.QualifiedName_();
		builder.NameSpace("xsi");
		builder.Name(directive);
		builder._QualifiedName();

		builder.Value(value);

		builder._Attribute();
	}
	protected void createSchemalLocation(IEntity entity, String languageURI) {
		String schemaLocationURI = getXsiMappingStrategy(languageURI).getSchemaLocation();
		if (schemaLocationURI != null && schemaLocationURI.length() > 0)
			createXsiDirective(entity, "schemaLocation", languageURI+' '+schemaLocationURI);
	}
	protected void createNoNamespaceSchemalLocation(IEntity entity, String languageURI) {
		String schemaLocationURI = getXsiMappingStrategy(languageURI).getSchemaLocation();
		if (schemaLocationURI != null && schemaLocationURI.length() > 0) {
			createXsiDirective(entity, "noNamespaceSchemaLocation", schemaLocationURI);
			putNamespacePrefix(languageURI, "noNamespace");
		}
	}
}
