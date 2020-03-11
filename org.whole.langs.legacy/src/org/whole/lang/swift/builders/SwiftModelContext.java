/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swift.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftModelContext extends EntityContext {

    public SwiftModelContext(IEntity root) {
        super(root);
    }

    public SwiftModelContext getExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.expression);
    }

    public void setExpression(SwiftModelContext expression) {
        wSet(SwiftFeatureDescriptorEnum.expression, expression);
    }

    public SwiftModelContext getDelimiter() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.delimiter);
    }

    public void setDelimiter(SwiftModelContext delimiter) {
        wSet(SwiftFeatureDescriptorEnum.delimiter, delimiter);
    }

    public SwiftModelContext getExpressions() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.expressions);
    }

    public void setExpressions(SwiftModelContext expressions) {
        wSet(SwiftFeatureDescriptorEnum.expressions, expressions);
    }

    public SwiftModelContext getQuestionOrExclamationMark() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.questionOrExclamationMark);
    }

    public void setQuestionOrExclamationMark(SwiftModelContext questionOrExclamationMark) {
        wSet(SwiftFeatureDescriptorEnum.questionOrExclamationMark, questionOrExclamationMark);
    }

    public SwiftModelContext getIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.identifier);
    }

    public void setIdentifier(SwiftModelContext identifier) {
        wSet(SwiftFeatureDescriptorEnum.identifier, identifier);
    }

    public SwiftModelContext getDeclNameArguments() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.declNameArguments);
    }

    public void setDeclNameArguments(SwiftModelContext declNameArguments) {
        wSet(SwiftFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public SwiftModelContext getGenericArgumentClause() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.genericArgumentClause);
    }

    public void setGenericArgumentClause(SwiftModelContext genericArgumentClause) {
        wSet(SwiftFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }

    public SwiftModelContext getOperatorToken() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.operatorToken);
    }

    public void setOperatorToken(SwiftModelContext operatorToken) {
        wSet(SwiftFeatureDescriptorEnum.operatorToken, operatorToken);
    }

    public SwiftModelContext getPostfixExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.postfixExpression);
    }

    public void setPostfixExpression(SwiftModelContext postfixExpression) {
        wSet(SwiftFeatureDescriptorEnum.postfixExpression, postfixExpression);
    }

    public SwiftModelContext getThrowsToken() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.throwsToken);
    }

    public void setThrowsToken(SwiftModelContext throwsToken) {
        wSet(SwiftFeatureDescriptorEnum.throwsToken, throwsToken);
    }

    public SwiftModelContext getLabel() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.label);
    }

    public void setLabel(SwiftModelContext label) {
        wSet(SwiftFeatureDescriptorEnum.label, label);
    }

    public SwiftModelContext getKeyExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.keyExpression);
    }

    public void setKeyExpression(SwiftModelContext keyExpression) {
        wSet(SwiftFeatureDescriptorEnum.keyExpression, keyExpression);
    }

    public SwiftModelContext getValueExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.valueExpression);
    }

    public void setValueExpression(SwiftModelContext valueExpression) {
        wSet(SwiftFeatureDescriptorEnum.valueExpression, valueExpression);
    }

    public SwiftModelContext getConditionExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.conditionExpression);
    }

    public void setConditionExpression(SwiftModelContext conditionExpression) {
        wSet(SwiftFeatureDescriptorEnum.conditionExpression, conditionExpression);
    }

    public SwiftModelContext getFirstChoice() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.firstChoice);
    }

    public void setFirstChoice(SwiftModelContext firstChoice) {
        wSet(SwiftFeatureDescriptorEnum.firstChoice, firstChoice);
    }

    public SwiftModelContext getSecondChoice() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.secondChoice);
    }

    public void setSecondChoice(SwiftModelContext secondChoice) {
        wSet(SwiftFeatureDescriptorEnum.secondChoice, secondChoice);
    }

    public SwiftModelContext getBase() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.base);
    }

    public void setBase(SwiftModelContext base) {
        wSet(SwiftFeatureDescriptorEnum.base, base);
    }

    public SwiftModelContext getDot() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.dot);
    }

    public void setDot(SwiftModelContext dot) {
        wSet(SwiftFeatureDescriptorEnum.dot, dot);
    }

    public SwiftModelContext getName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.name);
    }

    public void setName(SwiftModelContext name) {
        wSet(SwiftFeatureDescriptorEnum.name, name);
    }

    public SwiftModelContext getTypeName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.typeName);
    }

    public void setTypeName(SwiftModelContext typeName) {
        wSet(SwiftFeatureDescriptorEnum.typeName, typeName);
    }

    public SwiftModelContext getType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.type);
    }

    public void setType(SwiftModelContext type) {
        wSet(SwiftFeatureDescriptorEnum.type, type);
    }

    public SwiftModelContext getSpecifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.specifier);
    }

    public void setSpecifier(SwiftModelContext specifier) {
        wSet(SwiftFeatureDescriptorEnum.specifier, specifier);
    }

    public SwiftModelContext getCapture() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.capture);
    }

    public void setCapture(SwiftModelContext capture) {
        wSet(SwiftFeatureDescriptorEnum.capture, capture);
    }

    public SwiftModelContext getInput() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.input);
    }

    public void setInput(SwiftModelContext input) {
        wSet(SwiftFeatureDescriptorEnum.input, input);
    }

    public SwiftModelContext getThrowsTok() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.throwsTok);
    }

    public void setThrowsTok(SwiftModelContext throwsTok) {
        wSet(SwiftFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public SwiftModelContext getOutput() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.output);
    }

    public void setOutput(SwiftModelContext output) {
        wSet(SwiftFeatureDescriptorEnum.output, output);
    }

    public SwiftModelContext getSignature() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.signature);
    }

    public void setSignature(SwiftModelContext signature) {
        wSet(SwiftFeatureDescriptorEnum.signature, signature);
    }

    public SwiftModelContext getStatements() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.statements);
    }

    public void setStatements(SwiftModelContext statements) {
        wSet(SwiftFeatureDescriptorEnum.statements, statements);
    }

    public SwiftModelContext getPattern() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.pattern);
    }

    public void setPattern(SwiftModelContext pattern) {
        wSet(SwiftFeatureDescriptorEnum.pattern, pattern);
    }

    public SwiftModelContext getCalledExpression() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.calledExpression);
    }

    public void setCalledExpression(SwiftModelContext calledExpression) {
        wSet(SwiftFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public SwiftModelContext getArgumentList() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.argumentList);
    }

    public void setArgumentList(SwiftModelContext argumentList) {
        wSet(SwiftFeatureDescriptorEnum.argumentList, argumentList);
    }

    public SwiftModelContext getTrailingClosure() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.trailingClosure);
    }

    public void setTrailingClosure(SwiftModelContext trailingClosure) {
        wSet(SwiftFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }

    public SwiftModelContext getOpenDelimiter() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.openDelimiter);
    }

    public void setOpenDelimiter(SwiftModelContext openDelimiter) {
        wSet(SwiftFeatureDescriptorEnum.openDelimiter, openDelimiter);
    }

    public SwiftModelContext getOpenQuote() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.openQuote);
    }

    public void setOpenQuote(SwiftModelContext openQuote) {
        wSet(SwiftFeatureDescriptorEnum.openQuote, openQuote);
    }

    public SwiftModelContext getSegments() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.segments);
    }

    public void setSegments(SwiftModelContext segments) {
        wSet(SwiftFeatureDescriptorEnum.segments, segments);
    }

    public SwiftModelContext getRootExpr() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.rootExpr);
    }

    public void setRootExpr(SwiftModelContext rootExpr) {
        wSet(SwiftFeatureDescriptorEnum.rootExpr, rootExpr);
    }

    public SwiftModelContext getKind() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.kind);
    }

    public void setKind(SwiftModelContext kind) {
        wSet(SwiftFeatureDescriptorEnum.kind, kind);
    }

    public SwiftModelContext getPoundIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.poundIdentifier);
    }

    public void setPoundIdentifier(SwiftModelContext poundIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.poundIdentifier, poundIdentifier);
    }

    public SwiftModelContext getArguments() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.arguments);
    }

    public void setArguments(SwiftModelContext arguments) {
        wSet(SwiftFeatureDescriptorEnum.arguments, arguments);
    }

    public SwiftModelContext getAttributes() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.attributes);
    }

    public void setAttributes(SwiftModelContext attributes) {
        wSet(SwiftFeatureDescriptorEnum.attributes, attributes);
    }

    public SwiftModelContext getModifiers() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.modifiers);
    }

    public void setModifiers(SwiftModelContext modifiers) {
        wSet(SwiftFeatureDescriptorEnum.modifiers, modifiers);
    }

    public SwiftModelContext getGenericParameterClause() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.genericParameterClause);
    }

    public void setGenericParameterClause(SwiftModelContext genericParameterClause) {
        wSet(SwiftFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public SwiftModelContext getInitializer() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.initializer);
    }

    public void setInitializer(SwiftModelContext initializer) {
        wSet(SwiftFeatureDescriptorEnum.initializer, initializer);
    }

    public SwiftModelContext getGenericWhereClause() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.genericWhereClause);
    }

    public void setGenericWhereClause(SwiftModelContext genericWhereClause) {
        wSet(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public SwiftModelContext getInheritanceClause() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.inheritanceClause);
    }

    public void setInheritanceClause(SwiftModelContext inheritanceClause) {
        wSet(SwiftFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public SwiftModelContext getThrowsOrRethrowsKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(SwiftModelContext throwsOrRethrowsKeyword) {
        wSet(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public SwiftModelContext getPoundKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.poundKeyword);
    }

    public void setPoundKeyword(SwiftModelContext poundKeyword) {
        wSet(SwiftFeatureDescriptorEnum.poundKeyword, poundKeyword);
    }

    public SwiftModelContext getCondition() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.condition);
    }

    public void setCondition(SwiftModelContext condition) {
        wSet(SwiftFeatureDescriptorEnum.condition, condition);
    }

    public SwiftModelContext getElements() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.elements);
    }

    public void setElements(SwiftModelContext elements) {
        wSet(SwiftFeatureDescriptorEnum.elements, elements);
    }

    public SwiftModelContext getMessage() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.message);
    }

    public void setMessage(SwiftModelContext message) {
        wSet(SwiftFeatureDescriptorEnum.message, message);
    }

    public SwiftModelContext getArgs() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.args);
    }

    public void setArgs(SwiftModelContext args) {
        wSet(SwiftFeatureDescriptorEnum.args, args);
    }

    public SwiftModelContext getFileArgLabel() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.fileArgLabel);
    }

    public void setFileArgLabel(SwiftModelContext fileArgLabel) {
        wSet(SwiftFeatureDescriptorEnum.fileArgLabel, fileArgLabel);
    }

    public SwiftModelContext getFileName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.fileName);
    }

    public void setFileName(SwiftModelContext fileName) {
        wSet(SwiftFeatureDescriptorEnum.fileName, fileName);
    }

    public SwiftModelContext getLineArgLabel() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.lineArgLabel);
    }

    public void setLineArgLabel(SwiftModelContext lineArgLabel) {
        wSet(SwiftFeatureDescriptorEnum.lineArgLabel, lineArgLabel);
    }

    public SwiftModelContext getLineNumber() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.lineNumber);
    }

    public void setLineNumber(SwiftModelContext lineNumber) {
        wSet(SwiftFeatureDescriptorEnum.lineNumber, lineNumber);
    }

    public SwiftModelContext getDetail() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.detail);
    }

    public void setDetail(SwiftModelContext detail) {
        wSet(SwiftFeatureDescriptorEnum.detail, detail);
    }

    public SwiftModelContext getMembers() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.members);
    }

    public void setMembers(SwiftModelContext members) {
        wSet(SwiftFeatureDescriptorEnum.members, members);
    }

    public SwiftModelContext getExtendedType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.extendedType);
    }

    public void setExtendedType(SwiftModelContext extendedType) {
        wSet(SwiftFeatureDescriptorEnum.extendedType, extendedType);
    }

    public SwiftModelContext getFirstName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.firstName);
    }

    public void setFirstName(SwiftModelContext firstName) {
        wSet(SwiftFeatureDescriptorEnum.firstName, firstName);
    }

    public SwiftModelContext getSecondName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.secondName);
    }

    public void setSecondName(SwiftModelContext secondName) {
        wSet(SwiftFeatureDescriptorEnum.secondName, secondName);
    }

    public SwiftModelContext getEllipsis() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.ellipsis);
    }

    public void setEllipsis(SwiftModelContext ellipsis) {
        wSet(SwiftFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public SwiftModelContext getDefaultArgument() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.defaultArgument);
    }

    public void setDefaultArgument(SwiftModelContext defaultArgument) {
        wSet(SwiftFeatureDescriptorEnum.defaultArgument, defaultArgument);
    }

    public SwiftModelContext getFunctionIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.functionIdentifier);
    }

    public void setFunctionIdentifier(SwiftModelContext functionIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.functionIdentifier, functionIdentifier);
    }

    public SwiftModelContext getBody() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.body);
    }

    public void setBody(SwiftModelContext body) {
        wSet(SwiftFeatureDescriptorEnum.body, body);
    }

    public SwiftModelContext getOptionalMark() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.optionalMark);
    }

    public void setOptionalMark(SwiftModelContext optionalMark) {
        wSet(SwiftFeatureDescriptorEnum.optionalMark, optionalMark);
    }

    public SwiftModelContext getParameters() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.parameters);
    }

    public void setParameters(SwiftModelContext parameters) {
        wSet(SwiftFeatureDescriptorEnum.parameters, parameters);
    }

    public SwiftModelContext getIndices() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.indices);
    }

    public void setIndices(SwiftModelContext indices) {
        wSet(SwiftFeatureDescriptorEnum.indices, indices);
    }

    public SwiftModelContext getResult() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.result);
    }

    public void setResult(SwiftModelContext result) {
        wSet(SwiftFeatureDescriptorEnum.result, result);
    }

    public SwiftModelContext getAccessor() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.accessor);
    }

    public void setAccessor(SwiftModelContext accessor) {
        wSet(SwiftFeatureDescriptorEnum.accessor, accessor);
    }

    public SwiftModelContext getModifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.modifier);
    }

    public void setModifier(SwiftModelContext modifier) {
        wSet(SwiftFeatureDescriptorEnum.modifier, modifier);
    }

    public SwiftModelContext getImportKind() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.importKind);
    }

    public void setImportKind(SwiftModelContext importKind) {
        wSet(SwiftFeatureDescriptorEnum.importKind, importKind);
    }

    public SwiftModelContext getPath() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.path);
    }

    public void setPath(SwiftModelContext path) {
        wSet(SwiftFeatureDescriptorEnum.path, path);
    }

    public SwiftModelContext getAccessorKind() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.accessorKind);
    }

    public void setAccessorKind(SwiftModelContext accessorKind) {
        wSet(SwiftFeatureDescriptorEnum.accessorKind, accessorKind);
    }

    public SwiftModelContext getParameter() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.parameter);
    }

    public void setParameter(SwiftModelContext parameter) {
        wSet(SwiftFeatureDescriptorEnum.parameter, parameter);
    }

    public SwiftModelContext getTypeAnnotation() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.typeAnnotation);
    }

    public void setTypeAnnotation(SwiftModelContext typeAnnotation) {
        wSet(SwiftFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public SwiftModelContext getLetOrVarKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.letOrVarKeyword);
    }

    public void setLetOrVarKeyword(SwiftModelContext letOrVarKeyword) {
        wSet(SwiftFeatureDescriptorEnum.letOrVarKeyword, letOrVarKeyword);
    }

    public SwiftModelContext getBindings() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.bindings);
    }

    public void setBindings(SwiftModelContext bindings) {
        wSet(SwiftFeatureDescriptorEnum.bindings, bindings);
    }

    public SwiftModelContext getAssociatedValue() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.associatedValue);
    }

    public void setAssociatedValue(SwiftModelContext associatedValue) {
        wSet(SwiftFeatureDescriptorEnum.associatedValue, associatedValue);
    }

    public SwiftModelContext getRawValue() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.rawValue);
    }

    public void setRawValue(SwiftModelContext rawValue) {
        wSet(SwiftFeatureDescriptorEnum.rawValue, rawValue);
    }

    public SwiftModelContext getGenericParameters() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.genericParameters);
    }

    public void setGenericParameters(SwiftModelContext genericParameters) {
        wSet(SwiftFeatureDescriptorEnum.genericParameters, genericParameters);
    }

    public SwiftModelContext getOperatorIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.operatorIdentifier);
    }

    public void setOperatorIdentifier(SwiftModelContext operatorIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.operatorIdentifier, operatorIdentifier);
    }

    public SwiftModelContext getOperatorPrecedenceAndTypes() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes);
    }

    public void setOperatorPrecedenceAndTypes(SwiftModelContext operatorPrecedenceAndTypes) {
        wSet(SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes, operatorPrecedenceAndTypes);
    }

    public SwiftModelContext getGroupAttributes() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.groupAttributes);
    }

    public void setGroupAttributes(SwiftModelContext groupAttributes) {
        wSet(SwiftFeatureDescriptorEnum.groupAttributes, groupAttributes);
    }

    public SwiftModelContext getHigherThanOrLowerThan() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.higherThanOrLowerThan);
    }

    public void setHigherThanOrLowerThan(SwiftModelContext higherThanOrLowerThan) {
        wSet(SwiftFeatureDescriptorEnum.higherThanOrLowerThan, higherThanOrLowerThan);
    }

    public SwiftModelContext getOtherNames() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.otherNames);
    }

    public void setOtherNames(SwiftModelContext otherNames) {
        wSet(SwiftFeatureDescriptorEnum.otherNames, otherNames);
    }

    public SwiftModelContext getAssignmentKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.assignmentKeyword);
    }

    public void setAssignmentKeyword(SwiftModelContext assignmentKeyword) {
        wSet(SwiftFeatureDescriptorEnum.assignmentKeyword, assignmentKeyword);
    }

    public SwiftModelContext getFlag() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.flag);
    }

    public void setFlag(SwiftModelContext flag) {
        wSet(SwiftFeatureDescriptorEnum.flag, flag);
    }

    public SwiftModelContext getAssociativityKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.associativityKeyword);
    }

    public void setAssociativityKeyword(SwiftModelContext associativityKeyword) {
        wSet(SwiftFeatureDescriptorEnum.associativityKeyword, associativityKeyword);
    }

    public SwiftModelContext getValue() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.value);
    }

    public void setValue(SwiftModelContext value) {
        wSet(SwiftFeatureDescriptorEnum.value, value);
    }

    public SwiftModelContext getAttributeName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.attributeName);
    }

    public void setAttributeName(SwiftModelContext attributeName) {
        wSet(SwiftFeatureDescriptorEnum.attributeName, attributeName);
    }

    public SwiftModelContext getArgument() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.argument);
    }

    public void setArgument(SwiftModelContext argument) {
        wSet(SwiftFeatureDescriptorEnum.argument, argument);
    }

    public SwiftModelContext getDeclBaseName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.declBaseName);
    }

    public void setDeclBaseName(SwiftModelContext declBaseName) {
        wSet(SwiftFeatureDescriptorEnum.declBaseName, declBaseName);
    }

    public SwiftModelContext getNameTok() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.nameTok);
    }

    public void setNameTok(SwiftModelContext nameTok) {
        wSet(SwiftFeatureDescriptorEnum.nameTok, nameTok);
    }

    public SwiftModelContext getStringOrDeclname() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.stringOrDeclname);
    }

    public void setStringOrDeclname(SwiftModelContext stringOrDeclname) {
        wSet(SwiftFeatureDescriptorEnum.stringOrDeclname, stringOrDeclname);
    }

    public SwiftModelContext getLabelName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.labelName);
    }

    public void setLabelName(SwiftModelContext labelName) {
        wSet(SwiftFeatureDescriptorEnum.labelName, labelName);
    }

    public SwiftModelContext getConditions() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.conditions);
    }

    public void setConditions(SwiftModelContext conditions) {
        wSet(SwiftFeatureDescriptorEnum.conditions, conditions);
    }

    public SwiftModelContext getUnknownAttr() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.unknownAttr);
    }

    public void setUnknownAttr(SwiftModelContext unknownAttr) {
        wSet(SwiftFeatureDescriptorEnum.unknownAttr, unknownAttr);
    }

    public SwiftModelContext getCaseKeyword() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.caseKeyword);
    }

    public void setCaseKeyword(SwiftModelContext caseKeyword) {
        wSet(SwiftFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public SwiftModelContext getSequenceExpr() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.sequenceExpr);
    }

    public void setSequenceExpr(SwiftModelContext sequenceExpr) {
        wSet(SwiftFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public SwiftModelContext getWhereClause() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.whereClause);
    }

    public void setWhereClause(SwiftModelContext whereClause) {
        wSet(SwiftFeatureDescriptorEnum.whereClause, whereClause);
    }

    public SwiftModelContext getCases() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.cases);
    }

    public void setCases(SwiftModelContext cases) {
        wSet(SwiftFeatureDescriptorEnum.cases, cases);
    }

    public SwiftModelContext getCatchClauses() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.catchClauses);
    }

    public void setCatchClauses(SwiftModelContext catchClauses) {
        wSet(SwiftFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public SwiftModelContext getYields() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.yields);
    }

    public void setYields(SwiftModelContext yields) {
        wSet(SwiftFeatureDescriptorEnum.yields, yields);
    }

    public SwiftModelContext getAvailabilitySpec() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.availabilitySpec);
    }

    public void setAvailabilitySpec(SwiftModelContext availabilitySpec) {
        wSet(SwiftFeatureDescriptorEnum.availabilitySpec, availabilitySpec);
    }

    public SwiftModelContext getElseBody() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.elseBody);
    }

    public void setElseBody(SwiftModelContext elseBody) {
        wSet(SwiftFeatureDescriptorEnum.elseBody, elseBody);
    }

    public SwiftModelContext getLeftTypeIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.leftTypeIdentifier);
    }

    public void setLeftTypeIdentifier(SwiftModelContext leftTypeIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.leftTypeIdentifier, leftTypeIdentifier);
    }

    public SwiftModelContext getEqualityToken() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.equalityToken);
    }

    public void setEqualityToken(SwiftModelContext equalityToken) {
        wSet(SwiftFeatureDescriptorEnum.equalityToken, equalityToken);
    }

    public SwiftModelContext getRightTypeIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.rightTypeIdentifier);
    }

    public void setRightTypeIdentifier(SwiftModelContext rightTypeIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.rightTypeIdentifier, rightTypeIdentifier);
    }

    public SwiftModelContext getInheritedType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.inheritedType);
    }

    public void setInheritedType(SwiftModelContext inheritedType) {
        wSet(SwiftFeatureDescriptorEnum.inheritedType, inheritedType);
    }

    public SwiftModelContext getBaseType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.baseType);
    }

    public void setBaseType(SwiftModelContext baseType) {
        wSet(SwiftFeatureDescriptorEnum.baseType, baseType);
    }

    public SwiftModelContext getPeriod() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.period);
    }

    public void setPeriod(SwiftModelContext period) {
        wSet(SwiftFeatureDescriptorEnum.period, period);
    }

    public SwiftModelContext getElementType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.elementType);
    }

    public void setElementType(SwiftModelContext elementType) {
        wSet(SwiftFeatureDescriptorEnum.elementType, elementType);
    }

    public SwiftModelContext getKeyType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.keyType);
    }

    public void setKeyType(SwiftModelContext keyType) {
        wSet(SwiftFeatureDescriptorEnum.keyType, keyType);
    }

    public SwiftModelContext getValueType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.valueType);
    }

    public void setValueType(SwiftModelContext valueType) {
        wSet(SwiftFeatureDescriptorEnum.valueType, valueType);
    }

    public SwiftModelContext getTypeOrProtocol() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.typeOrProtocol);
    }

    public void setTypeOrProtocol(SwiftModelContext typeOrProtocol) {
        wSet(SwiftFeatureDescriptorEnum.typeOrProtocol, typeOrProtocol);
    }

    public SwiftModelContext getWrappedType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.wrappedType);
    }

    public void setWrappedType(SwiftModelContext wrappedType) {
        wSet(SwiftFeatureDescriptorEnum.wrappedType, wrappedType);
    }

    public SwiftModelContext getSomeSpecifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.someSpecifier);
    }

    public void setSomeSpecifier(SwiftModelContext someSpecifier) {
        wSet(SwiftFeatureDescriptorEnum.someSpecifier, someSpecifier);
    }

    public SwiftModelContext getAmpersand() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.ampersand);
    }

    public void setAmpersand(SwiftModelContext ampersand) {
        wSet(SwiftFeatureDescriptorEnum.ampersand, ampersand);
    }

    public SwiftModelContext getInOut() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.inOut);
    }

    public void setInOut(SwiftModelContext inOut) {
        wSet(SwiftFeatureDescriptorEnum.inOut, inOut);
    }

    public SwiftModelContext getReturnType() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.returnType);
    }

    public void setReturnType(SwiftModelContext returnType) {
        wSet(SwiftFeatureDescriptorEnum.returnType, returnType);
    }

    public SwiftModelContext getCaseName() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.caseName);
    }

    public void setCaseName(SwiftModelContext caseName) {
        wSet(SwiftFeatureDescriptorEnum.caseName, caseName);
    }

    public SwiftModelContext getAssociatedTuple() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.associatedTuple);
    }

    public void setAssociatedTuple(SwiftModelContext associatedTuple) {
        wSet(SwiftFeatureDescriptorEnum.associatedTuple, associatedTuple);
    }

    public SwiftModelContext getSubPattern() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.subPattern);
    }

    public void setSubPattern(SwiftModelContext subPattern) {
        wSet(SwiftFeatureDescriptorEnum.subPattern, subPattern);
    }

    public SwiftModelContext getPatternIdentifier() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.patternIdentifier);
    }

    public void setPatternIdentifier(SwiftModelContext patternIdentifier) {
        wSet(SwiftFeatureDescriptorEnum.patternIdentifier, patternIdentifier);
    }

    public SwiftModelContext getValuePattern() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.valuePattern);
    }

    public void setValuePattern(SwiftModelContext valuePattern) {
        wSet(SwiftFeatureDescriptorEnum.valuePattern, valuePattern);
    }

    public SwiftModelContext getPlatform() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.platform);
    }

    public void setPlatform(SwiftModelContext platform) {
        wSet(SwiftFeatureDescriptorEnum.platform, platform);
    }

    public SwiftModelContext getVersion() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.version);
    }

    public void setVersion(SwiftModelContext version) {
        wSet(SwiftFeatureDescriptorEnum.version, version);
    }

    public SwiftModelContext getMajorMinor() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.majorMinor);
    }

    public void setMajorMinor(SwiftModelContext majorMinor) {
        wSet(SwiftFeatureDescriptorEnum.majorMinor, majorMinor);
    }

    public SwiftModelContext getPatchVersion() {
        return (SwiftModelContext) wGet(SwiftFeatureDescriptorEnum.patchVersion);
    }

    public void setPatchVersion(SwiftModelContext patchVersion) {
        wSet(SwiftFeatureDescriptorEnum.patchVersion, patchVersion);
    }
}
