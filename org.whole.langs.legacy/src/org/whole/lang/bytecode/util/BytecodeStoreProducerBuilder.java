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
package org.whole.lang.bytecode.util;

import java.util.Date;

import org.objectweb.asm.*;
import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public class BytecodeStoreProducerBuilder implements IBuilder, Opcodes {
//	private List<ClassWriter> cwList = new ArrayList<ClassWriter>();
	private ClassWriter cw;
	private MethodVisitor mv;
	private String builderInterfaceInternalName;
	private int varNum = 2;

	public byte[] getResult() {
		return cw.toByteArray();
	}

	public static void visitIntInsn(MethodVisitor mv, int value) {
		switch (value) {
		case -1:
			mv.visitInsn(ICONST_M1);
			break;
		case 0:
			mv.visitInsn(ICONST_0);
			break;
		case 1:
			mv.visitInsn(ICONST_1);
			break;
		case 2:
			mv.visitInsn(ICONST_2);
			break;
		case 3:
			mv.visitInsn(ICONST_3);
			break;
		case 4:
			mv.visitInsn(ICONST_4);
			break;
		case 5:
			mv.visitInsn(ICONST_5);
			break;
		default:
			if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE)
				mv.visitIntInsn(BIPUSH, value);
			else
				mv.visitIntInsn(SIPUSH, value);
		}
	}

	public static String getInternalName(String type) {
		return Type.getType(type).getInternalName();
	}
    public static String getMethodDescriptor(final Class<?> res, final Class<?> arg0) {
        final StringBuffer buf = new StringBuffer();
        buf.append('(');

        buf.append(Type.getDescriptor(arg0));

        buf.append(')');
        buf.append(Type.getDescriptor(res));
        return buf.toString();
    }

	public void buildStartCompilationUnit(String packageName, String className) {
		cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		String classInternalName = Type.getType(packageName.length()>0 ? packageName+'.'+className : className).getInternalName();
		String superInternalName = Type.getInternalName(AbstractTemplateFactory.class);

		cw.visit(V1_4, ACC_PUBLIC+ACC_SUPER,
				classInternalName, null, superInternalName, null);
		cw.visitSource(className+".java", null);

		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, superInternalName, "<init>", "()V");
		mv.visitInsn(RETURN);
		mv.visitEnd();
		
		mv = cw.visitMethod(ACC_PUBLIC, "apply", getMethodDescriptor(Void.TYPE, IBuilderOperation.class), null, null);
		mv.visitCode();
	}
	public void buildEndCompilationUnit() {
	    mv.visitInsn(RETURN);
        mv.visitEnd();
	}

	public void ensureBuilder(ILanguageKit languageKit) {
		//TODO
	}
	protected void buildGetBuilder(ILanguageKit languageKit, String builderType) {
		builderInterfaceInternalName = getInternalName(builderType);
		
		mv.visitVarInsn(ALOAD, 1);
		mv.visitLdcInsn(languageKit.getClass().getName());
		mv.visitMethodInsn(INVOKEINTERFACE,
				Type.getInternalName(IBuilderOperation.class),
				"wGetBuilder",
				getMethodDescriptor(IBuilder.class, String.class));
		mv.visitTypeInsn(CHECKCAST, builderInterfaceInternalName);
		mv.visitVarInsn(ASTORE, varNum);
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.startBuildName(entityDesc),
				"()V");
	}
	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);

		visitIntInsn(mv, initialCapacity);
		
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.startBuildName(entityDesc),
				"(I)V");
	}
    public void _wEntity(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.endBuildName(entityDesc),
				"()V");
    }
    public void wEntity(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.buildName(entityDesc),
				"()V");
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		mv.visitInsn(value ? ICONST_1 : ICONST_0);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.buildName(entityDesc),
				"(Z)V");		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		ensureBuilder(entityDesc.getLanguageKit());
		

		wEntity(entityDesc, value);
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		ensureBuilder(entityDesc.getLanguageKit());
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		ensureBuilder(entityDesc.getLanguageKit());
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		ensureBuilder(entityDesc.getLanguageKit());
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		visitIntInsn(mv, value);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.buildName(entityDesc),
				"(I)V");
	}
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		ensureBuilder(entityDesc.getLanguageKit());
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		ensureBuilder(entityDesc.getLanguageKit());
		
	}
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		ensureBuilder(entityDesc.getLanguageKit());
		mv.visitVarInsn(ALOAD, varNum);
		mv.visitLdcInsn(value);
		mv.visitMethodInsn(INVOKEINTERFACE,
				builderInterfaceInternalName,
				BuilderConstants.buildName(entityDesc),
				"(Ljava/lang/String;)V");
	}
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
		ensureBuilder(entityDesc.getLanguageKit());

	}
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		ensureBuilder(entityDesc.getLanguageKit());

	}
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		
	}

    
    
	public void wSetBuilderContext(IBuilderContext context) {
	}
	public void wSetEntityContext(IEntityContext context) {
	}

	public void wDefault() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wEntity() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wEntity_() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void _wEntity() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(int index) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(FeatureDescriptor feature) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(ITemplate template) {
		// TODO
		throw new UnsupportedOperationException();
	}
}
