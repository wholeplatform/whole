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
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.AbstractOperation;

/**
 * @author Riccardo Solmi
 */
public class BytecodeGeneratorOperation extends AbstractOperation implements Opcodes {
	public static final String ID ="toASMBytecode";

	private ClassWriter classWriter;
	private ClassVisitor classVisitor;
	private MethodVisitor methodVisitor;

	public static byte[] compile(IEntity program, IBindingManager args) {
		BytecodeGeneratorOperation gen = new BytecodeGeneratorOperation(args);
		gen.stagedVisit(program);
		return gen.getResult();
	}

	protected BytecodeGeneratorOperation(IBindingManager args) {
		super(ID, args, false);
	}

	public byte[] getResult() {
		return classWriter.toByteArray();
	}

	public ClassVisitor getClassVisitor() {
		if (classVisitor == null) {
			classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

			//FIXME print nothing
//			ClassVisitor cc = new CheckClassAdapter(classWriter);
//			ClassVisitor tv = new TraceClassVisitor(cc, new PrintWriter(System.out));
//			classVisitor = tv;
			classVisitor = classWriter;

			classVisitor.visit(V1_4, ACC_PUBLIC, "Example", null, "java/lang/Object", null);
			
			//default constructor
		    MethodVisitor mv = classVisitor.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		    mv.visitCode();
		    mv.visitVarInsn(ALOAD, 0);
		    mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		    mv.visitInsn(RETURN);
		    mv.visitMaxs(1, 1);
	        mv.visitEnd();
		}
		return classVisitor;
	}

	public void setClassVisitor(ClassWriter cw) {
		this.classVisitor = cw;
	}

	public MethodVisitor getMethodVisitor() {
		return methodVisitor;
	}

	public void setMethodVisitor(MethodVisitor methodVisitor) {
		this.methodVisitor = methodVisitor;
	}

}
