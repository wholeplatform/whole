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
package org.whole.lang.xsi.ui.actions;

import org.whole.lang.ui.editor.ActionFactory;

/** 
 * @author Riccardo Solmi
 */
public class XsiActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final XsiActionFactory instance = new XsiActionFactory();
	}
	public static XsiActionFactory instance() {
		return SingletonHolder.instance;
	}
	private XsiActionFactory() {
	}

//	@Override
//	public SelectionAction createAddAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> addedEntityDescriptor) {
//		IEnablerPredicate identityPredicate = EnablerPredicateFactory.instance.alwaysTrue();
//		return new XsiCompositeAddAction(workbenchPart, identityPredicate, addedEntityDescriptor, addedEntityDescriptor.getName());
//	}
//
//	@Override
//	public SelectionAction createReplaceAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> replaceEntityDescriptor) {
//		IEnablerPredicate identityPredicate = EnablerPredicateFactory.instance.alwaysTrue();
//		return new XsiReplaceChildAction(workbenchPart, identityPredicate, DefaultCopyTransformer.instance, replaceEntityDescriptor, replaceEntityDescriptor.getName());
//	}
//	
//	private static class XsiCompositeAddAction extends CompositeAddAction {
//		private String defaultLabel;
//		private EntityDescriptor<?> type;
//		public XsiCompositeAddAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
//			super(part, enablerPredicate, type, text);
//			this.defaultLabel = "(" + text + ")";
//			this.type = type;
//			}
//
//		@Override
//		protected boolean calculateEnabled() {
//			boolean isEnabled = super.calculateEnabled();
//			if (isEnabled) {
//				IEntity selectedEntity = ((IEntityPart) getSelectedObjects().get(0)).getModelEntity();
//				IMappingStrategy strategy = MappingStrategyUtils.getMappingStrategy(selectedEntity);
//				EntityDescriptor<?> contextED = EntityUtils.isFragment(selectedEntity) ? CommonsEntityDescriptorEnum.RootFragment : selectedEntity.wGetEntityDescriptor();
//				FeatureDescriptor fd = selectedEntity.wGetFeatureDescriptor(0);
//				if (strategy != null && strategy.isElementMapping(contextED, type, fd))
//					setText(strategy.getElementNCName(contextED, type, fd));
//				else if (strategy != null && strategy.isAttributeMapping(contextED, type, fd)) {
//					boolean hasMultipleSubstitutions = selectedEntity.wGetEntityDescriptor().isPolymorphic();//was getConcreteSubtypesInLanguage().size() > 1;
//					String attributeName = strategy.getAttributeNCName(contextED, type, fd) + (hasMultipleSubstitutions ? ' ' + defaultLabel : "");
//					setText(attributeName);
//				} else
//					setText(defaultLabel);
//			}
//			return isEnabled;
//		}
//	}
//
//	private static class XsiReplaceChildAction extends ReplaceChildAction {
//		private String defaultLabel;
//		private EntityDescriptor<?> type;
//		public XsiReplaceChildAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntityTransformer transformer, EntityDescriptor<?> type, String text) {
//			super(part, enablerPredicate, type, text, transformer);
//			this.defaultLabel = "(" + text + ")";
//			this.type = type;
//		}
//
//		@Override
//		protected boolean calculateEnabled() {
//			boolean isEnabled = super.calculateEnabled();
//			if (isEnabled) {
//				IEntity selectedEntity = ((IEntityPart) getSelectedObjects().get(0)).getModelEntity();
//				IMappingStrategy strategy = MappingStrategyUtils.getMappingStrategy(selectedEntity);
//				IEntity parent = selectedEntity.wGetParent().wGetAdaptee(false);
//				EntityDescriptor<?> contextED = EntityUtils.isFragment(parent) ? CommonsEntityDescriptorEnum.RootFragment : parent.wGetEntityDescriptor();
//				FeatureDescriptor fd = parent.wGetFeatureDescriptor(selectedEntity);
//				if (strategy != null && strategy.isElementMapping(contextED, type, fd))
//					setText(strategy.getElementNCName(contextED, type, fd));
//				else if (strategy != null && strategy.isAttributeMapping(contextED, type, fd)) {
//					boolean hasMultipleSubstitutions = selectedEntity.wGetEntityDescriptor().isPolymorphic();//was getConcreteSubtypesInLanguage().size() > 1;
//					String attributeName = strategy.getAttributeNCName(contextED, type, fd) + (hasMultipleSubstitutions ? ' ' + defaultLabel : "");
//					setText(attributeName);
//				} else
//					setText(defaultLabel);
//			}
//			return isEnabled;
//		}
//	}
}
