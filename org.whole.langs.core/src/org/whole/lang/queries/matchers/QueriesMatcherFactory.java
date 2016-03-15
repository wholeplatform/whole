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
package org.whole.lang.queries.matchers;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class QueriesMatcherFactory {
	public static IVisitor pointwiseEquals(IEntityIterator<?> exp1, IEntityIterator<?> exp2) {
		return new PointwiseEqualsVisitor(exp1, exp2);
	}
	public static class PointwiseEqualsVisitor extends AbstractVisitor {
		private IEntityIterator<?> exp1, exp2;

		public PointwiseEqualsVisitor(IEntityIterator<?> exp1, IEntityIterator<?> exp2) {
			this.exp1 = exp1;
			this.exp2 = exp2;
		}

		public IVisitor clone(ICloneContext cc) {
			PointwiseEqualsVisitor visitor = (PointwiseEqualsVisitor) super.clone(cc);
			visitor.exp1 = cc.clone(exp1);
			visitor.exp2 = cc.clone(exp2);
			return visitor;
		}

		public void visit(IEntity entity) {
			exp1.reset(entity);
			exp2.reset(entity);

			for (IEntity e1 : exp1)
				if (!exp2.hasNext() || !e1.wEquals(exp2.next()))
					throw new VisitException();
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			exp1.setBindings(bm);
			exp2.setBindings(bm);
		}
		
		public void toString(StringBuilder sb) {
			sb.append("pointwiseEquals(");
			sb.append(exp1);//TODO startOf
			sb.append(",");
			sb.append(exp2);//TODO startOf
			sb.append(")");
		}
	}

	public static IVisitor one(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
		return new OneVisitor(fromClause, satisfiesClause);
	}
	public static class OneVisitor extends AbstractVisitor {
		private IEntityIterator<?> fromClause;
		private IVisitor satisfiesClause;

		public OneVisitor(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
			this.fromClause = fromClause;
			this.satisfiesClause = satisfiesClause;
		}

		public IVisitor clone(ICloneContext cc) {
			OneVisitor visitor = (OneVisitor) super.clone(cc);
			visitor.fromClause = cc.clone(fromClause);
			visitor.satisfiesClause = cc.clone(satisfiesClause);
			return visitor;
		}

		public void visit(IEntity entity) {
			fromClause.reset(entity);

			IBindingScope laScope = null;
			for (IEntity e : fromClause) {
				try {
					satisfiesClause.visit(e);						
				} catch (VisitException ve) {
					continue;
				}
				if (laScope != null)
					throw new VisitException();
				else
					laScope = fromClause.lookaheadScope().clone();
			}

			if (laScope == null)
				throw new VisitException();
			
			getBindings().wAddAll(laScope);
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			fromClause.setBindings(bm);
			satisfiesClause.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("one(");
			sb.append(fromClause);//TODO startOf
			sb.append(" satisfies ");
			sb.append(satisfiesClause);//TODO startOf
			sb.append(")");
		}
	}

	public static IVisitor some(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
		return new SomeVisitor(fromClause, satisfiesClause);
	}
	public static class SomeVisitor extends AbstractVisitor {
		private IEntityIterator<?> fromClause;
		private IVisitor satisfiesClause;

		public SomeVisitor(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
			this.fromClause = fromClause;
			this.satisfiesClause = satisfiesClause;
		}

		public IVisitor clone(ICloneContext cc) {
			SomeVisitor visitor = (SomeVisitor) super.clone(cc);
			visitor.fromClause = cc.clone(fromClause);
			visitor.satisfiesClause = cc.clone(satisfiesClause);
			return visitor;
		}

		public void visit(IEntity entity) {
			fromClause.reset(entity);

			for (IEntity e : fromClause)
				try {
					satisfiesClause.visit(e);
					return;
				} catch (VisitException ve) {
				}

			throw new VisitException();
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			fromClause.setBindings(bm);
			satisfiesClause.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("some(");
			sb.append(fromClause);//TODO startOf
			sb.append(" satisfies ");
			sb.append(satisfiesClause);//TODO startOf
			sb.append(")");
		}
	}

	public static IVisitor all(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
		return new AllVisitor(fromClause, satisfiesClause);
	}
	public static class AllVisitor extends AbstractVisitor {
		private IEntityIterator<?> fromClause;
		private IVisitor satisfiesClause;

		public AllVisitor(IEntityIterator<?> fromClause, IVisitor satisfiesClause) {
			this.fromClause = fromClause;
			this.satisfiesClause = satisfiesClause;
		}

		public IVisitor clone(ICloneContext cc) {
			AllVisitor visitor = (AllVisitor) super.clone(cc);
			visitor.fromClause = cc.clone(fromClause);
			visitor.satisfiesClause = cc.clone(satisfiesClause);
			return visitor;
		}

		public void visit(IEntity entity) {
			fromClause.reset(entity);

			for (IEntity e : fromClause)
				satisfiesClause.visit(e);
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			fromClause.setBindings(bm);
			satisfiesClause.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("all(");
			sb.append(fromClause);//TODO startOf
			sb.append(" satisfies ");
			sb.append(satisfiesClause);//TODO startOf
			sb.append(")");
		}
	}
}
