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
package org.whole.examples.lang.imp.ui.editparts;

import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.FunctionInvocationExpression;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.examples.lang.imp.model.IfStatement;
import org.whole.examples.lang.imp.model.Parameter;
import org.whole.examples.lang.imp.model.WhileStatement;

/** 
 * @author Riccardo Solmi
 */
public class ImpDiagramPartFactoryVisitor extends ImpTextualPartFactoryVisitor {
	public void visit(FunctionDeclaration entity) {
		//TODO
		super.visit(entity);
	}

	public void visit(Parameter entity) {
		//TODO
		super.visit(entity);
	}

	public void visit(FunctionInvocationExpression entity) {
		//TODO
		super.visit(entity);
	}

	public void visit(IfStatement entity) {
		part = new IfStatementDiagramPart();
	}

	public void visit(IfElseStatement entity) {
		part = new IfElseStatementDiagramPart();
	}

	public void visit(WhileStatement entity) {
		part = new WhileStatementDiagramPart();
	}

	public void visit(DoWhileStatement entity) {
		//TODO
		super.visit(entity);
	}

	public void visit(ForStatement entity) {
		//TODO
		super.visit(entity);
	}
}