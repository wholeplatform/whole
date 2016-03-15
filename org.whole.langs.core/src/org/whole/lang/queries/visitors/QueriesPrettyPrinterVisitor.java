/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.queries.visitors;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class QueriesPrettyPrinterVisitor extends QueriesTraverseAllVisitor {
	protected final IPrettyPrintWriter out;

	public QueriesPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

    @Override
    public void visit(QueryDeclaration entity) {
    	out.printRaw("query ");
    	entity.getName().accept(this);
    	out.printRaw("(");
    	entity.getParameters().accept(this);
    	out.printRaw(") ");
    	entity.getBody().accept(this);
    }

    @Override
    public void visit(Scope entity) {
    	out.printRaw("[");
    	entity.getLocalNames().accept(this);
    	out.printRaw(" | ");
    	entity.getExpression().accept(this);
    	out.printRaw("]");
    }

    @Override
    public void visit(Call entity) {
    	entity.getName().accept(this);
    	out.printRaw("(");
    	entity.getArguments().accept(this);
    	out.printRaw(")");
    }

    @Override
    public void visit(Expressions entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
    }

    @Override
    public void visit(CartesianInsert entity) {
    	out.printRaw("insert ");
    	entity.getPlacement().accept(this);
    	out.printRaw(" ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" x= ");
    	entity.getValuesClause().accept(this);
    }

    @Override
    public void visit(PointwiseInsert entity) {
    	out.printRaw("insert ");
    	entity.getPlacement().accept(this);
    	out.printRaw(" ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" .= ");
    	entity.getValuesClause().accept(this);
    }

    @Override
    public void visit(CartesianUpdate entity) {
    	out.printRaw("update ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" x= ");
    	entity.getValuesClause().accept(this);
    }

    @Override
    public void visit(PointwiseUpdate entity) {
    	out.printRaw("update ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" .= ");
    	entity.getValuesClause().accept(this);
    }

    @Override
    public void visit(Delete entity) {
    	out.printRaw("delete ");
    	entity.getFromClause().accept(this);
    }

    @Override
    public void visit(Select entity) {
    	out.printRaw("select ");
    	entity.getSelectClause().accept(this);
    	out.printRaw(" from ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" where ");
    	entity.getWhereClause().accept(this);
    	out.printRaw(" clear ");
    	entity.getClearClause().accept(this);
    }

    @Override
    public void visit(Do entity) {
    	out.printRaw("do ");
    	entity.getExpression().accept(this);
    }

    @Override
    public void visit(For entity) {
    	out.printRaw("for ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" do ");
    	entity.getExpression().accept(this);
    }

    @Override
    public void visit(If entity) {
    	out.printRaw("if ");
    	entity.getPredicate().accept(this);
    	out.printRaw(" do ");
    	entity.getExpression().accept(this);
    }

    @Override
    public void visit(Path entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			StepExpression e = entity.get(i);
			if (i>0)
				out.printRaw("/");
			e.accept(this);
		}
	}

    @Override
	public void visit(Choose entity) {
    	out.printRaw("choose(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw("; ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
	}

    @Override
	public void visit(Block entity) {
    	out.printRaw("(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw((i<entity.wSize()-1 ? ", " : "; "));
			entity.get(i).accept(this);
		}
		out.printRaw(")");
	}

    @Override
	public void visit(Sequence entity) {
    	out.printRaw("(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
	}

    @Override
    public void visit(CartesianProduct entity) {
    	out.printRaw("(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(" * ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
    }
    @Override
    public void visit(PointwiseProduct entity) {
    	out.printRaw("(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(" .* ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
    }

    @Override
    public void visit(Prune entity) {
    	out.printRaw("[prune]");
    	super.visit(entity);
    }

    @Override
	public void visit(Filter entity) {
		entity.getExpression().accept(this);
		entity.getPredicate().accept(this);
	}

    @Override
	public void visit(AspectStep entity) {
    	out.printRaw("aspect()");
	}

    @Override
	public void visit(AdjacentStep entity) {
    	out.printRaw("adjacent()");
	}

    @Override
	public void visit(ReachableStep entity) {
    	out.printRaw("reachable()");
	}

    @Override
	public void visit(ReachableOrSelfStep entity) {
    	out.printRaw("reachableOrSelf()");
	}

    @Override
	public void visit(InverseAdjacentStep entity) {
    	out.printRaw("inverseAdjacent()");
	}

    @Override
	public void visit(InverseReachableStep entity) {
    	out.printRaw("inverseReachable()");
	}

    @Override
	public void visit(InverseReachableOrSelfStep entity) {
    	out.printRaw("inverseReachableOrSelf()");
	}

    @Override
    public void visit(RootStep entity) {
    	out.printRaw("/");
    }

    @Override
    public void visit(FragmentRootStep entity) {
    	out.printRaw("F/");
    }

    @Override
    public void visit(SelfStep entity) {
    	out.printRaw(".");
    }

    @Override
    public void visit(FeatureStep entity) {
    	out.printRaw(entity.getValue());
    }

    @Override
    public void visit(ChildStep entity) {
    	out.printRaw("child()");
    }

    @Override
    public void visit(DescendantStep entity) {
    	out.printRaw("descendant()");
    }

    @Override
    public void visit(DescendantOrSelfStep entity) {
    	out.printRaw("descendant-or-self()");
    }

    @Override
    public void visit(FollowingSiblingStep entity) {
    	out.printRaw("following-sibling()");
    }
    
    @Override
    public void visit(FollowingStep entity) {
    	out.printRaw("following()");
    }

    @Override
    public void visit(ParentStep entity) {
    	out.printRaw("..");
    }

    @Override
    public void visit(AncestorStep entity) {
    	out.printRaw("ancestor()");
    }
    
    @Override
    public void visit(AncestorOrSelfStep entity) {
    	out.printRaw("ancestor-or-self()");
    }

    @Override
    public void visit(PrecedingSiblingStep entity) {
    	out.printRaw("preceding-sibling()");
    }

    @Override
    public void visit(PrecedingStep entity) {
    	out.printRaw("preceding()");
    }

    @Override
    public void visit(VariableRefStep entity) {
    	out.printRaw(("$"+entity.getValue()));
    }

    @Override
    public void visit(VariableTest entity) {
    	out.printRaw("[as $");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }

    @Override
    public void visit(LanguageTest entity) {
    	out.printRaw("[language() = ");
    	out.printRaw(entity.getValue().toString());
    	out.printRaw("]");
    }
    @Override
    public void visit(KindTest entity) {
    	out.printRaw("[kind() = ");
    	out.printRaw(entity.getValue().toString());
    	out.printRaw("]");
    }

    @Override
    public void visit(StageTest entity) {
    	out.printRaw("[stage() = ");
    	out.printRaw(entity.getValue().toString());
    	out.printRaw("]");
    }
    @Override
    public void visit(StageVariableTest entity) {
    	out.printRaw("[stage as $");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }

    @Override
    public void visit(TypeTest entity) {
    	out.printRaw("[type() = ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(SubtypeTest entity) {
    	out.printRaw("[type() <: ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(SupertypeTest entity) {
    	out.printRaw("[type() :> ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(ExtendedSubtypeTest entity) {
    	out.printRaw("[type() <<: ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(ExtendedSupertypeTest entity) {
    	out.printRaw("[type() :>> ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(AtTypeTest entity) {
    	out.printRaw("[at ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(AtFeatureTest entity) {
    	out.printRaw("[at ");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(AtIndexTest entity) {
    	out.printRaw("[at ");
    	int value = entity.getValue();
    	if (value < 0)
    		out.printRaw("size");
		out.print(value);
    	out.printRaw("]");
    }

    @Override
    public void visit(IndexVariableTest entity) {
    	out.printRaw("[index as $");
    	out.printRaw(entity.getValue());
    	out.printRaw("]");
    }

    @Override
    public void visit(IndexTest entity) {
    	out.printRaw("[");
    	out.print(entity.getIndex().getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(IndexRangeTest entity) {
    	out.printRaw("[");
    	out.print(entity.getStartIndex().getValue());
    	out.printRaw("..");
    	IntLiteral endIndex = entity.getEndIndex();
    	if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IntLiteral, endIndex))
    		out.print(endIndex.getValue());
    	out.printRaw("]");
    }
    @Override
    public void visit(VisitorTest entity) {
    	out.printRaw("[visitor: ");
    	out.printRaw(entity.getValue().toString());
    	out.printRaw("]");
    }
    @Override
    public void visit(ExpressionTest entity) {
    	out.printRaw("[");
    	entity.getExpression().accept(this);
    	out.printRaw("]");
    }
    
    @Override
    public void visit(PointwiseEquals entity) {
    	out.printRaw("[");
    	entity.getPexp1().accept(this);
    	out.printRaw(" .== ");
    	entity.getPexp2().accept(this);
    	out.printRaw("]");
    }

    @Override
    public void visit(Addition entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" + ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(Subtraction entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" - ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(Multiplication entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" * ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(Division entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" / ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(Remainder entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" % ");
    	entity.getExp2().accept(this);
    }

    @Override
    public void visit(Equals entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" == ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(NotEquals entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" != ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(LessOrEquals entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" <= ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(LessThan entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" < ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(GreaterOrEquals entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" >= ");
    	entity.getExp2().accept(this);
    }
    @Override
    public void visit(GreaterThan entity) {
    	entity.getExp1().accept(this);
    	out.printRaw(" > ");
    	entity.getExp2().accept(this);
    }

    @Override
    public void visit(Singleton entity) {
    	out.printRaw(" |");
    	entity.getExpression().accept(this);
    	out.printRaw("| ");
    }

    @Override
    public void visit(And entity) {
		for (int i = 0; i < entity.wSize(); i++) 
			entity.get(i).accept(this);
	}
    @Override
	public void visit(Or entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw("|");
			entity.get(i).accept(this);
		}
	}
    @Override
	public void visit(Not entity) {
    	out.printRaw("!");
		entity.getPredicate().accept(this);
	}
    @Override
    public void visit(ParenthesizedPredicate entity) {
    	out.printRaw("[");
    	super.visit(entity);
    	out.printRaw("]");
    }

    @Override
    public void visit(DistinctTest entity) {
    	out.printRaw("[distinct_");
    	entity.getComparator().accept(this);
    	out.printRaw("]");
    }

    @Override
    public void visit(IdentityComparator entity) {
    	out.printRaw("by ");
    	entity.getIdentity().accept(this);
    }

    @Override
    public void visit(UnionAll entity) {
    	out.printRaw("unionAll(");
    	entity.getExpressions().accept(this);
    	out.printRaw(")");
    }


    @Override
    public void visit(Union entity) {
    	out.printRaw("union_");
    	entity.getComparator().accept(this);
    	out.printRaw("(");
    	entity.getExpressions().accept(this);
    	out.printRaw(")");
    }

    @Override
    public void visit(Intersect entity) {
    	out.printRaw("intercept_");
    	entity.getComparator().accept(this);
    	out.printRaw("(");
    	entity.getExpressions().accept(this);
    	out.printRaw(")");
    }

    @Override
    public void visit(Except entity) {
    	out.printRaw("except_");
    	entity.getComparator().accept(this);
    	out.printRaw("(");
    	entity.getExpressions().accept(this);
    	out.printRaw(")");
    }

    @Override
    public void visit(Every entity) {
    	out.printRaw("[every ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" satisfies ");
    	entity.getWhereClause().accept(this);
    	out.printRaw("]");
    }
    @Override
    public void visit(Some entity) {
    	out.printRaw("[some ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" satisfies ");
    	entity.getWhereClause().accept(this);
    	out.printRaw("]");
    }
    @Override
    public void visit(One entity) {
    	out.printRaw("[one ");
    	entity.getFromClause().accept(this);
    	out.printRaw(" satisfies ");
    	entity.getWhereClause().accept(this);
    	out.printRaw("]");
    }

    @Override
    public void visit(BooleanLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(ByteLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(CharLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(DateLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(DoubleLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(FloatLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(IntLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(LongLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(ShortLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(StringLiteral entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }
    @Override
    public void visit(VoidLiteral entity) {
    	out.printRaw("void");
    }

    @Override
    public void visit(Name entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }

    @Override
    public void visit(Placement entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
    }

    @Override
    public void visit(AllNames entity) {
    	out.printRaw("all names");
    }
    @Override
    public void visit(TemplateNames entity) {
    	out.printRaw("template names");
    }
    @Override
    public void visit(AddNames entity) {
    	entity.getExpression().accept(this);
    	out.printRaw(" + {");
    	entity.getNames().accept(this);
    	out.printRaw("}");
    }
    
    public void visit(RemoveNames entity) {
    	entity.getExpression().accept(this);
    	out.printRaw(" - {");
    	entity.getNames().accept(this);
    	out.printRaw("}");
    };
    
    @Override
    public void visit(Names entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
    }

    @Override
    public void visit(Tuple entity) {
    	out.printRaw("(");
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
    }
}
