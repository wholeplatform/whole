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
package org.whole.gen.lang.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class EnumTypeBuilder extends CompilationUnitBuilder {
    private MethodDeclaration constructor;
    private String valueType;
    
    int nextOrdinal = 0;
    Map<String, String> values = new HashMap<String, String>(256); // maps names to types

    public EnumTypeBuilder(LanguageGenerator generator, String enumType, String valueType) {
        super(generator);
        this.valueType = valueType;
        
        TypeDeclaration enumDec = addClassDeclaration(generator.modelPackage()+"."+enumType);
        setSuperclass(newParameterizedType(EnumType.class.getName(), newQualifiedType(enumType+".Value")));
		addSerialVersionUID(1L);
		constructor = addSingletonField();
				
//		MethodDeclaration method = newMethodDeclaration("Value", "valueOf", newSingleVariableDeclaration("int", "ordinal"));
//		method.getBody().statements().add(newReturnStatement(newCastExpression("Value", newMethodInvocation("values", "get", ast.newSimpleName("ordinal")))));
//		addBodyDeclaration(method);
//
//		method = newMethodDeclaration("Value", "valueOf", newSingleVariableDeclaration("String", "name"));
//		method.getBody().statements().add(newReturnStatement(newCastExpression("Value", newMethodInvocation("namesMap", "get", ast.newSimpleName("name")))));
//		addBodyDeclaration(method);

		MethodDeclaration method = newMethodDeclaration("void", "enumValue", newSingleVariableDeclaration("int", "ordinal"), newSingleVariableDeclaration("String", "name"));
        method.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		method.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		method.getBody().statements().add(
				newIfStatement(newInfixExpression(newMethodInvocation("valueOf", ast.newSimpleName("name")), "==", newNullLiteral()),
				newExpressionStatement(newMethodInvocation("putEnumValue", newClassInstanceCreation("Value", ast.newSimpleName("ordinal"), ast.newSimpleName("name"))))));
		addBodyDeclaration(method);

		method = newMethodDeclaration("void", "enumValue", newSingleVariableDeclaration("int", "ordinal"), newSingleVariableDeclaration("String", "name"),
				newSingleVariableDeclaration("String", "implName"));
        method.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		method.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		method.getBody().statements().add(
				newIfStatement(newInfixExpression(newMethodInvocation("valueOf", ast.newSimpleName("name")), "==", newNullLiteral()),
				newExpressionStatement(newMethodInvocation("putEnumValue", newClassInstanceCreation("Value", ast.newSimpleName("ordinal"), ast.newSimpleName("name"),
						ast.newSimpleName("implName"))))));
		addBodyDeclaration(method);

		// inner EnumValue class
		TypeDeclaration typeDec = ast.newTypeDeclaration();		
		typeDec.setInterface(isInterface = false);
		typeDec.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		typeDec.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		typeDec.setName(ast.newSimpleName("Value"));
		typeDec.setSuperclassType(newType(EnumValueImpl.class.getName()));
		enumDec.bodyDeclarations().add(typeDec);

		typeDec.bodyDeclarations().add(newSerialVersionUID(1L));

		method = newConstructorDeclaration(typeDec);
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		method.getBody().statements().add(superCall);
		typeDec.bodyDeclarations().add(method);
		
		method = newConstructorDeclaration(typeDec);
		method.parameters().add(newSingleVariableDeclaration("int", "ordinal"));
		method.parameters().add(newSingleVariableDeclaration("String", "name"));
		superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("ordinal"));
		superCall.arguments().add(ast.newSimpleName("name"));
		method.getBody().statements().add(superCall);
		typeDec.bodyDeclarations().add(method);		
		
		method = newConstructorDeclaration(typeDec);
		method.parameters().add(newSingleVariableDeclaration("int", "ordinal"));
		method.parameters().add(newSingleVariableDeclaration("String", "name"));
		method.parameters().add(newSingleVariableDeclaration("String", "implName"));
		superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("ordinal"));
		superCall.arguments().add(ast.newSimpleName("name"));
		superCall.arguments().add(ast.newSimpleName("implName"));
		method.getBody().statements().add(superCall);
		typeDec.bodyDeclarations().add(method);		
    }
    
    public void addValue(String valueName, String valueImplName) {
        String valueName_ord = valueImplName+"_ord";
        String oldType = (String) values.put(valueImplName, valueType);

        if (oldType == null) {
            //public static final int [valueName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", valueName_ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final Value [valueName] = instance.valueOf([valueName_ord]);
    		MethodInvocation callExp = newMethodInvocation("instance", "valueOf");
    		callExp.arguments().add(ast.newSimpleName(valueName_ord));
            fieldDecl = newFieldDeclaration("Value", valueImplName, callExp);
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);

			//enumValue([valueName_ord], "[valueName]");
			callExp = newMethodInvocation("enumValue");
			callExp.arguments().add(ast.newSimpleName(valueName_ord));
			callExp.arguments().add(newLiteral(valueName));
			if (!valueName.equals(valueImplName))
				callExp.arguments().add(newLiteral(valueImplName));
			constructor.getBody().statements().add(ast.newExpressionStatement(callExp));
        }
    }
}
