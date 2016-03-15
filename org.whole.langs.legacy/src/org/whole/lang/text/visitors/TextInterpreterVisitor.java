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
package org.whole.lang.text.visitors;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.text.factories.TextEntityFactory;
import org.whole.lang.text.model.ITextEntity;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class TextInterpreterVisitor extends TextIdentityDefaultVisitor {
	public TextInterpreterVisitor(InterpreterOperation operation) {
    	setOperation(operation);
	}

	protected final InterpreterOperation op() {
		return (InterpreterOperation) getOperation();
	}

	@Override
	public void visit(ITextEntity entity) {
		IVisitor ov = op().setVisitor(entity, 0, op().getVisitor(entity, 1));
		op().stagedVisit(entity);
		op().setVisitor(entity, 0, ov);

		IBindingManager bm = getBindings();
		bm.setResult(TextEntityFactory.instance.createText(
				toPrettyPrintString(bm.getResult())));
	}
}
