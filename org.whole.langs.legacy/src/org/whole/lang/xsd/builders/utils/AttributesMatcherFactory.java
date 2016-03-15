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
package org.whole.lang.xsd.builders.utils;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlLanguageKit;

/**
 * @author Enrico Persiani
 */
public class AttributesMatcherFactory {
	public static IVisitor matchNamespaceDeclaration(IBindingManager bm) {
		IVisitor ov = GenericTraversalFactory.instance.one( 
				GenericMatcherFactory.instance.matchInScope(getNsDeclPattern()),
				GenericMatcherFactory.instance.matchInScope(getDefaultNsDeclPattern()));
		ov.setBindings(bm);
		return ov;
	}
	public static IVisitor matchNamespaceDeclaration() {
		return matchNamespaceDeclaration(BindingManagerFactory.instance.createBindingManager());
	}
	public static boolean matchNamespaceDeclaration(IEntity entity, IBindingManager bm) {
		return Matcher.match(AttributesMatcherFactory.matchNamespaceDeclaration(bm), entity);
	}
	public static boolean matchNamespaceDeclaration(IEntity entity) {
		return matchNamespaceDeclaration(entity, BindingManagerFactory.instance.createBindingManager());
	}
	public static boolean containsNamespaceDeclaration(IEntity entity) {
		return Matcher.find(matchNamespaceDeclaration(), entity, false) != null;
	}

	public static IVisitor matchReferenceAttribute(IBindingManager bm) {
		IVisitor ov = GenericTraversalFactory.instance.one( 
				GenericMatcherFactory.instance.matchInScope(getRefAttrPattern()),
				GenericMatcherFactory.instance.matchInScope(getQualifiedRefAttrPattern()));
		ov.setBindings(bm);
		return ov;
	}
	public static IVisitor matchReferenceAttribute() {
		return matchReferenceAttribute(BindingManagerFactory.instance.createBindingManager());
	}
	public static boolean matchReferenceAttribute(IEntity entity, IBindingManager bm) {
		return Matcher.match(AttributesMatcherFactory.matchReferenceAttribute(bm), entity);
	}
	public static boolean matchReferenceAttribute(IEntity entity) {
		return matchReferenceAttribute(entity, BindingManagerFactory.instance.createBindingManager());
	}
	public static boolean containsReferenceAttribute(IEntity entity) {
		return Matcher.find(matchReferenceAttribute(), entity, false) != null;
	}

	private static IEntity nsDeclPattern;
	private static IEntity getNsDeclPattern() {
		if (nsDeclPattern == null) {
			ModelBuilderOperation mop = new ModelBuilderOperation();
			IXmlBuilder xb = (IXmlBuilder) mop.wGetBuilder(XmlLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) mop.wGetBuilder(CommonsLanguageKit.URI);
			xb.Attribute_();
			xb.QualifiedName_();
			xb.NameSpace("xmlns");
			cb.Variable_();
			cb.VarType(XmlEntityDescriptorEnum.Name);
			cb.VarName("xmlns");
			cb.Quantifier(QuantifierEnum.MANDATORY);
			cb._Variable();
			xb._QualifiedName();
			cb.Variable_();
			cb.VarType(XmlEntityDescriptorEnum.Value);
			cb.VarName("uri");
			cb.Quantifier(QuantifierEnum.MANDATORY);
			cb._Variable();
			xb._Attribute();
			nsDeclPattern = mop.wGetResult();
		}
		return nsDeclPattern;
	}
	private static IEntity defaultNsDeclPattern;
	private static IEntity getDefaultNsDeclPattern() {
		if (defaultNsDeclPattern == null) {
			ModelBuilderOperation mop = new ModelBuilderOperation();
			IXmlBuilder xb = (IXmlBuilder) mop.wGetBuilder(XmlLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) mop.wGetBuilder(CommonsLanguageKit.URI);
			xb.Attribute_();
			xb.Name("xmlns");
			cb.Variable_();
			cb.VarType(XmlEntityDescriptorEnum.Value);
			cb.VarName("uri");
			cb.Quantifier(QuantifierEnum.MANDATORY);
			cb._Variable();
			xb._Attribute();
			defaultNsDeclPattern = mop.wGetResult();
		}
		return defaultNsDeclPattern;
	}

	private static IEntity refAttrPattern;
	private static  IEntity getRefAttrPattern() {
		if (refAttrPattern == null) {
			ModelBuilderOperation mop = new ModelBuilderOperation();
			IXmlBuilder xb = (IXmlBuilder) mop.wGetBuilder(XmlLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) mop.wGetBuilder(CommonsLanguageKit.URI);
			xb.Attribute_();
			xb.Name("ref");
			cb.Variable_();
			cb.VarType(XmlEntityDescriptorEnum.Value);
			cb.VarName("value");
			cb.Quantifier(QuantifierEnum.MANDATORY);
			cb._Variable();
			xb._Attribute();
			refAttrPattern = mop.wGetResult();
		}
		return refAttrPattern;
	}


	private static IEntity qualifiedRefAttrPattern;
	private static  IEntity getQualifiedRefAttrPattern() {
		if (qualifiedRefAttrPattern == null) {
			ModelBuilderOperation mop = new ModelBuilderOperation();
			IXmlBuilder xb = (IXmlBuilder) mop.wGetBuilder(XmlLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) mop.wGetBuilder(CommonsLanguageKit.URI);
			xb.Attribute_();
			xb.QualifiedName_();
			cb.Variable_();
			cb.VarType("http://lang.whole.org/Xml#NameSpace");
			cb.VarName("xmlns");
			cb.Quantifier("!");
			cb._Variable();
			xb.Name("ref");
			xb._QualifiedName();
			cb.Variable_();
			cb.VarType("http://lang.whole.org/Xml#Value");
			cb.VarName("value");
			cb.Quantifier("!");
			cb._Variable();
			xb._Attribute();
			qualifiedRefAttrPattern = mop.wGetResult();
		}
		return qualifiedRefAttrPattern;
	}
}
