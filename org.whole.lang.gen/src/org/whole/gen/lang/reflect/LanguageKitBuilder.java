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
package org.whole.gen.lang.reflect;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;


/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public class LanguageKitBuilder extends CompilationUnitBuilder {
	public LanguageKitBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.languageKitName(),
				AbstractLanguageKit.class.getName());

		FieldDeclaration fieldDec = newFieldDeclaration(
				"String", "URI", newLiteral(generator.getURI()));
        fieldDec.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		addBodyDeclaration(fieldDec);

		methodDec = newMethodDeclaration("String", "getURI");
		addStatement(methodDec,
				newReturnStatement(ast.newSimpleName("URI")));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration("String", "getNamespace");
		addStatement(methodDec,
				newReturnStatement(newLiteral(generator.getPackagePrefix())));
		addBodyDeclaration(methodDec);
		
		methodDec = newMethodDeclaration("String", "getName");
		addStatement(methodDec,
				newReturnStatement(newLiteral(generator.getModelName())));
		addBodyDeclaration(methodDec);
		
		String version = generator.getVersion();
		if (version != null && version.length()>0) {
			methodDec = newMethodDeclaration("String", "getVersion");
			addStatement(methodDec,
					newReturnStatement(newLiteral(version)));
			addBodyDeclaration(methodDec);
		}

		methodDec = newMethodDeclaration(
				EntityDescriptorEnum.class.getName(), "getEntityDescriptorEnum");
		addStatement(methodDec,
				newReturnStatement(newFieldAccess(
						generator.specificEntityDescriptorEnumName(), "instance")));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(FeatureDescriptorEnum.class.getName(), "getFeatureDescriptorEnum");
		addStatement(methodDec, newReturnStatement(newFieldAccess(generator.specificFeatureDescriptorEnumName(), "instance")));
		addBodyDeclaration(methodDec);

		
		methodDec = newMethodDeclaration(IEntityRegistry.class.getName(), "createImplEntityRegistry");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		addStatement(methodDec, newReturnStatement(newClassInstanceCreation(generator.implRegistryName())));
		addBodyDeclaration(methodDec);

//		if (generator.hasStrictImplRegistry()) {//FIXME workaround
			methodDec = newMethodDeclaration(IEntityRegistry.class.getName(), "createStrictImplEntityRegistry");
			methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
			methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
			addStatement(methodDec, newReturnStatement(newClassInstanceCreation(generator.strictImplRegistryName())));
			addBodyDeclaration(methodDec);
//		}

		methodDec = newMethodDeclaration(IEntityRegistry.class.getName(), "createAdaptersEntityRegistry");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		addStatement(methodDec, newReturnStatement(newClassInstanceCreation(generator.adapterRegistryName())));
		addBodyDeclaration(methodDec);

//		methodDec = newMethodDeclaration(IPrototypeManager.class.getName(), "getPrototypeManager");
//		addStatement(methodDec, newReturnStatement(newMethodInvocation(generator.prototypeManagerName(), "instance")));
//		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ITemplateManager.class.getName(), "getTemplateManager");
		addStatement(methodDec, newReturnStatement(newMethodInvocation(generator.templateManagerName(), "instance")));
		addBodyDeclaration(methodDec);
	}
}
