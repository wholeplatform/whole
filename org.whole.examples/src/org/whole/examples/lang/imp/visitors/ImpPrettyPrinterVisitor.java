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
package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.model.Addition;
import org.whole.examples.lang.imp.model.And;
import org.whole.examples.lang.imp.model.Arguments;
import org.whole.examples.lang.imp.model.ArrayAccess;
import org.whole.examples.lang.imp.model.ArrayLiteral;
import org.whole.examples.lang.imp.model.ArrayType;
import org.whole.examples.lang.imp.model.AssignmentExpression;
import org.whole.examples.lang.imp.model.BooleanLiteral;
import org.whole.examples.lang.imp.model.Division;
import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.examples.lang.imp.model.EmptyStatement;
import org.whole.examples.lang.imp.model.Equals;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.model.ExpressionStatement;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.examples.lang.imp.model.ForeachStatement;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.GreaterOrEquals;
import org.whole.examples.lang.imp.model.GreaterThan;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.examples.lang.imp.model.IfStatement;
import org.whole.examples.lang.imp.model.IntLiteral;
import org.whole.examples.lang.imp.model.LessOrEquals;
import org.whole.examples.lang.imp.model.LessThan;
import org.whole.examples.lang.imp.model.Literal;
import org.whole.examples.lang.imp.model.LoadExpression;
import org.whole.examples.lang.imp.model.Multiplication;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.model.NameExpression;
import org.whole.examples.lang.imp.model.Not;
import org.whole.examples.lang.imp.model.NotEquals;
import org.whole.examples.lang.imp.model.Or;
import org.whole.examples.lang.imp.model.Parameter;
import org.whole.examples.lang.imp.model.Parameters;
import org.whole.examples.lang.imp.model.PrimitiveType;
import org.whole.examples.lang.imp.model.PrintStatement;
import org.whole.examples.lang.imp.model.PrintlnStatement;
import org.whole.examples.lang.imp.model.RangeLiteral;
import org.whole.examples.lang.imp.model.Remainder;
import org.whole.examples.lang.imp.model.ReturnStatement;
import org.whole.examples.lang.imp.model.RunExpression;
import org.whole.examples.lang.imp.model.SaveStatement;
import org.whole.examples.lang.imp.model.SizeExpression;
import org.whole.examples.lang.imp.model.StringLiteral;
import org.whole.examples.lang.imp.model.Subtraction;
import org.whole.examples.lang.imp.model.VariableDeclaration;
import org.whole.examples.lang.imp.model.WhileStatement;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ImpPrettyPrinterVisitor extends ImpTraverseAllVisitor {
	protected final IPrettyPrintWriter out;

	public ImpPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(FunctionDeclaration entity) {
		out.printRaw("function ");
		entity.getType().accept(this);
		out.print(' ');
		entity.getName().accept(this);
		out.print('(');
		entity.getParameters().accept(this);
		out.printlnRaw(") {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			((Parameter) entity.wGet(i)).accept(this);
		}
	}

	public void visit(Parameter entity) {
		entity.getType().accept(this);
		out.print(' ');
		entity.getName().accept(this);
	}

	public void visit(VariableDeclaration entity) {
		entity.getType().accept(this);
		out.print(' ');
		entity.getName().accept(this);
		out.printRaw(" = ");
		entity.getInitializer().accept(this);
		if (!out.isInlined())
			out.printlnRaw(";");
	}

	public void visit(Arguments entity) {
		out.print('(');
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			((Expression) entity.wGet(i)).accept(this);
		}
		out.print(')');
	}

	public void visit(EmptyStatement entity) {
		out.printlnRaw(";");
	}

	public void visit(ReturnStatement entity) {
		out.printRaw("return ");
		entity.getExp().accept(this);
		out.printlnRaw(";");
	}

	public void visit(IfStatement entity) {
		out.printRaw("if (");
		entity.getCondition().accept(this);
		out.print(')');
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));
		
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement)) {
			out.printlnRaw("}");
		}
	}

	public void visit(IfElseStatement entity) {
		out.printRaw("if (");
		entity.getCondition().accept(this);
		out.print(')');
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));

		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printRaw("} ");
		out.printRaw("else");
		if (entity.getFalseBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getFalseBody().accept(this);
		out.setRelativeIndentation((-1));
		
		if (entity.getFalseBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement)) {
			out.printlnRaw("}");
		}
	}

	public void visit(WhileStatement entity) {
		out.printRaw("while (");
		entity.getCondition().accept(this);
		out.print(')');
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));

		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement)) {
			out.printlnRaw("}");
		}
	}

	public void visit(DoWhileStatement entity) {
		out.printlnRaw("do {");

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));

		out.printRaw("} while (");
		entity.getCondition().accept(this);
		out.printlnRaw(");");
	}

	public void visit(ForStatement entity) {
		out.printRaw("for (");
		out.setInlined(true);
		entity.getInitializer().accept(this);
		out.setInlined(false);
		out.printRaw("; ");
		entity.getCondition().accept(this);
		out.printRaw("; ");
		out.setInlined(true);
		entity.getUpdater().accept(this);
		out.setInlined(false);
		out.printRaw(")");
		
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));

		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement)) {
			out.printlnRaw("}");
		}
	}

	public void visit(ForeachStatement entity) {
		out.printRaw("foreach (");
		entity.getName().accept(this);
		out.printRaw(" : ");
		entity.getArrayExp().accept(this);
		out.printRaw(")");
		
		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement))
			out.printlnRaw(" {");
		else
			out.println();

		out.setRelativeIndentation((+1));
		entity.getTrueBody().accept(this);
		out.setRelativeIndentation((-1));

		if (entity.getTrueBody().wGetEntityDescriptor().equals(ImpEntityDescriptorEnum.BlockStatement)) {
			out.printlnRaw("}");
		}
	}

	public void visit(ExpressionStatement entity) {
		entity.getExp().accept(this);
		out.printlnRaw(";");		
	}

	public void visit(AssignmentExpression entity) {
		entity.getName().accept(this);
		out.printRaw(" = ");
		entity.getExp().accept(this);
	}

	public void visit(PrintStatement entity) {
		out.printRaw("print ");
		entity.getExp().accept(this);
		out.printlnRaw(";");
	}
	public void visit(PrintlnStatement entity) {
		out.printRaw("println ");
		entity.getExp().accept(this);
		out.printlnRaw(";");
	}

	public void visit(SaveStatement entity) {
		out.printRaw("save ");
		entity.getExp().accept(this);
		if (!EntityUtils.isResolver(entity.getFileName())) {
			out.printRaw(" as ");
			entity.getFileName().accept(this);
		}
		out.printlnRaw(";");
	}

	public void visit(LoadExpression entity) {
		out.printRaw("load ");
		entity.getFileName().accept(this);
		if (!EntityUtils.isResolver(entity.getLanguage())) {
			out.printRaw(" as ");
			entity.getLanguage().accept(this);
		}
	}

	public void visit(RunExpression entity) {
		out.printRaw("run ");
		entity.getExp().accept(this);
	}

	public void visit(BooleanLiteral entity) {
		out.print(entity.wBooleanValue());
	}

	public void visit(IntLiteral entity) {
		out.print(entity.wIntValue());
	}

	public void visit(StringLiteral entity) {
		out.printRaw("\""+entity.wStringValue()+"\"");
	}

	public void visit(Name entity) {
		out.printRaw(entity.getValue());
	}
	public void visit(NameExpression entity) {
		out.printRaw(entity.getValue());
	}

	public void visit(PrimitiveType entity) {
		out.print(entity.getValue());
	}

	public void visit(SizeExpression entity) {
		out.print('#');
		entity.getExp().accept(this);
	}

	public void visit(RangeLiteral entity) {
		out.print('{');
		entity.getLowerBound().accept(this);
		out.printRaw("..");
		entity.getUpperBound().accept(this);
		out.print('}');
	}

	public void visit(ArrayLiteral entity) {
		out.print('{');
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			((Literal) entity.wGet(i)).accept(this);
		}
		out.print('}');
	}

	public void visit(ArrayType entity) {
		entity.getContentType().accept(this);
		out.print('[');
		entity.getIndexType().accept(this);
		out.print(']');
	}

	public void visit(ArrayAccess entity) {
		entity.getArray().accept(this);
		out.print('[');
		entity.getIndex().accept(this);
		out.print(']');
	}

	public void visit(Addition entity) {
		entity.getExp1().accept(this);
		out.printRaw(" + ");
		entity.getExp2().accept(this);
	}

	public void visit(Subtraction entity) {
		entity.getExp1().accept(this);
		out.printRaw(" - ");
		entity.getExp2().accept(this);
	}

	public void visit(Multiplication entity) {
		entity.getExp1().accept(this);
		out.printRaw(" * ");
		entity.getExp2().accept(this);
	}

	public void visit(Division entity) {
		entity.getExp1().accept(this);
		out.printRaw(" / ");
		entity.getExp2().accept(this);
	}

	public void visit(Remainder entity) {
		entity.getExp1().accept(this);
		out.printRaw(" % ");
		entity.getExp2().accept(this);
	}

	public void visit(And entity) {
		entity.getExp1().accept(this);
		out.printRaw(" && ");
		entity.getExp2().accept(this);
	}

	public void visit(Or entity) {
		entity.getExp1().accept(this);
		out.printRaw(" || ");
		entity.getExp2().accept(this);
	}

	public void visit(Not entity) {
		out.print('!');
		entity.getExp().accept(this);
	}

	public void visit(Equals entity) {
		entity.getExp1().accept(this);
		out.printRaw(" == ");
		entity.getExp2().accept(this);
	}

	public void visit(NotEquals entity) {
		entity.getExp1().accept(this);
		out.printRaw(" != ");
		entity.getExp2().accept(this);
	}

	public void visit(LessThan entity) {
		entity.getExp1().accept(this);
		out.printRaw(" < ");
		entity.getExp2().accept(this);
	}

	public void visit(LessOrEquals entity) {
		entity.getExp1().accept(this);
		out.printRaw(" <= ");
		entity.getExp2().accept(this);
	}

	public void visit(GreaterThan entity) {
		entity.getExp1().accept(this);
		out.printRaw(" > ");
		entity.getExp2().accept(this);
	}

	public void visit(GreaterOrEquals entity) {
		entity.getExp1().accept(this);
		out.printRaw(" >= ");
		entity.getExp2().accept(this);
	}
}
