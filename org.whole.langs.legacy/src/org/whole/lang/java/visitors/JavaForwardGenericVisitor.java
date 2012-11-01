package org.whole.lang.java.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class JavaForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements IJavaVisitor {
	public JavaForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JavaSystemSoftware entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CompilationUnit entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PackageDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BlockComment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LineComment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Javadoc entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Tags entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DocElements entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MethodRef entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MethodRefParameters entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MethodRefParameter entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MemberRef entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TextElement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TagElement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TagName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Annotations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SingleMemberAnnotation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MarkerAnnotation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NormalAnnotation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MemberValuePairs entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MemberValuePair entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ImportDeclarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ImportDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ImportModifier entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeDeclarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumConstants entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumConstantDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnonymousClassDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnnotationTypeDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ClassDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InterfaceDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeParameters entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeParameter entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Types entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BodyDeclarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnnotationTypeMemberDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Initializer entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FieldDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MethodDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConstructorDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Parameters entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SingleVariableDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Varargs entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ParameterizedType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrimitiveType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(QualifiedType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WildcardType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UpperBound entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssertStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Block entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BreakStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConstructorInvocation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ContinueStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EmptyStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnhancedForStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExpressionStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Expressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LabeledStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ReturnStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SuperConstructorInvocation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchCase entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchDefault entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Statements entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SynchronizedStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ThrowStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TryStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CatchClauses entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CatchClause entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeDeclarationStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclarationStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WhileStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Names entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NullLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByteLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CharLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoubleLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FloatLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ShortLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LongLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayAccess entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayCreation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayInitializer entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Assignment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssignmentOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CastExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ClassInstanceCreation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionalExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FieldAccess entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InfixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InfixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InstanceofExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MethodInvocation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ParenthesizedExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PostfixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PostfixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrefixExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrefixOperator entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SuperFieldAccess entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SuperMethodInvocation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ThisExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclarationExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclarationFragments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclarationFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExtraDimensions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExtendedModifiers entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Modifier entity) {
		wGetVisitor1().visit(entity);
	}
}
