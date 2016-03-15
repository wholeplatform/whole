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
package org.whole.lang.java.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.java.builders.IJavaBuilder;
import org.whole.lang.java.model.PrimitiveTypeEnum;
import org.whole.lang.java.reflect.JavaLanguageKit;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class JavaStoreProducerBuilder implements IBuilder {
	private static final int MAX_METHOD_STATEMENTS = 5000;
	private IJavaBuilder jb; 
	private ICommonsBuilder cb; 
	private Map<ILanguageKit, String> builderNameMap = new HashMap<ILanguageKit, String>();
	private Map<ILanguageKit, String> edEnumNameMap = new HashMap<ILanguageKit, String>();
	private static final String builderPrefix = "b";
	private static final String edEnumPrefix = "e";
	private String builderName = "b";
	private String edEnumName = "e";
	private int builderIndex = 0;
	private int methodStatements = 0;
	private int methodCount = 0;
	private Strategy STRATEGY_FOR_STATIC;
	private Strategy STRATEGY_FOR_DYNAMIC;
	private Strategy strategy;

	public JavaStoreProducerBuilder(IBuilderOperation targetOperation) {
		this(targetOperation, true, false);
	}
	public JavaStoreProducerBuilder(IBuilderOperation targetOperation, boolean specific, boolean force) {
		jb = (IJavaBuilder) targetOperation.wGetBuilder(JavaLanguageKit.URI);
		cb = (ICommonsBuilder) targetOperation.wGetBuilder(CommonsLanguageKit.URI);
		withStrategy(specific, force);
	}

	public IBuilder withStrategy(boolean specific, boolean force) {
		STRATEGY_FOR_STATIC = specific ? new SpecificStrategy() : new GenericStrategy();
		STRATEGY_FOR_DYNAMIC = force ? STRATEGY_FOR_STATIC : null;
		return this;
	}

	public void buildStartCompilationUnit(String packageName, String className) {
		buildStartCompilationUnit(packageName, className, null);
	}
	public void buildStartCompilationUnit(String packageName, String className, String templateClassName) {
		jb.CompilationUnit_();
		if (packageName == null || packageName.length()==0)
			cb.Resolver();
		else {
			jb.PackageDeclaration_();
			jb.Javadoc();
			cb.Resolver();
			jb.SimpleName(packageName);
			jb._PackageDeclaration();
		}
		
		jb.ImportDeclarations_();
		jb.ImportDeclaration_();
		jb.QualifiedName(IBuilderOperation.class.getName());
		jb.ImportModifier(false);
		jb.ImportModifier(false);
		jb._ImportDeclaration();
		jb.ImportDeclaration_();
		jb.QualifiedName(AbstractTemplateFactory.class.getName());
		jb.ImportModifier(false);
		jb.ImportModifier(false);
		jb._ImportDeclaration();
		jb._ImportDeclarations();
		
		jb.TypeDeclarations_(1);
		jb.ClassDeclaration_();
		jb.Javadoc();
		jb.ExtendedModifiers_(1);
		jb.Modifier("public");
		jb._ExtendedModifiers();
		jb.SimpleName(className);
		jb.TypeParameters();
		if (templateClassName != null) {
			jb.ParameterizedType_();
			jb.SimpleType("AbstractTemplateFactory");
			jb.Types_(1);
			jb.QualifiedType(templateClassName);
			jb._Types();
			jb._ParameterizedType();
		} else
			jb.SimpleType("AbstractTemplateFactory");
		jb.Types();
		jb.BodyDeclarations_(1);
		jb.MethodDeclaration_();
		jb.Javadoc();
		jb.ExtendedModifiers_(1);
		jb.Modifier("public");
		jb._ExtendedModifiers();
		jb.TypeParameters();
		jb.PrimitiveType("void");
		jb.SimpleName("apply");
		jb.Parameters_(1);
		jb.SingleVariableDeclaration_();
		jb.ExtendedModifiers();
		jb.SimpleType("IBuilderOperation");
		jb.Varargs(false);
		jb.SimpleName("op");
		jb.ExtraDimensions();
		jb._SingleVariableDeclaration();
		jb._Parameters();
		jb.ExtraDimensions();
		jb.Types();
		jb.Block_();
	}
	public void buildEndCompilationUnit() {
		jb._Block();
		
		jb._MethodDeclaration();
		jb._BodyDeclarations();
		jb._ClassDeclaration();

		jb._TypeDeclarations();
		jb._CompilationUnit();
	}

	public void buildStartBlock() {
		jb.Block_();
	}
	public void buildEndBlock() {
		jb._Block();
	}

	protected void ensureMethodSizeLimit() {
		if (methodStatements++ == MAX_METHOD_STATEMENTS) {
			methodStatements = 0;
			String nextMethodName = "apply" + Integer.toString(methodCount++);

			// apply0(op);
			jb.ExpressionStatement_();
			jb.MethodInvocation_();
			cb.Resolver();
			jb.Types();
			jb.SimpleName(nextMethodName);
			jb.Arguments_();
			jb.SimpleName("op");
			jb._Arguments();
			jb._MethodInvocation();
			jb._ExpressionStatement();

			// }
			jb._Block();
			jb._MethodDeclaration();

			// private void apply0(IBuilderOperation op) {
			jb.MethodDeclaration_();
			jb.Javadoc();
			jb.ExtendedModifiers_(1);
			jb.Modifier("private");
			jb._ExtendedModifiers();
			jb.TypeParameters();
			jb.PrimitiveType("void");
			jb.SimpleName(nextMethodName);
			jb.Parameters_(1);
			jb.SingleVariableDeclaration_();
			jb.ExtendedModifiers();
			jb.SimpleType("IBuilderOperation");
			jb.Varargs(false);
			jb.SimpleName("op");
			jb.ExtraDimensions();
			jb._SingleVariableDeclaration();
			jb._Parameters();
			jb.ExtraDimensions();
			jb.Types();
			jb.Block_();

			builderNameMap.clear();
			edEnumNameMap.clear();
		}
	}

	protected void ensureBuilder(EntityDescriptor<?> ed) {
		ensureMethodSizeLimit();

		ILanguageKit languageKit = ed.getLanguageKit();
		ILanguageKit builderLanguageKit = languageKit;

		if (languageKit.isDynamic()) {
			builderLanguageKit = ReflectionFactory.getLanguageKit(CommonsLanguageKit.URI);
			if (STRATEGY_FOR_DYNAMIC == null)
				STRATEGY_FOR_DYNAMIC = new SymbolicStrategy();
			strategy = STRATEGY_FOR_DYNAMIC;
		} else
			strategy = STRATEGY_FOR_STATIC;

		builderName = builderNameMap.get(builderLanguageKit);
		if (builderName == null) {
			builderName = builderPrefix + builderIndex++;
			builderNameMap.put(builderLanguageKit, builderName);
			
			buildGetBuilder(builderLanguageKit);
		}
		if (languageKit.isDynamic()) {
			edEnumName = edEnumNameMap.get(languageKit);
			if (edEnumName == null) {
				edEnumName = edEnumPrefix + builderIndex++;
				edEnumNameMap.put(languageKit, edEnumName);
				
				buildGetEntityDescriptorEnum(languageKit);
			}
		}
	}

	protected void buildGetBuilder(ILanguageKit languageKit) {
		String builderType = BuilderConstants.builderType(languageKit);
		jb.VariableDeclarationStatement_();
		jb.ExtendedModifiers();
		jb.SimpleType(builderType);
		jb.VariableDeclarationFragments_(1);
		jb.VariableDeclarationFragment_();
		jb.SimpleName(builderName);
		jb.ExtraDimensions();
		jb.CastExpression_();
		jb.SimpleType(builderType);
		jb.MethodInvocation_();
		jb.SimpleName("op");
		jb.Types();
		jb.SimpleName("wGetBuilder");
		jb.Arguments_(1);
		jb.QualifiedName(languageKit.getClass().getName()+".URI");
		jb._Arguments();
		jb._MethodInvocation();
		jb._CastExpression();
		jb._VariableDeclarationFragment();
		jb._VariableDeclarationFragments();
		jb._VariableDeclarationStatement();
	}
	protected void buildGetEntityDescriptorEnum(ILanguageKit languageKit) {
		jb.VariableDeclarationStatement_();
		jb.ExtendedModifiers();
		jb.SimpleType(EntityDescriptorEnum.class.getName());
		jb.VariableDeclarationFragments_(1);
		jb.VariableDeclarationFragment_();
		jb.SimpleName(edEnumName);
		jb.ExtraDimensions();
		jb.MethodInvocation_();
		jb.MethodInvocation_();
		jb.QualifiedName("org.whole.lang.reflect.ReflectionFactory");
		jb.Types();
		jb.SimpleName("getLanguageKit");
		jb.Arguments_(1);
		jb.StringLiteral(languageKit.getURI());
		jb._Arguments();
		jb._MethodInvocation();
		jb.Types();
		jb.SimpleName("getEntityDescriptorEnum");
		jb.Arguments();
		jb._MethodInvocation();
		jb._VariableDeclarationFragment();
		jb._VariableDeclarationFragments();
		jb._VariableDeclarationStatement();
	}

	
	protected void buildDataEntity_(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc);
		jb.ExpressionStatement_();
		jb.MethodInvocation_();
		jb.SimpleName(builderName);
		jb.Types();
		strategy.buildDataEntity_(entityDesc);
	}
	protected void _buildDataEntity() {
		jb._Arguments();
		jb._MethodInvocation();
		jb._ExpressionStatement();
	}


    public void wEntity(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc);
		jb.ExpressionStatement_();
		jb.MethodInvocation_();
		jb.SimpleName(builderName);
		jb.Types();
		strategy.buildEntity(entityDesc);
		jb._MethodInvocation();
		jb._ExpressionStatement();
    }
	public void wEntity_(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc);
		jb.ExpressionStatement_();
		jb.MethodInvocation_();
		jb.SimpleName(builderName);
		jb.Types();
		strategy.buildSimpleEntity_(entityDesc);
		jb._MethodInvocation();
		jb._ExpressionStatement();
	}
	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		ensureBuilder(entityDesc);
		jb.ExpressionStatement_();
		jb.MethodInvocation_();
		jb.SimpleName(builderName);
		jb.Types();
		strategy.buildCompositeEntity_(entityDesc);
		jb.IntLiteral(initialCapacity);
		jb._Arguments();
		jb._MethodInvocation();
		jb._ExpressionStatement();
	}
    public void _wEntity(EntityDescriptor<?> entityDesc) {
		ensureBuilder(entityDesc);
		jb.ExpressionStatement_();
		jb.MethodInvocation_();
		jb.SimpleName(builderName);
		jb.Types();
		strategy._buildEntity(entityDesc);
		jb._MethodInvocation();
		jb._ExpressionStatement();
    }


	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		buildDataEntity_(entityDesc);
		jb.BooleanLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		buildDataEntity_(entityDesc);
		jb.CastExpression_();
		jb.PrimitiveType(PrimitiveTypeEnum._byte);
		jb.ByteLiteral(value);
		jb._CastExpression();
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		buildDataEntity_(entityDesc);
		jb.CharLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		buildDataEntity_(entityDesc);
		boolean nan = Double.isNaN(value), infinite = Double.isInfinite(value);
		if (nan || infinite) {
			jb.FieldAccess_();
			jb.SimpleName("Double");
			jb.SimpleName(nan ? "NaN"  : (Double.compare(value, 0) < 0 ? "NEGATIVE_INFINITY" : "POSITIVE_INFINITY"));
			jb._FieldAccess();
		} else 
			jb.DoubleLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		buildDataEntity_(entityDesc);
		boolean nan = Float.isNaN(value), infinite = Float.isInfinite(value);
		if (nan || infinite) {
			jb.FieldAccess_();
			jb.SimpleName("Float");
			jb.SimpleName(nan ? "NaN"  : (Float.compare(value, 0) < 0 ? "NEGATIVE_INFINITY" : "POSITIVE_INFINITY"));
			jb._FieldAccess();
		} else 
			jb.FloatLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		buildDataEntity_(entityDesc);
		jb.IntLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		buildDataEntity_(entityDesc);
		jb.LongLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		buildDataEntity_(entityDesc);
		jb.CastExpression_();
		jb.PrimitiveType(PrimitiveTypeEnum._short);
		jb.ShortLiteral(value);
		jb._CastExpression();
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		buildDataEntity_(entityDesc);
		jb.StringLiteral(value);
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
		buildDataEntity_(entityDesc);
		jb.ClassInstanceCreation_();
        cb.Resolver();
        cb.Resolver();
        jb.QualifiedType("java.util.Date");
        jb.Arguments_(1);
        jb.LongLiteral(value.getTime());
        jb._Arguments();
        cb.Resolver();
        jb._ClassInstanceCreation();
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		buildDataEntity_(entityDesc);
		jb.StringLiteral(DataTypeUtils.getDataTypeParser(entityDesc, DataTypeParsers.PERSISTENCE)
				.unparseEnumValue(entityDesc, value));
		_buildDataEntity();
	}
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		buildDataEntity_(entityDesc);
		if (value == null) {
			jb.CastExpression_();
			jb.SimpleType("Object");
			jb.NullLiteral();
			jb._CastExpression();
		} else
			jb.StringLiteral(DataTypeUtils.getDataTypeParser(entityDesc, DataTypeParsers.PERSISTENCE)
					.unparseObject(entityDesc, value));
		_buildDataEntity();
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

	protected interface Strategy {
		public void buildDataEntity_(EntityDescriptor<?> ed);
		public void buildEntity(EntityDescriptor<?> ed);
		public void buildSimpleEntity_(EntityDescriptor<?> ed);
		public void buildCompositeEntity_(EntityDescriptor<?> ed);
		public void _buildEntity(EntityDescriptor<?> ed);
	}
	protected class SpecificStrategy implements Strategy {
		public void buildDataEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.buildName(ed));
			jb.Arguments_(1);
		}
		public void buildEntity(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.buildName(ed));
			jb.Arguments_(0);
			jb._Arguments();
		}
		public void buildSimpleEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.startBuildName(ed));
			jb.Arguments_(0);
			jb._Arguments();
		}
		public void buildCompositeEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.startBuildName(ed));
			jb.Arguments_(1);
		}
		public void _buildEntity(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.endBuildName(ed));
			jb.Arguments_(0);
			jb._Arguments();
		}
	}
	protected abstract class AbstractStrategy implements Strategy {
		public void buildDataEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.buildName());
			jb.Arguments_(2);
			buildTarget(ed);
		}
		public void buildEntity(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.buildName());
			jb.Arguments_(1);
			buildTarget(ed);
			jb._Arguments();
		}
		public void buildSimpleEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.startBuildName());
			jb.Arguments_(1);
			buildTarget(ed);
			jb._Arguments();
		}
		public void buildCompositeEntity_(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.startBuildName());
			jb.Arguments_(2);
			buildTarget(ed);
		}
		public void _buildEntity(EntityDescriptor<?> ed) {
			jb.SimpleName(BuilderConstants.endBuildName());
			jb.Arguments_(1);
			buildTarget(ed);
			jb._Arguments();
		}
		protected abstract void buildTarget(EntityDescriptor<?> ed);
	}
	protected class GenericStrategy extends AbstractStrategy {
		protected final void buildTarget(EntityDescriptor<?> ed) {
			jb.FieldAccess_();
			jb.SimpleName(ed.getEntityDescriptorEnum().getClass().getName());
			jb.SimpleName(ed.getImplName());
			jb._FieldAccess();
		}		
	}
	protected class SymbolicStrategy extends AbstractStrategy {
		protected final void buildTarget(EntityDescriptor<?> ed) {
			jb.MethodInvocation_();
			jb.SimpleName(edEnumName);
			jb.Types();
			jb.SimpleName("valueOf");
			jb.Arguments_(1);
			jb.StringLiteral(ed.getName());
			jb._Arguments();
			jb._MethodInvocation();
		}
	}
}
