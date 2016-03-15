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
package org.whole.gen.lang.visitors;

import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.MethodNotFoundException;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVisitorCompilationUnitBuilder extends CompilationUnitBuilder {
    public AbstractVisitorCompilationUnitBuilder(LanguageGenerator generator) {
        super(generator);
    }
    
    public void addConstructorWithSuper(String[][] params) {
		MethodDeclaration constructor = addConstructorDeclaration();
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		for (int i=0; i<params.length; i++) {
		    String pName = params[i][1];
			constructor.parameters().add(newSingleVariableDeclaration(generator.visitorInterfaceName(), pName));
			superCall.arguments().add(ast.newSimpleName(pName));
		}
		constructor.getBody().statements().add(superCall);
    }
    public void addConstructorWithFields(String[][] params) {
		MethodDeclaration constructor = addConstructorDeclaration();
		
		for (int i=0; i<params.length; i++) {
		    String pType = params[i][0];
		    String pName = params[i][1];
		    String setterName = "wSet"+StringUtils.toUpperCap(pName);
		    
		    FieldDeclaration fieldDecl = newFieldDeclaration(pType, pName);
		    fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		    fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		    addBodyDeclaration(2*i, fieldDecl);
//			addBodyDeclaration(3*i+1, newGetterMethod(pType, pName));
			addBodyDeclaration(2*i+1, newSetterMethod(setterName, generator.visitorInterfaceName(), pType, pName));
		    addConstructorCase(constructor, setterName, generator.visitorInterfaceName(), pName);
		}
    }

    public MethodDeclaration addFactoryMethod(String factoryName) {
        return addFactoryMethod(factoryName, new String[0][0]);
    }
    public MethodDeclaration addFactoryMethod(String factoryName, String[][] params) {
        LanguageGenerator gen = (LanguageGenerator) generator;
        String factoryType;
        switch (params.length) {
        case 1:
        	factoryType = generator.unaryVisitorName();
        	break;
        case 2:
        	factoryType = generator.binaryVisitorName();
        	break;
        case 3:
        	factoryType = generator.ternaryVisitorName();
        	break;
        default:
        	factoryType = generator.visitorInterfaceName();
        }
        String visitorName = typeDec.getName().getFullyQualifiedName();
		MethodDeclaration factoryMethod = gen.visitorFactoryBuilder().addFactoryMethod("", factoryType, factoryName, visitorName);
		
	    for (int i=0; i<params.length; i++) {
	        factoryMethod.parameters().add(newSingleVariableDeclaration(generator.visitorInterfaceName(), params[i][1]));
			MethodInvocation callExp = newMethodInvocation("ensureSpecific");
			callExp.arguments().add(ast.newSimpleName(params[i][1]));
	        ((ClassInstanceCreation)((ReturnStatement) factoryMethod.getBody().statements().get(0)).getExpression()).arguments().add(callExp);
	    
	    }
	    return factoryMethod;
    }

    public MethodDeclaration visitMethod(String eName) {
	    try {
	        return findMethodDeclaration("visit", new String[] {eName}, bodyDeclarations());
	    } catch (MethodNotFoundException e) {
	        return super.addVisitMethod(eName);
	    }
    }

	public MethodDeclaration addFragmentVisitMethod(String visitSuffix, String typeName) {
		MethodDeclaration method = addVisitMethod(typeName);
		SuperMethodInvocation callExp = newSuperMethodInvocation("visit"+visitSuffix);
		callExp.arguments().add(ast.newSimpleName("entity"));
		method.getBody().statements().add(ast.newExpressionStatement(callExp));
		return method;
	}

//    public MethodInvocation newAcceptInvocation(String fType, String fName, String name) {
//        return newAcceptInvocation(fType, fName, name, "visitor");
//    }
    public MethodInvocation newAcceptInvocation(String fType, String fName, String name, String visitor) {
        return newAcceptInvocation(newMethodInvocation("entity", StringUtils.getterName(fType, StringUtils.isJavaKeyword(name) ? name : fName)), visitor);
    }
    public MethodInvocation newAcceptInvocation(Expression fieldExp, String visitor) {
    	MethodInvocation getVisitor = newMethodInvocation("wGet"+StringUtils.toUpperCap(visitor));
	    return newAcceptInvocation(fieldExp, getVisitor);
    }
    public MethodInvocation newAcceptInvocation(Expression fieldExp) {
	    return newAcceptInvocation(fieldExp, ast.newThisExpression());
    }
    public MethodInvocation newAcceptInvocation(Expression fieldExp, Expression visitor) {
	    return newMethodInvocation(fieldExp, "accept", visitor);
    }

    public MethodInvocation newVisitInvocation(Expression visitorExp) {
        return newVisitInvocation(visitorExp, "entity");
    }
    public MethodInvocation newVisitInvocation(String visitor, String fType, String fName, String name) {
        return newVisitInvocation(visitor, newMethodInvocation("entity", StringUtils.getterName(fType, StringUtils.isJavaKeyword(name) ? name : fName)));
    }
    public MethodInvocation newVisitInvocation(String visitor, Expression fieldExp) {
    	MethodInvocation getVisitor = newMethodInvocation("wGet"+StringUtils.toUpperCap(visitor));
	    return newVisitInvocation(getVisitor, fieldExp);
    }
    public MethodInvocation newVisitInvocation(Expression visitorExp, String fName) {
	    return newVisitInvocation(visitorExp, newSimpleName(fName));
    }
    public MethodInvocation newVisitInvocation(Expression visitorExp, Expression fieldExp) {
	    MethodInvocation callExp = newMethodInvocation(visitorExp, "visit");
	    callExp.arguments().add(fieldExp);
	    return callExp;
    }
    
	public MethodDeclaration addType(String eName, String eType) {
	    return null;
	}

    public MethodDeclaration addEntity(String type) {
        return visitMethod(type);
	}
	public MethodDeclaration addSimpleEntity(String type) {
	    return addEntity(type);
	}
	public MethodDeclaration addCompositeEntity(String type, String componentType, boolean isOrdered, boolean isByReference) {
	    return addEntity(type);
	}
	public MethodDeclaration addMapEntity(String type, String keyType, String valueType) {
	    return addEntity(type);
	}
	public MethodDeclaration addFragmentEntity(String type) {
	    return null;
	}
	public MethodDeclaration addPrimitiveEntity(String type) {
	    return addEntity(type);
	}
	public void addEnumEntity(String eName, String fType, String fName) {
		addPrimitiveEntity(eName);
		addPrimitiveFeature(eName, fType, fName);
	}
	public MethodDeclaration addResolverEntity(String type) {
	    return addEntity(type);
	}

	public void addFeature(String eName, String fType, String fName) {
	}
	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
	    addFeature(eName, fType, fName);
	}
	public void addPrimitiveFeature(String eName, String fType, String fName) {
	    addFeature(eName, fType, fName);
	}
}
