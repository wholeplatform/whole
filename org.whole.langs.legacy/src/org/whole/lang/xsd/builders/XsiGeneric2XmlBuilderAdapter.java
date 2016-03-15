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

import static org.whole.lang.xsd.mapping.util.MappingStrategyUtils.*;

import java.io.StringWriter;
import java.util.Date;
import java.util.Stack;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.GenericEventTrackingBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.reflect.XmlLanguageKit;

/**
 * @author Enrico Persiani
 */
public class XsiGeneric2XmlBuilderAdapter extends GenericEventTrackingBuilder {
	private IXmlBuilder xb;
	private ICommonsBuilder cb;
	private IBindingManager bm;

	public XsiGeneric2XmlBuilderAdapter(IBuilderOperation targetOperation, EntityDescriptor<?> context, FeatureDescriptor fd) {
		super(null, context, fd);
		wSetBuilderStrategy(new Xsi2XmlBuilder(context, fd));

		xb = (IXmlBuilder) targetOperation.wGetBuilder(XmlLanguageKit.URI);
		cb = (ICommonsBuilder) targetOperation.wGetBuilder(CommonsLanguageKit.URI);
		bm = BindingManagerFactory.instance.createBindingManager();
	}

	private enum State {
		INITIAL, IN_ATTRIBUTES, IN_ATTRIBUTE, IN_CONTENT, IN_STRUCTURE, UNKNOWN;
	}

	public class Xsi2XmlBuilder extends GenericBuilderContext {
		private Stack<State> states;

		public Xsi2XmlBuilder(EntityDescriptor<?> context, FeatureDescriptor fd) {
			states = new Stack<State>();
			states.push(State.INITIAL);
		}

		private String getPrefix(EntityDescriptor<?> ed) {
			if (!ed.getLanguageKit().getURI().equals(wGetEntityDescriptor().getLanguageKit().getURI()))
				setDeferredNamespeceDecl("prefix", "http://uri");
			return "prefix"; //TODO get/calculate prefix
		}

		private void buildQualifiedName(String prefix, String name) {
			xb.QualifiedName_();
			xb.NameSpace(prefix);
			xb.Name(name);
			xb._QualifiedName();
		}

		private void buildNamespeceDecl(String prefix, String uri) {
			xb.Attribute_();
			buildQualifiedName("xmlns", prefix);
			xb.Value(uri);
			xb._Attribute();
		}
		private String deferredPrefix, deferredUri;
		private void setDeferredNamespeceDecl(String prefix, String uri) {
			deferredPrefix = prefix;
			deferredUri = uri;
		}
		private void buildDeferredNamespeceDecl() {
			if (deferredPrefix != null) {
				buildNamespeceDecl(deferredPrefix, deferredUri);
				deferredUri = deferredPrefix = null;
			}
		}

		private void buildElementName(EntityDescriptor<?> ed, String name) {
			//TODO add a strategy to add prefix using elementForm
			buildQualifiedName(getPrefix(ed), name);
		}
		private void buildAttributeName(EntityDescriptor<?> ed, String name) {
			//TODO add a strategy to add prefix using attributeForm
			xb.Name(name);
		}

		private void buildComment(String comment) {
			xb.Comment_();
			xb.CommentText(comment);
			xb._Comment();
		}

		public void wEntity_(EntityDescriptor<?> ed, int initialCapacity) {
			wEntity_(ed);
		}

		public void wEntity(EntityDescriptor<?> ed) {
			EntityDescriptor<?> context = wGetEntityDescriptor();
			FeatureDescriptor fd = wCurrentGetFeatureDescriptor();
			String name;

			switch (states.peek()) {
			case INITIAL:
				name = getElementNCName(context, ed, fd);
				if (name != null) {
					xb.Element_();
					buildElementName(ed, name);
					xb.Attributes_();
					buildDeferredNamespeceDecl();
					xb._Attributes();
					xb._Element();
				} else {
					StringBuilder contents = new StringBuilder();
					contents.append("[[unrooted contents]] ");
					contents.append(ed.getName());
					contents.append(" {}\n");
					buildComment(contents.toString());
				}
				break;

			case IN_ATTRIBUTES:
				throw new IllegalStateException("not implemented yet");

			case IN_CONTENT:
				name = getElementNCName(context, ed, fd);
				if (name != null) {
					xb.Element_();
					buildElementName(ed, name);
					xb.Attributes_();
					buildDeferredNamespeceDecl();
					xb._Attributes();
					xb._Element();
				} else
					throw new IllegalStateException("not implemented yet");
					
				break;
				
			case IN_ATTRIBUTE:
			case UNKNOWN:
				throw new IllegalStateException("illegal mapping");
			}
		}

		public void wEntity_(EntityDescriptor<?> ed) {
			EntityDescriptor<?> context = wGetEntityDescriptor();
			FeatureDescriptor fd = wCurrentGetFeatureDescriptor();
			String name;

			switch (states.peek()) {
			case INITIAL:
				if ((name = getElementNCName(context, ed, fd)) != null) {
					xb.Element_();
					buildElementName(ed, name);
					xb.Attributes_();
					buildDeferredNamespeceDecl();
					states.push(State.IN_ATTRIBUTES); // INITIAL -> IN_ATTRIBUTES
				} else {
					states.push(State.UNKNOWN); // INITIAL -> UNKNOWN
					wBuildEntity_(ed);
				}
				break;

			case IN_ATTRIBUTES:
				name = getAttributeNCName(context, ed, fd);
				if (name != null) {
					xb.Attribute_();
					buildAttributeName(ed, name);
					states.push(State.IN_ATTRIBUTE); // IN_ATTRIBUTES -> IN_ATTRIBUTE
					wBuildEntity_(ed);
				} else if ((name = getElementNCName(context, ed, fd)) != null) {
					xb._Attributes();
					xb.Content_();
					states.pop(); // IN_ATTRIBUTES -> IN_CONTENT
					states.push(State.IN_CONTENT); 
				} else
					throw new IllegalStateException("not implemented yet");
				break;

			case IN_ATTRIBUTE:
				throw new IllegalStateException("not implemented yet");
				
			case IN_CONTENT:
				
				if ((name = getElementNCName(context, ed, fd)) != null) {
					xb.Element_();
					buildElementName(ed, name);
					xb.Attributes_();
					buildDeferredNamespeceDecl();
					states.push(State.IN_ATTRIBUTES); // INITIAL -> IN_ATTRIBUTES
				} else {
					StringBuilder contents = new StringBuilder();
					contents.append("[[unrooted contents]] ");
					contents.append(ed.getName());
					contents.append(" {}");
					buildComment(contents.toString());
				}
				break;

			case UNKNOWN:
				throw new IllegalStateException("illegal mapping");
			}
		}

		public void _wEntity(EntityDescriptor<?> ed) {
			EntityDescriptor<?> context = wGetEntityDescriptor();
			FeatureDescriptor fd = wCurrentGetFeatureDescriptor();
			String name;
			IEntity entity;

			switch (states.peek()) {
			case INITIAL:
				name = getElementNCName(context, ed, fd);
				if (name != null) {
					xb.Element_();
					buildElementName(ed, name);
					xb.Attributes_();
					buildDeferredNamespeceDecl();
					states.push(State.IN_ATTRIBUTES); // INITIAL -> IN_ATTRIBUTES
				} else {
					StringBuilder contents = new StringBuilder();
					contents.append("[[unrooted contents]] ");
					contents.append(ed.getName());
					contents.append(" {}");
					buildComment(contents.toString());
				}
				break;

			case IN_ATTRIBUTES:
				name = getAttributeNCName(context, ed, fd);
				if (name != null) {
					xb.Attribute_();
					buildAttributeName(ed, name);
					states.push(State.IN_ATTRIBUTE); // IN_ATTRIBUTES -> IN_ATTRIBUTE
					wBuildEntity_(ed);
				} else {
					
				}
				break;

			case IN_ATTRIBUTE:
				entity = _wBuildEntity(ed);
				if (EntityUtils.isComposite(entity)) {
					StringBuilder value = new StringBuilder();
					for (int i=0, size=entity.wSize(); i< size; i++) {
						if (i>0)
							value.append(' ');
						IEntity child = entity.wGet(i);
						if (EntityUtils.isData(child))
							value.append(DataTypeUtils.getAsPersistenceString(child));
						else
							throw new IllegalStateException("not implemented yet");
					}
					xb.Value(value.toString());
					xb._Attribute();
				} else
					throw new IllegalStateException("not implemented yet");

				states.pop(); // IN_ATTRIBUTE -> [PREVIOUS STATE]
				assert states.peek() == State.IN_ATTRIBUTES;
				break;

			case IN_CONTENT:
				throw new IllegalStateException("not implemented yet");

			case UNKNOWN:
				entity = _wBuildEntity(ed);
				StringWriter contents = new StringWriter();
				contents.append("[[unrooted contents]] ");
				contents.append(ed.getName());
				contents.append(" {\n");
				for (int i=0, size=entity.wSize(); i<size; i++)
					PrettyPrinterOperation.prettyPrint(entity.wGet(i), contents);
				contents.append("\n}\n");
				buildComment(contents.toString());
				states.pop(); // UNKNOWN -> [PREVIOUS STATE]
			}
		}

		public void wEntity(EntityDescriptor<?> ed, boolean value) {
		}

		public void wEntity(EntityDescriptor<?> ed, byte value) {
		}

		public void wEntity(EntityDescriptor<?> ed, char value) {
		}

		public void wEntity(EntityDescriptor<?> ed, double value) {
		}

		public void wEntity(EntityDescriptor<?> ed, float value) {
		}

		public void wEntity(EntityDescriptor<?> ed, int value) {
		}

		public void wEntity(EntityDescriptor<?> ed, long value) {
		}

		public void wEntity(EntityDescriptor<?> ed, short value) {
		}

		public void wEntity(EntityDescriptor<?> ed, String value) {
		}

		public void wEntity(EntityDescriptor<?> ed, Date value) {
		}

		public void wEntity(EntityDescriptor<?> ed, EnumValue value) {
		}

		public void wEntity(EntityDescriptor<?> ed, Object value) {
		}

		public void wSetBuilderContext(IBuilderContext context) {
		}
		public void wSetEntityContext(IEntityContext context) {
		}

		public void wDefault() {
			throw new UnsupportedOperationException();
		}
		public void wEntity() {
			throw new UnsupportedOperationException();
		}
		public void wEntity_() {
			throw new UnsupportedOperationException();
		}
		public void _wEntity() {
			throw new UnsupportedOperationException();
		}

		public void wFeature(int index) {
			throw new UnsupportedOperationException();
		}
		public void wFeature(FeatureDescriptor feature) {
			throw new UnsupportedOperationException();
		}
		public void wFeature(ITemplate template) {
			throw new UnsupportedOperationException();
		}
	}
}
