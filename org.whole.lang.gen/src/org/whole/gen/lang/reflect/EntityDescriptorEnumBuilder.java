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
package org.whole.gen.lang.reflect;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public class EntityDescriptorEnumBuilder extends CompilationUnitBuilder {
	private String fdEnumName;
//    private MethodDeclaration constructor;
    private MethodDeclaration initEntityDescriptors;
    private MethodDeclaration initForeignTypeRelations;
    
    int nextOrdinal = 0;
    Map<String, String> entities = new HashMap<String, String>(256); // maps names to types
    Map<String, ExpressionStatement> etypeExpressionMap = new HashMap<String, ExpressionStatement>(256); // maps entityType to argument list of entityDescriptor call

    @SuppressWarnings("unchecked")
	public EntityDescriptorEnumBuilder(LanguageGenerator generator) {
        super(generator);
        
        TypeDeclaration typeDec = addClassDeclaration(generator.specificEntityDescriptorEnumName());
		typeDec.modifiers().add(0, newSingleMemberAnnotation("SuppressWarnings", "unchecked"));
		addImportDeclaration(fdEnumName = ((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), false);
		addImportDeclaration(EntityDescriptorEnum.class.getName(), false);
		addImportDeclaration(EntityDescriptor.class.getName(), false);
		addImportDeclaration(generator.modelPackage(), true);
		setSuperclass(EntityDescriptorEnum.class.getName());
		addSerialVersionUID(1L);
		
		/*constructor =*/
		addSingletonField();
		addBodyDeclaration(initEntityDescriptors = newMethodDeclaration("void", "initEntityDescriptors"));
		initEntityDescriptors.modifiers().clear();
		initEntityDescriptors.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
    }

    protected MethodDeclaration initForeignTypeRelations() {
    	if (initForeignTypeRelations == null) {
    		addBodyDeclaration(initForeignTypeRelations = newMethodDeclaration("void", "initForeignTypeRelations"));
    		initForeignTypeRelations.modifiers().clear();
    		initForeignTypeRelations.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
    	}
    	return initForeignTypeRelations;
    }

    public void addSetAssignableFromAll(String... types) {
		MethodInvocation mi = newMethodInvocation("setAssignableFromAll",
				newLiteral(true));
		
		for (String type : types)
			mi.arguments().add(ast.newSimpleName(type+"_ord"));

		initForeignTypeRelations().getBody().statements().add(
				newExpressionStatement(mi));
    }

    public void addSetAssignableFromForeignType(String foreignType, String... types) {
		MethodInvocation mi = newMethodInvocation("setAssignableFromForeignType",
				newLiteral(true), newLiteral(foreignType));
		
		for (String type : types)
			mi.arguments().add(ast.newSimpleName(type+"_ord"));

		initForeignTypeRelations().getBody().statements().add(
				newExpressionStatement(mi));
    }

    public void addSetAssignableToAll(String... types) {
		MethodInvocation mi = newMethodInvocation("setAssignableToAll",
				newLiteral(true));
		
		for (String type : types)
			mi.arguments().add(ast.newSimpleName(type+"_ord"));

		initForeignTypeRelations().getBody().statements().add(
				newExpressionStatement(mi));
    }

    public void addSetAssignableToForeignType(String foreignType, String... types) {
		MethodInvocation mi = newMethodInvocation("setAssignableToForeignType",
				newLiteral(true), newLiteral(foreignType));
		
		for (String type : types)
			mi.arguments().add(ast.newSimpleName(type+"_ord"));

		initForeignTypeRelations().getBody().statements().add(
				newExpressionStatement(mi));
    }

    public void addSetAliasOf(String foreignType, String type) {
		initForeignTypeRelations().getBody().statements().add(
				newExpressionStatement(newMethodInvocation("setAliasOf",
						newLiteral(true),
						newLiteral(foreignType),
						ast.newSimpleName(type+"_ord"))));
    }

//	public void addSupertypes(String eType, String name, Set<String> supertypes) {
//    	if (supertypes.size()>1) {//!supertypes.isEmpty()) {
//			ExpressionStatement expStm = etypeExpressionMap.get(eType);
//	    	Expression edExp = expStm.getExpression();
//	
//	    	MethodInvocation nfd = newMethodInvocation("withSupertypes");
//	    	expStm.setExpression(nfd);
//	    	nfd.setExpression(edExp); // after unparenting edExp
//	
//	    	for (String sType : supertypes)
//	    		if (!sType.equals(name))
//	    			nfd.arguments().add(ast.newSimpleName(sType+"_ord"));
//    	}
//    }

    @SuppressWarnings("unchecked")
    public void addSimpleEntity(String eName, String name, String eType, Set<String> modifiers, Set<String> allSubtypes) {
        String eName_Ord = eName+"_ord";
        String oldType = entities.put(eName, eType);
        
        if (oldType == null) {
            //public static final int [eName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", eName_Ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final EntityDescriptor<eName> [eName] = (EntityDescriptor<eName>) instance.valueOf([eName_ord]);
            fieldDecl = newFieldDeclaration(
            		newParameterizedType(EntityDescriptor.class.getName(), eName),
            		newVariableDeclarationFragment(eName, newCastExpression(
            				newParameterizedType(EntityDescriptor.class.getName(), eName),
            				newMethodInvocation("instance", "valueOf", ast.newSimpleName(eName_Ord)))));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);
        } else if (oldType.equals(eType))
            return;

		//putSimpleEntity([eName_ord], "[eName]", [eType].class);
		MethodInvocation callExp = newMethodInvocation("putSimpleEntity");
		callExp.arguments().add(ast.newSimpleName(eName_Ord));
		callExp.arguments().add(newLiteral(name));
		if (!eName.equals(name))
			callExp.arguments().add(newLiteral(eName));
		callExp.arguments().add(newTypeLiteral(eType));
		callExp.arguments().add(newLiteral(modifiers!=null && modifiers.contains("ABSTRACT")));

		if (!allSubtypes.isEmpty())
			for (String type : allSubtypes)
				if (!type.equals(name))
					callExp.arguments().add(ast.newSimpleName(type+"_ord"));


		ExpressionStatement expStm = newExpressionStatement(callExp);
		initEntityDescriptors.getBody().statements().add(expStm);
		etypeExpressionMap.put(eType, expStm);
    }
    @SuppressWarnings("unchecked")
	public void addFeature(String eType, String fType, String fName, String ofName, Set<String> modifiers) {
    	ExpressionStatement expStm = etypeExpressionMap.get(eType);
    	Expression edExp = expStm.getExpression();

    	MethodInvocation nfd = newMethodInvocation("withFeature");
    	expStm.setExpression(nfd);
    	nfd.setExpression(edExp); // after unparenting edExp

    	nfd.arguments().add(ast.newQualifiedName(ast.newSimpleName(StringUtils.toSimpleName(fdEnumName)), ast.newSimpleName(fName)));
    	nfd.arguments().add(ast.newSimpleName(fType+"_ord"));
    	if (ofName != null)
        	nfd.arguments().add(ast.newQualifiedName(ast.newSimpleName(StringUtils.toSimpleName(fdEnumName)), ast.newSimpleName(ofName)));
    	if (ofName != null || (modifiers!=null && !modifiers.isEmpty())) { 
	    	nfd.arguments().add(newLiteral(
	    			modifiers!=null && modifiers.contains("OPTIONAL")));
	    	nfd.arguments().add(newLiteral(
	    			modifiers!=null && modifiers.contains("ID")));
	    	nfd.arguments().add(newLiteral(
	    			modifiers!=null && modifiers.contains("REFERENCE")));
	    	nfd.arguments().add(newLiteral(
	    			modifiers!=null && modifiers.contains("DERIVED")));
	    	nfd.arguments().add(newLiteral(
	    			modifiers!=null && modifiers.contains("SHARED")));
    	}
    }

    @SuppressWarnings("unchecked")
    public void addDataEntity(String eName, String name, String eType, Set<String> modifiers, String fType, String fName) {
        String eName_Ord = eName+"_ord";
        String oldType = entities.put(eName, eType);
        
        if (oldType == null) {
            //public static final int [eName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", eName_Ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final EntityDescriptor<eName> [eName] = (EntityDescriptor<eName>) instance.valueOf([eName_ord]);
            fieldDecl = newFieldDeclaration(
            		newParameterizedType(EntityDescriptor.class.getName(), eName),
            		newVariableDeclarationFragment(eName, newCastExpression(
            				newParameterizedType(EntityDescriptor.class.getName(), eName),
            				newMethodInvocation("instance", "valueOf", ast.newSimpleName(eName_Ord)))));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);
        } else if (oldType.equals(eType))
            return;

		//putDataEntity([eName_ord], "[eName]", [eType].class);
		MethodInvocation callExp = newMethodInvocation("putDataEntity");
		callExp.arguments().add(ast.newSimpleName(eName_Ord));
		callExp.arguments().add(newLiteral(name));
		if (!eName.equals(name))
			callExp.arguments().add(newLiteral(eName));
		callExp.arguments().add(newTypeLiteral(eType));
		callExp.arguments().add(newLiteral(modifiers!=null && modifiers.contains("RELATIONSHIP")));
//				newEnumSetOfExpression(EntityModifiers.class.getName(), modifiers));
//		if (fType.indexOf('.')!=-1 || fType.endsWith("Enum.Value"))
			callExp.arguments().add(newQualifiedTypeLiteral(fType));
//		else
//			callExp.arguments().add(newTypeLiteral(fType));

		ExpressionStatement expStm = newExpressionStatement(callExp);
		initEntityDescriptors.getBody().statements().add(expStm);
		etypeExpressionMap.put(eType, expStm);
    }

    @SuppressWarnings("unchecked")
    public void addCompositeEntity(String eName, String name, String eType, Set<String> modifiers, String elementType, Set<String> compositeModifiers) {
//        String eName = StringUtils.toSimpleName(eType);
        String eName_Ord = eName+"_ord";
        String oldType = entities.put(eName, eType);
        
        if (oldType == null) {
            //public static final int [eName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", eName_Ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final EntityDescriptor<eName> [eName] = (EntityDescriptor<eName>) instance.valueOf([eName_ord]);
            fieldDecl = newFieldDeclaration(
            		newParameterizedType(EntityDescriptor.class.getName(), eName),
            		newVariableDeclarationFragment(eName, newCastExpression(
            				newParameterizedType(EntityDescriptor.class.getName(), eName),
            				newMethodInvocation("instance", "valueOf", ast.newSimpleName(eName_Ord)))));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);
        } else if (oldType.equals(eType))
            return;

		boolean isOrdered = false, isUnique = false, isReference = false, isDerived = false, isShared = false;
		if (compositeModifiers != null) {
			isOrdered = compositeModifiers.contains("ORDERED");
			isUnique = compositeModifiers.contains("UNIQUE");
			isReference = compositeModifiers.contains("REFERENCE");
			isDerived = compositeModifiers.contains("DERIVED");
			isShared = compositeModifiers.contains("SHARED");
		}

		//putCompositeEntity([eName_ord], "[eName]", [eType].class, ElementType_ord);
		MethodInvocation callExp = newMethodInvocation("putCompositeEntity");
		callExp.arguments().add(ast.newSimpleName(eName_Ord));
		callExp.arguments().add(newLiteral(name));
		if (!eName.equals(name))
			callExp.arguments().add(newLiteral(eName));
		callExp.arguments().add(newTypeLiteral(eType));
		callExp.arguments().add(newLiteral(modifiers!=null && modifiers.contains("RELATIONSHIP")));
		callExp.arguments().add(ast.newSimpleName(generator.entityResolverSimpleName(elementType)+"_ord"));
		callExp.arguments().add(newLiteral(isOrdered));
		callExp.arguments().add(newLiteral(isUnique));
		if (isReference || isDerived || isShared) {
			callExp.arguments().add(newLiteral(isReference));
			callExp.arguments().add(newLiteral(isDerived));
			callExp.arguments().add(newLiteral(isShared));
		}

		ExpressionStatement expStm = newExpressionStatement(callExp);
		initEntityDescriptors.getBody().statements().add(expStm);
		etypeExpressionMap.put(eType, expStm);
    }

    @SuppressWarnings("unchecked")
    public void addMapEntity(String eType, String name, Set<String> modifiers, String keyType, String valueType) {
        String eName = StringUtils.toSimpleName(eType);
        String eName_Ord = eName+"_ord";
        String oldType = entities.put(eName, eType);
        
        if (oldType == null) {
            //public static final int [eName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", eName_Ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
    		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final EntityDescriptor<eName> [eName] = (EntityDescriptor<eName>) instance.valueOf([eName_ord]);
            fieldDecl = newFieldDeclaration(
            		newParameterizedType(EntityDescriptor.class.getName(), eName),
            		newVariableDeclarationFragment(eName, newCastExpression(
            				newParameterizedType(EntityDescriptor.class.getName(), eName),
            				newMethodInvocation("instance", "valueOf", ast.newSimpleName(eName_Ord)))));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);
        } else if (oldType.equals(eType))
            return;
		
		//putMapEntity([eName_ord], "[eName]", [eType].class, ElementType_ord);
		MethodInvocation callExp = newMethodInvocation("putMapEntity");
		callExp.arguments().add(ast.newSimpleName(eName_Ord));
		callExp.arguments().add(newLiteral(name));
		if (!eName.equals(name))
			callExp.arguments().add(newLiteral(eName));
		callExp.arguments().add(newTypeLiteral(eType));
		callExp.arguments().add(newLiteral(modifiers!=null && modifiers.contains("RELATIONSHIP")));
//				newEnumSetOfExpression(EntityModifiers.class.getName(), modifiers));
		callExp.arguments().add(ast.newSimpleName(generator.entityResolverSimpleName(keyType)+"_ord"));
		callExp.arguments().add(ast.newSimpleName(generator.entityResolverSimpleName(valueType)+"_ord"));

		ExpressionStatement expStm = newExpressionStatement(callExp);
		initEntityDescriptors.getBody().statements().add(expStm);
		etypeExpressionMap.put(eType, expStm);
    }

    @SuppressWarnings("unchecked")
	public Expression newEnumSetOfExpression(String enumType, Set<String> enumConstants) {
		if (enumConstants.isEmpty())
			return newMethodInvocation("noneOf"+StringUtils.toSimpleName(enumType));
//			return newMethodInvocation("noneOf", newTypeLiteral(enumType));

		MethodInvocation callExp = newMethodInvocation("of");
		for (String enumConstant : enumConstants)
			callExp.arguments().add(
					enumConstant.equals("REFERENCE")||enumConstant.equals("DERIVED")||enumConstant.equals("SHARED") ?
							newMethodInvocation(StringUtils.toSimpleName(enumType)+enumConstant) :
							newSimpleName(enumConstant));
//					newFieldAccess(enumType, enumConstant));
		return callExp;
	}


}
