package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.editors.model.ChildPlace;
import org.whole.lang.editors.model.ControllerComponent;
import org.whole.lang.editors.model.ControllerDeclarations;
import org.whole.lang.editors.model.DelimiterToken;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.editors.model.EntityFeatures;
import org.whole.lang.editors.model.EntityNames;
import org.whole.lang.editors.model.FoldableTextualFigure;
import org.whole.lang.editors.model.FoldingToggle;
import org.whole.lang.editors.model.GenericPartDeclaration;
import org.whole.lang.editors.model.GenericPartName;
import org.whole.lang.editors.model.IEditorsEntity;
import org.whole.lang.editors.model.Identifier;
import org.whole.lang.editors.model.IdentifierToken;
import org.whole.lang.editors.model.Indent;
import org.whole.lang.editors.model.JavaPartDeclaration;
import org.whole.lang.editors.model.KeywordToken;
import org.whole.lang.editors.model.LiteralToken;
import org.whole.lang.editors.model.ModelComponent;
import org.whole.lang.editors.model.OperatorToken;
import org.whole.lang.editors.model.ParenthesisToken;
import org.whole.lang.editors.model.PartDeclaration;
import org.whole.lang.editors.model.Row;
import org.whole.lang.editors.model.SimpleFigureDeclaration;
import org.whole.lang.editors.model.TextualFigure;
import org.whole.lang.editors.model.ViewComponent;
import org.whole.lang.editors.model.ViewDeclarations;
import org.whole.lang.editors.visitors.EditorsIdentityVisitor;

/** 
 * @generator Whole
 */
public class EditorsJavaStoreGeneratorVisitor extends EditorsIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public EditorsJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.editors.model.EditorsLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(
			IEditorsEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(Editor entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEditor");
		callExp.arguments().add(astOf(entity.getEditorName()));
		callExp.arguments().add(astOf(entity.getSuperEditorName()));
		callExp.arguments().add(astOf(entity.getModelComponent()));
		callExp.arguments().add(astOf(entity.getViewComponent()));
		callExp.arguments().add(astOf(entity.getControllerComponent()));
		builder.addSubtree(parentNestingSize, "Editor", callExp);
	}

	public void visit(ModelComponent entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createModelComponent");
		callExp.arguments().add(astOf(entity.getModelName()));
		builder.addSubtree(parentNestingSize, "ModelComponent", callExp);
	}

	public void visit(ControllerComponent entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createControllerComponent");
		callExp.arguments().add(astOf(entity.getDeclarations()));
		builder.addSubtree(parentNestingSize, "ControllerComponent", callExp);
	}

	public void visit(ControllerDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createControllerDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments()
				.add(
						builder.newArrayCreation("ControllerDeclaration",
								initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder
				.addSubtree(parentNestingSize, "ControllerDeclarations",
						callExp);
	}

	public void visit(PartDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPartDeclaration");
		callExp.arguments().add(astOf(entity.getPartName()));
		callExp.arguments().add(astOf(entity.getEntityName()));
		callExp.arguments().add(astOf(entity.getFigureName()));
		callExp.arguments().add(astOf(entity.getEntityFeatures()));
		builder.addSubtree(parentNestingSize, "PartDeclaration", callExp);
	}

	public void visit(JavaPartDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createJavaPartDeclaration");
		callExp.arguments().add(astOf(entity.getPartName()));
		callExp.arguments().add(astOf(entity.getEntityNames()));
		builder.addSubtree(parentNestingSize, "JavaPartDeclaration", callExp);
	}

	public void visit(GenericPartDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createGenericPartDeclaration");
		callExp.arguments().add(astOf(entity.getPartName()));
		callExp.arguments().add(astOf(entity.getEntityNames()));
		builder
				.addSubtree(parentNestingSize, "GenericPartDeclaration",
						callExp);
	}

	public void visit(EntityFeatures entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEntityFeatures");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("FeatureName", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "EntityFeatures", callExp);
	}

	public void visit(GenericPartName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createGenericPartName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "GenericPartName", callExp);
	}

	public void visit(ViewComponent entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createViewComponent");
		callExp.arguments().add(astOf(entity.getDeclarations()));
		builder.addSubtree(parentNestingSize, "ViewComponent", callExp);
	}

	public void visit(ViewDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createViewDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ViewDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ViewDeclarations", callExp);
	}

	public void visit(SimpleFigureDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleFigureDeclaration");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getFigure()));
		builder.addSubtree(parentNestingSize, "SimpleFigureDeclaration",
				callExp);
	}

	public void visit(FoldableTextualFigure entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFoldableTextualFigure");
		callExp.arguments().add(astOf(entity.getExpandedFigure()));
		callExp.arguments().add(astOf(entity.getCollapsedFigure()));
		builder.addSubtree(parentNestingSize, "FoldableTextualFigure", callExp);
	}

	public void visit(TextualFigure entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTextualFigure");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(builder.newArrayCreation("IRow", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "TextualFigure", callExp);
	}

	public void visit(Row entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createRow");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("RowElement", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Row", callExp);
	}

	public void visit(ChildPlace entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createChildPlace");
		builder.addSubtree(parentNestingSize, "ChildPlace", callExp);
	}

	public void visit(Indent entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIndent");
		builder.addSubtree(parentNestingSize, "Indent", callExp);
	}

	public void visit(FoldingToggle entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFoldingToggle");
		builder.addSubtree(parentNestingSize, "FoldingToggle", callExp);
	}

	public void visit(KeywordToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createKeywordToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "KeywordToken", callExp);
	}

	public void visit(LiteralToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLiteralToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "LiteralToken", callExp);
	}

	public void visit(IdentifierToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIdentifierToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "IdentifierToken", callExp);
	}

	public void visit(OperatorToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createOperatorToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "OperatorToken", callExp);
	}

	public void visit(DelimiterToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDelimiterToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "DelimiterToken", callExp);
	}

	public void visit(ParenthesisToken entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createParenthesisToken");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ParenthesisToken", callExp);
	}

	public void visit(EntityNames entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEntityNames");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("EntityName", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IEditorsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "EntityNames", callExp);
	}

	public void visit(Identifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIdentifier");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Identifier", callExp);
	}
}