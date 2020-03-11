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
package org.whole.lang.swiftsyntax.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.model.TokenKindEnum;
import org.whole.lang.swiftsyntax.model.SourcePresenceEnum;

/**
 *  @generator Whole
 */
public class SwiftSyntaxSpecificBuilderAdapter extends GenericBuilderContext implements ISwiftSyntaxBuilder {

    public SwiftSyntaxSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public SwiftSyntaxSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void patchVersion() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.patchVersion);
    }

    public void patchPeriod() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.patchPeriod);
    }

    public void majorMinor() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.majorMinor);
    }

    public void version() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.version);
    }

    public void platform() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.platform);
    }

    public void entry() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.entry);
    }

    public void valuePattern() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.valuePattern);
    }

    public void asKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.asKeyword);
    }

    public void subPattern() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.subPattern);
    }

    public void isKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.isKeyword);
    }

    public void associatedTuple() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.associatedTuple);
    }

    public void caseName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.caseName);
    }

    public void argumentType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.argumentType);
    }

    public void inOut() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inOut);
    }

    public void someSpecifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.someSpecifier);
    }

    public void wrappedType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.wrappedType);
    }

    public void typeOrProtocol() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.typeOrProtocol);
    }

    public void valueType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.valueType);
    }

    public void keyType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.keyType);
    }

    public void rightSquareBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket);
    }

    public void elementType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.elementType);
    }

    public void leftSquareBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket);
    }

    public void baseType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.baseType);
    }

    public void rightAngleBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket);
    }

    public void genericParameterList() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.genericParameterList);
    }

    public void leftAngleBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket);
    }

    public void inheritedType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inheritedType);
    }

    public void rightTypeIdentifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier);
    }

    public void equalityToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.equalityToken);
    }

    public void leftTypeIdentifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier);
    }

    public void requirementList() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.requirementList);
    }

    public void poundAssert() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundAssert);
    }

    public void catchKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.catchKeyword);
    }

    public void caseItems() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.caseItems);
    }

    public void defaultKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.defaultKeyword);
    }

    public void unknownAttr() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.unknownAttr);
    }

    public void elseBody() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.elseBody);
    }

    public void ifKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.ifKeyword);
    }

    public void throwKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.throwKeyword);
    }

    public void availabilitySpec() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.availabilitySpec);
    }

    public void poundAvailableKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundAvailableKeyword);
    }

    public void breakKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.breakKeyword);
    }

    public void fallthroughKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.fallthroughKeyword);
    }

    public void yields() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.yields);
    }

    public void yieldKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.yieldKeyword);
    }

    public void returnKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.returnKeyword);
    }

    public void catchClauses() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.catchClauses);
    }

    public void doKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.doKeyword);
    }

    public void cases() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.cases);
    }

    public void switchKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.switchKeyword);
    }

    public void whereClause() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.whereClause);
    }

    public void sequenceExpr() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr);
    }

    public void inKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inKeyword);
    }

    public void forKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.forKeyword);
    }

    public void guardResult() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.guardResult);
    }

    public void whereKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.whereKeyword);
    }

    public void elseKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.elseKeyword);
    }

    public void guardKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.guardKeyword);
    }

    public void repeatKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.repeatKeyword);
    }

    public void deferKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.deferKeyword);
    }

    public void conditions() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.conditions);
    }

    public void whileKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.whileKeyword);
    }

    public void labelColon() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.labelColon);
    }

    public void labelName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.labelName);
    }

    public void continueKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.continueKeyword);
    }

    public void declBaseName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.declBaseName);
    }

    public void stringOrDeclname() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.stringOrDeclname);
    }

    public void nameTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.nameTok);
    }

    public void argument() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.argument);
    }

    public void attributeName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.attributeName);
    }

    public void atSignToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.atSignToken);
    }

    public void associativityKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.associativityKeyword);
    }

    public void flag() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.flag);
    }

    public void assignmentKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.assignmentKeyword);
    }

    public void otherNames() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.otherNames);
    }

    public void higherThanOrLowerThan() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan);
    }

    public void groupAttributes() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.groupAttributes);
    }

    public void precedencegroupKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword);
    }

    public void precedenceGroupAndDesignatedTypes() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.precedenceGroupAndDesignatedTypes);
    }

    public void operatorPrecedenceAndTypes() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.operatorPrecedenceAndTypes);
    }

    public void operatorKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.operatorKeyword);
    }

    public void genericParameters() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.genericParameters);
    }

    public void enumKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.enumKeyword);
    }

    public void caseKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.caseKeyword);
    }

    public void rawValue() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rawValue);
    }

    public void associatedValue() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.associatedValue);
    }

    public void bindings() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.bindings);
    }

    public void letOrVarKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword);
    }

    public void typeAnnotation() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation);
    }

    public void accessors() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.accessors);
    }

    public void parameter() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.parameter);
    }

    public void accessorKind() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.accessorKind);
    }

    public void path() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.path);
    }

    public void importKind() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.importKind);
    }

    public void importTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.importTok);
    }

    public void trailingDot() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.trailingDot);
    }

    public void modifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.modifier);
    }

    public void accessor() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.accessor);
    }

    public void result() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.result);
    }

    public void indices() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.indices);
    }

    public void subscriptKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword);
    }

    public void deinitKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.deinitKeyword);
    }

    public void parameters() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.parameters);
    }

    public void optionalMark() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.optionalMark);
    }

    public void initKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.initKeyword);
    }

    public void body() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.body);
    }

    public void funcKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.funcKeyword);
    }

    public void defaultArgument() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.defaultArgument);
    }

    public void ellipsis() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.ellipsis);
    }

    public void secondName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.secondName);
    }

    public void firstName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.firstName);
    }

    public void eofToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.eofToken);
    }

    public void decl() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.decl);
    }

    public void extendedType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.extendedType);
    }

    public void extensionKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.extensionKeyword);
    }

    public void protocolKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.protocolKeyword);
    }

    public void structKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.structKeyword);
    }

    public void members() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.members);
    }

    public void classKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.classKeyword);
    }

    public void inheritedTypeCollection() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inheritedTypeCollection);
    }

    public void detailRightParen() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.detailRightParen);
    }

    public void detail() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.detail);
    }

    public void detailLeftParen() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.detailLeftParen);
    }

    public void lineNumber() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.lineNumber);
    }

    public void lineArgColon() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.lineArgColon);
    }

    public void lineArgLabel() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel);
    }

    public void comma() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.comma);
    }

    public void fileName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.fileName);
    }

    public void fileArgColon() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.fileArgColon);
    }

    public void fileArgLabel() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel);
    }

    public void args() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.args);
    }

    public void poundSourceLocation() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundSourceLocation);
    }

    public void poundWarning() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundWarning);
    }

    public void message() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.message);
    }

    public void poundError() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundError);
    }

    public void poundEndif() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundEndif);
    }

    public void clauses() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.clauses);
    }

    public void condition() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.condition);
    }

    public void poundKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundKeyword);
    }

    public void throwsOrRethrowsKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword);
    }

    public void returnType() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.returnType);
    }

    public void arrow() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.arrow);
    }

    public void parameterList() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.parameterList);
    }

    public void inheritanceClause() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause);
    }

    public void associatedtypeKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword);
    }

    public void genericWhereClause() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause);
    }

    public void initializer() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.initializer);
    }

    public void genericParameterClause() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause);
    }

    public void typealiasKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.typealiasKeyword);
    }

    public void modifiers() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.modifiers);
    }

    public void attributes() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.attributes);
    }

    public void value() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.value);
    }

    public void equal() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.equal);
    }

    public void poundSelector() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundSelector);
    }

    public void keyPath() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.keyPath);
    }

    public void period() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.period);
    }

    public void rootExpr() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rootExpr);
    }

    public void closeDelimiter() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter);
    }

    public void closeQuote() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.closeQuote);
    }

    public void segments() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.segments);
    }

    public void openQuote() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.openQuote);
    }

    public void openDelimiter() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.openDelimiter);
    }

    public void expressions() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.expressions);
    }

    public void delimiter() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.delimiter);
    }

    public void backslash() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.backslash);
    }

    public void exclamationMark() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.exclamationMark);
    }

    public void rightBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightBracket);
    }

    public void leftBracket() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftBracket);
    }

    public void trailingClosure() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.trailingClosure);
    }

    public void argumentList() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.argumentList);
    }

    public void calledExpression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.calledExpression);
    }

    public void pattern() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.pattern);
    }

    public void signature() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.signature);
    }

    public void inTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.inTok);
    }

    public void output() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.output);
    }

    public void throwsTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.throwsTok);
    }

    public void input() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.input);
    }

    public void capture() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.capture);
    }

    public void items() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.items);
    }

    public void specifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.specifier);
    }

    public void type() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.type);
    }

    public void asTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.asTok);
    }

    public void typeName() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.typeName);
    }

    public void isTok() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.isTok);
    }

    public void dot() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.dot);
    }

    public void base() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.base);
    }

    public void secondChoice() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.secondChoice);
    }

    public void colonMark() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.colonMark);
    }

    public void firstChoice() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.firstChoice);
    }

    public void questionMark() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.questionMark);
    }

    public void conditionExpression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.conditionExpression);
    }

    public void booleanLiteral() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.booleanLiteral);
    }

    public void digits() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.digits);
    }

    public void valueExpression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.valueExpression);
    }

    public void keyExpression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.keyExpression);
    }

    public void trailingComma() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.trailingComma);
    }

    public void label() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.label);
    }

    public void content() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.content);
    }

    public void rightSquare() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightSquare);
    }

    public void leftSquare() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftSquare);
    }

    public void elementList() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.elementList);
    }

    public void floatingDigits() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.floatingDigits);
    }

    public void arrowToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.arrowToken);
    }

    public void throwsToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.throwsToken);
    }

    public void postfixExpression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.postfixExpression);
    }

    public void operatorToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.operatorToken);
    }

    public void genericArgumentClause() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause);
    }

    public void poundDsohandle() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundDsohandle);
    }

    public void poundFunction() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundFunction);
    }

    public void poundFile() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundFile);
    }

    public void poundLine() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundLine);
    }

    public void elements() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.elements);
    }

    public void assignToken() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.assignToken);
    }

    public void wildcard() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.wildcard);
    }

    public void nilKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.nilKeyword);
    }

    public void superKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.superKeyword);
    }

    public void declNameArguments() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.declNameArguments);
    }

    public void identifier() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.identifier);
    }

    public void rightParen() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightParen);
    }

    public void arguments() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.arguments);
    }

    public void leftParen() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftParen);
    }

    public void colon() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.colon);
    }

    public void name() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.name);
    }

    public void questionOrExclamationMark() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark);
    }

    public void tryKeyword() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.tryKeyword);
    }

    public void poundColumn() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.poundColumn);
    }

    public void expression() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.expression);
    }

    public void ampersand() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.ampersand);
    }

    public void rightBrace() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.rightBrace);
    }

    public void statements() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.statements);
    }

    public void leftBrace() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leftBrace);
    }

    public void errorTokens() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.errorTokens);
    }

    public void semicolon() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.semicolon);
    }

    public void item() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.item);
    }

    public void text() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.text);
    }

    public void trailingTrivia() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia);
    }

    public void leadingTrivia() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia);
    }

    public void presence() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.presence);
    }

    public void kind() {
        wFeature(SwiftSyntaxFeatureDescriptorEnum.kind);
    }

    public void visit() {
    }

    public void Token() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void Token_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void _Token() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void UnknownDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownDecl);
    }

    public void UnknownDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownDecl);
    }

    public void UnknownDecl_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownDecl, initialCapacity);
    }

    public void _UnknownDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownDecl);
    }

    public void UnknownExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownExpr);
    }

    public void UnknownExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownExpr);
    }

    public void UnknownExpr_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownExpr, initialCapacity);
    }

    public void _UnknownExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownExpr);
    }

    public void UnknownPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownPattern);
    }

    public void UnknownPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownPattern);
    }

    public void UnknownPattern_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownPattern, initialCapacity);
    }

    public void _UnknownPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownPattern);
    }

    public void UnknownStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownStmt);
    }

    public void UnknownStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownStmt);
    }

    public void UnknownStmt_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownStmt, initialCapacity);
    }

    public void _UnknownStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownStmt);
    }

    public void UnknownType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownType);
    }

    public void UnknownType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownType);
    }

    public void UnknownType_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnknownType, initialCapacity);
    }

    public void _UnknownType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnknownType);
    }

    public void CodeBlockItem() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem);
    }

    public void CodeBlockItem_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem);
    }

    public void _CodeBlockItem() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem);
    }

    public void CodeBlockItemList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList);
    }

    public void CodeBlockItemList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList);
    }

    public void CodeBlockItemList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList, initialCapacity);
    }

    public void _CodeBlockItemList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList);
    }

    public void CodeBlock() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void CodeBlock_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void _CodeBlock() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void InOutExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.InOutExpr);
    }

    public void InOutExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InOutExpr);
    }

    public void _InOutExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.InOutExpr);
    }

    public void PoundColumnExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr);
    }

    public void PoundColumnExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr);
    }

    public void _PoundColumnExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr);
    }

    public void FunctionCallArgumentList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void FunctionCallArgumentList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void FunctionCallArgumentList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList, initialCapacity);
    }

    public void _FunctionCallArgumentList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void TupleElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleElementList);
    }

    public void TupleElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleElementList);
    }

    public void TupleElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleElementList, initialCapacity);
    }

    public void _TupleElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleElementList);
    }

    public void ArrayElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayElementList);
    }

    public void ArrayElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrayElementList);
    }

    public void ArrayElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrayElementList, initialCapacity);
    }

    public void _ArrayElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayElementList);
    }

    public void DictionaryElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList);
    }

    public void DictionaryElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList);
    }

    public void DictionaryElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList, initialCapacity);
    }

    public void _DictionaryElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList);
    }

    public void StringLiteralSegments() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments);
    }

    public void StringLiteralSegments_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments);
    }

    public void StringLiteralSegments_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments, initialCapacity);
    }

    public void _StringLiteralSegments() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments);
    }

    public void TryExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TryExpr);
    }

    public void TryExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TryExpr);
    }

    public void _TryExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TryExpr);
    }

    public void DeclNameArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument);
    }

    public void DeclNameArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument);
    }

    public void _DeclNameArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument);
    }

    public void DeclNameArgumentList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void DeclNameArgumentList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void DeclNameArgumentList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList, initialCapacity);
    }

    public void _DeclNameArgumentList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList);
    }

    public void DeclNameArguments() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments);
    }

    public void DeclNameArguments_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments);
    }

    public void _DeclNameArguments() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments);
    }

    public void IdentifierExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr);
    }

    public void IdentifierExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr);
    }

    public void _IdentifierExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr);
    }

    public void SuperRefExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SuperRefExpr);
    }

    public void SuperRefExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SuperRefExpr);
    }

    public void _SuperRefExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SuperRefExpr);
    }

    public void NilLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr);
    }

    public void NilLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr);
    }

    public void _NilLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr);
    }

    public void DiscardAssignmentExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void DiscardAssignmentExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void _DiscardAssignmentExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public void AssignmentExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AssignmentExpr);
    }

    public void AssignmentExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AssignmentExpr);
    }

    public void _AssignmentExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AssignmentExpr);
    }

    public void SequenceExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SequenceExpr);
    }

    public void SequenceExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SequenceExpr);
    }

    public void _SequenceExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SequenceExpr);
    }

    public void ExprList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ExprList);
    }

    public void ExprList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ExprList);
    }

    public void ExprList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ExprList, initialCapacity);
    }

    public void _ExprList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ExprList);
    }

    public void PoundLineExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundLineExpr);
    }

    public void PoundLineExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundLineExpr);
    }

    public void _PoundLineExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundLineExpr);
    }

    public void PoundFileExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundFileExpr);
    }

    public void PoundFileExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundFileExpr);
    }

    public void _PoundFileExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundFileExpr);
    }

    public void PoundFunctionExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void PoundFunctionExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void _PoundFunctionExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr);
    }

    public void PoundDsohandleExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void PoundDsohandleExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void _PoundDsohandleExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public void SymbolicReferenceExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void SymbolicReferenceExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void _SymbolicReferenceExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public void PrefixOperatorExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void PrefixOperatorExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void _PrefixOperatorExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public void BinaryOperatorExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void BinaryOperatorExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void _BinaryOperatorExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public void ArrowExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ArrowExpr);
    }

    public void ArrowExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrowExpr);
    }

    public void _ArrowExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ArrowExpr);
    }

    public void FloatLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr);
    }

    public void FloatLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr);
    }

    public void _FloatLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr);
    }

    public void TupleExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleExpr);
    }

    public void TupleExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleExpr);
    }

    public void _TupleExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleExpr);
    }

    public void ArrayExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayExpr);
    }

    public void ArrayExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrayExpr);
    }

    public void _ArrayExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayExpr);
    }

    public void DictionaryExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr);
    }

    public void DictionaryExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr);
    }

    public void _DictionaryExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr);
    }

    public void FunctionCallArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument);
    }

    public void FunctionCallArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument);
    }

    public void _FunctionCallArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument);
    }

    public void TupleElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleElement);
    }

    public void TupleElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleElement);
    }

    public void _TupleElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleElement);
    }

    public void ArrayElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayElement);
    }

    public void ArrayElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrayElement);
    }

    public void _ArrayElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayElement);
    }

    public void DictionaryElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryElement);
    }

    public void DictionaryElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DictionaryElement);
    }

    public void _DictionaryElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryElement);
    }

    public void IntegerLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr);
    }

    public void IntegerLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr);
    }

    public void _IntegerLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr);
    }

    public void BooleanLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr);
    }

    public void BooleanLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr);
    }

    public void _BooleanLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr);
    }

    public void TernaryExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TernaryExpr);
    }

    public void TernaryExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TernaryExpr);
    }

    public void _TernaryExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TernaryExpr);
    }

    public void MemberAccessExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr);
    }

    public void MemberAccessExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr);
    }

    public void _MemberAccessExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr);
    }

    public void IsExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IsExpr);
    }

    public void IsExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IsExpr);
    }

    public void _IsExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IsExpr);
    }

    public void AsExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AsExpr);
    }

    public void AsExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AsExpr);
    }

    public void _AsExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AsExpr);
    }

    public void TypeExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TypeExpr);
    }

    public void TypeExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TypeExpr);
    }

    public void _TypeExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TypeExpr);
    }

    public void ClosureCaptureItem() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void ClosureCaptureItem_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void _ClosureCaptureItem() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem);
    }

    public void ClosureCaptureItemList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void ClosureCaptureItemList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void ClosureCaptureItemList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList, initialCapacity);
    }

    public void _ClosureCaptureItemList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void ClosureCaptureSignature() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature);
    }

    public void ClosureCaptureSignature_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature);
    }

    public void _ClosureCaptureSignature() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature);
    }

    public void ClosureParam() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureParam);
    }

    public void ClosureParam_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureParam);
    }

    public void _ClosureParam() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureParam);
    }

    public void ClosureParamList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureParamList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureParamList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureParamList, initialCapacity);
    }

    public void _ClosureParamList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureParamList);
    }

    public void ClosureSignature() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureSignature);
    }

    public void ClosureSignature_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureSignature);
    }

    public void _ClosureSignature() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureSignature);
    }

    public void ClosureExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureExpr);
    }

    public void ClosureExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClosureExpr);
    }

    public void _ClosureExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClosureExpr);
    }

    public void UnresolvedPatternExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void UnresolvedPatternExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void _UnresolvedPatternExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public void FunctionCallExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr);
    }

    public void FunctionCallExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr);
    }

    public void _FunctionCallExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr);
    }

    public void SubscriptExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr);
    }

    public void SubscriptExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr);
    }

    public void _SubscriptExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr);
    }

    public void OptionalChainingExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void OptionalChainingExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void _OptionalChainingExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr);
    }

    public void ForcedValueExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr);
    }

    public void ForcedValueExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr);
    }

    public void _ForcedValueExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr);
    }

    public void PostfixUnaryExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void PostfixUnaryExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void _PostfixUnaryExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public void SpecializeExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr);
    }

    public void SpecializeExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr);
    }

    public void _SpecializeExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr);
    }

    public void StringSegment() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.StringSegment);
    }

    public void StringSegment_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.StringSegment);
    }

    public void _StringSegment() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.StringSegment);
    }

    public void ExpressionSegment() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment);
    }

    public void ExpressionSegment_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment);
    }

    public void _ExpressionSegment() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment);
    }

    public void StringLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr);
    }

    public void StringLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr);
    }

    public void _StringLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr);
    }

    public void KeyPathExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr);
    }

    public void KeyPathExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr);
    }

    public void _KeyPathExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr);
    }

    public void KeyPathBaseExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void KeyPathBaseExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void _KeyPathBaseExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public void ObjcNamePiece() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece);
    }

    public void ObjcNamePiece_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece);
    }

    public void _ObjcNamePiece() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece);
    }

    public void ObjcName() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcName);
    }

    public void ObjcName_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjcName);
    }

    public void ObjcName_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjcName, initialCapacity);
    }

    public void _ObjcName() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcName);
    }

    public void ObjcKeyPathExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void ObjcKeyPathExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void _ObjcKeyPathExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public void ObjcSelectorExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void ObjcSelectorExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void _ObjcSelectorExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public void EditorPlaceholderExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void EditorPlaceholderExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void _EditorPlaceholderExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public void ObjectLiteralExpr() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void ObjectLiteralExpr_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void _ObjectLiteralExpr() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public void TypeInitializerClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause);
    }

    public void TypeInitializerClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause);
    }

    public void _TypeInitializerClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause);
    }

    public void TypealiasDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl);
    }

    public void TypealiasDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl);
    }

    public void _TypealiasDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl);
    }

    public void AssociatedtypeDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void AssociatedtypeDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void _AssociatedtypeDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public void FunctionParameterList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList);
    }

    public void FunctionParameterList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList);
    }

    public void FunctionParameterList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList, initialCapacity);
    }

    public void _FunctionParameterList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList);
    }

    public void ParameterClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ParameterClause);
    }

    public void ParameterClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ParameterClause);
    }

    public void _ParameterClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ParameterClause);
    }

    public void ReturnClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ReturnClause);
    }

    public void ReturnClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ReturnClause);
    }

    public void _ReturnClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ReturnClause);
    }

    public void FunctionSignature() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionSignature);
    }

    public void FunctionSignature_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionSignature);
    }

    public void _FunctionSignature() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionSignature);
    }

    public void IfConfigClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigClause);
    }

    public void IfConfigClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IfConfigClause);
    }

    public void _IfConfigClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigClause);
    }

    public void IfConfigClauseList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList);
    }

    public void IfConfigClauseList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList);
    }

    public void IfConfigClauseList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList, initialCapacity);
    }

    public void _IfConfigClauseList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList);
    }

    public void IfConfigDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl);
    }

    public void IfConfigDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl);
    }

    public void _IfConfigDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl);
    }

    public void PoundErrorDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl);
    }

    public void PoundErrorDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl);
    }

    public void _PoundErrorDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl);
    }

    public void PoundWarningDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl);
    }

    public void PoundWarningDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl);
    }

    public void _PoundWarningDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl);
    }

    public void PoundSourceLocation() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation);
    }

    public void PoundSourceLocation_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation);
    }

    public void _PoundSourceLocation() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation);
    }

    public void PoundSourceLocationArgs() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void PoundSourceLocationArgs_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void _PoundSourceLocationArgs() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public void DeclModifier() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeclModifier);
    }

    public void DeclModifier_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclModifier);
    }

    public void _DeclModifier() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeclModifier);
    }

    public void InheritedType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.InheritedType);
    }

    public void InheritedType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InheritedType);
    }

    public void _InheritedType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.InheritedType);
    }

    public void InheritedTypeList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList);
    }

    public void InheritedTypeList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList);
    }

    public void InheritedTypeList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList, initialCapacity);
    }

    public void _InheritedTypeList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList);
    }

    public void TypeInheritanceClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause);
    }

    public void TypeInheritanceClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause);
    }

    public void _TypeInheritanceClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause);
    }

    public void ClassDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClassDecl);
    }

    public void ClassDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClassDecl);
    }

    public void _ClassDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClassDecl);
    }

    public void StructDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.StructDecl);
    }

    public void StructDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.StructDecl);
    }

    public void _StructDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.StructDecl);
    }

    public void ProtocolDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl);
    }

    public void ProtocolDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl);
    }

    public void _ProtocolDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl);
    }

    public void ExtensionDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl);
    }

    public void ExtensionDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl);
    }

    public void _ExtensionDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl);
    }

    public void MemberDeclBlock() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock);
    }

    public void MemberDeclBlock_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock);
    }

    public void _MemberDeclBlock() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock);
    }

    public void MemberDeclList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclList);
    }

    public void MemberDeclList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberDeclList);
    }

    public void MemberDeclList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberDeclList, initialCapacity);
    }

    public void _MemberDeclList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclList);
    }

    public void MemberDeclListItem() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem);
    }

    public void MemberDeclListItem_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem);
    }

    public void _MemberDeclListItem() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem);
    }

    public void SourceFile() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SourceFile);
    }

    public void SourceFile_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SourceFile);
    }

    public void _SourceFile() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SourceFile);
    }

    public void InitializerClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.InitializerClause);
    }

    public void InitializerClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InitializerClause);
    }

    public void _InitializerClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.InitializerClause);
    }

    public void FunctionParameter() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionParameter);
    }

    public void FunctionParameter_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionParameter);
    }

    public void _FunctionParameter() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionParameter);
    }

    public void ModifierList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public void ModifierList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public void ModifierList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ModifierList, initialCapacity);
    }

    public void _ModifierList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public void FunctionDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionDecl);
    }

    public void FunctionDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionDecl);
    }

    public void _FunctionDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionDecl);
    }

    public void InitializerDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.InitializerDecl);
    }

    public void InitializerDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.InitializerDecl);
    }

    public void _InitializerDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.InitializerDecl);
    }

    public void DeinitializerDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl);
    }

    public void DeinitializerDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl);
    }

    public void _DeinitializerDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl);
    }

    public void SubscriptDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl);
    }

    public void SubscriptDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl);
    }

    public void _SubscriptDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl);
    }

    public void AccessLevelModifier() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier);
    }

    public void AccessLevelModifier_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier);
    }

    public void _AccessLevelModifier() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier);
    }

    public void AccessPathComponent() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent);
    }

    public void AccessPathComponent_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent);
    }

    public void _AccessPathComponent() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent);
    }

    public void AccessPath() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessPath);
    }

    public void AccessPath_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessPath);
    }

    public void AccessPath_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessPath, initialCapacity);
    }

    public void _AccessPath() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessPath);
    }

    public void ImportDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ImportDecl);
    }

    public void ImportDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ImportDecl);
    }

    public void _ImportDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ImportDecl);
    }

    public void AccessorParameter() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorParameter);
    }

    public void AccessorParameter_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessorParameter);
    }

    public void _AccessorParameter() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorParameter);
    }

    public void AccessorDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorDecl);
    }

    public void AccessorDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessorDecl);
    }

    public void _AccessorDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorDecl);
    }

    public void AccessorList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorList);
    }

    public void AccessorList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessorList);
    }

    public void AccessorList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessorList, initialCapacity);
    }

    public void _AccessorList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorList);
    }

    public void AccessorBlock() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorBlock);
    }

    public void AccessorBlock_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AccessorBlock);
    }

    public void _AccessorBlock() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AccessorBlock);
    }

    public void PatternBinding() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PatternBinding);
    }

    public void PatternBinding_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PatternBinding);
    }

    public void _PatternBinding() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PatternBinding);
    }

    public void PatternBindingList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PatternBindingList);
    }

    public void PatternBindingList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PatternBindingList);
    }

    public void PatternBindingList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PatternBindingList, initialCapacity);
    }

    public void _PatternBindingList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PatternBindingList);
    }

    public void VariableDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.VariableDecl);
    }

    public void VariableDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.VariableDecl);
    }

    public void _VariableDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.VariableDecl);
    }

    public void EnumCaseElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement);
    }

    public void EnumCaseElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement);
    }

    public void _EnumCaseElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement);
    }

    public void EnumCaseElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList, initialCapacity);
    }

    public void _EnumCaseElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList);
    }

    public void EnumCaseDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl);
    }

    public void EnumCaseDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl);
    }

    public void _EnumCaseDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl);
    }

    public void EnumDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EnumDecl);
    }

    public void EnumDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumDecl);
    }

    public void _EnumDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EnumDecl);
    }

    public void OperatorDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OperatorDecl);
    }

    public void OperatorDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OperatorDecl);
    }

    public void _OperatorDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OperatorDecl);
    }

    public void IdentifierList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierList);
    }

    public void IdentifierList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IdentifierList);
    }

    public void IdentifierList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IdentifierList, initialCapacity);
    }

    public void _IdentifierList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierList);
    }

    public void OperatorPrecedenceAndTypes() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes);
    }

    public void OperatorPrecedenceAndTypes_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes);
    }

    public void _OperatorPrecedenceAndTypes() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes);
    }

    public void PrecedenceGroupDecl() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void PrecedenceGroupDecl_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void _PrecedenceGroupDecl() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public void PrecedenceGroupAttributeList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupAttributeList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupAttributeList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList, initialCapacity);
    }

    public void _PrecedenceGroupAttributeList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void PrecedenceGroupRelation() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void PrecedenceGroupRelation_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void _PrecedenceGroupRelation() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public void PrecedenceGroupNameList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void PrecedenceGroupNameList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void PrecedenceGroupNameList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList, initialCapacity);
    }

    public void _PrecedenceGroupNameList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public void PrecedenceGroupNameElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement);
    }

    public void PrecedenceGroupNameElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement);
    }

    public void _PrecedenceGroupNameElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement);
    }

    public void PrecedenceGroupAssignment() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void PrecedenceGroupAssignment_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void _PrecedenceGroupAssignment() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public void PrecedenceGroupAssociativity() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void PrecedenceGroupAssociativity_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void _PrecedenceGroupAssociativity() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public void TokenList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TokenList);
    }

    public void TokenList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TokenList);
    }

    public void TokenList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TokenList, initialCapacity);
    }

    public void _TokenList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TokenList);
    }

    public void CustomAttribute() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CustomAttribute);
    }

    public void CustomAttribute_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CustomAttribute);
    }

    public void _CustomAttribute() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CustomAttribute);
    }

    public void Attribute() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.Attribute);
    }

    public void Attribute_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.Attribute);
    }

    public void _Attribute() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.Attribute);
    }

    public void AttributeList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void AttributeList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void AttributeList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AttributeList, initialCapacity);
    }

    public void _AttributeList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void SpecializeAttributeSpecList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void SpecializeAttributeSpecList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void SpecializeAttributeSpecList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList, initialCapacity);
    }

    public void _SpecializeAttributeSpecList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public void LabeledSpecializeEntry() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void LabeledSpecializeEntry_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void _LabeledSpecializeEntry() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public void NamedAttributeStringArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void NamedAttributeStringArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void _NamedAttributeStringArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public void DeclName() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeclName);
    }

    public void DeclName_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeclName);
    }

    public void _DeclName() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeclName);
    }

    public void ImplementsAttributeArguments() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void ImplementsAttributeArguments_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void _ImplementsAttributeArguments() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public void ObjCSelectorPiece() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece);
    }

    public void ObjCSelectorPiece_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece);
    }

    public void _ObjCSelectorPiece() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece);
    }

    public void ObjCSelector() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ObjCSelector);
    }

    public void ObjCSelector_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjCSelector);
    }

    public void ObjCSelector_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ObjCSelector, initialCapacity);
    }

    public void _ObjCSelector() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ObjCSelector);
    }

    public void ContinueStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ContinueStmt);
    }

    public void ContinueStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ContinueStmt);
    }

    public void _ContinueStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ContinueStmt);
    }

    public void WhileStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.WhileStmt);
    }

    public void WhileStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.WhileStmt);
    }

    public void _WhileStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.WhileStmt);
    }

    public void DeferStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DeferStmt);
    }

    public void DeferStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DeferStmt);
    }

    public void _DeferStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DeferStmt);
    }

    public void SwitchCaseList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList);
    }

    public void SwitchCaseList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList);
    }

    public void SwitchCaseList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList, initialCapacity);
    }

    public void _SwitchCaseList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList);
    }

    public void RepeatWhileStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void RepeatWhileStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void _RepeatWhileStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt);
    }

    public void GuardStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GuardStmt);
    }

    public void GuardStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GuardStmt);
    }

    public void _GuardStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GuardStmt);
    }

    public void WhereClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.WhereClause);
    }

    public void WhereClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.WhereClause);
    }

    public void _WhereClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.WhereClause);
    }

    public void ForInStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ForInStmt);
    }

    public void ForInStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ForInStmt);
    }

    public void _ForInStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ForInStmt);
    }

    public void SwitchStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchStmt);
    }

    public void SwitchStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchStmt);
    }

    public void _SwitchStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchStmt);
    }

    public void CatchClauseList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CatchClauseList);
    }

    public void CatchClauseList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CatchClauseList);
    }

    public void CatchClauseList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CatchClauseList, initialCapacity);
    }

    public void _CatchClauseList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CatchClauseList);
    }

    public void DoStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DoStmt);
    }

    public void DoStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DoStmt);
    }

    public void _DoStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DoStmt);
    }

    public void ReturnStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ReturnStmt);
    }

    public void ReturnStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ReturnStmt);
    }

    public void _ReturnStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ReturnStmt);
    }

    public void YieldStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.YieldStmt);
    }

    public void YieldStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.YieldStmt);
    }

    public void _YieldStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.YieldStmt);
    }

    public void YieldList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.YieldList);
    }

    public void YieldList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.YieldList);
    }

    public void _YieldList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.YieldList);
    }

    public void FallthroughStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FallthroughStmt);
    }

    public void FallthroughStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FallthroughStmt);
    }

    public void _FallthroughStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FallthroughStmt);
    }

    public void BreakStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.BreakStmt);
    }

    public void BreakStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.BreakStmt);
    }

    public void _BreakStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.BreakStmt);
    }

    public void CaseItemList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CaseItemList);
    }

    public void CaseItemList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CaseItemList);
    }

    public void CaseItemList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CaseItemList, initialCapacity);
    }

    public void _CaseItemList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CaseItemList);
    }

    public void ConditionElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ConditionElement);
    }

    public void ConditionElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ConditionElement);
    }

    public void _ConditionElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ConditionElement);
    }

    public void AvailabilityCondition() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition);
    }

    public void AvailabilityCondition_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition);
    }

    public void _AvailabilityCondition() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition);
    }

    public void MatchingPatternCondition() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void MatchingPatternCondition_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void _MatchingPatternCondition() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition);
    }

    public void OptionalBindingCondition() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void OptionalBindingCondition_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void _OptionalBindingCondition() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition);
    }

    public void ConditionElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ConditionElementList);
    }

    public void ConditionElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ConditionElementList);
    }

    public void ConditionElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ConditionElementList, initialCapacity);
    }

    public void _ConditionElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ConditionElementList);
    }

    public void ThrowStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ThrowStmt);
    }

    public void ThrowStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ThrowStmt);
    }

    public void _ThrowStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ThrowStmt);
    }

    public void IfStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IfStmt);
    }

    public void IfStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IfStmt);
    }

    public void _IfStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IfStmt);
    }

    public void SwitchCase() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCase);
    }

    public void SwitchCase_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchCase);
    }

    public void _SwitchCase() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCase);
    }

    public void SwitchDefaultLabel() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void SwitchDefaultLabel_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void _SwitchDefaultLabel() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public void CaseItem() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CaseItem);
    }

    public void CaseItem_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CaseItem);
    }

    public void _CaseItem() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CaseItem);
    }

    public void SwitchCaseLabel() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void SwitchCaseLabel_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void _SwitchCaseLabel() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel);
    }

    public void CatchClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CatchClause);
    }

    public void CatchClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CatchClause);
    }

    public void _CatchClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CatchClause);
    }

    public void PoundAssertStmt() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt);
    }

    public void PoundAssertStmt_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt);
    }

    public void _PoundAssertStmt() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt);
    }

    public void GenericWhereClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause);
    }

    public void GenericWhereClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause);
    }

    public void _GenericWhereClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause);
    }

    public void GenericRequirementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList);
    }

    public void GenericRequirementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList);
    }

    public void GenericRequirementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList, initialCapacity);
    }

    public void _GenericRequirementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList);
    }

    public void SameTypeRequirement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement);
    }

    public void SameTypeRequirement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement);
    }

    public void _SameTypeRequirement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement);
    }

    public void GenericParameterList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameterList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameterList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericParameterList, initialCapacity);
    }

    public void _GenericParameterList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameterList);
    }

    public void GenericParameter() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameter);
    }

    public void GenericParameter_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericParameter);
    }

    public void _GenericParameter() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameter);
    }

    public void GenericParameterClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause);
    }

    public void GenericParameterClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause);
    }

    public void _GenericParameterClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause);
    }

    public void ConformanceRequirement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement);
    }

    public void ConformanceRequirement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement);
    }

    public void _ConformanceRequirement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement);
    }

    public void SimpleTypeIdentifier() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void SimpleTypeIdentifier_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void _SimpleTypeIdentifier() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public void MemberTypeIdentifier() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void MemberTypeIdentifier_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void _MemberTypeIdentifier() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public void ClassRestrictionType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType);
    }

    public void ClassRestrictionType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType);
    }

    public void _ClassRestrictionType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType);
    }

    public void ArrayType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayType);
    }

    public void ArrayType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ArrayType);
    }

    public void _ArrayType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ArrayType);
    }

    public void DictionaryType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryType);
    }

    public void DictionaryType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.DictionaryType);
    }

    public void _DictionaryType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.DictionaryType);
    }

    public void MetatypeType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.MetatypeType);
    }

    public void MetatypeType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.MetatypeType);
    }

    public void _MetatypeType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.MetatypeType);
    }

    public void OptionalType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalType);
    }

    public void OptionalType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OptionalType);
    }

    public void _OptionalType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalType);
    }

    public void SomeType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SomeType);
    }

    public void SomeType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.SomeType);
    }

    public void _SomeType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.SomeType);
    }

    public void ImplicitlyUnwrappedOptionalType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void ImplicitlyUnwrappedOptionalType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void _ImplicitlyUnwrappedOptionalType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public void CompositionTypeElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement);
    }

    public void CompositionTypeElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement);
    }

    public void _CompositionTypeElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement);
    }

    public void CompositionTypeElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList);
    }

    public void CompositionTypeElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList);
    }

    public void CompositionTypeElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList, initialCapacity);
    }

    public void _CompositionTypeElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList);
    }

    public void CompositionType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionType);
    }

    public void CompositionType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.CompositionType);
    }

    public void _CompositionType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.CompositionType);
    }

    public void TupleTypeElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement);
    }

    public void TupleTypeElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement);
    }

    public void _TupleTypeElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement);
    }

    public void TupleTypeElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleTypeElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleTypeElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList, initialCapacity);
    }

    public void _TupleTypeElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList);
    }

    public void TupleType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TupleType);
    }

    public void TupleType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TupleType);
    }

    public void _TupleType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TupleType);
    }

    public void FunctionType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionType);
    }

    public void FunctionType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.FunctionType);
    }

    public void _FunctionType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.FunctionType);
    }

    public void AttributedType() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AttributedType);
    }

    public void AttributedType_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AttributedType);
    }

    public void _AttributedType() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AttributedType);
    }

    public void GenericArgumentList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList);
    }

    public void GenericArgumentList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList);
    }

    public void GenericArgumentList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList, initialCapacity);
    }

    public void _GenericArgumentList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList);
    }

    public void GenericArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgument);
    }

    public void GenericArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericArgument);
    }

    public void _GenericArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgument);
    }

    public void GenericArgumentClause() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause);
    }

    public void GenericArgumentClause_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause);
    }

    public void _GenericArgumentClause() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause);
    }

    public void TypeAnnotation() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation);
    }

    public void TypeAnnotation_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation);
    }

    public void _TypeAnnotation() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation);
    }

    public void EnumCasePattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern);
    }

    public void EnumCasePattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern);
    }

    public void _EnumCasePattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern);
    }

    public void IsTypePattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IsTypePattern);
    }

    public void IsTypePattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IsTypePattern);
    }

    public void _IsTypePattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IsTypePattern);
    }

    public void OptionalPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalPattern);
    }

    public void OptionalPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.OptionalPattern);
    }

    public void _OptionalPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.OptionalPattern);
    }

    public void IdentifierPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierPattern);
    }

    public void IdentifierPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.IdentifierPattern);
    }

    public void _IdentifierPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.IdentifierPattern);
    }

    public void AsTypePattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AsTypePattern);
    }

    public void AsTypePattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AsTypePattern);
    }

    public void _AsTypePattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AsTypePattern);
    }

    public void TuplePattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePattern);
    }

    public void TuplePattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TuplePattern);
    }

    public void _TuplePattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePattern);
    }

    public void WildcardPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.WildcardPattern);
    }

    public void WildcardPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.WildcardPattern);
    }

    public void _WildcardPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.WildcardPattern);
    }

    public void TuplePatternElement() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement);
    }

    public void TuplePatternElement_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement);
    }

    public void _TuplePatternElement() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement);
    }

    public void ExpressionPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ExpressionPattern);
    }

    public void ExpressionPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ExpressionPattern);
    }

    public void _ExpressionPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ExpressionPattern);
    }

    public void TuplePatternElementList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList);
    }

    public void TuplePatternElementList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList);
    }

    public void TuplePatternElementList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList, initialCapacity);
    }

    public void _TuplePatternElementList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList);
    }

    public void ValueBindingPattern() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern);
    }

    public void ValueBindingPattern_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern);
    }

    public void _ValueBindingPattern() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern);
    }

    public void AvailabilitySpecList() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void AvailabilitySpecList_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void AvailabilitySpecList_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList, initialCapacity);
    }

    public void _AvailabilitySpecList() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList);
    }

    public void AvailabilityArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument);
    }

    public void AvailabilityArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument);
    }

    public void _AvailabilityArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument);
    }

    public void AvailabilityLabeledArgument() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void AvailabilityLabeledArgument_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void _AvailabilityLabeledArgument() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public void AvailabilityVersionRestriction() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void AvailabilityVersionRestriction_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void _AvailabilityVersionRestriction() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public void VersionTuple() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.VersionTuple);
    }

    public void VersionTuple_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.VersionTuple);
    }

    public void _VersionTuple() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.VersionTuple);
    }

    public void TokenKind() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TokenKind);
    }

    public void TokenKind(TokenKindEnum.Value value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TokenKind, value);
    }

    public void TokenKind(String value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TokenKind, value);
    }

    public void Text() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.Text);
    }

    public void Text(String value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.Text, value);
    }

    public void Trivia() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public void Trivia_() {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public void Trivia_(int initialCapacity) {
        wEntity_(SwiftSyntaxEntityDescriptorEnum.Trivia, initialCapacity);
    }

    public void _Trivia() {
        _wEntity(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public void TriviaPiece() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TriviaPiece);
    }

    public void TriviaPiece(String value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.TriviaPiece, value);
    }

    public void SourcePresence() {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SourcePresence);
    }

    public void SourcePresence(SourcePresenceEnum.Value value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SourcePresence, value);
    }

    public void SourcePresence(String value) {
        wEntity(SwiftSyntaxEntityDescriptorEnum.SourcePresence, value);
    }
}
