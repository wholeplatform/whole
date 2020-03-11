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
package org.whole.lang.swiftsyntax.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SwiftSyntaxForwardStrategyVisitor extends GenericForwardStrategyVisitor<ISwiftSyntaxVisitor> implements ISwiftSyntaxVisitor {

    public SwiftSyntaxForwardStrategyVisitor() {
        this(new SwiftSyntaxIdentityVisitor());
    }

    public SwiftSyntaxForwardStrategyVisitor(ISwiftSyntaxVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ISwiftSyntaxEntity) entity).accept(this);
    }

    public void visit(Token entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnknownDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnknownExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnknownPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnknownStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnknownType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CodeBlockItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CodeBlockItemList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CodeBlock entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InOutExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundColumnExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteralSegments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclNameArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclNameArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclNameArguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperRefExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NilLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssignmentExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SequenceExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExprList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundLineExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundFileExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundFunctionExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrowExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FloatLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntegerLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TernaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberAccessExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AsExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureCaptureItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureCaptureSignature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureParam entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureParamList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureSignature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubscriptExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalChainingExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForcedValueExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SpecializeExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringSegment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionSegment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KeyPathExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcNamePiece entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeInitializerClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypealiasDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionParameterList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ParameterClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReturnClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionSignature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfConfigClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfConfigClauseList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfConfigDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundErrorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundWarningDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundSourceLocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclModifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InheritedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InheritedTypeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeInheritanceClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StructDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ProtocolDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtensionDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberDeclBlock entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberDeclList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberDeclListItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SourceFile entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InitializerClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ModifierList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InitializerDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeinitializerDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubscriptDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessLevelModifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessPathComponent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessPath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorBlock entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternBinding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternBindingList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OperatorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OperatorPrecedenceAndTypes entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupRelation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupNameElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TokenList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CustomAttribute entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Attribute entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AttributeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LabeledSpecializeEntry entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjCSelectorPiece entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjCSelector entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ContinueStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhileStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeferStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCaseList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RepeatWhileStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GuardStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhereClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForInStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClauseList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReturnStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(YieldStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(YieldList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FallthroughStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BreakStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CaseItemList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MatchingPatternCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalBindingCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThrowStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchDefaultLabel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CaseItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCaseLabel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundAssertStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericWhereClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericRequirementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SameTypeRequirement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericParameterList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericParameterClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConformanceRequirement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassRestrictionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MetatypeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SomeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositionTypeElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositionTypeElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleTypeElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleTypeElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AttributedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericArgumentClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeAnnotation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCasePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsTypePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AsTypePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TuplePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WildcardPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TuplePatternElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TuplePatternElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ValueBindingPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilitySpecList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VersionTuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TokenKind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Text entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Trivia entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TriviaPiece entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SourcePresence entity) {
        wGetStrategy().visit(entity);
    }
}
