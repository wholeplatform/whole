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

import static org.whole.lang.xml.reflect.XmlEntityDescriptorEnum.*;
import static org.whole.lang.xsd.mapping.util.MappingStrategyUtils.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.GenericEventTrackingBuilder;
import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.builders.XmlSpecificBuilderAdapter;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.model.Element;
import org.whole.lang.xml.model.IName;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xml.util.XmlUtils;
import org.whole.lang.xsd.builders.utils.AttributesPreprocessor;
import org.whole.lang.xsd.builders.utils.MappingContext;
import org.whole.lang.xsd.builders.utils.MappingContextStack;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsd.util.NamespaceUtils;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Enrico Persiani
 */
public class XmlSpecific2XsiBuilderAdapter extends XmlSpecificBuilderAdapter {
	protected IBuilderOperation op;
	protected IBindingManager ns;
	protected AttributesPreprocessor ap;
	protected GenericEventTrackingBuilder builder;

	public XmlSpecific2XsiBuilderAdapter(IBuilderOperation op, IBindingManager bm) {
		super(new GenericIdentityBuilder());
		wSetBuilderStrategy(new ElementBuilder());
		this.ns = NamespaceUtils.initializeNampespaceBindings(BindingManagerFactory.instance.createBindingManager());
		this.op = op;
		this.ap = new AttributesPreprocessor(bm, ns);
		this.builder = new GenericEventTrackingBuilder(getTargetBuilder(), CommonsEntityDescriptorEnum.RootFragment);
	}

	protected IBuilder getTargetBuilder() {
		return ModelBuilderOperation.ID.equals(op.wGetOperationId()) ?
				op.wGetBuilder(XmlLanguageKit.URI, false) : //FIXME workaround, should use a generic builder
					op.wGetBuilder();
	}

	protected FeatureDescriptor calculateFeatureDescriptor(EntityDescriptor<?> context, QName name) {
		Collection<FeatureDescriptor> fds = getElementFeatureMappings(context, name);
		if (fds.size() > 1) {
			List<FeatureDescriptor> contextFeatures = context.getEntityFeatureDescriptors();
			FeatureDescriptor contextFeature;
			int index = builder.wCurrentIndexOf();
			while (index < contextFeatures.size() && !fds.contains(contextFeature = contextFeatures.get(index)) && contextFeature.isOptional())
				index++;
			return context.getEntityFeatureDescriptor(index);
		} else
			return fds.iterator().next();
	}

	protected MappingContext elementEntity_(EntityDescriptor<?> context, QName name, Attributes attributes) {
		//TODO test!!!
//		EntityDescriptor<?> ed = ap.hasExplicitType() ? ap.getExplicitType() : getElementEntityMapping(context, name);
		EntityDescriptor<?> ed = getElementEntityMapping(context, name);
		if (SchemaUtils.isAnyType(ed))
			ed = getElementEntityMapping(CommonsEntityDescriptorEnum.RootFragment, name);

		if (ed == null)
			throw new IllegalStateException("missing mapping");

		FeatureDescriptor fd = calculateFeatureDescriptor(context, name);
		if (!EntityUtils.isComposite(context))
			builder.wFeature(fd);

		//FIXME abstract/union types
		if (!EntityUtils.isData(ed) && !(ed.isAbstract() && ed.isPolymorphic())) {;//was getConcreteSubtypesInLanguage().size() > 1)) {
			builder.wEntity_(ed);
			attributeEntities(ed, attributes);
		}

		return MappingContext.create(ed, fd, false);
	}

	protected void _elementEntity(EntityDescriptor<?> context) {
		//FIXME unions
		if (!EntityUtils.isData(context) && !(context.isAbstract() && context.isPolymorphic())) {;//was getConcreteSubtypesInLanguage().size() > 1)) {
			// sets an empty string if content entity maps to a string data type
			FeatureDescriptor fd = getContentFeatureMapping(context);
			if (fd != null && builder.wCurrentIndexOf() <= context.indexOf(fd)) {
				EntityDescriptor<?> ed = getContentEntityMapping(context);
	
				//FIXME lists/unions
				if (ed.getDataKind().isString()) {
					builder.wFeature(fd);
					DataTypeUtils.buildFromPersistenceString(builder, ed, "");
				}
			}
			builder._wEntity(context);
		}
	}

	protected void attributeEntities(EntityDescriptor<?> context, Attributes attributes) {
		String uri = context.getLanguageKit().getURI();
		boolean isAttributeFormQualified = MappingStrategyUtils.hasMappingStrategy(uri) &&
		MappingStrategyUtils.getMappingStrategy(uri).isAttributesFormQualified();

		IEntityIterator<Attribute> iterator = IteratorFactory.<Attribute>childIterator();
		iterator.reset(attributes);
		// add attribute features
		while (iterator.hasNext()) {
			Attribute attribute = iterator.next();
			QName name = QName.create(ns, isAttributeFormQualified ? NamespaceUtils.getDefaultNamespace(ns) : uri, attribute.getName());
			String value = attribute.getValue().getValue();
			if (hasAttributeEntityMapping(context, name)) {
				FeatureDescriptor fd = getAttributeFeatureMapping(context, name);
				EntityDescriptor<?> ed = getAttributeEntityMapping(context, name);
				attributeEntity(fd, ed, value);
				iterator.remove();
			}
		}
		// add any attributes feature
		anyAttributeEntities(context, attributes);
	}

	protected void anyAttributeEntities(EntityDescriptor<?> context, Attributes anyAttributes) {
		//TODO implement any attribute mappings
	}
	protected void anyAttributeEntity(EntityDescriptor<?> context, Attribute anyAttribute) {
		builder.wEntity_(CommonsEntityDescriptorEnum.SameStageFragment);
		new ModelTemplate(anyAttribute).apply(builder);
		builder._wEntity(CommonsEntityDescriptorEnum.SameStageFragment);
	}

	protected void attributeEntity(FeatureDescriptor fd, EntityDescriptor<?> ed, String value) {
		builder.wFeature(fd);
		DataTypeUtils.buildFromPersistenceString(builder, ed, value);
	}

	protected void dataEntity(EntityDescriptor<?> context, String value) {
		if (context.isAbstract() && context.isPolymorphic()) {//was getConcreteSubtypesInLanguage().size() > 1) {
			Collection<EntityDescriptor<?>> unionTypes = getUnionEntityMappings(context);
			Iterator<EntityDescriptor<?>> iterator = unionTypes.iterator();
			while (iterator.hasNext()) {
				try {
					dataEntity(iterator.next(), value);
					return;
				} catch (Exception e) {
				}
			}
			throw new IllegalStateException("cannot find a suitable type");
		}

		if (EntityUtils.isData(context))
			DataTypeUtils.buildFromPersistenceString(builder, context, value);
		else if (EntityUtils.isComposite(context)) {
			String[] values = value.split("["+XmlUtils.IGNORABLE_WHITESPACE_CHARS+"]++");
			EntityDescriptor<?> ed = context.getEntityDescriptor(0);
			builder.wEntity_(context);
			for (String v : values)
				dataEntity(ed, v);
			builder._wEntity(context);
		} else {
			EntityDescriptor<?> ed = getContentEntityMapping(context);
			builder.wFeature(getContentFeatureMapping(context));
			DataTypeUtils.buildFromPersistenceString(builder, ed, value);
		}
	}

	protected MappingContext structuralEntity_(EntityDescriptor<?> context, QName name) {
		if (!hasStructuralEntityMapping(context, name))
			return null;

		FeatureDescriptor fd = getStructuralFeatureMapping(context, name);
		EntityDescriptor<?> ed = getStructuralEntityMapping(context, name);
		if (!EntityUtils.isComposite(context))
			builder.wFeature(fd);
		builder.wEntity_(ed);
		return MappingContext.create(ed, fd, true);
	}

	protected MappingContext mixedStructuralEntity_(EntityDescriptor<?> context) {
		if (!hasMixedStructuralMapping(context))
			return null;
		
		FeatureDescriptor fd = getMixedStructuralFeature(context);
		EntityDescriptor<?> ed = getMixedStructuralType(context);
		builder.wFeature(fd);
		builder.wEntity_(ed);
		return MappingContext.create(ed, fd, true, true);
	}

	protected void mixedDataEntity(EntityDescriptor<?> context, int lastChildIndex, String value) {
		EntityDescriptor<?> ed = getMixedDataType(context);
		// find next mixed feature
		if (!EntityUtils.isComposite(context)) {
			for (int i=lastChildIndex, size=context.featureSize(); i<size; i++)
				if (ed.equals(context.getEntityDescriptor(i))) {
					builder.wFeature(context.getEntityFeatureDescriptor(i));
					break;
				}
		}
		builder.wEntity(ed, value);
	}

	protected org.whole.lang.xml.model.Element normalizeXmlFragment(org.whole.lang.xml.model.Element xmlFragment) {
		XmlFragmentNormalizer normalizer = new XmlFragmentNormalizer(true);
		xmlFragment.accept(normalizer);

		// add needed namespace declarations
		XmlEntityFactory xef = XmlEntityFactory.instance;
		IEntity attributes = xmlFragment.getAttributes();
		for (String prefix : normalizer.getNeededNamespaces())
			attributes.wAdd(xef.createAttribute(xef.createQualifiedName(
					xef.createNameSpace("xmlns"), xef.createName(prefix)),
					xef.createValue(ns.wStringValue(prefix))));
		return xmlFragment;
	}

	private final class ElementBuilder extends GenericIdentityBuilder {
		private IName name;
		private MappingContextStack mcs;
		private org.whole.lang.xml.model.Element xmlFragment;

		public ElementBuilder() {
			this.mcs = new MappingContextStack();
		}

		public void wEntity(EntityDescriptor<?> ed) {
			if (ed.getOrdinal() == Attributes_ord)
				mapElementEntity_(XmlEntityFactory.instance.createAttributes(0));
		}

		public void wEntity(EntityDescriptor<?> ed, String value) {
			switch (ed.getOrdinal()) {

			case Name_ord:
				name = (IName) GenericEntityFactory.instance.create(ed, value);
				break;

			case CharData_ord:
				mapElementEntity(value);
			}
		}

		public void wEntity_(EntityDescriptor<?> ed) {
			wEntity_(ed, 0);
		}

		public void wEntity_(EntityDescriptor<?> ed, int initialCapacity) {
			switch (ed.getOrdinal()) {

			case Attributes_ord:
			case QualifiedName_ord:
				wBuildEntity_(ed);
				break;

			case Element_ord:
				ns.wEnterScope();
				break;

			case Content_ord:
				if (isBuildingXmlFragment())
					wBuildEntity_(ed);
			}
		}

		public void _wEntity(EntityDescriptor<?> ed) {
			switch (ed.getOrdinal()) {

			case Attributes_ord:
				Attributes attributes = (Attributes) _wBuildEntity(ed);
				ap.preprocess(attributes);

				mapElementEntity_(attributes);
				break;

			case QualifiedName_ord:
				name = (IName) _wBuildEntity(ed);
				break;

			case Element_ord:
				_mapElementEntity();
				ns.wExitScope();
				break;

			case Content_ord:
				if (isBuildingXmlFragment())
					break;

				// close as many containing element as needed
				while (mcs.isStructural())
					builder._wEntity(mcs.pop().ed);
			}
		}

		protected void mapElementEntity(String value) {
			try {
				MappingContext mc = mcs.peek();
				if (hasMixedContent(mc.ed))
					mixedDataEntity(mc.ed, mc.getLastChildIndex(), value);
				else
					dataEntity(mc.ed, value);
			} catch (Exception e) {
				xmlContent(value);
			}
		}

		protected void mapElementEntity_(Attributes attributes) {
			try {
				MappingContext mc;

				ILanguageKit languageKit = mcs.peekContextType().getLanguageKit();
				IMappingStrategy strategy = getMappingStrategy(languageKit);
				boolean isElementsFormQualified = strategy != null && strategy.isElementsFormQualified();
	
				QName qname = QName.create(ns, isElementsFormQualified ? NamespaceUtils.getDefaultNamespace(ns) : languageKit.getURI(), name);
	
				if (!hasMappingStrategy(qname))
					throw new IllegalStateException("missing mapping strategy");
	
				if (!hasElementEntityMapping(mcs.peekContextType(), qname)) {
					// terminate structural entities if we cannot further map to another container
					if (mcs.isStructural() && !hasStructuralEntityMapping(mcs.peekContextType(), qname))
						builder._wEntity(mcs.pop().ed);//_anyStructuralEntity(mcs.pop().ed);
	
					// begin as many structural entities as needed
					while ((mc = structuralEntity_(mcs.peekContextType(), qname)) != null) {
						mcs.push(mc);
						if (hasElementEntityMapping(mcs.peekContextType(), qname))
							break;
					}
				}

				// maps the current element
				mcs.push(mc = elementEntity_(mcs.peekContextType(), qname, attributes));

				// begin a mixed structural entity if needed
				if ((mc = mixedStructuralEntity_(mcs.peekContextType())) != null)
					mcs.push(mc);
			} catch (Exception e) {
				xmlContent_(attributes);
			}
		}
		protected void _mapElementEntity() {
			if (isBuildingXmlFragment())
				_xmlContent();
			else {
				// terminate the mixed structural entity, if any
				if (mcs.isMixedStructural())
					builder._wEntity(mcs.pop().ed);

				_elementEntity(mcs.pop().ed);
			}
		}

		protected void skipAttributeFeatures() {
			EntityDescriptor<?> context = builder.wGetEntityDescriptor();
			int index = builder.wCurrentIndexOf();

			if (EntityUtils.isComposite(context))
				return;

			IMappingStrategy mappingStrategy = getMappingStrategy(context.getLanguageKit());
			while (mappingStrategy.isAttributeMapping(context,
					context.getEntityDescriptor(index),
					context.getEntityFeatureDescriptor(index)))
				index++;

			builder.wFeature(index);
		}
		protected boolean isBuildingXmlFragment() {
			return xmlFragment != null;
		}
		protected void xmlContent(String value) {
			skipAttributeFeatures();

			XmlEntityFactory xef = XmlEntityFactory.instance;
			Element element = xef.createElement(name, 
					CommonsEntityAdapterFactory.createResolver(Attributes),
					xef.createCharData(value));

			builder.wEntity_(CommonsEntityDescriptorEnum.SameStageFragment);
			new ModelTemplate(normalizeXmlFragment(element)).apply(builder);
			builder._wEntity(CommonsEntityDescriptorEnum.SameStageFragment);
		}
		protected void xmlContent_(Attributes attributes) {
			skipAttributeFeatures();
			builder.wEntity_(CommonsEntityDescriptorEnum.SameStageFragment);
			xmlFragment = XmlEntityFactory.instance.createElement(name, attributes,
					CommonsEntityAdapterFactory.createResolver(Content));

		}
		protected void _xmlContent() {
			xmlFragment.wSet(XmlFeatureDescriptorEnum.content, _wBuildEntity(Content));
			new ModelTemplate(normalizeXmlFragment(xmlFragment)).apply(builder);
			builder._wEntity(CommonsEntityDescriptorEnum.SameStageFragment);
			xmlFragment = null;
		}
	}
}
