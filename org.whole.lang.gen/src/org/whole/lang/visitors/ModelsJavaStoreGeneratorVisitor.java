package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifiers;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.DataType;
import org.whole.lang.models.model.EntityModifier;
import org.whole.lang.models.model.EntityModifiers;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValue;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.FeatureModifiers;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.MapEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.TypeRelations;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.visitors.ModelsIdentityVisitor;

/** 
 * @generator Whole
 */
public class ModelsJavaStoreGeneratorVisitor extends ModelsIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public ModelsJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.models.model.ModelsLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(IModelsEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(SimpleName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "SimpleName", callExp);
	}

	public void visit(Types entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypes");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(builder.newArrayCreation("Type", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Types", callExp);
	}

	public void visit(TypeRelations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeRelations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(builder.newArrayCreation("Type", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "TypeRelations", callExp);
	}

	public void visit(Model entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createModel");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypeRelations()));
		callExp.arguments().add(astOf(entity.getDeclarations()));
		builder.addSubtree(parentNestingSize, "Model", callExp);
	}

	public void visit(ModelDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createModelDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ModelDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ModelDeclarations", callExp);
	}

	public void visit(SimpleEntity entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleEntity");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getFeatures()));
		builder.addSubtree(parentNestingSize, "SimpleEntity", callExp);
	}

	public void visit(EntityModifiers entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEntityModifiers");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IEntityModifier", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "EntityModifiers", callExp);
	}

	public void visit(EntityModifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEntityModifier");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "EntityModifier", callExp);
	}

	public void visit(Features entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFeatures");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IFeature", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Features", callExp);
	}

	public void visit(Feature entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFeature");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "Feature", callExp);
	}

	public void visit(FeatureModifiers entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFeatureModifiers");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IFeatureModifier", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "FeatureModifiers", callExp);
	}

	public void visit(FeatureModifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFeatureModifier");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "FeatureModifier", callExp);
	}

	public void visit(CompositeEntity entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCompositeEntity");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getComponentModifiers()));
		callExp.arguments().add(astOf(entity.getComponentType()));
		builder.addSubtree(parentNestingSize, "CompositeEntity", callExp);
	}

	public void visit(ComponentModifiers entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createComponentModifiers");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IComponentModifier", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ComponentModifiers", callExp);
	}

	public void visit(ComponentModifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createComponentModifier");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ComponentModifier", callExp);
	}

	public void visit(MapEntity entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMapEntity");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getKeyType()));
		callExp.arguments().add(astOf(entity.getValueType()));
		builder.addSubtree(parentNestingSize, "MapEntity", callExp);
	}

	public void visit(DataEntity entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDataEntity");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getDataType()));
		builder.addSubtree(parentNestingSize, "DataEntity", callExp);
	}

	public void visit(DataType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDataType");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "DataType", callExp);
	}

	public void visit(EnumEntity entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumEntity");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getValues()));
		builder.addSubtree(parentNestingSize, "EnumEntity", callExp);
	}

	public void visit(EnumValues entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumValues");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IEnumValue", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IModelsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "EnumValues", callExp);
	}

	public void visit(EnumValue entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumValue");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "EnumValue", callExp);
	}
}