/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.gen.lang.visitors;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;


/**
 * @author Riccardo Solmi
 */
public class FailureVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	public FailureVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.failureVisitorName(), generator.identityVisitorName());
		addImportDeclaration(generator.modelPackage(), true);

		addFactoryMethod("failure");

	    MethodDeclaration eaMethod = addVisitMethod("boolean", "visitAdapter", IEntityAdapter.class.getName());
	    eaMethod.getBody().statements().add(newThrowStatement(newClassInstanceCreation(VisitException.class.getName())));
	}

    public MethodDeclaration addEntity(String eName) {
	    MethodDeclaration eMethod = visitMethod(eName);
	    
	    eMethod.getBody().statements().add(newThrowStatement(newClassInstanceCreation(VisitException.class.getName())));

	    return eMethod;
	}
	public MethodDeclaration addFragmentEntity(String type) {
	    return addEntity(type);
	}
}
