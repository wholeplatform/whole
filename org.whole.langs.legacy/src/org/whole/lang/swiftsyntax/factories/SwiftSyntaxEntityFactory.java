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
package org.whole.lang.swiftsyntax.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SwiftSyntaxEntityFactory extends GenericEntityFactory {
    public static final SwiftSyntaxEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static SwiftSyntaxEntityFactory instance(IEntityRegistryProvider provider) {
        return new SwiftSyntaxEntityFactory(provider);
    }

    protected SwiftSyntaxEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Token createToken() {
        return create(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public Token createToken(TokenKind kind, SourcePresence presence, Trivia leadingTrivia, Trivia trailingTrivia, Text text) {
        return create(SwiftSyntaxEntityDescriptorEnum.Token, kind, presence, leadingTrivia, trailingTrivia, text);
    }

    public IEntityBuilder<Token> buildToken() {
        return new EntityBuilder<Token>(create(SwiftSyntaxEntityDescriptorEnum.Token));
    }

    public UnknownDecl createUnknownDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownDecl);
    }

    public UnknownDecl createUnknownDecl(Syntax... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownDecl, (IEntity[]) entities);
    }

    public UnknownDecl createUnknownDecl(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.UnknownDecl, initialSize);
    }

    public UnknownExpr createUnknownExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownExpr);
    }

    public UnknownExpr createUnknownExpr(Syntax... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownExpr, (IEntity[]) entities);
    }

    public UnknownExpr createUnknownExpr(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.UnknownExpr, initialSize);
    }

    public UnknownPattern createUnknownPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownPattern);
    }

    public UnknownPattern createUnknownPattern(Syntax... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownPattern, (IEntity[]) entities);
    }

    public UnknownPattern createUnknownPattern(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.UnknownPattern, initialSize);
    }

    public UnknownStmt createUnknownStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownStmt);
    }

    public UnknownStmt createUnknownStmt(Syntax... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownStmt, (IEntity[]) entities);
    }

    public UnknownStmt createUnknownStmt(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.UnknownStmt, initialSize);
    }

    public UnknownType createUnknownType() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownType);
    }

    public UnknownType createUnknownType(Syntax... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnknownType, (IEntity[]) entities);
    }

    public UnknownType createUnknownType(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.UnknownType, initialSize);
    }

    public CodeBlockItem createCodeBlockItem() {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem);
    }

    public CodeBlockItem createCodeBlockItem(Syntax item, Token semicolon, Syntax errorTokens) {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem, item, semicolon, errorTokens);
    }

    public IEntityBuilder<CodeBlockItem> buildCodeBlockItem() {
        return new EntityBuilder<CodeBlockItem>(create(SwiftSyntaxEntityDescriptorEnum.CodeBlockItem));
    }

    public CodeBlockItemList createCodeBlockItemList() {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList);
    }

    public CodeBlockItemList createCodeBlockItemList(CodeBlockItem... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList, (IEntity[]) entities);
    }

    public CodeBlockItemList createCodeBlockItemList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList, initialSize);
    }

    public CodeBlock createCodeBlock() {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public CodeBlock createCodeBlock(Token leftBrace, CodeBlockItemList statements, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.CodeBlock, leftBrace, statements, rightBrace);
    }

    public IEntityBuilder<CodeBlock> buildCodeBlock() {
        return new EntityBuilder<CodeBlock>(create(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
    }

    public InOutExpr createInOutExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.InOutExpr);
    }

    public InOutExpr createInOutExpr(Token ampersand, Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.InOutExpr, ampersand, expression);
    }

    public IEntityBuilder<InOutExpr> buildInOutExpr() {
        return new EntityBuilder<InOutExpr>(create(SwiftSyntaxEntityDescriptorEnum.InOutExpr));
    }

    public PoundColumnExpr createPoundColumnExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr);
    }

    public PoundColumnExpr createPoundColumnExpr(Token poundColumn) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr, poundColumn);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList(FunctionCallArgument... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList, (IEntity[]) entities);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList, initialSize);
    }

    public TupleElementList createTupleElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleElementList);
    }

    public TupleElementList createTupleElementList(TupleElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleElementList, (IEntity[]) entities);
    }

    public TupleElementList createTupleElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.TupleElementList, initialSize);
    }

    public ArrayElementList createArrayElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayElementList);
    }

    public ArrayElementList createArrayElementList(ArrayElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayElementList, (IEntity[]) entities);
    }

    public ArrayElementList createArrayElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ArrayElementList, initialSize);
    }

    public DictionaryElementList createDictionaryElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList);
    }

    public DictionaryElementList createDictionaryElementList(DictionaryElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList, (IEntity[]) entities);
    }

    public DictionaryElementList createDictionaryElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.DictionaryElementList, initialSize);
    }

    public StringLiteralSegments createStringLiteralSegments() {
        return create(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments);
    }

    public StringLiteralSegments createStringLiteralSegments(AbstractSegment... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments, (IEntity[]) entities);
    }

    public StringLiteralSegments createStringLiteralSegments(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments, initialSize);
    }

    public TryExpr createTryExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.TryExpr);
    }

    public TryExpr createTryExpr(Token tryKeyword, Token questionOrExclamationMark, Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.TryExpr, tryKeyword, questionOrExclamationMark, expression);
    }

    public IEntityBuilder<TryExpr> buildTryExpr() {
        return new EntityBuilder<TryExpr>(create(SwiftSyntaxEntityDescriptorEnum.TryExpr));
    }

    public DeclNameArgument createDeclNameArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument);
    }

    public DeclNameArgument createDeclNameArgument(Token name, Token colon) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument, name, colon);
    }

    public IEntityBuilder<DeclNameArgument> buildDeclNameArgument() {
        return new EntityBuilder<DeclNameArgument>(create(SwiftSyntaxEntityDescriptorEnum.DeclNameArgument));
    }

    public DeclNameArgumentList createDeclNameArgumentList() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList);
    }

    public DeclNameArgumentList createDeclNameArgumentList(DeclNameArgument... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList, (IEntity[]) entities);
    }

    public DeclNameArgumentList createDeclNameArgumentList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList, initialSize);
    }

    public DeclNameArguments createDeclNameArguments() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments);
    }

    public DeclNameArguments createDeclNameArguments(Token leftParen, DeclNameArgumentList arguments, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments, leftParen, arguments, rightParen);
    }

    public IEntityBuilder<DeclNameArguments> buildDeclNameArguments() {
        return new EntityBuilder<DeclNameArguments>(create(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments));
    }

    public IdentifierExpr createIdentifierExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr);
    }

    public IdentifierExpr createIdentifierExpr(Token identifier, DeclNameArguments declNameArguments) {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr, identifier, declNameArguments);
    }

    public IEntityBuilder<IdentifierExpr> buildIdentifierExpr() {
        return new EntityBuilder<IdentifierExpr>(create(SwiftSyntaxEntityDescriptorEnum.IdentifierExpr));
    }

    public SuperRefExpr createSuperRefExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.SuperRefExpr);
    }

    public SuperRefExpr createSuperRefExpr(Token superKeyword) {
        return create(SwiftSyntaxEntityDescriptorEnum.SuperRefExpr, superKeyword);
    }

    public NilLiteralExpr createNilLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr);
    }

    public NilLiteralExpr createNilLiteralExpr(Token nilKeyword) {
        return create(SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr, nilKeyword);
    }

    public DiscardAssignmentExpr createDiscardAssignmentExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public DiscardAssignmentExpr createDiscardAssignmentExpr(Token wildcard) {
        return create(SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr, wildcard);
    }

    public AssignmentExpr createAssignmentExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.AssignmentExpr);
    }

    public AssignmentExpr createAssignmentExpr(Token assignToken) {
        return create(SwiftSyntaxEntityDescriptorEnum.AssignmentExpr, assignToken);
    }

    public SequenceExpr createSequenceExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.SequenceExpr);
    }

    public SequenceExpr createSequenceExpr(ExprList elements) {
        return create(SwiftSyntaxEntityDescriptorEnum.SequenceExpr, elements);
    }

    public ExprList createExprList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ExprList);
    }

    public ExprList createExprList(Expr... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ExprList, (IEntity[]) entities);
    }

    public ExprList createExprList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ExprList, initialSize);
    }

    public PoundLineExpr createPoundLineExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundLineExpr);
    }

    public PoundLineExpr createPoundLineExpr(Token poundLine) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundLineExpr, poundLine);
    }

    public PoundFileExpr createPoundFileExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundFileExpr);
    }

    public PoundFileExpr createPoundFileExpr(Token poundFile) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundFileExpr, poundFile);
    }

    public PoundFunctionExpr createPoundFunctionExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr);
    }

    public PoundFunctionExpr createPoundFunctionExpr(Token poundFunction) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr, poundFunction);
    }

    public PoundDsohandleExpr createPoundDsohandleExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public PoundDsohandleExpr createPoundDsohandleExpr(Token poundDsohandle) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr, poundDsohandle);
    }

    public SymbolicReferenceExpr createSymbolicReferenceExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public SymbolicReferenceExpr createSymbolicReferenceExpr(Token identifier, GenericArgumentClause genericArgumentClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr, identifier, genericArgumentClause);
    }

    public IEntityBuilder<SymbolicReferenceExpr> buildSymbolicReferenceExpr() {
        return new EntityBuilder<SymbolicReferenceExpr>(create(SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr));
    }

    public PrefixOperatorExpr createPrefixOperatorExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public PrefixOperatorExpr createPrefixOperatorExpr(Token operatorToken, Expr postfixExpression) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr, operatorToken, postfixExpression);
    }

    public IEntityBuilder<PrefixOperatorExpr> buildPrefixOperatorExpr() {
        return new EntityBuilder<PrefixOperatorExpr>(create(SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr));
    }

    public BinaryOperatorExpr createBinaryOperatorExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public BinaryOperatorExpr createBinaryOperatorExpr(Token operatorToken) {
        return create(SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr, operatorToken);
    }

    public ArrowExpr createArrowExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrowExpr);
    }

    public ArrowExpr createArrowExpr(Token throwsToken, Token arrowToken) {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrowExpr, throwsToken, arrowToken);
    }

    public IEntityBuilder<ArrowExpr> buildArrowExpr() {
        return new EntityBuilder<ArrowExpr>(create(SwiftSyntaxEntityDescriptorEnum.ArrowExpr));
    }

    public FloatLiteralExpr createFloatLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr);
    }

    public FloatLiteralExpr createFloatLiteralExpr(Token floatingDigits) {
        return create(SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr, floatingDigits);
    }

    public TupleExpr createTupleExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleExpr);
    }

    public TupleExpr createTupleExpr(Token leftParen, TupleElementList elementList, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleExpr, leftParen, elementList, rightParen);
    }

    public IEntityBuilder<TupleExpr> buildTupleExpr() {
        return new EntityBuilder<TupleExpr>(create(SwiftSyntaxEntityDescriptorEnum.TupleExpr));
    }

    public ArrayExpr createArrayExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayExpr);
    }

    public ArrayExpr createArrayExpr(Token leftSquare, ArrayElementList elements, Token rightSquare) {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayExpr, leftSquare, elements, rightSquare);
    }

    public IEntityBuilder<ArrayExpr> buildArrayExpr() {
        return new EntityBuilder<ArrayExpr>(create(SwiftSyntaxEntityDescriptorEnum.ArrayExpr));
    }

    public DictionaryExpr createDictionaryExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr);
    }

    public DictionaryExpr createDictionaryExpr(Token leftSquare, Syntax content, Token rightSquare) {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr, leftSquare, content, rightSquare);
    }

    public IEntityBuilder<DictionaryExpr> buildDictionaryExpr() {
        return new EntityBuilder<DictionaryExpr>(create(SwiftSyntaxEntityDescriptorEnum.DictionaryExpr));
    }

    public FunctionCallArgument createFunctionCallArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument);
    }

    public FunctionCallArgument createFunctionCallArgument(Token label, Token colon, Expr expression, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument, label, colon, expression, trailingComma);
    }

    public IEntityBuilder<FunctionCallArgument> buildFunctionCallArgument() {
        return new EntityBuilder<FunctionCallArgument>(create(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument));
    }

    public TupleElement createTupleElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleElement);
    }

    public TupleElement createTupleElement(Token label, Token colon, Expr expression, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleElement, label, colon, expression, trailingComma);
    }

    public IEntityBuilder<TupleElement> buildTupleElement() {
        return new EntityBuilder<TupleElement>(create(SwiftSyntaxEntityDescriptorEnum.TupleElement));
    }

    public ArrayElement createArrayElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayElement);
    }

    public ArrayElement createArrayElement(Expr expression, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayElement, expression, trailingComma);
    }

    public IEntityBuilder<ArrayElement> buildArrayElement() {
        return new EntityBuilder<ArrayElement>(create(SwiftSyntaxEntityDescriptorEnum.ArrayElement));
    }

    public DictionaryElement createDictionaryElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryElement);
    }

    public DictionaryElement createDictionaryElement(Expr keyExpression, Token colon, Expr valueExpression, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryElement, keyExpression, colon, valueExpression, trailingComma);
    }

    public IEntityBuilder<DictionaryElement> buildDictionaryElement() {
        return new EntityBuilder<DictionaryElement>(create(SwiftSyntaxEntityDescriptorEnum.DictionaryElement));
    }

    public IntegerLiteralExpr createIntegerLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr);
    }

    public IntegerLiteralExpr createIntegerLiteralExpr(Token digits) {
        return create(SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr, digits);
    }

    public BooleanLiteralExpr createBooleanLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr);
    }

    public BooleanLiteralExpr createBooleanLiteralExpr(Token booleanLiteral) {
        return create(SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr, booleanLiteral);
    }

    public TernaryExpr createTernaryExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.TernaryExpr);
    }

    public TernaryExpr createTernaryExpr(Expr conditionExpression, Token questionMark, Expr firstChoice, Token colonMark, Expr secondChoice) {
        return create(SwiftSyntaxEntityDescriptorEnum.TernaryExpr, conditionExpression, questionMark, firstChoice, colonMark, secondChoice);
    }

    public IEntityBuilder<TernaryExpr> buildTernaryExpr() {
        return new EntityBuilder<TernaryExpr>(create(SwiftSyntaxEntityDescriptorEnum.TernaryExpr));
    }

    public MemberAccessExpr createMemberAccessExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr);
    }

    public MemberAccessExpr createMemberAccessExpr(Expr base, Token dot, Token name, DeclNameArguments declNameArguments) {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr, base, dot, name, declNameArguments);
    }

    public IEntityBuilder<MemberAccessExpr> buildMemberAccessExpr() {
        return new EntityBuilder<MemberAccessExpr>(create(SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr));
    }

    public IsExpr createIsExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.IsExpr);
    }

    public IsExpr createIsExpr(Token isTok, Type typeName) {
        return create(SwiftSyntaxEntityDescriptorEnum.IsExpr, isTok, typeName);
    }

    public IEntityBuilder<IsExpr> buildIsExpr() {
        return new EntityBuilder<IsExpr>(create(SwiftSyntaxEntityDescriptorEnum.IsExpr));
    }

    public AsExpr createAsExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.AsExpr);
    }

    public AsExpr createAsExpr(Token asTok, Token questionOrExclamationMark, Type typeName) {
        return create(SwiftSyntaxEntityDescriptorEnum.AsExpr, asTok, questionOrExclamationMark, typeName);
    }

    public IEntityBuilder<AsExpr> buildAsExpr() {
        return new EntityBuilder<AsExpr>(create(SwiftSyntaxEntityDescriptorEnum.AsExpr));
    }

    public TypeExpr createTypeExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeExpr);
    }

    public TypeExpr createTypeExpr(Type type) {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeExpr, type);
    }

    public ClosureCaptureItem createClosureCaptureItem() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem);
    }

    public ClosureCaptureItem createClosureCaptureItem(TokenList specifier, Token name, Token assignToken, Expr expression, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem, specifier, name, assignToken, expression, trailingComma);
    }

    public IEntityBuilder<ClosureCaptureItem> buildClosureCaptureItem() {
        return new EntityBuilder<ClosureCaptureItem>(create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem));
    }

    public ClosureCaptureItemList createClosureCaptureItemList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public ClosureCaptureItemList createClosureCaptureItemList(ClosureCaptureItem... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList, (IEntity[]) entities);
    }

    public ClosureCaptureItemList createClosureCaptureItemList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList, initialSize);
    }

    public ClosureCaptureSignature createClosureCaptureSignature() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature);
    }

    public ClosureCaptureSignature createClosureCaptureSignature(Token leftSquare, ClosureCaptureItemList items, Token rightSquare) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature, leftSquare, items, rightSquare);
    }

    public IEntityBuilder<ClosureCaptureSignature> buildClosureCaptureSignature() {
        return new EntityBuilder<ClosureCaptureSignature>(create(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature));
    }

    public ClosureParam createClosureParam() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureParam);
    }

    public ClosureParam createClosureParam(Token name, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureParam, name, trailingComma);
    }

    public IEntityBuilder<ClosureParam> buildClosureParam() {
        return new EntityBuilder<ClosureParam>(create(SwiftSyntaxEntityDescriptorEnum.ClosureParam));
    }

    public ClosureParamList createClosureParamList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureParamList);
    }

    public ClosureParamList createClosureParamList(ClosureParam... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureParamList, (IEntity[]) entities);
    }

    public ClosureParamList createClosureParamList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ClosureParamList, initialSize);
    }

    public ClosureSignature createClosureSignature() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureSignature);
    }

    public ClosureSignature createClosureSignature(ClosureCaptureSignature capture, Syntax input, Token throwsTok, ReturnClause output, Token inTok) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureSignature, capture, input, throwsTok, output, inTok);
    }

    public IEntityBuilder<ClosureSignature> buildClosureSignature() {
        return new EntityBuilder<ClosureSignature>(create(SwiftSyntaxEntityDescriptorEnum.ClosureSignature));
    }

    public ClosureExpr createClosureExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureExpr);
    }

    public ClosureExpr createClosureExpr(Token leftBrace, ClosureSignature signature, CodeBlockItemList statements, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClosureExpr, leftBrace, signature, statements, rightBrace);
    }

    public IEntityBuilder<ClosureExpr> buildClosureExpr() {
        return new EntityBuilder<ClosureExpr>(create(SwiftSyntaxEntityDescriptorEnum.ClosureExpr));
    }

    public UnresolvedPatternExpr createUnresolvedPatternExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public UnresolvedPatternExpr createUnresolvedPatternExpr(Pattern pattern) {
        return create(SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr, pattern);
    }

    public FunctionCallExpr createFunctionCallExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr);
    }

    public FunctionCallExpr createFunctionCallExpr(Expr calledExpression, Token leftParen, FunctionCallArgumentList argumentList, Token rightParen, ClosureExpr trailingClosure) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr, calledExpression, leftParen, argumentList, rightParen, trailingClosure);
    }

    public IEntityBuilder<FunctionCallExpr> buildFunctionCallExpr() {
        return new EntityBuilder<FunctionCallExpr>(create(SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr));
    }

    public SubscriptExpr createSubscriptExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr);
    }

    public SubscriptExpr createSubscriptExpr(Expr calledExpression, Token leftBracket, FunctionCallArgumentList argumentList, Token rightBracket, ClosureExpr trailingClosure) {
        return create(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr, calledExpression, leftBracket, argumentList, rightBracket, trailingClosure);
    }

    public IEntityBuilder<SubscriptExpr> buildSubscriptExpr() {
        return new EntityBuilder<SubscriptExpr>(create(SwiftSyntaxEntityDescriptorEnum.SubscriptExpr));
    }

    public OptionalChainingExpr createOptionalChainingExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr);
    }

    public OptionalChainingExpr createOptionalChainingExpr(Expr expression, Token questionMark) {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr, expression, questionMark);
    }

    public IEntityBuilder<OptionalChainingExpr> buildOptionalChainingExpr() {
        return new EntityBuilder<OptionalChainingExpr>(create(SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr));
    }

    public ForcedValueExpr createForcedValueExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr);
    }

    public ForcedValueExpr createForcedValueExpr(Expr expression, Token exclamationMark) {
        return create(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr, expression, exclamationMark);
    }

    public IEntityBuilder<ForcedValueExpr> buildForcedValueExpr() {
        return new EntityBuilder<ForcedValueExpr>(create(SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr));
    }

    public PostfixUnaryExpr createPostfixUnaryExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public PostfixUnaryExpr createPostfixUnaryExpr(Expr expression, Token operatorToken) {
        return create(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr, expression, operatorToken);
    }

    public IEntityBuilder<PostfixUnaryExpr> buildPostfixUnaryExpr() {
        return new EntityBuilder<PostfixUnaryExpr>(create(SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr));
    }

    public SpecializeExpr createSpecializeExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr);
    }

    public SpecializeExpr createSpecializeExpr(Expr expression, GenericArgumentClause genericArgumentClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr, expression, genericArgumentClause);
    }

    public IEntityBuilder<SpecializeExpr> buildSpecializeExpr() {
        return new EntityBuilder<SpecializeExpr>(create(SwiftSyntaxEntityDescriptorEnum.SpecializeExpr));
    }

    public StringSegment createStringSegment() {
        return create(SwiftSyntaxEntityDescriptorEnum.StringSegment);
    }

    public StringSegment createStringSegment(Token content) {
        return create(SwiftSyntaxEntityDescriptorEnum.StringSegment, content);
    }

    public ExpressionSegment createExpressionSegment() {
        return create(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment);
    }

    public ExpressionSegment createExpressionSegment(Token backslash, Token delimiter, Token leftParen, FunctionCallArgumentList expressions, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment, backslash, delimiter, leftParen, expressions, rightParen);
    }

    public IEntityBuilder<ExpressionSegment> buildExpressionSegment() {
        return new EntityBuilder<ExpressionSegment>(create(SwiftSyntaxEntityDescriptorEnum.ExpressionSegment));
    }

    public StringLiteralExpr createStringLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr);
    }

    public StringLiteralExpr createStringLiteralExpr(Token openDelimiter, Token openQuote, StringLiteralSegments segments, Token closeQuote, Token closeDelimiter) {
        return create(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr, openDelimiter, openQuote, segments, closeQuote, closeDelimiter);
    }

    public IEntityBuilder<StringLiteralExpr> buildStringLiteralExpr() {
        return new EntityBuilder<StringLiteralExpr>(create(SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr));
    }

    public KeyPathExpr createKeyPathExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr);
    }

    public KeyPathExpr createKeyPathExpr(Token backslash, Expr rootExpr, Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr, backslash, rootExpr, expression);
    }

    public IEntityBuilder<KeyPathExpr> buildKeyPathExpr() {
        return new EntityBuilder<KeyPathExpr>(create(SwiftSyntaxEntityDescriptorEnum.KeyPathExpr));
    }

    public KeyPathBaseExpr createKeyPathBaseExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public KeyPathBaseExpr createKeyPathBaseExpr(Token period) {
        return create(SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr, period);
    }

    public ObjcNamePiece createObjcNamePiece() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece);
    }

    public ObjcNamePiece createObjcNamePiece(Token name, Token dot) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece, name, dot);
    }

    public IEntityBuilder<ObjcNamePiece> buildObjcNamePiece() {
        return new EntityBuilder<ObjcNamePiece>(create(SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece));
    }

    public ObjcName createObjcName() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcName);
    }

    public ObjcName createObjcName(ObjcNamePiece... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcName, (IEntity[]) entities);
    }

    public ObjcName createObjcName(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ObjcName, initialSize);
    }

    public ObjcKeyPathExpr createObjcKeyPathExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public ObjcKeyPathExpr createObjcKeyPathExpr(Token keyPath, Token leftParen, ObjcName name, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr, keyPath, leftParen, name, rightParen);
    }

    public IEntityBuilder<ObjcKeyPathExpr> buildObjcKeyPathExpr() {
        return new EntityBuilder<ObjcKeyPathExpr>(create(SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr));
    }

    public ObjcSelectorExpr createObjcSelectorExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public ObjcSelectorExpr createObjcSelectorExpr(Token poundSelector, Token leftParen, Token kind, Token colon, Expr name, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr, poundSelector, leftParen, kind, colon, name, rightParen);
    }

    public IEntityBuilder<ObjcSelectorExpr> buildObjcSelectorExpr() {
        return new EntityBuilder<ObjcSelectorExpr>(create(SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr));
    }

    public EditorPlaceholderExpr createEditorPlaceholderExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public EditorPlaceholderExpr createEditorPlaceholderExpr(Token identifier) {
        return create(SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr, identifier);
    }

    public ObjectLiteralExpr createObjectLiteralExpr() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public ObjectLiteralExpr createObjectLiteralExpr(Token identifier, Token leftParen, FunctionCallArgumentList arguments, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr, identifier, leftParen, arguments, rightParen);
    }

    public IEntityBuilder<ObjectLiteralExpr> buildObjectLiteralExpr() {
        return new EntityBuilder<ObjectLiteralExpr>(create(SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr));
    }

    public TypeInitializerClause createTypeInitializerClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause);
    }

    public TypeInitializerClause createTypeInitializerClause(Token equal, Type value) {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause, equal, value);
    }

    public IEntityBuilder<TypeInitializerClause> buildTypeInitializerClause() {
        return new EntityBuilder<TypeInitializerClause>(create(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause));
    }

    public TypealiasDecl createTypealiasDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl);
    }

    public TypealiasDecl createTypealiasDecl(AttributeList attributes, ModifierList modifiers, Token typealiasKeyword, Token identifier, GenericParameterClause genericParameterClause, TypeInitializerClause initializer, GenericWhereClause genericWhereClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl, attributes, modifiers, typealiasKeyword, identifier, genericParameterClause, initializer, genericWhereClause);
    }

    public IEntityBuilder<TypealiasDecl> buildTypealiasDecl() {
        return new EntityBuilder<TypealiasDecl>(create(SwiftSyntaxEntityDescriptorEnum.TypealiasDecl));
    }

    public AssociatedtypeDecl createAssociatedtypeDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public AssociatedtypeDecl createAssociatedtypeDecl(AttributeList attributes, ModifierList modifiers, Token associatedtypeKeyword, Token identifier, TypeInheritanceClause inheritanceClause, TypeInitializerClause initializer, GenericWhereClause genericWhereClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl, attributes, modifiers, associatedtypeKeyword, identifier, inheritanceClause, initializer, genericWhereClause);
    }

    public IEntityBuilder<AssociatedtypeDecl> buildAssociatedtypeDecl() {
        return new EntityBuilder<AssociatedtypeDecl>(create(SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl));
    }

    public FunctionParameterList createFunctionParameterList() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList);
    }

    public FunctionParameterList createFunctionParameterList(FunctionParameter... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList, (IEntity[]) entities);
    }

    public FunctionParameterList createFunctionParameterList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.FunctionParameterList, initialSize);
    }

    public ParameterClause createParameterClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.ParameterClause);
    }

    public ParameterClause createParameterClause(Token leftParen, FunctionParameterList parameterList, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.ParameterClause, leftParen, parameterList, rightParen);
    }

    public IEntityBuilder<ParameterClause> buildParameterClause() {
        return new EntityBuilder<ParameterClause>(create(SwiftSyntaxEntityDescriptorEnum.ParameterClause));
    }

    public ReturnClause createReturnClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.ReturnClause);
    }

    public ReturnClause createReturnClause(Token arrow, Type returnType) {
        return create(SwiftSyntaxEntityDescriptorEnum.ReturnClause, arrow, returnType);
    }

    public IEntityBuilder<ReturnClause> buildReturnClause() {
        return new EntityBuilder<ReturnClause>(create(SwiftSyntaxEntityDescriptorEnum.ReturnClause));
    }

    public FunctionSignature createFunctionSignature() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionSignature);
    }

    public FunctionSignature createFunctionSignature(ParameterClause input, Token throwsOrRethrowsKeyword, ReturnClause output) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionSignature, input, throwsOrRethrowsKeyword, output);
    }

    public IEntityBuilder<FunctionSignature> buildFunctionSignature() {
        return new EntityBuilder<FunctionSignature>(create(SwiftSyntaxEntityDescriptorEnum.FunctionSignature));
    }

    public IfConfigClause createIfConfigClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigClause);
    }

    public IfConfigClause createIfConfigClause(Token poundKeyword, Expr condition, Syntax elements) {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigClause, poundKeyword, condition, elements);
    }

    public IEntityBuilder<IfConfigClause> buildIfConfigClause() {
        return new EntityBuilder<IfConfigClause>(create(SwiftSyntaxEntityDescriptorEnum.IfConfigClause));
    }

    public IfConfigClauseList createIfConfigClauseList() {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList);
    }

    public IfConfigClauseList createIfConfigClauseList(IfConfigClause... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList, (IEntity[]) entities);
    }

    public IfConfigClauseList createIfConfigClauseList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList, initialSize);
    }

    public IfConfigDecl createIfConfigDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl);
    }

    public IfConfigDecl createIfConfigDecl(IfConfigClauseList clauses, Token poundEndif) {
        return create(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl, clauses, poundEndif);
    }

    public IEntityBuilder<IfConfigDecl> buildIfConfigDecl() {
        return new EntityBuilder<IfConfigDecl>(create(SwiftSyntaxEntityDescriptorEnum.IfConfigDecl));
    }

    public PoundErrorDecl createPoundErrorDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl);
    }

    public PoundErrorDecl createPoundErrorDecl(Token poundError, Token leftParen, StringLiteralExpr message, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl, poundError, leftParen, message, rightParen);
    }

    public IEntityBuilder<PoundErrorDecl> buildPoundErrorDecl() {
        return new EntityBuilder<PoundErrorDecl>(create(SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl));
    }

    public PoundWarningDecl createPoundWarningDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl);
    }

    public PoundWarningDecl createPoundWarningDecl(Token poundWarning, Token leftParen, StringLiteralExpr message, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl, poundWarning, leftParen, message, rightParen);
    }

    public IEntityBuilder<PoundWarningDecl> buildPoundWarningDecl() {
        return new EntityBuilder<PoundWarningDecl>(create(SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl));
    }

    public PoundSourceLocation createPoundSourceLocation() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation);
    }

    public PoundSourceLocation createPoundSourceLocation(Token poundSourceLocation, Token leftParen, PoundSourceLocationArgs args, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation, poundSourceLocation, leftParen, args, rightParen);
    }

    public IEntityBuilder<PoundSourceLocation> buildPoundSourceLocation() {
        return new EntityBuilder<PoundSourceLocation>(create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation));
    }

    public PoundSourceLocationArgs createPoundSourceLocationArgs() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public PoundSourceLocationArgs createPoundSourceLocationArgs(Token fileArgLabel, Token fileArgColon, Token fileName, Token comma, Token lineArgLabel, Token lineArgColon, Token lineNumber) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs, fileArgLabel, fileArgColon, fileName, comma, lineArgLabel, lineArgColon, lineNumber);
    }

    public IEntityBuilder<PoundSourceLocationArgs> buildPoundSourceLocationArgs() {
        return new EntityBuilder<PoundSourceLocationArgs>(create(SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs));
    }

    public DeclModifier createDeclModifier() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclModifier);
    }

    public DeclModifier createDeclModifier(Token name, Token detailLeftParen, Token detail, Token detailRightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclModifier, name, detailLeftParen, detail, detailRightParen);
    }

    public IEntityBuilder<DeclModifier> buildDeclModifier() {
        return new EntityBuilder<DeclModifier>(create(SwiftSyntaxEntityDescriptorEnum.DeclModifier));
    }

    public InheritedType createInheritedType() {
        return create(SwiftSyntaxEntityDescriptorEnum.InheritedType);
    }

    public InheritedType createInheritedType(Type typeName, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.InheritedType, typeName, trailingComma);
    }

    public IEntityBuilder<InheritedType> buildInheritedType() {
        return new EntityBuilder<InheritedType>(create(SwiftSyntaxEntityDescriptorEnum.InheritedType));
    }

    public InheritedTypeList createInheritedTypeList() {
        return create(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList);
    }

    public InheritedTypeList createInheritedTypeList(InheritedType... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList, (IEntity[]) entities);
    }

    public InheritedTypeList createInheritedTypeList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.InheritedTypeList, initialSize);
    }

    public TypeInheritanceClause createTypeInheritanceClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause);
    }

    public TypeInheritanceClause createTypeInheritanceClause(Token colon, InheritedTypeList inheritedTypeCollection) {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause, colon, inheritedTypeCollection);
    }

    public IEntityBuilder<TypeInheritanceClause> buildTypeInheritanceClause() {
        return new EntityBuilder<TypeInheritanceClause>(create(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause));
    }

    public ClassDecl createClassDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClassDecl);
    }

    public ClassDecl createClassDecl(AttributeList attributes, ModifierList modifiers, Token classKeyword, Token identifier, GenericParameterClause genericParameterClause, TypeInheritanceClause inheritanceClause, GenericWhereClause genericWhereClause, MemberDeclBlock members) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClassDecl, attributes, modifiers, classKeyword, identifier, genericParameterClause, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ClassDecl> buildClassDecl() {
        return new EntityBuilder<ClassDecl>(create(SwiftSyntaxEntityDescriptorEnum.ClassDecl));
    }

    public StructDecl createStructDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.StructDecl);
    }

    public StructDecl createStructDecl(AttributeList attributes, ModifierList modifiers, Token structKeyword, Token identifier, GenericParameterClause genericParameterClause, TypeInheritanceClause inheritanceClause, GenericWhereClause genericWhereClause, MemberDeclBlock members) {
        return create(SwiftSyntaxEntityDescriptorEnum.StructDecl, attributes, modifiers, structKeyword, identifier, genericParameterClause, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<StructDecl> buildStructDecl() {
        return new EntityBuilder<StructDecl>(create(SwiftSyntaxEntityDescriptorEnum.StructDecl));
    }

    public ProtocolDecl createProtocolDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl);
    }

    public ProtocolDecl createProtocolDecl(AttributeList attributes, ModifierList modifiers, Token protocolKeyword, Token identifier, TypeInheritanceClause inheritanceClause, GenericWhereClause genericWhereClause, MemberDeclBlock members) {
        return create(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl, attributes, modifiers, protocolKeyword, identifier, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ProtocolDecl> buildProtocolDecl() {
        return new EntityBuilder<ProtocolDecl>(create(SwiftSyntaxEntityDescriptorEnum.ProtocolDecl));
    }

    public ExtensionDecl createExtensionDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl);
    }

    public ExtensionDecl createExtensionDecl(AttributeList attributes, ModifierList modifiers, Token extensionKeyword, Type extendedType, TypeInheritanceClause inheritanceClause, GenericWhereClause genericWhereClause, MemberDeclBlock members) {
        return create(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl, attributes, modifiers, extensionKeyword, extendedType, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ExtensionDecl> buildExtensionDecl() {
        return new EntityBuilder<ExtensionDecl>(create(SwiftSyntaxEntityDescriptorEnum.ExtensionDecl));
    }

    public MemberDeclBlock createMemberDeclBlock() {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock);
    }

    public MemberDeclBlock createMemberDeclBlock(Token leftBrace, MemberDeclList members, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock, leftBrace, members, rightBrace);
    }

    public IEntityBuilder<MemberDeclBlock> buildMemberDeclBlock() {
        return new EntityBuilder<MemberDeclBlock>(create(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock));
    }

    public MemberDeclList createMemberDeclList() {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclList);
    }

    public MemberDeclList createMemberDeclList(MemberDeclListItem... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclList, (IEntity[]) entities);
    }

    public MemberDeclList createMemberDeclList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.MemberDeclList, initialSize);
    }

    public MemberDeclListItem createMemberDeclListItem() {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem);
    }

    public MemberDeclListItem createMemberDeclListItem(Decl decl, Token semicolon) {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem, decl, semicolon);
    }

    public IEntityBuilder<MemberDeclListItem> buildMemberDeclListItem() {
        return new EntityBuilder<MemberDeclListItem>(create(SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem));
    }

    public SourceFile createSourceFile() {
        return create(SwiftSyntaxEntityDescriptorEnum.SourceFile);
    }

    public SourceFile createSourceFile(CodeBlockItemList statements, Token eofToken) {
        return create(SwiftSyntaxEntityDescriptorEnum.SourceFile, statements, eofToken);
    }

    public IEntityBuilder<SourceFile> buildSourceFile() {
        return new EntityBuilder<SourceFile>(create(SwiftSyntaxEntityDescriptorEnum.SourceFile));
    }

    public InitializerClause createInitializerClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.InitializerClause);
    }

    public InitializerClause createInitializerClause(Token equal, Expr value) {
        return create(SwiftSyntaxEntityDescriptorEnum.InitializerClause, equal, value);
    }

    public IEntityBuilder<InitializerClause> buildInitializerClause() {
        return new EntityBuilder<InitializerClause>(create(SwiftSyntaxEntityDescriptorEnum.InitializerClause));
    }

    public FunctionParameter createFunctionParameter() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionParameter);
    }

    public FunctionParameter createFunctionParameter(AttributeList attributes, Token firstName, Token secondName, Token colon, Type type, Token ellipsis, InitializerClause defaultArgument, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionParameter, attributes, firstName, secondName, colon, type, ellipsis, defaultArgument, trailingComma);
    }

    public IEntityBuilder<FunctionParameter> buildFunctionParameter() {
        return new EntityBuilder<FunctionParameter>(create(SwiftSyntaxEntityDescriptorEnum.FunctionParameter));
    }

    public ModifierList createModifierList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public ModifierList createModifierList(DeclModifier... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ModifierList, (IEntity[]) entities);
    }

    public ModifierList createModifierList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ModifierList, initialSize);
    }

    public FunctionDecl createFunctionDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionDecl);
    }

    public FunctionDecl createFunctionDecl(AttributeList attributes, ModifierList modifiers, Token funcKeyword, Token identifier, GenericParameterClause genericParameterClause, FunctionSignature signature, GenericWhereClause genericWhereClause, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionDecl, attributes, modifiers, funcKeyword, identifier, genericParameterClause, signature, genericWhereClause, body);
    }

    public IEntityBuilder<FunctionDecl> buildFunctionDecl() {
        return new EntityBuilder<FunctionDecl>(create(SwiftSyntaxEntityDescriptorEnum.FunctionDecl));
    }

    public InitializerDecl createInitializerDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.InitializerDecl);
    }

    public InitializerDecl createInitializerDecl(AttributeList attributes, ModifierList modifiers, Token initKeyword, Token optionalMark, GenericParameterClause genericParameterClause, ParameterClause parameters, Token throwsOrRethrowsKeyword, GenericWhereClause genericWhereClause, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.InitializerDecl, attributes, modifiers, initKeyword, optionalMark, genericParameterClause, parameters, throwsOrRethrowsKeyword, genericWhereClause, body);
    }

    public IEntityBuilder<InitializerDecl> buildInitializerDecl() {
        return new EntityBuilder<InitializerDecl>(create(SwiftSyntaxEntityDescriptorEnum.InitializerDecl));
    }

    public DeinitializerDecl createDeinitializerDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl);
    }

    public DeinitializerDecl createDeinitializerDecl(AttributeList attributes, ModifierList modifiers, Token deinitKeyword, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl, attributes, modifiers, deinitKeyword, body);
    }

    public IEntityBuilder<DeinitializerDecl> buildDeinitializerDecl() {
        return new EntityBuilder<DeinitializerDecl>(create(SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl));
    }

    public SubscriptDecl createSubscriptDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl);
    }

    public SubscriptDecl createSubscriptDecl(AttributeList attributes, ModifierList modifiers, Token subscriptKeyword, GenericParameterClause genericParameterClause, ParameterClause indices, ReturnClause result, GenericWhereClause genericWhereClause, Syntax accessor) {
        return create(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl, attributes, modifiers, subscriptKeyword, genericParameterClause, indices, result, genericWhereClause, accessor);
    }

    public IEntityBuilder<SubscriptDecl> buildSubscriptDecl() {
        return new EntityBuilder<SubscriptDecl>(create(SwiftSyntaxEntityDescriptorEnum.SubscriptDecl));
    }

    public AccessLevelModifier createAccessLevelModifier() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier);
    }

    public AccessLevelModifier createAccessLevelModifier(Token name, Token leftParen, Token modifier, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier, name, leftParen, modifier, rightParen);
    }

    public IEntityBuilder<AccessLevelModifier> buildAccessLevelModifier() {
        return new EntityBuilder<AccessLevelModifier>(create(SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier));
    }

    public AccessPathComponent createAccessPathComponent() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent);
    }

    public AccessPathComponent createAccessPathComponent(Token name, Token trailingDot) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent, name, trailingDot);
    }

    public IEntityBuilder<AccessPathComponent> buildAccessPathComponent() {
        return new EntityBuilder<AccessPathComponent>(create(SwiftSyntaxEntityDescriptorEnum.AccessPathComponent));
    }

    public AccessPath createAccessPath() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessPath);
    }

    public AccessPath createAccessPath(AccessPathComponent... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessPath, (IEntity[]) entities);
    }

    public AccessPath createAccessPath(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.AccessPath, initialSize);
    }

    public ImportDecl createImportDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.ImportDecl);
    }

    public ImportDecl createImportDecl(AttributeList attributes, ModifierList modifiers, Token importTok, Token importKind, AccessPath path) {
        return create(SwiftSyntaxEntityDescriptorEnum.ImportDecl, attributes, modifiers, importTok, importKind, path);
    }

    public IEntityBuilder<ImportDecl> buildImportDecl() {
        return new EntityBuilder<ImportDecl>(create(SwiftSyntaxEntityDescriptorEnum.ImportDecl));
    }

    public AccessorParameter createAccessorParameter() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorParameter);
    }

    public AccessorParameter createAccessorParameter(Token leftParen, Token name, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorParameter, leftParen, name, rightParen);
    }

    public IEntityBuilder<AccessorParameter> buildAccessorParameter() {
        return new EntityBuilder<AccessorParameter>(create(SwiftSyntaxEntityDescriptorEnum.AccessorParameter));
    }

    public AccessorDecl createAccessorDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorDecl);
    }

    public AccessorDecl createAccessorDecl(AttributeList attributes, DeclModifier modifier, Token accessorKind, AccessorParameter parameter, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorDecl, attributes, modifier, accessorKind, parameter, body);
    }

    public IEntityBuilder<AccessorDecl> buildAccessorDecl() {
        return new EntityBuilder<AccessorDecl>(create(SwiftSyntaxEntityDescriptorEnum.AccessorDecl));
    }

    public AccessorList createAccessorList() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorList);
    }

    public AccessorList createAccessorList(AccessorDecl... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorList, (IEntity[]) entities);
    }

    public AccessorList createAccessorList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.AccessorList, initialSize);
    }

    public AccessorBlock createAccessorBlock() {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorBlock);
    }

    public AccessorBlock createAccessorBlock(Token leftBrace, AccessorList accessors, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.AccessorBlock, leftBrace, accessors, rightBrace);
    }

    public IEntityBuilder<AccessorBlock> buildAccessorBlock() {
        return new EntityBuilder<AccessorBlock>(create(SwiftSyntaxEntityDescriptorEnum.AccessorBlock));
    }

    public PatternBinding createPatternBinding() {
        return create(SwiftSyntaxEntityDescriptorEnum.PatternBinding);
    }

    public PatternBinding createPatternBinding(Pattern pattern, TypeAnnotation typeAnnotation, InitializerClause initializer, Syntax accessor, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.PatternBinding, pattern, typeAnnotation, initializer, accessor, trailingComma);
    }

    public IEntityBuilder<PatternBinding> buildPatternBinding() {
        return new EntityBuilder<PatternBinding>(create(SwiftSyntaxEntityDescriptorEnum.PatternBinding));
    }

    public PatternBindingList createPatternBindingList() {
        return create(SwiftSyntaxEntityDescriptorEnum.PatternBindingList);
    }

    public PatternBindingList createPatternBindingList(PatternBinding... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.PatternBindingList, (IEntity[]) entities);
    }

    public PatternBindingList createPatternBindingList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.PatternBindingList, initialSize);
    }

    public VariableDecl createVariableDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.VariableDecl);
    }

    public VariableDecl createVariableDecl(AttributeList attributes, ModifierList modifiers, Token letOrVarKeyword, PatternBindingList bindings) {
        return create(SwiftSyntaxEntityDescriptorEnum.VariableDecl, attributes, modifiers, letOrVarKeyword, bindings);
    }

    public IEntityBuilder<VariableDecl> buildVariableDecl() {
        return new EntityBuilder<VariableDecl>(create(SwiftSyntaxEntityDescriptorEnum.VariableDecl));
    }

    public EnumCaseElement createEnumCaseElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement);
    }

    public EnumCaseElement createEnumCaseElement(Token identifier, ParameterClause associatedValue, InitializerClause rawValue, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement, identifier, associatedValue, rawValue, trailingComma);
    }

    public IEntityBuilder<EnumCaseElement> buildEnumCaseElement() {
        return new EntityBuilder<EnumCaseElement>(create(SwiftSyntaxEntityDescriptorEnum.EnumCaseElement));
    }

    public EnumCaseElementList createEnumCaseElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList);
    }

    public EnumCaseElementList createEnumCaseElementList(EnumCaseElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList, (IEntity[]) entities);
    }

    public EnumCaseElementList createEnumCaseElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList, initialSize);
    }

    public EnumCaseDecl createEnumCaseDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl);
    }

    public EnumCaseDecl createEnumCaseDecl(AttributeList attributes, ModifierList modifiers, Token caseKeyword, EnumCaseElementList elements) {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl, attributes, modifiers, caseKeyword, elements);
    }

    public IEntityBuilder<EnumCaseDecl> buildEnumCaseDecl() {
        return new EntityBuilder<EnumCaseDecl>(create(SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl));
    }

    public EnumDecl createEnumDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumDecl);
    }

    public EnumDecl createEnumDecl(AttributeList attributes, ModifierList modifiers, Token enumKeyword, Token identifier, GenericParameterClause genericParameters, TypeInheritanceClause inheritanceClause, GenericWhereClause genericWhereClause, MemberDeclBlock members) {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumDecl, attributes, modifiers, enumKeyword, identifier, genericParameters, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<EnumDecl> buildEnumDecl() {
        return new EntityBuilder<EnumDecl>(create(SwiftSyntaxEntityDescriptorEnum.EnumDecl));
    }

    public OperatorDecl createOperatorDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.OperatorDecl);
    }

    public OperatorDecl createOperatorDecl(AttributeList attributes, ModifierList modifiers, Token operatorKeyword, Token identifier, OperatorPrecedenceAndTypes operatorPrecedenceAndTypes) {
        return create(SwiftSyntaxEntityDescriptorEnum.OperatorDecl, attributes, modifiers, operatorKeyword, identifier, operatorPrecedenceAndTypes);
    }

    public IEntityBuilder<OperatorDecl> buildOperatorDecl() {
        return new EntityBuilder<OperatorDecl>(create(SwiftSyntaxEntityDescriptorEnum.OperatorDecl));
    }

    public IdentifierList createIdentifierList() {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierList);
    }

    public IdentifierList createIdentifierList(Token... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierList, (IEntity[]) entities);
    }

    public IdentifierList createIdentifierList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.IdentifierList, initialSize);
    }

    public OperatorPrecedenceAndTypes createOperatorPrecedenceAndTypes() {
        return create(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes);
    }

    public OperatorPrecedenceAndTypes createOperatorPrecedenceAndTypes(Token colon, IdentifierList precedenceGroupAndDesignatedTypes) {
        return create(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes, colon, precedenceGroupAndDesignatedTypes);
    }

    public IEntityBuilder<OperatorPrecedenceAndTypes> buildOperatorPrecedenceAndTypes() {
        return new EntityBuilder<OperatorPrecedenceAndTypes>(create(SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes));
    }

    public PrecedenceGroupDecl createPrecedenceGroupDecl() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public PrecedenceGroupDecl createPrecedenceGroupDecl(AttributeList attributes, ModifierList modifiers, Token precedencegroupKeyword, Token identifier, Token leftBrace, PrecedenceGroupAttributeList groupAttributes, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl, attributes, modifiers, precedencegroupKeyword, identifier, leftBrace, groupAttributes, rightBrace);
    }

    public IEntityBuilder<PrecedenceGroupDecl> buildPrecedenceGroupDecl() {
        return new EntityBuilder<PrecedenceGroupDecl>(create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl));
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList(AbstractPrecedenceGroupAttribute... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList, (IEntity[]) entities);
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList, initialSize);
    }

    public PrecedenceGroupRelation createPrecedenceGroupRelation() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public PrecedenceGroupRelation createPrecedenceGroupRelation(Token higherThanOrLowerThan, Token colon, PrecedenceGroupNameList otherNames) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation, higherThanOrLowerThan, colon, otherNames);
    }

    public IEntityBuilder<PrecedenceGroupRelation> buildPrecedenceGroupRelation() {
        return new EntityBuilder<PrecedenceGroupRelation>(create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation));
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList(PrecedenceGroupNameElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList, (IEntity[]) entities);
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList, initialSize);
    }

    public PrecedenceGroupNameElement createPrecedenceGroupNameElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement);
    }

    public PrecedenceGroupNameElement createPrecedenceGroupNameElement(Token name, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement, name, trailingComma);
    }

    public IEntityBuilder<PrecedenceGroupNameElement> buildPrecedenceGroupNameElement() {
        return new EntityBuilder<PrecedenceGroupNameElement>(create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement));
    }

    public PrecedenceGroupAssignment createPrecedenceGroupAssignment() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public PrecedenceGroupAssignment createPrecedenceGroupAssignment(Token assignmentKeyword, Token colon, Token flag) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment, assignmentKeyword, colon, flag);
    }

    public IEntityBuilder<PrecedenceGroupAssignment> buildPrecedenceGroupAssignment() {
        return new EntityBuilder<PrecedenceGroupAssignment>(create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment));
    }

    public PrecedenceGroupAssociativity createPrecedenceGroupAssociativity() {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public PrecedenceGroupAssociativity createPrecedenceGroupAssociativity(Token associativityKeyword, Token colon, Token value) {
        return create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity, associativityKeyword, colon, value);
    }

    public IEntityBuilder<PrecedenceGroupAssociativity> buildPrecedenceGroupAssociativity() {
        return new EntityBuilder<PrecedenceGroupAssociativity>(create(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity));
    }

    public TokenList createTokenList() {
        return create(SwiftSyntaxEntityDescriptorEnum.TokenList);
    }

    public TokenList createTokenList(Token... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.TokenList, (IEntity[]) entities);
    }

    public TokenList createTokenList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.TokenList, initialSize);
    }

    public CustomAttribute createCustomAttribute() {
        return create(SwiftSyntaxEntityDescriptorEnum.CustomAttribute);
    }

    public CustomAttribute createCustomAttribute(Token atSignToken, Type attributeName, Token leftParen, FunctionCallArgumentList argumentList, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.CustomAttribute, atSignToken, attributeName, leftParen, argumentList, rightParen);
    }

    public IEntityBuilder<CustomAttribute> buildCustomAttribute() {
        return new EntityBuilder<CustomAttribute>(create(SwiftSyntaxEntityDescriptorEnum.CustomAttribute));
    }

    public Attribute createAttribute() {
        return create(SwiftSyntaxEntityDescriptorEnum.Attribute);
    }

    public Attribute createAttribute(Token atSignToken, Token attributeName, Token leftParen, Syntax argument, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.Attribute, atSignToken, attributeName, leftParen, argument, rightParen);
    }

    public IEntityBuilder<Attribute> buildAttribute() {
        return new EntityBuilder<Attribute>(create(SwiftSyntaxEntityDescriptorEnum.Attribute));
    }

    public AttributeList createAttributeList() {
        return create(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public AttributeList createAttributeList(AbstractAttribute... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.AttributeList, (IEntity[]) entities);
    }

    public AttributeList createAttributeList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.AttributeList, initialSize);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList() {
        return create(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList(AbstractSpecializeAttribute... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList, (IEntity[]) entities);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList, initialSize);
    }

    public LabeledSpecializeEntry createLabeledSpecializeEntry() {
        return create(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public LabeledSpecializeEntry createLabeledSpecializeEntry(Token label, Token colon, Token value, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry, label, colon, value, trailingComma);
    }

    public IEntityBuilder<LabeledSpecializeEntry> buildLabeledSpecializeEntry() {
        return new EntityBuilder<LabeledSpecializeEntry>(create(SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry));
    }

    public NamedAttributeStringArgument createNamedAttributeStringArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public NamedAttributeStringArgument createNamedAttributeStringArgument(Token nameTok, Token colon, Syntax stringOrDeclname) {
        return create(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument, nameTok, colon, stringOrDeclname);
    }

    public IEntityBuilder<NamedAttributeStringArgument> buildNamedAttributeStringArgument() {
        return new EntityBuilder<NamedAttributeStringArgument>(create(SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument));
    }

    public DeclName createDeclName() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclName);
    }

    public DeclName createDeclName(Syntax declBaseName, DeclNameArguments declNameArguments) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeclName, declBaseName, declNameArguments);
    }

    public IEntityBuilder<DeclName> buildDeclName() {
        return new EntityBuilder<DeclName>(create(SwiftSyntaxEntityDescriptorEnum.DeclName));
    }

    public ImplementsAttributeArguments createImplementsAttributeArguments() {
        return create(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public ImplementsAttributeArguments createImplementsAttributeArguments(SimpleTypeIdentifier type, Token comma, Syntax declBaseName, DeclNameArguments declNameArguments) {
        return create(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments, type, comma, declBaseName, declNameArguments);
    }

    public IEntityBuilder<ImplementsAttributeArguments> buildImplementsAttributeArguments() {
        return new EntityBuilder<ImplementsAttributeArguments>(create(SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments));
    }

    public ObjCSelectorPiece createObjCSelectorPiece() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece);
    }

    public ObjCSelectorPiece createObjCSelectorPiece(Token name, Token colon) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece, name, colon);
    }

    public IEntityBuilder<ObjCSelectorPiece> buildObjCSelectorPiece() {
        return new EntityBuilder<ObjCSelectorPiece>(create(SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece));
    }

    public ObjCSelector createObjCSelector() {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjCSelector);
    }

    public ObjCSelector createObjCSelector(ObjCSelectorPiece... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ObjCSelector, (IEntity[]) entities);
    }

    public ObjCSelector createObjCSelector(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ObjCSelector, initialSize);
    }

    public ContinueStmt createContinueStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.ContinueStmt);
    }

    public ContinueStmt createContinueStmt(Token continueKeyword, Token label) {
        return create(SwiftSyntaxEntityDescriptorEnum.ContinueStmt, continueKeyword, label);
    }

    public IEntityBuilder<ContinueStmt> buildContinueStmt() {
        return new EntityBuilder<ContinueStmt>(create(SwiftSyntaxEntityDescriptorEnum.ContinueStmt));
    }

    public WhileStmt createWhileStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.WhileStmt);
    }

    public WhileStmt createWhileStmt(Token labelName, Token labelColon, Token whileKeyword, ConditionElementList conditions, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.WhileStmt, labelName, labelColon, whileKeyword, conditions, body);
    }

    public IEntityBuilder<WhileStmt> buildWhileStmt() {
        return new EntityBuilder<WhileStmt>(create(SwiftSyntaxEntityDescriptorEnum.WhileStmt));
    }

    public DeferStmt createDeferStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.DeferStmt);
    }

    public DeferStmt createDeferStmt(Token deferKeyword, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.DeferStmt, deferKeyword, body);
    }

    public IEntityBuilder<DeferStmt> buildDeferStmt() {
        return new EntityBuilder<DeferStmt>(create(SwiftSyntaxEntityDescriptorEnum.DeferStmt));
    }

    public SwitchCaseList createSwitchCaseList() {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList);
    }

    public SwitchCaseList createSwitchCaseList(AbstractSwitchCase... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList, (IEntity[]) entities);
    }

    public SwitchCaseList createSwitchCaseList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList, initialSize);
    }

    public RepeatWhileStmt createRepeatWhileStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt);
    }

    public RepeatWhileStmt createRepeatWhileStmt(Token labelName, Token labelColon, Token repeatKeyword, CodeBlock body, Token whileKeyword, Expr condition) {
        return create(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt, labelName, labelColon, repeatKeyword, body, whileKeyword, condition);
    }

    public IEntityBuilder<RepeatWhileStmt> buildRepeatWhileStmt() {
        return new EntityBuilder<RepeatWhileStmt>(create(SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt));
    }

    public GuardStmt createGuardStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.GuardStmt);
    }

    public GuardStmt createGuardStmt(Token guardKeyword, ConditionElementList conditions, Token elseKeyword, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.GuardStmt, guardKeyword, conditions, elseKeyword, body);
    }

    public IEntityBuilder<GuardStmt> buildGuardStmt() {
        return new EntityBuilder<GuardStmt>(create(SwiftSyntaxEntityDescriptorEnum.GuardStmt));
    }

    public WhereClause createWhereClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.WhereClause);
    }

    public WhereClause createWhereClause(Token whereKeyword, Expr guardResult) {
        return create(SwiftSyntaxEntityDescriptorEnum.WhereClause, whereKeyword, guardResult);
    }

    public IEntityBuilder<WhereClause> buildWhereClause() {
        return new EntityBuilder<WhereClause>(create(SwiftSyntaxEntityDescriptorEnum.WhereClause));
    }

    public ForInStmt createForInStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.ForInStmt);
    }

    public ForInStmt createForInStmt(Token labelName, Token labelColon, Token forKeyword, Token caseKeyword, Pattern pattern, TypeAnnotation typeAnnotation, Token inKeyword, Expr sequenceExpr, WhereClause whereClause, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.ForInStmt, labelName, labelColon, forKeyword, caseKeyword, pattern, typeAnnotation, inKeyword, sequenceExpr, whereClause, body);
    }

    public IEntityBuilder<ForInStmt> buildForInStmt() {
        return new EntityBuilder<ForInStmt>(create(SwiftSyntaxEntityDescriptorEnum.ForInStmt));
    }

    public SwitchStmt createSwitchStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchStmt);
    }

    public SwitchStmt createSwitchStmt(Token labelName, Token labelColon, Token switchKeyword, Expr expression, Token leftBrace, SwitchCaseList cases, Token rightBrace) {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchStmt, labelName, labelColon, switchKeyword, expression, leftBrace, cases, rightBrace);
    }

    public IEntityBuilder<SwitchStmt> buildSwitchStmt() {
        return new EntityBuilder<SwitchStmt>(create(SwiftSyntaxEntityDescriptorEnum.SwitchStmt));
    }

    public CatchClauseList createCatchClauseList() {
        return create(SwiftSyntaxEntityDescriptorEnum.CatchClauseList);
    }

    public CatchClauseList createCatchClauseList(CatchClause... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.CatchClauseList, (IEntity[]) entities);
    }

    public CatchClauseList createCatchClauseList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.CatchClauseList, initialSize);
    }

    public DoStmt createDoStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.DoStmt);
    }

    public DoStmt createDoStmt(Token labelName, Token labelColon, Token doKeyword, CodeBlock body, CatchClauseList catchClauses) {
        return create(SwiftSyntaxEntityDescriptorEnum.DoStmt, labelName, labelColon, doKeyword, body, catchClauses);
    }

    public IEntityBuilder<DoStmt> buildDoStmt() {
        return new EntityBuilder<DoStmt>(create(SwiftSyntaxEntityDescriptorEnum.DoStmt));
    }

    public ReturnStmt createReturnStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.ReturnStmt);
    }

    public ReturnStmt createReturnStmt(Token returnKeyword, Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.ReturnStmt, returnKeyword, expression);
    }

    public IEntityBuilder<ReturnStmt> buildReturnStmt() {
        return new EntityBuilder<ReturnStmt>(create(SwiftSyntaxEntityDescriptorEnum.ReturnStmt));
    }

    public YieldStmt createYieldStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.YieldStmt);
    }

    public YieldStmt createYieldStmt(Token yieldKeyword, Syntax yields) {
        return create(SwiftSyntaxEntityDescriptorEnum.YieldStmt, yieldKeyword, yields);
    }

    public IEntityBuilder<YieldStmt> buildYieldStmt() {
        return new EntityBuilder<YieldStmt>(create(SwiftSyntaxEntityDescriptorEnum.YieldStmt));
    }

    public YieldList createYieldList() {
        return create(SwiftSyntaxEntityDescriptorEnum.YieldList);
    }

    public YieldList createYieldList(Token leftParen, ExprList elementList, Token trailingComma, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.YieldList, leftParen, elementList, trailingComma, rightParen);
    }

    public IEntityBuilder<YieldList> buildYieldList() {
        return new EntityBuilder<YieldList>(create(SwiftSyntaxEntityDescriptorEnum.YieldList));
    }

    public FallthroughStmt createFallthroughStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.FallthroughStmt);
    }

    public FallthroughStmt createFallthroughStmt(Token fallthroughKeyword) {
        return create(SwiftSyntaxEntityDescriptorEnum.FallthroughStmt, fallthroughKeyword);
    }

    public BreakStmt createBreakStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.BreakStmt);
    }

    public BreakStmt createBreakStmt(Token breakKeyword, Token label) {
        return create(SwiftSyntaxEntityDescriptorEnum.BreakStmt, breakKeyword, label);
    }

    public IEntityBuilder<BreakStmt> buildBreakStmt() {
        return new EntityBuilder<BreakStmt>(create(SwiftSyntaxEntityDescriptorEnum.BreakStmt));
    }

    public CaseItemList createCaseItemList() {
        return create(SwiftSyntaxEntityDescriptorEnum.CaseItemList);
    }

    public CaseItemList createCaseItemList(CaseItem... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.CaseItemList, (IEntity[]) entities);
    }

    public CaseItemList createCaseItemList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.CaseItemList, initialSize);
    }

    public ConditionElement createConditionElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.ConditionElement);
    }

    public ConditionElement createConditionElement(Syntax condition, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.ConditionElement, condition, trailingComma);
    }

    public IEntityBuilder<ConditionElement> buildConditionElement() {
        return new EntityBuilder<ConditionElement>(create(SwiftSyntaxEntityDescriptorEnum.ConditionElement));
    }

    public AvailabilityCondition createAvailabilityCondition() {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition);
    }

    public AvailabilityCondition createAvailabilityCondition(Token poundAvailableKeyword, Token leftParen, AvailabilitySpecList availabilitySpec, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition, poundAvailableKeyword, leftParen, availabilitySpec, rightParen);
    }

    public IEntityBuilder<AvailabilityCondition> buildAvailabilityCondition() {
        return new EntityBuilder<AvailabilityCondition>(create(SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition));
    }

    public MatchingPatternCondition createMatchingPatternCondition() {
        return create(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition);
    }

    public MatchingPatternCondition createMatchingPatternCondition(Token caseKeyword, Pattern pattern, TypeAnnotation typeAnnotation, InitializerClause initializer) {
        return create(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition, caseKeyword, pattern, typeAnnotation, initializer);
    }

    public IEntityBuilder<MatchingPatternCondition> buildMatchingPatternCondition() {
        return new EntityBuilder<MatchingPatternCondition>(create(SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition));
    }

    public OptionalBindingCondition createOptionalBindingCondition() {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition);
    }

    public OptionalBindingCondition createOptionalBindingCondition(Token letOrVarKeyword, Pattern pattern, TypeAnnotation typeAnnotation, InitializerClause initializer) {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition, letOrVarKeyword, pattern, typeAnnotation, initializer);
    }

    public IEntityBuilder<OptionalBindingCondition> buildOptionalBindingCondition() {
        return new EntityBuilder<OptionalBindingCondition>(create(SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition));
    }

    public ConditionElementList createConditionElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.ConditionElementList);
    }

    public ConditionElementList createConditionElementList(ConditionElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.ConditionElementList, (IEntity[]) entities);
    }

    public ConditionElementList createConditionElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.ConditionElementList, initialSize);
    }

    public ThrowStmt createThrowStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.ThrowStmt);
    }

    public ThrowStmt createThrowStmt(Token throwKeyword, Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.ThrowStmt, throwKeyword, expression);
    }

    public IEntityBuilder<ThrowStmt> buildThrowStmt() {
        return new EntityBuilder<ThrowStmt>(create(SwiftSyntaxEntityDescriptorEnum.ThrowStmt));
    }

    public IfStmt createIfStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.IfStmt);
    }

    public IfStmt createIfStmt(Token labelName, Token labelColon, Token ifKeyword, ConditionElementList conditions, CodeBlock body, Token elseKeyword, Syntax elseBody) {
        return create(SwiftSyntaxEntityDescriptorEnum.IfStmt, labelName, labelColon, ifKeyword, conditions, body, elseKeyword, elseBody);
    }

    public IEntityBuilder<IfStmt> buildIfStmt() {
        return new EntityBuilder<IfStmt>(create(SwiftSyntaxEntityDescriptorEnum.IfStmt));
    }

    public SwitchCase createSwitchCase() {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCase);
    }

    public SwitchCase createSwitchCase(Attribute unknownAttr, Syntax label, CodeBlockItemList statements) {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCase, unknownAttr, label, statements);
    }

    public IEntityBuilder<SwitchCase> buildSwitchCase() {
        return new EntityBuilder<SwitchCase>(create(SwiftSyntaxEntityDescriptorEnum.SwitchCase));
    }

    public SwitchDefaultLabel createSwitchDefaultLabel() {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public SwitchDefaultLabel createSwitchDefaultLabel(Token defaultKeyword, Token colon) {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel, defaultKeyword, colon);
    }

    public IEntityBuilder<SwitchDefaultLabel> buildSwitchDefaultLabel() {
        return new EntityBuilder<SwitchDefaultLabel>(create(SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel));
    }

    public CaseItem createCaseItem() {
        return create(SwiftSyntaxEntityDescriptorEnum.CaseItem);
    }

    public CaseItem createCaseItem(Pattern pattern, WhereClause whereClause, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.CaseItem, pattern, whereClause, trailingComma);
    }

    public IEntityBuilder<CaseItem> buildCaseItem() {
        return new EntityBuilder<CaseItem>(create(SwiftSyntaxEntityDescriptorEnum.CaseItem));
    }

    public SwitchCaseLabel createSwitchCaseLabel() {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel);
    }

    public SwitchCaseLabel createSwitchCaseLabel(Token caseKeyword, CaseItemList caseItems, Token colon) {
        return create(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel, caseKeyword, caseItems, colon);
    }

    public IEntityBuilder<SwitchCaseLabel> buildSwitchCaseLabel() {
        return new EntityBuilder<SwitchCaseLabel>(create(SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel));
    }

    public CatchClause createCatchClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.CatchClause);
    }

    public CatchClause createCatchClause(Token catchKeyword, Pattern pattern, WhereClause whereClause, CodeBlock body) {
        return create(SwiftSyntaxEntityDescriptorEnum.CatchClause, catchKeyword, pattern, whereClause, body);
    }

    public IEntityBuilder<CatchClause> buildCatchClause() {
        return new EntityBuilder<CatchClause>(create(SwiftSyntaxEntityDescriptorEnum.CatchClause));
    }

    public PoundAssertStmt createPoundAssertStmt() {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt);
    }

    public PoundAssertStmt createPoundAssertStmt(Token poundAssert, Token leftParen, Expr condition, Token comma, Token message, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt, poundAssert, leftParen, condition, comma, message, rightParen);
    }

    public IEntityBuilder<PoundAssertStmt> buildPoundAssertStmt() {
        return new EntityBuilder<PoundAssertStmt>(create(SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt));
    }

    public GenericWhereClause createGenericWhereClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause);
    }

    public GenericWhereClause createGenericWhereClause(Token whereKeyword, GenericRequirementList requirementList) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause, whereKeyword, requirementList);
    }

    public IEntityBuilder<GenericWhereClause> buildGenericWhereClause() {
        return new EntityBuilder<GenericWhereClause>(create(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause));
    }

    public GenericRequirementList createGenericRequirementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList);
    }

    public GenericRequirementList createGenericRequirementList(AbstractGenericRequirement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList, (IEntity[]) entities);
    }

    public GenericRequirementList createGenericRequirementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.GenericRequirementList, initialSize);
    }

    public SameTypeRequirement createSameTypeRequirement() {
        return create(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement);
    }

    public SameTypeRequirement createSameTypeRequirement(Type leftTypeIdentifier, Token equalityToken, Type rightTypeIdentifier, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement, leftTypeIdentifier, equalityToken, rightTypeIdentifier, trailingComma);
    }

    public IEntityBuilder<SameTypeRequirement> buildSameTypeRequirement() {
        return new EntityBuilder<SameTypeRequirement>(create(SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement));
    }

    public GenericParameterList createGenericParameterList() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameterList);
    }

    public GenericParameterList createGenericParameterList(GenericParameter... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameterList, (IEntity[]) entities);
    }

    public GenericParameterList createGenericParameterList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.GenericParameterList, initialSize);
    }

    public GenericParameter createGenericParameter() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameter);
    }

    public GenericParameter createGenericParameter(AttributeList attributes, Token name, Token colon, Type inheritedType, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameter, attributes, name, colon, inheritedType, trailingComma);
    }

    public IEntityBuilder<GenericParameter> buildGenericParameter() {
        return new EntityBuilder<GenericParameter>(create(SwiftSyntaxEntityDescriptorEnum.GenericParameter));
    }

    public GenericParameterClause createGenericParameterClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause);
    }

    public GenericParameterClause createGenericParameterClause(Token leftAngleBracket, GenericParameterList genericParameterList, Token rightAngleBracket) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause, leftAngleBracket, genericParameterList, rightAngleBracket);
    }

    public IEntityBuilder<GenericParameterClause> buildGenericParameterClause() {
        return new EntityBuilder<GenericParameterClause>(create(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause));
    }

    public ConformanceRequirement createConformanceRequirement() {
        return create(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement);
    }

    public ConformanceRequirement createConformanceRequirement(Type leftTypeIdentifier, Token colon, Type rightTypeIdentifier, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement, leftTypeIdentifier, colon, rightTypeIdentifier, trailingComma);
    }

    public IEntityBuilder<ConformanceRequirement> buildConformanceRequirement() {
        return new EntityBuilder<ConformanceRequirement>(create(SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement));
    }

    public SimpleTypeIdentifier createSimpleTypeIdentifier() {
        return create(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public SimpleTypeIdentifier createSimpleTypeIdentifier(Token name, GenericArgumentClause genericArgumentClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier, name, genericArgumentClause);
    }

    public IEntityBuilder<SimpleTypeIdentifier> buildSimpleTypeIdentifier() {
        return new EntityBuilder<SimpleTypeIdentifier>(create(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier));
    }

    public MemberTypeIdentifier createMemberTypeIdentifier() {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public MemberTypeIdentifier createMemberTypeIdentifier(Type baseType, Token period, Token name, GenericArgumentClause genericArgumentClause) {
        return create(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier, baseType, period, name, genericArgumentClause);
    }

    public IEntityBuilder<MemberTypeIdentifier> buildMemberTypeIdentifier() {
        return new EntityBuilder<MemberTypeIdentifier>(create(SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier));
    }

    public ClassRestrictionType createClassRestrictionType() {
        return create(SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType);
    }

    public ClassRestrictionType createClassRestrictionType(Token classKeyword) {
        return create(SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType, classKeyword);
    }

    public ArrayType createArrayType() {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayType);
    }

    public ArrayType createArrayType(Token leftSquareBracket, Type elementType, Token rightSquareBracket) {
        return create(SwiftSyntaxEntityDescriptorEnum.ArrayType, leftSquareBracket, elementType, rightSquareBracket);
    }

    public IEntityBuilder<ArrayType> buildArrayType() {
        return new EntityBuilder<ArrayType>(create(SwiftSyntaxEntityDescriptorEnum.ArrayType));
    }

    public DictionaryType createDictionaryType() {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryType);
    }

    public DictionaryType createDictionaryType(Token leftSquareBracket, Type keyType, Token colon, Type valueType, Token rightSquareBracket) {
        return create(SwiftSyntaxEntityDescriptorEnum.DictionaryType, leftSquareBracket, keyType, colon, valueType, rightSquareBracket);
    }

    public IEntityBuilder<DictionaryType> buildDictionaryType() {
        return new EntityBuilder<DictionaryType>(create(SwiftSyntaxEntityDescriptorEnum.DictionaryType));
    }

    public MetatypeType createMetatypeType() {
        return create(SwiftSyntaxEntityDescriptorEnum.MetatypeType);
    }

    public MetatypeType createMetatypeType(Type baseType, Token period, Token typeOrProtocol) {
        return create(SwiftSyntaxEntityDescriptorEnum.MetatypeType, baseType, period, typeOrProtocol);
    }

    public IEntityBuilder<MetatypeType> buildMetatypeType() {
        return new EntityBuilder<MetatypeType>(create(SwiftSyntaxEntityDescriptorEnum.MetatypeType));
    }

    public OptionalType createOptionalType() {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalType);
    }

    public OptionalType createOptionalType(Type wrappedType, Token questionMark) {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalType, wrappedType, questionMark);
    }

    public IEntityBuilder<OptionalType> buildOptionalType() {
        return new EntityBuilder<OptionalType>(create(SwiftSyntaxEntityDescriptorEnum.OptionalType));
    }

    public SomeType createSomeType() {
        return create(SwiftSyntaxEntityDescriptorEnum.SomeType);
    }

    public SomeType createSomeType(Token someSpecifier, Type baseType) {
        return create(SwiftSyntaxEntityDescriptorEnum.SomeType, someSpecifier, baseType);
    }

    public IEntityBuilder<SomeType> buildSomeType() {
        return new EntityBuilder<SomeType>(create(SwiftSyntaxEntityDescriptorEnum.SomeType));
    }

    public ImplicitlyUnwrappedOptionalType createImplicitlyUnwrappedOptionalType() {
        return create(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public ImplicitlyUnwrappedOptionalType createImplicitlyUnwrappedOptionalType(Type wrappedType, Token exclamationMark) {
        return create(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType, wrappedType, exclamationMark);
    }

    public IEntityBuilder<ImplicitlyUnwrappedOptionalType> buildImplicitlyUnwrappedOptionalType() {
        return new EntityBuilder<ImplicitlyUnwrappedOptionalType>(create(SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType));
    }

    public CompositionTypeElement createCompositionTypeElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement);
    }

    public CompositionTypeElement createCompositionTypeElement(Type type, Token ampersand) {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement, type, ampersand);
    }

    public IEntityBuilder<CompositionTypeElement> buildCompositionTypeElement() {
        return new EntityBuilder<CompositionTypeElement>(create(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement));
    }

    public CompositionTypeElementList createCompositionTypeElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList);
    }

    public CompositionTypeElementList createCompositionTypeElementList(CompositionTypeElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList, (IEntity[]) entities);
    }

    public CompositionTypeElementList createCompositionTypeElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList, initialSize);
    }

    public CompositionType createCompositionType() {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionType);
    }

    public CompositionType createCompositionType(CompositionTypeElementList elements) {
        return create(SwiftSyntaxEntityDescriptorEnum.CompositionType, elements);
    }

    public TupleTypeElement createTupleTypeElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement);
    }

    public TupleTypeElement createTupleTypeElement(Token inOut, Token name, Token secondName, Token colon, Type type, Token ellipsis, InitializerClause initializer, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement, inOut, name, secondName, colon, type, ellipsis, initializer, trailingComma);
    }

    public IEntityBuilder<TupleTypeElement> buildTupleTypeElement() {
        return new EntityBuilder<TupleTypeElement>(create(SwiftSyntaxEntityDescriptorEnum.TupleTypeElement));
    }

    public TupleTypeElementList createTupleTypeElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList);
    }

    public TupleTypeElementList createTupleTypeElementList(TupleTypeElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList, (IEntity[]) entities);
    }

    public TupleTypeElementList createTupleTypeElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList, initialSize);
    }

    public TupleType createTupleType() {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleType);
    }

    public TupleType createTupleType(Token leftParen, TupleTypeElementList elements, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.TupleType, leftParen, elements, rightParen);
    }

    public IEntityBuilder<TupleType> buildTupleType() {
        return new EntityBuilder<TupleType>(create(SwiftSyntaxEntityDescriptorEnum.TupleType));
    }

    public FunctionType createFunctionType() {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionType);
    }

    public FunctionType createFunctionType(Token leftParen, TupleTypeElementList arguments, Token rightParen, Token throwsOrRethrowsKeyword, Token arrow, Type returnType) {
        return create(SwiftSyntaxEntityDescriptorEnum.FunctionType, leftParen, arguments, rightParen, throwsOrRethrowsKeyword, arrow, returnType);
    }

    public IEntityBuilder<FunctionType> buildFunctionType() {
        return new EntityBuilder<FunctionType>(create(SwiftSyntaxEntityDescriptorEnum.FunctionType));
    }

    public AttributedType createAttributedType() {
        return create(SwiftSyntaxEntityDescriptorEnum.AttributedType);
    }

    public AttributedType createAttributedType(Token specifier, AttributeList attributes, Type baseType) {
        return create(SwiftSyntaxEntityDescriptorEnum.AttributedType, specifier, attributes, baseType);
    }

    public IEntityBuilder<AttributedType> buildAttributedType() {
        return new EntityBuilder<AttributedType>(create(SwiftSyntaxEntityDescriptorEnum.AttributedType));
    }

    public GenericArgumentList createGenericArgumentList() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList);
    }

    public GenericArgumentList createGenericArgumentList(GenericArgument... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList, (IEntity[]) entities);
    }

    public GenericArgumentList createGenericArgumentList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.GenericArgumentList, initialSize);
    }

    public GenericArgument createGenericArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgument);
    }

    public GenericArgument createGenericArgument(Type argumentType, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgument, argumentType, trailingComma);
    }

    public IEntityBuilder<GenericArgument> buildGenericArgument() {
        return new EntityBuilder<GenericArgument>(create(SwiftSyntaxEntityDescriptorEnum.GenericArgument));
    }

    public GenericArgumentClause createGenericArgumentClause() {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause);
    }

    public GenericArgumentClause createGenericArgumentClause(Token leftAngleBracket, GenericArgumentList arguments, Token rightAngleBracket) {
        return create(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause, leftAngleBracket, arguments, rightAngleBracket);
    }

    public IEntityBuilder<GenericArgumentClause> buildGenericArgumentClause() {
        return new EntityBuilder<GenericArgumentClause>(create(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause));
    }

    public TypeAnnotation createTypeAnnotation() {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation);
    }

    public TypeAnnotation createTypeAnnotation(Token colon, Type type) {
        return create(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation, colon, type);
    }

    public IEntityBuilder<TypeAnnotation> buildTypeAnnotation() {
        return new EntityBuilder<TypeAnnotation>(create(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation));
    }

    public EnumCasePattern createEnumCasePattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern);
    }

    public EnumCasePattern createEnumCasePattern(Type type, Token period, Token caseName, TuplePattern associatedTuple) {
        return create(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern, type, period, caseName, associatedTuple);
    }

    public IEntityBuilder<EnumCasePattern> buildEnumCasePattern() {
        return new EntityBuilder<EnumCasePattern>(create(SwiftSyntaxEntityDescriptorEnum.EnumCasePattern));
    }

    public IsTypePattern createIsTypePattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.IsTypePattern);
    }

    public IsTypePattern createIsTypePattern(Token isKeyword, Type type) {
        return create(SwiftSyntaxEntityDescriptorEnum.IsTypePattern, isKeyword, type);
    }

    public IEntityBuilder<IsTypePattern> buildIsTypePattern() {
        return new EntityBuilder<IsTypePattern>(create(SwiftSyntaxEntityDescriptorEnum.IsTypePattern));
    }

    public OptionalPattern createOptionalPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalPattern);
    }

    public OptionalPattern createOptionalPattern(Pattern subPattern, Token questionMark) {
        return create(SwiftSyntaxEntityDescriptorEnum.OptionalPattern, subPattern, questionMark);
    }

    public IEntityBuilder<OptionalPattern> buildOptionalPattern() {
        return new EntityBuilder<OptionalPattern>(create(SwiftSyntaxEntityDescriptorEnum.OptionalPattern));
    }

    public IdentifierPattern createIdentifierPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierPattern);
    }

    public IdentifierPattern createIdentifierPattern(Token identifier) {
        return create(SwiftSyntaxEntityDescriptorEnum.IdentifierPattern, identifier);
    }

    public AsTypePattern createAsTypePattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.AsTypePattern);
    }

    public AsTypePattern createAsTypePattern(Pattern pattern, Token asKeyword, Type type) {
        return create(SwiftSyntaxEntityDescriptorEnum.AsTypePattern, pattern, asKeyword, type);
    }

    public IEntityBuilder<AsTypePattern> buildAsTypePattern() {
        return new EntityBuilder<AsTypePattern>(create(SwiftSyntaxEntityDescriptorEnum.AsTypePattern));
    }

    public TuplePattern createTuplePattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePattern);
    }

    public TuplePattern createTuplePattern(Token leftParen, TuplePatternElementList elements, Token rightParen) {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePattern, leftParen, elements, rightParen);
    }

    public IEntityBuilder<TuplePattern> buildTuplePattern() {
        return new EntityBuilder<TuplePattern>(create(SwiftSyntaxEntityDescriptorEnum.TuplePattern));
    }

    public WildcardPattern createWildcardPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.WildcardPattern);
    }

    public WildcardPattern createWildcardPattern(Token wildcard, TypeAnnotation typeAnnotation) {
        return create(SwiftSyntaxEntityDescriptorEnum.WildcardPattern, wildcard, typeAnnotation);
    }

    public IEntityBuilder<WildcardPattern> buildWildcardPattern() {
        return new EntityBuilder<WildcardPattern>(create(SwiftSyntaxEntityDescriptorEnum.WildcardPattern));
    }

    public TuplePatternElement createTuplePatternElement() {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement);
    }

    public TuplePatternElement createTuplePatternElement(Token labelName, Token labelColon, Pattern pattern, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement, labelName, labelColon, pattern, trailingComma);
    }

    public IEntityBuilder<TuplePatternElement> buildTuplePatternElement() {
        return new EntityBuilder<TuplePatternElement>(create(SwiftSyntaxEntityDescriptorEnum.TuplePatternElement));
    }

    public ExpressionPattern createExpressionPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.ExpressionPattern);
    }

    public ExpressionPattern createExpressionPattern(Expr expression) {
        return create(SwiftSyntaxEntityDescriptorEnum.ExpressionPattern, expression);
    }

    public TuplePatternElementList createTuplePatternElementList() {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList);
    }

    public TuplePatternElementList createTuplePatternElementList(TuplePatternElement... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList, (IEntity[]) entities);
    }

    public TuplePatternElementList createTuplePatternElementList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList, initialSize);
    }

    public ValueBindingPattern createValueBindingPattern() {
        return create(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern);
    }

    public ValueBindingPattern createValueBindingPattern(Token letOrVarKeyword, Pattern valuePattern) {
        return create(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern, letOrVarKeyword, valuePattern);
    }

    public IEntityBuilder<ValueBindingPattern> buildValueBindingPattern() {
        return new EntityBuilder<ValueBindingPattern>(create(SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern));
    }

    public AvailabilitySpecList createAvailabilitySpecList() {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList);
    }

    public AvailabilitySpecList createAvailabilitySpecList(AvailabilityArgument... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList, (IEntity[]) entities);
    }

    public AvailabilitySpecList createAvailabilitySpecList(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList, initialSize);
    }

    public AvailabilityArgument createAvailabilityArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument);
    }

    public AvailabilityArgument createAvailabilityArgument(Syntax entry, Token trailingComma) {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument, entry, trailingComma);
    }

    public IEntityBuilder<AvailabilityArgument> buildAvailabilityArgument() {
        return new EntityBuilder<AvailabilityArgument>(create(SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument));
    }

    public AvailabilityLabeledArgument createAvailabilityLabeledArgument() {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public AvailabilityLabeledArgument createAvailabilityLabeledArgument(Token label, Token colon, Syntax value) {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument, label, colon, value);
    }

    public IEntityBuilder<AvailabilityLabeledArgument> buildAvailabilityLabeledArgument() {
        return new EntityBuilder<AvailabilityLabeledArgument>(create(SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument));
    }

    public AvailabilityVersionRestriction createAvailabilityVersionRestriction() {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public AvailabilityVersionRestriction createAvailabilityVersionRestriction(Token platform, VersionTuple version) {
        return create(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction, platform, version);
    }

    public IEntityBuilder<AvailabilityVersionRestriction> buildAvailabilityVersionRestriction() {
        return new EntityBuilder<AvailabilityVersionRestriction>(create(SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction));
    }

    public VersionTuple createVersionTuple() {
        return create(SwiftSyntaxEntityDescriptorEnum.VersionTuple);
    }

    public VersionTuple createVersionTuple(Syntax majorMinor, Token patchPeriod, Token patchVersion) {
        return create(SwiftSyntaxEntityDescriptorEnum.VersionTuple, majorMinor, patchPeriod, patchVersion);
    }

    public IEntityBuilder<VersionTuple> buildVersionTuple() {
        return new EntityBuilder<VersionTuple>(create(SwiftSyntaxEntityDescriptorEnum.VersionTuple));
    }

    public TokenKind createTokenKind() {
        return create(SwiftSyntaxEntityDescriptorEnum.TokenKind);
    }

    public TokenKind createTokenKind(TokenKindEnum.Value value) {
        return create(SwiftSyntaxEntityDescriptorEnum.TokenKind, value);
    }

    public Text createText() {
        return create(SwiftSyntaxEntityDescriptorEnum.Text);
    }

    public Text createText(String value) {
        return create(SwiftSyntaxEntityDescriptorEnum.Text, value);
    }

    public Trivia createTrivia() {
        return create(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public Trivia createTrivia(TriviaPiece... entities) {
        return create(SwiftSyntaxEntityDescriptorEnum.Trivia, (IEntity[]) entities);
    }

    public Trivia createTrivia(int initialSize) {
        return clone(SwiftSyntaxEntityDescriptorEnum.Trivia, initialSize);
    }

    public TriviaPiece createTriviaPiece() {
        return create(SwiftSyntaxEntityDescriptorEnum.TriviaPiece);
    }

    public TriviaPiece createTriviaPiece(String value) {
        return create(SwiftSyntaxEntityDescriptorEnum.TriviaPiece, value);
    }

    public SourcePresence createSourcePresence() {
        return create(SwiftSyntaxEntityDescriptorEnum.SourcePresence);
    }

    public SourcePresence createSourcePresence(SourcePresenceEnum.Value value) {
        return create(SwiftSyntaxEntityDescriptorEnum.SourcePresence, value);
    }
}
