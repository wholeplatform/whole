/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class JavaModelContext extends EntityContext {

    public JavaModelContext(IEntity root) {
        super(root);
    }

    public JavaModelContext get_package() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum._package);
    }

    public void set_package(JavaModelContext _package) {
        wSet(JavaFeatureDescriptorEnum._package, _package);
    }

    public JavaModelContext getImports() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.imports);
    }

    public void setImports(JavaModelContext imports) {
        wSet(JavaFeatureDescriptorEnum.imports, imports);
    }

    public JavaModelContext getTypes() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.types);
    }

    public void setTypes(JavaModelContext types) {
        wSet(JavaFeatureDescriptorEnum.types, types);
    }

    public JavaModelContext getJavadoc() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.javadoc);
    }

    public void setJavadoc(JavaModelContext javadoc) {
        wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
    }

    public JavaModelContext getAnnotations() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.annotations);
    }

    public void setAnnotations(JavaModelContext annotations) {
        wSet(JavaFeatureDescriptorEnum.annotations, annotations);
    }

    public JavaModelContext getName() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.name);
    }

    public void setName(JavaModelContext name) {
        wSet(JavaFeatureDescriptorEnum.name, name);
    }

    public JavaModelContext getDocElements() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.docElements);
    }

    public void setDocElements(JavaModelContext docElements) {
        wSet(JavaFeatureDescriptorEnum.docElements, docElements);
    }

    public JavaModelContext getText() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.text);
    }

    public void setText(JavaModelContext text) {
        wSet(JavaFeatureDescriptorEnum.text, text);
    }

    public JavaModelContext getTags() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.tags);
    }

    public void setTags(JavaModelContext tags) {
        wSet(JavaFeatureDescriptorEnum.tags, tags);
    }

    public JavaModelContext getQualifier() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.qualifier);
    }

    public void setQualifier(JavaModelContext qualifier) {
        wSet(JavaFeatureDescriptorEnum.qualifier, qualifier);
    }

    public JavaModelContext getParameters() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.parameters);
    }

    public void setParameters(JavaModelContext parameters) {
        wSet(JavaFeatureDescriptorEnum.parameters, parameters);
    }

    public JavaModelContext getType() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.type);
    }

    public void setType(JavaModelContext type) {
        wSet(JavaFeatureDescriptorEnum.type, type);
    }

    public JavaModelContext getVarargs() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.varargs);
    }

    public void setVarargs(JavaModelContext varargs) {
        wSet(JavaFeatureDescriptorEnum.varargs, varargs);
    }

    public JavaModelContext getTagName() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.tagName);
    }

    public void setTagName(JavaModelContext tagName) {
        wSet(JavaFeatureDescriptorEnum.tagName, tagName);
    }

    public JavaModelContext getFragments() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.fragments);
    }

    public void setFragments(JavaModelContext fragments) {
        wSet(JavaFeatureDescriptorEnum.fragments, fragments);
    }

    public JavaModelContext getTypeName() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.typeName);
    }

    public void setTypeName(JavaModelContext typeName) {
        wSet(JavaFeatureDescriptorEnum.typeName, typeName);
    }

    public JavaModelContext getValue() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.value);
    }

    public void setValue(JavaModelContext value) {
        wSet(JavaFeatureDescriptorEnum.value, value);
    }

    public JavaModelContext getValues() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.values);
    }

    public void setValues(JavaModelContext values) {
        wSet(JavaFeatureDescriptorEnum.values, values);
    }

    public JavaModelContext getOnDemand() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.onDemand);
    }

    public void setOnDemand(JavaModelContext onDemand) {
        wSet(JavaFeatureDescriptorEnum.onDemand, onDemand);
    }

    public JavaModelContext get_static() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum._static);
    }

    public void set_static(JavaModelContext _static) {
        wSet(JavaFeatureDescriptorEnum._static, _static);
    }

    public JavaModelContext getModifiers() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.modifiers);
    }

    public void setModifiers(JavaModelContext modifiers) {
        wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
    }

    public JavaModelContext getBodyDeclarations() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.bodyDeclarations);
    }

    public void setBodyDeclarations(JavaModelContext bodyDeclarations) {
        wSet(JavaFeatureDescriptorEnum.bodyDeclarations, bodyDeclarations);
    }

    public JavaModelContext getSuperInterfaceTypes() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.superInterfaceTypes);
    }

    public void setSuperInterfaceTypes(JavaModelContext superInterfaceTypes) {
        wSet(JavaFeatureDescriptorEnum.superInterfaceTypes, superInterfaceTypes);
    }

    public JavaModelContext getEnumConstants() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.enumConstants);
    }

    public void setEnumConstants(JavaModelContext enumConstants) {
        wSet(JavaFeatureDescriptorEnum.enumConstants, enumConstants);
    }

    public JavaModelContext getArguments() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.arguments);
    }

    public void setArguments(JavaModelContext arguments) {
        wSet(JavaFeatureDescriptorEnum.arguments, arguments);
    }

    public JavaModelContext getAnonymousClassDeclaration() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.anonymousClassDeclaration);
    }

    public void setAnonymousClassDeclaration(JavaModelContext anonymousClassDeclaration) {
        wSet(JavaFeatureDescriptorEnum.anonymousClassDeclaration, anonymousClassDeclaration);
    }

    public JavaModelContext getTypeParameters() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.typeParameters);
    }

    public void setTypeParameters(JavaModelContext typeParameters) {
        wSet(JavaFeatureDescriptorEnum.typeParameters, typeParameters);
    }

    public JavaModelContext getSuperclassType() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.superclassType);
    }

    public void setSuperclassType(JavaModelContext superclassType) {
        wSet(JavaFeatureDescriptorEnum.superclassType, superclassType);
    }

    public JavaModelContext getTypeBounds() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.typeBounds);
    }

    public void setTypeBounds(JavaModelContext typeBounds) {
        wSet(JavaFeatureDescriptorEnum.typeBounds, typeBounds);
    }

    public JavaModelContext get_default() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum._default);
    }

    public void set_default(JavaModelContext _default) {
        wSet(JavaFeatureDescriptorEnum._default, _default);
    }

    public JavaModelContext getBody() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.body);
    }

    public void setBody(JavaModelContext body) {
        wSet(JavaFeatureDescriptorEnum.body, body);
    }

    public JavaModelContext getReturnType() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.returnType);
    }

    public void setReturnType(JavaModelContext returnType) {
        wSet(JavaFeatureDescriptorEnum.returnType, returnType);
    }

    public JavaModelContext getExtraDimensions() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.extraDimensions);
    }

    public void setExtraDimensions(JavaModelContext extraDimensions) {
        wSet(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
    }

    public JavaModelContext getThrownExceptions() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.thrownExceptions);
    }

    public void setThrownExceptions(JavaModelContext thrownExceptions) {
        wSet(JavaFeatureDescriptorEnum.thrownExceptions, thrownExceptions);
    }

    public JavaModelContext getInitializer() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.initializer);
    }

    public void setInitializer(JavaModelContext initializer) {
        wSet(JavaFeatureDescriptorEnum.initializer, initializer);
    }

    public JavaModelContext getVarargsAnnotations() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.varargsAnnotations);
    }

    public void setVarargsAnnotations(JavaModelContext varargsAnnotations) {
        wSet(JavaFeatureDescriptorEnum.varargsAnnotations, varargsAnnotations);
    }

    public JavaModelContext getComponentType() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.componentType);
    }

    public void setComponentType(JavaModelContext componentType) {
        wSet(JavaFeatureDescriptorEnum.componentType, componentType);
    }

    public JavaModelContext getTypeArguments() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.typeArguments);
    }

    public void setTypeArguments(JavaModelContext typeArguments) {
        wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
    }

    public JavaModelContext getBound() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.bound);
    }

    public void setBound(JavaModelContext bound) {
        wSet(JavaFeatureDescriptorEnum.bound, bound);
    }

    public JavaModelContext getUpperBound() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.upperBound);
    }

    public void setUpperBound(JavaModelContext upperBound) {
        wSet(JavaFeatureDescriptorEnum.upperBound, upperBound);
    }

    public JavaModelContext getExpression() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.expression);
    }

    public void setExpression(JavaModelContext expression) {
        wSet(JavaFeatureDescriptorEnum.expression, expression);
    }

    public JavaModelContext getMessage() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.message);
    }

    public void setMessage(JavaModelContext message) {
        wSet(JavaFeatureDescriptorEnum.message, message);
    }

    public JavaModelContext getLabel() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.label);
    }

    public void setLabel(JavaModelContext label) {
        wSet(JavaFeatureDescriptorEnum.label, label);
    }

    public JavaModelContext getParameter() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.parameter);
    }

    public void setParameter(JavaModelContext parameter) {
        wSet(JavaFeatureDescriptorEnum.parameter, parameter);
    }

    public JavaModelContext getInitializers() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.initializers);
    }

    public void setInitializers(JavaModelContext initializers) {
        wSet(JavaFeatureDescriptorEnum.initializers, initializers);
    }

    public JavaModelContext getUpdaters() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.updaters);
    }

    public void setUpdaters(JavaModelContext updaters) {
        wSet(JavaFeatureDescriptorEnum.updaters, updaters);
    }

    public JavaModelContext getThenStatement() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.thenStatement);
    }

    public void setThenStatement(JavaModelContext thenStatement) {
        wSet(JavaFeatureDescriptorEnum.thenStatement, thenStatement);
    }

    public JavaModelContext getElseStatement() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.elseStatement);
    }

    public void setElseStatement(JavaModelContext elseStatement) {
        wSet(JavaFeatureDescriptorEnum.elseStatement, elseStatement);
    }

    public JavaModelContext getStatements() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.statements);
    }

    public void setStatements(JavaModelContext statements) {
        wSet(JavaFeatureDescriptorEnum.statements, statements);
    }

    public JavaModelContext getCatchClauses() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.catchClauses);
    }

    public void setCatchClauses(JavaModelContext catchClauses) {
        wSet(JavaFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public JavaModelContext get_finally() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum._finally);
    }

    public void set_finally(JavaModelContext _finally) {
        wSet(JavaFeatureDescriptorEnum._finally, _finally);
    }

    public JavaModelContext getException() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.exception);
    }

    public void setException(JavaModelContext exception) {
        wSet(JavaFeatureDescriptorEnum.exception, exception);
    }

    public JavaModelContext getTypeDeclaration() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.typeDeclaration);
    }

    public void setTypeDeclaration(JavaModelContext typeDeclaration) {
        wSet(JavaFeatureDescriptorEnum.typeDeclaration, typeDeclaration);
    }

    public JavaModelContext getArray() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.array);
    }

    public void setArray(JavaModelContext array) {
        wSet(JavaFeatureDescriptorEnum.array, array);
    }

    public JavaModelContext getIndex() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.index);
    }

    public void setIndex(JavaModelContext index) {
        wSet(JavaFeatureDescriptorEnum.index, index);
    }

    public JavaModelContext getDimensions() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.dimensions);
    }

    public void setDimensions(JavaModelContext dimensions) {
        wSet(JavaFeatureDescriptorEnum.dimensions, dimensions);
    }

    public JavaModelContext getLeftHandSide() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.leftHandSide);
    }

    public void setLeftHandSide(JavaModelContext leftHandSide) {
        wSet(JavaFeatureDescriptorEnum.leftHandSide, leftHandSide);
    }

    public JavaModelContext getOperator() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.operator);
    }

    public void setOperator(JavaModelContext operator) {
        wSet(JavaFeatureDescriptorEnum.operator, operator);
    }

    public JavaModelContext getRightHandSide() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.rightHandSide);
    }

    public void setRightHandSide(JavaModelContext rightHandSide) {
        wSet(JavaFeatureDescriptorEnum.rightHandSide, rightHandSide);
    }

    public JavaModelContext getThenExpression() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.thenExpression);
    }

    public void setThenExpression(JavaModelContext thenExpression) {
        wSet(JavaFeatureDescriptorEnum.thenExpression, thenExpression);
    }

    public JavaModelContext getElseExpression() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.elseExpression);
    }

    public void setElseExpression(JavaModelContext elseExpression) {
        wSet(JavaFeatureDescriptorEnum.elseExpression, elseExpression);
    }

    public JavaModelContext getLeftOperand() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.leftOperand);
    }

    public void setLeftOperand(JavaModelContext leftOperand) {
        wSet(JavaFeatureDescriptorEnum.leftOperand, leftOperand);
    }

    public JavaModelContext getRightOperand() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.rightOperand);
    }

    public void setRightOperand(JavaModelContext rightOperand) {
        wSet(JavaFeatureDescriptorEnum.rightOperand, rightOperand);
    }

    public JavaModelContext getExtendedOperands() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.extendedOperands);
    }

    public void setExtendedOperands(JavaModelContext extendedOperands) {
        wSet(JavaFeatureDescriptorEnum.extendedOperands, extendedOperands);
    }

    public JavaModelContext getOperand() {
        return (JavaModelContext) wGet(JavaFeatureDescriptorEnum.operand);
    }

    public void setOperand(JavaModelContext operand) {
        wSet(JavaFeatureDescriptorEnum.operand, operand);
    }
}
