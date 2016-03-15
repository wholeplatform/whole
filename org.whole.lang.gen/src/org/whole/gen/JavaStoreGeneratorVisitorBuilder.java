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
package org.whole.gen;

import java.util.Iterator;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class JavaStoreGeneratorVisitorBuilder extends CompilationUnitBuilder {
	public JavaStoreGeneratorVisitorBuilder(JavaModelGenerator generator, String packageSuffix, String entityInterfaceName, CompilationUnit visitorCU, TypeDeclaration languageFactoryType) {
		super(generator, packageSuffix);

		MethodInvocation callExp;
		MethodInvocation callExp2;
		FieldDeclaration fieldDec;
		
		addImplementationType(generator.javaStoreVisitorName(), visitorCU);
		setSuperclass(generator.identityVisitorName());

		noImportPackage("org.eclipse.jdt.core.dom");

		Iterator i = typeDec.bodyDeclarations().iterator();
		while (i.hasNext()) {
			Object declaration = i.next();
			if (declaration instanceof MethodDeclaration) {
				MethodDeclaration visitMethod = (MethodDeclaration)declaration;
				SingleVariableDeclaration paramDec = (SingleVariableDeclaration)visitMethod.parameters().get(0);
				String visitType = paramDec.getType().toString();
				String visitName = paramDec.getName().getIdentifier();
				
				if (visitType.endsWith(StringUtils.toSimpleName(generator.adapterFragmentName()))) {
				    //super.visit(fragment);
					SuperMethodInvocation superCall = newSuperMethodInvocation("visit");
				    superCall.arguments().add(ast.newSimpleName("entity"));
				    
				    //builder.addSubtree(this, fragment, fragmentAdapterName);
				    callExp2 = newMethodInvocation("builder", "addSubtree");
				    callExp2.arguments().add(ast.newThisExpression());
				    callExp2.arguments().add(ast.newSimpleName("entity"));
				    callExp2.arguments().add(newLiteral(StringUtils.toSimpleName(generator.adapterFragmentName())));

				    IfStatement ifStm = newIfStatement(
				            ast.newSimpleName("isCompiling"),
				            newExpressionStatement(superCall),
				            newExpressionStatement(callExp2));
				    visitMethod.getBody().statements().add(ifStm);
				    continue;
				} else if (visitType.endsWith(StringUtils.toSimpleName(generator.baseFragmentName()))) {
				    //super.visit(fragment);
					SuperMethodInvocation superCall = newSuperMethodInvocation("visit");
				    superCall.arguments().add(ast.newSimpleName("entity"));
					    
				    //builder.addSubtree(this, fragment, baseFragmentName);
				    callExp2 = newMethodInvocation("builder", "addSubtree");
				    callExp2.arguments().add(ast.newThisExpression());
				    callExp2.arguments().add(ast.newSimpleName("entity"));
				    callExp2.arguments().add(newLiteral(StringUtils.toSimpleName(generator.baseFragmentName())));

				    IfStatement ifStm = newIfStatement(
				            ast.newSimpleName("isCompiling"),
				            newExpressionStatement(superCall),
				            newExpressionStatement(callExp2));
				    visitMethod.getBody().statements().add(ifStm);
				    continue;
				} else if (visitType.endsWith(StringUtils.toSimpleName(generator.metaFragmentName()))) {
				    //builder.addSubtree(this, fragment, metaFragmentName);
				    callExp = newMethodInvocation("builder", "addSubtree");
				    callExp.arguments().add(ast.newThisExpression());
				    callExp.arguments().add(ast.newSimpleName("entity"));
				    callExp.arguments().add(newLiteral(StringUtils.toSimpleName(generator.metaFragmentName())));
				    visitMethod.getBody().statements().add(newExpressionStatement(callExp));
				    continue;
				}

				
				String factoryName = "create"+visitType;
				MethodDeclaration factoryMethod;
                try {
                    factoryMethod = findMethodDeclaration(factoryName, languageFactoryType.bodyDeclarations());
                } catch (MethodNotFoundException e) {
                    continue;
                }

				String componentType = generator.getComponentType(visitType);
				boolean isComposite = componentType != null;

				//int parentNestingSize = builder.initNestingSize();
				visitMethod.getBody().statements().add(newVariableDeclarationStatement("int", "parentNestingSize", newMethodInvocation("builder", "initNestingSize")));								

				//MethodInvocation callExp = builder.newFactoryInvocation(this, factoryName);
				callExp = newMethodInvocation("builder", "newFactoryInvocation");
				callExp.arguments().add(ast.newThisExpression());
				callExp.arguments().add(newLiteral(factoryName));
				visitMethod.getBody().statements().add(newVariableDeclarationStatement("org.eclipse.jdt.core.dom.MethodInvocation", "callExp", callExp));								
				
				Iterator j = factoryMethod.parameters().iterator();
				while (j.hasNext()) {
					SingleVariableDeclaration paramDec2 = (SingleVariableDeclaration)j.next();
					String paramType = paramDec2.getType().toString();
					String paramName = paramDec2.getName().getIdentifier();
					
					if (isComposite) {
						//ArrayInitializer initArrayExp = builder.newArrayInitializer();
						visitMethod.getBody().statements().add(newVariableDeclarationStatement("org.eclipse.jdt.core.dom.ArrayInitializer", "initArrayExp", newMethodInvocation("builder", "newArrayInitializer")));				

					    //builder.newArrayCreation(componentType, initArrayExp);
						callExp = newMethodInvocation("builder", "newArrayCreation");
						callExp.arguments().add(newLiteral(componentType));
						callExp.arguments().add(ast.newSimpleName("initArrayExp"));
						
						//callExp.arguments().add(callExp);
						callExp2 = newMethodInvocation(newMethodInvocation("callExp", "arguments"), "add");
						callExp2.arguments().add(callExp);
						visitMethod.getBody().statements().add(ast.newExpressionStatement(callExp2));
						
						//List list = initArrayExp.expressions();
						VariableDeclarationStatement varDecStm = newVariableDeclarationStatement("java.util.List", "list", newMethodInvocation("initArrayExp", "expressions"));
						visitMethod.getBody().statements().add(varDecStm);				
					    
						//for (int i=0; i<entity.wSize(); i++)
						//  list.add(astOf((entityInterfaceName) entity.wGet(i)));
					    addStatement(visitMethod, newForStatement(
					            newVariableDeclarationExpression("int", "i", newLiteral(0)),
					            newInfixExpression(ast.newSimpleName("i"), "<", newMethodInvocation(visitName, "wSize")),
					            newPostfixExpression(ast.newSimpleName("i"), "++"),
					            newExpressionStatement(
					            		newMethodInvocation("list", "add", newMethodInvocation("astOf", newCastExpression(generator.specificEntityInterfaceName(),
					                            newMethodInvocation(visitName, "wGet", ast.newSimpleName("i"))))))));
					} else {
					    //builder.newLiteral(entity.getField()) oppure astOf(entity.getField());
						MethodInvocation callExp4 = (StringUtils.isPrimitiveOrString(paramType) || paramType.endsWith("Enum.Value")) ? newMethodInvocation("builder", "newLiteral") : newMethodInvocation("astOf");
						callExp4.arguments().add(newMethodInvocation(visitName, StringUtils.getterName(paramType, paramName)));							
					
						//callExp.arguments().add(fieldExp);
						callExp2 = newMethodInvocation(newMethodInvocation("callExp", "arguments"), "add");
						callExp2.arguments().add(callExp4);
						visitMethod.getBody().statements().add(ast.newExpressionStatement(callExp2));
					};
				}
			    
			    //builder.addSubtree(parentNestingSize, visitType, callExp);
			    callExp = newMethodInvocation("builder", "addSubtree");
			    callExp.arguments().add(ast.newSimpleName("parentNestingSize"));
			    callExp.arguments().add(newLiteral(visitType));
			    callExp.arguments().add(ast.newSimpleName("callExp"));
			    visitMethod.getBody().statements().add(newExpressionStatement(callExp));
			}
		}

		//add builder field
		addBodyDeclaration(0, fieldDec = newFieldDeclaration(JavaStoreBuilder.class.getName(), "builder"));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		
		//add isCompiling field
		addBodyDeclaration(1, fieldDec = newFieldDeclaration("boolean", "isCompiling"));
		fieldDec.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));

		//add astOf method
		methodDec = newMethodDeclaration("org.eclipse.jdt.core.dom.Expression", "astOf");
	    methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration(entityInterfaceName, "entity"));
		addBodyDeclaration(2, methodDec);

		//entity.accept(this);
		callExp = newMethodInvocation("entity", "accept");
		callExp.arguments().add(ast.newThisExpression());
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));

		//return builder.getExpression();
		methodDec.getBody().statements().add(newReturnStatement(newMethodInvocation("builder", "getExpression")));

		//add astOf method
		methodDec = newMethodDeclaration("org.eclipse.jdt.core.dom.Expression", "astOf");
	    methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("Object", "entity"));
		addBodyDeclaration(3, methodDec);

		//return builder.newNullLiteral();
		methodDec.getBody().statements().add(newReturnStatement(newMethodInvocation("builder", "newNullLiteral")));

	    
		//add constructor
		methodDec = newConstructorDeclaration(generator.javaStoreVisitorName());
		methodDec.parameters().add(newSingleVariableDeclaration(JavaStoreBuilder.class.getName(), "builder"));
		methodDec.parameters().add(newSingleVariableDeclaration("boolean", "isCompiling"));
		addBodyDeclaration(2, methodDec);

		//this.builder = builder
		methodDec.getBody().statements().add(ast.newExpressionStatement(newAssignment(newFieldAccess(ast.newThisExpression(), "builder"), ast.newSimpleName("builder"))));

		//this.builder = builder
		methodDec.getBody().statements().add(ast.newExpressionStatement(newAssignment(newFieldAccess(ast.newThisExpression(), "isCompiling"), ast.newSimpleName("isCompiling"))));
		
		//builder.addLanguageFactory(factoryName);
		String languageFactoryName = generator.packagePrefix+".model."+languageFactoryType.getName().getFullyQualifiedName();
		callExp = newMethodInvocation("builder", "addLanguageFactory");
		callExp.arguments().add(ast.newThisExpression());
		callExp.arguments().add(newLiteral(languageFactoryName));
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));
	}
}
