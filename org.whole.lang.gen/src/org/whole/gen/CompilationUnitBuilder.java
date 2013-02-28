/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.gen;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.model.AbstractEntity;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;



/**
 * @author Riccardo Solmi
 */
public class CompilationUnitBuilder extends AbstractEntity {
    public static final String LANG_PACKAGE = "org.whole.lang";
    
	public final JavaModelGenerator generator;
	public final AST ast;
	public final List<CompilationUnit> cuList;

	public CompilationUnit cu;
	public PackageDeclaration packageDec;
	public TypeDeclaration typeDec;
	public MethodDeclaration methodDec;
	public Block block;
	public Statement stm;
	public Name name;
	public Expression exp;
	public List<Expression> expList;
	public Type type;

	protected boolean isInterface = false;

	public CompilationUnitBuilder(JavaModelGenerator generator) {
		this.generator = generator;
		ast = generator.ast;
		cuList = generator.cuList;

		newCompilationUnit();
	}
	public CompilationUnitBuilder(JavaModelGenerator generator, String packageSuffix) {
		this(generator);
		
		putPackageDeclaration(generator.packagePrefix+"."+packageSuffix);
	}

	public CompilationUnit getCompilationUnit() {
		return cu;
	}
	public TypeDeclaration getType() {
		return typeDec;
	}

	protected CompilationUnit newCompilationUnit() {
		cuList.add(cu = ast.newCompilationUnit());
		return cu;
	}

	public void putCUDocComment() {
		String copyright = generator.getCopyright();
		String license = generator.getLicense();
		String comment = copyright;
		if (comment != null && comment.length() > 0)
			comment += "\n "+license;
		else
			comment = license;

		if (comment != null && comment.length() > 0) {
			TagElement te = newTagElement(null, comment);
			Javadoc cuDoc = newJavadoc();
			cuDoc.tags().add(te);
			packageDec.setJavadoc(cuDoc);
		}
	}

	public void putPackageDeclaration(String packageName) {
	    if (packageDec == null) {
	        packageDec = ast.newPackageDeclaration();
	        packageDec.setName(newQualifiedName(packageName));
			cu.setPackage(packageDec);

			putCUDocComment();
			
			packageImportSet.add(packageName);
	    }
	}

	private Set<String> classImportSet = new HashSet<String>(32);
	private Set<String> packageImportSet = new HashSet<String>(32);
	protected Set<String> simpleNameImportSet = new HashSet<String>(32);
	private Set<String> packageNoImportSet = new HashSet<String>(32);
	public void noImportPackage(String packageName) {
	    packageNoImportSet.add(packageName);
	}
	public boolean addImportDeclaration(String typeName) {
		return addImportDeclaration(typeName, false);
	}
	public boolean addImportDeclaration(String typeName, boolean onDemand) {
		return addImportDeclaration(typeName, onDemand, false);
	}
	public boolean addImportDeclaration(String typeName, boolean onDemand, boolean isStatic) {
		if (onDemand) {
			if (packageImportSet.contains(typeName))
				return true;
			packageImportSet.add(typeName);
		} else {
		    String packageName = StringUtils.toPackageName(typeName);
		    String simpleName = StringUtils.toSimpleName(typeName);
		    
		    if (classImportSet.contains(typeName))
				return true;

			if ("java.lang".equals(packageName))//&& StringUtils.isAmbiguous(simpleName)
				return !simpleNameImportSet.contains(simpleName);

			if (!StringUtils.isAmbiguous(simpleName)) {
			    if (packageNoImportSet.contains(packageName) ||
			            simpleNameImportSet.contains(simpleName))
			        return false;
				else if (packageImportSet.contains(packageName)) {
					classImportSet.add(typeName);
					simpleNameImportSet.add(simpleName);
					return true;
				}
		    }

			classImportSet.add(typeName);
			simpleNameImportSet.add(simpleName);
		}

		ImportDeclaration id = ast.newImportDeclaration();
		id.setName(newQualifiedName(typeName));
		id.setOnDemand(onDemand);	
		id.setStatic(isStatic);
		cu.imports().add(id);
		return true;
	}

	public SingleMemberAnnotation newSingleMemberAnnotation(String typeName, String value) {
		return newSingleMemeberAnnotation(typeName, newLiteral(value));
	}
	public SingleMemberAnnotation newSingleMemeberAnnotation(String typeName, Expression exp) {
		SingleMemberAnnotation annotation = ast.newSingleMemberAnnotation();
		annotation.setTypeName(newSimpleName(typeName));
		annotation.setValue(exp);
		return annotation;
	}

	public TextElement newTextElement(String text) {
	    TextElement elem = ast.newTextElement();
	    elem.setText(text);
	    return elem;
	}
	public TagElement newTagElement(String tagName) {
	    TagElement tag = ast.newTagElement();
		tag.setTagName(tagName);
		return tag;
	}
	public TagElement newTagElement(String tagName, String text) {
	    TagElement tag = newTagElement(tagName);
	    tag.fragments().add(newTextElement(" "+text));
	    return tag;
	}
	public Javadoc newJavadoc() {
	    return ast.newJavadoc();
	}
	public Javadoc newJavadoc(String author) {
		Javadoc doc = ast.newJavadoc();
		if (author != null)
		    doc.tags().add(newTagElement(TagElement.TAG_AUTHOR, author));
		doc.tags().add(newTagElement("@generator", "Whole"));
	    return doc;
	}
	public String getAuthor() {
	    if (generator != null)
	        return generator.getAuthor();
	    else
	        return "";
	}
	
	public TypeDeclaration addClassDeclaration(String name) {
	    putPackageDeclaration(StringUtils.toPackageName(name));

		typeDec = ast.newTypeDeclaration();		
		typeDec.setJavadoc(newJavadoc(getAuthor()));
		typeDec.setInterface(isInterface = false);
		typeDec.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		typeDec.setName(ast.newSimpleName(StringUtils.toSimpleName(name)));
		cu.types().add(typeDec);
		return typeDec;
	}
	public TypeDeclaration addClassDeclaration(String name, String superclassName) {
		addClassDeclaration(name);
		setSuperclass(superclassName);
		return typeDec;
	}
	public TypeDeclaration addClassDeclaration(String name, Type superclassName) {
		addClassDeclaration(name);
		setSuperclass(superclassName);
		return typeDec;
	}
	public TypeDeclaration addInterfaceDeclaration(String name) {
	    putPackageDeclaration(StringUtils.toPackageName(name));

	    typeDec = ast.newTypeDeclaration();
		typeDec.setJavadoc(newJavadoc(getAuthor()));
		typeDec.setInterface(isInterface = true);
		typeDec.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		typeDec.setName(ast.newSimpleName(StringUtils.toSimpleName(name)));
		cu.types().add(typeDec);
		return typeDec;
	}
	public TypeDeclaration addInterfaceDeclaration(String name, String superclassName) {
		addInterfaceDeclaration(name);
		addSuperInterface(superclassName);
		return typeDec;
	}
	public TypeDeclaration addInterfaceDeclaration(String name, Type superclassName) {
		addInterfaceDeclaration(name);
		addSuperInterface(superclassName);
		return typeDec;
	}
	public CompilationUnit addImplementationType(String implementationName, CompilationUnit interfaceCU) {
		TypeDeclaration interfaceType = (TypeDeclaration)interfaceCU.types().get(0);

		addClassDeclaration(implementationName);
//		addSuperInterface(interfaceType.getName().getIdentifier());

//		addImportDeclaration(interfaceCU.getPackage().getName().toString()+"."+interfaceType.getName().getIdentifier());
		Iterator i = interfaceCU.imports().iterator();
		while (i.hasNext()) {
			ImportDeclaration importDec = (ImportDeclaration)i.next();
			if (importDec.isOnDemand())
				addImportDeclaration(importDec.getName().getFullyQualifiedName(), true);
//			else
//				addImportDeclaration(importDec.getName().toString());
		}

		i = interfaceType.bodyDeclarations().iterator();
		while (i.hasNext()) {
			Object declaration = i.next();
			if (declaration instanceof MethodDeclaration) {
				String typeName = ((SingleVariableDeclaration)((MethodDeclaration)declaration).parameters().get(0)).getType().toString();
				addVisitMethod(typeName);				
			}
		}
		return cu;
	}

	public void setSuperclass(String superClass) {
		typeDec.setSuperclassType(newType(superClass));
	}
	public void setSuperclass(Type superClass) {
		typeDec.setSuperclassType(superClass);
	}
	public void addSuperInterface(String superInterface) {
		typeDec.superInterfaceTypes().add(newType(superInterface));
	}
	public void addSuperInterface(Type superInterface) {
		typeDec.superInterfaceTypes().add(superInterface);
	}

	public List bodyDeclarations() {
	    return typeDec.bodyDeclarations();
	}
	public void addBodyDeclaration(BodyDeclaration declaration) {
	    if (declaration instanceof MethodDeclaration)
	        methodDec = (MethodDeclaration)declaration;
		bodyDeclarations().add(declaration);
	}
	public void addBodyDeclaration(int index, BodyDeclaration declaration) {
	    if (declaration instanceof MethodDeclaration)
	        methodDec = (MethodDeclaration)declaration;
		bodyDeclarations().add(index, declaration);
	}

	public FieldDeclaration newSerialVersionUID(long value) {
		FieldDeclaration field = newFieldDeclaration("long", "serialVersionUID", newLiteral(value));
		field.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		field.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		return field;
	}
	public void addSerialVersionUID(long value) {
		addBodyDeclaration(newSerialVersionUID(value));
	}

	//TODO rename to newName
	public Name newSimpleName(String name) {
		if (StringUtils.isQualified(name)) {
		    if (addImportDeclaration(name)) {
			    return ast.newSimpleName(StringUtils.toSimpleName(name));
		    } else {
		        String[] names = name.split("\\.");
		        Name qName = ast.newSimpleName(names[0]);
		        for (int i=1; i<names.length; i++) {
		            qName = ast.newQualifiedName(qName, ast.newSimpleName(names[i]));
		        }
		        return qName;
		    }
		} else
	        return ast.newSimpleName(name);
	}
	public Name newSimpleQualifiedName(String name) {
		if (StringUtils.isQualified2(name))
		    if (addImportDeclaration(StringUtils.toPackageName(name)))
			    return newQualifiedName(StringUtils.toSimpleQualifiedName(name));
		return newQualifiedName(name);
	}
	public Name newQualifiedName(String name) {
		if (StringUtils.isQualified(name)) {
	        String[] names = name.split("\\.");
	        Name qName = ast.newSimpleName(names[0]);
	        for (int i=1; i<names.length; i++) {
	            qName = ast.newQualifiedName(qName, ast.newSimpleName(names[i]));
	        }
	        return qName;
		} else
	        return ast.newSimpleName(name);
	}

	public Type newQualifiedType(String name) {
		if (StringUtils.isQualified(name))
			return ast.newSimpleType(newQualifiedName(name));
		else
			return newType(name);
	}
	public Type newSimpleQualifiedType(String name) {
        return ast.newSimpleType(newSimpleQualifiedName(name));
	}

	public MethodDeclaration newCloneMethod() {
		MethodDeclaration cloneMethod = ast.newMethodDeclaration();
		cloneMethod.setConstructor(false);
		cloneMethod.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		cloneMethod.setReturnType2(ast.newSimpleType(newSimpleName("java.lang.Object")));
		cloneMethod.setName(ast.newSimpleName("clone"));
		Block body = newBlock();

		CastExpression castExp = ast.newCastExpression();
		castExp.setType(newType(typeDec.getName().getIdentifier()));

		SuperMethodInvocation superCall = ast.newSuperMethodInvocation();
		superCall.setName(ast.newSimpleName("clone"));
		castExp.setExpression(superCall);
		
		VariableDeclarationFragment varDec = ast.newVariableDeclarationFragment();
		varDec.setName(ast.newSimpleName("obj"));
		varDec.setInitializer(castExp);
		VariableDeclarationStatement varDecStm = ast.newVariableDeclarationStatement(varDec);
		varDecStm.setType(newType(typeDec.getName().getIdentifier()));
		body.statements().add(varDecStm);

		ReturnStatement returnStm = ast.newReturnStatement();
		returnStm.setExpression(ast.newSimpleName("obj"));
		body.statements().add(returnStm);

		cloneMethod.setBody(body);
		return cloneMethod;
	}

	public MethodDeclaration newAcceptMethod(String visitorInterfaceName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName("accept"));
		method.parameters().add(newSingleVariableDeclaration(visitorInterfaceName, "visitor"));

		if (!isInterface) {
			Block body = newBlock();
			MethodInvocation callExp = ast.newMethodInvocation();
			callExp.setExpression(ast.newSimpleName("visitor"));
			callExp.setName(ast.newSimpleName("visit"));
			callExp.arguments().add(ast.newThisExpression());
			body.statements().add(ast.newExpressionStatement(callExp));
			method.setBody(body);
		}
		return method;
	}

	public CastExpression newCastExpression(Type type, Expression exp) {
		CastExpression castExp = ast.newCastExpression();
		castExp.setType(type);
		castExp.setExpression(exp);
		return castExp;
	}
	public CastExpression newCastExpression(String type, Expression exp) {
		return newCastExpression(type, exp, false);
	}
	public CastExpression newCastExpression(String type, Expression exp, boolean useQualifiedType) {
		return newCastExpression(useQualifiedType ? newQualifiedType(type) : newType(type), exp);
	}

	public ReturnStatement newReturnStatement(Expression exp) {
		ReturnStatement stm = ast.newReturnStatement();
		stm.setExpression(exp);
		return stm;
	}

	public ThrowStatement newThrowStatement(Expression exp) {
		ThrowStatement stm = ast.newThrowStatement();
		stm.setExpression(exp);
		return stm;
	}

	public Assignment newAssignment(Expression exp1, String op, Expression exp2) {
		Assignment eqExp = ast.newAssignment();
		eqExp.setLeftHandSide(exp1);
		eqExp.setOperator(Assignment.Operator.toOperator(op));
		eqExp.setRightHandSide(exp2);
		return eqExp;
	}
	public Assignment newAssignment(Expression exp1, Expression exp2) {
		return newAssignment(exp1, "=", exp2);
	}
	public Assignment newAssignment(String name, Expression exp) {
		return newAssignment(ast.newSimpleName(name), exp);
	}
	
	public PostfixExpression newPostfixExpression(String id, String op) {
	    return newPostfixExpression(ast.newSimpleName(id), op);
	}

	public PostfixExpression newPostfixExpression(Expression exp, String op) {
		PostfixExpression postfixExp = ast.newPostfixExpression();
		postfixExp.setOperand(exp);
		postfixExp.setOperator(PostfixExpression.Operator.toOperator(op));
		return postfixExp;
	}

	public PrefixExpression newPrefixExpression(String id, String op) {
	    return newPrefixExpression(ast.newSimpleName(id), op);
	}

	public PrefixExpression newPrefixExpression(Expression exp, String op) {
	    PrefixExpression prefixExp = ast.newPrefixExpression();
	    prefixExp.setOperand(exp);
	    prefixExp.setOperator(PrefixExpression.Operator.toOperator(op));
		return prefixExp;
	}

	public InfixExpression newInfixExpression(Expression exp1, String op, Expression exp2) {
	    InfixExpression infixExp = ast.newInfixExpression();
	    infixExp.setLeftOperand(exp1);
	    infixExp.setOperator(InfixExpression.Operator.toOperator(op));
	    infixExp.setRightOperand(exp2);
		return infixExp;
	}

	public InstanceofExpression newInstanceofExpression(String exp1, String type) {
		return newInstanceofExpression(ast.newSimpleName(exp1), type);
	}
	public InstanceofExpression newInstanceofExpression(Expression exp1, String type) {
		return newInstanceofExpression(exp1, newType(type));
	}
	public InstanceofExpression newInstanceofExpression(Expression exp1, Type type) {
		InstanceofExpression exp = ast.newInstanceofExpression();
		exp.setLeftOperand(exp1);
		exp.setRightOperand(type);
		return exp;
	}

	public ClassInstanceCreation newClassInstanceCreation(Type type) {
		ClassInstanceCreation stm = ast.newClassInstanceCreation();
		stm.setType(type);
		return stm;
	}
	public ClassInstanceCreation newClassInstanceCreation(Type type, Expression arg0) {
		ClassInstanceCreation stm = newClassInstanceCreation(type);
		stm.arguments().add(arg0);
		return stm;
	}
	public ClassInstanceCreation newClassInstanceCreation(Type type, Expression arg0, Expression arg1) {
		ClassInstanceCreation stm = newClassInstanceCreation(type);
		stm.arguments().add(arg0);
		stm.arguments().add(arg1);
		return stm;
	}
	public ClassInstanceCreation newClassInstanceCreation(Type type, Expression arg0, Expression arg1, Expression arg2) {
		ClassInstanceCreation stm = newClassInstanceCreation(type);
		stm.arguments().add(arg0);
		stm.arguments().add(arg1);
		stm.arguments().add(arg2);
		return stm;
	}
	public ClassInstanceCreation newClassInstanceCreation(String type) {
		return newClassInstanceCreation(newType(type));
	}
	public ClassInstanceCreation newClassInstanceCreation(String type, Expression arg0) {
		return newClassInstanceCreation(newType(type), arg0);
	}
	public ClassInstanceCreation newClassInstanceCreation(String type, Expression arg0, Expression arg1) {
		return newClassInstanceCreation(newType(type), arg0, arg1);
	}
	public ClassInstanceCreation newClassInstanceCreation(String type, Expression arg0, Expression arg1, Expression arg2) {
		return newClassInstanceCreation(newType(type), arg0, arg1, arg2);
	}

	public ArrayInitializer newArrayInitializer() {
	    return ast.newArrayInitializer();
	}
	public ArrayCreation newArrayCreation(String type, ArrayInitializer initializer) {
		ArrayCreation stm = newArrayCreation(type);
		stm.setInitializer(initializer);
		return stm;
	}
	public ArrayCreation newArrayCreation(String type) {
		return newArrayCreation(type, 1);
	}
	public ArrayCreation newArrayCreation(String type, int dimensions) {
		ArrayCreation stm = ast.newArrayCreation();
		stm.setType(newArrayType(type, dimensions));
		return stm;
	}

	public TryStatement newTryStatement(Statement stm, SingleVariableDeclaration exc, Statement body) {
		TryStatement tryStm = newTryStatement();
		tryStm.getBody().statements().add(stm);
		tryStm.catchClauses().add(newCatchClause(exc, body));
		return tryStm;
	}
	public TryStatement newTryStatement() {
		return ast.newTryStatement();
	}	
	public CatchClause newCatchClause() {
		return ast.newCatchClause();
	}
	public CatchClause newCatchClause(SingleVariableDeclaration exc) {
		CatchClause clause = newCatchClause();
		clause.setException(exc);
		return clause;
	}
	public CatchClause newCatchClause(SingleVariableDeclaration exc, Statement body) {
		CatchClause clause = newCatchClause(exc);
		clause.getBody().statements().add(body);
		return clause;
	}

	public VariableDeclarationStatement newVariableDeclarationStatement(String type, String name) {
	    return newVariableDeclarationStatement(type, name, null);
	}
	public VariableDeclarationStatement newVariableDeclarationStatement(String type, String name, Expression initializer) {
		return newVariableDeclarationStatement(newType(type), newVariableDeclarationFragment(name, initializer));
	}
	public void addVariableDeclarationStatement(String type, String name, Expression initializer) {
		addStatement(newVariableDeclarationStatement(type, name, initializer));
	}
	public VariableDeclarationStatement newVariableDeclarationStatement(Type fType, VariableDeclarationFragment varDec) {
		VariableDeclarationStatement varDecStm = ast.newVariableDeclarationStatement(varDec);
		varDecStm.setType(fType);
		return varDecStm;
	}

	public VariableDeclarationExpression newVariableDeclarationExpression(String type, String name) {
	    return newVariableDeclarationExpression(type, name, null);
	}
	public VariableDeclarationExpression newVariableDeclarationExpression(String type, String name, Expression initializer) {
		return newVariableDeclarationExpression(newType(type), newVariableDeclarationFragment(name, initializer));
	}
	public VariableDeclarationExpression newVariableDeclarationExpression(Type fType, VariableDeclarationFragment varDec) {
		VariableDeclarationExpression varDecExp = ast.newVariableDeclarationExpression(varDec);
		varDecExp.setType(fType);
		return varDecExp;
	}

	public void addConstructorCase(MethodDeclaration constructor, String fType, String fName) {
		constructor.parameters().add(newSingleVariableDeclaration(fType, fName));

		constructor.getBody().statements().add(ast.newExpressionStatement(
				newMethodInvocation(StringUtils.setterName(fName), ast.newSimpleName(fName))
		));
/*		
		FieldAccess fieldAcc = ast.newFieldAccess();
		fieldAcc.setExpression(ast.newThisExpression());
		fieldAcc.setName(ast.newSimpleName(fName));
		Assignment eq = ast.newAssignment();
		eq.setLeftHandSide(fieldAcc);
		eq.setRightHandSide(ast.newSimpleName(fName));
		constructor.getBody().statements().add(ast.newExpressionStatement(eq));*/
	}
	public void addConstructorCase(MethodDeclaration constructor, String setterName, String fType, String fName) {
		constructor.parameters().add(newSingleVariableDeclaration(fType, fName));

		MethodInvocation callExp = newMethodInvocation(setterName);
		callExp.arguments().add(ast.newSimpleName(fName));
		constructor.getBody().statements().add(ast.newExpressionStatement(callExp));
	}

	public FieldDeclaration newFieldDeclaration(String fType, String fName) {
		return newFieldDeclaration(fType, fName, false);
	}
	public FieldDeclaration newFieldDeclaration(String fType, String fName, boolean useQualifiedType) {
		return newFieldDeclaration(fType, fName, null, useQualifiedType);
	}
	public FieldDeclaration newFieldDeclaration(String fType, String fName, Expression initializer) {
		return newFieldDeclaration(fType, fName, initializer, false);
	}
	public FieldDeclaration newFieldDeclaration(String fType, String fName, Expression initializer, boolean useQualifiedType) {
		return newFieldDeclaration(useQualifiedType ? newQualifiedType(fType) : newType(fType), newVariableDeclarationFragment(fName, initializer));
	}
	public FieldDeclaration newFieldDeclaration(Type fType, VariableDeclarationFragment varDec) {
		FieldDeclaration fieldDec = ast.newFieldDeclaration(varDec);
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		fieldDec.setType(fType);
		return fieldDec;
	}
	public FieldDeclaration newFieldDeclaration(String fType, VariableDeclarationFragment fragment) {
		return newFieldDeclaration(newType(fType), fragment);
	}
	public VariableDeclarationFragment newVariableDeclarationFragment(String fName, Expression initializer) {
	    try {
	    	return newVariableDeclarationFragment(ast.newSimpleName(fName), initializer);
	    } catch(IllegalArgumentException e) {
	    	throw new IllegalStateException("illegal name: "+fName, e);
	    }
	}
	public VariableDeclarationFragment newVariableDeclarationFragment(SimpleName fName, Expression initializer) {
		VariableDeclarationFragment varDec = ast.newVariableDeclarationFragment();
		varDec.setName(fName);
		if (initializer != null)
			varDec.setInitializer(initializer);
	    return varDec;
	}
	
	public ParameterizedType newParameterizedType(String type) {
	    return ast.newParameterizedType(newType(type));
	}
	public ParameterizedType newParameterizedType(String type, String type1) {
		ParameterizedType ptype = newParameterizedType(type);
		ptype.typeArguments().add(newType(type1));
		return ptype;
	}
	public ParameterizedType newParameterizedType(String type, Type type1) {
		ParameterizedType ptype = newParameterizedType(type);
		ptype.typeArguments().add(type1);
		return ptype;
	}
	public ParameterizedType newParameterizedType(String type, String type1, String type2) {
		ParameterizedType ptype = newParameterizedType(type);
		ptype.typeArguments().add(newType(type1));
		ptype.typeArguments().add(newType(type2));
		return ptype;
	}
	public ParameterizedType newParameterizedType(String type, Type type1, Type type2) {
		ParameterizedType ptype = newParameterizedType(type);
		ptype.typeArguments().add(type1);
		ptype.typeArguments().add(type2);
		return ptype;
	}
	public Type newType(String fType) {
		if (StringUtils.isPrimitive(fType))
			return ast.newPrimitiveType(PrimitiveType.toCode(fType));
		return ast.newSimpleType(newSimpleName(fType));
	}
	public ArrayType newArrayType(String type) {
	    return ast.newArrayType(newType(type));
	}
	public ArrayType newArrayType(String type, int dimensions) {
	    return ast.newArrayType(newType(type), dimensions);
	}
	
	public FieldAccess newFieldAccess(String exp, String fName) {
	    return newFieldAccess(newSimpleName(exp), fName);
	}
	public FieldAccess newFieldAccess(Expression exp, String fName) {
		FieldAccess fieldExp = ast.newFieldAccess();
		fieldExp.setExpression(exp);
		fieldExp.setName(ast.newSimpleName(fName));
		return fieldExp;
	}
	public SuperFieldAccess newSuperFieldAccess(String fName) {
	    SuperFieldAccess fieldExp = ast.newSuperFieldAccess();
		fieldExp.setName(ast.newSimpleName(fName));
		return fieldExp;
	}

	public MethodDeclaration newGetterMethod(String fType, String fName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(newType(fType));
		method.setName(ast.newSimpleName(StringUtils.getterName(fType, fName)));

		if (!isInterface) {
			Block body = newBlock();
			ReturnStatement returnStm = ast.newReturnStatement();
			returnStm.setExpression(ast.newSimpleName(fName));
			body.statements().add(returnStm);			
			method.setBody(body);
		}

		return method;
	}
	public MethodDeclaration newGetterMethodWithNotification(String featuresEnum, String fType, String fName, String name) {
		return newGetterMethodWithNotification(featuresEnum, fType, fName, name, false);
	}

	public MethodDeclaration newGetterMethodWithNotification(String featuresEnum, String fType, String fName, String name, boolean useQualifiedType) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(useQualifiedType ? newQualifiedType(fType) : newType(fType));
		method.setName(ast.newSimpleName(StringUtils.getterName(fType, StringUtils.isJavaKeyword(name) ? name : fName)));

		if (!isInterface) {
			Block body = newBlock();
			MethodInvocation callExp = newMethodInvocation("notifyRequested", ast.newSimpleName(fName));
			if (featuresEnum != null)
				callExp.arguments().add(0, newFieldAccess(featuresEnum, fName));
			body.statements().add(newReturnStatement(callExp));			
			method.setBody(body);
		}

		return method;
	}
	public MethodDeclaration newGetterMethodWithGenericForward(String featuresEnum, String fType, String fName, String name) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(newType(fType));
		method.setName(ast.newSimpleName(StringUtils.getterName(fType, StringUtils.isJavaKeyword(name) ? name : fName)));

		if (!isInterface) {
			Block body = newBlock();
			MethodInvocation callExp = newMethodInvocation("wGet");
			callExp.arguments().add(newFieldAccess(featuresEnum, fName));
			body.statements().add(newReturnStatement
					(newMethodInvocation(callExp, "wGetAdapter",
					newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), fType))));			
			method.setBody(body);
		}

		return method;
	}
	public MethodDeclaration newDataGetterMethodWithGenericForward(String fType, String fName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(newType(fType));
		method.setName(ast.newSimpleName(StringUtils.getterName(fType, fName)));

		if (!isInterface) {
			Block body = newBlock();
			String getValueMethod = specificGetValueName(fType);
			if (getValueMethod.equals("wEnumValue") || getValueMethod.equals("wGetValue"))
				body.statements().add(newReturnStatement(
						newCastExpression(newType(fType),
								newMethodInvocation(getValueMethod))));			
			else
				body.statements().add(newReturnStatement(
						newMethodInvocation(getValueMethod)));			
			method.setBody(body);
		}

		return method;
	}
	private String specificGetValueName(String fType) {
		String methodName;
		if (StringUtils.isPrimitive(fType))
			methodName = "w"+StringUtils.toUpperCap(fType)+"Value";
		else if (StringUtils.isString(fType))
			methodName = "wStringValue";
		else if (fType.endsWith("Enum.Value") || fType.equals(EntityDescriptor.class.getName()))
			methodName = "wEnumValue";
		else if (fType.equals("Date") || fType.equals("java.util.Date"))
			methodName = "wDateValue";
		else
			methodName = "wGetValue";
		return methodName;
	}
	public MethodDeclaration newSetterMethodWithGenericForward(String featuresEnum, String fType, String fName, String name) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName(StringUtils.setterName(StringUtils.isJavaKeyword(name) ? name : fName)));
		method.parameters().add(newSingleVariableDeclaration(fType, fName));

		if (!isInterface) {
			Block body = newBlock();

			MethodInvocation callExp = newMethodInvocation("wSet");
			callExp.arguments().add(newFieldAccess(featuresEnum, fName));
			callExp.arguments().add(ast.newSimpleName(fName));

			body.statements().add(ast.newExpressionStatement(callExp));
			method.setBody(body);
		}

		return method;
	}
	public MethodDeclaration newDataSetterMethodWithGenericForward(String fType, String fName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName(StringUtils.setterName(fName)));
		method.parameters().add(newSingleVariableDeclaration(fType, fName));

		if (!isInterface) {
			Block body = newBlock();

			MethodInvocation callExp = newMethodInvocation("wSetValue");
			if (StringUtils.isPrimitiveOrString(fType) || fType.equals("java.util.Date") || fType.endsWith("Enum.Value"))
				callExp.arguments().add(ast.newSimpleName(fName));
			else
				callExp.arguments().add(newCastExpression("java.lang.Object", ast.newSimpleName(fName)));				

			body.statements().add(ast.newExpressionStatement(callExp));
			method.setBody(body);
		}

		return method;
	}
	
	public MethodDeclaration newSetterMethod(String fType, String fName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName(StringUtils.setterName(fName)));
		method.parameters().add(newSingleVariableDeclaration(fType, fName));

		if (!isInterface) {
			Block body = newBlock();

			Assignment eq = ast.newAssignment();
			FieldAccess fieldAcc = ast.newFieldAccess();
			fieldAcc.setExpression(ast.newThisExpression());
			fieldAcc.setName(ast.newSimpleName(fName));
			eq.setLeftHandSide(fieldAcc);
			eq.setRightHandSide(ast.newSimpleName(fName));
			body.statements().add(ast.newExpressionStatement(eq));
			method.setBody(body);
		}

		return method;
	}
	public MethodDeclaration newSetterMethod(String setterName, String pType, String fType, String fName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName(setterName));
		method.parameters().add(newSingleVariableDeclaration(pType, fName));

		if (!isInterface) {
			Block body = newBlock();

			Assignment eq = ast.newAssignment();
			FieldAccess fieldAcc = ast.newFieldAccess();
			fieldAcc.setExpression(ast.newThisExpression());
			fieldAcc.setName(ast.newSimpleName(fName));
			eq.setLeftHandSide(fieldAcc);
			if (pType.equals(fType))
				eq.setRightHandSide(ast.newSimpleName(fName));
			else
				eq.setRightHandSide(newCastExpression(fType, ast.newSimpleName(fName)));
			body.statements().add(ast.newExpressionStatement(eq));
			method.setBody(body);
		}

		return method;
	}

	public void addParameter(SingleVariableDeclaration param) {
	    methodDec.parameters().add(param);
	}

	public SingleVariableDeclaration newSingleVariableDeclaration(String pType, String pName) {
		return newSingleVariableDeclaration(pType, pName, false);
	}
	public SingleVariableDeclaration newSingleVariableDeclaration(String pType, String pName, boolean useQualifiedType) {
		return newSingleVariableDeclaration(useQualifiedType ? newQualifiedType(pType) : newType(pType), pName);
	}
	public SingleVariableDeclaration newSingleVariableDeclaration(Type pType, String pName) {
		return newSingleVariableDeclaration(pType, ast.newSimpleName(pName));
	}
	public SingleVariableDeclaration newSingleVariableDeclaration(Type pType, SimpleName pName) {
		SingleVariableDeclaration param = ast.newSingleVariableDeclaration();
		param.setType(pType);
		param.setName(pName);
		return param;
	}

	public MethodDeclaration newSetterMethodWithNotification(String featuresEnum, String fType, String fName, String name, boolean isReference) {
		return newSetterMethodWithNotification(featuresEnum, fType, fName, name, isReference, false);
	}
	public MethodDeclaration newSetterMethodWithNotification(String featuresEnum, String fType, String fName, String name, boolean isReference, boolean useQualifiedType) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(ast.newPrimitiveType(PrimitiveType.VOID));
		method.setName(ast.newSimpleName(StringUtils.setterName(StringUtils.isJavaKeyword(name) ? name : fName)));
		method.parameters().add(newSingleVariableDeclaration(useQualifiedType ? newQualifiedType(fType) : newType(fType), fName));

		if (!isInterface) {
			Block body = newBlock();
			MethodInvocation callExp = ast.newMethodInvocation();
			callExp.setName(ast.newSimpleName("notifyChanged"));
			if (featuresEnum != null)
				callExp.arguments().add(newFieldAccess(featuresEnum, fName));
			FieldAccess fieldAcc = ast.newFieldAccess();
			fieldAcc.setExpression(ast.newThisExpression());
			fieldAcc.setName(ast.newSimpleName(fName));
			callExp.arguments().add(fieldAcc);
			fieldAcc = ast.newFieldAccess();
			fieldAcc.setExpression(ast.newThisExpression());
			fieldAcc.setName(ast.newSimpleName(fName));
			Assignment eq = ast.newAssignment();
			eq.setLeftHandSide(fieldAcc);
			eq.setRightHandSide(ast.newSimpleName(fName));
			callExp.arguments().add(eq);
			if (isReference)
				callExp.arguments().add(newLiteral(false));
			body.statements().add(ast.newExpressionStatement(callExp));
			method.setBody(body);
		}

		return method;
	}

	public ParenthesizedExpression newParenthesizedExpression(Expression exp) {
		ParenthesizedExpression parExp = ast.newParenthesizedExpression();
		parExp.setExpression(exp);
		return parExp;
	}

	public MethodDeclaration addConstructorDeclaration() {
	    MethodDeclaration constructor = newConstructorDeclaration(typeDec);
	    addBodyDeclaration(constructor);
	    return constructor;
	}
	public MethodDeclaration newConstructorDeclaration(TypeDeclaration type) {
	    return newConstructorDeclaration(type.getName().getIdentifier());
	}
	public MethodDeclaration newConstructorDeclaration(String typeName) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(true);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setName(ast.newSimpleName(StringUtils.toSimpleName(typeName)));
		method.setBody(newBlock());
		return method;
	}

	public MethodDeclaration newMethodDeclaration(Type returnType, SimpleName name) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setConstructor(false);
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.setReturnType2(returnType);
		method.setName(name);
		if (!isInterface)
			method.setBody(newBlock());
		return method;
	}
	public MethodDeclaration newMethodDeclaration(Type returnType, String name) {
		return newMethodDeclaration(returnType, ast.newSimpleName(name));
	}
	public MethodDeclaration newMethodDeclaration(String returnType, String name) {
		return newMethodDeclaration(newType(returnType), name);
	}
	public MethodDeclaration newMethodDeclaration(String returnType, String name, SingleVariableDeclaration par0) {
		MethodDeclaration method =  newMethodDeclaration(newType(returnType), name);
		method.parameters().add(par0);
		return method;
	}
	public MethodDeclaration newMethodDeclaration(String returnType, String name, SingleVariableDeclaration par0, SingleVariableDeclaration par1) {
		MethodDeclaration method =  newMethodDeclaration(newType(returnType), name);
		method.parameters().add(par0);
		method.parameters().add(par1);
		return method;
	}
	public MethodDeclaration newMethodDeclaration(String returnType, String name, SingleVariableDeclaration par0, SingleVariableDeclaration par1, SingleVariableDeclaration par2) {
		MethodDeclaration method =  newMethodDeclaration(newType(returnType), name);
		method.parameters().add(par0);
		method.parameters().add(par1);
		method.parameters().add(par2);
		return method;
	}
	
	public MethodDeclaration findMethodDeclaration(String methodName, List bodyDeclarations) {
	    Iterator i = bodyDeclarations.iterator();
		while (i.hasNext()) {
			Object declaration = i.next();
			if (declaration instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration)declaration;
				if (method.getName().getIdentifier().equals(methodName))
					return method;
			}
		}
		throw new MethodNotFoundException("method declaration not found: "+methodName);
	}
	public MethodDeclaration findMethodDeclaration(String methodName, String[] paramTypes, List bodyDeclarations) {
	    Iterator i = bodyDeclarations.iterator();
		while (i.hasNext()) {
			Object declaration = i.next();
			if (declaration instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration)declaration;
				if (method.getName().getIdentifier().equals(methodName)) {
				    List params = method.parameters();
				    if (params.size() == paramTypes.length) {
				        int j;
				        for (j=0; j<paramTypes.length; j++) {
				            Type paramType = ((SingleVariableDeclaration) params.get(j)).getType();
				            if (!paramType.toString().equals(paramTypes[j]))
				                break;
				        }
				        if (j == paramTypes.length)
				            return method;
				    }
				}
			}
		}
		throw new MethodNotFoundException("method declaration not found: "+methodName);
	}

	public TypeDeclaration addSingletonHolder(String holderName, String fieldTypeName) {
		return addSingletonHolder(holderName, fieldTypeName, Collections.<BodyDeclaration>emptyList());
	}
	public TypeDeclaration addSingletonHolder(String holderName, String fieldTypeName, List<BodyDeclaration> declarations) {
		TypeDeclaration classDeclaration = ast.newTypeDeclaration();
		classDeclaration.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		classDeclaration.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		classDeclaration.setName(ast.newSimpleName(holderName));

		VariableDeclarationFragment varDec = newVariableDeclarationFragment("instance", newClassInstanceCreation(fieldTypeName));
		FieldDeclaration instanceField = ast.newFieldDeclaration(varDec);
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		instanceField.setType(ast.newSimpleType(ast.newSimpleName(fieldTypeName)));
		classDeclaration.bodyDeclarations().add(instanceField);
		classDeclaration.bodyDeclarations().addAll(declarations);
		addBodyDeclaration(classDeclaration);
		return classDeclaration;
	}

	public MethodDeclaration addSingletonHolderMethod() {
		String typeName = typeDec.getName().getIdentifier();

		String holderName = "SingletonHolder";
		addSingletonHolder(holderName, typeName);

		MethodDeclaration instanceMethod = newMethodDeclaration(typeName, "instance");
		instanceMethod.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		addBodyDeclaration(instanceMethod);
		Block body = newBlock();
		
		FieldAccess instanceFieldAccess = ast.newFieldAccess();
		instanceFieldAccess.setExpression(ast.newSimpleName(holderName));
		instanceFieldAccess.setName(ast.newSimpleName("instance"));
		body.statements().add(newReturnStatement(instanceFieldAccess));
		instanceMethod.setBody(body);

		MethodDeclaration constructor = newConstructorDeclaration(typeDec);
        constructor.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		constructor.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		addBodyDeclaration(constructor);
		return constructor;
	}

	public MethodDeclaration addSingletonMethod() {
		String typeName = typeDec.getName().getIdentifier();

		FieldDeclaration instanceField = newFieldDeclaration(typeName, "instance");
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		addBodyDeclaration(0, instanceField);

		MethodDeclaration instanceMethod = newMethodDeclaration(typeName, "instance");
		instanceMethod.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		addBodyDeclaration(1, instanceMethod);
		Block body = newBlock();
		
		IfStatement ifStm = ast.newIfStatement();
		InfixExpression infixExp = ast.newInfixExpression();
		infixExp.setLeftOperand(ast.newSimpleName("instance"));
		infixExp.setOperator(InfixExpression.Operator.EQUALS);
		infixExp.setRightOperand(ast.newNullLiteral());
		ifStm.setExpression(infixExp);
		ifStm.setThenStatement(ast.newExpressionStatement(newAssignment("instance", newClassInstanceCreation(typeName))));
		body.statements().add(ifStm);
		body.statements().add(newReturnStatement(ast.newSimpleName("instance")));
		instanceMethod.setBody(body);

		MethodDeclaration constructor = newConstructorDeclaration(typeDec);
        constructor.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		constructor.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		addBodyDeclaration(2, constructor);
		return constructor;
	}

	public MethodDeclaration addSingletonField() {
		String implName = typeDec.getName().getIdentifier();
		return addSingletonField(implName, implName);
	}
	public MethodDeclaration addSingletonField(String typeName) {
		if (isInterface)
			return addSingletonField(typeDec.getName().getIdentifier(), typeName);
		else
			return addSingletonField(typeName, typeDec.getName().getIdentifier());
	}
	public MethodDeclaration addSingletonField(String typeName, String implName) {
		FieldDeclaration instanceField = newFieldDeclaration(typeName, "instance", newClassInstanceCreation(implName));
		instanceField.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		addBodyDeclaration(0, instanceField);

		MethodDeclaration constructor = null;
		if (!isInterface) {
			constructor = newConstructorDeclaration(typeDec);
            constructor.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
			constructor.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
			addBodyDeclaration(1, constructor);
		}
		return constructor;
	}
	
	private String visitReturnType = "void";
	public void setVisitMethodReturnType(String type) {
	    visitReturnType = type;
	}
	public MethodDeclaration addVisitMethod(String type) {
		return addVisitMethod("visit", generator.entityInterfaceQName(type));
	}
	public MethodDeclaration addVisitMethod(String name, String type) {
		return addVisitMethod(visitReturnType, "visit", type);
	}
	public MethodDeclaration addVisitMethod(String returnType, String name, String type) {
		MethodDeclaration method = newMethodDeclaration(returnType, name);
		method.parameters().add(newSingleVariableDeclaration(type, "entity"));	
		
		if (!isInterface)
			method.setBody(newBlock());
		
		addBodyDeclaration(method);
		return method;
	}

	public MethodDeclaration addBuildMethod(String entityType) {
		return addBuildMethod(entityType, newParameterizedType(IEntityBuilder.class.getName(), entityType));
	}
	public MethodDeclaration addBuildMethod(String entityType, Type buildType) {
		return addBuildMethod("build", entityType, buildType, entityType);
	}
	public MethodDeclaration addBuildMethod(String prefix, String entityType, Type builderType, String builderName) {
		String prefixFactoryName = prefix.length() == 0 ? StringUtils.toLowerCap(StringUtils.toSimpleName(builderName)) : prefix+StringUtils.toSimpleName(builderName);
	    methodDec = newMethodDeclaration(builderType, prefixFactoryName);

		if (!isInterface) {
			Block body = newBlock();
			body.statements().add(newReturnStatement(newClassInstanceCreation(
					newParameterizedType(EntityBuilder.class.getName(), entityType),
					newMethodInvocation("create",
							newFieldAccess(generator.specificEntityDescriptorEnumName(), entityType)))));
			methodDec.setBody(body);			
		}
		
		addBodyDeclaration(methodDec);
		return methodDec;
	}
	
	public MethodDeclaration addFactoryForwardMethod(String entityType, String targetMethodName) {
		assert isInterface;

		return addFactoryMethod(entityType);
	}
	public MethodDeclaration addFactoryMethod(String entityType) {
		return addFactoryMethod("create", entityType, entityType, entityType);
	}
	public MethodDeclaration addFactoryMethod(String entityType, String entityImplType) {
		return addFactoryMethod("create", entityType, entityType, entityImplType);
	}
	public MethodDeclaration addFactoryMethod(String factoryType, String entityType, String entityImplType) {
		return addFactoryMethod("create", factoryType, entityType, entityImplType);
	}
	public MethodDeclaration addFactoryMethod(String prefix, String factoryType, String factoryName, String typeName) {
		String prefixFactoryName = prefix.length() == 0 ? StringUtils.toLowerCap(StringUtils.toSimpleName(factoryName)) : prefix+StringUtils.toSimpleName(factoryName);
	    methodDec = newMethodDeclaration(factoryType, prefixFactoryName);

		if (!isInterface) {
			Block body = newBlock();
			body.statements().add(newReturnStatement(newClassInstanceCreation(typeName)));
			methodDec.setBody(body);			
		}
		
		addBodyDeclaration(methodDec);
		return methodDec;
	}
	public void addFactoryMethodCase(MethodDeclaration factoryMethod, String fType, String fName, boolean useQualifiedType) {
		if (fType.endsWith("Enum.Value"))
			addFactoryMethodCase(factoryMethod, newSimpleQualifiedType(fType), fName);
		else
			addFactoryMethodCase(factoryMethod, useQualifiedType ? newQualifiedType(fType) : newType(fType), fName);
	}
	public void addFactoryMethodCase(MethodDeclaration factoryMethod, Type fType, String fName) {
		factoryMethod.parameters().add(newSingleVariableDeclaration(fType, fName));
		if (!isInterface)
			((ClassInstanceCreation)((ReturnStatement)factoryMethod.getBody().statements().get(0)).getExpression()).arguments().add(ast.newSimpleName(fName));
	}
	public void addFactoryMethodArrayCase(MethodDeclaration method, String componentType, String fName) {
		addFactoryMethodCase(method, newArrayType(componentType), fName);
	}
	public void addFactoryMethodVarArgsCase(MethodDeclaration method, String componentType, String fName) {
		SingleVariableDeclaration varDecl = newSingleVariableDeclaration(componentType, fName);
		varDecl.setVarargs(true);

		method.parameters().add(varDecl);
		if (!isInterface)
			((ClassInstanceCreation)((ReturnStatement)method.getBody().statements().get(0)).getExpression()).arguments().add(ast.newSimpleName(fName));
	}

	public MethodInvocation newMethodInvocation(SimpleName method) {
		MethodInvocation callExp = ast.newMethodInvocation();
		callExp.setName(method);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String method) {
		return newMethodInvocation(ast.newSimpleName(method));
	}
	public MethodInvocation newMethodInvocation(String method, Expression arg0) {
		MethodInvocation callExp = newMethodInvocation(method);
		callExp.arguments().add(arg0);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String method, Expression arg0, Expression arg1) {
		MethodInvocation callExp = newMethodInvocation(method, arg0);
		callExp.arguments().add(arg1);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String method, Expression arg0, Expression arg1, Expression arg2) {
		MethodInvocation callExp = newMethodInvocation(method, arg0, arg1);
		callExp.arguments().add(arg2);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String obj, String method) {
		return newMethodInvocation(newSimpleName(obj), method);
	}
	public MethodInvocation newMethodInvocation(Expression exp, String method) {
		MethodInvocation callExp = ast.newMethodInvocation();
		callExp.setExpression(exp);
		callExp.setName(ast.newSimpleName(method));
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String obj, String method, Expression arg0) {
		return newMethodInvocation(newSimpleName(obj), method, arg0);
	}
	public MethodInvocation newMethodInvocation(Expression exp, String method, Expression arg0) {
		MethodInvocation callExp = newMethodInvocation(exp, method);
		callExp.arguments().add(arg0);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String obj, String method, Expression arg0, Expression arg1) {
		return newMethodInvocation(newSimpleName(obj), method, arg0, arg1);
	}
	public MethodInvocation newMethodInvocation(Expression exp, String method, Expression arg0, Expression arg1) {
		MethodInvocation callExp = newMethodInvocation(exp, method, arg0);
		callExp.arguments().add(arg1);
		return callExp;
	}
	public MethodInvocation newMethodInvocation(String obj, String method, Expression arg0, Expression arg1, Expression arg2) {
		return newMethodInvocation(newSimpleName(obj), method, arg0, arg1, arg2);
	}
	public MethodInvocation newMethodInvocation(Expression exp, String method, Expression arg0, Expression arg1, Expression arg2) {
		MethodInvocation callExp = newMethodInvocation(exp, method, arg0, arg1);
		callExp.arguments().add(arg2);
		return callExp;
	}
	public SuperMethodInvocation newSuperMethodInvocation(String method) {
	    SuperMethodInvocation callExp = ast.newSuperMethodInvocation();
		callExp.setName(ast.newSimpleName(method));
		return callExp;
	}
	public SuperMethodInvocation newSuperMethodInvocation(String method, Expression arg0) {
	    SuperMethodInvocation callExp = newSuperMethodInvocation(method);
		callExp.arguments().add(arg0);
		return callExp;
	}

	public ConstructorInvocation newConstructorInvocation() {
	    return ast.newConstructorInvocation();
	}
	public ConstructorInvocation newConstructorInvocation(Expression arg0) {
		ConstructorInvocation callExp = newConstructorInvocation();
		callExp.arguments().add(arg0);	
		return callExp;
	}
	public ConstructorInvocation newConstructorInvocation(Expression arg0, Expression arg1) {
		ConstructorInvocation callExp = newConstructorInvocation(arg0);
		callExp.arguments().add(arg1);
		return callExp;
	}
	public SuperConstructorInvocation newSuperConstructorInvocation() {
	    return ast.newSuperConstructorInvocation();
	}
	public SuperConstructorInvocation newSuperConstructorInvocation(Expression arg0) {
		SuperConstructorInvocation callExp = newSuperConstructorInvocation();
		callExp.arguments().add(arg0);
		return callExp;
	}
	public SuperConstructorInvocation newSuperConstructorInvocation(Expression arg0, Expression arg1) {
		SuperConstructorInvocation callExp = newSuperConstructorInvocation(arg0);
		callExp.arguments().add(arg1);
		return callExp;
	}

	public Expression newValueOfMethodInvocation(Expression stringExp, String primitiveType) {
		MethodInvocation callExp;
		
		if (primitiveType.equals("boolean")) {
			callExp = newMethodInvocation("java.lang.Boolean", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "booleanValue");
		} else if (primitiveType.equals("byte")) {
			callExp = newMethodInvocation("java.lang.Byte", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "byteValue");
		} else if (primitiveType.equals("char")) {
			callExp = newMethodInvocation(newParenthesizedExpression(stringExp), "charAt");
			callExp.arguments().add(newLiteral(0));
			return callExp;
		} else if (primitiveType.equals("double")) {
			callExp = newMethodInvocation("java.lang.Double", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "doubleValue");
		} else if (primitiveType.equals("float")) {
			callExp = newMethodInvocation("java.lang.Float", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "floatValue");
		} else if (primitiveType.equals("int")) {
			callExp = newMethodInvocation("java.lang.Integer", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "intValue");
		} else if (primitiveType.equals("long")) {
			callExp = newMethodInvocation("java.lang.Long", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "longValue");
		} else if (primitiveType.equals("short")) {
			callExp = newMethodInvocation("java.lang.Short", "valueOf");
			callExp.arguments().add(stringExp);
			return newMethodInvocation(callExp, "shortValue");
		} else if (primitiveType.endsWith("java.lang.Date")) {
			return newMethodInvocation(
					StringUtils.class.getName(),
					"parseDate", stringExp);
		} else if (primitiveType.endsWith("Enum.Value")) {
			return newMethodInvocation(
					newFieldAccess(primitiveType.substring(0,primitiveType.lastIndexOf('.')), "instance"),
					"valueOf", stringExp);
		} else if (primitiveType.equals(EntityDescriptor.class.getName())) {
			return newMethodInvocation(
					newFieldAccess(generator.specificEntityDescriptorEnumName(), "instance"),
					"valueOf", stringExp);
		} else if (StringUtils.isString(primitiveType))
			return stringExp;
		throw new IllegalArgumentException(primitiveType);
	}
	public Expression newToStringMethodInvocation(Expression exp) {
		MethodInvocation callExp = newMethodInvocation(StringUtils.class.getName(), "toString");
		callExp.arguments().add(exp);
		return callExp;
	}

	public Block newBlock() {
	    return block = ast.newBlock();
	}
	public void addStatement(Expression exp) {
	    block.statements().add(newExpressionStatement(exp));
	}
	public void addStatement(Statement stm) {
	    block.statements().add(stm);
	}
	public void addStatement(MethodDeclaration method, Expression exp) {
	    addStatement(method, newExpressionStatement(exp));
	}
	public void addStatement(MethodDeclaration method, Statement stm) {
	    method.getBody().statements().add(stm);
	}
	
	public Initializer newInitializer(Block body) {
	    Initializer initializer = ast.newInitializer();
	    initializer.setBody(body);
	    return initializer;
	}

	public EmptyStatement newEmptyStatement() {
	    return ast.newEmptyStatement();
	}
	
	public ExpressionStatement newExpressionStatement(Expression exp) {
	    return ast.newExpressionStatement(exp);
	}

	public IfStatement newIfStatement(Expression exp) {
	    IfStatement stm = ast.newIfStatement();
	    stm.setExpression(exp);
	    return stm;
	}
	public IfStatement newIfStatement(Expression exp, Statement thenStm) {
	    IfStatement stm = newIfStatement(exp);
	    stm.setThenStatement(thenStm);
	    return stm;
	}
	public IfStatement newIfStatement(Expression exp, Statement thenStm, Statement elseStm) {
	    IfStatement stm = newIfStatement(exp, thenStm);
	    stm.setElseStatement(elseStm);
	    return stm;
	}

	public SwitchStatement newSwitchStatement(Expression exp) {
		SwitchStatement stm = ast.newSwitchStatement();
	    stm.setExpression(exp);
	    return stm;
	}
	public SwitchCase newCaseStatement(Expression exp) {
		SwitchCase stm = ast.newSwitchCase();
	    stm.setExpression(exp);
	    return stm;
	}
	public SwitchCase newDefaultCaseStatement() {
		SwitchCase stm = ast.newSwitchCase();
	    stm.setExpression(null);
	    return stm;
	}

	public WhileStatement newWhileStatement(Expression exp) {
	    WhileStatement stm = ast.newWhileStatement();
	    stm.setExpression(exp);
	    return stm;
	}
	public WhileStatement newWhileStatement(Expression exp, Statement body) {
	    WhileStatement stm = newWhileStatement(exp);
	    stm.setBody(body);
	    return stm;
	}

	public DoStatement newDoStatement(Expression exp) {
	    DoStatement stm = ast.newDoStatement();
	    stm.setExpression(exp);
	    return stm;
	}
	public DoStatement newDoStatement(Expression exp, Statement body) {
	    DoStatement stm = newDoStatement(exp);
	    stm.setBody(body);
	    return stm;
	}

	public ForStatement newForStatement(Expression exp, Statement body) {
	    ForStatement stm = ast.newForStatement();
	    stm.setExpression(exp);
	    stm.setBody(body);
	    return stm;
	}
	public ForStatement newForStatement(Expression initializer, Expression exp, Expression updater, Statement body) {
	    ForStatement stm = ast.newForStatement();
	    stm.initializers().add(initializer);
	    stm.setExpression(exp);
	    stm.updaters().add(updater);
	    stm.setBody(body);
	    return stm;
	}
	public EnhancedForStatement newEnhancedForStatement(SingleVariableDeclaration parameter, Expression exp, Statement body) {
		EnhancedForStatement stm = ast.newEnhancedForStatement();
		stm.setParameter(parameter);
	    stm.setExpression(exp);
	    stm.setBody(body);
	    return stm;
	}

	public BooleanLiteral newLiteral(boolean value) {
		return ast.newBooleanLiteral(value);
	}
	public NumberLiteral newLiteral(byte value) {
		return ast.newNumberLiteral(Byte.toString(value));
	}
	public CharacterLiteral newLiteral(char value) {
		CharacterLiteral str = ast.newCharacterLiteral();
		str.setCharValue(value);
		return str;
	}
	public NumberLiteral newLiteral(double value) {
		return ast.newNumberLiteral(String.valueOf(value));
	}
	public NumberLiteral newLiteral(float value) {
		return ast.newNumberLiteral(String.valueOf(value));
	}
	public NumberLiteral newLiteral(int value) {
		return ast.newNumberLiteral(String.valueOf(value));
	}
	public NumberLiteral newLiteral(long value) {
		return ast.newNumberLiteral(String.valueOf(value));
	}
	public NumberLiteral newLiteral(short value) {
		return ast.newNumberLiteral(Short.toString(value));
	}
	public StringLiteral newLiteral(String text) {
		StringLiteral str = ast.newStringLiteral();
		str.setLiteralValue(text);
		return str;
	}
	public NumberLiteral newLiteral(Date value) {
		return newLiteral(value.getTime());
	}
	public StringLiteral newLiteral(EnumValue value) {
		return newLiteral(value.getName());
	}
	public Expression newLiteral(Object value) {
		if (value instanceof String)
			return newLiteral((String) value);
		else if (value instanceof EnumValue)
			return newLiteral((EnumValue) value);
		else if (value instanceof Date)
			return newLiteral((Date) value);
		else if (value instanceof Boolean)
		    return ast.newBooleanLiteral(((Boolean) value).booleanValue());
		else
			return ast.newNumberLiteral(value.toString());
	}
	public NumberLiteral newNumberLiteral(String value) {
	    return ast.newNumberLiteral(value);
	}
	public NullLiteral newNullLiteral() {
	    return ast.newNullLiteral();
	}
	public TypeLiteral newTypeLiteral(String type) {
		TypeLiteral typeLiteral = ast.newTypeLiteral();
		typeLiteral.setType(newType(type));
		return typeLiteral;
	}
	public TypeLiteral newQualifiedTypeLiteral(String type) {
		TypeLiteral typeLiteral = ast.newTypeLiteral();
		typeLiteral.setType(newQualifiedType(type));
		return typeLiteral;
	}
	
	public Expression newWrapperInstanceCreation(String literalType, String name) {
		return newWrapperInstanceCreation(literalType, newSimpleName(name));
	}
	public Expression newWrapperInstanceCreation(String literalType, Expression literalExp) {
		ClassInstanceCreation exp;
		if (literalType.equals("boolean")) {
			exp = newClassInstanceCreation("java.lang.Boolean");
		} else if (literalType.equals("byte")) {
			exp = newClassInstanceCreation("java.lang.Byte");
		} else if (literalType.equals("char")) {
			exp = newClassInstanceCreation("java.lang.Character");
		} else if (literalType.equals("double")) {
			exp = newClassInstanceCreation("java.lang.Double");
		} else if (literalType.equals("float")) {
			exp = newClassInstanceCreation("java.lang.Float");
		} else if (literalType.equals("int")) {
			exp = newClassInstanceCreation("java.lang.Integer");
		} else if (literalType.equals("long")) {
			exp = newClassInstanceCreation("java.lang.Long");
		} else if (literalType.equals("short")) {
			exp = newClassInstanceCreation("java.lang.Short");
		} else
			return literalExp;
		exp.arguments().add(literalExp);
		return exp;
	}

	public Expression newUnwrapperExpression(String literalType, String name, boolean useQualifiedType) {
		return newUnwrapperExpression(literalType, newSimpleName(name), useQualifiedType);
	}
	public Expression newUnwrapperExpression(String literalType, Expression literalExp, boolean useQualifiedType) {
		String wrapperType;
		String unwrapMethod;
		Expression exp;
		if (literalType.equals("boolean")) {
			wrapperType = "java.lang.Boolean";
			unwrapMethod = "booleanValue";
		} else if (literalType.equals("byte")) {
			wrapperType = "java.lang.Byte";
			unwrapMethod = "byteValue";
		} else if (literalType.equals("char")) {
			wrapperType = "java.lang.Character";
			unwrapMethod = "charValue";
		} else if (literalType.equals("double")) {
			wrapperType = "java.lang.Double";
			unwrapMethod = "doubleValue";
		} else if (literalType.equals("float")) {
			wrapperType = "java.lang.Float";
			unwrapMethod = "floatValue";
		} else if (literalType.equals("int")) {
			wrapperType = "java.lang.Integer";
			unwrapMethod = "intValue";
		} else if (literalType.equals("long")) {
			wrapperType = "java.lang.Long";
			unwrapMethod = "longValue";
			exp = newClassInstanceCreation("java.lang.Long");
		} else if (literalType.equals("short")) {
			wrapperType = "java.lang.Short";
			unwrapMethod = "shortValue";
			exp = newClassInstanceCreation("java.lang.Short");
		} else if (!literalType.equals("java.lang.Object")) {
			return newCastExpression(useQualifiedType ? newQualifiedType(literalType) : newType(literalType), literalExp);
		} else
			return literalExp;

		exp = newMethodInvocation(newParenthesizedExpression(newCastExpression(wrapperType, literalExp)), unwrapMethod);
		return exp;
	}

	@Override
	public EntityDescriptor<?> wGetEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
}
