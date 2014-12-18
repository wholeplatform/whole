package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.JavaIdentityVisitor;

/** 
 * @generator Whole
 */
public class JavaJavaStoreGeneratorVisitor extends JavaIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public JavaJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.java.model.JavaLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(IJavaEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(JavaSystemSoftware entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createJavaSystemSoftware");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ICompilationUnit", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "JavaSystemSoftware", callExp);
	}

	public void visit(CompilationUnit entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCompilationUnit");
		callExp.arguments().add(astOf(entity.getPackage()));
		callExp.arguments().add(astOf(entity.getImports()));
		callExp.arguments().add(astOf(entity.getTypes()));
		builder.addSubtree(parentNestingSize, "CompilationUnit", callExp);
	}

	public void visit(PackageDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPackageDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "PackageDeclaration", callExp);
	}

	public void visit(BlockComment entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBlockComment");
		callExp.arguments().add(astOf(entity.getDocElements()));
		builder.addSubtree(parentNestingSize, "BlockComment", callExp);
	}

	public void visit(LineComment entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLineComment");
		callExp.arguments().add(astOf(entity.getText()));
		builder.addSubtree(parentNestingSize, "LineComment", callExp);
	}

	public void visit(Javadoc entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createJavadoc");
		callExp.arguments().add(astOf(entity.getTags()));
		builder.addSubtree(parentNestingSize, "Javadoc", callExp);
	}

	public void visit(Tags entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTags");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ITagElement", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Tags", callExp);
	}

	public void visit(DocElements entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDocElements");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("DocElement", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "DocElements", callExp);
	}

	public void visit(MethodRef entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMethodRef");
		callExp.arguments().add(astOf(entity.getQualifier()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getParameters()));
		builder.addSubtree(parentNestingSize, "MethodRef", callExp);
	}

	public void visit(MethodRefParameters entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMethodRefParameters");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IMethodRefParameter", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "MethodRefParameters", callExp);
	}

	public void visit(MethodRefParameter entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMethodRefParameter");
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "MethodRefParameter", callExp);
	}

	public void visit(MemberRef entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMemberRef");
		callExp.arguments().add(astOf(entity.getQualifier()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "MemberRef", callExp);
	}

	public void visit(TextElement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTextElement");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "TextElement", callExp);
	}

	public void visit(TagElement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTagElement");
		callExp.arguments().add(astOf(entity.getTagName()));
		callExp.arguments().add(astOf(entity.getFragments()));
		builder.addSubtree(parentNestingSize, "TagElement", callExp);
	}

	public void visit(TagName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTagName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "TagName", callExp);
	}

	public void visit(Annotations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAnnotations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Annotation", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Annotations", callExp);
	}

	public void visit(SingleMemberAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSingleMemberAnnotation");
		callExp.arguments().add(astOf(entity.getTypeName()));
		callExp.arguments().add(astOf(entity.getValue()));
		builder
				.addSubtree(parentNestingSize, "SingleMemberAnnotation",
						callExp);
	}

	public void visit(MarkerAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMarkerAnnotation");
		callExp.arguments().add(astOf(entity.getTypeName()));
		builder.addSubtree(parentNestingSize, "MarkerAnnotation", callExp);
	}

	public void visit(NormalAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNormalAnnotation");
		callExp.arguments().add(astOf(entity.getTypeName()));
		callExp.arguments().add(astOf(entity.getValues()));
		builder.addSubtree(parentNestingSize, "NormalAnnotation", callExp);
	}

	public void visit(MemberValuePairs entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMemberValuePairs");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IMemberValuePair", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "MemberValuePairs", callExp);
	}

	public void visit(MemberValuePair entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMemberValuePair");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getValue()));
		builder.addSubtree(parentNestingSize, "MemberValuePair", callExp);
	}

	public void visit(ImportDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createImportDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IImportDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ImportDeclarations", callExp);
	}

	public void visit(ImportDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createImportDeclaration");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getOnDemand()));
		callExp.arguments().add(astOf(entity.getStatic()));
		builder.addSubtree(parentNestingSize, "ImportDeclaration", callExp);
	}

	public void visit(ImportModifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createImportModifier");
		callExp.arguments().add(builder.newLiteral(entity.isValue()));
		builder.addSubtree(parentNestingSize, "ImportModifier", callExp);
	}

	public void visit(TypeDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("TypeDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "TypeDeclarations", callExp);
	}

	public void visit(EnumDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getSuperInterfaceTypes()));
		callExp.arguments().add(astOf(entity.getEnumConstants()));
		callExp.arguments().add(astOf(entity.getBodyDeclarations()));
		builder.addSubtree(parentNestingSize, "EnumDeclaration", callExp);
	}

	public void visit(EnumConstants entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumConstants");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IEnumConstantDeclaration",
						initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "EnumConstants", callExp);
	}

	public void visit(EnumConstantDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumConstantDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getArguments()));
		callExp.arguments().add(astOf(entity.getAnonymousClassDeclaration()));
		builder.addSubtree(parentNestingSize, "EnumConstantDeclaration",
				callExp);
	}

	public void visit(Arguments entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArguments");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Expression", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Arguments", callExp);
	}

	public void visit(AnonymousClassDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAnonymousClassDeclaration");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("BodyDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "AnonymousClassDeclaration",
				callExp);
	}

	public void visit(AnnotationTypeDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAnnotationTypeDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getBodyDeclarations()));
		builder.addSubtree(parentNestingSize, "AnnotationTypeDeclaration",
				callExp);
	}

	public void visit(ClassDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createClassDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypeParameters()));
		callExp.arguments().add(astOf(entity.getSuperclassType()));
		callExp.arguments().add(astOf(entity.getSuperInterfaceTypes()));
		callExp.arguments().add(astOf(entity.getBodyDeclarations()));
		builder.addSubtree(parentNestingSize, "ClassDeclaration", callExp);
	}

	public void visit(InterfaceDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createInterfaceDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypeParameters()));
		callExp.arguments().add(astOf(entity.getSuperInterfaceTypes()));
		callExp.arguments().add(astOf(entity.getBodyDeclarations()));
		builder.addSubtree(parentNestingSize, "InterfaceDeclaration", callExp);
	}

	public void visit(TypeParameters entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeParameters");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ITypeParameter", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "TypeParameters", callExp);
	}

	public void visit(TypeParameter entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeParameter");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypeBounds()));
		builder.addSubtree(parentNestingSize, "TypeParameter", callExp);
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
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Types", callExp);
	}

	public void visit(BodyDeclarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBodyDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("BodyDeclaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "BodyDeclarations", callExp);
	}

	public void visit(AnnotationTypeMemberDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this,
						"createAnnotationTypeMemberDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getDefault()));
		builder.addSubtree(parentNestingSize,
				"AnnotationTypeMemberDeclaration", callExp);
	}

	public void visit(Initializer entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createInitializer");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "Initializer", callExp);
	}

	public void visit(FieldDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFieldDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getFragments()));
		builder.addSubtree(parentNestingSize, "FieldDeclaration", callExp);
	}

	public void visit(MethodDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMethodDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getTypeParameters()));
		callExp.arguments().add(astOf(entity.getReturnType()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getParameters()));
		callExp.arguments().add(astOf(entity.getExtraDimensions()));
		callExp.arguments().add(astOf(entity.getThrownExceptions()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "MethodDeclaration", callExp);
	}

	public void visit(ConstructorDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createConstructorDeclaration");
		callExp.arguments().add(astOf(entity.getJavadoc()));
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getTypeParameters()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getParameters()));
		callExp.arguments().add(astOf(entity.getExtraDimensions()));
		callExp.arguments().add(astOf(entity.getThrownExceptions()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder
				.addSubtree(parentNestingSize, "ConstructorDeclaration",
						callExp);
	}

	public void visit(Parameters entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createParameters");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ISingleVariableDeclaration",
						initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Parameters", callExp);
	}

	public void visit(SingleVariableDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSingleVariableDeclaration");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getExtraDimensions()));
		callExp.arguments().add(astOf(entity.getInitializer()));
		builder.addSubtree(parentNestingSize, "SingleVariableDeclaration",
				callExp);
	}

	public void visit(ArrayType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayType");
		callExp.arguments().add(astOf(entity.getComponentType()));
		builder.addSubtree(parentNestingSize, "ArrayType", callExp);
	}

	public void visit(ParameterizedType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createParameterizedType");
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		builder.addSubtree(parentNestingSize, "ParameterizedType", callExp);
	}

	public void visit(PrimitiveType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPrimitiveType");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "PrimitiveType", callExp);
	}

	public void visit(QualifiedType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createQualifiedType");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "QualifiedType", callExp);
	}

	public void visit(SimpleType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleType");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "SimpleType", callExp);
	}

	public void visit(WildcardType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createWildcardType");
		callExp.arguments().add(astOf(entity.getBound()));
		callExp.arguments().add(astOf(entity.getUpperBound()));
		builder.addSubtree(parentNestingSize, "WildcardType", callExp);
	}

	public void visit(UpperBound entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createUpperBound");
		callExp.arguments().add(builder.newLiteral(entity.isValue()));
		builder.addSubtree(parentNestingSize, "UpperBound", callExp);
	}

	public void visit(AssertStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAssertStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getMessage()));
		builder.addSubtree(parentNestingSize, "AssertStatement", callExp);
	}

	public void visit(Block entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBlock");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Statement", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Block", callExp);
	}

	public void visit(BreakStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBreakStatement");
		callExp.arguments().add(astOf(entity.getLabel()));
		builder.addSubtree(parentNestingSize, "BreakStatement", callExp);
	}

	public void visit(ConstructorInvocation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createConstructorInvocation");
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		callExp.arguments().add(astOf(entity.getArguments()));
		builder.addSubtree(parentNestingSize, "ConstructorInvocation", callExp);
	}

	public void visit(ContinueStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createContinueStatement");
		callExp.arguments().add(astOf(entity.getLabel()));
		builder.addSubtree(parentNestingSize, "ContinueStatement", callExp);
	}

	public void visit(DoStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDoStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "DoStatement", callExp);
	}

	public void visit(EmptyStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEmptyStatement");
		builder.addSubtree(parentNestingSize, "EmptyStatement", callExp);
	}

	public void visit(EnhancedForStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnhancedForStatement");
		callExp.arguments().add(astOf(entity.getParameter()));
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "EnhancedForStatement", callExp);
	}

	public void visit(ExpressionStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createExpressionStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "ExpressionStatement", callExp);
	}

	public void visit(ForStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createForStatement");
		callExp.arguments().add(astOf(entity.getInitializers()));
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getUpdaters()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "ForStatement", callExp);
	}

	public void visit(Expressions entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createExpressions");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Expression", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Expressions", callExp);
	}

	public void visit(IfStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIfStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getThenStatement()));
		callExp.arguments().add(astOf(entity.getElseStatement()));
		builder.addSubtree(parentNestingSize, "IfStatement", callExp);
	}

	public void visit(LabeledStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLabeledStatement");
		callExp.arguments().add(astOf(entity.getLabel()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "LabeledStatement", callExp);
	}

	public void visit(ReturnStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createReturnStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "ReturnStatement", callExp);
	}

	public void visit(SuperConstructorInvocation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSuperConstructorInvocation");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		callExp.arguments().add(astOf(entity.getArguments()));
		builder.addSubtree(parentNestingSize, "SuperConstructorInvocation",
				callExp);
	}

	public void visit(SwitchCase entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSwitchCase");
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "SwitchCase", callExp);
	}

	public void visit(SwitchDefault entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSwitchDefault");
		builder.addSubtree(parentNestingSize, "SwitchDefault", callExp);
	}

	public void visit(SwitchStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSwitchStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getStatements()));
		builder.addSubtree(parentNestingSize, "SwitchStatement", callExp);
	}

	public void visit(Statements entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createStatements");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Statement", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Statements", callExp);
	}

	public void visit(SynchronizedStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSynchronizedStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "SynchronizedStatement", callExp);
	}

	public void visit(ThrowStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createThrowStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "ThrowStatement", callExp);
	}

	public void visit(TryStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTryStatement");
		callExp.arguments().add(astOf(entity.getBody()));
		callExp.arguments().add(astOf(entity.getCatchClauses()));
		callExp.arguments().add(astOf(entity.getFinally()));
		builder.addSubtree(parentNestingSize, "TryStatement", callExp);
	}

	public void visit(CatchClauses entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCatchClauses");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ICatchClause", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "CatchClauses", callExp);
	}

	public void visit(CatchClause entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCatchClause");
		callExp.arguments().add(astOf(entity.getException()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "CatchClause", callExp);
	}

	public void visit(TypeDeclarationStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeDeclarationStatement");
		callExp.arguments().add(astOf(entity.getTypeDeclaration()));
		builder.addSubtree(parentNestingSize, "TypeDeclarationStatement",
				callExp);
	}

	public void visit(VariableDeclarationStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this,
						"createVariableDeclarationStatement");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getFragments()));
		builder.addSubtree(parentNestingSize, "VariableDeclarationStatement",
				callExp);
	}

	public void visit(WhileStatement entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createWhileStatement");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getBody()));
		builder.addSubtree(parentNestingSize, "WhileStatement", callExp);
	}

	public void visit(SimpleName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "SimpleName", callExp);
	}

	public void visit(QualifiedName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createQualifiedName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "QualifiedName", callExp);
	}

	public void visit(NullLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNullLiteral");
		builder.addSubtree(parentNestingSize, "NullLiteral", callExp);
	}

	public void visit(BooleanLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBooleanLiteral");
		callExp.arguments().add(builder.newLiteral(entity.isValue()));
		builder.addSubtree(parentNestingSize, "BooleanLiteral", callExp);
	}

	public void visit(ByteLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createByteLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ByteLiteral", callExp);
	}

	public void visit(CharLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCharLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "CharLiteral", callExp);
	}

	public void visit(DoubleLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDoubleLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "DoubleLiteral", callExp);
	}

	public void visit(FloatLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFloatLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "FloatLiteral", callExp);
	}

	public void visit(IntLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIntLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "IntLiteral", callExp);
	}

	public void visit(ShortLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createShortLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ShortLiteral", callExp);
	}

	public void visit(LongLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLongLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "LongLiteral", callExp);
	}

	public void visit(StringLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createStringLiteral");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "StringLiteral", callExp);
	}

	public void visit(TypeLiteral entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createTypeLiteral");
		callExp.arguments().add(astOf(entity.getType()));
		builder.addSubtree(parentNestingSize, "TypeLiteral", callExp);
	}

	public void visit(ArrayAccess entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayAccess");
		callExp.arguments().add(astOf(entity.getArray()));
		callExp.arguments().add(astOf(entity.getIndex()));
		builder.addSubtree(parentNestingSize, "ArrayAccess", callExp);
	}

	public void visit(ArrayCreation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayCreation");
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getDimensions()));
		callExp.arguments().add(astOf(entity.getInitializer()));
		builder.addSubtree(parentNestingSize, "ArrayCreation", callExp);
	}

	public void visit(ArrayInitializer entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayInitializer");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Expression", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ArrayInitializer", callExp);
	}

	public void visit(Assignment entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAssignment");
		callExp.arguments().add(astOf(entity.getLeftHandSide()));
		callExp.arguments().add(astOf(entity.getOperator()));
		callExp.arguments().add(astOf(entity.getRightHandSide()));
		builder.addSubtree(parentNestingSize, "Assignment", callExp);
	}

	public void visit(AssignmentOperator entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAssignmentOperator");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "AssignmentOperator", callExp);
	}

	public void visit(CastExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCastExpression");
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "CastExpression", callExp);
	}

	public void visit(ClassInstanceCreation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createClassInstanceCreation");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getArguments()));
		callExp.arguments().add(astOf(entity.getAnonymousClassDeclaration()));
		builder.addSubtree(parentNestingSize, "ClassInstanceCreation", callExp);
	}

	public void visit(ConditionalExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createConditionalExpression");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getThenExpression()));
		callExp.arguments().add(astOf(entity.getElseExpression()));
		builder.addSubtree(parentNestingSize, "ConditionalExpression", callExp);
	}

	public void visit(FieldAccess entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFieldAccess");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "FieldAccess", callExp);
	}

	public void visit(InfixExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createInfixExpression");
		callExp.arguments().add(astOf(entity.getLeftOperand()));
		callExp.arguments().add(astOf(entity.getOperator()));
		callExp.arguments().add(astOf(entity.getRightOperand()));
		callExp.arguments().add(astOf(entity.getExtendedOperands()));
		builder.addSubtree(parentNestingSize, "InfixExpression", callExp);
	}

	public void visit(InfixOperator entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createInfixOperator");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "InfixOperator", callExp);
	}

	public void visit(InstanceofExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createInstanceofExpression");
		callExp.arguments().add(astOf(entity.getLeftOperand()));
		callExp.arguments().add(astOf(entity.getRightOperand()));
		builder.addSubtree(parentNestingSize, "InstanceofExpression", callExp);
	}

	public void visit(MethodInvocation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMethodInvocation");
		callExp.arguments().add(astOf(entity.getExpression()));
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getArguments()));
		builder.addSubtree(parentNestingSize, "MethodInvocation", callExp);
	}

	public void visit(ParenthesizedExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createParenthesizedExpression");
		callExp.arguments().add(astOf(entity.getExpression()));
		builder.addSubtree(parentNestingSize, "ParenthesizedExpression",
				callExp);
	}

	public void visit(PostfixExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPostfixExpression");
		callExp.arguments().add(astOf(entity.getOperand()));
		callExp.arguments().add(astOf(entity.getOperator()));
		builder.addSubtree(parentNestingSize, "PostfixExpression", callExp);
	}

	public void visit(PostfixOperator entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPostfixOperator");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "PostfixOperator", callExp);
	}

	public void visit(PrefixExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPrefixExpression");
		callExp.arguments().add(astOf(entity.getOperator()));
		callExp.arguments().add(astOf(entity.getOperand()));
		builder.addSubtree(parentNestingSize, "PrefixExpression", callExp);
	}

	public void visit(PrefixOperator entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPrefixOperator");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "PrefixOperator", callExp);
	}

	public void visit(SuperFieldAccess entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSuperFieldAccess");
		callExp.arguments().add(astOf(entity.getQualifier()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "SuperFieldAccess", callExp);
	}

	public void visit(SuperMethodInvocation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSuperMethodInvocation");
		callExp.arguments().add(astOf(entity.getQualifier()));
		callExp.arguments().add(astOf(entity.getTypeArguments()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getArguments()));
		builder.addSubtree(parentNestingSize, "SuperMethodInvocation", callExp);
	}

	public void visit(ThisExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createThisExpression");
		callExp.arguments().add(astOf(entity.getQualifier()));
		builder.addSubtree(parentNestingSize, "ThisExpression", callExp);
	}

	public void visit(VariableDeclarationExpression entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this,
						"createVariableDeclarationExpression");
		callExp.arguments().add(astOf(entity.getModifiers()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getFragments()));
		builder.addSubtree(parentNestingSize, "VariableDeclarationExpression",
				callExp);
	}

	public void visit(VariableDeclarationFragments entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this,
						"createVariableDeclarationFragments");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IVariableDeclarationFragment",
						initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "VariableDeclarationFragments",
				callExp);
	}

	public void visit(VariableDeclarationFragment entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createVariableDeclarationFragment");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getExtraDimensions()));
		callExp.arguments().add(astOf(entity.getInitializer()));
		builder.addSubtree(parentNestingSize, "VariableDeclarationFragment",
				callExp);
	}

	public void visit(ExtraDimensions entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createExtraDimensions");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ExtraDimensions", callExp);
	}

	public void visit(ExtendedModifiers entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createExtendedModifiers");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("ExtendedModifier", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IJavaEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ExtendedModifiers", callExp);
	}

	public void visit(Modifier entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createModifier");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Modifier", callExp);
	}
}