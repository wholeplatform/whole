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

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class FeatureDescriptorEnumBuilder extends CompilationUnitBuilder {
    private MethodDeclaration constructor;
    
    int nextOrdinal = 0;
    Map features = new HashMap(256); // maps names to types

    public FeatureDescriptorEnumBuilder(LanguageGenerator generator) {
        super(generator);
        
		addClassDeclaration(generator.specificFeatureDescriptorEnumName(), FeatureDescriptorEnum.class.getName());
		addSerialVersionUID(1L);
		constructor = addSingletonField();
    }

    public void addFeature(String fType, String fName, String name) {
        String fName_ord = fName+"_ord";
        String oldType = (String) features.put(fName, fType);
        
        if (oldType == null) {
            //public static final int [fName_ord] = [nextOrdinal];
            FieldDeclaration fieldDecl = newFieldDeclaration("int", fName_ord, newLiteral(nextOrdinal));
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
            addBodyDeclaration(nextOrdinal++, fieldDecl);

    		//public static final FeatureDescriptor [fName] = instance.valueOf([fName_ord]);
    		MethodInvocation callExp = newMethodInvocation("instance", "valueOf");
    		callExp.arguments().add(ast.newSimpleName(fName_ord));
            fieldDecl = newFieldDeclaration(FeatureDescriptor.class.getName(), fName, callExp);
            fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
            fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
    		addBodyDeclaration(nextOrdinal*2, fieldDecl);
//        }
		
		//putFeatureDescriptor([fName_ord], "[fName]");
		callExp = newMethodInvocation("putFeatureDescriptor");
		callExp.arguments().add(ast.newSimpleName(fName_ord));
		callExp.arguments().add(newLiteral(name));
		if (!fName.equals(name))
			callExp.arguments().add(newLiteral(fName));
		constructor.getBody().statements().add(ast.newExpressionStatement(callExp));

        }
    }
}
