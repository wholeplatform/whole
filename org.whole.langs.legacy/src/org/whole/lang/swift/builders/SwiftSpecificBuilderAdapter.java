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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.swift.model.QuestionOrExclamationMarkEnumEnum;
import org.whole.lang.swift.model.IdentifierEnumEnum;
import org.whole.lang.swift.model.DotEnumEnum;
import org.whole.lang.swift.model.OpenQuoteEnumEnum;
import org.whole.lang.swift.model.KindValueEnum;
import org.whole.lang.swift.model.PoundIdentifierEnumEnum;
import org.whole.lang.swift.model.ThrowsOrRethrowsKeywordEnumEnum;
import org.whole.lang.swift.model.PoundKeywordEnumEnum;
import org.whole.lang.swift.model.NameValueEnum;
import org.whole.lang.swift.model.OptionalMarkEnumEnum;
import org.whole.lang.swift.model.ImportKindEnumEnum;
import org.whole.lang.swift.model.AccessorKindValueEnum;
import org.whole.lang.swift.model.LetOrVarKeywordEnumEnum;
import org.whole.lang.swift.model.HigherThanOrLowerThanValueEnum;
import org.whole.lang.swift.model.FlagEnumEnum;
import org.whole.lang.swift.model.ValueValueEnum;
import org.whole.lang.swift.model.NameEnumEnum;
import org.whole.lang.swift.model.PeriodEnumEnum;
import org.whole.lang.swift.model.TypeOrProtocolValueEnum;
import org.whole.lang.swift.model.SpecifierValueEnum;
import org.whole.lang.swift.model.CaptureSpecifierEnumEnum;

/**
 *  @generator Whole
 */
public class SwiftSpecificBuilderAdapter extends GenericBuilderContext implements ISwiftBuilder {

    public SwiftSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public SwiftSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void patchVersion() {
        wFeature(SwiftFeatureDescriptorEnum.patchVersion);
    }

    public void majorMinor() {
        wFeature(SwiftFeatureDescriptorEnum.majorMinor);
    }

    public void version() {
        wFeature(SwiftFeatureDescriptorEnum.version);
    }

    public void platform() {
        wFeature(SwiftFeatureDescriptorEnum.platform);
    }

    public void valuePattern() {
        wFeature(SwiftFeatureDescriptorEnum.valuePattern);
    }

    public void patternIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.patternIdentifier);
    }

    public void subPattern() {
        wFeature(SwiftFeatureDescriptorEnum.subPattern);
    }

    public void associatedTuple() {
        wFeature(SwiftFeatureDescriptorEnum.associatedTuple);
    }

    public void caseName() {
        wFeature(SwiftFeatureDescriptorEnum.caseName);
    }

    public void returnType() {
        wFeature(SwiftFeatureDescriptorEnum.returnType);
    }

    public void inOut() {
        wFeature(SwiftFeatureDescriptorEnum.inOut);
    }

    public void ampersand() {
        wFeature(SwiftFeatureDescriptorEnum.ampersand);
    }

    public void someSpecifier() {
        wFeature(SwiftFeatureDescriptorEnum.someSpecifier);
    }

    public void wrappedType() {
        wFeature(SwiftFeatureDescriptorEnum.wrappedType);
    }

    public void typeOrProtocol() {
        wFeature(SwiftFeatureDescriptorEnum.typeOrProtocol);
    }

    public void valueType() {
        wFeature(SwiftFeatureDescriptorEnum.valueType);
    }

    public void keyType() {
        wFeature(SwiftFeatureDescriptorEnum.keyType);
    }

    public void elementType() {
        wFeature(SwiftFeatureDescriptorEnum.elementType);
    }

    public void period() {
        wFeature(SwiftFeatureDescriptorEnum.period);
    }

    public void baseType() {
        wFeature(SwiftFeatureDescriptorEnum.baseType);
    }

    public void inheritedType() {
        wFeature(SwiftFeatureDescriptorEnum.inheritedType);
    }

    public void rightTypeIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.rightTypeIdentifier);
    }

    public void equalityToken() {
        wFeature(SwiftFeatureDescriptorEnum.equalityToken);
    }

    public void leftTypeIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.leftTypeIdentifier);
    }

    public void elseBody() {
        wFeature(SwiftFeatureDescriptorEnum.elseBody);
    }

    public void availabilitySpec() {
        wFeature(SwiftFeatureDescriptorEnum.availabilitySpec);
    }

    public void yields() {
        wFeature(SwiftFeatureDescriptorEnum.yields);
    }

    public void catchClauses() {
        wFeature(SwiftFeatureDescriptorEnum.catchClauses);
    }

    public void cases() {
        wFeature(SwiftFeatureDescriptorEnum.cases);
    }

    public void whereClause() {
        wFeature(SwiftFeatureDescriptorEnum.whereClause);
    }

    public void sequenceExpr() {
        wFeature(SwiftFeatureDescriptorEnum.sequenceExpr);
    }

    public void caseKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.caseKeyword);
    }

    public void unknownAttr() {
        wFeature(SwiftFeatureDescriptorEnum.unknownAttr);
    }

    public void conditions() {
        wFeature(SwiftFeatureDescriptorEnum.conditions);
    }

    public void labelName() {
        wFeature(SwiftFeatureDescriptorEnum.labelName);
    }

    public void stringOrDeclname() {
        wFeature(SwiftFeatureDescriptorEnum.stringOrDeclname);
    }

    public void nameTok() {
        wFeature(SwiftFeatureDescriptorEnum.nameTok);
    }

    public void declBaseName() {
        wFeature(SwiftFeatureDescriptorEnum.declBaseName);
    }

    public void argument() {
        wFeature(SwiftFeatureDescriptorEnum.argument);
    }

    public void attributeName() {
        wFeature(SwiftFeatureDescriptorEnum.attributeName);
    }

    public void value() {
        wFeature(SwiftFeatureDescriptorEnum.value);
    }

    public void associativityKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.associativityKeyword);
    }

    public void flag() {
        wFeature(SwiftFeatureDescriptorEnum.flag);
    }

    public void assignmentKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.assignmentKeyword);
    }

    public void otherNames() {
        wFeature(SwiftFeatureDescriptorEnum.otherNames);
    }

    public void higherThanOrLowerThan() {
        wFeature(SwiftFeatureDescriptorEnum.higherThanOrLowerThan);
    }

    public void groupAttributes() {
        wFeature(SwiftFeatureDescriptorEnum.groupAttributes);
    }

    public void operatorPrecedenceAndTypes() {
        wFeature(SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes);
    }

    public void operatorIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.operatorIdentifier);
    }

    public void genericParameters() {
        wFeature(SwiftFeatureDescriptorEnum.genericParameters);
    }

    public void rawValue() {
        wFeature(SwiftFeatureDescriptorEnum.rawValue);
    }

    public void associatedValue() {
        wFeature(SwiftFeatureDescriptorEnum.associatedValue);
    }

    public void bindings() {
        wFeature(SwiftFeatureDescriptorEnum.bindings);
    }

    public void letOrVarKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.letOrVarKeyword);
    }

    public void typeAnnotation() {
        wFeature(SwiftFeatureDescriptorEnum.typeAnnotation);
    }

    public void parameter() {
        wFeature(SwiftFeatureDescriptorEnum.parameter);
    }

    public void accessorKind() {
        wFeature(SwiftFeatureDescriptorEnum.accessorKind);
    }

    public void path() {
        wFeature(SwiftFeatureDescriptorEnum.path);
    }

    public void importKind() {
        wFeature(SwiftFeatureDescriptorEnum.importKind);
    }

    public void modifier() {
        wFeature(SwiftFeatureDescriptorEnum.modifier);
    }

    public void accessor() {
        wFeature(SwiftFeatureDescriptorEnum.accessor);
    }

    public void result() {
        wFeature(SwiftFeatureDescriptorEnum.result);
    }

    public void indices() {
        wFeature(SwiftFeatureDescriptorEnum.indices);
    }

    public void parameters() {
        wFeature(SwiftFeatureDescriptorEnum.parameters);
    }

    public void optionalMark() {
        wFeature(SwiftFeatureDescriptorEnum.optionalMark);
    }

    public void body() {
        wFeature(SwiftFeatureDescriptorEnum.body);
    }

    public void functionIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.functionIdentifier);
    }

    public void defaultArgument() {
        wFeature(SwiftFeatureDescriptorEnum.defaultArgument);
    }

    public void ellipsis() {
        wFeature(SwiftFeatureDescriptorEnum.ellipsis);
    }

    public void secondName() {
        wFeature(SwiftFeatureDescriptorEnum.secondName);
    }

    public void firstName() {
        wFeature(SwiftFeatureDescriptorEnum.firstName);
    }

    public void extendedType() {
        wFeature(SwiftFeatureDescriptorEnum.extendedType);
    }

    public void members() {
        wFeature(SwiftFeatureDescriptorEnum.members);
    }

    public void detail() {
        wFeature(SwiftFeatureDescriptorEnum.detail);
    }

    public void lineNumber() {
        wFeature(SwiftFeatureDescriptorEnum.lineNumber);
    }

    public void lineArgLabel() {
        wFeature(SwiftFeatureDescriptorEnum.lineArgLabel);
    }

    public void fileName() {
        wFeature(SwiftFeatureDescriptorEnum.fileName);
    }

    public void fileArgLabel() {
        wFeature(SwiftFeatureDescriptorEnum.fileArgLabel);
    }

    public void args() {
        wFeature(SwiftFeatureDescriptorEnum.args);
    }

    public void message() {
        wFeature(SwiftFeatureDescriptorEnum.message);
    }

    public void elements() {
        wFeature(SwiftFeatureDescriptorEnum.elements);
    }

    public void condition() {
        wFeature(SwiftFeatureDescriptorEnum.condition);
    }

    public void poundKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.poundKeyword);
    }

    public void throwsOrRethrowsKeyword() {
        wFeature(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword);
    }

    public void inheritanceClause() {
        wFeature(SwiftFeatureDescriptorEnum.inheritanceClause);
    }

    public void genericWhereClause() {
        wFeature(SwiftFeatureDescriptorEnum.genericWhereClause);
    }

    public void initializer() {
        wFeature(SwiftFeatureDescriptorEnum.initializer);
    }

    public void genericParameterClause() {
        wFeature(SwiftFeatureDescriptorEnum.genericParameterClause);
    }

    public void modifiers() {
        wFeature(SwiftFeatureDescriptorEnum.modifiers);
    }

    public void attributes() {
        wFeature(SwiftFeatureDescriptorEnum.attributes);
    }

    public void arguments() {
        wFeature(SwiftFeatureDescriptorEnum.arguments);
    }

    public void poundIdentifier() {
        wFeature(SwiftFeatureDescriptorEnum.poundIdentifier);
    }

    public void kind() {
        wFeature(SwiftFeatureDescriptorEnum.kind);
    }

    public void rootExpr() {
        wFeature(SwiftFeatureDescriptorEnum.rootExpr);
    }

    public void segments() {
        wFeature(SwiftFeatureDescriptorEnum.segments);
    }

    public void openQuote() {
        wFeature(SwiftFeatureDescriptorEnum.openQuote);
    }

    public void openDelimiter() {
        wFeature(SwiftFeatureDescriptorEnum.openDelimiter);
    }

    public void trailingClosure() {
        wFeature(SwiftFeatureDescriptorEnum.trailingClosure);
    }

    public void argumentList() {
        wFeature(SwiftFeatureDescriptorEnum.argumentList);
    }

    public void calledExpression() {
        wFeature(SwiftFeatureDescriptorEnum.calledExpression);
    }

    public void pattern() {
        wFeature(SwiftFeatureDescriptorEnum.pattern);
    }

    public void statements() {
        wFeature(SwiftFeatureDescriptorEnum.statements);
    }

    public void signature() {
        wFeature(SwiftFeatureDescriptorEnum.signature);
    }

    public void output() {
        wFeature(SwiftFeatureDescriptorEnum.output);
    }

    public void throwsTok() {
        wFeature(SwiftFeatureDescriptorEnum.throwsTok);
    }

    public void input() {
        wFeature(SwiftFeatureDescriptorEnum.input);
    }

    public void capture() {
        wFeature(SwiftFeatureDescriptorEnum.capture);
    }

    public void specifier() {
        wFeature(SwiftFeatureDescriptorEnum.specifier);
    }

    public void type() {
        wFeature(SwiftFeatureDescriptorEnum.type);
    }

    public void typeName() {
        wFeature(SwiftFeatureDescriptorEnum.typeName);
    }

    public void name() {
        wFeature(SwiftFeatureDescriptorEnum.name);
    }

    public void dot() {
        wFeature(SwiftFeatureDescriptorEnum.dot);
    }

    public void base() {
        wFeature(SwiftFeatureDescriptorEnum.base);
    }

    public void secondChoice() {
        wFeature(SwiftFeatureDescriptorEnum.secondChoice);
    }

    public void firstChoice() {
        wFeature(SwiftFeatureDescriptorEnum.firstChoice);
    }

    public void conditionExpression() {
        wFeature(SwiftFeatureDescriptorEnum.conditionExpression);
    }

    public void valueExpression() {
        wFeature(SwiftFeatureDescriptorEnum.valueExpression);
    }

    public void keyExpression() {
        wFeature(SwiftFeatureDescriptorEnum.keyExpression);
    }

    public void label() {
        wFeature(SwiftFeatureDescriptorEnum.label);
    }

    public void throwsToken() {
        wFeature(SwiftFeatureDescriptorEnum.throwsToken);
    }

    public void postfixExpression() {
        wFeature(SwiftFeatureDescriptorEnum.postfixExpression);
    }

    public void operatorToken() {
        wFeature(SwiftFeatureDescriptorEnum.operatorToken);
    }

    public void genericArgumentClause() {
        wFeature(SwiftFeatureDescriptorEnum.genericArgumentClause);
    }

    public void declNameArguments() {
        wFeature(SwiftFeatureDescriptorEnum.declNameArguments);
    }

    public void identifier() {
        wFeature(SwiftFeatureDescriptorEnum.identifier);
    }

    public void questionOrExclamationMark() {
        wFeature(SwiftFeatureDescriptorEnum.questionOrExclamationMark);
    }

    public void expressions() {
        wFeature(SwiftFeatureDescriptorEnum.expressions);
    }

    public void delimiter() {
        wFeature(SwiftFeatureDescriptorEnum.delimiter);
    }

    public void expression() {
        wFeature(SwiftFeatureDescriptorEnum.expression);
    }

    public void visit() {
    }

    public void BooleanLiteral() {
        wEntity(SwiftEntityDescriptorEnum.BooleanLiteral);
    }

    public void BooleanLiteral(boolean value) {
        wEntity(SwiftEntityDescriptorEnum.BooleanLiteral, value);
    }

    public void IntegerLiteral() {
        wEntity(SwiftEntityDescriptorEnum.IntegerLiteral);
    }

    public void IntegerLiteral(long value) {
        wEntity(SwiftEntityDescriptorEnum.IntegerLiteral, value);
    }

    public void FloatingLiteral() {
        wEntity(SwiftEntityDescriptorEnum.FloatingLiteral);
    }

    public void FloatingLiteral(double value) {
        wEntity(SwiftEntityDescriptorEnum.FloatingLiteral, value);
    }

    public void StringLiteral() {
        wEntity(SwiftEntityDescriptorEnum.StringLiteral);
    }

    public void StringLiteral(String value) {
        wEntity(SwiftEntityDescriptorEnum.StringLiteral, value);
    }

    public void Identifier() {
        wEntity(SwiftEntityDescriptorEnum.Identifier);
    }

    public void Identifier(String value) {
        wEntity(SwiftEntityDescriptorEnum.Identifier, value);
    }

    public void BinaryOperator() {
        wEntity(SwiftEntityDescriptorEnum.BinaryOperator);
    }

    public void BinaryOperator(String value) {
        wEntity(SwiftEntityDescriptorEnum.BinaryOperator, value);
    }

    public void PostfixOperator() {
        wEntity(SwiftEntityDescriptorEnum.PostfixOperator);
    }

    public void PostfixOperator(String value) {
        wEntity(SwiftEntityDescriptorEnum.PostfixOperator, value);
    }

    public void PrefixOperator() {
        wEntity(SwiftEntityDescriptorEnum.PrefixOperator);
    }

    public void PrefixOperator(String value) {
        wEntity(SwiftEntityDescriptorEnum.PrefixOperator, value);
    }

    public void DollarIdentifier() {
        wEntity(SwiftEntityDescriptorEnum.DollarIdentifier);
    }

    public void DollarIdentifier(String value) {
        wEntity(SwiftEntityDescriptorEnum.DollarIdentifier, value);
    }

    public void RawStringDelimiter() {
        wEntity(SwiftEntityDescriptorEnum.RawStringDelimiter);
    }

    public void RawStringDelimiter(String value) {
        wEntity(SwiftEntityDescriptorEnum.RawStringDelimiter, value);
    }

    public void CodeBlockItemList() {
        wEntity(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public void CodeBlockItemList_() {
        wEntity_(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public void CodeBlockItemList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.CodeBlockItemList, initialCapacity);
    }

    public void _CodeBlockItemList() {
        _wEntity(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public void InOutExpr() {
        wEntity(SwiftEntityDescriptorEnum.InOutExpr);
    }

    public void InOutExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.InOutExpr);
    }

    public void _InOutExpr() {
        _wEntity(SwiftEntityDescriptorEnum.InOutExpr);
    }

    public void PoundColumnExpr() {
        wEntity(SwiftEntityDescriptorEnum.PoundColumnExpr);
    }

    public void PoundColumnExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundColumnExpr);
    }

    public void _PoundColumnExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PoundColumnExpr);
    }

    public void FunctionCallArgumentList() {
        wEntity(SwiftEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void FunctionCallArgumentList_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void FunctionCallArgumentList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.FunctionCallArgumentList, initialCapacity);
    }

    public void _FunctionCallArgumentList() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void StringLiteralSegments() {
        wEntity(SwiftEntityDescriptorEnum.StringLiteralSegments);
    }

    public void StringLiteralSegments_() {
        wEntity_(SwiftEntityDescriptorEnum.StringLiteralSegments);
    }

    public void StringLiteralSegments_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.StringLiteralSegments, initialCapacity);
    }

    public void _StringLiteralSegments() {
        _wEntity(SwiftEntityDescriptorEnum.StringLiteralSegments);
    }

    public void ExpressionSegment() {
        wEntity(SwiftEntityDescriptorEnum.ExpressionSegment);
    }

    public void ExpressionSegment_() {
        wEntity_(SwiftEntityDescriptorEnum.ExpressionSegment);
    }

    public void _ExpressionSegment() {
        _wEntity(SwiftEntityDescriptorEnum.ExpressionSegment);
    }

    public void TryExpr() {
        wEntity(SwiftEntityDescriptorEnum.TryExpr);
    }

    public void TryExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.TryExpr);
    }

    public void _TryExpr() {
        _wEntity(SwiftEntityDescriptorEnum.TryExpr);
    }

    public void QuestionOrExclamationMarkEnum() {
        wEntity(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum);
    }

    public void QuestionOrExclamationMarkEnum(QuestionOrExclamationMarkEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum, value);
    }

    public void QuestionOrExclamationMarkEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum, value);
    }

    public void DeclNameArgumentList() {
        wEntity(SwiftEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void DeclNameArgumentList_() {
        wEntity_(SwiftEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void DeclNameArgumentList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.DeclNameArgumentList, initialCapacity);
    }

    public void _DeclNameArgumentList() {
        _wEntity(SwiftEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void IdentifierExpr() {
        wEntity(SwiftEntityDescriptorEnum.IdentifierExpr);
    }

    public void IdentifierExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.IdentifierExpr);
    }

    public void _IdentifierExpr() {
        _wEntity(SwiftEntityDescriptorEnum.IdentifierExpr);
    }

    public void IdentifierEnum() {
        wEntity(SwiftEntityDescriptorEnum.IdentifierEnum);
    }

    public void IdentifierEnum(IdentifierEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.IdentifierEnum, value);
    }

    public void IdentifierEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.IdentifierEnum, value);
    }

    public void SuperRefExpr() {
        wEntity(SwiftEntityDescriptorEnum.SuperRefExpr);
    }

    public void SuperRefExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.SuperRefExpr);
    }

    public void _SuperRefExpr() {
        _wEntity(SwiftEntityDescriptorEnum.SuperRefExpr);
    }

    public void NilLiteralExpr() {
        wEntity(SwiftEntityDescriptorEnum.NilLiteralExpr);
    }

    public void NilLiteralExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.NilLiteralExpr);
    }

    public void _NilLiteralExpr() {
        _wEntity(SwiftEntityDescriptorEnum.NilLiteralExpr);
    }

    public void DiscardAssignmentExpr() {
        wEntity(SwiftEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void DiscardAssignmentExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void _DiscardAssignmentExpr() {
        _wEntity(SwiftEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void AssignmentExpr() {
        wEntity(SwiftEntityDescriptorEnum.AssignmentExpr);
    }

    public void AssignmentExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.AssignmentExpr);
    }

    public void _AssignmentExpr() {
        _wEntity(SwiftEntityDescriptorEnum.AssignmentExpr);
    }

    public void SequenceExpr() {
        wEntity(SwiftEntityDescriptorEnum.SequenceExpr);
    }

    public void SequenceExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.SequenceExpr);
    }

    public void SequenceExpr_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.SequenceExpr, initialCapacity);
    }

    public void _SequenceExpr() {
        _wEntity(SwiftEntityDescriptorEnum.SequenceExpr);
    }

    public void PoundLineExpr() {
        wEntity(SwiftEntityDescriptorEnum.PoundLineExpr);
    }

    public void PoundLineExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundLineExpr);
    }

    public void _PoundLineExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PoundLineExpr);
    }

    public void PoundFileExpr() {
        wEntity(SwiftEntityDescriptorEnum.PoundFileExpr);
    }

    public void PoundFileExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundFileExpr);
    }

    public void _PoundFileExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PoundFileExpr);
    }

    public void PoundFunctionExpr() {
        wEntity(SwiftEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void PoundFunctionExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void _PoundFunctionExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void PoundDsohandleExpr() {
        wEntity(SwiftEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void PoundDsohandleExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void _PoundDsohandleExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void SymbolicReferenceExpr() {
        wEntity(SwiftEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void SymbolicReferenceExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void _SymbolicReferenceExpr() {
        _wEntity(SwiftEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void PrefixOperatorExpr() {
        wEntity(SwiftEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void PrefixOperatorExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void _PrefixOperatorExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void BinaryOperatorExpr() {
        wEntity(SwiftEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void BinaryOperatorExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void _BinaryOperatorExpr() {
        _wEntity(SwiftEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void ArrowExpr() {
        wEntity(SwiftEntityDescriptorEnum.ArrowExpr);
    }

    public void ArrowExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ArrowExpr);
    }

    public void _ArrowExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ArrowExpr);
    }

    public void Throws() {
        wEntity(SwiftEntityDescriptorEnum.Throws);
    }

    public void Throws_() {
        wEntity_(SwiftEntityDescriptorEnum.Throws);
    }

    public void _Throws() {
        _wEntity(SwiftEntityDescriptorEnum.Throws);
    }

    public void TupleExpr() {
        wEntity(SwiftEntityDescriptorEnum.TupleExpr);
    }

    public void TupleExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.TupleExpr);
    }

    public void TupleExpr_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.TupleExpr, initialCapacity);
    }

    public void _TupleExpr() {
        _wEntity(SwiftEntityDescriptorEnum.TupleExpr);
    }

    public void ArrayExpr() {
        wEntity(SwiftEntityDescriptorEnum.ArrayExpr);
    }

    public void ArrayExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ArrayExpr);
    }

    public void ArrayExpr_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ArrayExpr, initialCapacity);
    }

    public void _ArrayExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ArrayExpr);
    }

    public void DictionaryExpr() {
        wEntity(SwiftEntityDescriptorEnum.DictionaryExpr);
    }

    public void DictionaryExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.DictionaryExpr);
    }

    public void DictionaryExpr_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.DictionaryExpr, initialCapacity);
    }

    public void _DictionaryExpr() {
        _wEntity(SwiftEntityDescriptorEnum.DictionaryExpr);
    }

    public void FunctionCallArgument() {
        wEntity(SwiftEntityDescriptorEnum.FunctionCallArgument);
    }

    public void FunctionCallArgument_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionCallArgument);
    }

    public void _FunctionCallArgument() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionCallArgument);
    }

    public void TupleElement() {
        wEntity(SwiftEntityDescriptorEnum.TupleElement);
    }

    public void TupleElement_() {
        wEntity_(SwiftEntityDescriptorEnum.TupleElement);
    }

    public void _TupleElement() {
        _wEntity(SwiftEntityDescriptorEnum.TupleElement);
    }

    public void DictionaryElement() {
        wEntity(SwiftEntityDescriptorEnum.DictionaryElement);
    }

    public void DictionaryElement_() {
        wEntity_(SwiftEntityDescriptorEnum.DictionaryElement);
    }

    public void _DictionaryElement() {
        _wEntity(SwiftEntityDescriptorEnum.DictionaryElement);
    }

    public void TernaryExpr() {
        wEntity(SwiftEntityDescriptorEnum.TernaryExpr);
    }

    public void TernaryExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.TernaryExpr);
    }

    public void _TernaryExpr() {
        _wEntity(SwiftEntityDescriptorEnum.TernaryExpr);
    }

    public void MemberAccessExpr() {
        wEntity(SwiftEntityDescriptorEnum.MemberAccessExpr);
    }

    public void MemberAccessExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.MemberAccessExpr);
    }

    public void _MemberAccessExpr() {
        _wEntity(SwiftEntityDescriptorEnum.MemberAccessExpr);
    }

    public void DotEnum() {
        wEntity(SwiftEntityDescriptorEnum.DotEnum);
    }

    public void DotEnum(DotEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.DotEnum, value);
    }

    public void DotEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.DotEnum, value);
    }

    public void IsExpr() {
        wEntity(SwiftEntityDescriptorEnum.IsExpr);
    }

    public void IsExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.IsExpr);
    }

    public void _IsExpr() {
        _wEntity(SwiftEntityDescriptorEnum.IsExpr);
    }

    public void AsExpr() {
        wEntity(SwiftEntityDescriptorEnum.AsExpr);
    }

    public void AsExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.AsExpr);
    }

    public void _AsExpr() {
        _wEntity(SwiftEntityDescriptorEnum.AsExpr);
    }

    public void TypeExpr() {
        wEntity(SwiftEntityDescriptorEnum.TypeExpr);
    }

    public void TypeExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.TypeExpr);
    }

    public void _TypeExpr() {
        _wEntity(SwiftEntityDescriptorEnum.TypeExpr);
    }

    public void ClosureCaptureItem() {
        wEntity(SwiftEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void ClosureCaptureItem_() {
        wEntity_(SwiftEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void _ClosureCaptureItem() {
        _wEntity(SwiftEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void ClosureCaptureItemList() {
        wEntity(SwiftEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void ClosureCaptureItemList_() {
        wEntity_(SwiftEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void ClosureCaptureItemList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ClosureCaptureItemList, initialCapacity);
    }

    public void _ClosureCaptureItemList() {
        _wEntity(SwiftEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void WildcardMarker() {
        wEntity(SwiftEntityDescriptorEnum.WildcardMarker);
    }

    public void WildcardMarker_() {
        wEntity_(SwiftEntityDescriptorEnum.WildcardMarker);
    }

    public void _WildcardMarker() {
        _wEntity(SwiftEntityDescriptorEnum.WildcardMarker);
    }

    public void ClosureParamList() {
        wEntity(SwiftEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureParamList_() {
        wEntity_(SwiftEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureParamList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ClosureParamList, initialCapacity);
    }

    public void _ClosureParamList() {
        _wEntity(SwiftEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureSignature() {
        wEntity(SwiftEntityDescriptorEnum.ClosureSignature);
    }

    public void ClosureSignature_() {
        wEntity_(SwiftEntityDescriptorEnum.ClosureSignature);
    }

    public void _ClosureSignature() {
        _wEntity(SwiftEntityDescriptorEnum.ClosureSignature);
    }

    public void ClosureExpr() {
        wEntity(SwiftEntityDescriptorEnum.ClosureExpr);
    }

    public void ClosureExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ClosureExpr);
    }

    public void _ClosureExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ClosureExpr);
    }

    public void UnresolvedPatternExpr() {
        wEntity(SwiftEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void UnresolvedPatternExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void _UnresolvedPatternExpr() {
        _wEntity(SwiftEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void FunctionCallExpr() {
        wEntity(SwiftEntityDescriptorEnum.FunctionCallExpr);
    }

    public void FunctionCallExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionCallExpr);
    }

    public void _FunctionCallExpr() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionCallExpr);
    }

    public void SubscriptExpr() {
        wEntity(SwiftEntityDescriptorEnum.SubscriptExpr);
    }

    public void SubscriptExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.SubscriptExpr);
    }

    public void _SubscriptExpr() {
        _wEntity(SwiftEntityDescriptorEnum.SubscriptExpr);
    }

    public void OptionalChainingExpr() {
        wEntity(SwiftEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void OptionalChainingExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void _OptionalChainingExpr() {
        _wEntity(SwiftEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void ForcedValueExpr() {
        wEntity(SwiftEntityDescriptorEnum.ForcedValueExpr);
    }

    public void ForcedValueExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ForcedValueExpr);
    }

    public void _ForcedValueExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ForcedValueExpr);
    }

    public void PostfixUnaryExpr() {
        wEntity(SwiftEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void PostfixUnaryExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void _PostfixUnaryExpr() {
        _wEntity(SwiftEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void SpecializeExpr() {
        wEntity(SwiftEntityDescriptorEnum.SpecializeExpr);
    }

    public void SpecializeExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.SpecializeExpr);
    }

    public void _SpecializeExpr() {
        _wEntity(SwiftEntityDescriptorEnum.SpecializeExpr);
    }

    public void StringLiteralExpr() {
        wEntity(SwiftEntityDescriptorEnum.StringLiteralExpr);
    }

    public void StringLiteralExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.StringLiteralExpr);
    }

    public void _StringLiteralExpr() {
        _wEntity(SwiftEntityDescriptorEnum.StringLiteralExpr);
    }

    public void OpenQuoteEnum() {
        wEntity(SwiftEntityDescriptorEnum.OpenQuoteEnum);
    }

    public void OpenQuoteEnum(OpenQuoteEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.OpenQuoteEnum, value);
    }

    public void OpenQuoteEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.OpenQuoteEnum, value);
    }

    public void KeyPathExpr() {
        wEntity(SwiftEntityDescriptorEnum.KeyPathExpr);
    }

    public void KeyPathExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.KeyPathExpr);
    }

    public void _KeyPathExpr() {
        _wEntity(SwiftEntityDescriptorEnum.KeyPathExpr);
    }

    public void KeyPathBaseExpr() {
        wEntity(SwiftEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void KeyPathBaseExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void _KeyPathBaseExpr() {
        _wEntity(SwiftEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void ObjcKeyPathExpr() {
        wEntity(SwiftEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void ObjcKeyPathExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void ObjcKeyPathExpr_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ObjcKeyPathExpr, initialCapacity);
    }

    public void _ObjcKeyPathExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void ObjcSelectorExpr() {
        wEntity(SwiftEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void ObjcSelectorExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void _ObjcSelectorExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void KindValue() {
        wEntity(SwiftEntityDescriptorEnum.KindValue);
    }

    public void KindValue(KindValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.KindValue, value);
    }

    public void KindValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.KindValue, value);
    }

    public void EditorPlaceholderExpr() {
        wEntity(SwiftEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void EditorPlaceholderExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void _EditorPlaceholderExpr() {
        _wEntity(SwiftEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void ObjectLiteralExpr() {
        wEntity(SwiftEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void ObjectLiteralExpr_() {
        wEntity_(SwiftEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void _ObjectLiteralExpr() {
        _wEntity(SwiftEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void PoundIdentifierEnum() {
        wEntity(SwiftEntityDescriptorEnum.PoundIdentifierEnum);
    }

    public void PoundIdentifierEnum(PoundIdentifierEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.PoundIdentifierEnum, value);
    }

    public void PoundIdentifierEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.PoundIdentifierEnum, value);
    }

    public void TypealiasDecl() {
        wEntity(SwiftEntityDescriptorEnum.TypealiasDecl);
    }

    public void TypealiasDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.TypealiasDecl);
    }

    public void _TypealiasDecl() {
        _wEntity(SwiftEntityDescriptorEnum.TypealiasDecl);
    }

    public void AssociatedtypeDecl() {
        wEntity(SwiftEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void AssociatedtypeDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void _AssociatedtypeDecl() {
        _wEntity(SwiftEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void FunctionParameterList() {
        wEntity(SwiftEntityDescriptorEnum.FunctionParameterList);
    }

    public void FunctionParameterList_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionParameterList);
    }

    public void FunctionParameterList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.FunctionParameterList, initialCapacity);
    }

    public void _FunctionParameterList() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionParameterList);
    }

    public void FunctionSignature() {
        wEntity(SwiftEntityDescriptorEnum.FunctionSignature);
    }

    public void FunctionSignature_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionSignature);
    }

    public void _FunctionSignature() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionSignature);
    }

    public void ThrowsOrRethrowsKeywordEnum() {
        wEntity(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum);
    }

    public void ThrowsOrRethrowsKeywordEnum(ThrowsOrRethrowsKeywordEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum, value);
    }

    public void ThrowsOrRethrowsKeywordEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum, value);
    }

    public void IfConfigClause() {
        wEntity(SwiftEntityDescriptorEnum.IfConfigClause);
    }

    public void IfConfigClause_() {
        wEntity_(SwiftEntityDescriptorEnum.IfConfigClause);
    }

    public void _IfConfigClause() {
        _wEntity(SwiftEntityDescriptorEnum.IfConfigClause);
    }

    public void PoundKeywordEnum() {
        wEntity(SwiftEntityDescriptorEnum.PoundKeywordEnum);
    }

    public void PoundKeywordEnum(PoundKeywordEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.PoundKeywordEnum, value);
    }

    public void PoundKeywordEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.PoundKeywordEnum, value);
    }

    public void SwitchCaseList() {
        wEntity(SwiftEntityDescriptorEnum.SwitchCaseList);
    }

    public void SwitchCaseList_() {
        wEntity_(SwiftEntityDescriptorEnum.SwitchCaseList);
    }

    public void SwitchCaseList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.SwitchCaseList, initialCapacity);
    }

    public void _SwitchCaseList() {
        _wEntity(SwiftEntityDescriptorEnum.SwitchCaseList);
    }

    public void MemberDeclList() {
        wEntity(SwiftEntityDescriptorEnum.MemberDeclList);
    }

    public void MemberDeclList_() {
        wEntity_(SwiftEntityDescriptorEnum.MemberDeclList);
    }

    public void MemberDeclList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.MemberDeclList, initialCapacity);
    }

    public void _MemberDeclList() {
        _wEntity(SwiftEntityDescriptorEnum.MemberDeclList);
    }

    public void IfConfigDecl() {
        wEntity(SwiftEntityDescriptorEnum.IfConfigDecl);
    }

    public void IfConfigDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.IfConfigDecl);
    }

    public void IfConfigDecl_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.IfConfigDecl, initialCapacity);
    }

    public void _IfConfigDecl() {
        _wEntity(SwiftEntityDescriptorEnum.IfConfigDecl);
    }

    public void PoundErrorDecl() {
        wEntity(SwiftEntityDescriptorEnum.PoundErrorDecl);
    }

    public void PoundErrorDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundErrorDecl);
    }

    public void _PoundErrorDecl() {
        _wEntity(SwiftEntityDescriptorEnum.PoundErrorDecl);
    }

    public void PoundWarningDecl() {
        wEntity(SwiftEntityDescriptorEnum.PoundWarningDecl);
    }

    public void PoundWarningDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundWarningDecl);
    }

    public void _PoundWarningDecl() {
        _wEntity(SwiftEntityDescriptorEnum.PoundWarningDecl);
    }

    public void PoundSourceLocation() {
        wEntity(SwiftEntityDescriptorEnum.PoundSourceLocation);
    }

    public void PoundSourceLocation_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundSourceLocation);
    }

    public void _PoundSourceLocation() {
        _wEntity(SwiftEntityDescriptorEnum.PoundSourceLocation);
    }

    public void PoundSourceLocationArgs() {
        wEntity(SwiftEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void PoundSourceLocationArgs_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void _PoundSourceLocationArgs() {
        _wEntity(SwiftEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void DeclModifier() {
        wEntity(SwiftEntityDescriptorEnum.DeclModifier);
    }

    public void DeclModifier_() {
        wEntity_(SwiftEntityDescriptorEnum.DeclModifier);
    }

    public void _DeclModifier() {
        _wEntity(SwiftEntityDescriptorEnum.DeclModifier);
    }

    public void NameValue() {
        wEntity(SwiftEntityDescriptorEnum.NameValue);
    }

    public void NameValue(NameValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.NameValue, value);
    }

    public void NameValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.NameValue, value);
    }

    public void InheritedTypeList() {
        wEntity(SwiftEntityDescriptorEnum.InheritedTypeList);
    }

    public void InheritedTypeList_() {
        wEntity_(SwiftEntityDescriptorEnum.InheritedTypeList);
    }

    public void InheritedTypeList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.InheritedTypeList, initialCapacity);
    }

    public void _InheritedTypeList() {
        _wEntity(SwiftEntityDescriptorEnum.InheritedTypeList);
    }

    public void ClassDecl() {
        wEntity(SwiftEntityDescriptorEnum.ClassDecl);
    }

    public void ClassDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.ClassDecl);
    }

    public void _ClassDecl() {
        _wEntity(SwiftEntityDescriptorEnum.ClassDecl);
    }

    public void StructDecl() {
        wEntity(SwiftEntityDescriptorEnum.StructDecl);
    }

    public void StructDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.StructDecl);
    }

    public void _StructDecl() {
        _wEntity(SwiftEntityDescriptorEnum.StructDecl);
    }

    public void ProtocolDecl() {
        wEntity(SwiftEntityDescriptorEnum.ProtocolDecl);
    }

    public void ProtocolDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.ProtocolDecl);
    }

    public void _ProtocolDecl() {
        _wEntity(SwiftEntityDescriptorEnum.ProtocolDecl);
    }

    public void ExtensionDecl() {
        wEntity(SwiftEntityDescriptorEnum.ExtensionDecl);
    }

    public void ExtensionDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.ExtensionDecl);
    }

    public void _ExtensionDecl() {
        _wEntity(SwiftEntityDescriptorEnum.ExtensionDecl);
    }

    public void SourceFile() {
        wEntity(SwiftEntityDescriptorEnum.SourceFile);
    }

    public void SourceFile_() {
        wEntity_(SwiftEntityDescriptorEnum.SourceFile);
    }

    public void _SourceFile() {
        _wEntity(SwiftEntityDescriptorEnum.SourceFile);
    }

    public void FunctionParameter() {
        wEntity(SwiftEntityDescriptorEnum.FunctionParameter);
    }

    public void FunctionParameter_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionParameter);
    }

    public void _FunctionParameter() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionParameter);
    }

    public void Ellipsis() {
        wEntity(SwiftEntityDescriptorEnum.Ellipsis);
    }

    public void Ellipsis_() {
        wEntity_(SwiftEntityDescriptorEnum.Ellipsis);
    }

    public void _Ellipsis() {
        _wEntity(SwiftEntityDescriptorEnum.Ellipsis);
    }

    public void ModifierList() {
        wEntity(SwiftEntityDescriptorEnum.ModifierList);
    }

    public void ModifierList_() {
        wEntity_(SwiftEntityDescriptorEnum.ModifierList);
    }

    public void ModifierList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ModifierList, initialCapacity);
    }

    public void _ModifierList() {
        _wEntity(SwiftEntityDescriptorEnum.ModifierList);
    }

    public void FunctionDecl() {
        wEntity(SwiftEntityDescriptorEnum.FunctionDecl);
    }

    public void FunctionDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionDecl);
    }

    public void _FunctionDecl() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionDecl);
    }

    public void InitializerDecl() {
        wEntity(SwiftEntityDescriptorEnum.InitializerDecl);
    }

    public void InitializerDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.InitializerDecl);
    }

    public void _InitializerDecl() {
        _wEntity(SwiftEntityDescriptorEnum.InitializerDecl);
    }

    public void OptionalMarkEnum() {
        wEntity(SwiftEntityDescriptorEnum.OptionalMarkEnum);
    }

    public void OptionalMarkEnum(OptionalMarkEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.OptionalMarkEnum, value);
    }

    public void OptionalMarkEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.OptionalMarkEnum, value);
    }

    public void DeinitializerDecl() {
        wEntity(SwiftEntityDescriptorEnum.DeinitializerDecl);
    }

    public void DeinitializerDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.DeinitializerDecl);
    }

    public void _DeinitializerDecl() {
        _wEntity(SwiftEntityDescriptorEnum.DeinitializerDecl);
    }

    public void SubscriptDecl() {
        wEntity(SwiftEntityDescriptorEnum.SubscriptDecl);
    }

    public void SubscriptDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.SubscriptDecl);
    }

    public void _SubscriptDecl() {
        _wEntity(SwiftEntityDescriptorEnum.SubscriptDecl);
    }

    public void AccessorBlock() {
        wEntity(SwiftEntityDescriptorEnum.AccessorBlock);
    }

    public void AccessorBlock_() {
        wEntity_(SwiftEntityDescriptorEnum.AccessorBlock);
    }

    public void AccessorBlock_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.AccessorBlock, initialCapacity);
    }

    public void _AccessorBlock() {
        _wEntity(SwiftEntityDescriptorEnum.AccessorBlock);
    }

    public void AccessLevelModifier() {
        wEntity(SwiftEntityDescriptorEnum.AccessLevelModifier);
    }

    public void AccessLevelModifier_() {
        wEntity_(SwiftEntityDescriptorEnum.AccessLevelModifier);
    }

    public void _AccessLevelModifier() {
        _wEntity(SwiftEntityDescriptorEnum.AccessLevelModifier);
    }

    public void AccessPath() {
        wEntity(SwiftEntityDescriptorEnum.AccessPath);
    }

    public void AccessPath_() {
        wEntity_(SwiftEntityDescriptorEnum.AccessPath);
    }

    public void AccessPath_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.AccessPath, initialCapacity);
    }

    public void _AccessPath() {
        _wEntity(SwiftEntityDescriptorEnum.AccessPath);
    }

    public void ImportDecl() {
        wEntity(SwiftEntityDescriptorEnum.ImportDecl);
    }

    public void ImportDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.ImportDecl);
    }

    public void _ImportDecl() {
        _wEntity(SwiftEntityDescriptorEnum.ImportDecl);
    }

    public void ImportKindEnum() {
        wEntity(SwiftEntityDescriptorEnum.ImportKindEnum);
    }

    public void ImportKindEnum(ImportKindEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.ImportKindEnum, value);
    }

    public void ImportKindEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.ImportKindEnum, value);
    }

    public void AccessorDecl() {
        wEntity(SwiftEntityDescriptorEnum.AccessorDecl);
    }

    public void AccessorDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.AccessorDecl);
    }

    public void _AccessorDecl() {
        _wEntity(SwiftEntityDescriptorEnum.AccessorDecl);
    }

    public void AccessorKindValue() {
        wEntity(SwiftEntityDescriptorEnum.AccessorKindValue);
    }

    public void AccessorKindValue(AccessorKindValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.AccessorKindValue, value);
    }

    public void AccessorKindValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.AccessorKindValue, value);
    }

    public void PatternBinding() {
        wEntity(SwiftEntityDescriptorEnum.PatternBinding);
    }

    public void PatternBinding_() {
        wEntity_(SwiftEntityDescriptorEnum.PatternBinding);
    }

    public void _PatternBinding() {
        _wEntity(SwiftEntityDescriptorEnum.PatternBinding);
    }

    public void PatternBindingList() {
        wEntity(SwiftEntityDescriptorEnum.PatternBindingList);
    }

    public void PatternBindingList_() {
        wEntity_(SwiftEntityDescriptorEnum.PatternBindingList);
    }

    public void PatternBindingList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.PatternBindingList, initialCapacity);
    }

    public void _PatternBindingList() {
        _wEntity(SwiftEntityDescriptorEnum.PatternBindingList);
    }

    public void VariableDecl() {
        wEntity(SwiftEntityDescriptorEnum.VariableDecl);
    }

    public void VariableDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.VariableDecl);
    }

    public void _VariableDecl() {
        _wEntity(SwiftEntityDescriptorEnum.VariableDecl);
    }

    public void LetOrVarKeywordEnum() {
        wEntity(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum);
    }

    public void LetOrVarKeywordEnum(LetOrVarKeywordEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum, value);
    }

    public void LetOrVarKeywordEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum, value);
    }

    public void EnumCaseElement() {
        wEntity(SwiftEntityDescriptorEnum.EnumCaseElement);
    }

    public void EnumCaseElement_() {
        wEntity_(SwiftEntityDescriptorEnum.EnumCaseElement);
    }

    public void _EnumCaseElement() {
        _wEntity(SwiftEntityDescriptorEnum.EnumCaseElement);
    }

    public void EnumCaseElementList() {
        wEntity(SwiftEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseElementList_() {
        wEntity_(SwiftEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseElementList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.EnumCaseElementList, initialCapacity);
    }

    public void _EnumCaseElementList() {
        _wEntity(SwiftEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseDecl() {
        wEntity(SwiftEntityDescriptorEnum.EnumCaseDecl);
    }

    public void EnumCaseDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.EnumCaseDecl);
    }

    public void _EnumCaseDecl() {
        _wEntity(SwiftEntityDescriptorEnum.EnumCaseDecl);
    }

    public void EnumDecl() {
        wEntity(SwiftEntityDescriptorEnum.EnumDecl);
    }

    public void EnumDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.EnumDecl);
    }

    public void _EnumDecl() {
        _wEntity(SwiftEntityDescriptorEnum.EnumDecl);
    }

    public void OperatorDecl() {
        wEntity(SwiftEntityDescriptorEnum.OperatorDecl);
    }

    public void OperatorDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.OperatorDecl);
    }

    public void _OperatorDecl() {
        _wEntity(SwiftEntityDescriptorEnum.OperatorDecl);
    }

    public void IdentifierList() {
        wEntity(SwiftEntityDescriptorEnum.IdentifierList);
    }

    public void IdentifierList_() {
        wEntity_(SwiftEntityDescriptorEnum.IdentifierList);
    }

    public void IdentifierList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.IdentifierList, initialCapacity);
    }

    public void _IdentifierList() {
        _wEntity(SwiftEntityDescriptorEnum.IdentifierList);
    }

    public void PrecedenceGroupDecl() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void PrecedenceGroupDecl_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void _PrecedenceGroupDecl() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void PrecedenceGroupAttributeList() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupAttributeList_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupAttributeList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList, initialCapacity);
    }

    public void _PrecedenceGroupAttributeList() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupRelation() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void PrecedenceGroupRelation_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void _PrecedenceGroupRelation() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void PrecedenceGroupAssignment() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void PrecedenceGroupAssignment_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void _PrecedenceGroupAssignment() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void PrecedenceGroupAssociativity() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void PrecedenceGroupAssociativity_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void _PrecedenceGroupAssociativity() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void HigherThanOrLowerThanValue() {
        wEntity(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue);
    }

    public void HigherThanOrLowerThanValue(HigherThanOrLowerThanValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue, value);
    }

    public void HigherThanOrLowerThanValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue, value);
    }

    public void PrecedenceGroupNameList() {
        wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void PrecedenceGroupNameList_() {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void PrecedenceGroupNameList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.PrecedenceGroupNameList, initialCapacity);
    }

    public void _PrecedenceGroupNameList() {
        _wEntity(SwiftEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void FlagEnum() {
        wEntity(SwiftEntityDescriptorEnum.FlagEnum);
    }

    public void FlagEnum(FlagEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.FlagEnum, value);
    }

    public void FlagEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.FlagEnum, value);
    }

    public void ValueValue() {
        wEntity(SwiftEntityDescriptorEnum.ValueValue);
    }

    public void ValueValue(ValueValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.ValueValue, value);
    }

    public void ValueValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.ValueValue, value);
    }

    public void CustomAttribute() {
        wEntity(SwiftEntityDescriptorEnum.CustomAttribute);
    }

    public void CustomAttribute_() {
        wEntity_(SwiftEntityDescriptorEnum.CustomAttribute);
    }

    public void _CustomAttribute() {
        _wEntity(SwiftEntityDescriptorEnum.CustomAttribute);
    }

    public void Attribute() {
        wEntity(SwiftEntityDescriptorEnum.Attribute);
    }

    public void Attribute_() {
        wEntity_(SwiftEntityDescriptorEnum.Attribute);
    }

    public void _Attribute() {
        _wEntity(SwiftEntityDescriptorEnum.Attribute);
    }

    public void AvailabilitySpecList() {
        wEntity(SwiftEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void AvailabilitySpecList_() {
        wEntity_(SwiftEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void AvailabilitySpecList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.AvailabilitySpecList, initialCapacity);
    }

    public void _AvailabilitySpecList() {
        _wEntity(SwiftEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void SpecializeAttributeSpecList() {
        wEntity(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void SpecializeAttributeSpecList_() {
        wEntity_(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void SpecializeAttributeSpecList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList, initialCapacity);
    }

    public void _SpecializeAttributeSpecList() {
        _wEntity(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void ObjCSelector() {
        wEntity(SwiftEntityDescriptorEnum.ObjCSelector);
    }

    public void ObjCSelector_() {
        wEntity_(SwiftEntityDescriptorEnum.ObjCSelector);
    }

    public void ObjCSelector_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ObjCSelector, initialCapacity);
    }

    public void _ObjCSelector() {
        _wEntity(SwiftEntityDescriptorEnum.ObjCSelector);
    }

    public void ImplementsAttributeArguments() {
        wEntity(SwiftEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void ImplementsAttributeArguments_() {
        wEntity_(SwiftEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void _ImplementsAttributeArguments() {
        _wEntity(SwiftEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void NamedAttributeStringArgument() {
        wEntity(SwiftEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void NamedAttributeStringArgument_() {
        wEntity_(SwiftEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void _NamedAttributeStringArgument() {
        _wEntity(SwiftEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void AttributeList() {
        wEntity(SwiftEntityDescriptorEnum.AttributeList);
    }

    public void AttributeList_() {
        wEntity_(SwiftEntityDescriptorEnum.AttributeList);
    }

    public void AttributeList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.AttributeList, initialCapacity);
    }

    public void _AttributeList() {
        _wEntity(SwiftEntityDescriptorEnum.AttributeList);
    }

    public void LabeledSpecializeEntry() {
        wEntity(SwiftEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void LabeledSpecializeEntry_() {
        wEntity_(SwiftEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void _LabeledSpecializeEntry() {
        _wEntity(SwiftEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void DeclName() {
        wEntity(SwiftEntityDescriptorEnum.DeclName);
    }

    public void DeclName_() {
        wEntity_(SwiftEntityDescriptorEnum.DeclName);
    }

    public void _DeclName() {
        _wEntity(SwiftEntityDescriptorEnum.DeclName);
    }

    public void ContinueStmt() {
        wEntity(SwiftEntityDescriptorEnum.ContinueStmt);
    }

    public void ContinueStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.ContinueStmt);
    }

    public void _ContinueStmt() {
        _wEntity(SwiftEntityDescriptorEnum.ContinueStmt);
    }

    public void WhileStmt() {
        wEntity(SwiftEntityDescriptorEnum.WhileStmt);
    }

    public void WhileStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.WhileStmt);
    }

    public void _WhileStmt() {
        _wEntity(SwiftEntityDescriptorEnum.WhileStmt);
    }

    public void DeferStmt() {
        wEntity(SwiftEntityDescriptorEnum.DeferStmt);
    }

    public void DeferStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.DeferStmt);
    }

    public void _DeferStmt() {
        _wEntity(SwiftEntityDescriptorEnum.DeferStmt);
    }

    public void SwitchCase() {
        wEntity(SwiftEntityDescriptorEnum.SwitchCase);
    }

    public void SwitchCase_() {
        wEntity_(SwiftEntityDescriptorEnum.SwitchCase);
    }

    public void _SwitchCase() {
        _wEntity(SwiftEntityDescriptorEnum.SwitchCase);
    }

    public void RepeatWhileStmt() {
        wEntity(SwiftEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void RepeatWhileStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void _RepeatWhileStmt() {
        _wEntity(SwiftEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void GuardStmt() {
        wEntity(SwiftEntityDescriptorEnum.GuardStmt);
    }

    public void GuardStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.GuardStmt);
    }

    public void _GuardStmt() {
        _wEntity(SwiftEntityDescriptorEnum.GuardStmt);
    }

    public void ForInStmt() {
        wEntity(SwiftEntityDescriptorEnum.ForInStmt);
    }

    public void ForInStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.ForInStmt);
    }

    public void _ForInStmt() {
        _wEntity(SwiftEntityDescriptorEnum.ForInStmt);
    }

    public void Case() {
        wEntity(SwiftEntityDescriptorEnum.Case);
    }

    public void Case_() {
        wEntity_(SwiftEntityDescriptorEnum.Case);
    }

    public void _Case() {
        _wEntity(SwiftEntityDescriptorEnum.Case);
    }

    public void SwitchStmt() {
        wEntity(SwiftEntityDescriptorEnum.SwitchStmt);
    }

    public void SwitchStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.SwitchStmt);
    }

    public void _SwitchStmt() {
        _wEntity(SwiftEntityDescriptorEnum.SwitchStmt);
    }

    public void CatchClauseList() {
        wEntity(SwiftEntityDescriptorEnum.CatchClauseList);
    }

    public void CatchClauseList_() {
        wEntity_(SwiftEntityDescriptorEnum.CatchClauseList);
    }

    public void CatchClauseList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.CatchClauseList, initialCapacity);
    }

    public void _CatchClauseList() {
        _wEntity(SwiftEntityDescriptorEnum.CatchClauseList);
    }

    public void DoStmt() {
        wEntity(SwiftEntityDescriptorEnum.DoStmt);
    }

    public void DoStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.DoStmt);
    }

    public void _DoStmt() {
        _wEntity(SwiftEntityDescriptorEnum.DoStmt);
    }

    public void ReturnStmt() {
        wEntity(SwiftEntityDescriptorEnum.ReturnStmt);
    }

    public void ReturnStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.ReturnStmt);
    }

    public void _ReturnStmt() {
        _wEntity(SwiftEntityDescriptorEnum.ReturnStmt);
    }

    public void YieldStmt() {
        wEntity(SwiftEntityDescriptorEnum.YieldStmt);
    }

    public void YieldStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.YieldStmt);
    }

    public void _YieldStmt() {
        _wEntity(SwiftEntityDescriptorEnum.YieldStmt);
    }

    public void YieldList() {
        wEntity(SwiftEntityDescriptorEnum.YieldList);
    }

    public void YieldList_() {
        wEntity_(SwiftEntityDescriptorEnum.YieldList);
    }

    public void YieldList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.YieldList, initialCapacity);
    }

    public void _YieldList() {
        _wEntity(SwiftEntityDescriptorEnum.YieldList);
    }

    public void FallthroughStmt() {
        wEntity(SwiftEntityDescriptorEnum.FallthroughStmt);
    }

    public void FallthroughStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.FallthroughStmt);
    }

    public void _FallthroughStmt() {
        _wEntity(SwiftEntityDescriptorEnum.FallthroughStmt);
    }

    public void BreakStmt() {
        wEntity(SwiftEntityDescriptorEnum.BreakStmt);
    }

    public void BreakStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.BreakStmt);
    }

    public void _BreakStmt() {
        _wEntity(SwiftEntityDescriptorEnum.BreakStmt);
    }

    public void AvailabilityCondition() {
        wEntity(SwiftEntityDescriptorEnum.AvailabilityCondition);
    }

    public void AvailabilityCondition_() {
        wEntity_(SwiftEntityDescriptorEnum.AvailabilityCondition);
    }

    public void _AvailabilityCondition() {
        _wEntity(SwiftEntityDescriptorEnum.AvailabilityCondition);
    }

    public void MatchingPatternCondition() {
        wEntity(SwiftEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void MatchingPatternCondition_() {
        wEntity_(SwiftEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void _MatchingPatternCondition() {
        _wEntity(SwiftEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void OptionalBindingCondition() {
        wEntity(SwiftEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void OptionalBindingCondition_() {
        wEntity_(SwiftEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void _OptionalBindingCondition() {
        _wEntity(SwiftEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void ConditionElementList() {
        wEntity(SwiftEntityDescriptorEnum.ConditionElementList);
    }

    public void ConditionElementList_() {
        wEntity_(SwiftEntityDescriptorEnum.ConditionElementList);
    }

    public void ConditionElementList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.ConditionElementList, initialCapacity);
    }

    public void _ConditionElementList() {
        _wEntity(SwiftEntityDescriptorEnum.ConditionElementList);
    }

    public void ThrowStmt() {
        wEntity(SwiftEntityDescriptorEnum.ThrowStmt);
    }

    public void ThrowStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.ThrowStmt);
    }

    public void _ThrowStmt() {
        _wEntity(SwiftEntityDescriptorEnum.ThrowStmt);
    }

    public void IfStmt() {
        wEntity(SwiftEntityDescriptorEnum.IfStmt);
    }

    public void IfStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.IfStmt);
    }

    public void _IfStmt() {
        _wEntity(SwiftEntityDescriptorEnum.IfStmt);
    }

    public void SwitchDefaultLabel() {
        wEntity(SwiftEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void SwitchDefaultLabel_() {
        wEntity_(SwiftEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void _SwitchDefaultLabel() {
        _wEntity(SwiftEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void SwitchCaseLabel() {
        wEntity(SwiftEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void SwitchCaseLabel_() {
        wEntity_(SwiftEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void SwitchCaseLabel_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.SwitchCaseLabel, initialCapacity);
    }

    public void _SwitchCaseLabel() {
        _wEntity(SwiftEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void CaseItem() {
        wEntity(SwiftEntityDescriptorEnum.CaseItem);
    }

    public void CaseItem_() {
        wEntity_(SwiftEntityDescriptorEnum.CaseItem);
    }

    public void _CaseItem() {
        _wEntity(SwiftEntityDescriptorEnum.CaseItem);
    }

    public void CatchClause() {
        wEntity(SwiftEntityDescriptorEnum.CatchClause);
    }

    public void CatchClause_() {
        wEntity_(SwiftEntityDescriptorEnum.CatchClause);
    }

    public void _CatchClause() {
        _wEntity(SwiftEntityDescriptorEnum.CatchClause);
    }

    public void PoundAssertStmt() {
        wEntity(SwiftEntityDescriptorEnum.PoundAssertStmt);
    }

    public void PoundAssertStmt_() {
        wEntity_(SwiftEntityDescriptorEnum.PoundAssertStmt);
    }

    public void _PoundAssertStmt() {
        _wEntity(SwiftEntityDescriptorEnum.PoundAssertStmt);
    }

    public void GenericRequirementList() {
        wEntity(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public void GenericRequirementList_() {
        wEntity_(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public void GenericRequirementList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.GenericRequirementList, initialCapacity);
    }

    public void _GenericRequirementList() {
        _wEntity(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public void SameTypeRequirement() {
        wEntity(SwiftEntityDescriptorEnum.SameTypeRequirement);
    }

    public void SameTypeRequirement_() {
        wEntity_(SwiftEntityDescriptorEnum.SameTypeRequirement);
    }

    public void _SameTypeRequirement() {
        _wEntity(SwiftEntityDescriptorEnum.SameTypeRequirement);
    }

    public void ConformanceRequirement() {
        wEntity(SwiftEntityDescriptorEnum.ConformanceRequirement);
    }

    public void ConformanceRequirement_() {
        wEntity_(SwiftEntityDescriptorEnum.ConformanceRequirement);
    }

    public void _ConformanceRequirement() {
        _wEntity(SwiftEntityDescriptorEnum.ConformanceRequirement);
    }

    public void GenericParameterList() {
        wEntity(SwiftEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameterList_() {
        wEntity_(SwiftEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameterList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.GenericParameterList, initialCapacity);
    }

    public void _GenericParameterList() {
        _wEntity(SwiftEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameter() {
        wEntity(SwiftEntityDescriptorEnum.GenericParameter);
    }

    public void GenericParameter_() {
        wEntity_(SwiftEntityDescriptorEnum.GenericParameter);
    }

    public void _GenericParameter() {
        _wEntity(SwiftEntityDescriptorEnum.GenericParameter);
    }

    public void SimpleTypeIdentifier() {
        wEntity(SwiftEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void SimpleTypeIdentifier_() {
        wEntity_(SwiftEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void _SimpleTypeIdentifier() {
        _wEntity(SwiftEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void NameEnum() {
        wEntity(SwiftEntityDescriptorEnum.NameEnum);
    }

    public void NameEnum(NameEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.NameEnum, value);
    }

    public void NameEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.NameEnum, value);
    }

    public void MemberTypeIdentifier() {
        wEntity(SwiftEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void MemberTypeIdentifier_() {
        wEntity_(SwiftEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void _MemberTypeIdentifier() {
        _wEntity(SwiftEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void PeriodEnum() {
        wEntity(SwiftEntityDescriptorEnum.PeriodEnum);
    }

    public void PeriodEnum(PeriodEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.PeriodEnum, value);
    }

    public void PeriodEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.PeriodEnum, value);
    }

    public void ClassRestrictionType() {
        wEntity(SwiftEntityDescriptorEnum.ClassRestrictionType);
    }

    public void ClassRestrictionType_() {
        wEntity_(SwiftEntityDescriptorEnum.ClassRestrictionType);
    }

    public void _ClassRestrictionType() {
        _wEntity(SwiftEntityDescriptorEnum.ClassRestrictionType);
    }

    public void ArrayType() {
        wEntity(SwiftEntityDescriptorEnum.ArrayType);
    }

    public void ArrayType_() {
        wEntity_(SwiftEntityDescriptorEnum.ArrayType);
    }

    public void _ArrayType() {
        _wEntity(SwiftEntityDescriptorEnum.ArrayType);
    }

    public void DictionaryType() {
        wEntity(SwiftEntityDescriptorEnum.DictionaryType);
    }

    public void DictionaryType_() {
        wEntity_(SwiftEntityDescriptorEnum.DictionaryType);
    }

    public void _DictionaryType() {
        _wEntity(SwiftEntityDescriptorEnum.DictionaryType);
    }

    public void MetatypeType() {
        wEntity(SwiftEntityDescriptorEnum.MetatypeType);
    }

    public void MetatypeType_() {
        wEntity_(SwiftEntityDescriptorEnum.MetatypeType);
    }

    public void _MetatypeType() {
        _wEntity(SwiftEntityDescriptorEnum.MetatypeType);
    }

    public void TypeOrProtocolValue() {
        wEntity(SwiftEntityDescriptorEnum.TypeOrProtocolValue);
    }

    public void TypeOrProtocolValue(TypeOrProtocolValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.TypeOrProtocolValue, value);
    }

    public void TypeOrProtocolValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.TypeOrProtocolValue, value);
    }

    public void OptionalType() {
        wEntity(SwiftEntityDescriptorEnum.OptionalType);
    }

    public void OptionalType_() {
        wEntity_(SwiftEntityDescriptorEnum.OptionalType);
    }

    public void _OptionalType() {
        _wEntity(SwiftEntityDescriptorEnum.OptionalType);
    }

    public void SomeType() {
        wEntity(SwiftEntityDescriptorEnum.SomeType);
    }

    public void SomeType_() {
        wEntity_(SwiftEntityDescriptorEnum.SomeType);
    }

    public void _SomeType() {
        _wEntity(SwiftEntityDescriptorEnum.SomeType);
    }

    public void ImplicitlyUnwrappedOptionalType() {
        wEntity(SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void ImplicitlyUnwrappedOptionalType_() {
        wEntity_(SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void _ImplicitlyUnwrappedOptionalType() {
        _wEntity(SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void CompositionTypeElement() {
        wEntity(SwiftEntityDescriptorEnum.CompositionTypeElement);
    }

    public void CompositionTypeElement_() {
        wEntity_(SwiftEntityDescriptorEnum.CompositionTypeElement);
    }

    public void _CompositionTypeElement() {
        _wEntity(SwiftEntityDescriptorEnum.CompositionTypeElement);
    }

    public void Ampersand() {
        wEntity(SwiftEntityDescriptorEnum.Ampersand);
    }

    public void Ampersand_() {
        wEntity_(SwiftEntityDescriptorEnum.Ampersand);
    }

    public void _Ampersand() {
        _wEntity(SwiftEntityDescriptorEnum.Ampersand);
    }

    public void CompositionType() {
        wEntity(SwiftEntityDescriptorEnum.CompositionType);
    }

    public void CompositionType_() {
        wEntity_(SwiftEntityDescriptorEnum.CompositionType);
    }

    public void CompositionType_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.CompositionType, initialCapacity);
    }

    public void _CompositionType() {
        _wEntity(SwiftEntityDescriptorEnum.CompositionType);
    }

    public void TupleTypeElement() {
        wEntity(SwiftEntityDescriptorEnum.TupleTypeElement);
    }

    public void TupleTypeElement_() {
        wEntity_(SwiftEntityDescriptorEnum.TupleTypeElement);
    }

    public void _TupleTypeElement() {
        _wEntity(SwiftEntityDescriptorEnum.TupleTypeElement);
    }

    public void Inout() {
        wEntity(SwiftEntityDescriptorEnum.Inout);
    }

    public void Inout_() {
        wEntity_(SwiftEntityDescriptorEnum.Inout);
    }

    public void _Inout() {
        _wEntity(SwiftEntityDescriptorEnum.Inout);
    }

    public void TupleTypeElementList() {
        wEntity(SwiftEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleTypeElementList_() {
        wEntity_(SwiftEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleTypeElementList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.TupleTypeElementList, initialCapacity);
    }

    public void _TupleTypeElementList() {
        _wEntity(SwiftEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleType() {
        wEntity(SwiftEntityDescriptorEnum.TupleType);
    }

    public void TupleType_() {
        wEntity_(SwiftEntityDescriptorEnum.TupleType);
    }

    public void _TupleType() {
        _wEntity(SwiftEntityDescriptorEnum.TupleType);
    }

    public void FunctionType() {
        wEntity(SwiftEntityDescriptorEnum.FunctionType);
    }

    public void FunctionType_() {
        wEntity_(SwiftEntityDescriptorEnum.FunctionType);
    }

    public void _FunctionType() {
        _wEntity(SwiftEntityDescriptorEnum.FunctionType);
    }

    public void AttributedType() {
        wEntity(SwiftEntityDescriptorEnum.AttributedType);
    }

    public void AttributedType_() {
        wEntity_(SwiftEntityDescriptorEnum.AttributedType);
    }

    public void _AttributedType() {
        _wEntity(SwiftEntityDescriptorEnum.AttributedType);
    }

    public void SpecifierValue() {
        wEntity(SwiftEntityDescriptorEnum.SpecifierValue);
    }

    public void SpecifierValue(SpecifierValueEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.SpecifierValue, value);
    }

    public void SpecifierValue(String value) {
        wEntity(SwiftEntityDescriptorEnum.SpecifierValue, value);
    }

    public void GenericArgumentList() {
        wEntity(SwiftEntityDescriptorEnum.GenericArgumentList);
    }

    public void GenericArgumentList_() {
        wEntity_(SwiftEntityDescriptorEnum.GenericArgumentList);
    }

    public void GenericArgumentList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.GenericArgumentList, initialCapacity);
    }

    public void _GenericArgumentList() {
        _wEntity(SwiftEntityDescriptorEnum.GenericArgumentList);
    }

    public void EnumCasePattern() {
        wEntity(SwiftEntityDescriptorEnum.EnumCasePattern);
    }

    public void EnumCasePattern_() {
        wEntity_(SwiftEntityDescriptorEnum.EnumCasePattern);
    }

    public void _EnumCasePattern() {
        _wEntity(SwiftEntityDescriptorEnum.EnumCasePattern);
    }

    public void IsTypePattern() {
        wEntity(SwiftEntityDescriptorEnum.IsTypePattern);
    }

    public void IsTypePattern_() {
        wEntity_(SwiftEntityDescriptorEnum.IsTypePattern);
    }

    public void _IsTypePattern() {
        _wEntity(SwiftEntityDescriptorEnum.IsTypePattern);
    }

    public void OptionalPattern() {
        wEntity(SwiftEntityDescriptorEnum.OptionalPattern);
    }

    public void OptionalPattern_() {
        wEntity_(SwiftEntityDescriptorEnum.OptionalPattern);
    }

    public void _OptionalPattern() {
        _wEntity(SwiftEntityDescriptorEnum.OptionalPattern);
    }

    public void IdentifierPattern() {
        wEntity(SwiftEntityDescriptorEnum.IdentifierPattern);
    }

    public void IdentifierPattern_() {
        wEntity_(SwiftEntityDescriptorEnum.IdentifierPattern);
    }

    public void _IdentifierPattern() {
        _wEntity(SwiftEntityDescriptorEnum.IdentifierPattern);
    }

    public void SelfMarker() {
        wEntity(SwiftEntityDescriptorEnum.SelfMarker);
    }

    public void SelfMarker_() {
        wEntity_(SwiftEntityDescriptorEnum.SelfMarker);
    }

    public void _SelfMarker() {
        _wEntity(SwiftEntityDescriptorEnum.SelfMarker);
    }

    public void AsTypePattern() {
        wEntity(SwiftEntityDescriptorEnum.AsTypePattern);
    }

    public void AsTypePattern_() {
        wEntity_(SwiftEntityDescriptorEnum.AsTypePattern);
    }

    public void _AsTypePattern() {
        _wEntity(SwiftEntityDescriptorEnum.AsTypePattern);
    }

    public void WildcardPattern() {
        wEntity(SwiftEntityDescriptorEnum.WildcardPattern);
    }

    public void WildcardPattern_() {
        wEntity_(SwiftEntityDescriptorEnum.WildcardPattern);
    }

    public void _WildcardPattern() {
        _wEntity(SwiftEntityDescriptorEnum.WildcardPattern);
    }

    public void TuplePatternElement() {
        wEntity(SwiftEntityDescriptorEnum.TuplePatternElement);
    }

    public void TuplePatternElement_() {
        wEntity_(SwiftEntityDescriptorEnum.TuplePatternElement);
    }

    public void _TuplePatternElement() {
        _wEntity(SwiftEntityDescriptorEnum.TuplePatternElement);
    }

    public void ExpressionPattern() {
        wEntity(SwiftEntityDescriptorEnum.ExpressionPattern);
    }

    public void ExpressionPattern_() {
        wEntity_(SwiftEntityDescriptorEnum.ExpressionPattern);
    }

    public void _ExpressionPattern() {
        _wEntity(SwiftEntityDescriptorEnum.ExpressionPattern);
    }

    public void TuplePatternElementList() {
        wEntity(SwiftEntityDescriptorEnum.TuplePatternElementList);
    }

    public void TuplePatternElementList_() {
        wEntity_(SwiftEntityDescriptorEnum.TuplePatternElementList);
    }

    public void TuplePatternElementList_(int initialCapacity) {
        wEntity_(SwiftEntityDescriptorEnum.TuplePatternElementList, initialCapacity);
    }

    public void _TuplePatternElementList() {
        _wEntity(SwiftEntityDescriptorEnum.TuplePatternElementList);
    }

    public void ValueBindingPattern() {
        wEntity(SwiftEntityDescriptorEnum.ValueBindingPattern);
    }

    public void ValueBindingPattern_() {
        wEntity_(SwiftEntityDescriptorEnum.ValueBindingPattern);
    }

    public void _ValueBindingPattern() {
        _wEntity(SwiftEntityDescriptorEnum.ValueBindingPattern);
    }

    public void AvailabilityVersionRestriction() {
        wEntity(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void AvailabilityVersionRestriction_() {
        wEntity_(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void _AvailabilityVersionRestriction() {
        _wEntity(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void AvailabilityLabeledArgument() {
        wEntity(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void AvailabilityLabeledArgument_() {
        wEntity_(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void _AvailabilityLabeledArgument() {
        _wEntity(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void VersionTuple() {
        wEntity(SwiftEntityDescriptorEnum.VersionTuple);
    }

    public void VersionTuple_() {
        wEntity_(SwiftEntityDescriptorEnum.VersionTuple);
    }

    public void _VersionTuple() {
        _wEntity(SwiftEntityDescriptorEnum.VersionTuple);
    }

    public void CaptureSpecifierEnum() {
        wEntity(SwiftEntityDescriptorEnum.CaptureSpecifierEnum);
    }

    public void CaptureSpecifierEnum(CaptureSpecifierEnumEnum.Value value) {
        wEntity(SwiftEntityDescriptorEnum.CaptureSpecifierEnum, value);
    }

    public void CaptureSpecifierEnum(String value) {
        wEntity(SwiftEntityDescriptorEnum.CaptureSpecifierEnum, value);
    }
}
