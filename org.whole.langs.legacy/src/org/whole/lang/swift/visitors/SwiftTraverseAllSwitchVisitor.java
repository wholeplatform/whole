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

import org.whole.lang.swift.visitors.SwiftIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.swift.model.*;

/**
 *  @generator Whole
 */
public class SwiftTraverseAllSwitchVisitor extends SwiftIdentityUnaryVisitor<IVisitor> {

    public SwiftTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(CodeBlockItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(InOutExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(FunctionCallArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(StringLiteralSegments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ExpressionSegment entity) {
        wGetVisitor1().visit(entity.getDelimiter());
        wGetVisitor1().visit(entity.getExpressions());
    }

    public void visit(TryExpr entity) {
        wGetVisitor1().visit(entity.getQuestionOrExclamationMark());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(DeclNameArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(IdentifierExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(SequenceExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SymbolicReferenceExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(PrefixOperatorExpr entity) {
        wGetVisitor1().visit(entity.getOperatorToken());
        wGetVisitor1().visit(entity.getPostfixExpression());
    }

    public void visit(BinaryOperatorExpr entity) {
        wGetVisitor1().visit(entity.getOperatorToken());
    }

    public void visit(ArrowExpr entity) {
        wGetVisitor1().visit(entity.getThrowsToken());
    }

    public void visit(TupleExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ArrayExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DictionaryExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionCallArgument entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(TupleElement entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(DictionaryElement entity) {
        wGetVisitor1().visit(entity.getKeyExpression());
        wGetVisitor1().visit(entity.getValueExpression());
    }

    public void visit(TernaryExpr entity) {
        wGetVisitor1().visit(entity.getConditionExpression());
        wGetVisitor1().visit(entity.getFirstChoice());
        wGetVisitor1().visit(entity.getSecondChoice());
    }

    public void visit(MemberAccessExpr entity) {
        wGetVisitor1().visit(entity.getBase());
        wGetVisitor1().visit(entity.getDot());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(IsExpr entity) {
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(AsExpr entity) {
        wGetVisitor1().visit(entity.getQuestionOrExclamationMark());
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(TypeExpr entity) {
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(ClosureCaptureItem entity) {
        wGetVisitor1().visit(entity.getSpecifier());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ClosureCaptureItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ClosureParamList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ClosureSignature entity) {
        wGetVisitor1().visit(entity.getCapture());
        wGetVisitor1().visit(entity.getInput());
        wGetVisitor1().visit(entity.getThrowsTok());
        wGetVisitor1().visit(entity.getOutput());
    }

    public void visit(ClosureExpr entity) {
        wGetVisitor1().visit(entity.getSignature());
        wGetVisitor1().visit(entity.getStatements());
    }

    public void visit(UnresolvedPatternExpr entity) {
        wGetVisitor1().visit(entity.getPattern());
    }

    public void visit(FunctionCallExpr entity) {
        wGetVisitor1().visit(entity.getCalledExpression());
        wGetVisitor1().visit(entity.getArgumentList());
        wGetVisitor1().visit(entity.getTrailingClosure());
    }

    public void visit(SubscriptExpr entity) {
        wGetVisitor1().visit(entity.getCalledExpression());
        wGetVisitor1().visit(entity.getArgumentList());
        wGetVisitor1().visit(entity.getTrailingClosure());
    }

    public void visit(OptionalChainingExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ForcedValueExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(PostfixUnaryExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getOperatorToken());
    }

    public void visit(SpecializeExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(StringLiteralExpr entity) {
        wGetVisitor1().visit(entity.getOpenDelimiter());
        wGetVisitor1().visit(entity.getOpenQuote());
        wGetVisitor1().visit(entity.getSegments());
    }

    public void visit(KeyPathExpr entity) {
        wGetVisitor1().visit(entity.getRootExpr());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ObjcKeyPathExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ObjcSelectorExpr entity) {
        wGetVisitor1().visit(entity.getKind());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(EditorPlaceholderExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
    }

    public void visit(ObjectLiteralExpr entity) {
        wGetVisitor1().visit(entity.getPoundIdentifier());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(TypealiasDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getGenericWhereClause());
    }

    public void visit(AssociatedtypeDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getGenericWhereClause());
    }

    public void visit(FunctionParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionSignature entity) {
        wGetVisitor1().visit(entity.getInput());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getOutput());
    }

    public void visit(IfConfigClause entity) {
        wGetVisitor1().visit(entity.getPoundKeyword());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(SwitchCaseList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MemberDeclList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(IfConfigDecl entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PoundErrorDecl entity) {
        wGetVisitor1().visit(entity.getMessage());
    }

    public void visit(PoundWarningDecl entity) {
        wGetVisitor1().visit(entity.getMessage());
    }

    public void visit(PoundSourceLocation entity) {
        wGetVisitor1().visit(entity.getArgs());
    }

    public void visit(PoundSourceLocationArgs entity) {
        wGetVisitor1().visit(entity.getFileArgLabel());
        wGetVisitor1().visit(entity.getFileName());
        wGetVisitor1().visit(entity.getLineArgLabel());
        wGetVisitor1().visit(entity.getLineNumber());
    }

    public void visit(DeclModifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDetail());
    }

    public void visit(InheritedTypeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ClassDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(StructDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(ProtocolDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(ExtensionDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getExtendedType());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(SourceFile entity) {
        wGetVisitor1().visit(entity.getStatements());
    }

    public void visit(FunctionParameter entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getFirstName());
        wGetVisitor1().visit(entity.getSecondName());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getEllipsis());
        wGetVisitor1().visit(entity.getDefaultArgument());
    }

    public void visit(ModifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getFunctionIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getSignature());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(InitializerDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getOptionalMark());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(DeinitializerDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SubscriptDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getIndices());
        wGetVisitor1().visit(entity.getResult());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getAccessor());
    }

    public void visit(AccessorBlock entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AccessLevelModifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getModifier());
    }

    public void visit(AccessPath entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ImportDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getImportKind());
        wGetVisitor1().visit(entity.getPath());
    }

    public void visit(AccessorDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifier());
        wGetVisitor1().visit(entity.getAccessorKind());
        wGetVisitor1().visit(entity.getParameter());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(PatternBinding entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getAccessor());
    }

    public void visit(PatternBindingList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(VariableDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(EnumCaseElement entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getAssociatedValue());
        wGetVisitor1().visit(entity.getRawValue());
    }

    public void visit(EnumCaseElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EnumCaseDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(EnumDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameters());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(OperatorDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getOperatorIdentifier());
        wGetVisitor1().visit(entity.getOperatorPrecedenceAndTypes());
    }

    public void visit(IdentifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PrecedenceGroupDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGroupAttributes());
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PrecedenceGroupRelation entity) {
        wGetVisitor1().visit(entity.getHigherThanOrLowerThan());
        wGetVisitor1().visit(entity.getOtherNames());
    }

    public void visit(PrecedenceGroupAssignment entity) {
        wGetVisitor1().visit(entity.getAssignmentKeyword());
        wGetVisitor1().visit(entity.getFlag());
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        wGetVisitor1().visit(entity.getAssociativityKeyword());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(PrecedenceGroupNameList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CustomAttribute entity) {
        wGetVisitor1().visit(entity.getAttributeName());
        wGetVisitor1().visit(entity.getArgumentList());
    }

    public void visit(Attribute entity) {
        wGetVisitor1().visit(entity.getAttributeName());
        wGetVisitor1().visit(entity.getArgument());
    }

    public void visit(AvailabilitySpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SpecializeAttributeSpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ObjCSelector entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ImplementsAttributeArguments entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getDeclBaseName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(NamedAttributeStringArgument entity) {
        wGetVisitor1().visit(entity.getNameTok());
        wGetVisitor1().visit(entity.getStringOrDeclname());
    }

    public void visit(AttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(LabeledSpecializeEntry entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(DeclName entity) {
        wGetVisitor1().visit(entity.getDeclBaseName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(ContinueStmt entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(WhileStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(DeferStmt entity) {
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SwitchCase entity) {
        wGetVisitor1().visit(entity.getUnknownAttr());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getStatements());
    }

    public void visit(RepeatWhileStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getCondition());
    }

    public void visit(GuardStmt entity) {
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(ForInStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getCaseKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getSequenceExpr());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SwitchStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getCases());
    }

    public void visit(CatchClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DoStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getCatchClauses());
    }

    public void visit(ReturnStmt entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(YieldStmt entity) {
        wGetVisitor1().visit(entity.getYields());
    }

    public void visit(YieldList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BreakStmt entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(AvailabilityCondition entity) {
        wGetVisitor1().visit(entity.getAvailabilitySpec());
    }

    public void visit(MatchingPatternCondition entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(OptionalBindingCondition entity) {
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(ConditionElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ThrowStmt entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(IfStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getElseBody());
    }

    public void visit(SwitchCaseLabel entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CaseItem entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getWhereClause());
    }

    public void visit(CatchClause entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(PoundAssertStmt entity) {
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getMessage());
    }

    public void visit(GenericRequirementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SameTypeRequirement entity) {
        wGetVisitor1().visit(entity.getLeftTypeIdentifier());
        wGetVisitor1().visit(entity.getEqualityToken());
        wGetVisitor1().visit(entity.getRightTypeIdentifier());
    }

    public void visit(ConformanceRequirement entity) {
        wGetVisitor1().visit(entity.getLeftTypeIdentifier());
        wGetVisitor1().visit(entity.getRightTypeIdentifier());
    }

    public void visit(GenericParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(GenericParameter entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getInheritedType());
    }

    public void visit(SimpleTypeIdentifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(MemberTypeIdentifier entity) {
        wGetVisitor1().visit(entity.getBaseType());
        wGetVisitor1().visit(entity.getPeriod());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(ArrayType entity) {
        wGetVisitor1().visit(entity.getElementType());
    }

    public void visit(DictionaryType entity) {
        wGetVisitor1().visit(entity.getKeyType());
        wGetVisitor1().visit(entity.getValueType());
    }

    public void visit(MetatypeType entity) {
        wGetVisitor1().visit(entity.getBaseType());
        wGetVisitor1().visit(entity.getTypeOrProtocol());
    }

    public void visit(OptionalType entity) {
        wGetVisitor1().visit(entity.getWrappedType());
    }

    public void visit(SomeType entity) {
        wGetVisitor1().visit(entity.getSomeSpecifier());
        wGetVisitor1().visit(entity.getBaseType());
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        wGetVisitor1().visit(entity.getWrappedType());
    }

    public void visit(CompositionTypeElement entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getAmpersand());
    }

    public void visit(CompositionType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TupleTypeElement entity) {
        wGetVisitor1().visit(entity.getInOut());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getSecondName());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getEllipsis());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(TupleTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TupleType entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(FunctionType entity) {
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getReturnType());
    }

    public void visit(AttributedType entity) {
        wGetVisitor1().visit(entity.getSpecifier());
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getBaseType());
    }

    public void visit(GenericArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EnumCasePattern entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getCaseName());
        wGetVisitor1().visit(entity.getAssociatedTuple());
    }

    public void visit(IsTypePattern entity) {
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(OptionalPattern entity) {
        wGetVisitor1().visit(entity.getSubPattern());
    }

    public void visit(IdentifierPattern entity) {
        wGetVisitor1().visit(entity.getPatternIdentifier());
    }

    public void visit(AsTypePattern entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(WildcardPattern entity) {
        wGetVisitor1().visit(entity.getTypeAnnotation());
    }

    public void visit(TuplePatternElement entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getPattern());
    }

    public void visit(ExpressionPattern entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(TuplePatternElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ValueBindingPattern entity) {
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getValuePattern());
    }

    public void visit(AvailabilityVersionRestriction entity) {
        wGetVisitor1().visit(entity.getPlatform());
        wGetVisitor1().visit(entity.getVersion());
    }

    public void visit(AvailabilityLabeledArgument entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(VersionTuple entity) {
        wGetVisitor1().visit(entity.getMajorMinor());
        wGetVisitor1().visit(entity.getPatchVersion());
    }
}
