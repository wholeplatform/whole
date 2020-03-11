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

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftSyntaxModelContext extends EntityContext {

    public SwiftSyntaxModelContext(IEntity root) {
        super(root);
    }

    public SwiftSyntaxModelContext getKind() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.kind);
    }

    public void setKind(SwiftSyntaxModelContext kind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.kind, kind);
    }

    public SwiftSyntaxModelContext getPresence() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.presence);
    }

    public void setPresence(SwiftSyntaxModelContext presence) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.presence, presence);
    }

    public SwiftSyntaxModelContext getLeadingTrivia() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia);
    }

    public void setLeadingTrivia(SwiftSyntaxModelContext leadingTrivia) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia, leadingTrivia);
    }

    public SwiftSyntaxModelContext getTrailingTrivia() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia);
    }

    public void setTrailingTrivia(SwiftSyntaxModelContext trailingTrivia) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia, trailingTrivia);
    }

    public SwiftSyntaxModelContext getText() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.text);
    }

    public void setText(SwiftSyntaxModelContext text) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.text, text);
    }

    public SwiftSyntaxModelContext getItem() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.item);
    }

    public void setItem(SwiftSyntaxModelContext item) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.item, item);
    }

    public SwiftSyntaxModelContext getSemicolon() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.semicolon);
    }

    public void setSemicolon(SwiftSyntaxModelContext semicolon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.semicolon, semicolon);
    }

    public SwiftSyntaxModelContext getErrorTokens() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.errorTokens);
    }

    public void setErrorTokens(SwiftSyntaxModelContext errorTokens) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.errorTokens, errorTokens);
    }

    public SwiftSyntaxModelContext getLeftBrace() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftBrace);
    }

    public void setLeftBrace(SwiftSyntaxModelContext leftBrace) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public SwiftSyntaxModelContext getStatements() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.statements);
    }

    public void setStatements(SwiftSyntaxModelContext statements) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.statements, statements);
    }

    public SwiftSyntaxModelContext getRightBrace() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightBrace);
    }

    public void setRightBrace(SwiftSyntaxModelContext rightBrace) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightBrace, rightBrace);
    }

    public SwiftSyntaxModelContext getAmpersand() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.ampersand);
    }

    public void setAmpersand(SwiftSyntaxModelContext ampersand) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.ampersand, ampersand);
    }

    public SwiftSyntaxModelContext getExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.expression);
    }

    public void setExpression(SwiftSyntaxModelContext expression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.expression, expression);
    }

    public SwiftSyntaxModelContext getPoundColumn() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundColumn);
    }

    public void setPoundColumn(SwiftSyntaxModelContext poundColumn) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundColumn, poundColumn);
    }

    public SwiftSyntaxModelContext getTryKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.tryKeyword);
    }

    public void setTryKeyword(SwiftSyntaxModelContext tryKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.tryKeyword, tryKeyword);
    }

    public SwiftSyntaxModelContext getQuestionOrExclamationMark() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark);
    }

    public void setQuestionOrExclamationMark(SwiftSyntaxModelContext questionOrExclamationMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark, questionOrExclamationMark);
    }

    public SwiftSyntaxModelContext getName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.name);
    }

    public void setName(SwiftSyntaxModelContext name) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public SwiftSyntaxModelContext getColon() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.colon);
    }

    public void setColon(SwiftSyntaxModelContext colon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public SwiftSyntaxModelContext getLeftParen() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftParen);
    }

    public void setLeftParen(SwiftSyntaxModelContext leftParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public SwiftSyntaxModelContext getArguments() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.arguments);
    }

    public void setArguments(SwiftSyntaxModelContext arguments) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.arguments, arguments);
    }

    public SwiftSyntaxModelContext getRightParen() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightParen);
    }

    public void setRightParen(SwiftSyntaxModelContext rightParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightParen, rightParen);
    }

    public SwiftSyntaxModelContext getIdentifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.identifier);
    }

    public void setIdentifier(SwiftSyntaxModelContext identifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public SwiftSyntaxModelContext getDeclNameArguments() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.declNameArguments);
    }

    public void setDeclNameArguments(SwiftSyntaxModelContext declNameArguments) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public SwiftSyntaxModelContext getSuperKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.superKeyword);
    }

    public void setSuperKeyword(SwiftSyntaxModelContext superKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.superKeyword, superKeyword);
    }

    public SwiftSyntaxModelContext getNilKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.nilKeyword);
    }

    public void setNilKeyword(SwiftSyntaxModelContext nilKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.nilKeyword, nilKeyword);
    }

    public SwiftSyntaxModelContext getWildcard() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.wildcard);
    }

    public void setWildcard(SwiftSyntaxModelContext wildcard) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.wildcard, wildcard);
    }

    public SwiftSyntaxModelContext getAssignToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.assignToken);
    }

    public void setAssignToken(SwiftSyntaxModelContext assignToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.assignToken, assignToken);
    }

    public SwiftSyntaxModelContext getElements() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.elements);
    }

    public void setElements(SwiftSyntaxModelContext elements) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elements, elements);
    }

    public SwiftSyntaxModelContext getPoundLine() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundLine);
    }

    public void setPoundLine(SwiftSyntaxModelContext poundLine) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundLine, poundLine);
    }

    public SwiftSyntaxModelContext getPoundFile() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundFile);
    }

    public void setPoundFile(SwiftSyntaxModelContext poundFile) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundFile, poundFile);
    }

    public SwiftSyntaxModelContext getPoundFunction() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundFunction);
    }

    public void setPoundFunction(SwiftSyntaxModelContext poundFunction) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundFunction, poundFunction);
    }

    public SwiftSyntaxModelContext getPoundDsohandle() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundDsohandle);
    }

    public void setPoundDsohandle(SwiftSyntaxModelContext poundDsohandle) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundDsohandle, poundDsohandle);
    }

    public SwiftSyntaxModelContext getGenericArgumentClause() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause);
    }

    public void setGenericArgumentClause(SwiftSyntaxModelContext genericArgumentClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }

    public SwiftSyntaxModelContext getOperatorToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.operatorToken);
    }

    public void setOperatorToken(SwiftSyntaxModelContext operatorToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.operatorToken, operatorToken);
    }

    public SwiftSyntaxModelContext getPostfixExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.postfixExpression);
    }

    public void setPostfixExpression(SwiftSyntaxModelContext postfixExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.postfixExpression, postfixExpression);
    }

    public SwiftSyntaxModelContext getThrowsToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.throwsToken);
    }

    public void setThrowsToken(SwiftSyntaxModelContext throwsToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwsToken, throwsToken);
    }

    public SwiftSyntaxModelContext getArrowToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.arrowToken);
    }

    public void setArrowToken(SwiftSyntaxModelContext arrowToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.arrowToken, arrowToken);
    }

    public SwiftSyntaxModelContext getFloatingDigits() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.floatingDigits);
    }

    public void setFloatingDigits(SwiftSyntaxModelContext floatingDigits) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.floatingDigits, floatingDigits);
    }

    public SwiftSyntaxModelContext getElementList() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.elementList);
    }

    public void setElementList(SwiftSyntaxModelContext elementList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elementList, elementList);
    }

    public SwiftSyntaxModelContext getLeftSquare() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftSquare);
    }

    public void setLeftSquare(SwiftSyntaxModelContext leftSquare) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftSquare, leftSquare);
    }

    public SwiftSyntaxModelContext getRightSquare() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightSquare);
    }

    public void setRightSquare(SwiftSyntaxModelContext rightSquare) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightSquare, rightSquare);
    }

    public SwiftSyntaxModelContext getContent() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.content);
    }

    public void setContent(SwiftSyntaxModelContext content) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.content, content);
    }

    public SwiftSyntaxModelContext getLabel() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.label);
    }

    public void setLabel(SwiftSyntaxModelContext label) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.label, label);
    }

    public SwiftSyntaxModelContext getTrailingComma() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.trailingComma);
    }

    public void setTrailingComma(SwiftSyntaxModelContext trailingComma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }

    public SwiftSyntaxModelContext getKeyExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.keyExpression);
    }

    public void setKeyExpression(SwiftSyntaxModelContext keyExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.keyExpression, keyExpression);
    }

    public SwiftSyntaxModelContext getValueExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.valueExpression);
    }

    public void setValueExpression(SwiftSyntaxModelContext valueExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.valueExpression, valueExpression);
    }

    public SwiftSyntaxModelContext getDigits() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.digits);
    }

    public void setDigits(SwiftSyntaxModelContext digits) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.digits, digits);
    }

    public SwiftSyntaxModelContext getBooleanLiteral() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.booleanLiteral);
    }

    public void setBooleanLiteral(SwiftSyntaxModelContext booleanLiteral) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.booleanLiteral, booleanLiteral);
    }

    public SwiftSyntaxModelContext getConditionExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.conditionExpression);
    }

    public void setConditionExpression(SwiftSyntaxModelContext conditionExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.conditionExpression, conditionExpression);
    }

    public SwiftSyntaxModelContext getQuestionMark() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.questionMark);
    }

    public void setQuestionMark(SwiftSyntaxModelContext questionMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.questionMark, questionMark);
    }

    public SwiftSyntaxModelContext getFirstChoice() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.firstChoice);
    }

    public void setFirstChoice(SwiftSyntaxModelContext firstChoice) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.firstChoice, firstChoice);
    }

    public SwiftSyntaxModelContext getColonMark() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.colonMark);
    }

    public void setColonMark(SwiftSyntaxModelContext colonMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.colonMark, colonMark);
    }

    public SwiftSyntaxModelContext getSecondChoice() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.secondChoice);
    }

    public void setSecondChoice(SwiftSyntaxModelContext secondChoice) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.secondChoice, secondChoice);
    }

    public SwiftSyntaxModelContext getBase() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.base);
    }

    public void setBase(SwiftSyntaxModelContext base) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.base, base);
    }

    public SwiftSyntaxModelContext getDot() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.dot);
    }

    public void setDot(SwiftSyntaxModelContext dot) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.dot, dot);
    }

    public SwiftSyntaxModelContext getIsTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.isTok);
    }

    public void setIsTok(SwiftSyntaxModelContext isTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.isTok, isTok);
    }

    public SwiftSyntaxModelContext getTypeName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.typeName);
    }

    public void setTypeName(SwiftSyntaxModelContext typeName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.typeName, typeName);
    }

    public SwiftSyntaxModelContext getAsTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.asTok);
    }

    public void setAsTok(SwiftSyntaxModelContext asTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.asTok, asTok);
    }

    public SwiftSyntaxModelContext getType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.type);
    }

    public void setType(SwiftSyntaxModelContext type) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public SwiftSyntaxModelContext getSpecifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.specifier);
    }

    public void setSpecifier(SwiftSyntaxModelContext specifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.specifier, specifier);
    }

    public SwiftSyntaxModelContext getItems() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.items);
    }

    public void setItems(SwiftSyntaxModelContext items) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.items, items);
    }

    public SwiftSyntaxModelContext getCapture() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.capture);
    }

    public void setCapture(SwiftSyntaxModelContext capture) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.capture, capture);
    }

    public SwiftSyntaxModelContext getInput() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.input);
    }

    public void setInput(SwiftSyntaxModelContext input) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.input, input);
    }

    public SwiftSyntaxModelContext getThrowsTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.throwsTok);
    }

    public void setThrowsTok(SwiftSyntaxModelContext throwsTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public SwiftSyntaxModelContext getOutput() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.output);
    }

    public void setOutput(SwiftSyntaxModelContext output) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.output, output);
    }

    public SwiftSyntaxModelContext getInTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inTok);
    }

    public void setInTok(SwiftSyntaxModelContext inTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inTok, inTok);
    }

    public SwiftSyntaxModelContext getSignature() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.signature);
    }

    public void setSignature(SwiftSyntaxModelContext signature) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.signature, signature);
    }

    public SwiftSyntaxModelContext getPattern() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.pattern);
    }

    public void setPattern(SwiftSyntaxModelContext pattern) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public SwiftSyntaxModelContext getCalledExpression() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.calledExpression);
    }

    public void setCalledExpression(SwiftSyntaxModelContext calledExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public SwiftSyntaxModelContext getArgumentList() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.argumentList);
    }

    public void setArgumentList(SwiftSyntaxModelContext argumentList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.argumentList, argumentList);
    }

    public SwiftSyntaxModelContext getTrailingClosure() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.trailingClosure);
    }

    public void setTrailingClosure(SwiftSyntaxModelContext trailingClosure) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }

    public SwiftSyntaxModelContext getLeftBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftBracket);
    }

    public void setLeftBracket(SwiftSyntaxModelContext leftBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftBracket, leftBracket);
    }

    public SwiftSyntaxModelContext getRightBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightBracket);
    }

    public void setRightBracket(SwiftSyntaxModelContext rightBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightBracket, rightBracket);
    }

    public SwiftSyntaxModelContext getExclamationMark() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.exclamationMark);
    }

    public void setExclamationMark(SwiftSyntaxModelContext exclamationMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.exclamationMark, exclamationMark);
    }

    public SwiftSyntaxModelContext getBackslash() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.backslash);
    }

    public void setBackslash(SwiftSyntaxModelContext backslash) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.backslash, backslash);
    }

    public SwiftSyntaxModelContext getDelimiter() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.delimiter);
    }

    public void setDelimiter(SwiftSyntaxModelContext delimiter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.delimiter, delimiter);
    }

    public SwiftSyntaxModelContext getExpressions() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.expressions);
    }

    public void setExpressions(SwiftSyntaxModelContext expressions) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.expressions, expressions);
    }

    public SwiftSyntaxModelContext getOpenDelimiter() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.openDelimiter);
    }

    public void setOpenDelimiter(SwiftSyntaxModelContext openDelimiter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.openDelimiter, openDelimiter);
    }

    public SwiftSyntaxModelContext getOpenQuote() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.openQuote);
    }

    public void setOpenQuote(SwiftSyntaxModelContext openQuote) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.openQuote, openQuote);
    }

    public SwiftSyntaxModelContext getSegments() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.segments);
    }

    public void setSegments(SwiftSyntaxModelContext segments) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.segments, segments);
    }

    public SwiftSyntaxModelContext getCloseQuote() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.closeQuote);
    }

    public void setCloseQuote(SwiftSyntaxModelContext closeQuote) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.closeQuote, closeQuote);
    }

    public SwiftSyntaxModelContext getCloseDelimiter() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter);
    }

    public void setCloseDelimiter(SwiftSyntaxModelContext closeDelimiter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter, closeDelimiter);
    }

    public SwiftSyntaxModelContext getRootExpr() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rootExpr);
    }

    public void setRootExpr(SwiftSyntaxModelContext rootExpr) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rootExpr, rootExpr);
    }

    public SwiftSyntaxModelContext getPeriod() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.period);
    }

    public void setPeriod(SwiftSyntaxModelContext period) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.period, period);
    }

    public SwiftSyntaxModelContext getKeyPath() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.keyPath);
    }

    public void setKeyPath(SwiftSyntaxModelContext keyPath) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.keyPath, keyPath);
    }

    public SwiftSyntaxModelContext getPoundSelector() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundSelector);
    }

    public void setPoundSelector(SwiftSyntaxModelContext poundSelector) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundSelector, poundSelector);
    }

    public SwiftSyntaxModelContext getEqual() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.equal);
    }

    public void setEqual(SwiftSyntaxModelContext equal) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.equal, equal);
    }

    public SwiftSyntaxModelContext getValue() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.value);
    }

    public void setValue(SwiftSyntaxModelContext value) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.value, value);
    }

    public SwiftSyntaxModelContext getAttributes() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.attributes);
    }

    public void setAttributes(SwiftSyntaxModelContext attributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public SwiftSyntaxModelContext getModifiers() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.modifiers);
    }

    public void setModifiers(SwiftSyntaxModelContext modifiers) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.modifiers, modifiers);
    }

    public SwiftSyntaxModelContext getTypealiasKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.typealiasKeyword);
    }

    public void setTypealiasKeyword(SwiftSyntaxModelContext typealiasKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.typealiasKeyword, typealiasKeyword);
    }

    public SwiftSyntaxModelContext getGenericParameterClause() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause);
    }

    public void setGenericParameterClause(SwiftSyntaxModelContext genericParameterClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public SwiftSyntaxModelContext getInitializer() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.initializer);
    }

    public void setInitializer(SwiftSyntaxModelContext initializer) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.initializer, initializer);
    }

    public SwiftSyntaxModelContext getGenericWhereClause() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause);
    }

    public void setGenericWhereClause(SwiftSyntaxModelContext genericWhereClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public SwiftSyntaxModelContext getAssociatedtypeKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword);
    }

    public void setAssociatedtypeKeyword(SwiftSyntaxModelContext associatedtypeKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword, associatedtypeKeyword);
    }

    public SwiftSyntaxModelContext getInheritanceClause() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause);
    }

    public void setInheritanceClause(SwiftSyntaxModelContext inheritanceClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public SwiftSyntaxModelContext getParameterList() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.parameterList);
    }

    public void setParameterList(SwiftSyntaxModelContext parameterList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.parameterList, parameterList);
    }

    public SwiftSyntaxModelContext getArrow() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.arrow);
    }

    public void setArrow(SwiftSyntaxModelContext arrow) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.arrow, arrow);
    }

    public SwiftSyntaxModelContext getReturnType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.returnType);
    }

    public void setReturnType(SwiftSyntaxModelContext returnType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.returnType, returnType);
    }

    public SwiftSyntaxModelContext getThrowsOrRethrowsKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(SwiftSyntaxModelContext throwsOrRethrowsKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public SwiftSyntaxModelContext getPoundKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundKeyword);
    }

    public void setPoundKeyword(SwiftSyntaxModelContext poundKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundKeyword, poundKeyword);
    }

    public SwiftSyntaxModelContext getCondition() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.condition);
    }

    public void setCondition(SwiftSyntaxModelContext condition) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.condition, condition);
    }

    public SwiftSyntaxModelContext getClauses() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.clauses);
    }

    public void setClauses(SwiftSyntaxModelContext clauses) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.clauses, clauses);
    }

    public SwiftSyntaxModelContext getPoundEndif() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundEndif);
    }

    public void setPoundEndif(SwiftSyntaxModelContext poundEndif) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundEndif, poundEndif);
    }

    public SwiftSyntaxModelContext getPoundError() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundError);
    }

    public void setPoundError(SwiftSyntaxModelContext poundError) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundError, poundError);
    }

    public SwiftSyntaxModelContext getMessage() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.message);
    }

    public void setMessage(SwiftSyntaxModelContext message) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.message, message);
    }

    public SwiftSyntaxModelContext getPoundWarning() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundWarning);
    }

    public void setPoundWarning(SwiftSyntaxModelContext poundWarning) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundWarning, poundWarning);
    }

    public SwiftSyntaxModelContext getPoundSourceLocation() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundSourceLocation);
    }

    public void setPoundSourceLocation(SwiftSyntaxModelContext poundSourceLocation) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundSourceLocation, poundSourceLocation);
    }

    public SwiftSyntaxModelContext getArgs() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.args);
    }

    public void setArgs(SwiftSyntaxModelContext args) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.args, args);
    }

    public SwiftSyntaxModelContext getFileArgLabel() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel);
    }

    public void setFileArgLabel(SwiftSyntaxModelContext fileArgLabel) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel, fileArgLabel);
    }

    public SwiftSyntaxModelContext getFileArgColon() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.fileArgColon);
    }

    public void setFileArgColon(SwiftSyntaxModelContext fileArgColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileArgColon, fileArgColon);
    }

    public SwiftSyntaxModelContext getFileName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.fileName);
    }

    public void setFileName(SwiftSyntaxModelContext fileName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileName, fileName);
    }

    public SwiftSyntaxModelContext getComma() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.comma);
    }

    public void setComma(SwiftSyntaxModelContext comma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.comma, comma);
    }

    public SwiftSyntaxModelContext getLineArgLabel() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel);
    }

    public void setLineArgLabel(SwiftSyntaxModelContext lineArgLabel) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel, lineArgLabel);
    }

    public SwiftSyntaxModelContext getLineArgColon() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.lineArgColon);
    }

    public void setLineArgColon(SwiftSyntaxModelContext lineArgColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineArgColon, lineArgColon);
    }

    public SwiftSyntaxModelContext getLineNumber() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.lineNumber);
    }

    public void setLineNumber(SwiftSyntaxModelContext lineNumber) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineNumber, lineNumber);
    }

    public SwiftSyntaxModelContext getDetailLeftParen() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.detailLeftParen);
    }

    public void setDetailLeftParen(SwiftSyntaxModelContext detailLeftParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.detailLeftParen, detailLeftParen);
    }

    public SwiftSyntaxModelContext getDetail() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.detail);
    }

    public void setDetail(SwiftSyntaxModelContext detail) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.detail, detail);
    }

    public SwiftSyntaxModelContext getDetailRightParen() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.detailRightParen);
    }

    public void setDetailRightParen(SwiftSyntaxModelContext detailRightParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.detailRightParen, detailRightParen);
    }

    public SwiftSyntaxModelContext getInheritedTypeCollection() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inheritedTypeCollection);
    }

    public void setInheritedTypeCollection(SwiftSyntaxModelContext inheritedTypeCollection) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inheritedTypeCollection, inheritedTypeCollection);
    }

    public SwiftSyntaxModelContext getClassKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.classKeyword);
    }

    public void setClassKeyword(SwiftSyntaxModelContext classKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.classKeyword, classKeyword);
    }

    public SwiftSyntaxModelContext getMembers() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.members);
    }

    public void setMembers(SwiftSyntaxModelContext members) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.members, members);
    }

    public SwiftSyntaxModelContext getStructKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.structKeyword);
    }

    public void setStructKeyword(SwiftSyntaxModelContext structKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.structKeyword, structKeyword);
    }

    public SwiftSyntaxModelContext getProtocolKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.protocolKeyword);
    }

    public void setProtocolKeyword(SwiftSyntaxModelContext protocolKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.protocolKeyword, protocolKeyword);
    }

    public SwiftSyntaxModelContext getExtensionKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.extensionKeyword);
    }

    public void setExtensionKeyword(SwiftSyntaxModelContext extensionKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.extensionKeyword, extensionKeyword);
    }

    public SwiftSyntaxModelContext getExtendedType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.extendedType);
    }

    public void setExtendedType(SwiftSyntaxModelContext extendedType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.extendedType, extendedType);
    }

    public SwiftSyntaxModelContext getDecl() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.decl);
    }

    public void setDecl(SwiftSyntaxModelContext decl) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.decl, decl);
    }

    public SwiftSyntaxModelContext getEofToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.eofToken);
    }

    public void setEofToken(SwiftSyntaxModelContext eofToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.eofToken, eofToken);
    }

    public SwiftSyntaxModelContext getFirstName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.firstName);
    }

    public void setFirstName(SwiftSyntaxModelContext firstName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.firstName, firstName);
    }

    public SwiftSyntaxModelContext getSecondName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.secondName);
    }

    public void setSecondName(SwiftSyntaxModelContext secondName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.secondName, secondName);
    }

    public SwiftSyntaxModelContext getEllipsis() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.ellipsis);
    }

    public void setEllipsis(SwiftSyntaxModelContext ellipsis) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public SwiftSyntaxModelContext getDefaultArgument() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.defaultArgument);
    }

    public void setDefaultArgument(SwiftSyntaxModelContext defaultArgument) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.defaultArgument, defaultArgument);
    }

    public SwiftSyntaxModelContext getFuncKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.funcKeyword);
    }

    public void setFuncKeyword(SwiftSyntaxModelContext funcKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.funcKeyword, funcKeyword);
    }

    public SwiftSyntaxModelContext getBody() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.body);
    }

    public void setBody(SwiftSyntaxModelContext body) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public SwiftSyntaxModelContext getInitKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.initKeyword);
    }

    public void setInitKeyword(SwiftSyntaxModelContext initKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.initKeyword, initKeyword);
    }

    public SwiftSyntaxModelContext getOptionalMark() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.optionalMark);
    }

    public void setOptionalMark(SwiftSyntaxModelContext optionalMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.optionalMark, optionalMark);
    }

    public SwiftSyntaxModelContext getParameters() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.parameters);
    }

    public void setParameters(SwiftSyntaxModelContext parameters) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.parameters, parameters);
    }

    public SwiftSyntaxModelContext getDeinitKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.deinitKeyword);
    }

    public void setDeinitKeyword(SwiftSyntaxModelContext deinitKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.deinitKeyword, deinitKeyword);
    }

    public SwiftSyntaxModelContext getSubscriptKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword);
    }

    public void setSubscriptKeyword(SwiftSyntaxModelContext subscriptKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword, subscriptKeyword);
    }

    public SwiftSyntaxModelContext getIndices() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.indices);
    }

    public void setIndices(SwiftSyntaxModelContext indices) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.indices, indices);
    }

    public SwiftSyntaxModelContext getResult() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.result);
    }

    public void setResult(SwiftSyntaxModelContext result) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.result, result);
    }

    public SwiftSyntaxModelContext getAccessor() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.accessor);
    }

    public void setAccessor(SwiftSyntaxModelContext accessor) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.accessor, accessor);
    }

    public SwiftSyntaxModelContext getModifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.modifier);
    }

    public void setModifier(SwiftSyntaxModelContext modifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.modifier, modifier);
    }

    public SwiftSyntaxModelContext getTrailingDot() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.trailingDot);
    }

    public void setTrailingDot(SwiftSyntaxModelContext trailingDot) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingDot, trailingDot);
    }

    public SwiftSyntaxModelContext getImportTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.importTok);
    }

    public void setImportTok(SwiftSyntaxModelContext importTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.importTok, importTok);
    }

    public SwiftSyntaxModelContext getImportKind() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.importKind);
    }

    public void setImportKind(SwiftSyntaxModelContext importKind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.importKind, importKind);
    }

    public SwiftSyntaxModelContext getPath() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.path);
    }

    public void setPath(SwiftSyntaxModelContext path) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.path, path);
    }

    public SwiftSyntaxModelContext getAccessorKind() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.accessorKind);
    }

    public void setAccessorKind(SwiftSyntaxModelContext accessorKind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.accessorKind, accessorKind);
    }

    public SwiftSyntaxModelContext getParameter() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.parameter);
    }

    public void setParameter(SwiftSyntaxModelContext parameter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.parameter, parameter);
    }

    public SwiftSyntaxModelContext getAccessors() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.accessors);
    }

    public void setAccessors(SwiftSyntaxModelContext accessors) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.accessors, accessors);
    }

    public SwiftSyntaxModelContext getTypeAnnotation() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation);
    }

    public void setTypeAnnotation(SwiftSyntaxModelContext typeAnnotation) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public SwiftSyntaxModelContext getLetOrVarKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword);
    }

    public void setLetOrVarKeyword(SwiftSyntaxModelContext letOrVarKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword, letOrVarKeyword);
    }

    public SwiftSyntaxModelContext getBindings() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.bindings);
    }

    public void setBindings(SwiftSyntaxModelContext bindings) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.bindings, bindings);
    }

    public SwiftSyntaxModelContext getAssociatedValue() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.associatedValue);
    }

    public void setAssociatedValue(SwiftSyntaxModelContext associatedValue) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.associatedValue, associatedValue);
    }

    public SwiftSyntaxModelContext getRawValue() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rawValue);
    }

    public void setRawValue(SwiftSyntaxModelContext rawValue) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rawValue, rawValue);
    }

    public SwiftSyntaxModelContext getCaseKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.caseKeyword);
    }

    public void setCaseKeyword(SwiftSyntaxModelContext caseKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public SwiftSyntaxModelContext getEnumKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.enumKeyword);
    }

    public void setEnumKeyword(SwiftSyntaxModelContext enumKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.enumKeyword, enumKeyword);
    }

    public SwiftSyntaxModelContext getGenericParameters() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.genericParameters);
    }

    public void setGenericParameters(SwiftSyntaxModelContext genericParameters) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericParameters, genericParameters);
    }

    public SwiftSyntaxModelContext getOperatorKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.operatorKeyword);
    }

    public void setOperatorKeyword(SwiftSyntaxModelContext operatorKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.operatorKeyword, operatorKeyword);
    }

    public SwiftSyntaxModelContext getOperatorPrecedenceAndTypes() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.operatorPrecedenceAndTypes);
    }

    public void setOperatorPrecedenceAndTypes(SwiftSyntaxModelContext operatorPrecedenceAndTypes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.operatorPrecedenceAndTypes, operatorPrecedenceAndTypes);
    }

    public SwiftSyntaxModelContext getPrecedenceGroupAndDesignatedTypes() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.precedenceGroupAndDesignatedTypes);
    }

    public void setPrecedenceGroupAndDesignatedTypes(SwiftSyntaxModelContext precedenceGroupAndDesignatedTypes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.precedenceGroupAndDesignatedTypes, precedenceGroupAndDesignatedTypes);
    }

    public SwiftSyntaxModelContext getPrecedencegroupKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword);
    }

    public void setPrecedencegroupKeyword(SwiftSyntaxModelContext precedencegroupKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword, precedencegroupKeyword);
    }

    public SwiftSyntaxModelContext getGroupAttributes() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.groupAttributes);
    }

    public void setGroupAttributes(SwiftSyntaxModelContext groupAttributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.groupAttributes, groupAttributes);
    }

    public SwiftSyntaxModelContext getHigherThanOrLowerThan() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan);
    }

    public void setHigherThanOrLowerThan(SwiftSyntaxModelContext higherThanOrLowerThan) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan, higherThanOrLowerThan);
    }

    public SwiftSyntaxModelContext getOtherNames() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.otherNames);
    }

    public void setOtherNames(SwiftSyntaxModelContext otherNames) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.otherNames, otherNames);
    }

    public SwiftSyntaxModelContext getAssignmentKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.assignmentKeyword);
    }

    public void setAssignmentKeyword(SwiftSyntaxModelContext assignmentKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.assignmentKeyword, assignmentKeyword);
    }

    public SwiftSyntaxModelContext getFlag() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.flag);
    }

    public void setFlag(SwiftSyntaxModelContext flag) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.flag, flag);
    }

    public SwiftSyntaxModelContext getAssociativityKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.associativityKeyword);
    }

    public void setAssociativityKeyword(SwiftSyntaxModelContext associativityKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.associativityKeyword, associativityKeyword);
    }

    public SwiftSyntaxModelContext getAtSignToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.atSignToken);
    }

    public void setAtSignToken(SwiftSyntaxModelContext atSignToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.atSignToken, atSignToken);
    }

    public SwiftSyntaxModelContext getAttributeName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.attributeName);
    }

    public void setAttributeName(SwiftSyntaxModelContext attributeName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.attributeName, attributeName);
    }

    public SwiftSyntaxModelContext getArgument() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.argument);
    }

    public void setArgument(SwiftSyntaxModelContext argument) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.argument, argument);
    }

    public SwiftSyntaxModelContext getNameTok() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.nameTok);
    }

    public void setNameTok(SwiftSyntaxModelContext nameTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.nameTok, nameTok);
    }

    public SwiftSyntaxModelContext getStringOrDeclname() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.stringOrDeclname);
    }

    public void setStringOrDeclname(SwiftSyntaxModelContext stringOrDeclname) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.stringOrDeclname, stringOrDeclname);
    }

    public SwiftSyntaxModelContext getDeclBaseName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.declBaseName);
    }

    public void setDeclBaseName(SwiftSyntaxModelContext declBaseName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.declBaseName, declBaseName);
    }

    public SwiftSyntaxModelContext getContinueKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.continueKeyword);
    }

    public void setContinueKeyword(SwiftSyntaxModelContext continueKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.continueKeyword, continueKeyword);
    }

    public SwiftSyntaxModelContext getLabelName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.labelName);
    }

    public void setLabelName(SwiftSyntaxModelContext labelName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelName, labelName);
    }

    public SwiftSyntaxModelContext getLabelColon() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.labelColon);
    }

    public void setLabelColon(SwiftSyntaxModelContext labelColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelColon, labelColon);
    }

    public SwiftSyntaxModelContext getWhileKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.whileKeyword);
    }

    public void setWhileKeyword(SwiftSyntaxModelContext whileKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.whileKeyword, whileKeyword);
    }

    public SwiftSyntaxModelContext getConditions() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.conditions);
    }

    public void setConditions(SwiftSyntaxModelContext conditions) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.conditions, conditions);
    }

    public SwiftSyntaxModelContext getDeferKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.deferKeyword);
    }

    public void setDeferKeyword(SwiftSyntaxModelContext deferKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.deferKeyword, deferKeyword);
    }

    public SwiftSyntaxModelContext getRepeatKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.repeatKeyword);
    }

    public void setRepeatKeyword(SwiftSyntaxModelContext repeatKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.repeatKeyword, repeatKeyword);
    }

    public SwiftSyntaxModelContext getGuardKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.guardKeyword);
    }

    public void setGuardKeyword(SwiftSyntaxModelContext guardKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.guardKeyword, guardKeyword);
    }

    public SwiftSyntaxModelContext getElseKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.elseKeyword);
    }

    public void setElseKeyword(SwiftSyntaxModelContext elseKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elseKeyword, elseKeyword);
    }

    public SwiftSyntaxModelContext getWhereKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.whereKeyword);
    }

    public void setWhereKeyword(SwiftSyntaxModelContext whereKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.whereKeyword, whereKeyword);
    }

    public SwiftSyntaxModelContext getGuardResult() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.guardResult);
    }

    public void setGuardResult(SwiftSyntaxModelContext guardResult) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.guardResult, guardResult);
    }

    public SwiftSyntaxModelContext getForKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.forKeyword);
    }

    public void setForKeyword(SwiftSyntaxModelContext forKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.forKeyword, forKeyword);
    }

    public SwiftSyntaxModelContext getInKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inKeyword);
    }

    public void setInKeyword(SwiftSyntaxModelContext inKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inKeyword, inKeyword);
    }

    public SwiftSyntaxModelContext getSequenceExpr() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr);
    }

    public void setSequenceExpr(SwiftSyntaxModelContext sequenceExpr) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public SwiftSyntaxModelContext getWhereClause() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.whereClause);
    }

    public void setWhereClause(SwiftSyntaxModelContext whereClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.whereClause, whereClause);
    }

    public SwiftSyntaxModelContext getSwitchKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.switchKeyword);
    }

    public void setSwitchKeyword(SwiftSyntaxModelContext switchKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.switchKeyword, switchKeyword);
    }

    public SwiftSyntaxModelContext getCases() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.cases);
    }

    public void setCases(SwiftSyntaxModelContext cases) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.cases, cases);
    }

    public SwiftSyntaxModelContext getDoKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.doKeyword);
    }

    public void setDoKeyword(SwiftSyntaxModelContext doKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.doKeyword, doKeyword);
    }

    public SwiftSyntaxModelContext getCatchClauses() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.catchClauses);
    }

    public void setCatchClauses(SwiftSyntaxModelContext catchClauses) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public SwiftSyntaxModelContext getReturnKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.returnKeyword);
    }

    public void setReturnKeyword(SwiftSyntaxModelContext returnKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.returnKeyword, returnKeyword);
    }

    public SwiftSyntaxModelContext getYieldKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.yieldKeyword);
    }

    public void setYieldKeyword(SwiftSyntaxModelContext yieldKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.yieldKeyword, yieldKeyword);
    }

    public SwiftSyntaxModelContext getYields() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.yields);
    }

    public void setYields(SwiftSyntaxModelContext yields) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.yields, yields);
    }

    public SwiftSyntaxModelContext getFallthroughKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.fallthroughKeyword);
    }

    public void setFallthroughKeyword(SwiftSyntaxModelContext fallthroughKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fallthroughKeyword, fallthroughKeyword);
    }

    public SwiftSyntaxModelContext getBreakKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.breakKeyword);
    }

    public void setBreakKeyword(SwiftSyntaxModelContext breakKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.breakKeyword, breakKeyword);
    }

    public SwiftSyntaxModelContext getPoundAvailableKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundAvailableKeyword);
    }

    public void setPoundAvailableKeyword(SwiftSyntaxModelContext poundAvailableKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundAvailableKeyword, poundAvailableKeyword);
    }

    public SwiftSyntaxModelContext getAvailabilitySpec() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.availabilitySpec);
    }

    public void setAvailabilitySpec(SwiftSyntaxModelContext availabilitySpec) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.availabilitySpec, availabilitySpec);
    }

    public SwiftSyntaxModelContext getThrowKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.throwKeyword);
    }

    public void setThrowKeyword(SwiftSyntaxModelContext throwKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwKeyword, throwKeyword);
    }

    public SwiftSyntaxModelContext getIfKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.ifKeyword);
    }

    public void setIfKeyword(SwiftSyntaxModelContext ifKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.ifKeyword, ifKeyword);
    }

    public SwiftSyntaxModelContext getElseBody() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.elseBody);
    }

    public void setElseBody(SwiftSyntaxModelContext elseBody) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elseBody, elseBody);
    }

    public SwiftSyntaxModelContext getUnknownAttr() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.unknownAttr);
    }

    public void setUnknownAttr(SwiftSyntaxModelContext unknownAttr) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.unknownAttr, unknownAttr);
    }

    public SwiftSyntaxModelContext getDefaultKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.defaultKeyword);
    }

    public void setDefaultKeyword(SwiftSyntaxModelContext defaultKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.defaultKeyword, defaultKeyword);
    }

    public SwiftSyntaxModelContext getCaseItems() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.caseItems);
    }

    public void setCaseItems(SwiftSyntaxModelContext caseItems) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.caseItems, caseItems);
    }

    public SwiftSyntaxModelContext getCatchKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.catchKeyword);
    }

    public void setCatchKeyword(SwiftSyntaxModelContext catchKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.catchKeyword, catchKeyword);
    }

    public SwiftSyntaxModelContext getPoundAssert() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.poundAssert);
    }

    public void setPoundAssert(SwiftSyntaxModelContext poundAssert) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundAssert, poundAssert);
    }

    public SwiftSyntaxModelContext getRequirementList() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.requirementList);
    }

    public void setRequirementList(SwiftSyntaxModelContext requirementList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.requirementList, requirementList);
    }

    public SwiftSyntaxModelContext getLeftTypeIdentifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier);
    }

    public void setLeftTypeIdentifier(SwiftSyntaxModelContext leftTypeIdentifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier, leftTypeIdentifier);
    }

    public SwiftSyntaxModelContext getEqualityToken() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.equalityToken);
    }

    public void setEqualityToken(SwiftSyntaxModelContext equalityToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.equalityToken, equalityToken);
    }

    public SwiftSyntaxModelContext getRightTypeIdentifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier);
    }

    public void setRightTypeIdentifier(SwiftSyntaxModelContext rightTypeIdentifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier, rightTypeIdentifier);
    }

    public SwiftSyntaxModelContext getInheritedType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inheritedType);
    }

    public void setInheritedType(SwiftSyntaxModelContext inheritedType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inheritedType, inheritedType);
    }

    public SwiftSyntaxModelContext getLeftAngleBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket);
    }

    public void setLeftAngleBracket(SwiftSyntaxModelContext leftAngleBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket, leftAngleBracket);
    }

    public SwiftSyntaxModelContext getGenericParameterList() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.genericParameterList);
    }

    public void setGenericParameterList(SwiftSyntaxModelContext genericParameterList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericParameterList, genericParameterList);
    }

    public SwiftSyntaxModelContext getRightAngleBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket);
    }

    public void setRightAngleBracket(SwiftSyntaxModelContext rightAngleBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket, rightAngleBracket);
    }

    public SwiftSyntaxModelContext getBaseType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.baseType);
    }

    public void setBaseType(SwiftSyntaxModelContext baseType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.baseType, baseType);
    }

    public SwiftSyntaxModelContext getLeftSquareBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket);
    }

    public void setLeftSquareBracket(SwiftSyntaxModelContext leftSquareBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket, leftSquareBracket);
    }

    public SwiftSyntaxModelContext getElementType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.elementType);
    }

    public void setElementType(SwiftSyntaxModelContext elementType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elementType, elementType);
    }

    public SwiftSyntaxModelContext getRightSquareBracket() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket);
    }

    public void setRightSquareBracket(SwiftSyntaxModelContext rightSquareBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket, rightSquareBracket);
    }

    public SwiftSyntaxModelContext getKeyType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.keyType);
    }

    public void setKeyType(SwiftSyntaxModelContext keyType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.keyType, keyType);
    }

    public SwiftSyntaxModelContext getValueType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.valueType);
    }

    public void setValueType(SwiftSyntaxModelContext valueType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.valueType, valueType);
    }

    public SwiftSyntaxModelContext getTypeOrProtocol() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.typeOrProtocol);
    }

    public void setTypeOrProtocol(SwiftSyntaxModelContext typeOrProtocol) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.typeOrProtocol, typeOrProtocol);
    }

    public SwiftSyntaxModelContext getWrappedType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.wrappedType);
    }

    public void setWrappedType(SwiftSyntaxModelContext wrappedType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.wrappedType, wrappedType);
    }

    public SwiftSyntaxModelContext getSomeSpecifier() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.someSpecifier);
    }

    public void setSomeSpecifier(SwiftSyntaxModelContext someSpecifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.someSpecifier, someSpecifier);
    }

    public SwiftSyntaxModelContext getInOut() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.inOut);
    }

    public void setInOut(SwiftSyntaxModelContext inOut) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inOut, inOut);
    }

    public SwiftSyntaxModelContext getArgumentType() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.argumentType);
    }

    public void setArgumentType(SwiftSyntaxModelContext argumentType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.argumentType, argumentType);
    }

    public SwiftSyntaxModelContext getCaseName() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.caseName);
    }

    public void setCaseName(SwiftSyntaxModelContext caseName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.caseName, caseName);
    }

    public SwiftSyntaxModelContext getAssociatedTuple() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.associatedTuple);
    }

    public void setAssociatedTuple(SwiftSyntaxModelContext associatedTuple) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.associatedTuple, associatedTuple);
    }

    public SwiftSyntaxModelContext getIsKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.isKeyword);
    }

    public void setIsKeyword(SwiftSyntaxModelContext isKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.isKeyword, isKeyword);
    }

    public SwiftSyntaxModelContext getSubPattern() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.subPattern);
    }

    public void setSubPattern(SwiftSyntaxModelContext subPattern) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.subPattern, subPattern);
    }

    public SwiftSyntaxModelContext getAsKeyword() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.asKeyword);
    }

    public void setAsKeyword(SwiftSyntaxModelContext asKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.asKeyword, asKeyword);
    }

    public SwiftSyntaxModelContext getValuePattern() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.valuePattern);
    }

    public void setValuePattern(SwiftSyntaxModelContext valuePattern) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.valuePattern, valuePattern);
    }

    public SwiftSyntaxModelContext getEntry() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.entry);
    }

    public void setEntry(SwiftSyntaxModelContext entry) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.entry, entry);
    }

    public SwiftSyntaxModelContext getPlatform() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.platform);
    }

    public void setPlatform(SwiftSyntaxModelContext platform) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.platform, platform);
    }

    public SwiftSyntaxModelContext getVersion() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.version);
    }

    public void setVersion(SwiftSyntaxModelContext version) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.version, version);
    }

    public SwiftSyntaxModelContext getMajorMinor() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.majorMinor);
    }

    public void setMajorMinor(SwiftSyntaxModelContext majorMinor) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.majorMinor, majorMinor);
    }

    public SwiftSyntaxModelContext getPatchPeriod() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.patchPeriod);
    }

    public void setPatchPeriod(SwiftSyntaxModelContext patchPeriod) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.patchPeriod, patchPeriod);
    }

    public SwiftSyntaxModelContext getPatchVersion() {
        return (SwiftSyntaxModelContext) wGet(SwiftSyntaxFeatureDescriptorEnum.patchVersion);
    }

    public void setPatchVersion(SwiftSyntaxModelContext patchVersion) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.patchVersion, patchVersion);
    }
}
