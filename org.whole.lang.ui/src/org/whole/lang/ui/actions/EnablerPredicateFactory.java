/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.IContextMenuRequest;
import org.whole.lang.ui.requests.PartRequest;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi
 */
public class EnablerPredicateFactory {
	public static final EnablerPredicateFactory instance = new EnablerPredicateFactory();

	protected EnablerPredicateFactory() { }

	private IEnablerPredicate alwaysTrue;
	public final IEnablerPredicate alwaysTrue() {
		if (alwaysTrue == null)
			alwaysTrue = new IEnablerPredicate() {
				public boolean evaluate(IEntityPart selectedPart, Object userdata) {
					return true;
				}
				public String toString() {
					return "true";
				}
			};
		return alwaysTrue;
	}

	public final IEnablerPredicate and(final IEnablerPredicate p1, final IEnablerPredicate p2) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return p1.evaluate(selectedPart, userdata) && p2.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return p1.toString()+" && "+p2.toString();
			}
		};
	}
	public final IEnablerPredicate and(final IEnablerPredicate p1, final IEnablerPredicate p2, final IEnablerPredicate p3) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return p1.evaluate(selectedPart, userdata) && p2.evaluate(selectedPart, userdata) && p3.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return p1.toString()+" && "+p2.toString()+" && "+p3.toString();
			}
		};
	}
	public final IEnablerPredicate or(final IEnablerPredicate p1, final IEnablerPredicate p2) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return p1.evaluate(selectedPart, userdata) || p2.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return p1.toString()+" || "+p2.toString();
			}
		};
	}
	public final IEnablerPredicate or(final IEnablerPredicate p1, final IEnablerPredicate p2, final IEnablerPredicate p3) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return p1.evaluate(selectedPart, userdata) || p2.evaluate(selectedPart, userdata) || p3.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return p1.toString()+" || "+p2.toString()+" || "+p3.toString();
			}
		};
	}
	public final IEnablerPredicate or(final IEnablerPredicate p1, final IEnablerPredicate p2, final IEnablerPredicate p3, final IEnablerPredicate p4) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return p1.evaluate(selectedPart, userdata) || p2.evaluate(selectedPart, userdata) || p3.evaluate(selectedPart, userdata) || p4.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return p1.toString()+" || "+p2.toString()+" || "+p3.toString()+" || "+p4.toString();
			}
		};
	}
	public final IEnablerPredicate not(final IEnablerPredicate p) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return !p.evaluate(selectedPart, userdata);
			}
			public String toString() {
				return "!"+p.toString();
			}
		};
	}

	public final IEnablerPredicate assignableTo(final EntityDescriptor<?> ed) {
		return new AssignableToPredicate(ed);
	}
	public final IEnablerPredicate parent_assignableTo(final EntityDescriptor<?> ed) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return ed.isPlatformSupertypeOf(selectedPart.getParentModelEntity().wGetEntityDescriptor());
			}
			public String toString() {
				return "selectedParentEntity assignableTo "+ed.getName();
			}
		};
	}

	public final IEnablerPredicate assignableToFeatureType() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
			    if (EntityUtils.isNull(selectedPart.getParentModelEntity()))
			        return false;
				IContextMenuRequest request = (IContextMenuRequest)userdata;
				
				IEntity parentEntity = selectedPart.getParentModelEntity();
				IEntity childEntity = selectedPart.getModelEntity();
				return request.isAssignableTo(parentEntity.wGetEntityDescriptor(childEntity));
			}
			public String toString() {
				return "assignableToFeatureType";
			}
		};
	}
	public final IEnablerPredicate assignableToComponentType() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				IContextMenuRequest request = (IContextMenuRequest)userdata;
				return request.isAssignableTo(selectedPart.getModelEntity().wGetEntityDescriptor().getEntityDescriptor(0));
			}
			public String toString() {
				return "assignableToComponentType";
			}
		};
	}

	public final IEnablerPredicate differentType() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				IContextMenuRequest request = (IContextMenuRequest)userdata;
				return !request.isInstance(selectedPart.getModelEntity().wGetAdaptee(false).wGetEntityDescriptor());
			}
			public String toString() {
				return "differentType";
			}
		};
	}
	public final IEnablerPredicate sameType() {
		return not(differentType());
	}

	public final IEnablerPredicate insertMode() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return ((IContextMenuRequest)userdata).getHilightPosition() >= 0;
			}
			public String toString() {
				return "insertMode";
			}
		};
	}
	public final IEnablerPredicate replaceMode() {
		return not(insertMode());
	}

	public final IEnablerPredicate parent_isFragment() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return EntityUtils.isFragment(selectedPart.getParentModelEntity());
			}
		};
	}

	private IEnablerPredicate replaceFeatureType;
	public final IEnablerPredicate replaceFeatureType() {
	    if (replaceFeatureType == null)
	        replaceFeatureType = and(differentType(), assignableToFeatureType());
		return replaceFeatureType;
	}
	private IEnablerPredicate insertFeatureType;
	public final IEnablerPredicate insertFeatureType() {
	    if (insertFeatureType == null)
	        insertFeatureType = and(insertMode(), assignableToComponentType());
		return insertFeatureType;
	}

	// DnD Enabler Predicates
	public IEnablerPredicate isResolver() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return EntityUtils.isResolver(selectedPart.getModelEntity());
			}
			public String toString() {
				return "isResolver";
			}
		};
	}

	public final IEnablerPredicate dndSinglePart() {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				return ((PartRequest)userdata).size() == 1;
			}
			public String toString() {
				return "dndSinglePart";
			}
		};
	}

	public final IEnablerPredicate dndPartsAssignableTo(final EntityDescriptor<?> ed) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				Iterator<?> i = ((PartRequest)userdata).iterator();
				while (i.hasNext()) {
					IEntityPart part = (IEntityPart)i.next();
					if (!ed.isPlatformSupertypeOf(part.getModelEntity().wGetEntityDescriptor()))
						return false;
				}
				return true;
			}
			public String toString() {
				return "dndPartsInstanceOf "+ed;
			}
		};
	}

	public final IEnablerPredicate dndOver(final EntityDescriptor<?> dndED, final EntityDescriptor<?> overED) {
		return and(dndPartsAssignableTo(dndED), assignableTo(overED));
	}
	public final IEnablerPredicate dndOverResolver(final EntityDescriptor<?> dndED) {
		return and(dndPartsAssignableTo(dndED), isResolver());
	}

	public final IEnablerPredicate dndSingleOver(final EntityDescriptor<?> dndED, final EntityDescriptor<?> overED) {
		return and(dndSinglePart(), dndOver(dndED, overED));
	}
	public final IEnablerPredicate dndSingleOverResolver(final EntityDescriptor<?> dndED) {
		return and(dndSinglePart(), dndOverResolver(dndED));
	}
	public final IEnablerPredicate dndSingleInFragment() {
		return and(dndSinglePart(), parent_isFragment());
	}

	public final IEnablerPredicate dndOverResolverIn(final EntityDescriptor<?> dndED, final EntityDescriptor<?> parentED) {
		return and(dndOverResolver(dndED), parent_assignableTo(parentED));
	}
	public final IEnablerPredicate dndSingleOverResolverIn(final EntityDescriptor<?> dndED, final EntityDescriptor<?> parentED) {
		return and(dndSingleOverResolver(dndED), parent_assignableTo(parentED));
	}
	public static boolean isHidden(EntityDescriptor<?> ed) {
		return ed.isAbstract();//WAS !EntityUtils.isImpl(ed) || ed.isAbstract();
	}
	public static boolean isAssignableToFeatureType(IEntity assignee, EntityDescriptor<?> assigned) {
		if (!EntityUtils.hasParent(assignee))
			return false;
		return assignee.wGetParent().wGetEntityDescriptor(assignee).isPlatformSupertypeOf(assigned);
	}
	public static boolean hasSameEntityDescriptor(IEntity assignee, EntityDescriptor<?> assigned) {
		return assignee.wGetAdaptee(false).wGetEntityDescriptor().equals(assigned);
	}
	public static boolean isAssignableToComponentType(IEntity assignee, EntityDescriptor<?> assigned) {
		if (!EntityUtils.isComposite(assignee))
			return false;
		return assignee.wGetEntityDescriptor(0).isPlatformSupertypeOf(assigned);
	}

	public static boolean isSelectionRoot(PartRequest request) {
		EditPart parent = request.getPart().getParent();
		while (parent != null) {
			for (IEntityPart entityPart : request)
				if (parent.equals(entityPart))
					return false;
			parent = parent.getParent();
		}
		return true;
	}
}
