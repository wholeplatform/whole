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
package org.whole.lang.xsd.builders;

import static org.whole.lang.xsd.builders.utils.AttributesMatcherFactory.containsReferenceAttribute;
import static org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum.*;
import static org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum.*;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xml.util.XmlUtils;
import org.whole.lang.xsd.builders.utils.MappingContext;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani
 */
public class XmlSpecific2XsdBuilderAdapter extends XmlSpecific2XsiBuilderAdapter {
	
	public XmlSpecific2XsdBuilderAdapter(IBuilderOperation op, IBindingManager bm) {
		super(op, bm);
	}

	@Override
	public MappingContext elementEntity_(EntityDescriptor<?> context, QName name, Attributes attributes) {
		if (containsReferenceAttribute(attributes)) {
			EntityDescriptor<?> ed = null;

			if (Particles.equals(context) && matches("element", name))
				ed = ElementRef;
			else if (matches("attribute", name))
				ed = AttributeUseRef;
			else if (matches("attributeGroup", name))
				ed = AttributeGroupRef;
			else if (matches("group", name))
				ed = ModelGroupRef;

			FeatureDescriptor fd = calculateFeatureDescriptor(context, name);
			if (!EntityUtils.isComposite(context))
				builder.wFeature(fd);

			builder.wEntity_(ed);
			attributeEntities(ed, attributes);
			return MappingContext.create(ed, fd, false);
		} else
			return super.elementEntity_(context, name, attributes);
	}
	private final boolean matches(String name, QName tag) {
		return name.equals(tag.getLocalPart()) &&
		NamespaceUtils.isXsdNamespace(tag.getNamespaceURI());
	}

	@Override
	protected void anyAttributeEntities(EntityDescriptor<?> context, Attributes anyAttributes) {
		builder.wFeature(attributes);
		builder.wEntity_(Attributes, 0);
		for (int i=0, size=anyAttributes.wSize(); i<size; i++)
			anyAttributeEntity(context, (org.whole.lang.xml.model.Attribute) anyAttributes.wGet(i));
		builder._wEntity(Attributes);
	}

	@Override
	protected void attributeEntity(FeatureDescriptor fd, EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case  Bounded_ord:
		case Unbounded_ord:
			if ("unbounded".equals(value)) {
				builder.wFeature(fd);
				builder.wEntity(Unbounded);
			} else
				super.attributeEntity(fd, Bounded, value);
			break;

		case NamespaceSpecs_ord:
			builder.wFeature(fd);
			if ("##any".equals(value))
				builder.wEntity(AnyNamespaceSpecs);
			else if ("##other".equals(value))
				builder.wEntity(OtherNamespaceSpecs);
			else {
				builder.wEntity_(NamespaceSpecsList);
				for (String namespaceSpec : value.split("\\s+")) {
					if ("##targetNamespace".equals(namespaceSpec))
						builder.wEntity(TargetNamespaceSpec);
					else if ("##local".equals(namespaceSpec))
						builder.wEntity(LocalNamespaceSpec);
					else
						builder.wEntity(AnyURI, namespaceSpec);
				}
				builder._wEntity(NamespaceSpecsList);
			}
			break;

		case MemberTypes_ord:
			builder.wFeature(fd);
			builder.wEntity_(MemberTypes);
			for (String memeberType : value.split("\\s+"))
				builder.wEntity(QName, memeberType);
			builder._wEntity(MemberTypes);
			break;

		case DerivationSet_ord:
			builder.wFeature(fd);
			if ("#all".equals(value))
				builder.wEntity(DerivationAll);
			else {
				builder.wEntity_(DerivationList);
				if (!XmlUtils.isIgnorableWhitespace(value))
					for (String derivationControl : value.split("\\s+"))
						builder.wEntity(DerivationControl, derivationControl);
				builder._wEntity(DerivationList);
			}
			break;

		default:
			super.attributeEntity(fd, ed, value);
		}
	}

	protected void buildEntityNamespaceDecls(EntityDescriptor<?> context) {
		if (context.has(namespaces)) {
			builder.wEntity_(NamespaceDecls);
			for (String prefix : ns.wLocalNames()) {
				builder.wEntity_(NamespaceDecl);

				if (NamespaceUtils.isDefaultNamespacePrefix(prefix))
					builder.wEntity(CommonsEntityDescriptorEnum.Resolver);
				else
					builder.wEntity(Name, prefix);
				builder.wEntity(AnyURI, ns.wStringValue(prefix));

				builder._wEntity(NamespaceDecl);
			}
			builder._wEntity(NamespaceDecls);
		}
	}

	@Override
	protected void attributeEntities(EntityDescriptor<?> context, Attributes attributes) {
		// adds namespace declarations
		buildEntityNamespaceDecls(context);

		//FIXME workaround, must implement mapping of xml:lang attribute
		if (Schema.equals(context) || Documentation.equals(context)) {
			QualifiedName name = Matcher.find(
					XmlEntityFactory.instance.createQualifiedName(
							CommonsEntityAdapterFactory.createVariable(XmlEntityDescriptorEnum.NameSpace, "prefix"),
							XmlEntityFactory.instance.createName("lang")), attributes, false);
			if (name != null)
				attributes.wRemove(name.wGetParent());
		}
		
		super.attributeEntities(context, attributes);
	}

	protected org.whole.lang.xml.model.Element normalizeXmlFragment(org.whole.lang.xml.model.Element xmlFragment) {
		xmlFragment.accept(new XmlFragmentNormalizer());
		return xmlFragment;
	}
}
