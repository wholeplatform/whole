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

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.whole.examples.lang.imp.model.Addition;
import org.whole.examples.lang.imp.model.And;
import org.whole.examples.lang.imp.model.BooleanLiteral;
import org.whole.examples.lang.imp.model.Division;
import org.whole.examples.lang.imp.model.DoWhileStatement;
import org.whole.examples.lang.imp.model.Equals;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.model.GreaterOrEquals;
import org.whole.examples.lang.imp.model.GreaterThan;
import org.whole.examples.lang.imp.model.IfElseStatement;
import org.whole.examples.lang.imp.model.IfStatement;
import org.whole.examples.lang.imp.model.IntLiteral;
import org.whole.examples.lang.imp.model.LessOrEquals;
import org.whole.examples.lang.imp.model.LessThan;
import org.whole.examples.lang.imp.model.Multiplication;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.model.Not;
import org.whole.examples.lang.imp.model.NotEquals;
import org.whole.examples.lang.imp.model.Or;
import org.whole.examples.lang.imp.model.PrintStatement;
import org.whole.examples.lang.imp.model.PrintlnStatement;
import org.whole.examples.lang.imp.model.ReturnStatement;
import org.whole.examples.lang.imp.model.StringLiteral;
import org.whole.examples.lang.imp.model.Subtraction;
import org.whole.examples.lang.imp.model.WhileStatement;

/**
 * @author Riccardo Solmi
 */
public class ImpBytecodeGeneratorVisitor extends ImpTraverseAllVisitor implements Opcodes {
	protected String name;
	protected int resultType = TYPE_V;
	public static final int TYPE_V = 0;
	public static final int TYPE_B = 1;
	public static final int TYPE_I = 2;
	public static final int TYPE_A = 3;


	public ImpBytecodeGeneratorVisitor(BytecodeGeneratorOperation operation) {
    	setOperation(operation);
	}

	public BytecodeGeneratorOperation getOperation() {
		return (BytecodeGeneratorOperation) super.getOperation();
	}
	protected ClassVisitor cv() {
		return getOperation().getClassVisitor();
	}
	public MethodVisitor mv() {
		return getOperation().getMethodVisitor();
	}
	public void setMethodVisitor(MethodVisitor methodVisitor) {
		getOperation().setMethodVisitor(methodVisitor);
	}

	public void visit(FunctionDeclaration entity) {
		entity.getType().accept(this);
		entity.getName().accept(this);
		entity.getParameters().accept(this);

		MethodVisitor mv = cv().visitMethod(ACC_PUBLIC, name, "()V", null, null);
		mv.visitCode();
		setMethodVisitor(mv);
		
		entity.getBody().accept(this);

		mv.visitInsn(RETURN);
	    mv.visitMaxs(0, 0);
        mv.visitEnd();
	}

	public void visit(ReturnStatement entity) {
		resultType = TYPE_V;
		entity.getExp().accept(this);
		switch (resultType) {
		case TYPE_V:
			mv().visitInsn(RETURN);
			break;
		case TYPE_B:
			mv().visitInsn(IRETURN);
			break;
		case TYPE_I:
			mv().visitInsn(IRETURN);
			break;
		case TYPE_A:
			mv().visitInsn(ARETURN);
			break;
		}
	}

	public static String paramType(int resultType) {
		switch (resultType) {
		case TYPE_V:
			return "";
		case TYPE_B:
			return "I";
		case TYPE_I:
			return "I";
		case TYPE_A:
			return "Ljava/lang/String;";
		default:
			return "";
		}		
	}

	public void visit(IfStatement entity) {
		entity.getCondition().accept(this);
        Label iffalse = new Label();
        mv().visitJumpInsn(IF_ICMPNE, iffalse);
		entity.getTrueBody().accept(this);
        mv().visitLabel(iffalse);
	}

	public void visit(IfElseStatement entity) {
		entity.getCondition().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPEQ, iftrue);
		entity.getFalseBody().accept(this);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
		entity.getTrueBody().accept(this);
        mv().visitLabel(end);
	}

	public void visit(WhileStatement entity) {
        Label loop = new Label();
        Label end = new Label();
        mv().visitLabel(loop);
		entity.getCondition().accept(this);
        mv().visitJumpInsn(IF_ICMPNE, end);
		entity.getTrueBody().accept(this);
        mv().visitJumpInsn(GOTO, loop);
        mv().visitLabel(end);
	}

	public void visit(DoWhileStatement entity) {
        Label loop = new Label();
        mv().visitLabel(loop);
		entity.getTrueBody().accept(this);
		entity.getCondition().accept(this);
        mv().visitJumpInsn(IF_ICMPEQ, loop);
	}

	public void visit(ForStatement entity) {
		entity.getInitializer().accept(this);
        Label loop = new Label();
        Label end = new Label();
        mv().visitLabel(loop);
		entity.getCondition().accept(this);
        mv().visitJumpInsn(IF_ICMPNE, end);
		entity.getTrueBody().accept(this);
		entity.getUpdater().accept(this);
        mv().visitJumpInsn(GOTO, loop);
        mv().visitLabel(end);
	}

	public void visit(PrintStatement entity) {
		mv().visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	    entity.getExp().accept(this);
	    mv().visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "("+paramType(resultType)+")V");
	}

	public void visit(PrintlnStatement entity) {
		mv().visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	    entity.getExp().accept(this);
	    mv().visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "("+paramType(resultType)+")V");
	}

	
	public void visit(BooleanLiteral entity) {
		mv().visitInsn(entity.wBooleanValue() ? ICONST_1 : ICONST_0);
		resultType = TYPE_B;
	}

	public void visit(IntLiteral entity) {
		mv().visitLdcInsn(new Integer(entity.wIntValue()));
		resultType = TYPE_I;
	}

	public void visit(StringLiteral entity) {
		mv().visitLdcInsn(entity.wStringValue());
		resultType = TYPE_A;
	}

	public void visit(Name entity) {
		name = entity.getValue();
	}

	
	public void visit(Addition entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
		mv().visitInsn(IADD);
		resultType = TYPE_I;
	}

	public void visit(Subtraction entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
		mv().visitInsn(ISUB);
		resultType = TYPE_I;
	}

	public void visit(Multiplication entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
		mv().visitInsn(IMUL);
		resultType = TYPE_I;
	}

	public void visit(Division entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
		mv().visitInsn(IDIV);
		resultType = TYPE_I;
	}

	public void visit(And entity) {
		entity.getExp1().accept(this);
        mv().visitInsn(DUP);
        Label end = new Label();
        mv().visitJumpInsn(IFEQ, end);
        mv().visitInsn(POP);
		entity.getExp2().accept(this);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(Or entity) {
		entity.getExp1().accept(this);
        mv().visitInsn(DUP);
        Label end = new Label();
        mv().visitJumpInsn(IFNE, end);
        mv().visitInsn(POP);
		entity.getExp2().accept(this);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(Not entity) {
        mv().visitInsn(ICONST_1);
		entity.getExp().accept(this);
		mv().visitInsn(ISUB);
		resultType = TYPE_B;
	}

	public void visit(Equals entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPEQ, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(NotEquals entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPNE, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(LessThan entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPLT, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(LessOrEquals entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPLE, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(GreaterThan entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPGT, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}

	public void visit(GreaterOrEquals entity) {
		entity.getExp1().accept(this);
		entity.getExp2().accept(this);
        Label iftrue = new Label();
        Label end = new Label();
        mv().visitJumpInsn(IF_ICMPGE, iftrue);
        mv().visitInsn(ICONST_0);
        mv().visitJumpInsn(GOTO, end);
        mv().visitLabel(iftrue);
        mv().visitInsn(ICONST_1);
        mv().visitLabel(end);
		resultType = TYPE_B;
	}
}
