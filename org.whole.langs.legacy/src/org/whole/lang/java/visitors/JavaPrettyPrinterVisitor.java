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
package org.whole.lang.java.visitors;

import org.whole.lang.java.model.*;
import org.whole.lang.java.parsers.JavaDataTypePersistenceParser;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.AbstractOperation;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.IdentityWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.java.reflect.OperatorGroupEnum;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class JavaPrettyPrinterVisitor extends JavaTraverseAllVisitor {
	private static final String COMMENT_LINE_PREFIX = " *  ";
	protected final IPrettyPrintWriter out;
	private String typesSeparator = null;
	private String expressionsSeparator = null;
	
	public JavaPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	protected final void printKeyword(String text) {
		out.printRaw(text);
	}
	protected final void printIdentifier(String text) {
		out.printRaw(text);
	}
	protected final void printDelimiter(String text) {
		out.printRaw(text);
	}
	protected final void printParenthesis(String text) {
		out.printRaw(text);
	}
	protected final void printLiteral(String text) {
		out.printRaw(text);
	}

	private void printCond(boolean condition, String trueStr, String falseStr, boolean linefeed)  {
		String str = condition ? trueStr : falseStr;
		if (linefeed)
			out.printlnRaw(str);
		else
			out.printRaw(str);
	}
	private void printCond(boolean condition, String trueString, String falseString)  {
		printCond(condition, trueString, falseString, false);
	}
	private void printlnCond(boolean condition, String trueString, String falseString)  {
		printCond(condition, trueString, falseString, true);
	}

	protected void conditionalAddParetheses(Expression expression, Expression operand) {
		boolean printParentheses = OperatorGroupEnum.hasPrecedence(expression, operand);
		if (printParentheses)
			out.printRaw("(");
		operand.accept(this);
		if (printParentheses)
			out.printRaw(")");
	}

	private boolean isNested(IEntity entity) {
		return Matcher.findAncestor(entity.wGetEntityDescriptor(), entity) != null;
	}
	
	private void safePrettyPrint(IEntity entity) {
		try {
			PrettyPrinterOperation.prettyPrint(entity, IdentityWriter.instance());
			stagedVisit(entity);
		} catch (Exception e) {
			entity = EntityUtils.clone(entity);
			Matcher.removeVars(entity, true);
			try {
				PrettyPrinterOperation.prettyPrint(entity, IdentityWriter.instance());
				stagedVisit(entity);
			} catch (Exception x) {
				((AbstractOperation) getOperation()).stagedDefaultVisit(entity, 0);
			}
		}
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		if (EntityUtils.isFragment(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(JavaEntityDescriptorEnum.TextElement, entity) ||
					(Matcher.match(JavaEntityDescriptorEnum.DocElement, entity) &&
							!EntityUtils.isNull(parent) &&
							Matcher.match(JavaEntityDescriptorEnum.DocElements, parent))) {
				safePrettyPrint(EntityUtils.getFragmentRoot(entity));
				return false;
			}
		} else if (!EntityUtils.isResolver(entity))
			stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(CompilationUnit entity) {
		entity.getPackage().accept(this);
		entity.getImports().accept(this);
		entity.getTypes().accept(this);
	}

	public void visit(PackageDeclaration entity) {
		if (EntityUtils.isResolver(entity.getName()))
			return;
		entity.getJavadoc().accept(this);
		printKeyword("package ");
		entity.getAnnotations().accept(this);
		entity.getName().accept(this);
		out.printlnRaw(";");
		out.println();
	}

	public void visit(MethodRefParameter entity) {
		entity.getType().accept(this);
		entity.getVarargs().accept(this);
		SimpleName name = entity.getName();
		if (!EntityUtils.isResolver(name)) {
			out.printRaw(" ");
			name.accept(this);
		}
	}
	public void visit(MethodRefParameters entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i > 0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
	}
	public void visit(MethodRef entity) {
		Name qualifier = entity.getQualifier();
		if (!EntityUtils.isResolver(qualifier)) {
			qualifier.accept(this);
			out.printRaw("#");
		}
		entity.getName().accept(this);
		out.printRaw("(");
		entity.getParameters().accept(this);
		out.printRaw(")");
	}
	public void visit(MemberRef entity) {
		Name qualifier = entity.getQualifier();
		if (!EntityUtils.isResolver(qualifier)) {
			qualifier.accept(this);
			out.printRaw("#");
		}
		entity.getName().accept(this);
	}
	public void visit(TextElement entity) {
		out.printRaw(StringUtils.stripTrailing(entity.getValue()));
	}
	public void visit(DocElements entity) {
		int size = entity.wSize();
		IEntity parent = entity.wGetParent();
		boolean hasTagName = Matcher.match(JavaEntityDescriptorEnum.TagElement, parent) && EntityUtils.isNotResolver(((TagElement) parent).getTagName());
		if (isNested(entity)) {
			for (int i = 0; i < size; i++) {
				if (i>0)
					out.printRaw(" ");
				entity.get(i).accept(this);
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (i > 0 || !hasTagName) {
					if (hasTagName)
						out.printRaw("    ");
				}
				entity.get(i).accept(this);
				out.println();
			}
		}
	}
	@Override
	public void visit(TagName entity) {
		out.printRaw("@");
		out.printRaw(entity.getValue());
	}
	public void visit(TagElement entity) {
		TagName tagName = entity.getTagName();
		DocElements fragments = entity.getFragments();
		if(isNested(entity)) {
			out.printRaw("{");
			if (!EntityUtils.isResolver(tagName)) {
				tagName.accept(this);
				if (!fragments.wIsEmpty())
					out.printRaw(" ");
			}
			fragments.accept(this);
			out.printRaw("}");
		} else {
			if (!EntityUtils.isResolver(tagName)) {
				tagName.accept(this);
				if (!fragments.wIsEmpty())
					out.printRaw(" ");
			}
			fragments.accept(this);
		}
	}

	@Override
	public void visit(Tags entity) {
		int size = entity.size();
		for (int i = 0; i < size; i++) {
			entity.get(i).accept(this);
			if (i == 0 && size > 1) {
				out.println();
			}
		}
	}
	public void visit(Javadoc entity) {
		if (entity.getTags().wIsEmpty())
			return;
		out.printlnRaw("/**");
		out.addLinePrefix(COMMENT_LINE_PREFIX);
		super.visit(entity);
		out.ensureNewLine();
		out.removeLinePrefix(COMMENT_LINE_PREFIX);
		out.printlnRaw(" */");
	}

	@Override
	public void visit(BlockComment entity) {
		if (entity.getDocElements().wIsEmpty())
			return;
		out.printlnRaw("/*");
		out.addLinePrefix(COMMENT_LINE_PREFIX);
		super.visit(entity);
		out.ensureNewLine();
		out.removeLinePrefix(COMMENT_LINE_PREFIX);
		out.printlnRaw(" */");
	}
	
	@Override
	public void visit(LineComment entity) {
		out.printRaw("// ");
		super.visit(entity);
		out.ensureNewLine();
	}

	public void visit(ImportDeclaration entity) {
		printKeyword("import");
		out.printRaw(" ");
		boolean wStatic = ((ImportModifier)entity.getStatic()).wBooleanValue();
		boolean wOndemand = ((ImportModifier)entity.getOnDemand()).wBooleanValue();
		if (wStatic) {
			printKeyword("static");
			out.printRaw(" ");
		}
		entity.getName().accept(this);
		if (wOndemand)
			out.printRaw(".*");
		out.printlnRaw(";");
	}

	public void visit(InterfaceDeclaration entity) {
		out.println();
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		printKeyword("interface");
		out.printRaw(" ");
		entity.getName().accept(this);
		entity.getTypeParameters().accept(this);

		if (!entity.getSuperInterfaceTypes().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("extends");
			out.printRaw(" ");
			entity.getSuperInterfaceTypes().accept(this);
		}
		out.printlnRaw(" {");
		out.println();
		out.setRelativeIndentation((+1));
		entity.getBodyDeclarations().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}
	public void visit(ClassDeclaration entity) {
		out.println();
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		printKeyword("class");
		out.printRaw(" ");
		entity.getName().accept(this);
		entity.getTypeParameters().accept(this);
		
		if (!EntityUtils.isResolver(entity.getSuperclassType())) {
			out.printRaw(" ");
			printKeyword("extends");
			out.printRaw(" ");
			entity.getSuperclassType().accept(this);
		}
		
		if (!entity.getSuperInterfaceTypes().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("implements");
			out.printRaw(" ");
			entity.getSuperInterfaceTypes().accept(this);
		}
		out.printlnRaw(" {");
		out.setRelativeIndentation((+1));
		entity.getBodyDeclarations().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}
	public void visit(ClassInstanceCreation entity) {
		printKeyword("new");
		out.printRaw(" ");
		if (!EntityUtils.isResolver(entity.getExpression())) {
			entity.getExpression().accept(this);
			out.printRaw(".");
		}
		entity.getTypeArguments().accept(this);
		entity.getType().accept(this);
		out.printRaw("(");
		entity.getArguments().accept(this);
		out.printRaw(")");

		if (EntityUtils.isNotResolver(entity.getAnonymousClassDeclaration())) {
			out.printlnRaw(" {");
			out.setRelativeIndentation((+1));
			entity.getAnonymousClassDeclaration().accept(this);			
			out.setRelativeIndentation((-1));
			out.printRaw("}");
		}
	}

	public void visit(BodyDeclarations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
	}

	public void visit(ExtendedModifiers entity) {
		if (entity.wIsEmpty())
			return;
		for (int i = 0; i < entity.size(); i++) {
			entity.get(i).accept(this);
			if (!Matcher.isAssignableAsIsFrom(JavaEntityDescriptorEnum.Annotation, entity.wGet(i)))//TODO test was isAssignableFrom
				out.printRaw(" ");
		}
	}

	public void visit(Modifier entity) {
		printKeyword(entity.wEnumValue().getName());
	}

	@Override
	public void visit(MarkerAnnotation entity) {
		out.printRaw("@");
		entity.getTypeName().accept(this);
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && Matcher.match(JavaEntityDescriptorEnum.ExtendedModifiers, parent))
			out.println();
		else
			out.printRaw(" ");
	}

	@Override
	public void visit(NormalAnnotation entity) {
		out.printRaw("@");
		entity.getTypeName().accept(this);
		out.printRaw("(");
		entity.getValues().accept(this);
		out.printRaw(")");
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && Matcher.match(JavaEntityDescriptorEnum.ExtendedModifiers, parent))
			out.println();
		else
			out.printRaw(" ");
	}

	@Override
	public void visit(SingleMemberAnnotation entity) {
		out.printRaw("@");
		entity.getTypeName().accept(this);
		out.printRaw("(");
		entity.getValue().accept(this);
		out.printRaw(")");
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && Matcher.match(JavaEntityDescriptorEnum.ExtendedModifiers, parent))
			out.println();
		else
			out.printRaw(" ");
	}

	@Override
	public void visit(MemberValuePairs entity) {
		int size = entity.size();
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				entity.get(i).accept(this);
				if (i<size-1)
					out.printRaw(", ");
			}
		} else if (size == 1)
			entity.get(0).accept(this);
	}

	@Override
	public void visit(MemberValuePair entity) {
		entity.getName().accept(this);
		out.printRaw(" = ");
		entity.getValue().accept(this);
	}

	public void visit(ParameterizedType entity) {
		entity.getType().accept(this);
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
	}

	@Override
	public void visit(AnnotatedType entity) {
		Type type = entity.getType();
		if (Matcher.matchImpl(JavaEntityDescriptorEnum.QualifiedType, type)) {
			QualifiedType qualifiedType = (QualifiedType) type;
			out.printRaw(StringUtils.toPackageName(qualifiedType.getValue()));
			out.printRaw(". ");
			entity.getAnnotations().accept(this);
			out.printRaw(StringUtils.toSimpleName(qualifiedType.getValue()));
		} else {
			entity.getAnnotations().accept(this);
			entity.getType().accept(this);
		}
			
	}

	public void visit(WildcardType entity) {
		out.printRaw("?");
		if (EntityUtils.isNotResolver(entity.getBound())) {
			out.printRaw(" ");
			if (entity.getUpperBound().wBooleanValue())
				out.printRaw("extends");
			else
				out.printRaw("super");
			out.printRaw(" ");
			entity.getBound().accept(this);
		}
	}

	public void visit(SimpleType entity) {
		out.printRaw(entity.getValue());
	}
	
	public void visit(QualifiedType entity) {
		out.printRaw(entity.getValue());
	}

	public void visit(PrimitiveType entity) {
		out.printRaw(entity.getValue().getName());
	}

	public void visit(Types entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw((typesSeparator != null ? typesSeparator : ", "));
			entity.get(i).accept(this);
		}
	}

	@Override
	public void visit(ExtraDimensions entity) {
		int extraDimensions = entity.wIntValue();
		for (int i=0; i<extraDimensions; i++)
			out.printRaw("[]");
	}

	public void visit(ConstructorDeclaration entity) {
		out.println();
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		entity.getTypeParameters().accept(this);
		entity.getName().accept(this);
		out.printRaw("(");
		entity.getParameters().accept(this);
		out.printRaw(")");
		entity.getExtraDimensions().accept(this);
		
		if (!entity.getThrownExceptions().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("throws");
			out.printRaw(" ");
			entity.getThrownExceptions().accept(this);
		}

		out.printlnRaw(" {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	public void visit(MethodDeclaration entity) {
		out.println();
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		entity.getTypeParameters().accept(this);
		entity.getReturnType().accept(this);
		out.printRaw(" ");
		entity.getName().accept(this);
		out.printRaw("(");
		entity.getParameters().accept(this);
		out.printRaw(")");
		entity.getExtraDimensions().accept(this);

		if (!entity.getThrownExceptions().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("throws");
			out.printRaw(" ");
			entity.getThrownExceptions().accept(this);
		}
		
		if (EntityUtils.isResolver(entity.getBody()))
			out.printlnRaw(";");
		else {
			out.printlnRaw(" {");
			out.setRelativeIndentation((+1));
			entity.getBody().accept(this);
			out.setRelativeIndentation((-1));
			out.printlnRaw("}");
		}
	}

	@Override
	public void visit(Initializer entity) {
		out.println();
		entity.getModifiers().accept(this);
		out.printlnRaw("{");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	@Override
	public void visit(EnumDeclaration entity) {
		out.println();
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		printKeyword("enum");
		out.printRaw(" ");
		entity.getName().accept(this);
		
		if (!entity.getSuperInterfaceTypes().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("implements");
			out.printRaw(" ");
			entity.getSuperInterfaceTypes().accept(this);
		}
		out.printlnRaw(" {");
		out.println();
		out.setRelativeIndentation((+1));
		entity.getEnumConstants().accept(this);
		out.printlnRaw(";");
		entity.getBodyDeclarations().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	@Override
	public void visit(EnumConstants entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printlnRaw(",");
			entity.get(i).accept(this);
		}
	}
	@Override
	public void visit(EnumConstantDeclaration entity) {
		entity.getJavadoc().accept(this);
		if (!EntityUtils.isResolver(entity.getModifiers()))
			entity.getModifiers().accept(this);

		entity.getName().accept(this);
		if (!entity.getArguments().wIsEmpty()) {
			out.printRaw("(");
			entity.getArguments().accept(this);
			out.printRaw(")");
		}
		if (!EntityUtils.isResolver(entity.getAnonymousClassDeclaration())) {
			out.printlnRaw(" {");
			out.setRelativeIndentation((+1));
			entity.getAnonymousClassDeclaration().accept(this);			
			out.setRelativeIndentation((-1));
			out.printRaw("}");
		}
	}

	@Override
	public void visit(AnnotationTypeDeclaration entity) {
		if (!EntityUtils.isResolver(entity.getModifiers()))
			entity.getModifiers().accept(this);

		printKeyword("@interface");
		out.printRaw(" ");
		entity.getName().accept(this);
		out.printlnRaw(" {");
		out.setRelativeIndentation((+1));
		entity.getBodyDeclarations().accept(this);
		if (entity.getBodyDeclarations().wSize() > 0)
			out.println();
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	@Override
	public void visit(AnnotationTypeMemberDeclaration entity) {
		if (!EntityUtils.isResolver(entity.getModifiers()))
			entity.getModifiers().accept(this);

		entity.getType().accept(this);
		out.printRaw(" ");
		entity.getName().accept(this);
		out.printRaw("()");
		if (!EntityUtils.isResolver(entity.getDefault())) {
			out.printRaw(" ");
			printKeyword("default");
			out.printRaw(" ");
			entity.getDefault().accept(this);
		}
		out.printRaw(";");
	}

	public void visit(FieldDeclaration entity) {
		entity.getJavadoc().accept(this);
		entity.getModifiers().accept(this);
		entity.getType().accept(this);
		out.printRaw(" ");
		entity.getFragments().accept(this);
		out.printlnRaw(";");
	}

	public void visit(SimpleName entity) {	
		out.printRaw(entity.getValue());	
	}
	
	public void visit(QualifiedName entity) {
		out.printRaw(entity.getValue());
	}
	
	public void visit(BooleanLiteral entity) {
		out.printRaw(entity.wStringValue());
	}
	public void visit(ByteLiteral entity) {
//FIXME		print("(byte) ");
		out.printRaw(entity.wStringValue());
	}
	public void visit(DoubleLiteral entity) {
		out.printRaw(entity.wStringValue());
	}
	public void visit(FloatLiteral entity) {
		out.printRaw(entity.wStringValue());
		out.printRaw("f");
	}
	public void visit(IntLiteral entity) {
		out.printRaw(entity.wStringValue());
	}
	public void visit(ShortLiteral entity) {
//FIXME		print("(short) ");
		out.printRaw(entity.wStringValue());
	}
	public void visit(LongLiteral entity) {
		out.printRaw(entity.wStringValue());
		out.printRaw("l");
	}
	public void visit(CharLiteral entity) {
		out.printRaw("'");
		out.printRaw(StringUtils.escapeCharacter(entity.getValue()));
		out.printRaw("'");
	}
	public void visit(StringLiteral entity) {
		out.printRaw(StringUtils.quoteString(entity.getValue()));
	}
	
	public void visit(TypeLiteral entity) {
		entity.getType().accept(this);
		out.printRaw(".class");
	}

	public void visit(NullLiteral entity) {
		printKeyword(null);
	}	

	public void visit(TypeParameters entity) {
		if (!entity.wIsEmpty()) {
			out.printRaw("<");
			for (int i = 0; i < entity.size(); i++)
				entity.get(i).accept(this);
			out.printRaw("> ");
		}
	}

	public void visit(TypeParameter entity) {
		entity.getAnnotations().accept(this);
		entity.getName().accept(this);
		if (!entity.getTypeBounds().wIsEmpty()) {
			out.printRaw(" ");
			printKeyword("extends");
			out.printRaw(" ");
			typesSeparator = " & ";
			entity.getTypeBounds().accept(this);
			typesSeparator = null;
		}
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
	}
	
	public void visit(FieldAccess entity) {
		entity.getExpression().accept(this);
		out.printRaw(".");
		entity.getName().accept(this);
	}

	public void visit(SuperFieldAccess entity) {
		if (!EntityUtils.isResolver(entity.getQualifier())) {
			entity.getQualifier().accept(this);
			out.printRaw(".");
		}
		
		printKeyword("super");
		out.printRaw(".");
		entity.getName().accept(this);
	}

	@Override
	public void visit(Varargs entity) {
		if (entity.wBooleanValue())
			out.printRaw("...");
	}

	public void visit(SingleVariableDeclaration entity) {
		entity.getModifiers().accept(this);
		entity.getType().accept(this);
		if (!entity.getVarargsAnnotations().wIsEmpty())
			out.printRaw(" ");
		entity.getVarargsAnnotations().accept(this);
		entity.getVarargs().accept(this);
		out.printRaw(" ");
		entity.getName().accept(this);
		entity.getExtraDimensions().accept(this);
		entity.getInitializer().accept(this);
	}

	public void visit(VariableDeclarationStatement entity) {
		if (!EntityUtils.isResolver(entity.getModifiers()))
			entity.getModifiers().accept(this);
		entity.getType().accept(this);
		out.printRaw(" ");
		entity.getFragments().accept(this);
		out.printlnRaw(";");
	}

	public void visit(VariableDeclarationFragments entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
	}
	
	public void visit(VariableDeclarationFragment entity) {
		entity.getName().accept(this);
		entity.getExtraDimensions().accept(this);
		if (!EntityUtils.isResolver(entity.getInitializer())) {
			out.printRaw(" = ");
			entity.getInitializer().accept(this);
		}
	}

	public void visit(VariableDeclarationExpression entity) {
		entity.getModifiers().accept(this);
		entity.getType().accept(this);
		out.printRaw(" ");
		entity.getFragments().accept(this);
	}
	
	public void visit(PostfixExpression entity) {
		entity.getOperand().accept(this);
		entity.getOperator().accept(this);
	}

	public void visit(PrefixExpression entity) {
		entity.getOperator().accept(this);
		conditionalAddParetheses(entity, entity.getOperand());
	}

	@Override
	public void visit(ConditionalExpression entity) {
		entity.getExpression().accept(this);
		out.printRaw(" ? ");
		entity.getThenExpression().accept(this);
		out.printRaw(" : ");
		entity.getElseExpression().accept(this);
	}

	public void visit(Block entity) {
		IEntity parent =  entity.wGetParent();
		boolean printCurlyBraces = !EntityUtils.isNull(entity) &&
				(Matcher.match(JavaEntityDescriptorEnum.Statements, parent) ||
				Matcher.match(JavaEntityDescriptorEnum.Block, parent) ||
				Matcher.match(JavaEntityDescriptorEnum.LambdaExpression, parent));
		if (printCurlyBraces) {
			out.printlnRaw("{");
			out.setRelativeIndentation((+1));
		}
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
		if (printCurlyBraces) {
			out.setRelativeIndentation((-1));
			if (Matcher.match(JavaEntityDescriptorEnum.LambdaExpression, parent))
				out.printRaw("}");
			else
				out.printlnRaw("}");
		}
	}

	public void visit(CastExpression entity) {
		out.printRaw("(");
		entity.getType().accept(this);
		out.printRaw(") ");
		entity.getExpression().accept(this);
	}

	public void visit(ParenthesizedExpression entity) {
		out.printRaw("(");
		entity.getExpression().accept(this);
		out.printRaw(")");
	}

	public void visit(InstanceofExpression entity) {
		entity.getLeftOperand().accept(this);
		out.printRaw(" instanceof ");
		entity.getRightOperand().accept(this);
	}

	public void visit(LambdaExpression entity) {
		LambdaParameters parameters = entity.getParameters();
		if (EntityUtils.isComposite(parameters)) {
			out.printRaw("(");
			parameters.accept(this);
			out.printRaw(")");
		} else
			parameters.accept(this);
		out.printRaw(" -> ");
		entity.getBody().accept(this);
	}

	@Override
	public void visit(ConstructorReference entity) {
		entity.getType().accept(this);
		out.printRaw("::");
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		out.printRaw("new");
	}

	@Override
	public void visit(ExpressionMethodReference entity) {
		entity.getExpression().accept(this);
		out.printRaw("::");
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		entity.getName().accept(this);
	}

	@Override
	public void visit(SuperMethodReference entity) {
		Name qualifier = entity.getQualifier();
		if (EntityUtils.isNotResolver(qualifier)) {
			qualifier.accept(this);
			out.printRaw(".");
		}
		out.printRaw("super::");
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		entity.getName().accept(this);
	}

	@Override
	public void visit(TypeMethodReference entity) {
		entity.getType().accept(this);
		out.printRaw("super::");
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		entity.getName().accept(this);
	}

	public void visit(MethodInvocation entity) {
		if (!EntityUtils.isResolver(entity.getExpression())) {
			entity.getExpression().accept(this);
			out.printRaw(".");
		}
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		entity.getName().accept(this);
		out.printRaw("(");
		entity.getArguments().accept(this);
		out.printRaw(")");
	}
	
	public void visit(SuperMethodInvocation entity) {
		if (!EntityUtils.isResolver(entity.getQualifier())) {
			entity.getQualifier().accept(this);
			out.printRaw(".");
		}
		
		printKeyword("super");
		out.printRaw(".");
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		entity.getName().accept(this);
		out.printRaw("(");
		entity.getArguments().accept(this);
		out.printRaw(")");
	}


	public void visit(ConstructorInvocation entity) {
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		printKeyword("this");
		out.printRaw("(");
		entity.getArguments().accept(this);
		out.printRaw(")");
		out.printlnRaw(";");
	}

	public void visit(SuperConstructorInvocation entity) {
		entity.getExpression().accept(this);
		if (!entity.getTypeArguments().wIsEmpty()) {
			out.printRaw("<");
			entity.getTypeArguments().accept(this);
			out.printRaw(">");
		}
		printKeyword("super");
		out.printRaw("(");
		entity.getArguments().accept(this);
		out.printRaw(")");
		out.printlnRaw(";");
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
	}	

	public void visit(ExpressionStatement entity) {
		entity.getExpression().accept(this);
		out.printlnRaw(";");
	}

	public void visit(ReturnStatement entity) {
		printKeyword("return");
		out.printRaw(" ");
		entity.getExpression().accept(this);
		out.printlnRaw(";");
	}

	@Override
	public void visit(ContinueStatement entity) {
		printKeyword("continue");
		if (!EntityUtils.isResolver(entity.getLabel()))
			out.printRaw(" ");
		entity.getLabel().accept(this);
		out.printlnRaw(";");
	}

	public void visit(SynchronizedStatement entity) {
		printKeyword("synchronized");
		out.printRaw(" (");
		entity.getExpression().accept(this);
		out.printlnRaw(") {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	@Override
	public void visit(AssertStatement entity) {
		printKeyword("assert");
		out.printRaw(" ");
		entity.getExpression().accept(this);
		if (!EntityUtils.isResolver(entity.getMessage()))
			out.printRaw(" ");
		entity.getMessage().accept(this);
		out.printlnRaw(";");
	}

	public void visit(ThisExpression entity) {
		if (!EntityUtils.isResolver(entity.getQualifier())) {
			entity.getQualifier().accept(this);
			out.printRaw(".");
		}
		printKeyword("this");
	}

	public void visit(InfixExpression entity) {
		conditionalAddParetheses(entity, entity.getLeftOperand());
		out.printRaw(" ");
		entity.getOperator().accept(this);
		out.printRaw(" ");
		conditionalAddParetheses(entity, entity.getRightOperand());

		Expressions operands = entity.getExtendedOperands();
		if (operands.wIsAdapter())
			operands.accept(this);
		else {
			if (operands.wIsEmpty())
				return;
			for (int i = 0; i < operands.size(); i++) {
				out.printRaw(" ");
				entity.getOperator().accept(this);
				out.printRaw(" ");
				conditionalAddParetheses(entity, operands.get(i));
			}
		}
	}

	public void visit(Statements entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
	}	

	public void visit(IfStatement entity) {
		printKeyword("if");
		out.printRaw(" (");
		entity.getExpression().accept(this);
		out.printRaw(")");
		boolean printBlockBraces = EntityUtils.isComposite(entity.getThenStatement());
		printlnCond(printBlockBraces, " {", "");
		out.setRelativeIndentation((+1));
		entity.getThenStatement().accept(this);
		out.setRelativeIndentation((-1));
		if (!EntityUtils.isResolver(entity.getElseStatement())) {
			printCond(printBlockBraces, "} ", "");
			printKeyword("else");
			printBlockBraces = EntityUtils.isComposite(entity.getElseStatement());
			boolean elseIfRow = Matcher.match(JavaEntityDescriptorEnum.IfStatement, entity.getElseStatement());
			printCond(printBlockBraces, " {", elseIfRow ? " " : "", !elseIfRow);
			if (!elseIfRow)
				out.setRelativeIndentation((+1));
			entity.getElseStatement().accept(this);
			if (!elseIfRow)
				out.setRelativeIndentation((-1));
		}
		if (printBlockBraces) {
			out.printlnRaw("}");
		}
	}

	@Override
	public void visit(EnhancedForStatement entity) {
		printKeyword("for");
		out.printRaw(" (");
		entity.getParameter().accept(this);
		out.printRaw(" : ");
		entity.getExpression().accept(this);
		out.printRaw(")");
		boolean printBlockBraces = EntityUtils.isComposite(entity.getBody());
		printlnCond(printBlockBraces, " {", "");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		if (printBlockBraces) {
			out.printlnRaw("}");
		}
	}

	public void visit(ForStatement entity) {
		printKeyword("for");
		out.printRaw(" (");
		entity.getInitializers().accept(this);
		out.printRaw("; ");
		entity.getExpression().accept(this);
		out.printRaw("; ");
		entity.getUpdaters().accept(this);
		out.printRaw(")");
		boolean printBlockBraces = EntityUtils.isComposite(entity.getBody());
		printlnCond(printBlockBraces, " {", "");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		if (printBlockBraces) {
			out.printlnRaw("}");
		}
	}

	public void visit(SwitchStatement entity) {
		printKeyword("switch");
		out.printRaw(" (");
		entity.getExpression().accept(this);
		out.printlnRaw(") {");
		out.setRelativeIndentation((+1));
		entity.getStatements().accept(this);
		out.setRelativeIndentation((-1));
		out.printlnRaw("}");
	}

	public void visit(WhileStatement entity) {
		printKeyword("while");
		out.printRaw(" (");
		entity.getExpression().accept(this);
		out.printRaw(")");
		boolean printBlockBraces = EntityUtils.isComposite(entity.getBody());
		printlnCond(printBlockBraces, " {", "");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		if (printBlockBraces) {
			out.printlnRaw("}");
		}
	}

	public void visit(DoStatement entity) {
		printKeyword("do");
		out.printlnRaw(" {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		out.printRaw("} ");
		printKeyword("while");
		out.printRaw(" (");
		entity.getExpression().accept(this);
		out.printlnRaw(");");
	}
	
	public void visit(SwitchCase entity) {
		printKeyword("case");
		out.printRaw(" ");
		entity.getExpression().accept(this);
		out.printlnRaw(" :");
	}
	public void visit(SwitchDefault entity) {
		printKeyword("default");
		out.printlnRaw(" :");
	}
	
	public void visit(BreakStatement entity) {
		printKeyword("break");
		if (!EntityUtils.isResolver(entity.getLabel()))
			out.printRaw(" ");
		entity.getLabel().accept(this);
		out.printlnRaw(";");
	}

	public void visit(UnionType entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(" | ");
			entity.get(i).accept(this);
		}
	}

	public void visit(IntersectionType entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(" & ");
			entity.get(i).accept(this);
		}
	}

	public void visit(Assignment entity) {
		entity.getLeftHandSide().accept(this);
		out.printRaw(" ");
		entity.getOperator().accept(this);
		out.printRaw(" ");
		entity.getRightHandSide().accept(this);
	}

	public void visit(AssignmentOperator entity) {
		out.printRaw(JavaDataTypePersistenceParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(InfixOperator entity) {
		out.printRaw(JavaDataTypePersistenceParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(PostfixOperator entity) {
		out.printRaw(JavaDataTypePersistenceParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(PrefixOperator entity) {
		out.printRaw(JavaDataTypePersistenceParser.instance().unparseEnumValue(entity.wGetEntityDescriptor(), entity.getValue()));
	}

	public void visit(ArrayAccess entity) {
		entity.getArray().accept(this);
		out.printRaw("[");
		entity.getIndex().accept(this);
		out.printRaw("]");
	}

	public void visit(ArrayCreation entity) {
		printKeyword("new");
		out.printRaw(" ");
		entity.getType().accept(this);
		int size = entity.getDimensions().wSize();
		if (!EntityUtils.isResolver(entity.getDimensions()) && size > 0) {
			out.printRaw("[");
			expressionsSeparator = "][";
			entity.getDimensions().accept(this);
			expressionsSeparator = null;
			out.printRaw("]");
		} else {
			Type type = entity.getType();
			while (Matcher.match(JavaEntityDescriptorEnum.ArrayType, type)) {
				out.printRaw("[]");
				type = ((ArrayType) type).getComponentType();
			}
			out.printRaw(" ");
			if (!EntityUtils.isResolver(entity.getInitializer()))
				entity.getInitializer().accept(this);
			else
				out.printRaw("{ }");
		}
	}

	public void visit(Expressions entity) {
		for (int i = 0; i < entity.size(); i++) {
			if (i>0 && expressionsSeparator != null)
				out.printRaw(expressionsSeparator);
			entity.get(i).accept(this);
		}
	}	


	public void visit(ArrayInitializer entity) {
		out.printRaw(" {");
		for (int i = 0; i < entity.size(); i++) {
			if (i>0)
				out.printRaw(" , ");
			entity.get(i).accept(this);
		}
		out.printRaw("}");
	}	

	public void visit(ArrayType entity) {
		if (Matcher.match(JavaEntityDescriptorEnum.ArrayCreation, entity.wGetParent())) {
			Type componentType = entity.getComponentType();
			while (Matcher.matchImpl(JavaEntityDescriptorEnum.ArrayType, componentType))
				componentType = ((ArrayType) componentType).getComponentType();
			componentType.accept(this);
		} else {
			entity.getComponentType().accept(this);
			out.printRaw("[]");
		}
	}

	public void visit(CatchClause entity) {
		out.printRaw("} ");
		printKeyword("catch");
		out.printRaw(" (");
		entity.getException().accept(this);
		out.printlnRaw(") {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
	}

	public void visit(ThrowStatement entity) {
		printKeyword("throw");
		out.printRaw(" ");
		entity.getExpression().accept(this);
		out.printlnRaw(";");
	}

	public void visit(TryStatement entity) {
		printKeyword("try");
		out.printlnRaw(" {");
		out.setRelativeIndentation((+1));
		entity.getBody().accept(this);
		out.setRelativeIndentation((-1));
		entity.getCatchClauses().accept(this);
		if (!entity.getFinally().wIsEmpty()) {
			out.printRaw("} ");
			printKeyword("finally");
			out.printlnRaw(" {");
			out.setRelativeIndentation((+1));
			entity.getFinally().accept(this);
			out.setRelativeIndentation((-1));
		}
		out.printlnRaw("}");
	}

	public void visit(EmptyStatement entity) {
		out.printlnRaw(";");
	}
}

