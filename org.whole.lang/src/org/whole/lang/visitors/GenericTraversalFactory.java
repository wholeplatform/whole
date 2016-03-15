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
package org.whole.lang.visitors;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.events.ReplaceChildTracker;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;


/**
 * @author Riccardo Solmi
 */
public class GenericTraversalFactory {
	public static final GenericTraversalFactory instance = new GenericTraversalFactory();
	protected GenericTraversalFactory() {
	}

	public IVisitor failure() {
		return new GenericFailureVisitor();
	}

	public IVisitor identity() {
		return new GenericIdentityVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new GenericSequenceVisitor(visitor1, visitor2);
	}
	public IBinaryVisitor concurrentSequence(IVisitor visitor1, IVisitor visitor2) {
		return new GenericConcurrentSequenceVisitor(visitor1, visitor2);
	}
	public IBinaryVisitor ifThen(IVisitor condition, IVisitor success) {
		return new GenericIfThenVisitor(condition, success);
	}
	public IBinaryVisitor ifElse(IVisitor visitor1, IVisitor visitor2) {
		return new GenericIfElseVisitor(visitor1, visitor2);
	}
	public ITernaryVisitor ifThenElse(IVisitor condition, IVisitor success, IVisitor failure) {
		return new GenericIfThenElseVisitor(condition, success, failure);
	}

	public IUnaryVisitor not(IVisitor visitor) {
		return new GenericNotVisitor(visitor);
	}
	
	public IVisitor one(IVisitor... visitors) {
		return new AbstractQuantifiedVisitor(visitors) {
			public void visit(IEntity entity) {
				for (int i=0; i<visitorsLength(); i++)
			    	try {
			    		getVisitor(i).visit(entity);
			    		return;
			    	} catch (VisitException e) {
			    	}
				throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("one");
				super.toString(sb);
			}
		};
	}
	public IVisitor some(IVisitor... visitors) {
		return new AbstractQuantifiedVisitor(visitors) {
			public void visit(IEntity entity) {
		    	boolean fail = true;
				for (int i=0; i<visitorsLength(); i++)
			    	try {
			    		getVisitor(i).visit(entity);
			    		fail = false;
			    	} catch (VisitException e) {
			    	}
			    if (fail)
				    throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("some");
				super.toString(sb);
			}
		};
	}
	public IVisitor all(IVisitor... visitors) {
		return new AbstractQuantifiedVisitor(visitors) {
			public void visit(IEntity entity) {
				for (int i=0; i<visitorsLength(); i++)
					getVisitor(i).visit(entity);
			}

			public void toString(StringBuilder sb) {
				sb.append("all");
				super.toString(sb);
			}
		};
	}
	public IVisitor concurrentSome(IVisitor... visitors) {
		return new AbstractQuantifiedVisitor(visitors) {
			public void visit(IEntity entity) {
		    	ReplaceChildTracker tracker = new ReplaceChildTracker(entity);

		    	boolean fail = true;
				for (int i=0; i<visitorsLength(); i++)
			    	try {
			    		getVisitor(i).visit(tracker.entity());
			    		fail = false;
			    	} catch (VisitException e) {
			    	}

				tracker.dispose();

			    if (fail)
				    throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("concurrentSome");
				super.toString(sb);
			}
		};
	}
	public IVisitor concurrentAll(IVisitor... visitors) {
		return new AbstractQuantifiedVisitor(visitors) {
			public void visit(IEntity entity) {
		    	ReplaceChildTracker tracker = new ReplaceChildTracker(entity);
		    	try {
					for (int i=0; i<visitorsLength(); i++)
						getVisitor(i).visit(tracker.entity());
		    	} finally {
		    		tracker.dispose();
		    	}
			}

			public void toString(StringBuilder sb) {
				sb.append("concurrentAll");
				super.toString(sb);
			}
		};
	}

	public IUnaryVisitor traverseOne(IVisitor visitor, final int startIndex) {
		return new AbstractUnaryVisitor<IVisitor>(visitor) {
			public void visit(IEntity entity) {
				for (int i=startIndex; i<entity.wSize(); i++)
			    	try {
			    		wGetVisitor1().visit(entity.wGet(i));
			    		return;
			    	} catch (VisitException e) {
			    	}
				throw new VisitException();
			}
		};
	}
	public IUnaryVisitor traverseOne(IVisitor visitor, boolean includeAdjacents) {
		return includeAdjacents ?
				new GenericTraverseOneVisitor(visitor) :
				new GenericTraverseOneVisitor(visitor) {
					protected final int endIndex(IEntity entity) {
						return entity.wSize();
					}
				};
	}
	public IUnaryVisitor traverseOneAdjacent(IVisitor visitor) {
		return new GenericTraverseOneVisitor(visitor) {
			protected final int startIndex(IEntity entity) {
				return entity.wSize();
			}
		};
	}
	public IUnaryVisitor traverseSome(IVisitor visitor, boolean includeAdjacents) {
		return includeAdjacents ?
				new GenericTraverseSomeVisitor(visitor) :
				new GenericTraverseSomeVisitor(visitor) {
					protected final int endIndex(IEntity entity) {
						return entity.wSize();
					}
				};
	}
	public IUnaryVisitor traverseSomeAdjacents(IVisitor visitor) {
		return new GenericTraverseSomeVisitor(visitor) {
			protected final int startIndex(IEntity entity) {
				return entity.wSize();
			}
		};
	}
	public IUnaryVisitor traverseAll(IVisitor visitor, boolean includeAdjacents) {
		return includeAdjacents ? traverseAll(visitor) : traverseAllChildren(visitor);
	}
	public IUnaryVisitor traverseAll(IVisitor visitor) {
		return new GenericTraverseAllVisitor(visitor);
	}
	public IUnaryVisitor traverseAllChildren(IVisitor visitor) {
		return new GenericTraverseAllVisitor(visitor) {
			protected final int endIndex(IEntity entity) {
				return entity.wSize();
			}
		};
	}
	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor) {
		return new GenericTraverseAllVisitor(visitor) {
			protected final int startIndex(IEntity entity) {
				return entity.wSize();
			}
		};
	}
	public IUnaryVisitor traverseParent(IVisitor visitor) {
		return new GenericTraverseParentVisitor(visitor);
	}
	//TODO ? add one, some, all variants
	public IUnaryVisitor traverseCollection(IVisitor condition, Collection collection) {
		return new GenericTraverseCollectionVisitor(condition, collection);
	}

	public IUnaryVisitor breadthFirst(IVisitor visitor) {
		IBinaryVisitor seq = sequence(visitor, null);
	    seq.wSetVisitor2(new GenericBreadthFirstTraversalVisitor(seq));
	    return seq;
	}

	public IUnaryVisitor collect(IVisitor condition, Collection collection) {
		return new GenericCollectVisitor(condition, collection);
	}
	public IVisitor distinct(Set<IEntity> visitSet) {
		return new GenericDistinctVisitor(visitSet);
	}
	public IVisitor distinct() {
		return distinct(new HashSet<IEntity>());
	}

	public IDynamicVariantVisitor dynamicVisitor() {
		return new DynamicCrossLanguageVariantVisitor();
	}
	public IDynamicVariantVisitor dynamicVisitor(ILanguageKit languageKit) {
		return new DynamicMonoLanguageVariantVisitor(languageKit);
	}


//*** derived ***

	//includes self
	public IBinaryVisitor ancestors(IVisitor visitor) {
		IBinaryVisitor result = sequence(visitor, null);
		result.wSetVisitor2(traverseParent(result));
	    return result;
	}
	public IBinaryVisitor ancestorsWhile(IVisitor visitor) {
		IBinaryVisitor result = ifThen(visitor, null);
		result.wSetVisitor2(traverseParent(result));
	    return result;
	}
	public IBinaryVisitor ancestorsUntil(IVisitor visitor) {
		IBinaryVisitor result = ifElse(visitor, null);
		result.wSetVisitor2(traverseParent(result));
	    return result;
	}

	public IUnaryVisitor tryPrune(IVisitor visitor) {
		return ifElse(visitor, identity());
	}
	public IUnaryVisitor topDown(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor sequence = sequence(visitor, null);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor2(traverseAll(result, includeAdjacents));
	    return result;
	}
	public IUnaryVisitor concurrentTopDown(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor sequence = concurrentSequence(visitor, null);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor2(traverseAll(result, includeAdjacents));
	    return result;
	}
	public IUnaryVisitor topDownWhile(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor result = ifThen(
				includeAdjacents ? sequence(distinct(), visitor) : visitor, null);
		result.wSetVisitor2(traverseAll(result, includeAdjacents));
	    return result;
	}
	public IUnaryVisitor topDownUntil(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor ifElse = ifElse(visitor, null);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), ifElse) : ifElse;
		ifElse.wSetVisitor2(traverseAll(result, includeAdjacents));
	    return result;
	}
	public IBinaryVisitor bottomUp(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor sequence = sequence(null, visitor);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor1(traverseAll(result, includeAdjacents));
	    return result;
	}
	public IBinaryVisitor downUp(IVisitor vBefore, IVisitor vAfter, boolean includeAdjacents) {
		IBinaryVisitor sequence = sequence(vBefore, null);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor2(sequence(traverseAll(result, includeAdjacents), vAfter));
		return result;
	}
	public IBinaryVisitor downUpWhile(IVisitor vBefore, IVisitor vAfter, boolean includeAdjacents) {
		IBinaryVisitor result = ifThen(
				includeAdjacents ? sequence(distinct(), vBefore) : vBefore, null);
		result.wSetVisitor2(sequence(traverseAll(result, includeAdjacents), vAfter));
	    return result;
	}

	public IUnaryVisitor onceTopDown(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor ifElse = ifElse(visitor, null);
		IBinaryVisitor result = includeAdjacents ? sequence(distinct(), ifElse) : ifElse;
		ifElse.wSetVisitor2(traverseOne(result, includeAdjacents));
	    return result;
	}
	public IBinaryVisitor onceBottomUp(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor ifElse = ifElse(null, visitor);
		IBinaryVisitor result = includeAdjacents ? sequence(distinct(), ifElse) : ifElse;
		ifElse.wSetVisitor1(traverseOne(result, includeAdjacents));
	    return result;
	}
	
	public IUnaryVisitor spineTopDown(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor sequence = sequence(visitor, null);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor2(
			ifElse(traverseOne(result, includeAdjacents), traverseAll(failure(), includeAdjacents)));
	    return result;
	}
	public IVisitor spineBottomUp(IVisitor visitor, boolean includeAdjacents) {
		IBinaryVisitor sequence = sequence(null, visitor);
		IBinaryVisitor result = includeAdjacents ? ifThen(distinct(), sequence) : sequence;
		sequence.wSetVisitor1(
			ifElse(traverseOne(result, includeAdjacents), traverseAll(failure(), includeAdjacents)));
	    return result;
	}

	//derived fixpoint traversal strategies
	
	public IVisitor reduce(IVisitor visitor) {
		IBinaryVisitor rec = concurrentSequence(visitor, null);
		rec.wSetVisitor2(rec);
	    return concurrentSequence(visitor, tryPrune(rec));
	}
	public IVisitor outermost(IVisitor visitor) {
		IUnaryVisitor result = concurrentTopDown(null, false);
		result.wSetVisitor1(tryPrune(concurrentSequence(visitor, result)));
	    return result;
	}
	public IVisitor innermost(IVisitor visitor) {
		IBinaryVisitor result = bottomUp(null, false);
		result.wSetVisitor2(tryPrune(concurrentSequence(visitor, result)));
	    return result;
	}	
}
