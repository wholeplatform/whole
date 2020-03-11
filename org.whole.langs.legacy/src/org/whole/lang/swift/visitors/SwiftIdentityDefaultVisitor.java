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
package org.whole.lang.swift.visitors;

import org.whole.lang.swift.model.*;

/**
 *  @generator Whole
 */
public class SwiftIdentityDefaultVisitor extends SwiftIdentityVisitor {

    public void visit(ISwiftEntity entity) {
    }

    public void visit(AbstractItem entity) {
    }

    public void visit(Decl entity) {
        visit((AbstractItem) entity);
    }

    public void visit(Expr entity) {
        visit((AbstractItem) entity);
        visit((AbstractYields) entity);
        visit((AbstractCondition) entity);
    }

    public void visit(AbstractYields entity) {
    }

    public void visit(AbstractCondition entity) {
    }

    public void visit(Stmt entity) {
        visit((AbstractItem) entity);
    }

    public void visit(BooleanLiteral entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(AbstractArgument entity) {
    }

    public void visit(IntegerLiteral entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
        visit((AbstractValue) entity);
        visit((AbstractMajorMinor) entity);
        visit((Expr) entity);
    }

    public void visit(AbstractValue entity) {
    }

    public void visit(AbstractMajorMinor entity) {
    }

    public void visit(FloatingLiteral entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractValue) entity);
        visit((AbstractMajorMinor) entity);
        visit((Expr) entity);
    }

    public void visit(StringLiteral entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
        visit((AbstractValue) entity);
        visit((AbstractStringOrDeclname) entity);
        visit((AbstractSegment) entity);
    }

    public void visit(AbstractStringOrDeclname entity) {
    }

    public void visit(AbstractSegment entity) {
    }

    public void visit(AbstractIdentifier entity) {
        visit((Expr) entity);
        visit((AbstractRootExpr) entity);
    }

    public void visit(Identifier entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractIdentifier) entity);
        visit((AbstractName) entity);
        visit((AbstractFirstName) entity);
        visit((AbstractSecondName) entity);
        visit((AbstractFunctionIdentifier) entity);
        visit((AbstractArgument) entity);
        visit((AbstractDeclBaseName) entity);
        visit((AbstractPatternIdentifier) entity);
        visit((AbstractEntry) entity);
        visit((Type) entity);
    }

    public void visit(AbstractName entity) {
    }

    public void visit(AbstractFirstName entity) {
    }

    public void visit(AbstractSecondName entity) {
    }

    public void visit(AbstractFunctionIdentifier entity) {
    }

    public void visit(AbstractDeclBaseName entity) {
    }

    public void visit(AbstractPatternIdentifier entity) {
    }

    public void visit(AbstractEntry entity) {
    }

    public void visit(Type entity) {
    }

    public void visit(BinaryOperator entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractIdentifier) entity);
        visit((AbstractOperatorToken) entity);
        visit((AbstractFunctionIdentifier) entity);
        visit((AbstractOperatorIdentifier) entity);
        visit((AbstractValue) entity);
        visit((AbstractEqualityToken) entity);
        visit((AbstractEntry) entity);
    }

    public void visit(AbstractOperatorToken entity) {
    }

    public void visit(AbstractOperatorIdentifier entity) {
    }

    public void visit(AbstractEqualityToken entity) {
    }

    public void visit(PostfixOperator entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractFunctionIdentifier) entity);
        visit((AbstractOperatorIdentifier) entity);
    }

    public void visit(PrefixOperator entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractFunctionIdentifier) entity);
        visit((AbstractOperatorIdentifier) entity);
        visit((AbstractDeclBaseName) entity);
    }

    public void visit(DollarIdentifier entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractIdentifier) entity);
    }

    public void visit(RawStringDelimiter entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AbstractElements entity) {
    }

    public void visit(CodeBlockItemList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractElements) entity);
        visit((AbstractAccessor) entity);
        visit((AbstractElseBody) entity);
    }

    public void visit(AbstractAccessor entity) {
    }

    public void visit(AbstractElseBody entity) {
    }

    public void visit(InOutExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundColumnExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(StringLiteralSegments entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ExpressionSegment entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractSegment) entity);
    }

    public void visit(TryExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(QuestionOrExclamationMarkEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(DeclNameArgumentList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(IdentifierExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
        visit((AbstractRootExpr) entity);
    }

    public void visit(AbstractRootExpr entity) {
    }

    public void visit(IdentifierEnum entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractIdentifier) entity);
    }

    public void visit(SuperRefExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(NilLiteralExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(AssignmentExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SequenceExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundLineExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundFileExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundFunctionExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ArrowExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(Throws entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TupleExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ArrayExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DictionaryExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallArgument entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TupleElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(DictionaryElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TernaryExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(MemberAccessExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DotEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(IsExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(AsExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(TypeExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ClosureCaptureItem entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(WildcardMarker entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractName) entity);
        visit((AbstractFirstName) entity);
        visit((AbstractSecondName) entity);
    }

    public void visit(AbstractInput entity) {
    }

    public void visit(ClosureParamList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractInput) entity);
    }

    public void visit(ClosureSignature entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ClosureExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SubscriptExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(OptionalChainingExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ForcedValueExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SpecializeExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
        visit((AbstractRootExpr) entity);
    }

    public void visit(StringLiteralExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(OpenQuoteEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(KeyPathExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(KindValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        visit((ISwiftEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundIdentifierEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TypealiasDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(FunctionParameterList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractInput) entity);
    }

    public void visit(FunctionSignature entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ThrowsOrRethrowsKeywordEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(IfConfigClause entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PoundKeywordEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(SwitchCaseList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractElements) entity);
    }

    public void visit(MemberDeclList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractElements) entity);
    }

    public void visit(IfConfigDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
        visit((AbstractSwitchCase) entity);
    }

    public void visit(AbstractSwitchCase entity) {
    }

    public void visit(PoundErrorDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundWarningDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundSourceLocation entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(DeclModifier entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(NameValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(InheritedTypeList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ClassDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(StructDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(ProtocolDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(ExtensionDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(SourceFile entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(FunctionParameter entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(Ellipsis entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ModifierList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(FunctionDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(InitializerDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(OptionalMarkEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(DeinitializerDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(SubscriptDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AccessorBlock entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractAccessor) entity);
    }

    public void visit(AccessLevelModifier entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AccessPath entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ImportDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(ImportKindEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AccessorDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AccessorKindValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PatternBinding entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PatternBindingList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(VariableDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(LetOrVarKeywordEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(EnumCaseElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(EnumCaseElementList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(EnumCaseDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(EnumDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(OperatorDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(IdentifierList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        visit((ISwiftEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AbstractPrecedenceGroupAttribute entity) {
    }

    public void visit(PrecedenceGroupRelation entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(HigherThanOrLowerThanValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(FlagEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ValueValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AbstractAttribute entity) {
    }

    public void visit(CustomAttribute entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractAttribute) entity);
    }

    public void visit(Attribute entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractAttribute) entity);
    }

    public void visit(AvailabilitySpecList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
    }

    public void visit(ObjCSelector entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractArgument) entity);
    }

    public void visit(AttributeList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(AbstractSpecializeAttribute entity) {
    }

    public void visit(LabeledSpecializeEntry entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractSpecializeAttribute) entity);
    }

    public void visit(DeclName entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractStringOrDeclname) entity);
    }

    public void visit(ContinueStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(WhileStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(DeferStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(SwitchCase entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractSwitchCase) entity);
    }

    public void visit(RepeatWhileStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(GuardStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(ForInStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(Case entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(SwitchStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(CatchClauseList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(DoStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(ReturnStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(YieldStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(YieldList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractYields) entity);
    }

    public void visit(FallthroughStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(BreakStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(AvailabilityCondition entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractCondition) entity);
    }

    public void visit(MatchingPatternCondition entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractCondition) entity);
    }

    public void visit(OptionalBindingCondition entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractCondition) entity);
    }

    public void visit(ConditionElementList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ThrowStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(IfStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
        visit((AbstractElseBody) entity);
    }

    public void visit(AbstractLabel entity) {
    }

    public void visit(SwitchDefaultLabel entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractLabel) entity);
    }

    public void visit(SwitchCaseLabel entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractLabel) entity);
    }

    public void visit(CaseItem entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(CatchClause entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(PoundAssertStmt entity) {
        visit((ISwiftEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(GenericRequirementList entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractSpecializeAttribute) entity);
    }

    public void visit(AbstractGenericRequirement entity) {
    }

    public void visit(SameTypeRequirement entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractGenericRequirement) entity);
    }

    public void visit(ConformanceRequirement entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractGenericRequirement) entity);
    }

    public void visit(GenericParameterList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(GenericParameter entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(NameEnum entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractName) entity);
        visit((Type) entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(PeriodEnum entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ClassRestrictionType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(ArrayType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(DictionaryType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(MetatypeType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(TypeOrProtocolValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(OptionalType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(SomeType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(CompositionTypeElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(Ampersand entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(CompositionType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(TupleTypeElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(Inout entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TupleTypeElementList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(TupleType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(FunctionType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(AttributedType entity) {
        visit((ISwiftEntity) entity);
        visit((Type) entity);
    }

    public void visit(SpecifierValue entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(GenericArgumentList entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(Pattern entity) {
    }

    public void visit(EnumCasePattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(IsTypePattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(OptionalPattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(IdentifierPattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(SelfMarker entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractPatternIdentifier) entity);
    }

    public void visit(AsTypePattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(WildcardPattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(TuplePatternElement entity) {
        visit((ISwiftEntity) entity);
    }

    public void visit(ExpressionPattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(TuplePatternElementList entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(ValueBindingPattern entity) {
        visit((ISwiftEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractEntry) entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractEntry) entity);
    }

    public void visit(VersionTuple entity) {
        visit((ISwiftEntity) entity);
        visit((AbstractValue) entity);
    }

    public void visit(CaptureSpecifierEnum entity) {
        visit((ISwiftEntity) entity);
    }
}
