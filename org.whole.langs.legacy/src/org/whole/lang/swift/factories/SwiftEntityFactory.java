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
package org.whole.lang.swift.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.swift.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/**
 *  @generator Whole
 */
public class SwiftEntityFactory extends GenericEntityFactory {
    public static final SwiftEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static SwiftEntityFactory instance(IEntityRegistryProvider provider) {
        return new SwiftEntityFactory(provider);
    }

    protected SwiftEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public BooleanLiteral createBooleanLiteral() {
        return create(SwiftEntityDescriptorEnum.BooleanLiteral);
    }

    public BooleanLiteral createBooleanLiteral(boolean value) {
        return create(SwiftEntityDescriptorEnum.BooleanLiteral, value);
    }

    public IntegerLiteral createIntegerLiteral() {
        return create(SwiftEntityDescriptorEnum.IntegerLiteral);
    }

    public IntegerLiteral createIntegerLiteral(long value) {
        return create(SwiftEntityDescriptorEnum.IntegerLiteral, value);
    }

    public FloatingLiteral createFloatingLiteral() {
        return create(SwiftEntityDescriptorEnum.FloatingLiteral);
    }

    public FloatingLiteral createFloatingLiteral(double value) {
        return create(SwiftEntityDescriptorEnum.FloatingLiteral, value);
    }

    public StringLiteral createStringLiteral() {
        return create(SwiftEntityDescriptorEnum.StringLiteral);
    }

    public StringLiteral createStringLiteral(String value) {
        return create(SwiftEntityDescriptorEnum.StringLiteral, value);
    }

    public Identifier createIdentifier() {
        return create(SwiftEntityDescriptorEnum.Identifier);
    }

    public Identifier createIdentifier(String value) {
        return create(SwiftEntityDescriptorEnum.Identifier, value);
    }

    public BinaryOperator createBinaryOperator() {
        return create(SwiftEntityDescriptorEnum.BinaryOperator);
    }

    public BinaryOperator createBinaryOperator(String value) {
        return create(SwiftEntityDescriptorEnum.BinaryOperator, value);
    }

    public PostfixOperator createPostfixOperator() {
        return create(SwiftEntityDescriptorEnum.PostfixOperator);
    }

    public PostfixOperator createPostfixOperator(String value) {
        return create(SwiftEntityDescriptorEnum.PostfixOperator, value);
    }

    public PrefixOperator createPrefixOperator() {
        return create(SwiftEntityDescriptorEnum.PrefixOperator);
    }

    public PrefixOperator createPrefixOperator(String value) {
        return create(SwiftEntityDescriptorEnum.PrefixOperator, value);
    }

    public DollarIdentifier createDollarIdentifier() {
        return create(SwiftEntityDescriptorEnum.DollarIdentifier);
    }

    public DollarIdentifier createDollarIdentifier(String value) {
        return create(SwiftEntityDescriptorEnum.DollarIdentifier, value);
    }

    public RawStringDelimiter createRawStringDelimiter() {
        return create(SwiftEntityDescriptorEnum.RawStringDelimiter);
    }

    public RawStringDelimiter createRawStringDelimiter(String value) {
        return create(SwiftEntityDescriptorEnum.RawStringDelimiter, value);
    }

    public CodeBlockItemList createCodeBlockItemList() {
        return create(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public CodeBlockItemList createCodeBlockItemList(AbstractItem... entities) {
        return create(SwiftEntityDescriptorEnum.CodeBlockItemList, (IEntity[]) entities);
    }

    public CodeBlockItemList createCodeBlockItemList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.CodeBlockItemList, initialSize);
    }

    public InOutExpr createInOutExpr() {
        return create(SwiftEntityDescriptorEnum.InOutExpr);
    }

    public InOutExpr createInOutExpr(Expr expression) {
        return create(SwiftEntityDescriptorEnum.InOutExpr, expression);
    }

    public PoundColumnExpr createPoundColumnExpr() {
        return create(SwiftEntityDescriptorEnum.PoundColumnExpr);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList() {
        return create(SwiftEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList(FunctionCallArgument... entities) {
        return create(SwiftEntityDescriptorEnum.FunctionCallArgumentList, (IEntity[]) entities);
    }

    public FunctionCallArgumentList createFunctionCallArgumentList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.FunctionCallArgumentList, initialSize);
    }

    public StringLiteralSegments createStringLiteralSegments() {
        return create(SwiftEntityDescriptorEnum.StringLiteralSegments);
    }

    public StringLiteralSegments createStringLiteralSegments(AbstractSegment... entities) {
        return create(SwiftEntityDescriptorEnum.StringLiteralSegments, (IEntity[]) entities);
    }

    public StringLiteralSegments createStringLiteralSegments(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.StringLiteralSegments, initialSize);
    }

    public ExpressionSegment createExpressionSegment() {
        return create(SwiftEntityDescriptorEnum.ExpressionSegment);
    }

    public ExpressionSegment createExpressionSegment(RawStringDelimiter delimiter, FunctionCallArgumentList expressions) {
        return create(SwiftEntityDescriptorEnum.ExpressionSegment, delimiter, expressions);
    }

    public IEntityBuilder<ExpressionSegment> buildExpressionSegment() {
        return new EntityBuilder<ExpressionSegment>(create(SwiftEntityDescriptorEnum.ExpressionSegment));
    }

    public TryExpr createTryExpr() {
        return create(SwiftEntityDescriptorEnum.TryExpr);
    }

    public TryExpr createTryExpr(QuestionOrExclamationMarkEnum questionOrExclamationMark, Expr expression) {
        return create(SwiftEntityDescriptorEnum.TryExpr, questionOrExclamationMark, expression);
    }

    public IEntityBuilder<TryExpr> buildTryExpr() {
        return new EntityBuilder<TryExpr>(create(SwiftEntityDescriptorEnum.TryExpr));
    }

    public QuestionOrExclamationMarkEnum createQuestionOrExclamationMarkEnum() {
        return create(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum);
    }

    public QuestionOrExclamationMarkEnum createQuestionOrExclamationMarkEnum(QuestionOrExclamationMarkEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum, value);
    }

    public DeclNameArgumentList createDeclNameArgumentList() {
        return create(SwiftEntityDescriptorEnum.DeclNameArgumentList);
    }

    public DeclNameArgumentList createDeclNameArgumentList(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.DeclNameArgumentList, (IEntity[]) entities);
    }

    public DeclNameArgumentList createDeclNameArgumentList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.DeclNameArgumentList, initialSize);
    }

    public IdentifierExpr createIdentifierExpr() {
        return create(SwiftEntityDescriptorEnum.IdentifierExpr);
    }

    public IdentifierExpr createIdentifierExpr(AbstractIdentifier identifier, DeclNameArgumentList declNameArguments) {
        return create(SwiftEntityDescriptorEnum.IdentifierExpr, identifier, declNameArguments);
    }

    public IEntityBuilder<IdentifierExpr> buildIdentifierExpr() {
        return new EntityBuilder<IdentifierExpr>(create(SwiftEntityDescriptorEnum.IdentifierExpr));
    }

    public IdentifierEnum createIdentifierEnum() {
        return create(SwiftEntityDescriptorEnum.IdentifierEnum);
    }

    public IdentifierEnum createIdentifierEnum(IdentifierEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.IdentifierEnum, value);
    }

    public SuperRefExpr createSuperRefExpr() {
        return create(SwiftEntityDescriptorEnum.SuperRefExpr);
    }

    public NilLiteralExpr createNilLiteralExpr() {
        return create(SwiftEntityDescriptorEnum.NilLiteralExpr);
    }

    public DiscardAssignmentExpr createDiscardAssignmentExpr() {
        return create(SwiftEntityDescriptorEnum.DiscardAssignmentExpr);
    }

    public AssignmentExpr createAssignmentExpr() {
        return create(SwiftEntityDescriptorEnum.AssignmentExpr);
    }

    public SequenceExpr createSequenceExpr() {
        return create(SwiftEntityDescriptorEnum.SequenceExpr);
    }

    public SequenceExpr createSequenceExpr(Expr... entities) {
        return create(SwiftEntityDescriptorEnum.SequenceExpr, (IEntity[]) entities);
    }

    public SequenceExpr createSequenceExpr(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.SequenceExpr, initialSize);
    }

    public PoundLineExpr createPoundLineExpr() {
        return create(SwiftEntityDescriptorEnum.PoundLineExpr);
    }

    public PoundFileExpr createPoundFileExpr() {
        return create(SwiftEntityDescriptorEnum.PoundFileExpr);
    }

    public PoundFunctionExpr createPoundFunctionExpr() {
        return create(SwiftEntityDescriptorEnum.PoundFunctionExpr);
    }

    public PoundDsohandleExpr createPoundDsohandleExpr() {
        return create(SwiftEntityDescriptorEnum.PoundDsohandleExpr);
    }

    public SymbolicReferenceExpr createSymbolicReferenceExpr() {
        return create(SwiftEntityDescriptorEnum.SymbolicReferenceExpr);
    }

    public SymbolicReferenceExpr createSymbolicReferenceExpr(Identifier identifier, GenericArgumentList genericArgumentClause) {
        return create(SwiftEntityDescriptorEnum.SymbolicReferenceExpr, identifier, genericArgumentClause);
    }

    public IEntityBuilder<SymbolicReferenceExpr> buildSymbolicReferenceExpr() {
        return new EntityBuilder<SymbolicReferenceExpr>(create(SwiftEntityDescriptorEnum.SymbolicReferenceExpr));
    }

    public PrefixOperatorExpr createPrefixOperatorExpr() {
        return create(SwiftEntityDescriptorEnum.PrefixOperatorExpr);
    }

    public PrefixOperatorExpr createPrefixOperatorExpr(PrefixOperator operatorToken, Expr postfixExpression) {
        return create(SwiftEntityDescriptorEnum.PrefixOperatorExpr, operatorToken, postfixExpression);
    }

    public IEntityBuilder<PrefixOperatorExpr> buildPrefixOperatorExpr() {
        return new EntityBuilder<PrefixOperatorExpr>(create(SwiftEntityDescriptorEnum.PrefixOperatorExpr));
    }

    public BinaryOperatorExpr createBinaryOperatorExpr() {
        return create(SwiftEntityDescriptorEnum.BinaryOperatorExpr);
    }

    public BinaryOperatorExpr createBinaryOperatorExpr(AbstractOperatorToken operatorToken) {
        return create(SwiftEntityDescriptorEnum.BinaryOperatorExpr, operatorToken);
    }

    public ArrowExpr createArrowExpr() {
        return create(SwiftEntityDescriptorEnum.ArrowExpr);
    }

    public ArrowExpr createArrowExpr(Throws throwsToken) {
        return create(SwiftEntityDescriptorEnum.ArrowExpr, throwsToken);
    }

    public Throws createThrows() {
        return create(SwiftEntityDescriptorEnum.Throws);
    }

    public TupleExpr createTupleExpr() {
        return create(SwiftEntityDescriptorEnum.TupleExpr);
    }

    public TupleExpr createTupleExpr(TupleElement... entities) {
        return create(SwiftEntityDescriptorEnum.TupleExpr, (IEntity[]) entities);
    }

    public TupleExpr createTupleExpr(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.TupleExpr, initialSize);
    }

    public ArrayExpr createArrayExpr() {
        return create(SwiftEntityDescriptorEnum.ArrayExpr);
    }

    public ArrayExpr createArrayExpr(Expr... entities) {
        return create(SwiftEntityDescriptorEnum.ArrayExpr, (IEntity[]) entities);
    }

    public ArrayExpr createArrayExpr(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ArrayExpr, initialSize);
    }

    public DictionaryExpr createDictionaryExpr() {
        return create(SwiftEntityDescriptorEnum.DictionaryExpr);
    }

    public DictionaryExpr createDictionaryExpr(DictionaryElement... entities) {
        return create(SwiftEntityDescriptorEnum.DictionaryExpr, (IEntity[]) entities);
    }

    public DictionaryExpr createDictionaryExpr(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.DictionaryExpr, initialSize);
    }

    public FunctionCallArgument createFunctionCallArgument() {
        return create(SwiftEntityDescriptorEnum.FunctionCallArgument);
    }

    public FunctionCallArgument createFunctionCallArgument(Identifier label, Expr expression) {
        return create(SwiftEntityDescriptorEnum.FunctionCallArgument, label, expression);
    }

    public IEntityBuilder<FunctionCallArgument> buildFunctionCallArgument() {
        return new EntityBuilder<FunctionCallArgument>(create(SwiftEntityDescriptorEnum.FunctionCallArgument));
    }

    public TupleElement createTupleElement() {
        return create(SwiftEntityDescriptorEnum.TupleElement);
    }

    public TupleElement createTupleElement(Identifier label, Expr expression) {
        return create(SwiftEntityDescriptorEnum.TupleElement, label, expression);
    }

    public IEntityBuilder<TupleElement> buildTupleElement() {
        return new EntityBuilder<TupleElement>(create(SwiftEntityDescriptorEnum.TupleElement));
    }

    public DictionaryElement createDictionaryElement() {
        return create(SwiftEntityDescriptorEnum.DictionaryElement);
    }

    public DictionaryElement createDictionaryElement(Expr keyExpression, Expr valueExpression) {
        return create(SwiftEntityDescriptorEnum.DictionaryElement, keyExpression, valueExpression);
    }

    public IEntityBuilder<DictionaryElement> buildDictionaryElement() {
        return new EntityBuilder<DictionaryElement>(create(SwiftEntityDescriptorEnum.DictionaryElement));
    }

    public TernaryExpr createTernaryExpr() {
        return create(SwiftEntityDescriptorEnum.TernaryExpr);
    }

    public TernaryExpr createTernaryExpr(Expr conditionExpression, Expr firstChoice, Expr secondChoice) {
        return create(SwiftEntityDescriptorEnum.TernaryExpr, conditionExpression, firstChoice, secondChoice);
    }

    public IEntityBuilder<TernaryExpr> buildTernaryExpr() {
        return new EntityBuilder<TernaryExpr>(create(SwiftEntityDescriptorEnum.TernaryExpr));
    }

    public MemberAccessExpr createMemberAccessExpr() {
        return create(SwiftEntityDescriptorEnum.MemberAccessExpr);
    }

    public MemberAccessExpr createMemberAccessExpr(Expr base, DotEnum dot, Identifier name, DeclNameArgumentList declNameArguments) {
        return create(SwiftEntityDescriptorEnum.MemberAccessExpr, base, dot, name, declNameArguments);
    }

    public IEntityBuilder<MemberAccessExpr> buildMemberAccessExpr() {
        return new EntityBuilder<MemberAccessExpr>(create(SwiftEntityDescriptorEnum.MemberAccessExpr));
    }

    public DotEnum createDotEnum() {
        return create(SwiftEntityDescriptorEnum.DotEnum);
    }

    public DotEnum createDotEnum(DotEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.DotEnum, value);
    }

    public IsExpr createIsExpr() {
        return create(SwiftEntityDescriptorEnum.IsExpr);
    }

    public IsExpr createIsExpr(Type typeName) {
        return create(SwiftEntityDescriptorEnum.IsExpr, typeName);
    }

    public AsExpr createAsExpr() {
        return create(SwiftEntityDescriptorEnum.AsExpr);
    }

    public AsExpr createAsExpr(QuestionOrExclamationMarkEnum questionOrExclamationMark, Type typeName) {
        return create(SwiftEntityDescriptorEnum.AsExpr, questionOrExclamationMark, typeName);
    }

    public IEntityBuilder<AsExpr> buildAsExpr() {
        return new EntityBuilder<AsExpr>(create(SwiftEntityDescriptorEnum.AsExpr));
    }

    public TypeExpr createTypeExpr() {
        return create(SwiftEntityDescriptorEnum.TypeExpr);
    }

    public TypeExpr createTypeExpr(Type type) {
        return create(SwiftEntityDescriptorEnum.TypeExpr, type);
    }

    public ClosureCaptureItem createClosureCaptureItem() {
        return create(SwiftEntityDescriptorEnum.ClosureCaptureItem);
    }

    public ClosureCaptureItem createClosureCaptureItem(CaptureSpecifierEnum specifier, Identifier name, Expr expression) {
        return create(SwiftEntityDescriptorEnum.ClosureCaptureItem, specifier, name, expression);
    }

    public IEntityBuilder<ClosureCaptureItem> buildClosureCaptureItem() {
        return new EntityBuilder<ClosureCaptureItem>(create(SwiftEntityDescriptorEnum.ClosureCaptureItem));
    }

    public ClosureCaptureItemList createClosureCaptureItemList() {
        return create(SwiftEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public ClosureCaptureItemList createClosureCaptureItemList(ClosureCaptureItem... entities) {
        return create(SwiftEntityDescriptorEnum.ClosureCaptureItemList, (IEntity[]) entities);
    }

    public ClosureCaptureItemList createClosureCaptureItemList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ClosureCaptureItemList, initialSize);
    }

    public WildcardMarker createWildcardMarker() {
        return create(SwiftEntityDescriptorEnum.WildcardMarker);
    }

    public ClosureParamList createClosureParamList() {
        return create(SwiftEntityDescriptorEnum.ClosureParamList);
    }

    public ClosureParamList createClosureParamList(AbstractName... entities) {
        return create(SwiftEntityDescriptorEnum.ClosureParamList, (IEntity[]) entities);
    }

    public ClosureParamList createClosureParamList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ClosureParamList, initialSize);
    }

    public ClosureSignature createClosureSignature() {
        return create(SwiftEntityDescriptorEnum.ClosureSignature);
    }

    public ClosureSignature createClosureSignature(ClosureCaptureItemList capture, AbstractInput input, Throws throwsTok, Type output) {
        return create(SwiftEntityDescriptorEnum.ClosureSignature, capture, input, throwsTok, output);
    }

    public IEntityBuilder<ClosureSignature> buildClosureSignature() {
        return new EntityBuilder<ClosureSignature>(create(SwiftEntityDescriptorEnum.ClosureSignature));
    }

    public ClosureExpr createClosureExpr() {
        return create(SwiftEntityDescriptorEnum.ClosureExpr);
    }

    public ClosureExpr createClosureExpr(ClosureSignature signature, CodeBlockItemList statements) {
        return create(SwiftEntityDescriptorEnum.ClosureExpr, signature, statements);
    }

    public IEntityBuilder<ClosureExpr> buildClosureExpr() {
        return new EntityBuilder<ClosureExpr>(create(SwiftEntityDescriptorEnum.ClosureExpr));
    }

    public UnresolvedPatternExpr createUnresolvedPatternExpr() {
        return create(SwiftEntityDescriptorEnum.UnresolvedPatternExpr);
    }

    public UnresolvedPatternExpr createUnresolvedPatternExpr(Pattern pattern) {
        return create(SwiftEntityDescriptorEnum.UnresolvedPatternExpr, pattern);
    }

    public FunctionCallExpr createFunctionCallExpr() {
        return create(SwiftEntityDescriptorEnum.FunctionCallExpr);
    }

    public FunctionCallExpr createFunctionCallExpr(Expr calledExpression, FunctionCallArgumentList argumentList, ClosureExpr trailingClosure) {
        return create(SwiftEntityDescriptorEnum.FunctionCallExpr, calledExpression, argumentList, trailingClosure);
    }

    public IEntityBuilder<FunctionCallExpr> buildFunctionCallExpr() {
        return new EntityBuilder<FunctionCallExpr>(create(SwiftEntityDescriptorEnum.FunctionCallExpr));
    }

    public SubscriptExpr createSubscriptExpr() {
        return create(SwiftEntityDescriptorEnum.SubscriptExpr);
    }

    public SubscriptExpr createSubscriptExpr(Expr calledExpression, FunctionCallArgumentList argumentList, ClosureExpr trailingClosure) {
        return create(SwiftEntityDescriptorEnum.SubscriptExpr, calledExpression, argumentList, trailingClosure);
    }

    public IEntityBuilder<SubscriptExpr> buildSubscriptExpr() {
        return new EntityBuilder<SubscriptExpr>(create(SwiftEntityDescriptorEnum.SubscriptExpr));
    }

    public OptionalChainingExpr createOptionalChainingExpr() {
        return create(SwiftEntityDescriptorEnum.OptionalChainingExpr);
    }

    public OptionalChainingExpr createOptionalChainingExpr(Expr expression) {
        return create(SwiftEntityDescriptorEnum.OptionalChainingExpr, expression);
    }

    public ForcedValueExpr createForcedValueExpr() {
        return create(SwiftEntityDescriptorEnum.ForcedValueExpr);
    }

    public ForcedValueExpr createForcedValueExpr(Expr expression) {
        return create(SwiftEntityDescriptorEnum.ForcedValueExpr, expression);
    }

    public PostfixUnaryExpr createPostfixUnaryExpr() {
        return create(SwiftEntityDescriptorEnum.PostfixUnaryExpr);
    }

    public PostfixUnaryExpr createPostfixUnaryExpr(Expr expression, PostfixOperator operatorToken) {
        return create(SwiftEntityDescriptorEnum.PostfixUnaryExpr, expression, operatorToken);
    }

    public IEntityBuilder<PostfixUnaryExpr> buildPostfixUnaryExpr() {
        return new EntityBuilder<PostfixUnaryExpr>(create(SwiftEntityDescriptorEnum.PostfixUnaryExpr));
    }

    public SpecializeExpr createSpecializeExpr() {
        return create(SwiftEntityDescriptorEnum.SpecializeExpr);
    }

    public SpecializeExpr createSpecializeExpr(Expr expression, GenericArgumentList genericArgumentClause) {
        return create(SwiftEntityDescriptorEnum.SpecializeExpr, expression, genericArgumentClause);
    }

    public IEntityBuilder<SpecializeExpr> buildSpecializeExpr() {
        return new EntityBuilder<SpecializeExpr>(create(SwiftEntityDescriptorEnum.SpecializeExpr));
    }

    public StringLiteralExpr createStringLiteralExpr() {
        return create(SwiftEntityDescriptorEnum.StringLiteralExpr);
    }

    public StringLiteralExpr createStringLiteralExpr(RawStringDelimiter openDelimiter, OpenQuoteEnum openQuote, StringLiteralSegments segments) {
        return create(SwiftEntityDescriptorEnum.StringLiteralExpr, openDelimiter, openQuote, segments);
    }

    public IEntityBuilder<StringLiteralExpr> buildStringLiteralExpr() {
        return new EntityBuilder<StringLiteralExpr>(create(SwiftEntityDescriptorEnum.StringLiteralExpr));
    }

    public OpenQuoteEnum createOpenQuoteEnum() {
        return create(SwiftEntityDescriptorEnum.OpenQuoteEnum);
    }

    public OpenQuoteEnum createOpenQuoteEnum(OpenQuoteEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.OpenQuoteEnum, value);
    }

    public KeyPathExpr createKeyPathExpr() {
        return create(SwiftEntityDescriptorEnum.KeyPathExpr);
    }

    public KeyPathExpr createKeyPathExpr(AbstractRootExpr rootExpr, Expr expression) {
        return create(SwiftEntityDescriptorEnum.KeyPathExpr, rootExpr, expression);
    }

    public IEntityBuilder<KeyPathExpr> buildKeyPathExpr() {
        return new EntityBuilder<KeyPathExpr>(create(SwiftEntityDescriptorEnum.KeyPathExpr));
    }

    public KeyPathBaseExpr createKeyPathBaseExpr() {
        return create(SwiftEntityDescriptorEnum.KeyPathBaseExpr);
    }

    public ObjcKeyPathExpr createObjcKeyPathExpr() {
        return create(SwiftEntityDescriptorEnum.ObjcKeyPathExpr);
    }

    public ObjcKeyPathExpr createObjcKeyPathExpr(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.ObjcKeyPathExpr, (IEntity[]) entities);
    }

    public ObjcKeyPathExpr createObjcKeyPathExpr(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ObjcKeyPathExpr, initialSize);
    }

    public ObjcSelectorExpr createObjcSelectorExpr() {
        return create(SwiftEntityDescriptorEnum.ObjcSelectorExpr);
    }

    public ObjcSelectorExpr createObjcSelectorExpr(KindValue kind, Expr name) {
        return create(SwiftEntityDescriptorEnum.ObjcSelectorExpr, kind, name);
    }

    public IEntityBuilder<ObjcSelectorExpr> buildObjcSelectorExpr() {
        return new EntityBuilder<ObjcSelectorExpr>(create(SwiftEntityDescriptorEnum.ObjcSelectorExpr));
    }

    public KindValue createKindValue() {
        return create(SwiftEntityDescriptorEnum.KindValue);
    }

    public KindValue createKindValue(KindValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.KindValue, value);
    }

    public EditorPlaceholderExpr createEditorPlaceholderExpr() {
        return create(SwiftEntityDescriptorEnum.EditorPlaceholderExpr);
    }

    public EditorPlaceholderExpr createEditorPlaceholderExpr(Identifier identifier) {
        return create(SwiftEntityDescriptorEnum.EditorPlaceholderExpr, identifier);
    }

    public ObjectLiteralExpr createObjectLiteralExpr() {
        return create(SwiftEntityDescriptorEnum.ObjectLiteralExpr);
    }

    public ObjectLiteralExpr createObjectLiteralExpr(PoundIdentifierEnum poundIdentifier, FunctionCallArgumentList arguments) {
        return create(SwiftEntityDescriptorEnum.ObjectLiteralExpr, poundIdentifier, arguments);
    }

    public IEntityBuilder<ObjectLiteralExpr> buildObjectLiteralExpr() {
        return new EntityBuilder<ObjectLiteralExpr>(create(SwiftEntityDescriptorEnum.ObjectLiteralExpr));
    }

    public PoundIdentifierEnum createPoundIdentifierEnum() {
        return create(SwiftEntityDescriptorEnum.PoundIdentifierEnum);
    }

    public PoundIdentifierEnum createPoundIdentifierEnum(PoundIdentifierEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.PoundIdentifierEnum, value);
    }

    public TypealiasDecl createTypealiasDecl() {
        return create(SwiftEntityDescriptorEnum.TypealiasDecl);
    }

    public TypealiasDecl createTypealiasDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, GenericParameterList genericParameterClause, Type initializer, GenericRequirementList genericWhereClause) {
        return create(SwiftEntityDescriptorEnum.TypealiasDecl, attributes, modifiers, identifier, genericParameterClause, initializer, genericWhereClause);
    }

    public IEntityBuilder<TypealiasDecl> buildTypealiasDecl() {
        return new EntityBuilder<TypealiasDecl>(create(SwiftEntityDescriptorEnum.TypealiasDecl));
    }

    public AssociatedtypeDecl createAssociatedtypeDecl() {
        return create(SwiftEntityDescriptorEnum.AssociatedtypeDecl);
    }

    public AssociatedtypeDecl createAssociatedtypeDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, InheritedTypeList inheritanceClause, Type initializer, GenericRequirementList genericWhereClause) {
        return create(SwiftEntityDescriptorEnum.AssociatedtypeDecl, attributes, modifiers, identifier, inheritanceClause, initializer, genericWhereClause);
    }

    public IEntityBuilder<AssociatedtypeDecl> buildAssociatedtypeDecl() {
        return new EntityBuilder<AssociatedtypeDecl>(create(SwiftEntityDescriptorEnum.AssociatedtypeDecl));
    }

    public FunctionParameterList createFunctionParameterList() {
        return create(SwiftEntityDescriptorEnum.FunctionParameterList);
    }

    public FunctionParameterList createFunctionParameterList(FunctionParameter... entities) {
        return create(SwiftEntityDescriptorEnum.FunctionParameterList, (IEntity[]) entities);
    }

    public FunctionParameterList createFunctionParameterList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.FunctionParameterList, initialSize);
    }

    public FunctionSignature createFunctionSignature() {
        return create(SwiftEntityDescriptorEnum.FunctionSignature);
    }

    public FunctionSignature createFunctionSignature(FunctionParameterList input, ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword, Type output) {
        return create(SwiftEntityDescriptorEnum.FunctionSignature, input, throwsOrRethrowsKeyword, output);
    }

    public IEntityBuilder<FunctionSignature> buildFunctionSignature() {
        return new EntityBuilder<FunctionSignature>(create(SwiftEntityDescriptorEnum.FunctionSignature));
    }

    public ThrowsOrRethrowsKeywordEnum createThrowsOrRethrowsKeywordEnum() {
        return create(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum);
    }

    public ThrowsOrRethrowsKeywordEnum createThrowsOrRethrowsKeywordEnum(ThrowsOrRethrowsKeywordEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum, value);
    }

    public IfConfigClause createIfConfigClause() {
        return create(SwiftEntityDescriptorEnum.IfConfigClause);
    }

    public IfConfigClause createIfConfigClause(PoundKeywordEnum poundKeyword, Expr condition, AbstractElements elements) {
        return create(SwiftEntityDescriptorEnum.IfConfigClause, poundKeyword, condition, elements);
    }

    public IEntityBuilder<IfConfigClause> buildIfConfigClause() {
        return new EntityBuilder<IfConfigClause>(create(SwiftEntityDescriptorEnum.IfConfigClause));
    }

    public PoundKeywordEnum createPoundKeywordEnum() {
        return create(SwiftEntityDescriptorEnum.PoundKeywordEnum);
    }

    public PoundKeywordEnum createPoundKeywordEnum(PoundKeywordEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.PoundKeywordEnum, value);
    }

    public SwitchCaseList createSwitchCaseList() {
        return create(SwiftEntityDescriptorEnum.SwitchCaseList);
    }

    public SwitchCaseList createSwitchCaseList(AbstractSwitchCase... entities) {
        return create(SwiftEntityDescriptorEnum.SwitchCaseList, (IEntity[]) entities);
    }

    public SwitchCaseList createSwitchCaseList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.SwitchCaseList, initialSize);
    }

    public MemberDeclList createMemberDeclList() {
        return create(SwiftEntityDescriptorEnum.MemberDeclList);
    }

    public MemberDeclList createMemberDeclList(Decl... entities) {
        return create(SwiftEntityDescriptorEnum.MemberDeclList, (IEntity[]) entities);
    }

    public MemberDeclList createMemberDeclList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.MemberDeclList, initialSize);
    }

    public IfConfigDecl createIfConfigDecl() {
        return create(SwiftEntityDescriptorEnum.IfConfigDecl);
    }

    public IfConfigDecl createIfConfigDecl(IfConfigClause... entities) {
        return create(SwiftEntityDescriptorEnum.IfConfigDecl, (IEntity[]) entities);
    }

    public IfConfigDecl createIfConfigDecl(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.IfConfigDecl, initialSize);
    }

    public PoundErrorDecl createPoundErrorDecl() {
        return create(SwiftEntityDescriptorEnum.PoundErrorDecl);
    }

    public PoundErrorDecl createPoundErrorDecl(StringLiteralExpr message) {
        return create(SwiftEntityDescriptorEnum.PoundErrorDecl, message);
    }

    public PoundWarningDecl createPoundWarningDecl() {
        return create(SwiftEntityDescriptorEnum.PoundWarningDecl);
    }

    public PoundWarningDecl createPoundWarningDecl(StringLiteralExpr message) {
        return create(SwiftEntityDescriptorEnum.PoundWarningDecl, message);
    }

    public PoundSourceLocation createPoundSourceLocation() {
        return create(SwiftEntityDescriptorEnum.PoundSourceLocation);
    }

    public PoundSourceLocation createPoundSourceLocation(PoundSourceLocationArgs args) {
        return create(SwiftEntityDescriptorEnum.PoundSourceLocation, args);
    }

    public PoundSourceLocationArgs createPoundSourceLocationArgs() {
        return create(SwiftEntityDescriptorEnum.PoundSourceLocationArgs);
    }

    public PoundSourceLocationArgs createPoundSourceLocationArgs(Identifier fileArgLabel, StringLiteral fileName, Identifier lineArgLabel, IntegerLiteral lineNumber) {
        return create(SwiftEntityDescriptorEnum.PoundSourceLocationArgs, fileArgLabel, fileName, lineArgLabel, lineNumber);
    }

    public IEntityBuilder<PoundSourceLocationArgs> buildPoundSourceLocationArgs() {
        return new EntityBuilder<PoundSourceLocationArgs>(create(SwiftEntityDescriptorEnum.PoundSourceLocationArgs));
    }

    public DeclModifier createDeclModifier() {
        return create(SwiftEntityDescriptorEnum.DeclModifier);
    }

    public DeclModifier createDeclModifier(NameValue name, Identifier detail) {
        return create(SwiftEntityDescriptorEnum.DeclModifier, name, detail);
    }

    public IEntityBuilder<DeclModifier> buildDeclModifier() {
        return new EntityBuilder<DeclModifier>(create(SwiftEntityDescriptorEnum.DeclModifier));
    }

    public NameValue createNameValue() {
        return create(SwiftEntityDescriptorEnum.NameValue);
    }

    public NameValue createNameValue(NameValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.NameValue, value);
    }

    public InheritedTypeList createInheritedTypeList() {
        return create(SwiftEntityDescriptorEnum.InheritedTypeList);
    }

    public InheritedTypeList createInheritedTypeList(Type... entities) {
        return create(SwiftEntityDescriptorEnum.InheritedTypeList, (IEntity[]) entities);
    }

    public InheritedTypeList createInheritedTypeList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.InheritedTypeList, initialSize);
    }

    public ClassDecl createClassDecl() {
        return create(SwiftEntityDescriptorEnum.ClassDecl);
    }

    public ClassDecl createClassDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, GenericParameterList genericParameterClause, InheritedTypeList inheritanceClause, GenericRequirementList genericWhereClause, MemberDeclList members) {
        return create(SwiftEntityDescriptorEnum.ClassDecl, attributes, modifiers, identifier, genericParameterClause, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ClassDecl> buildClassDecl() {
        return new EntityBuilder<ClassDecl>(create(SwiftEntityDescriptorEnum.ClassDecl));
    }

    public StructDecl createStructDecl() {
        return create(SwiftEntityDescriptorEnum.StructDecl);
    }

    public StructDecl createStructDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, GenericParameterList genericParameterClause, InheritedTypeList inheritanceClause, GenericRequirementList genericWhereClause, MemberDeclList members) {
        return create(SwiftEntityDescriptorEnum.StructDecl, attributes, modifiers, identifier, genericParameterClause, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<StructDecl> buildStructDecl() {
        return new EntityBuilder<StructDecl>(create(SwiftEntityDescriptorEnum.StructDecl));
    }

    public ProtocolDecl createProtocolDecl() {
        return create(SwiftEntityDescriptorEnum.ProtocolDecl);
    }

    public ProtocolDecl createProtocolDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, InheritedTypeList inheritanceClause, GenericRequirementList genericWhereClause, MemberDeclList members) {
        return create(SwiftEntityDescriptorEnum.ProtocolDecl, attributes, modifiers, identifier, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ProtocolDecl> buildProtocolDecl() {
        return new EntityBuilder<ProtocolDecl>(create(SwiftEntityDescriptorEnum.ProtocolDecl));
    }

    public ExtensionDecl createExtensionDecl() {
        return create(SwiftEntityDescriptorEnum.ExtensionDecl);
    }

    public ExtensionDecl createExtensionDecl(AttributeList attributes, ModifierList modifiers, Type extendedType, InheritedTypeList inheritanceClause, GenericRequirementList genericWhereClause, MemberDeclList members) {
        return create(SwiftEntityDescriptorEnum.ExtensionDecl, attributes, modifiers, extendedType, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<ExtensionDecl> buildExtensionDecl() {
        return new EntityBuilder<ExtensionDecl>(create(SwiftEntityDescriptorEnum.ExtensionDecl));
    }

    public SourceFile createSourceFile() {
        return create(SwiftEntityDescriptorEnum.SourceFile);
    }

    public SourceFile createSourceFile(CodeBlockItemList statements) {
        return create(SwiftEntityDescriptorEnum.SourceFile, statements);
    }

    public FunctionParameter createFunctionParameter() {
        return create(SwiftEntityDescriptorEnum.FunctionParameter);
    }

    public FunctionParameter createFunctionParameter(AttributeList attributes, AbstractFirstName firstName, AbstractSecondName secondName, Type type, Ellipsis ellipsis, Expr defaultArgument) {
        return create(SwiftEntityDescriptorEnum.FunctionParameter, attributes, firstName, secondName, type, ellipsis, defaultArgument);
    }

    public IEntityBuilder<FunctionParameter> buildFunctionParameter() {
        return new EntityBuilder<FunctionParameter>(create(SwiftEntityDescriptorEnum.FunctionParameter));
    }

    public Ellipsis createEllipsis() {
        return create(SwiftEntityDescriptorEnum.Ellipsis);
    }

    public ModifierList createModifierList() {
        return create(SwiftEntityDescriptorEnum.ModifierList);
    }

    public ModifierList createModifierList(DeclModifier... entities) {
        return create(SwiftEntityDescriptorEnum.ModifierList, (IEntity[]) entities);
    }

    public ModifierList createModifierList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ModifierList, initialSize);
    }

    public FunctionDecl createFunctionDecl() {
        return create(SwiftEntityDescriptorEnum.FunctionDecl);
    }

    public FunctionDecl createFunctionDecl(AttributeList attributes, ModifierList modifiers, AbstractFunctionIdentifier functionIdentifier, GenericParameterList genericParameterClause, FunctionSignature signature, GenericRequirementList genericWhereClause, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.FunctionDecl, attributes, modifiers, functionIdentifier, genericParameterClause, signature, genericWhereClause, body);
    }

    public IEntityBuilder<FunctionDecl> buildFunctionDecl() {
        return new EntityBuilder<FunctionDecl>(create(SwiftEntityDescriptorEnum.FunctionDecl));
    }

    public InitializerDecl createInitializerDecl() {
        return create(SwiftEntityDescriptorEnum.InitializerDecl);
    }

    public InitializerDecl createInitializerDecl(AttributeList attributes, ModifierList modifiers, OptionalMarkEnum optionalMark, GenericParameterList genericParameterClause, FunctionParameterList parameters, ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword, GenericRequirementList genericWhereClause, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.InitializerDecl, attributes, modifiers, optionalMark, genericParameterClause, parameters, throwsOrRethrowsKeyword, genericWhereClause, body);
    }

    public IEntityBuilder<InitializerDecl> buildInitializerDecl() {
        return new EntityBuilder<InitializerDecl>(create(SwiftEntityDescriptorEnum.InitializerDecl));
    }

    public OptionalMarkEnum createOptionalMarkEnum() {
        return create(SwiftEntityDescriptorEnum.OptionalMarkEnum);
    }

    public OptionalMarkEnum createOptionalMarkEnum(OptionalMarkEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.OptionalMarkEnum, value);
    }

    public DeinitializerDecl createDeinitializerDecl() {
        return create(SwiftEntityDescriptorEnum.DeinitializerDecl);
    }

    public DeinitializerDecl createDeinitializerDecl(AttributeList attributes, ModifierList modifiers, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.DeinitializerDecl, attributes, modifiers, body);
    }

    public IEntityBuilder<DeinitializerDecl> buildDeinitializerDecl() {
        return new EntityBuilder<DeinitializerDecl>(create(SwiftEntityDescriptorEnum.DeinitializerDecl));
    }

    public SubscriptDecl createSubscriptDecl() {
        return create(SwiftEntityDescriptorEnum.SubscriptDecl);
    }

    public SubscriptDecl createSubscriptDecl(AttributeList attributes, ModifierList modifiers, GenericParameterList genericParameterClause, FunctionParameterList indices, Type result, GenericRequirementList genericWhereClause, AbstractAccessor accessor) {
        return create(SwiftEntityDescriptorEnum.SubscriptDecl, attributes, modifiers, genericParameterClause, indices, result, genericWhereClause, accessor);
    }

    public IEntityBuilder<SubscriptDecl> buildSubscriptDecl() {
        return new EntityBuilder<SubscriptDecl>(create(SwiftEntityDescriptorEnum.SubscriptDecl));
    }

    public AccessorBlock createAccessorBlock() {
        return create(SwiftEntityDescriptorEnum.AccessorBlock);
    }

    public AccessorBlock createAccessorBlock(AccessorDecl... entities) {
        return create(SwiftEntityDescriptorEnum.AccessorBlock, (IEntity[]) entities);
    }

    public AccessorBlock createAccessorBlock(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.AccessorBlock, initialSize);
    }

    public AccessLevelModifier createAccessLevelModifier() {
        return create(SwiftEntityDescriptorEnum.AccessLevelModifier);
    }

    public AccessLevelModifier createAccessLevelModifier(Identifier name, Identifier modifier) {
        return create(SwiftEntityDescriptorEnum.AccessLevelModifier, name, modifier);
    }

    public IEntityBuilder<AccessLevelModifier> buildAccessLevelModifier() {
        return new EntityBuilder<AccessLevelModifier>(create(SwiftEntityDescriptorEnum.AccessLevelModifier));
    }

    public AccessPath createAccessPath() {
        return create(SwiftEntityDescriptorEnum.AccessPath);
    }

    public AccessPath createAccessPath(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.AccessPath, (IEntity[]) entities);
    }

    public AccessPath createAccessPath(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.AccessPath, initialSize);
    }

    public ImportDecl createImportDecl() {
        return create(SwiftEntityDescriptorEnum.ImportDecl);
    }

    public ImportDecl createImportDecl(AttributeList attributes, ModifierList modifiers, ImportKindEnum importKind, AccessPath path) {
        return create(SwiftEntityDescriptorEnum.ImportDecl, attributes, modifiers, importKind, path);
    }

    public IEntityBuilder<ImportDecl> buildImportDecl() {
        return new EntityBuilder<ImportDecl>(create(SwiftEntityDescriptorEnum.ImportDecl));
    }

    public ImportKindEnum createImportKindEnum() {
        return create(SwiftEntityDescriptorEnum.ImportKindEnum);
    }

    public ImportKindEnum createImportKindEnum(ImportKindEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.ImportKindEnum, value);
    }

    public AccessorDecl createAccessorDecl() {
        return create(SwiftEntityDescriptorEnum.AccessorDecl);
    }

    public AccessorDecl createAccessorDecl(AttributeList attributes, DeclModifier modifier, AccessorKindValue accessorKind, Identifier parameter, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.AccessorDecl, attributes, modifier, accessorKind, parameter, body);
    }

    public IEntityBuilder<AccessorDecl> buildAccessorDecl() {
        return new EntityBuilder<AccessorDecl>(create(SwiftEntityDescriptorEnum.AccessorDecl));
    }

    public AccessorKindValue createAccessorKindValue() {
        return create(SwiftEntityDescriptorEnum.AccessorKindValue);
    }

    public AccessorKindValue createAccessorKindValue(AccessorKindValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.AccessorKindValue, value);
    }

    public PatternBinding createPatternBinding() {
        return create(SwiftEntityDescriptorEnum.PatternBinding);
    }

    public PatternBinding createPatternBinding(Pattern pattern, Type typeAnnotation, Expr initializer, AbstractAccessor accessor) {
        return create(SwiftEntityDescriptorEnum.PatternBinding, pattern, typeAnnotation, initializer, accessor);
    }

    public IEntityBuilder<PatternBinding> buildPatternBinding() {
        return new EntityBuilder<PatternBinding>(create(SwiftEntityDescriptorEnum.PatternBinding));
    }

    public PatternBindingList createPatternBindingList() {
        return create(SwiftEntityDescriptorEnum.PatternBindingList);
    }

    public PatternBindingList createPatternBindingList(PatternBinding... entities) {
        return create(SwiftEntityDescriptorEnum.PatternBindingList, (IEntity[]) entities);
    }

    public PatternBindingList createPatternBindingList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.PatternBindingList, initialSize);
    }

    public VariableDecl createVariableDecl() {
        return create(SwiftEntityDescriptorEnum.VariableDecl);
    }

    public VariableDecl createVariableDecl(AttributeList attributes, ModifierList modifiers, LetOrVarKeywordEnum letOrVarKeyword, PatternBindingList bindings) {
        return create(SwiftEntityDescriptorEnum.VariableDecl, attributes, modifiers, letOrVarKeyword, bindings);
    }

    public IEntityBuilder<VariableDecl> buildVariableDecl() {
        return new EntityBuilder<VariableDecl>(create(SwiftEntityDescriptorEnum.VariableDecl));
    }

    public LetOrVarKeywordEnum createLetOrVarKeywordEnum() {
        return create(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum);
    }

    public LetOrVarKeywordEnum createLetOrVarKeywordEnum(LetOrVarKeywordEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum, value);
    }

    public EnumCaseElement createEnumCaseElement() {
        return create(SwiftEntityDescriptorEnum.EnumCaseElement);
    }

    public EnumCaseElement createEnumCaseElement(Identifier identifier, FunctionParameterList associatedValue, Expr rawValue) {
        return create(SwiftEntityDescriptorEnum.EnumCaseElement, identifier, associatedValue, rawValue);
    }

    public IEntityBuilder<EnumCaseElement> buildEnumCaseElement() {
        return new EntityBuilder<EnumCaseElement>(create(SwiftEntityDescriptorEnum.EnumCaseElement));
    }

    public EnumCaseElementList createEnumCaseElementList() {
        return create(SwiftEntityDescriptorEnum.EnumCaseElementList);
    }

    public EnumCaseElementList createEnumCaseElementList(EnumCaseElement... entities) {
        return create(SwiftEntityDescriptorEnum.EnumCaseElementList, (IEntity[]) entities);
    }

    public EnumCaseElementList createEnumCaseElementList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.EnumCaseElementList, initialSize);
    }

    public EnumCaseDecl createEnumCaseDecl() {
        return create(SwiftEntityDescriptorEnum.EnumCaseDecl);
    }

    public EnumCaseDecl createEnumCaseDecl(AttributeList attributes, ModifierList modifiers, EnumCaseElementList elements) {
        return create(SwiftEntityDescriptorEnum.EnumCaseDecl, attributes, modifiers, elements);
    }

    public IEntityBuilder<EnumCaseDecl> buildEnumCaseDecl() {
        return new EntityBuilder<EnumCaseDecl>(create(SwiftEntityDescriptorEnum.EnumCaseDecl));
    }

    public EnumDecl createEnumDecl() {
        return create(SwiftEntityDescriptorEnum.EnumDecl);
    }

    public EnumDecl createEnumDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, GenericParameterList genericParameters, InheritedTypeList inheritanceClause, GenericRequirementList genericWhereClause, MemberDeclList members) {
        return create(SwiftEntityDescriptorEnum.EnumDecl, attributes, modifiers, identifier, genericParameters, inheritanceClause, genericWhereClause, members);
    }

    public IEntityBuilder<EnumDecl> buildEnumDecl() {
        return new EntityBuilder<EnumDecl>(create(SwiftEntityDescriptorEnum.EnumDecl));
    }

    public OperatorDecl createOperatorDecl() {
        return create(SwiftEntityDescriptorEnum.OperatorDecl);
    }

    public OperatorDecl createOperatorDecl(AttributeList attributes, ModifierList modifiers, AbstractOperatorIdentifier operatorIdentifier, IdentifierList operatorPrecedenceAndTypes) {
        return create(SwiftEntityDescriptorEnum.OperatorDecl, attributes, modifiers, operatorIdentifier, operatorPrecedenceAndTypes);
    }

    public IEntityBuilder<OperatorDecl> buildOperatorDecl() {
        return new EntityBuilder<OperatorDecl>(create(SwiftEntityDescriptorEnum.OperatorDecl));
    }

    public IdentifierList createIdentifierList() {
        return create(SwiftEntityDescriptorEnum.IdentifierList);
    }

    public IdentifierList createIdentifierList(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.IdentifierList, (IEntity[]) entities);
    }

    public IdentifierList createIdentifierList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.IdentifierList, initialSize);
    }

    public PrecedenceGroupDecl createPrecedenceGroupDecl() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupDecl);
    }

    public PrecedenceGroupDecl createPrecedenceGroupDecl(AttributeList attributes, ModifierList modifiers, Identifier identifier, PrecedenceGroupAttributeList groupAttributes) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupDecl, attributes, modifiers, identifier, groupAttributes);
    }

    public IEntityBuilder<PrecedenceGroupDecl> buildPrecedenceGroupDecl() {
        return new EntityBuilder<PrecedenceGroupDecl>(create(SwiftEntityDescriptorEnum.PrecedenceGroupDecl));
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList(AbstractPrecedenceGroupAttribute... entities) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList, (IEntity[]) entities);
    }

    public PrecedenceGroupAttributeList createPrecedenceGroupAttributeList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList, initialSize);
    }

    public PrecedenceGroupRelation createPrecedenceGroupRelation() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupRelation);
    }

    public PrecedenceGroupRelation createPrecedenceGroupRelation(HigherThanOrLowerThanValue higherThanOrLowerThan, PrecedenceGroupNameList otherNames) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupRelation, higherThanOrLowerThan, otherNames);
    }

    public IEntityBuilder<PrecedenceGroupRelation> buildPrecedenceGroupRelation() {
        return new EntityBuilder<PrecedenceGroupRelation>(create(SwiftEntityDescriptorEnum.PrecedenceGroupRelation));
    }

    public PrecedenceGroupAssignment createPrecedenceGroupAssignment() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment);
    }

    public PrecedenceGroupAssignment createPrecedenceGroupAssignment(Identifier assignmentKeyword, FlagEnum flag) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment, assignmentKeyword, flag);
    }

    public IEntityBuilder<PrecedenceGroupAssignment> buildPrecedenceGroupAssignment() {
        return new EntityBuilder<PrecedenceGroupAssignment>(create(SwiftEntityDescriptorEnum.PrecedenceGroupAssignment));
    }

    public PrecedenceGroupAssociativity createPrecedenceGroupAssociativity() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity);
    }

    public PrecedenceGroupAssociativity createPrecedenceGroupAssociativity(Identifier associativityKeyword, ValueValue value) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity, associativityKeyword, value);
    }

    public IEntityBuilder<PrecedenceGroupAssociativity> buildPrecedenceGroupAssociativity() {
        return new EntityBuilder<PrecedenceGroupAssociativity>(create(SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity));
    }

    public HigherThanOrLowerThanValue createHigherThanOrLowerThanValue() {
        return create(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue);
    }

    public HigherThanOrLowerThanValue createHigherThanOrLowerThanValue(HigherThanOrLowerThanValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue, value);
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList() {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupNameList);
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.PrecedenceGroupNameList, (IEntity[]) entities);
    }

    public PrecedenceGroupNameList createPrecedenceGroupNameList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.PrecedenceGroupNameList, initialSize);
    }

    public FlagEnum createFlagEnum() {
        return create(SwiftEntityDescriptorEnum.FlagEnum);
    }

    public FlagEnum createFlagEnum(FlagEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.FlagEnum, value);
    }

    public ValueValue createValueValue() {
        return create(SwiftEntityDescriptorEnum.ValueValue);
    }

    public ValueValue createValueValue(ValueValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.ValueValue, value);
    }

    public CustomAttribute createCustomAttribute() {
        return create(SwiftEntityDescriptorEnum.CustomAttribute);
    }

    public CustomAttribute createCustomAttribute(Type attributeName, FunctionCallArgumentList argumentList) {
        return create(SwiftEntityDescriptorEnum.CustomAttribute, attributeName, argumentList);
    }

    public IEntityBuilder<CustomAttribute> buildCustomAttribute() {
        return new EntityBuilder<CustomAttribute>(create(SwiftEntityDescriptorEnum.CustomAttribute));
    }

    public Attribute createAttribute() {
        return create(SwiftEntityDescriptorEnum.Attribute);
    }

    public Attribute createAttribute(Identifier attributeName, AbstractArgument argument) {
        return create(SwiftEntityDescriptorEnum.Attribute, attributeName, argument);
    }

    public IEntityBuilder<Attribute> buildAttribute() {
        return new EntityBuilder<Attribute>(create(SwiftEntityDescriptorEnum.Attribute));
    }

    public AvailabilitySpecList createAvailabilitySpecList() {
        return create(SwiftEntityDescriptorEnum.AvailabilitySpecList);
    }

    public AvailabilitySpecList createAvailabilitySpecList(AbstractEntry... entities) {
        return create(SwiftEntityDescriptorEnum.AvailabilitySpecList, (IEntity[]) entities);
    }

    public AvailabilitySpecList createAvailabilitySpecList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.AvailabilitySpecList, initialSize);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList() {
        return create(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList(AbstractSpecializeAttribute... entities) {
        return create(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList, (IEntity[]) entities);
    }

    public SpecializeAttributeSpecList createSpecializeAttributeSpecList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.SpecializeAttributeSpecList, initialSize);
    }

    public ObjCSelector createObjCSelector() {
        return create(SwiftEntityDescriptorEnum.ObjCSelector);
    }

    public ObjCSelector createObjCSelector(Identifier... entities) {
        return create(SwiftEntityDescriptorEnum.ObjCSelector, (IEntity[]) entities);
    }

    public ObjCSelector createObjCSelector(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ObjCSelector, initialSize);
    }

    public ImplementsAttributeArguments createImplementsAttributeArguments() {
        return create(SwiftEntityDescriptorEnum.ImplementsAttributeArguments);
    }

    public ImplementsAttributeArguments createImplementsAttributeArguments(SimpleTypeIdentifier type, AbstractDeclBaseName declBaseName, DeclNameArgumentList declNameArguments) {
        return create(SwiftEntityDescriptorEnum.ImplementsAttributeArguments, type, declBaseName, declNameArguments);
    }

    public IEntityBuilder<ImplementsAttributeArguments> buildImplementsAttributeArguments() {
        return new EntityBuilder<ImplementsAttributeArguments>(create(SwiftEntityDescriptorEnum.ImplementsAttributeArguments));
    }

    public NamedAttributeStringArgument createNamedAttributeStringArgument() {
        return create(SwiftEntityDescriptorEnum.NamedAttributeStringArgument);
    }

    public NamedAttributeStringArgument createNamedAttributeStringArgument(Identifier nameTok, AbstractStringOrDeclname stringOrDeclname) {
        return create(SwiftEntityDescriptorEnum.NamedAttributeStringArgument, nameTok, stringOrDeclname);
    }

    public IEntityBuilder<NamedAttributeStringArgument> buildNamedAttributeStringArgument() {
        return new EntityBuilder<NamedAttributeStringArgument>(create(SwiftEntityDescriptorEnum.NamedAttributeStringArgument));
    }

    public AttributeList createAttributeList() {
        return create(SwiftEntityDescriptorEnum.AttributeList);
    }

    public AttributeList createAttributeList(AbstractAttribute... entities) {
        return create(SwiftEntityDescriptorEnum.AttributeList, (IEntity[]) entities);
    }

    public AttributeList createAttributeList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.AttributeList, initialSize);
    }

    public LabeledSpecializeEntry createLabeledSpecializeEntry() {
        return create(SwiftEntityDescriptorEnum.LabeledSpecializeEntry);
    }

    public LabeledSpecializeEntry createLabeledSpecializeEntry(Identifier label, AbstractValue value) {
        return create(SwiftEntityDescriptorEnum.LabeledSpecializeEntry, label, value);
    }

    public IEntityBuilder<LabeledSpecializeEntry> buildLabeledSpecializeEntry() {
        return new EntityBuilder<LabeledSpecializeEntry>(create(SwiftEntityDescriptorEnum.LabeledSpecializeEntry));
    }

    public DeclName createDeclName() {
        return create(SwiftEntityDescriptorEnum.DeclName);
    }

    public DeclName createDeclName(AbstractDeclBaseName declBaseName, DeclNameArgumentList declNameArguments) {
        return create(SwiftEntityDescriptorEnum.DeclName, declBaseName, declNameArguments);
    }

    public IEntityBuilder<DeclName> buildDeclName() {
        return new EntityBuilder<DeclName>(create(SwiftEntityDescriptorEnum.DeclName));
    }

    public ContinueStmt createContinueStmt() {
        return create(SwiftEntityDescriptorEnum.ContinueStmt);
    }

    public ContinueStmt createContinueStmt(Identifier label) {
        return create(SwiftEntityDescriptorEnum.ContinueStmt, label);
    }

    public WhileStmt createWhileStmt() {
        return create(SwiftEntityDescriptorEnum.WhileStmt);
    }

    public WhileStmt createWhileStmt(Identifier labelName, ConditionElementList conditions, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.WhileStmt, labelName, conditions, body);
    }

    public IEntityBuilder<WhileStmt> buildWhileStmt() {
        return new EntityBuilder<WhileStmt>(create(SwiftEntityDescriptorEnum.WhileStmt));
    }

    public DeferStmt createDeferStmt() {
        return create(SwiftEntityDescriptorEnum.DeferStmt);
    }

    public DeferStmt createDeferStmt(CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.DeferStmt, body);
    }

    public SwitchCase createSwitchCase() {
        return create(SwiftEntityDescriptorEnum.SwitchCase);
    }

    public SwitchCase createSwitchCase(Attribute unknownAttr, AbstractLabel label, CodeBlockItemList statements) {
        return create(SwiftEntityDescriptorEnum.SwitchCase, unknownAttr, label, statements);
    }

    public IEntityBuilder<SwitchCase> buildSwitchCase() {
        return new EntityBuilder<SwitchCase>(create(SwiftEntityDescriptorEnum.SwitchCase));
    }

    public RepeatWhileStmt createRepeatWhileStmt() {
        return create(SwiftEntityDescriptorEnum.RepeatWhileStmt);
    }

    public RepeatWhileStmt createRepeatWhileStmt(Identifier labelName, CodeBlockItemList body, Expr condition) {
        return create(SwiftEntityDescriptorEnum.RepeatWhileStmt, labelName, body, condition);
    }

    public IEntityBuilder<RepeatWhileStmt> buildRepeatWhileStmt() {
        return new EntityBuilder<RepeatWhileStmt>(create(SwiftEntityDescriptorEnum.RepeatWhileStmt));
    }

    public GuardStmt createGuardStmt() {
        return create(SwiftEntityDescriptorEnum.GuardStmt);
    }

    public GuardStmt createGuardStmt(ConditionElementList conditions, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.GuardStmt, conditions, body);
    }

    public IEntityBuilder<GuardStmt> buildGuardStmt() {
        return new EntityBuilder<GuardStmt>(create(SwiftEntityDescriptorEnum.GuardStmt));
    }

    public ForInStmt createForInStmt() {
        return create(SwiftEntityDescriptorEnum.ForInStmt);
    }

    public ForInStmt createForInStmt(Identifier labelName, Case caseKeyword, Pattern pattern, Type typeAnnotation, Expr sequenceExpr, Expr whereClause, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.ForInStmt, labelName, caseKeyword, pattern, typeAnnotation, sequenceExpr, whereClause, body);
    }

    public IEntityBuilder<ForInStmt> buildForInStmt() {
        return new EntityBuilder<ForInStmt>(create(SwiftEntityDescriptorEnum.ForInStmt));
    }

    public Case createCase() {
        return create(SwiftEntityDescriptorEnum.Case);
    }

    public SwitchStmt createSwitchStmt() {
        return create(SwiftEntityDescriptorEnum.SwitchStmt);
    }

    public SwitchStmt createSwitchStmt(Identifier labelName, Expr expression, SwitchCaseList cases) {
        return create(SwiftEntityDescriptorEnum.SwitchStmt, labelName, expression, cases);
    }

    public IEntityBuilder<SwitchStmt> buildSwitchStmt() {
        return new EntityBuilder<SwitchStmt>(create(SwiftEntityDescriptorEnum.SwitchStmt));
    }

    public CatchClauseList createCatchClauseList() {
        return create(SwiftEntityDescriptorEnum.CatchClauseList);
    }

    public CatchClauseList createCatchClauseList(CatchClause... entities) {
        return create(SwiftEntityDescriptorEnum.CatchClauseList, (IEntity[]) entities);
    }

    public CatchClauseList createCatchClauseList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.CatchClauseList, initialSize);
    }

    public DoStmt createDoStmt() {
        return create(SwiftEntityDescriptorEnum.DoStmt);
    }

    public DoStmt createDoStmt(Identifier labelName, CodeBlockItemList body, CatchClauseList catchClauses) {
        return create(SwiftEntityDescriptorEnum.DoStmt, labelName, body, catchClauses);
    }

    public IEntityBuilder<DoStmt> buildDoStmt() {
        return new EntityBuilder<DoStmt>(create(SwiftEntityDescriptorEnum.DoStmt));
    }

    public ReturnStmt createReturnStmt() {
        return create(SwiftEntityDescriptorEnum.ReturnStmt);
    }

    public ReturnStmt createReturnStmt(Expr expression) {
        return create(SwiftEntityDescriptorEnum.ReturnStmt, expression);
    }

    public YieldStmt createYieldStmt() {
        return create(SwiftEntityDescriptorEnum.YieldStmt);
    }

    public YieldStmt createYieldStmt(AbstractYields yields) {
        return create(SwiftEntityDescriptorEnum.YieldStmt, yields);
    }

    public YieldList createYieldList() {
        return create(SwiftEntityDescriptorEnum.YieldList);
    }

    public YieldList createYieldList(Expr... entities) {
        return create(SwiftEntityDescriptorEnum.YieldList, (IEntity[]) entities);
    }

    public YieldList createYieldList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.YieldList, initialSize);
    }

    public FallthroughStmt createFallthroughStmt() {
        return create(SwiftEntityDescriptorEnum.FallthroughStmt);
    }

    public BreakStmt createBreakStmt() {
        return create(SwiftEntityDescriptorEnum.BreakStmt);
    }

    public BreakStmt createBreakStmt(Identifier label) {
        return create(SwiftEntityDescriptorEnum.BreakStmt, label);
    }

    public AvailabilityCondition createAvailabilityCondition() {
        return create(SwiftEntityDescriptorEnum.AvailabilityCondition);
    }

    public AvailabilityCondition createAvailabilityCondition(AvailabilitySpecList availabilitySpec) {
        return create(SwiftEntityDescriptorEnum.AvailabilityCondition, availabilitySpec);
    }

    public MatchingPatternCondition createMatchingPatternCondition() {
        return create(SwiftEntityDescriptorEnum.MatchingPatternCondition);
    }

    public MatchingPatternCondition createMatchingPatternCondition(Pattern pattern, Type typeAnnotation, Expr initializer) {
        return create(SwiftEntityDescriptorEnum.MatchingPatternCondition, pattern, typeAnnotation, initializer);
    }

    public IEntityBuilder<MatchingPatternCondition> buildMatchingPatternCondition() {
        return new EntityBuilder<MatchingPatternCondition>(create(SwiftEntityDescriptorEnum.MatchingPatternCondition));
    }

    public OptionalBindingCondition createOptionalBindingCondition() {
        return create(SwiftEntityDescriptorEnum.OptionalBindingCondition);
    }

    public OptionalBindingCondition createOptionalBindingCondition(LetOrVarKeywordEnum letOrVarKeyword, Pattern pattern, Type typeAnnotation, Expr initializer) {
        return create(SwiftEntityDescriptorEnum.OptionalBindingCondition, letOrVarKeyword, pattern, typeAnnotation, initializer);
    }

    public IEntityBuilder<OptionalBindingCondition> buildOptionalBindingCondition() {
        return new EntityBuilder<OptionalBindingCondition>(create(SwiftEntityDescriptorEnum.OptionalBindingCondition));
    }

    public ConditionElementList createConditionElementList() {
        return create(SwiftEntityDescriptorEnum.ConditionElementList);
    }

    public ConditionElementList createConditionElementList(AbstractCondition... entities) {
        return create(SwiftEntityDescriptorEnum.ConditionElementList, (IEntity[]) entities);
    }

    public ConditionElementList createConditionElementList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.ConditionElementList, initialSize);
    }

    public ThrowStmt createThrowStmt() {
        return create(SwiftEntityDescriptorEnum.ThrowStmt);
    }

    public ThrowStmt createThrowStmt(Expr expression) {
        return create(SwiftEntityDescriptorEnum.ThrowStmt, expression);
    }

    public IfStmt createIfStmt() {
        return create(SwiftEntityDescriptorEnum.IfStmt);
    }

    public IfStmt createIfStmt(Identifier labelName, ConditionElementList conditions, CodeBlockItemList body, AbstractElseBody elseBody) {
        return create(SwiftEntityDescriptorEnum.IfStmt, labelName, conditions, body, elseBody);
    }

    public IEntityBuilder<IfStmt> buildIfStmt() {
        return new EntityBuilder<IfStmt>(create(SwiftEntityDescriptorEnum.IfStmt));
    }

    public SwitchDefaultLabel createSwitchDefaultLabel() {
        return create(SwiftEntityDescriptorEnum.SwitchDefaultLabel);
    }

    public SwitchCaseLabel createSwitchCaseLabel() {
        return create(SwiftEntityDescriptorEnum.SwitchCaseLabel);
    }

    public SwitchCaseLabel createSwitchCaseLabel(CaseItem... entities) {
        return create(SwiftEntityDescriptorEnum.SwitchCaseLabel, (IEntity[]) entities);
    }

    public SwitchCaseLabel createSwitchCaseLabel(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.SwitchCaseLabel, initialSize);
    }

    public CaseItem createCaseItem() {
        return create(SwiftEntityDescriptorEnum.CaseItem);
    }

    public CaseItem createCaseItem(Pattern pattern, Expr whereClause) {
        return create(SwiftEntityDescriptorEnum.CaseItem, pattern, whereClause);
    }

    public IEntityBuilder<CaseItem> buildCaseItem() {
        return new EntityBuilder<CaseItem>(create(SwiftEntityDescriptorEnum.CaseItem));
    }

    public CatchClause createCatchClause() {
        return create(SwiftEntityDescriptorEnum.CatchClause);
    }

    public CatchClause createCatchClause(Pattern pattern, Expr whereClause, CodeBlockItemList body) {
        return create(SwiftEntityDescriptorEnum.CatchClause, pattern, whereClause, body);
    }

    public IEntityBuilder<CatchClause> buildCatchClause() {
        return new EntityBuilder<CatchClause>(create(SwiftEntityDescriptorEnum.CatchClause));
    }

    public PoundAssertStmt createPoundAssertStmt() {
        return create(SwiftEntityDescriptorEnum.PoundAssertStmt);
    }

    public PoundAssertStmt createPoundAssertStmt(Expr condition, StringLiteral message) {
        return create(SwiftEntityDescriptorEnum.PoundAssertStmt, condition, message);
    }

    public IEntityBuilder<PoundAssertStmt> buildPoundAssertStmt() {
        return new EntityBuilder<PoundAssertStmt>(create(SwiftEntityDescriptorEnum.PoundAssertStmt));
    }

    public GenericRequirementList createGenericRequirementList() {
        return create(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public GenericRequirementList createGenericRequirementList(AbstractGenericRequirement... entities) {
        return create(SwiftEntityDescriptorEnum.GenericRequirementList, (IEntity[]) entities);
    }

    public GenericRequirementList createGenericRequirementList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.GenericRequirementList, initialSize);
    }

    public SameTypeRequirement createSameTypeRequirement() {
        return create(SwiftEntityDescriptorEnum.SameTypeRequirement);
    }

    public SameTypeRequirement createSameTypeRequirement(Type leftTypeIdentifier, AbstractEqualityToken equalityToken, Type rightTypeIdentifier) {
        return create(SwiftEntityDescriptorEnum.SameTypeRequirement, leftTypeIdentifier, equalityToken, rightTypeIdentifier);
    }

    public IEntityBuilder<SameTypeRequirement> buildSameTypeRequirement() {
        return new EntityBuilder<SameTypeRequirement>(create(SwiftEntityDescriptorEnum.SameTypeRequirement));
    }

    public ConformanceRequirement createConformanceRequirement() {
        return create(SwiftEntityDescriptorEnum.ConformanceRequirement);
    }

    public ConformanceRequirement createConformanceRequirement(Type leftTypeIdentifier, Type rightTypeIdentifier) {
        return create(SwiftEntityDescriptorEnum.ConformanceRequirement, leftTypeIdentifier, rightTypeIdentifier);
    }

    public IEntityBuilder<ConformanceRequirement> buildConformanceRequirement() {
        return new EntityBuilder<ConformanceRequirement>(create(SwiftEntityDescriptorEnum.ConformanceRequirement));
    }

    public GenericParameterList createGenericParameterList() {
        return create(SwiftEntityDescriptorEnum.GenericParameterList);
    }

    public GenericParameterList createGenericParameterList(GenericParameter... entities) {
        return create(SwiftEntityDescriptorEnum.GenericParameterList, (IEntity[]) entities);
    }

    public GenericParameterList createGenericParameterList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.GenericParameterList, initialSize);
    }

    public GenericParameter createGenericParameter() {
        return create(SwiftEntityDescriptorEnum.GenericParameter);
    }

    public GenericParameter createGenericParameter(AttributeList attributes, Identifier name, Type inheritedType) {
        return create(SwiftEntityDescriptorEnum.GenericParameter, attributes, name, inheritedType);
    }

    public IEntityBuilder<GenericParameter> buildGenericParameter() {
        return new EntityBuilder<GenericParameter>(create(SwiftEntityDescriptorEnum.GenericParameter));
    }

    public SimpleTypeIdentifier createSimpleTypeIdentifier() {
        return create(SwiftEntityDescriptorEnum.SimpleTypeIdentifier);
    }

    public SimpleTypeIdentifier createSimpleTypeIdentifier(AbstractName name, GenericArgumentList genericArgumentClause) {
        return create(SwiftEntityDescriptorEnum.SimpleTypeIdentifier, name, genericArgumentClause);
    }

    public IEntityBuilder<SimpleTypeIdentifier> buildSimpleTypeIdentifier() {
        return new EntityBuilder<SimpleTypeIdentifier>(create(SwiftEntityDescriptorEnum.SimpleTypeIdentifier));
    }

    public NameEnum createNameEnum() {
        return create(SwiftEntityDescriptorEnum.NameEnum);
    }

    public NameEnum createNameEnum(NameEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.NameEnum, value);
    }

    public MemberTypeIdentifier createMemberTypeIdentifier() {
        return create(SwiftEntityDescriptorEnum.MemberTypeIdentifier);
    }

    public MemberTypeIdentifier createMemberTypeIdentifier(Type baseType, PeriodEnum period, AbstractName name, GenericArgumentList genericArgumentClause) {
        return create(SwiftEntityDescriptorEnum.MemberTypeIdentifier, baseType, period, name, genericArgumentClause);
    }

    public IEntityBuilder<MemberTypeIdentifier> buildMemberTypeIdentifier() {
        return new EntityBuilder<MemberTypeIdentifier>(create(SwiftEntityDescriptorEnum.MemberTypeIdentifier));
    }

    public PeriodEnum createPeriodEnum() {
        return create(SwiftEntityDescriptorEnum.PeriodEnum);
    }

    public PeriodEnum createPeriodEnum(PeriodEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.PeriodEnum, value);
    }

    public ClassRestrictionType createClassRestrictionType() {
        return create(SwiftEntityDescriptorEnum.ClassRestrictionType);
    }

    public ArrayType createArrayType() {
        return create(SwiftEntityDescriptorEnum.ArrayType);
    }

    public ArrayType createArrayType(Type elementType) {
        return create(SwiftEntityDescriptorEnum.ArrayType, elementType);
    }

    public DictionaryType createDictionaryType() {
        return create(SwiftEntityDescriptorEnum.DictionaryType);
    }

    public DictionaryType createDictionaryType(Type keyType, Type valueType) {
        return create(SwiftEntityDescriptorEnum.DictionaryType, keyType, valueType);
    }

    public IEntityBuilder<DictionaryType> buildDictionaryType() {
        return new EntityBuilder<DictionaryType>(create(SwiftEntityDescriptorEnum.DictionaryType));
    }

    public MetatypeType createMetatypeType() {
        return create(SwiftEntityDescriptorEnum.MetatypeType);
    }

    public MetatypeType createMetatypeType(Type baseType, TypeOrProtocolValue typeOrProtocol) {
        return create(SwiftEntityDescriptorEnum.MetatypeType, baseType, typeOrProtocol);
    }

    public IEntityBuilder<MetatypeType> buildMetatypeType() {
        return new EntityBuilder<MetatypeType>(create(SwiftEntityDescriptorEnum.MetatypeType));
    }

    public TypeOrProtocolValue createTypeOrProtocolValue() {
        return create(SwiftEntityDescriptorEnum.TypeOrProtocolValue);
    }

    public TypeOrProtocolValue createTypeOrProtocolValue(TypeOrProtocolValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.TypeOrProtocolValue, value);
    }

    public OptionalType createOptionalType() {
        return create(SwiftEntityDescriptorEnum.OptionalType);
    }

    public OptionalType createOptionalType(Type wrappedType) {
        return create(SwiftEntityDescriptorEnum.OptionalType, wrappedType);
    }

    public SomeType createSomeType() {
        return create(SwiftEntityDescriptorEnum.SomeType);
    }

    public SomeType createSomeType(Identifier someSpecifier, Type baseType) {
        return create(SwiftEntityDescriptorEnum.SomeType, someSpecifier, baseType);
    }

    public IEntityBuilder<SomeType> buildSomeType() {
        return new EntityBuilder<SomeType>(create(SwiftEntityDescriptorEnum.SomeType));
    }

    public ImplicitlyUnwrappedOptionalType createImplicitlyUnwrappedOptionalType() {
        return create(SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType);
    }

    public ImplicitlyUnwrappedOptionalType createImplicitlyUnwrappedOptionalType(Type wrappedType) {
        return create(SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType, wrappedType);
    }

    public CompositionTypeElement createCompositionTypeElement() {
        return create(SwiftEntityDescriptorEnum.CompositionTypeElement);
    }

    public CompositionTypeElement createCompositionTypeElement(Type type, Ampersand ampersand) {
        return create(SwiftEntityDescriptorEnum.CompositionTypeElement, type, ampersand);
    }

    public IEntityBuilder<CompositionTypeElement> buildCompositionTypeElement() {
        return new EntityBuilder<CompositionTypeElement>(create(SwiftEntityDescriptorEnum.CompositionTypeElement));
    }

    public Ampersand createAmpersand() {
        return create(SwiftEntityDescriptorEnum.Ampersand);
    }

    public CompositionType createCompositionType() {
        return create(SwiftEntityDescriptorEnum.CompositionType);
    }

    public CompositionType createCompositionType(CompositionTypeElement... entities) {
        return create(SwiftEntityDescriptorEnum.CompositionType, (IEntity[]) entities);
    }

    public CompositionType createCompositionType(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.CompositionType, initialSize);
    }

    public TupleTypeElement createTupleTypeElement() {
        return create(SwiftEntityDescriptorEnum.TupleTypeElement);
    }

    public TupleTypeElement createTupleTypeElement(Inout inOut, AbstractName name, AbstractSecondName secondName, Type type, Ellipsis ellipsis, Expr initializer) {
        return create(SwiftEntityDescriptorEnum.TupleTypeElement, inOut, name, secondName, type, ellipsis, initializer);
    }

    public IEntityBuilder<TupleTypeElement> buildTupleTypeElement() {
        return new EntityBuilder<TupleTypeElement>(create(SwiftEntityDescriptorEnum.TupleTypeElement));
    }

    public Inout createInout() {
        return create(SwiftEntityDescriptorEnum.Inout);
    }

    public TupleTypeElementList createTupleTypeElementList() {
        return create(SwiftEntityDescriptorEnum.TupleTypeElementList);
    }

    public TupleTypeElementList createTupleTypeElementList(TupleTypeElement... entities) {
        return create(SwiftEntityDescriptorEnum.TupleTypeElementList, (IEntity[]) entities);
    }

    public TupleTypeElementList createTupleTypeElementList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.TupleTypeElementList, initialSize);
    }

    public TupleType createTupleType() {
        return create(SwiftEntityDescriptorEnum.TupleType);
    }

    public TupleType createTupleType(TupleTypeElementList elements) {
        return create(SwiftEntityDescriptorEnum.TupleType, elements);
    }

    public FunctionType createFunctionType() {
        return create(SwiftEntityDescriptorEnum.FunctionType);
    }

    public FunctionType createFunctionType(TupleTypeElementList arguments, ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword, Type returnType) {
        return create(SwiftEntityDescriptorEnum.FunctionType, arguments, throwsOrRethrowsKeyword, returnType);
    }

    public IEntityBuilder<FunctionType> buildFunctionType() {
        return new EntityBuilder<FunctionType>(create(SwiftEntityDescriptorEnum.FunctionType));
    }

    public AttributedType createAttributedType() {
        return create(SwiftEntityDescriptorEnum.AttributedType);
    }

    public AttributedType createAttributedType(SpecifierValue specifier, AttributeList attributes, Type baseType) {
        return create(SwiftEntityDescriptorEnum.AttributedType, specifier, attributes, baseType);
    }

    public IEntityBuilder<AttributedType> buildAttributedType() {
        return new EntityBuilder<AttributedType>(create(SwiftEntityDescriptorEnum.AttributedType));
    }

    public SpecifierValue createSpecifierValue() {
        return create(SwiftEntityDescriptorEnum.SpecifierValue);
    }

    public SpecifierValue createSpecifierValue(SpecifierValueEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.SpecifierValue, value);
    }

    public GenericArgumentList createGenericArgumentList() {
        return create(SwiftEntityDescriptorEnum.GenericArgumentList);
    }

    public GenericArgumentList createGenericArgumentList(Type... entities) {
        return create(SwiftEntityDescriptorEnum.GenericArgumentList, (IEntity[]) entities);
    }

    public GenericArgumentList createGenericArgumentList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.GenericArgumentList, initialSize);
    }

    public EnumCasePattern createEnumCasePattern() {
        return create(SwiftEntityDescriptorEnum.EnumCasePattern);
    }

    public EnumCasePattern createEnumCasePattern(Type type, Identifier caseName, TuplePatternElementList associatedTuple) {
        return create(SwiftEntityDescriptorEnum.EnumCasePattern, type, caseName, associatedTuple);
    }

    public IEntityBuilder<EnumCasePattern> buildEnumCasePattern() {
        return new EntityBuilder<EnumCasePattern>(create(SwiftEntityDescriptorEnum.EnumCasePattern));
    }

    public IsTypePattern createIsTypePattern() {
        return create(SwiftEntityDescriptorEnum.IsTypePattern);
    }

    public IsTypePattern createIsTypePattern(Type type) {
        return create(SwiftEntityDescriptorEnum.IsTypePattern, type);
    }

    public OptionalPattern createOptionalPattern() {
        return create(SwiftEntityDescriptorEnum.OptionalPattern);
    }

    public OptionalPattern createOptionalPattern(Pattern subPattern) {
        return create(SwiftEntityDescriptorEnum.OptionalPattern, subPattern);
    }

    public IdentifierPattern createIdentifierPattern() {
        return create(SwiftEntityDescriptorEnum.IdentifierPattern);
    }

    public IdentifierPattern createIdentifierPattern(AbstractPatternIdentifier patternIdentifier) {
        return create(SwiftEntityDescriptorEnum.IdentifierPattern, patternIdentifier);
    }

    public SelfMarker createSelfMarker() {
        return create(SwiftEntityDescriptorEnum.SelfMarker);
    }

    public AsTypePattern createAsTypePattern() {
        return create(SwiftEntityDescriptorEnum.AsTypePattern);
    }

    public AsTypePattern createAsTypePattern(Pattern pattern, Type type) {
        return create(SwiftEntityDescriptorEnum.AsTypePattern, pattern, type);
    }

    public IEntityBuilder<AsTypePattern> buildAsTypePattern() {
        return new EntityBuilder<AsTypePattern>(create(SwiftEntityDescriptorEnum.AsTypePattern));
    }

    public WildcardPattern createWildcardPattern() {
        return create(SwiftEntityDescriptorEnum.WildcardPattern);
    }

    public WildcardPattern createWildcardPattern(Type typeAnnotation) {
        return create(SwiftEntityDescriptorEnum.WildcardPattern, typeAnnotation);
    }

    public TuplePatternElement createTuplePatternElement() {
        return create(SwiftEntityDescriptorEnum.TuplePatternElement);
    }

    public TuplePatternElement createTuplePatternElement(Identifier labelName, Pattern pattern) {
        return create(SwiftEntityDescriptorEnum.TuplePatternElement, labelName, pattern);
    }

    public IEntityBuilder<TuplePatternElement> buildTuplePatternElement() {
        return new EntityBuilder<TuplePatternElement>(create(SwiftEntityDescriptorEnum.TuplePatternElement));
    }

    public ExpressionPattern createExpressionPattern() {
        return create(SwiftEntityDescriptorEnum.ExpressionPattern);
    }

    public ExpressionPattern createExpressionPattern(Expr expression) {
        return create(SwiftEntityDescriptorEnum.ExpressionPattern, expression);
    }

    public TuplePatternElementList createTuplePatternElementList() {
        return create(SwiftEntityDescriptorEnum.TuplePatternElementList);
    }

    public TuplePatternElementList createTuplePatternElementList(TuplePatternElement... entities) {
        return create(SwiftEntityDescriptorEnum.TuplePatternElementList, (IEntity[]) entities);
    }

    public TuplePatternElementList createTuplePatternElementList(int initialSize) {
        return clone(SwiftEntityDescriptorEnum.TuplePatternElementList, initialSize);
    }

    public ValueBindingPattern createValueBindingPattern() {
        return create(SwiftEntityDescriptorEnum.ValueBindingPattern);
    }

    public ValueBindingPattern createValueBindingPattern(LetOrVarKeywordEnum letOrVarKeyword, Pattern valuePattern) {
        return create(SwiftEntityDescriptorEnum.ValueBindingPattern, letOrVarKeyword, valuePattern);
    }

    public IEntityBuilder<ValueBindingPattern> buildValueBindingPattern() {
        return new EntityBuilder<ValueBindingPattern>(create(SwiftEntityDescriptorEnum.ValueBindingPattern));
    }

    public AvailabilityVersionRestriction createAvailabilityVersionRestriction() {
        return create(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction);
    }

    public AvailabilityVersionRestriction createAvailabilityVersionRestriction(Identifier platform, VersionTuple version) {
        return create(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction, platform, version);
    }

    public IEntityBuilder<AvailabilityVersionRestriction> buildAvailabilityVersionRestriction() {
        return new EntityBuilder<AvailabilityVersionRestriction>(create(SwiftEntityDescriptorEnum.AvailabilityVersionRestriction));
    }

    public AvailabilityLabeledArgument createAvailabilityLabeledArgument() {
        return create(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument);
    }

    public AvailabilityLabeledArgument createAvailabilityLabeledArgument(Identifier label, AbstractValue value) {
        return create(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument, label, value);
    }

    public IEntityBuilder<AvailabilityLabeledArgument> buildAvailabilityLabeledArgument() {
        return new EntityBuilder<AvailabilityLabeledArgument>(create(SwiftEntityDescriptorEnum.AvailabilityLabeledArgument));
    }

    public VersionTuple createVersionTuple() {
        return create(SwiftEntityDescriptorEnum.VersionTuple);
    }

    public VersionTuple createVersionTuple(AbstractMajorMinor majorMinor, IntegerLiteral patchVersion) {
        return create(SwiftEntityDescriptorEnum.VersionTuple, majorMinor, patchVersion);
    }

    public IEntityBuilder<VersionTuple> buildVersionTuple() {
        return new EntityBuilder<VersionTuple>(create(SwiftEntityDescriptorEnum.VersionTuple));
    }

    public CaptureSpecifierEnum createCaptureSpecifierEnum() {
        return create(SwiftEntityDescriptorEnum.CaptureSpecifierEnum);
    }

    public CaptureSpecifierEnum createCaptureSpecifierEnum(CaptureSpecifierEnumEnum.Value value) {
        return create(SwiftEntityDescriptorEnum.CaptureSpecifierEnum, value);
    }
}
