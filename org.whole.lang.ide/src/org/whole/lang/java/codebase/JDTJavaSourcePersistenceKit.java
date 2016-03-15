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
package org.whole.lang.java.codebase;

import org.eclipse.jdt.core.dom.ASTNode;
import org.whole.gen.util.JDTUtils;
import org.whole.gen.util.JDTUtils.JAVA_FRAGMENT;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.java.model.ClassDeclaration;
import org.whole.lang.java.model.IJavaEntity;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.util.JDTTransformerVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class JDTJavaSourcePersistenceKit extends JavaSourcePersistenceKit {
	private static class SingletonHolder {
		private static final JDTJavaSourcePersistenceKit instance = new JDTJavaSourcePersistenceKit();
	}
	public static final JDTJavaSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}

	@Override
	public String getId() {
		return JavaSourcePersistenceKit.class.getName();
	}

	@Override
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		String fileStr = StringUtils.readAsString(pp.getInputStream(), pp.getEncoding());
		IBindingManager bm = pp.getBindings();
		ASTNode ast = null;

		//TODO remove when parse/unparse are added
		if (bm.wIsSet("parseFragments") && bm.wBooleanValue("parseFragments")) {
			IJavaEntity entity = JDTTransformerVisitor.transform(fileStr, JDTUtils.parse(fileStr));
			if (Matcher.matchImpl(JavaEntityDescriptorEnum.ClassDeclaration, entity))
				bm.wDef("syntheticRoot", ((ClassDeclaration) entity).getBodyDeclarations());
			else if (Matcher.matchImpl(JavaEntityDescriptorEnum.Block, entity))
				bm.wDef("syntheticRoot", entity);
			return entity;
		} else {
			if (bm.wIsSet("entityURI")) {
				String entityURI = bm.wStringValue("entityURI");
				if (ResourceUtils.hasFragmentPart(entityURI)) {
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(entityURI, true, contextUri);

					if (ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.Expression)) {
						ast = JDTUtils.parseAs(fileStr, JAVA_FRAGMENT.EXPRESSION);
					} else if (ed.equals(JavaEntityDescriptorEnum.Block)) {
						ast = JDTUtils.parseAs(fileStr, JAVA_FRAGMENT.STATEMENTS);
					} else if (ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.Statement)) {
						ast = JDTUtils.parseAs(fileStr, JAVA_FRAGMENT.STATEMENTS);
					} else if (ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.BodyDeclaration)) {
						ast = JDTUtils.parseAs(fileStr, JAVA_FRAGMENT.CLASS_BODY_DECLARATIONS);
					} else if (ed.equals(JavaEntityDescriptorEnum.BodyDeclarations)) {
						ast = JDTUtils.parseAs(fileStr, JAVA_FRAGMENT.CLASS_BODY_DECLARATIONS);
					} else if (ed.equals(JavaEntityDescriptorEnum.CompilationUnit))
						ast = JDTUtils.parseAsCompilationUnit(fileStr);
				}
			}
			if (ast == null)
				ast = JDTUtils.parse(fileStr);

			IEntity result = JDTTransformerVisitor.transform(fileStr, ast);

			if (bm.wIsSet("entityURI")) {
				String entityURI = bm.wStringValue("entityURI");
				if (ResourceUtils.hasFragmentPart(entityURI)) {
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(entityURI, true, contextUri);
					
					if (ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.Expression)) {
						if (!result.wGetEntityDescriptor().isLanguageSubtypeOf(ed))
							throw new IllegalArgumentException("");
					} else if (!ed.equals(JavaEntityDescriptorEnum.Block) && ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.Statement)) {
						if (result.wSize() != 1 || !(result = result.wGet(0)).wGetEntityDescriptor().isLanguageSubtypeOf(ed))
							throw new IllegalArgumentException("");
					} else if (ed.isLanguageSubtypeOf(JavaEntityDescriptorEnum.BodyDeclaration)) {
						if (result.wSize() != 1 || !(result = result.wGet(0)).wGetEntityDescriptor().isLanguageSubtypeOf(ed))
							throw new IllegalArgumentException("");
					}
				} else if (result.wGetEntityDescriptor().equals(JavaEntityDescriptorEnum.Block) && result.wSize() == 1)
					result = result.wGet(0);
			}

			return result;
		}
	}
}
