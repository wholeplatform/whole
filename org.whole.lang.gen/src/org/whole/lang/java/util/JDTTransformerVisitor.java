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

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.CreationReference;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionMethodReference;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.IntersectionType;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LambdaExpression;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NameQualifiedType;
import org.eclipse.jdt.core.dom.SuperMethodReference;
import org.eclipse.jdt.core.dom.TypeMethodReference;
import org.eclipse.jdt.core.dom.UnionType;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.Arguments;
import org.whole.lang.java.model.ClassDeclaration;
import org.whole.lang.java.model.ConstructorDeclaration;
import org.whole.lang.java.model.ConstructorReference;
import org.whole.lang.java.model.DocElements;
import org.whole.lang.java.model.Expressions;
import org.whole.lang.java.model.ExtendedModifiers;
import org.whole.lang.java.model.IJavaEntity;
import org.whole.lang.java.model.InterfaceDeclaration;
import org.whole.lang.java.model.MethodRefParameters;
import org.whole.lang.java.model.ModifierEnum;
import org.whole.lang.java.model.PrimitiveTypeEnum;
import org.whole.lang.java.model.TagName;
import org.whole.lang.java.model.Tags;
import org.whole.lang.java.model.Type;
import org.whole.lang.java.model.TypeDeclarations;
import org.whole.lang.java.model.VariableDeclarationFragments;
import org.whole.lang.java.parsers.JavaDataTypePersistenceParser;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class JDTTransformerVisitor extends ASTVisitor {
	private JavaEntityFactory lf;
	private JDTCommentsMapper commentsMapper;

	private org.whole.lang.java.model.CompilationUnit cu;
	private IBindingManager bindings;
	private org.whole.lang.java.model.Type type;
	private org.whole.lang.java.model.Javadoc javadoc;
	private org.whole.lang.java.model.DocElement docElement;
	private org.whole.lang.java.model.MethodRefParameter methodRefParameter;
	private org.whole.lang.java.model.Name name;
	private org.whole.lang.java.model.TypeParameter typeParameter;
	private org.whole.lang.java.model.Parameters params;
	private org.whole.lang.java.model.Types thrownExceptions;
	private org.whole.lang.java.model.SingleVariableDeclaration varDecl;
	private org.whole.lang.java.model.Block block;
	private org.whole.lang.java.model.Statement stm;
	private org.whole.lang.java.model.Comment comment;
	private org.whole.lang.java.model.Expression exp;
	private org.whole.lang.java.model.VariableDeclarationFragment varFrag;
	private org.whole.lang.java.model.CatchClauses catchClauses;
	private org.whole.lang.java.model.AnonymousClassDeclaration anonymousClassDeclaration;
	private org.whole.lang.java.model.MemberValuePair memberValuePair;

	public JDTTransformerVisitor(String source) {
		this.lf = JavaEntityFactory.instance;
		commentsMapper = new JDTCommentsMapper(source);
	}

	public static <T extends IJavaEntity> T transform(ASTNode model) {
		return transform(null, model);
	}

	@SuppressWarnings("unchecked")
	public static <T extends IJavaEntity> T transform(String source, ASTNode model) {
		JDTTransformerVisitor transformer = new JDTTransformerVisitor(source);

		// a TypeDeclaration container for translating fragments
		TypeDeclarations typeDeclarations = JavaEntityFactory.instance.createTypeDeclarations();
		transformer.env().wDef("typeDeclarationsContainer", typeDeclarations);

		CompilationUnit cu = (CompilationUnit) model.getRoot();
		transformer.commentsMapper.setComments(cu.getCommentList());
		model.accept(transformer);

		if (model instanceof Expression)
			return (T) transformer.exp;
		else if (model instanceof Block)
			return (T) transformer.block;
		else if (model instanceof TypeDeclaration)
			return (T) typeDeclarations.wGet(0);
		else
			return (T) transformer.cu;
	}

	IBindingManager env() {
		if (bindings == null) {
			bindings = BindingManagerFactory.instance.createBindingManager();
		}
		return bindings;
	}

	final boolean acceptChild(ASTNode child) {
		if (child == null)
			return false;

		child.accept(this);
		return true;
	}

	final void acceptChildren(List<?> children) {
		Iterator<?> i = children.iterator();
		while (i.hasNext())
			((ASTNode) i.next()).accept(this);
	}

	@Override
	public void preVisit(ASTNode node) {
		ASTNode parent = node.getParent();
		if (node instanceof BodyDeclaration && parent instanceof BodyDeclaration) {
			List<Comment> comments = commentsMapper.extractNodeComments(node);
			if (comments.isEmpty())
				return;

			for (Comment comment : comments) {
				comment.accept(this);
				appendBodyDeclaration(this.comment);
			}
		}
	}

	@Override
	public void postVisit(ASTNode node) {
		ASTNode parent = node.getParent();
		if (node instanceof Statement && parent instanceof Statement) {

			List<Comment> comments = commentsMapper.extractNodeComments(node);
			if (comments.isEmpty())
				return;

			if (parent.getNodeType() != ASTNode.BLOCK) {
				org.whole.lang.java.model.Block block = lf.createBlock(0);
				for (Comment comment : comments) {
					comment.accept(this);
					block.wAdd(this.comment);
				}
				block.wAdd(stm);
				stm = block;
			} else {
				for (Comment comment : comments) {
					comment.accept(this);
					commentsMapper.addOrphanComment(this.comment);
				}
			}
		}
	}

	public boolean visit(CompilationUnit node) {
		cu = lf.createCompilationUnit(
				createResolver(JavaEntityDescriptorEnum.PackageDeclaration),
				lf.create(JavaEntityDescriptorEnum.ImportDeclarations),
				lf.create(JavaEntityDescriptorEnum.TypeDeclarations));

		env().wDef("typeDeclarationsContainer", cu.getTypes());
		return true;
	}

	public boolean visit(PackageDeclaration node) {
		org.whole.lang.java.model.PackageDeclaration packageDeclaration = lf.createPackageDeclaration();

		acceptChild(node.getName());
		packageDeclaration.setName(name);

		if (acceptChild(commentsMapper.getPackageJavadoc()))
			packageDeclaration.setJavadoc(javadoc);

		cu.setPackage(packageDeclaration);
		return false;
	}

	public boolean visit(SimpleName node) {
		name = lf.createSimpleName(node.getIdentifier());
		exp = name;
		docElement = name;
		return true;
	}
	public boolean visit(QualifiedName node) {
		name = lf.createQualifiedName(node.getFullyQualifiedName());
		exp = name;
		docElement = name;
		return false;
	}

	@Override
	public boolean visit(TypeParameter node) {
		org.whole.lang.java.model.TypeParameter typeParameter = lf.create(JavaEntityDescriptorEnum.TypeParameter);

		acceptChild(node.getName());
		typeParameter.setName((org.whole.lang.java.model.SimpleName) name);
		setAnnotations(typeParameter.getAnnotations(), node.modifiers());		
		Iterator<?> i = node.typeBounds().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			typeParameter.getTypeBounds().wAdd(type);
		}

		this.typeParameter = typeParameter;
		return false;
	}

	public boolean visit(ParameterizedType node) {
		org.whole.lang.java.model.ParameterizedType parameterizedType = lf.create(JavaEntityDescriptorEnum.ParameterizedType);

		acceptChild(node.getType());
		parameterizedType.setType(type);
		setTypeArguments(parameterizedType.getTypeArguments(), node.typeArguments());

		type = parameterizedType;
		return false;
	}

	
	protected Type conditionalWrapWithAnnotatedType(Type type, List<?> annotations) {
		if (annotations.isEmpty()) {
			return type;			
		} else {
			org.whole.lang.java.model.AnnotatedType annotatedType = lf.create(JavaEntityDescriptorEnum.AnnotatedType);
			setAnnotations(annotatedType.getAnnotations(), annotations);
			annotatedType.setType(type);
			return annotatedType;
		}
	}
	public boolean visit(WildcardType node) {
		if (acceptChild(node.getBound())) {
			type = conditionalWrapWithAnnotatedType(lf.createWildcardType(type, lf.createUpperBound(node.isUpperBound())),
					node.annotations());
		} else {
			type = conditionalWrapWithAnnotatedType(lf.createWildcardType(),
					node.annotations());
		}
		return false;
	}
	public boolean visit(SimpleType node) {
		String name = node.getName().getFullyQualifiedName();
		if (StringUtils.isQualified(name))
			type = conditionalWrapWithAnnotatedType(lf.createQualifiedType(name),
					node.annotations());
		else
			type = conditionalWrapWithAnnotatedType(lf.createSimpleType(name),
					node.annotations());
		return false;
	}
	public boolean visit(PrimitiveType node) {
		type = conditionalWrapWithAnnotatedType(lf.createPrimitiveType(PrimitiveTypeEnum.instance.valueOf(node.getPrimitiveTypeCode().toString())),
				node.annotations());
		return true;
	}

	@Override
	public boolean visit(NameQualifiedType node) {
		String name = node.getName().getFullyQualifiedName();
		String qualifier = node.getQualifier().getFullyQualifiedName();

		type = conditionalWrapWithAnnotatedType(lf.createQualifiedType(qualifier+'.'+name),
				node.annotations());
		return true;
	}

	public boolean visit(ConstructorInvocation node) {
		org.whole.lang.java.model.ConstructorInvocation construcorCall = lf.create(JavaEntityDescriptorEnum.ConstructorInvocation);

		setTypeArguments(construcorCall.getTypeArguments(), node.typeArguments());

		Arguments arguments;
		construcorCall.setArguments(arguments = lf.create(JavaEntityDescriptorEnum.Arguments));
		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			arguments.wAdd(exp);
		}

		stm = construcorCall;
		return false;
	}

	public boolean visit(SuperConstructorInvocation node) {
		org.whole.lang.java.model.SuperConstructorInvocation superCall = lf.create(JavaEntityDescriptorEnum.SuperConstructorInvocation);

		if (acceptChild(node.getExpression()))
			superCall.setExpression(exp);

		setTypeArguments(superCall.getTypeArguments(), node.typeArguments());

		Arguments arguments;
		superCall.setArguments(arguments = lf.create(JavaEntityDescriptorEnum.Arguments));
		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			arguments.wAdd(exp);
		}

		stm = superCall;
		return false;
	}

	public boolean visit(NumberLiteral node) {
		String token = node.getToken();

		if (StringUtils.isJavaIntegerLiteral(token)) {
			long value = StringUtils.parseJavaIntegerLiteralType(token);
			if (Byte.MIN_VALUE <= value && value <= Byte.MAX_VALUE)
				exp = lf.createByteLiteral((byte) value);
			else if (Short.MIN_VALUE <= value && value <= Short.MAX_VALUE)
				exp = lf.createShortLiteral((short) value);
			else if (Integer.MIN_VALUE <= value && value <= Integer.MAX_VALUE)
				exp = lf.createIntLiteral((int) value);
			else 
				exp = lf.createLongLiteral(value);
		} else {
			int length = token.length();
			char lastCharacter = token.charAt(length -1);
			if (lastCharacter == 'f' || lastCharacter == 'F')
				exp = lf.createFloatLiteral(Float.parseFloat(token));
			else
				exp = lf.createDoubleLiteral(Double.parseDouble(token));
		}

		return false;
	}
	public boolean visit(NullLiteral node) {
		exp = lf.createNullLiteral();
		return true;
	}
	public boolean visit(BooleanLiteral node) {
		exp = lf.createBooleanLiteral(node.booleanValue());
		return true;
	}
	public boolean visit(CharacterLiteral node) {
		exp = lf.createCharLiteral(node.charValue());
		return false;
	}
	public boolean visit(StringLiteral node) {
		String literalValue = node.getLiteralValue();
		exp = lf.createStringLiteral(literalValue);
		return false;
	}


	public void endVisit(ImportDeclaration node) {
		cu.getImports().wAdd(lf.createImportDeclaration(name,
				lf.createImportModifier(node.isOnDemand()),
				lf.createImportModifier(node.isStatic())));
	}

	public boolean visit(AnonymousClassDeclaration node) {
		//FIXME workaround for type nesting
		org.whole.lang.java.model.Type type = this.type;
		org.whole.lang.java.model.Name name = this.name;
		org.whole.lang.java.model.TypeParameter typeParameter = this.typeParameter;
		org.whole.lang.java.model.Parameters params = this.params;
		org.whole.lang.java.model.Types thrownExceptions = this.thrownExceptions;
		org.whole.lang.java.model.SingleVariableDeclaration varDecl = this.varDecl;
		org.whole.lang.java.model.Block block = this.block;
		org.whole.lang.java.model.Statement stm = this.stm;
		org.whole.lang.java.model.Expression exp = this.exp;
		org.whole.lang.java.model.VariableDeclarationFragment varFrag = this.varFrag;
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;
		org.whole.lang.java.model.AnonymousClassDeclaration anonymousClassDeclaration = lf.create(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
		env().wEnterScope();

		env().wDef("typeDeclarationsContainer", anonymousClassDeclaration);
		acceptChildren(node.bodyDeclarations());			

		env().wExitScope();
		//FIXME workaround for type nesting
		this.type = type;
		this.name = name;
		this.typeParameter = typeParameter;
		this.params = params;
		this.thrownExceptions = thrownExceptions;
		this.varDecl = varDecl;
		this.block = block;
		this.stm = stm;
		this.exp = exp;
		this.varFrag = varFrag;
		this.catchClauses = catchClauses;
		this.anonymousClassDeclaration = anonymousClassDeclaration;
		return false;
	}

	public boolean visit(MethodRefParameter node) {
		this.methodRefParameter = lf.createMethodRefParameter();

		acceptChild(node.getType());
		this.methodRefParameter.setType(this.type);
		
		if (node.isVarargs())
			this.methodRefParameter.setVarargs(lf.createVarargs(true));

		this.methodRefParameter.setName(acceptChild(node.getName()) ? 
				(org.whole.lang.java.model.SimpleName) this.name : createResolver(JavaEntityDescriptorEnum.SimpleName));
		return false;
	}
	public boolean visit(MethodRef node) {
		org.whole.lang.java.model.MethodRef methodRef = lf.createMethodRef();

		methodRef.setQualifier(acceptChild(node.getQualifier()) ? this.name : createResolver(JavaEntityDescriptorEnum.Name));

		acceptChild(node.getName());
		methodRef.setName((org.whole.lang.java.model.SimpleName) this.name);

		MethodRefParameters parameters = lf.createMethodRefParameters(0);
		Iterator<?> i = node.parameters().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			parameters.wAdd(this.methodRefParameter);
		}
		methodRef.setParameters(parameters);

		this.docElement = methodRef;
		return false;
	}
	public boolean visit(MemberRef node) {
		org.whole.lang.java.model.MemberRef memeberRef = lf.createMemberRef();

		memeberRef.setQualifier(acceptChild(node.getQualifier()) ? this.name : createResolver(JavaEntityDescriptorEnum.Name));

		acceptChild(node.getName());
		memeberRef.setName((org.whole.lang.java.model.SimpleName) this.name);

		this.docElement = memeberRef;
		return false;
	}
	public boolean visit(TextElement node) {
		this.docElement = lf.createTextElement(node.getText());
		return false;
	}
	public boolean visit(TagElement tagElement) {
		DocElements docElements = lf.createDocElements(0);
		Iterator<?> i = tagElement.fragments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			docElements.wAdd(this.docElement);
		}

		String tagNameValue = tagElement.getTagName();
		TagName tagName = tagNameValue != null ? lf.createTagName(tagNameValue.substring(1)) : createResolver(JavaEntityDescriptorEnum.TagName);
		this.docElement = lf.createTagElement(tagName, docElements);
		return false;
	}

	public boolean visit(Javadoc javadoc) {
		commentsMapper.removeJavadoc(javadoc);

		Tags tags = lf.createTags(0);
		Iterator<?> i = javadoc.tags().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			tags.wAdd((org.whole.lang.java.model.TagElement) this.docElement);
		}

		this.comment = this.javadoc = tags.wIsEmpty() ? createResolver(JavaEntityDescriptorEnum.Javadoc) : lf.createJavadoc(tags);
		return false;
	}

	private static final Pattern BLOCK_COMMENT_WS = Pattern.compile("^[*\\p{javaWhitespace}]+");
	public boolean visit(BlockComment node) {
		DocElements docElements = lf.createDocElements(0);
		String[] lines = StringUtils.EOL_PATTERN.split(commentsMapper.getText(node));

		for (int i=0; i<lines.length ; i++) {
			String line = BLOCK_COMMENT_WS.matcher(lines[i]).replaceFirst("");
			if (line.length() != 0 || (0 < i && i < lines.length-1))
				docElements.wAdd(lf.createTextElement(line));
		}

		comment = lf.createBlockComment(docElements);
		return false;
	}

	public boolean visit(LineComment node) {
		comment = lf.createLineComment(lf.createTextElement(commentsMapper.getText(node)));
		return false;
	}

	public boolean visit(TypeDeclarationStatement node) {
		org.whole.lang.java.model.TypeDeclarationStatement typeDeclStm = lf.create(JavaEntityDescriptorEnum.TypeDeclarationStatement);

		env().wEnterScope();
		env().wDef("typeDeclarationsContainer", typeDeclStm);
		acceptChild(node.getDeclaration());
		env().wExitScope();

		stm = typeDeclStm;
		return false;
	}

	private void appendBodyDeclaration(org.whole.lang.java.model.BodyDeclaration declaration) {
		IEntity container = env().wGet("typeDeclarationsContainer");
		if (Matcher.match(JavaEntityDescriptorEnum.TypeDeclarationStatement, container))
			container.wSet(JavaFeatureDescriptorEnum.typeDeclaration, declaration);
		else
			container.wAdd(declaration);
	}
	public boolean visit(TypeDeclaration node) {
		//FIXME workaround for type nesting
		org.whole.lang.java.model.Type type = this.type;
		org.whole.lang.java.model.Name name = this.name;
		org.whole.lang.java.model.TypeParameter typeParameter = this.typeParameter;
		org.whole.lang.java.model.Parameters params = this.params;
		org.whole.lang.java.model.Types thrownExceptions = this.thrownExceptions;
		org.whole.lang.java.model.SingleVariableDeclaration varDecl = this.varDecl;
		org.whole.lang.java.model.Block block = this.block;
		org.whole.lang.java.model.Statement stm = this.stm;
		org.whole.lang.java.model.Expression exp = this.exp;
		org.whole.lang.java.model.VariableDeclarationFragment varFrag = this.varFrag;
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;
		org.whole.lang.java.model.AnonymousClassDeclaration anonymousClassDeclaration = this.anonymousClassDeclaration;

		env().wEnterScope();
		if (node.isInterface()) {
			InterfaceDeclaration interfaceDecl;
			appendBodyDeclaration(interfaceDecl = lf.create(JavaEntityDescriptorEnum.InterfaceDeclaration));

			if (acceptChild(node.getJavadoc()))
				interfaceDecl.setJavadoc(this.javadoc);

			Iterator<?> j = node.typeParameters().iterator();
			while (j.hasNext()) {
				((ASTNode) j.next()).accept(this);
				interfaceDecl.getTypeParameters().wAdd(this.typeParameter);
			}

			List<?> modifiers = node.modifiers();
			if (!modifiers.isEmpty()) {
				interfaceDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
				setExtendedModifiers(interfaceDecl.getModifiers(), modifiers);
			}
			if (acceptChild(node.getName()))
				interfaceDecl.setName((org.whole.lang.java.model.SimpleName) this.name);

			Iterator<?> i = node.superInterfaceTypes().iterator();
			while (i.hasNext()) {
				((ASTNode) i.next()).accept(this);
				interfaceDecl.getSuperInterfaceTypes().wAdd(this.type);
			}

			org.whole.lang.java.model.BodyDeclarations bodyDecl = lf.createBodyDeclarations();
			interfaceDecl.setBodyDeclarations(bodyDecl); 
			env().wDef("typeDeclarationsContainer", bodyDecl);
			acceptChildren(node.bodyDeclarations());
		} else {
			ClassDeclaration classDecl;
			appendBodyDeclaration(classDecl = lf.create(JavaEntityDescriptorEnum.ClassDeclaration));

			if (acceptChild(node.getJavadoc()))
				classDecl.setJavadoc(this.javadoc);

			Iterator<?> j = node.typeParameters().iterator();
			while (j.hasNext()) {
				((ASTNode) j.next()).accept(this);
				classDecl.getTypeParameters().wAdd(this.typeParameter);
			}

			List<?> modifiers = node.modifiers();
			if (!modifiers.isEmpty()) {
				classDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
				setExtendedModifiers(classDecl.getModifiers(), modifiers);
			}
			if (acceptChild(node.getName()))
				classDecl.setName((org.whole.lang.java.model.SimpleName) this.name);
			if (acceptChild(node.getSuperclassType()))
				classDecl.setSuperclassType(this.type);

			Iterator<?> i = node.superInterfaceTypes().iterator();
			while (i.hasNext()) {
				((ASTNode) i.next()).accept(this);
				classDecl.getSuperInterfaceTypes().wAdd(this.type);
			}

			org.whole.lang.java.model.BodyDeclarations bodyDecl = lf.createBodyDeclarations();
			classDecl.setBodyDeclarations(bodyDecl); 
			env().wDef("typeDeclarationsContainer", bodyDecl);
			acceptChildren(node.bodyDeclarations());			
		}
		env().wExitScope();
		//FIXME workaround for type nesting
		this.anonymousClassDeclaration = anonymousClassDeclaration;
		this.type = type;
		this.name = name;
		this.typeParameter = typeParameter;
		this.params = params;
		this.thrownExceptions = thrownExceptions;
		this.varDecl = varDecl;
		this.block = block;
		this.stm = stm;
		this.exp = exp;
		this.varFrag = varFrag;
		this.catchClauses = catchClauses;
		return false;
	}

	public boolean visit(EnumDeclaration node) {
		//FIXME workaround for type nesting
		org.whole.lang.java.model.Type type = this.type;
		org.whole.lang.java.model.Name name = this.name;
		org.whole.lang.java.model.TypeParameter typeParameter = this.typeParameter;
		org.whole.lang.java.model.Parameters params = this.params;
		org.whole.lang.java.model.Types thrownExceptions = this.thrownExceptions;
		org.whole.lang.java.model.SingleVariableDeclaration varDecl = this.varDecl;
		org.whole.lang.java.model.Block block = this.block;
		org.whole.lang.java.model.Statement stm = this.stm;
		org.whole.lang.java.model.Expression exp = this.exp;
		org.whole.lang.java.model.VariableDeclarationFragment varFrag = this.varFrag;
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;
		env().wEnterScope();

		org.whole.lang.java.model.EnumDeclaration enumDeclaration;
		appendBodyDeclaration(enumDeclaration = lf.create(JavaEntityDescriptorEnum.EnumDeclaration));

		if (acceptChild(node.getJavadoc()))
			enumDeclaration.setJavadoc(this.javadoc);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			enumDeclaration.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(enumDeclaration.getModifiers(), modifiers);
		}
		if (acceptChild(node.getName()))
			enumDeclaration.setName((org.whole.lang.java.model.SimpleName) this.name);

		Iterator<?> i = node.superInterfaceTypes().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			enumDeclaration.getSuperInterfaceTypes().wAdd(this.type);
		}

		org.whole.lang.java.model.EnumConstants enumConstants = lf.create(JavaEntityDescriptorEnum.EnumConstants);
		enumDeclaration.setEnumConstants(enumConstants);
		env().wDef("typeDeclarationsContainer", enumConstants);
		acceptChildren(node.enumConstants());

		org.whole.lang.java.model.BodyDeclarations bodyDecl = lf.createBodyDeclarations();
		enumDeclaration.setBodyDeclarations(bodyDecl); 
		env().wDef("typeDeclarationsContainer", bodyDecl);
		acceptChildren(node.bodyDeclarations());

		env().wExitScope();
		//FIXME workaround for type nesting
		this.type = type;
		this.name = name;
		this.typeParameter = typeParameter;
		this.params = params;
		this.thrownExceptions = thrownExceptions;
		this.varDecl = varDecl;
		this.block = block;
		this.stm = stm;
		this.exp = exp;
		this.varFrag = varFrag;
		this.catchClauses = catchClauses;
		return false;
	}

	@Override
	public boolean visit(EnumConstantDeclaration node) {
		org.whole.lang.java.model.EnumConstantDeclaration enumConstantDeclaration;
		appendBodyDeclaration(enumConstantDeclaration = createResolver(JavaEntityDescriptorEnum.EnumConstantDeclaration));

		if (acceptChild(node.getJavadoc()))
			enumConstantDeclaration.setJavadoc(this.javadoc);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			enumConstantDeclaration.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(enumConstantDeclaration.getModifiers(), modifiers);
		}
		if (acceptChild(node.getName()))
			enumConstantDeclaration.setName((org.whole.lang.java.model.SimpleName) this.name);

		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			enumConstantDeclaration.getArguments().wAdd(this.exp);
		}

		if (acceptChild(node.getAnonymousClassDeclaration()))
			enumConstantDeclaration.setAnonymousClassDeclaration(this.anonymousClassDeclaration);

		return false;
	}

	public boolean visit(AnnotationTypeDeclaration node) {
		//FIXME workaround for type nesting
		org.whole.lang.java.model.Type type = this.type;
		org.whole.lang.java.model.Name name = this.name;
		org.whole.lang.java.model.TypeParameter typeParameter = this.typeParameter;
		org.whole.lang.java.model.Parameters params = this.params;
		org.whole.lang.java.model.Types thrownExceptions = this.thrownExceptions;
		org.whole.lang.java.model.SingleVariableDeclaration varDecl = this.varDecl;
		org.whole.lang.java.model.Block block = this.block;
		org.whole.lang.java.model.Statement stm = this.stm;
		org.whole.lang.java.model.Expression exp = this.exp;
		org.whole.lang.java.model.VariableDeclarationFragment varFrag = this.varFrag;
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;
		env().wEnterScope();

		org.whole.lang.java.model.AnnotationTypeDeclaration annotationTypeDeclaration;
		appendBodyDeclaration(annotationTypeDeclaration = lf.create(JavaEntityDescriptorEnum.AnnotationTypeDeclaration));

		if (acceptChild(node.getJavadoc()))
			annotationTypeDeclaration.setJavadoc(this.javadoc);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			annotationTypeDeclaration.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(annotationTypeDeclaration.getModifiers(), modifiers);
		}
		if (acceptChild(node.getName()))
			annotationTypeDeclaration.setName((org.whole.lang.java.model.SimpleName) this.name);

		org.whole.lang.java.model.BodyDeclarations bodyDecl = lf.createBodyDeclarations();
		annotationTypeDeclaration.setBodyDeclarations(bodyDecl); 
		env().wDef("typeDeclarationsContainer", bodyDecl);
		acceptChildren(node.bodyDeclarations());

		env().wExitScope();
		//FIXME workaround for type nesting
		this.type = type;
		this.name = name;
		this.typeParameter = typeParameter;
		this.params = params;
		this.thrownExceptions = thrownExceptions;
		this.varDecl = varDecl;
		this.block = block;
		this.stm = stm;
		this.exp = exp;
		this.varFrag = varFrag;
		this.catchClauses = catchClauses;
		return false;
	}

	public boolean visit(AnnotationTypeMemberDeclaration node) {
		org.whole.lang.java.model.AnnotationTypeMemberDeclaration annotationTypeMemberDeclaration;
		appendBodyDeclaration(annotationTypeMemberDeclaration = lf.create(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration));

		if (acceptChild(node.getJavadoc()))
			annotationTypeMemberDeclaration.setJavadoc(this.javadoc);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			annotationTypeMemberDeclaration.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(annotationTypeMemberDeclaration.getModifiers(), modifiers);
		}

		acceptChild(node.getName());
		annotationTypeMemberDeclaration.setName((org.whole.lang.java.model.SimpleName) this.name);

		acceptChild(node.getType());
		annotationTypeMemberDeclaration.setType(this.type);

		if (acceptChild(node.getDefault()))
			annotationTypeMemberDeclaration.setDefault(this.exp);

		return false;
	}

	private void setTypeArguments(IEntity typeArguments, List<?> jdtTypeArguments) {
		IEntity parent = typeArguments.wGetParent();
		FeatureDescriptor fd = parent.wGetFeatureDescriptor(typeArguments);
		for (Iterator<?> i = jdtTypeArguments.iterator(); i.hasNext();) {
			org.eclipse.jdt.core.dom.Type type = (org.eclipse.jdt.core.dom.Type) i.next();
			acceptChild((org.eclipse.jdt.core.dom.Type) type);
			parent.wGet(fd).wAdd(this.type);
		}
	}
	private void setAnnotations(IEntity annotations, List<?> jdtAnnotations) {
		IEntity parent = annotations.wGetParent();
		FeatureDescriptor fd = parent.wGetFeatureDescriptor(annotations);
		for (Iterator<?> i = jdtAnnotations.iterator(); i.hasNext();) {
			Annotation annotation = (Annotation) i.next();
			acceptChild((Annotation) annotation);
			parent.wGet(fd).wAdd(exp);
		}
	}
	private void setExtendedModifiers(ExtendedModifiers modifiers, List<?> jdtModifiers) {
		for (Iterator<?> i = jdtModifiers.iterator(); i.hasNext();) {
			IExtendedModifier em = (IExtendedModifier) i.next();
			if (em.isAnnotation()) {
				acceptChild((Annotation) em);
				modifiers.wAdd(exp);
			} else if (em.isModifier()) {
				Modifier m = (Modifier) em;
				ModifierKeyword mk = m.getKeyword();
				int flags = mk.toFlagValue();
				if (Modifier.isPublic(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._public));
				if (Modifier.isPrivate(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._private));
				if (Modifier.isProtected(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._protected));
				if (Modifier.isStatic(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._static));
				if (Modifier.isFinal(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._final));
				if (Modifier.isSynchronized(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._synchronized));
				if (Modifier.isVolatile(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._volatile));
				if (Modifier.isTransient(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._transient));
				if (Modifier.isNative(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._native));
				if (Modifier.isAbstract(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._abstract));
				if (Modifier.isStrictfp(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum.strictftp));
				if (Modifier.isDefault(flags))
					modifiers.wAdd(lf.createModifier(ModifierEnum._default));
			}
		}
	}
	@Override
	public boolean visit(MarkerAnnotation annotation) {
		org.whole.lang.java.model.MarkerAnnotation ann = lf.createMarkerAnnotation();
		acceptChild(annotation.getTypeName());
		ann.setTypeName(name);
		exp = ann;
		return false;
	}

	@Override
	public boolean visit(SingleMemberAnnotation annotation) {
		org.whole.lang.java.model.SingleMemberAnnotation ann = lf.createSingleMemberAnnotation();

		SingleMemberAnnotation singleMemberAnnotation = (SingleMemberAnnotation) annotation;
		acceptChild(singleMemberAnnotation.getTypeName());
		ann.setTypeName(name);

		acceptChild(singleMemberAnnotation.getValue());
		ann.setValue(exp);
		exp = ann;
		return false;
	}

	@Override
	public boolean visit(NormalAnnotation annotation) {
		org.whole.lang.java.model.NormalAnnotation ann = lf.createNormalAnnotation();

		NormalAnnotation normalAnnotation = (NormalAnnotation) annotation;
		acceptChild(normalAnnotation.getTypeName());
		ann.setTypeName(name);
		ann.getValues().clear();

		Iterator<?> iterator = normalAnnotation.values().iterator();
		while (iterator.hasNext()) {
			((ASTNode) iterator.next()).accept(this);
			ann.getValues().wAdd(this.memberValuePair);
		}
		exp = ann;
		return false;
	}

	@Override
	public boolean visit(MemberValuePair node) {
		org.whole.lang.java.model.MemberValuePair memberValuePair = lf.create(JavaEntityDescriptorEnum.MemberValuePair);
		acceptChild(node.getName());
		memberValuePair.setName((org.whole.lang.java.model.SimpleName) name);
		acceptChild(node.getValue());
		memberValuePair.setValue(exp);
		this.memberValuePair = memberValuePair;
		return false;
	}

	public boolean visit(FieldDeclaration node) {
		org.whole.lang.java.model.FieldDeclaration fieldDecl = lf.create(JavaEntityDescriptorEnum.FieldDeclaration);
		appendBodyDeclaration(fieldDecl);

		if (acceptChild(node.getJavadoc()))
			fieldDecl.setJavadoc(this.javadoc);

		acceptChild(node.getType());
		fieldDecl.setType(type);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			fieldDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(fieldDecl.getModifiers(), modifiers);
		}

		Iterator<?> i = node.fragments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			fieldDecl.getFragments().wAdd(varFrag);
		}

		return false;
	}

	public boolean visit(MethodDeclaration node) {
		if (node.isConstructor()) {
			ConstructorDeclaration constructorDecl;
			appendBodyDeclaration(constructorDecl = lf.create(JavaEntityDescriptorEnum.ConstructorDeclaration));

			if (acceptChild(node.getJavadoc()))
				constructorDecl.setJavadoc(this.javadoc);

			List<?> modifiers = node.modifiers();
			if (!modifiers.isEmpty()) {
				constructorDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
				setExtendedModifiers(constructorDecl.getModifiers(), modifiers);
			}

			Iterator<?> j = node.typeParameters().iterator();
			while (j.hasNext()) {
				((ASTNode) j.next()).accept(this);
				constructorDecl.getTypeParameters().wAdd(typeParameter);
			}

			if (acceptChild(node.getName()))
				constructorDecl.setName((org.whole.lang.java.model.SimpleName) name);

			constructorDecl.setParameters(params = lf.create(JavaEntityDescriptorEnum.Parameters));
			acceptChildren(node.parameters());

			if (node.thrownExceptionTypes().isEmpty())
				thrownExceptions = createResolver(JavaEntityDescriptorEnum.Types);
			else
				thrownExceptions = lf.create(JavaEntityDescriptorEnum.Types);
			constructorDecl.setThrownExceptions(thrownExceptions);
			for (Object child : node.thrownExceptionTypes()) {
				((ASTNode) child).accept(this);
				thrownExceptions.wAdd(type);
			}

			acceptChild(node.getBody());
			constructorDecl.setBody((org.whole.lang.java.model.Block) stm);

			constructorDecl.getExtraDimensions().wSetValue(node.getExtraDimensions());
		} else {
			org.whole.lang.java.model.MethodDeclaration methodDecl;
			appendBodyDeclaration(methodDecl = lf.create(JavaEntityDescriptorEnum.MethodDeclaration));

			if (acceptChild(node.getJavadoc()))
				methodDecl.setJavadoc(this.javadoc);

			List<?> modifiers = node.modifiers();
			if (!modifiers.isEmpty()) {
				methodDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
				setExtendedModifiers(methodDecl.getModifiers(), modifiers);
			}

			Iterator<?> j = node.typeParameters().iterator();
			while (j.hasNext()) {
				((ASTNode) j.next()).accept(this);
				methodDecl.getTypeParameters().wAdd(typeParameter);
			}

			if (acceptChild(node.getReturnType2()))
				methodDecl.setReturnType(type);

			if (acceptChild(node.getName()))
				methodDecl.setName((org.whole.lang.java.model.SimpleName) name);

			methodDecl.setParameters(params = lf.create(JavaEntityDescriptorEnum.Parameters));
			acceptChildren(node.parameters());

			if (node.thrownExceptionTypes().isEmpty())
				thrownExceptions = createResolver(JavaEntityDescriptorEnum.Types);
			else
				thrownExceptions = lf.create(JavaEntityDescriptorEnum.Types);
			methodDecl.setThrownExceptions(thrownExceptions);
			for (Object child : node.thrownExceptionTypes()) {
				((ASTNode) child).accept(this);
				thrownExceptions.wAdd(type);
			}

			if (acceptChild(node.getBody()))
				methodDecl.setBody((org.whole.lang.java.model.Block) stm);			

			methodDecl.getExtraDimensions().wSetValue(node.getExtraDimensions());
		}
		return false;
	}

	@Override
	public boolean visit(Initializer node) {
		org.whole.lang.java.model.Initializer initializer;
		appendBodyDeclaration(initializer = lf.create(JavaEntityDescriptorEnum.Initializer));

		if (acceptChild(node.getJavadoc()))
			initializer.setJavadoc(this.javadoc);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			initializer.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(initializer.getModifiers(), modifiers);
		}

		acceptChild(node.getBody());
		initializer.setBody((org.whole.lang.java.model.Block) stm);			

		return false;
	}

	public boolean visit(SingleVariableDeclaration node) {
		varDecl = lf.create(JavaEntityDescriptorEnum.SingleVariableDeclaration);
		if (params != null)
			params.wAdd(varDecl);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			varDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(varDecl.getModifiers(), modifiers);
		}

		if (acceptChild(node.getType()))
			varDecl.setType(type);

		varDecl.setVarargs(lf.createVarargs(node.isVarargs()));
		setAnnotations(varDecl.getVarargsAnnotations(), (List<?>) node.varargsAnnotations());

		varDecl.getExtraDimensions().wSetValue(node.getExtraDimensions());

		if (acceptChild(node.getInitializer()))
			varDecl.setInitializer(exp);

		if (acceptChild(node.getName()))
			varDecl.setName((org.whole.lang.java.model.SimpleName) name);
		return false;
	}

	public boolean visit(Block node) {
		org.whole.lang.java.model.Block blockStm = lf.create(JavaEntityDescriptorEnum.Block);

		List<?> statements = node.statements();
		Iterator<?> i = statements.iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			commentsMapper.appendOrphanCommentsToBlock(blockStm);
			blockStm.wAdd(stm);
		}
		for (Comment comment : commentsMapper.extractContainerComments(node)) {
			comment.accept(this);
			blockStm.wAdd(this.comment);
		}
		stm = block = blockStm;
		return false;
	}

	public boolean visit(IfStatement node) {
		org.whole.lang.java.model.IfStatement ifStm = lf.create(JavaEntityDescriptorEnum.IfStatement);

		acceptChild(node.getExpression());
		ifStm.setExpression(exp);

		acceptChild(node.getThenStatement());
		ifStm.setThenStatement(stm);

		if (acceptChild(node.getElseStatement()))
			ifStm.setElseStatement(stm);

		stm = ifStm;
		return false;
	}

	public boolean visit(WhileStatement node) {
		org.whole.lang.java.model.WhileStatement whileStm = lf.create(JavaEntityDescriptorEnum.WhileStatement);

		acceptChild(node.getExpression());
		whileStm.setExpression(exp);

		acceptChild(node.getBody());
		whileStm.setBody(stm);

		stm = whileStm;
		return false;
	}

	public boolean visit(DoStatement node) {
		org.whole.lang.java.model.DoStatement doStm = lf.create(JavaEntityDescriptorEnum.DoStatement);

		acceptChild(node.getExpression());
		doStm.setExpression(exp);

		acceptChild(node.getBody());
		doStm.setBody(stm);

		stm = doStm;
		return false;
	}

	public boolean visit(EnhancedForStatement node) {
		org.whole.lang.java.model.EnhancedForStatement forStm = lf.create(JavaEntityDescriptorEnum.EnhancedForStatement);

		org.whole.lang.java.model.Parameters params = this.params;
		this.params = null;

		acceptChild(node.getParameter());
		forStm.setParameter(varDecl);

		acceptChild(node.getExpression());
		forStm.setExpression(exp);

		acceptChild(node.getBody());
		forStm.setBody(stm);

		this.params = params;

		stm = forStm;
		return false;
	}

	public boolean visit(ForStatement node) {
		org.whole.lang.java.model.ForStatement forStm = lf.create(JavaEntityDescriptorEnum.ForStatement);

		Iterator<?> i = node.initializers().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			forStm.getInitializers().wAdd(exp);
		}

		if (acceptChild(node.getExpression()))
			forStm.setExpression(exp);

		i = node.updaters().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			forStm.getUpdaters().wAdd(exp);
		}

		acceptChild(node.getBody());
		forStm.setBody(stm);

		stm = forStm;
		return false;
	}

	public boolean visit(ReturnStatement node) {
		org.whole.lang.java.model.ReturnStatement returnStm = lf.create(JavaEntityDescriptorEnum.ReturnStatement);

		if (acceptChild(node.getExpression()))
			returnStm.setExpression(exp);

		stm = returnStm;
		return false;
	}

	@Override
	public boolean visit(ContinueStatement node) {
		org.whole.lang.java.model.ContinueStatement continueStm = lf.create(JavaEntityDescriptorEnum.ContinueStatement);

		if (acceptChild(node.getLabel()))
			continueStm.setLabel((org.whole.lang.java.model.SimpleName)name);

		stm = continueStm;
		return false;
	}

	@Override
	public boolean visit(SynchronizedStatement node) {
		org.whole.lang.java.model.SynchronizedStatement syncStm = lf.create(JavaEntityDescriptorEnum.SynchronizedStatement);

		acceptChild(node.getExpression());
		syncStm.setExpression(exp);

		acceptChild(node.getBody());
		syncStm.setBody(block);

		stm = syncStm;
		return false;
	}

	@Override
	public boolean visit(AssertStatement node) {
		org.whole.lang.java.model.AssertStatement assertStm = lf.create(JavaEntityDescriptorEnum.AssertStatement);

		acceptChild(node.getExpression());
		assertStm.setExpression(exp);

		if (acceptChild(node.getMessage()))
			assertStm.setExpression(exp);

		stm = assertStm;
		return false;
	}

	@Override
	public boolean visit(EmptyStatement node) {
		stm = lf.create(JavaEntityDescriptorEnum.EmptyStatement);
		return false;
	}

	public boolean visit(CatchClause node) {
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;

		org.whole.lang.java.model.CatchClause catchClause = lf.create(JavaEntityDescriptorEnum.CatchClause);

		params = null;
		acceptChild(node.getException());
		catchClause.setException(varDecl);

		acceptChild(node.getBody());
		catchClause.setBody(block);

		catchClauses.wAdd(catchClause);
		return false;
	}

	public boolean visit(TryStatement node) {
		acceptChild(node.getBody());
		org.whole.lang.java.model.Block body = block;

		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses = lf.create(JavaEntityDescriptorEnum.CatchClauses);
		acceptChildren(node.catchClauses());

		block = lf.createBlock();
		acceptChild(node.getFinally());

		stm = lf.createTryStatement(body, catchClauses, block);
		return false;
	}

	public boolean visit(ThrowStatement node) {
		acceptChild(node.getExpression());
		stm = lf.createThrowStatement(exp);
		return false;
	}

	public void endVisit(ExpressionStatement node) {
		stm = lf.createExpressionStatement(exp);
	}
	
	@Override
	public boolean visit(UnionType node) {
		org.whole.lang.java.model.UnionType unionType = lf.createUnionType(0);

		Iterator<?> iterator = node.types().iterator();
		while (iterator.hasNext()) {
			((ASTNode) iterator.next()).accept(this);
			unionType.wAdd(type);
		}
		type = unionType;

		return false;
	}

	@Override
	public boolean visit(IntersectionType node) {
		org.whole.lang.java.model.IntersectionType intersectionType = lf.createIntersectionType(0);

		Iterator<?> iterator = node.types().iterator();
		while (iterator.hasNext()) {
			((ASTNode) iterator.next()).accept(this);
			intersectionType.wAdd(type);
		}
		type = intersectionType;

		return false;
	}

	public boolean visit(Assignment node) {
		acceptChild(node.getLeftHandSide());
		org.whole.lang.java.model.Expression exp1 = exp;
		acceptChild(node.getRightHandSide());

		exp = lf.createAssignment(exp1, lf.createAssignmentOperator(JavaDataTypePersistenceParser.parseAssignmentOperator(node.getOperator().toString())), exp);
		return false;
	}

	public boolean visit(InfixExpression node) {
		acceptChild(node.getLeftOperand());
		org.whole.lang.java.model.Expression exp1 = exp;
		acceptChild(node.getRightOperand());
		org.whole.lang.java.model.InfixExpression infixExp = lf.createInfixExpression(exp1,
				lf.createInfixOperator(JavaDataTypePersistenceParser.parseInfixOperator(node.getOperator().toString())),
				exp, lf.create(JavaEntityDescriptorEnum.Expressions));

		Expressions expressions;
		infixExp.setExtendedOperands(expressions = lf.create(JavaEntityDescriptorEnum.Expressions));
		Iterator<?> i = node.extendedOperands().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			expressions.wAdd(exp);
		}

		exp = infixExp;
		return false;
	}
	public void endVisit(PostfixExpression node) {
		exp = lf.createPostfixExpression(exp, lf.createPostfixOperator(JavaDataTypePersistenceParser.parsePostfixOperator(node.getOperator().toString())));
	}
	public void endVisit(PrefixExpression node) {
		exp = lf.createPrefixExpression(lf.createPrefixOperator(JavaDataTypePersistenceParser.parsePrefixOperator(node.getOperator().toString())), exp);
	}

	public boolean visit(MethodInvocation node) {
		org.whole.lang.java.model.MethodInvocation callExp = lf.create(JavaEntityDescriptorEnum.MethodInvocation);

		if (acceptChild(node.getExpression()))
			callExp.setExpression(exp);

		acceptChild(node.getName());
		callExp.setName((org.whole.lang.java.model.SimpleName)name);

		setTypeArguments(callExp.getTypeArguments(), node.typeArguments());

		Arguments arguments;
		callExp.setArguments(arguments = lf.create(JavaEntityDescriptorEnum.Arguments));
		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			arguments.wAdd(exp);
		}

		exp = callExp;
		return false;
	}

	public boolean visit(SuperMethodInvocation node) {
		org.whole.lang.java.model.SuperMethodInvocation callExp = lf.create(JavaEntityDescriptorEnum.SuperMethodInvocation);

		if (acceptChild(node.getQualifier()))
			callExp.setQualifier(name);

		acceptChild(node.getName());
		callExp.setName((org.whole.lang.java.model.SimpleName)name);

		Arguments arguments;
		callExp.setArguments(arguments = lf.create(JavaEntityDescriptorEnum.Arguments));
		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			arguments.wAdd(exp);
		}

		exp = callExp;
		return false;
	}

	@Override
	public boolean visit(ParenthesizedExpression node) {
		org.whole.lang.java.model.ParenthesizedExpression parExp = lf.createParenthesizedExpression();
		if (acceptChild(node.getExpression()))
			parExp.setExpression(exp);
		exp = parExp;
		return false;
	}

	@Override
	public boolean visit(ConditionalExpression node) {
		org.whole.lang.java.model.ConditionalExpression condExp = lf.createConditionalExpression();
		if (acceptChild(node.getExpression()))
			condExp.setExpression(exp);
		if (acceptChild(node.getThenExpression()))
			condExp.setThenExpression(exp);
		if (acceptChild(node.getElseExpression()))
			condExp.setElseExpression(exp);
		exp = condExp;
		return false;
	}

	@Override
	public boolean visit(InstanceofExpression node) {
		org.whole.lang.java.model.InstanceofExpression instExp = lf.createInstanceofExpression();
		if (acceptChild(node.getLeftOperand()))
			instExp.setLeftOperand(exp);

		if (acceptChild(node.getRightOperand()))
			instExp.setRightOperand(type);

		exp = instExp;
		return false;
	}

	@Override
	public boolean visit(LambdaExpression node) {
		//FIXME workaround for type nesting
		org.whole.lang.java.model.Type type = this.type;
		org.whole.lang.java.model.Name name = this.name;
		org.whole.lang.java.model.TypeParameter typeParameter = this.typeParameter;
		org.whole.lang.java.model.Parameters params = this.params;
		org.whole.lang.java.model.Types thrownExceptions = this.thrownExceptions;
		org.whole.lang.java.model.SingleVariableDeclaration varDecl = this.varDecl;
		org.whole.lang.java.model.Block block = this.block;
		org.whole.lang.java.model.Statement stm = this.stm;
		org.whole.lang.java.model.VariableDeclarationFragment varFrag = this.varFrag;
		org.whole.lang.java.model.CatchClauses catchClauses = this.catchClauses;
		org.whole.lang.java.model.AnonymousClassDeclaration anonymousClassDeclaration = lf.create(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
	
		org.whole.lang.java.model.LambdaExpression lambdaExpression = lf.createLambdaExpression();

		this.params = null;
		if (node.hasParentheses()) {
			Iterator<?> iterator = node.parameters().iterator();
			while (iterator.hasNext()) {
				this.varDecl = null;
				this.varFrag = null;
				acceptChild((ASTNode) iterator.next());
				lambdaExpression.getParameters().wAdd(this.varDecl != null ?
						this.varDecl : this.varFrag);	
			}
			if (EntityUtils.isResolver(lambdaExpression.getParameters()))
				lambdaExpression.setParameters(lf.createParameters(0));
		} else {
			acceptChild((ASTNode) node.parameters().get(0));
			lambdaExpression.setParameters(this.varFrag);
		}

		this.exp = null;
		this.stm = null;
		acceptChild(node.getBody());
		lambdaExpression.setBody(this.stm != null ? this.stm : this.exp);

		exp = lambdaExpression;

		//FIXME workaround for type nesting
		this.type = type;
		this.name = name;
		this.typeParameter = typeParameter;
		this.params = params;
		this.thrownExceptions = thrownExceptions;
		this.varDecl = varDecl;
		this.block = block;
		this.stm = stm;
		this.varFrag = varFrag;
		this.catchClauses = catchClauses;
		this.anonymousClassDeclaration = anonymousClassDeclaration;

		return false;
	}

	@Override
	public boolean visit(CreationReference node) {
		ConstructorReference constructorReference = lf.createConstructorReference();
		acceptChild((ASTNode) node.getType());
		constructorReference.setType(type);
		setTypeArguments(constructorReference.getTypeArguments(), node.typeArguments());
		this.exp = constructorReference;
		return false;
	}

	@Override
	public boolean visit(ExpressionMethodReference node) {
		org.whole.lang.java.model.ExpressionMethodReference expressionMethodReference = lf.createExpressionMethodReference();
		acceptChild((ASTNode) node.getExpression());
		expressionMethodReference.setExpression(exp);
		setTypeArguments(expressionMethodReference.getTypeArguments(), node.typeArguments());
		acceptChild((ASTNode) node.getName());
		expressionMethodReference.setName((org.whole.lang.java.model.SimpleName) name);
		this.exp = expressionMethodReference;
		return false;
	}

	@Override
	public boolean visit(SuperMethodReference node) {
		org.whole.lang.java.model.SuperMethodReference superMethodReference = lf.createSuperMethodReference();
		acceptChild((ASTNode) node.getQualifier());
		superMethodReference.setQualifier(name);
		setTypeArguments(superMethodReference.getTypeArguments(), node.typeArguments());
		acceptChild((ASTNode) node.getName());
		superMethodReference.setName((org.whole.lang.java.model.SimpleName) name);
		this.exp = superMethodReference;
		return false;
	}

	@Override
	public boolean visit(TypeMethodReference node) {
		org.whole.lang.java.model.TypeMethodReference typeMethodReference = lf.createTypeMethodReference();
		acceptChild((ASTNode) node.getType());
		typeMethodReference.setType(type);
		setTypeArguments(typeMethodReference.getTypeArguments(), node.typeArguments());
		acceptChild((ASTNode) node.getName());
		typeMethodReference.setName((org.whole.lang.java.model.SimpleName) name);
		this.exp = typeMethodReference;
		return false;
	}

	public boolean visit(ClassInstanceCreation node) {
		org.whole.lang.java.model.ClassInstanceCreation newExp = lf.create(JavaEntityDescriptorEnum.ClassInstanceCreation);

		if (acceptChild(node.getExpression()))
			newExp.setExpression(exp);

		acceptChild(node.getType());
		newExp.setType(type);

		Iterator<?> i = node.arguments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			newExp.getArguments().wAdd(exp);
		}

		if (acceptChild(node.getAnonymousClassDeclaration()))
			newExp.setAnonymousClassDeclaration(this.anonymousClassDeclaration);

		exp = newExp;
		return false;
	}

	public boolean visit(CastExpression node) {
		acceptChild(node.getType());
		org.whole.lang.java.model.Type type1 = type;

		acceptChild(node.getExpression());
		exp = lf.createCastExpression(type1, exp);
		return false;
	}

	public boolean visit(TypeLiteral node) {
		acceptChild(node.getType());
		exp = lf.createTypeLiteral(type);
		return false;
	}

	public boolean visit(ThisExpression node) {
		if (acceptChild(node.getQualifier()))
			exp = lf.createThisExpression(name);
		else
			exp = lf.create(JavaEntityDescriptorEnum.ThisExpression);
		return false;
	}

	public boolean visit(SuperFieldAccess node) {
		acceptChild(node.getQualifier());
		org.whole.lang.java.model.Name name1 = name;

		acceptChild(node.getName());
		exp = lf.createSuperFieldAccess(name1, (org.whole.lang.java.model.SimpleName)name);
		return false;
	}

	public boolean visit(FieldAccess node) {
		acceptChild(node.getExpression());
		org.whole.lang.java.model.Expression exp1 = exp;

		acceptChild(node.getName());
		exp = lf.createFieldAccess(exp1, (org.whole.lang.java.model.SimpleName)name);
		return false;
	}

	public boolean visit(VariableDeclarationExpression node) {
		org.whole.lang.java.model.VariableDeclarationExpression varDecl = lf.create(JavaEntityDescriptorEnum.VariableDeclarationExpression);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			varDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(varDecl.getModifiers(), modifiers);
		}

		acceptChild(node.getType());
		varDecl.setType(type);

		VariableDeclarationFragments fragments;
		varDecl.setFragments(fragments = lf.create(JavaEntityDescriptorEnum.VariableDeclarationFragments));
		Iterator<?> i = node.fragments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			fragments.wAdd(varFrag);
		}

		exp = varDecl;
		return false;
	}

	public boolean visit(VariableDeclarationStatement node) {
		org.whole.lang.java.model.VariableDeclarationStatement varDecl = lf.create(JavaEntityDescriptorEnum.VariableDeclarationStatement);

		List<?> modifiers = node.modifiers();
		if (!modifiers.isEmpty()) {
			varDecl.setModifiers(lf.create(JavaEntityDescriptorEnum.ExtendedModifiers)); 
			setExtendedModifiers(varDecl.getModifiers(), modifiers);
		}

		acceptChild(node.getType());
		varDecl.setType(type);

		VariableDeclarationFragments fragments;
		varDecl.setFragments(fragments = lf.create(JavaEntityDescriptorEnum.VariableDeclarationFragments));
		Iterator<?> i = node.fragments().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			fragments.wAdd(varFrag);
		}

		stm = varDecl;
		return false;
	}

	public boolean visit(VariableDeclarationFragment node) {
		varFrag = lf.create(JavaEntityDescriptorEnum.VariableDeclarationFragment);

		acceptChild(node.getName());
		varFrag.setName((org.whole.lang.java.model.SimpleName)name);

		varFrag.getExtraDimensions().wSetValue(node.getExtraDimensions());

		if (acceptChild(node.getInitializer()))
			varFrag.setInitializer(exp);

		return false;
	}

	public boolean visit(SwitchCase node) {
		if (node.isDefault()) {
			stm = lf.create(JavaEntityDescriptorEnum.SwitchDefault);
		} else {
			org.whole.lang.java.model.SwitchCase swCase = lf.create(JavaEntityDescriptorEnum.SwitchCase);
			acceptChild(node.getExpression());
			swCase.setExpression(exp);
			stm = swCase;
		}

		return false;
	}

	public boolean visit(SwitchStatement node) {
		org.whole.lang.java.model.SwitchStatement swStm = lf.create(JavaEntityDescriptorEnum.SwitchStatement);
		acceptChild(node.getExpression());
		swStm.setExpression(exp);

		Iterator<?> i = node.statements().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			swStm.getStatements().wAdd(stm);
		}

		stm = swStm;

		return false;
	}

	public boolean visit(BreakStatement node) {
		org.whole.lang.java.model.BreakStatement brkStm = lf.create(JavaEntityDescriptorEnum.BreakStatement);
		if (node.getLabel() != null)
			brkStm.setLabel(lf.createSimpleName(node.getLabel().toString()));

		stm = brkStm;

		return false;
	}

	public boolean visit(ArrayAccess node) {
		org.whole.lang.java.model.ArrayAccess aa = lf.create(JavaEntityDescriptorEnum.ArrayAccess);
		acceptChild(node.getArray());
		aa.setArray(exp);

		acceptChild(node.getIndex());
		aa.setIndex(exp);

		exp = aa;

		return false;
	}

	public boolean visit(ArrayCreation node) {
		org.whole.lang.java.model.ArrayCreation ac = lf.create(JavaEntityDescriptorEnum.ArrayCreation);

		acceptChild(node.getType());
		ac.setType((org.whole.lang.java.model.ArrayType)type);

		Iterator<?> i = node.dimensions().iterator();
		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			ac.getDimensions().wAdd(exp);
		}

		if (node.getInitializer() != null) {
			Iterator<?> j = node.getInitializer().expressions().iterator();
			while (j.hasNext()) {
				((ASTNode) j.next()).accept(this);
				ac.getInitializer().wAdd(exp);
			}
		}

		exp = ac;

		return false;
	}

	public boolean visit(ArrayInitializer node) {
		org.whole.lang.java.model.ArrayInitializer ai = lf.create(JavaEntityDescriptorEnum.ArrayInitializer);

		Iterator<?> i = node.expressions().iterator();

		while (i.hasNext()) {
			((ASTNode) i.next()).accept(this);
			ai.wAdd(exp);
		}	

		exp = ai;

		return false;
	}

	public boolean visit(ArrayType node) {
		org.whole.lang.java.model.ArrayType at = lf.create(JavaEntityDescriptorEnum.ArrayType);
		acceptChild(node.getElementType());
		at.setComponentType(type);

		org.whole.lang.java.model.ArrayType compound = at;
		for (int i=0, remaining=node.getDimensions()-1; i<remaining; i++)
			compound = lf.createArrayType(compound);

		type = compound;

		return false;
	}
}
