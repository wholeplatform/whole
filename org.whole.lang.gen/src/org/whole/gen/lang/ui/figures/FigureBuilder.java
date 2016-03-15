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
package org.whole.gen.lang.ui.figures;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;


/**
 * @author Riccardo Solmi
 */
public class FigureBuilder extends CompilationUnitBuilder {
	public final MethodDeclaration constructor;

	public FigureBuilder(LanguageGenerator generator, String packageSuffix, String figureName) {
		super(generator, packageSuffix);

		addClassDeclaration(figureName);
		addBodyDeclaration(constructor = newConstructorDeclaration(typeDec));
	}

	public void addFoldingToggle() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("addToken", newSimpleName("foldingToggle"))));
	}

	public void addChildPlace() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("addChildPlace")));
	}
	public void addIndent() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("addIndent")));
	}
	public void nextRow() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("nextRow")));
	}

	public void collapsedLayout() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("collapsedLayout")));
	}
	public void expandedLayout() {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("expandedLayout")));
	}

	public void addToken(String kind, String text) {
		constructor.getBody().statements().add(newExpressionStatement(
				newMethodInvocation("add"+kind, newLiteral(text))));
	}

	public void addToken(String text) {
		addToken("Token", text);
	}
}
