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
package org.whole.lang.java.ui.actions;

import org.whole.lang.ui.editor.ActionFactory;

/** 
 * @author Enrico Persiani
 */
public class JavaActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final JavaActionFactory instance = new JavaActionFactory();
	}
	public static JavaActionFactory instance() {
		return SingletonHolder.instance;
	}

	private JavaActionFactory() {
	}

//	private static class CompositeAddMethodDeclarationAction extends CompositeAddAction {
//		public CompositeAddMethodDeclarationAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
//			super(part, enablerPredicate, type, text);
//		}
//
//		@Override
//		protected IEntity configureNewChild(IEntity selectedEntity, IEntity newChild) {
//			IEntity parentEntity = selectedEntity.wGetParent();
//			boolean needsBlock = !EntityUtils.isNull(parentEntity) &&
//					JavaEntityDescriptorEnum.ClassDeclaration.equals(parentEntity.wGetEntityDescriptor());
//			if (needsBlock)
//				newChild.wSet(JavaFeatureDescriptorEnum.body, JavaEntityFactory.instance.createBlock(0));
//
//			return super.configureNewChild(selectedEntity, newChild);
//		}
//	}
//
//	private static class MethodDeclarationCopyTransformer extends DefaultCopyTransformer {
//		@Override
//		public void transform(IEntity oldEntity, IEntity newEntity) {
//			super.transform(oldEntity, newEntity);
//			IEntity grandParentEntity = oldEntity.wGetParent().wGetParent();
//			boolean needsBlock = !EntityUtils.isNull(grandParentEntity) &&
//					JavaEntityDescriptorEnum.ClassDeclaration.equals(grandParentEntity.wGetEntityDescriptor()) &&
//					!EntityUtils.isNotResolver(newEntity.wGet(JavaFeatureDescriptorEnum.body));
//			if (needsBlock)
//				newEntity.wSet(JavaFeatureDescriptorEnum.body, JavaEntityFactory.instance.createBlock(0));
//		}
//	}
//	@Override
//	public SelectionAction createAddAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> addedEntityDescriptor) {
//		if (!JavaEntityDescriptorEnum.MethodDeclaration.equals(addedEntityDescriptor))
//			return super.createAddAction(workbenchPart, addedEntityDescriptor);
//		else {
//			IEnablerPredicate identityPredicate = EnablerPredicateFactory.instance.alwaysTrue();
//			return new CompositeAddMethodDeclarationAction(workbenchPart, identityPredicate, addedEntityDescriptor, addedEntityDescriptor.getName());
//		}
//	}
//
//	@Override
//	public SelectionAction createReplaceAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> replaceEntityDescriptor) {
//		if (!JavaEntityDescriptorEnum.MethodDeclaration.equals(replaceEntityDescriptor))
//			return super.createReplaceAction(workbenchPart, replaceEntityDescriptor);
//		else {
//			IEnablerPredicate identityPredicate = EnablerPredicateFactory.instance.alwaysTrue();
//			return new ReplaceChildAction(workbenchPart, identityPredicate, replaceEntityDescriptor, replaceEntityDescriptor.getName(), new MethodDeclarationCopyTransformer());
//		}
//	}
}
