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
package org.whole.gen.lang.ui;

import static org.whole.gen.lang.ClassNames.AbstractEditorKitName;
import static org.whole.gen.lang.ClassNames.EditPartFactoryName;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.reflect.ILanguageKit;


/**
 * @author Riccardo Solmi
 */
public class EditorKitBuilder extends CompilationUnitBuilder {
	public EditorKitBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.editorKitName(),
				AbstractEditorKitName);
		addSerialVersionUID(1L);

		FieldDeclaration fieldDec = newFieldDeclaration(
				"String", "ID", newLiteral(generator.editorKitName()));
        fieldDec.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		addBodyDeclaration(fieldDec);

		methodDec = newMethodDeclaration("String", "getId");
		addStatement(methodDec,
				newReturnStatement(ast.newSimpleName("ID")));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration("String", "getName");
		addStatement(methodDec,
				newReturnStatement(newLiteral(generator.getEditorName())));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(EditPartFactoryName, "getPartFactory");
		addStatement(methodDec, newReturnStatement(newClassInstanceCreation(generator.partFactoryVisitorName())));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration("boolean", "canApply",
				newSingleVariableDeclaration(ILanguageKit.class.getName(), "languageKit"));
		addStatement(methodDec, newReturnStatement(
				newMethodInvocation(newMethodInvocation("languageKit", "getURI"), "equals",
						newFieldAccess(generator.languageKitName(), "URI"))));
		addBodyDeclaration(methodDec);
	}
}
