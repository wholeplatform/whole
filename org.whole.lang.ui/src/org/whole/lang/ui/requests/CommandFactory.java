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
package org.whole.lang.ui.requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.requests.GroupRequest;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.commands.CompositeAddCommand;
import org.whole.lang.ui.commands.CompositeRemoveCommand;
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IBinaryVisitor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class CommandFactory implements ICommandFactory {
	private static class SingletonHolder {
		private static final ICommandFactory instance = new CommandFactory();
	}
	public static ICommandFactory instance() {
		return SingletonHolder.instance;
	}

	private Map<String, List<IPartRequestHandler>> handlersMap = new HashMap<String, List<IPartRequestHandler>>(128); // requestType -> list of RequestHandlers

	protected final ICommandFactory removeFeature = new ICommandFactory() {
		public Command create(PartRequest request) {
			IEntity entity = request.getModelEntity();
			if (!isSelectionRoot(request))
				return null;
			ReplaceChildCommand cmd = new ReplaceChildCommand();
			cmd.setParent(request.getParentModelEntity());
			cmd.setOldChild(entity);
			cmd.setNewChild(CommonsEntityFactory.instance.createResolver());
			return cmd;
		}
	};
	protected final ICommandFactory removeIndexedFeature = new ICommandFactory() {
		public Command create(PartRequest request) {
			IEntity entity = request.getModelEntity();
			if (!isSelectionRoot(request))
				return null;
			CompositeRemoveCommand cmd = new CompositeRemoveCommand();
			cmd.setComposite(request.getParentModelEntity());
			cmd.setChild(entity);
			return cmd;
		}
	};

	protected static IEntity createEmpty(IEntity parent, IEntity child) {
		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(child);
		return CommonsEntityAdapterFactory.createResolver(ed);
	}

	protected static boolean isSelectionRoot(PartRequest request) {
		EditPart parent = request.getPart().getParent();
		while (parent != null) {
			for (IEntityPart entityPart : request)
				if (parent.equals(entityPart))
					return false;
			parent = parent.getParent();
		}
		return true;
	}

	/**
	 * @see org.whole.lang.e4.ui.actions.DeleteAction#createDeleteCommand(List)
	 */
	
	public static Command createDeleteCommand(List<?> objects) {
		if (objects.isEmpty())
			return null;
		if (!(objects.get(0) instanceof EditPart))
			return null;

		GroupRequest deleteReq =
			new GroupRequest(RequestConstants.REQ_DELETE);
		deleteReq.setEditParts(objects);

		CompoundCommand compoundCmd = new CompoundCommand(
			GEFMessages.DeleteAction_ActionDeleteCommandName);
		for (int i = 0; i < objects.size(); i++) {
			EditPart object = (EditPart) objects.get(i);
			Command cmd = object.getCommand(deleteReq);
			if (cmd != null) compoundCmd.add(cmd);
		}

		return compoundCmd;
	}

	protected final ICommandFactory orphanFeature = new ICommandFactory() {
		public Command create(PartRequest request) {
			DnDOverCompositeRequest orderedRequest = (DnDOverCompositeRequest) request;
			IEntityPart dnDChild = orderedRequest.iterator().next();
			return removeFeature.create(new DeletePartRequest(PartRequest.DELETE, dnDChild));
		}
	};
	protected final ICommandFactory orphanIndexedFeature = new ICommandFactory() {
		public Command create(PartRequest request) {
			DnDOverCompositeRequest orderedRequest = (DnDOverCompositeRequest) request;
			IEntityPart dnDChild = orderedRequest.iterator().next();
			return removeIndexedFeature.create(new DeletePartRequest(PartRequest.DELETE, dnDChild));
		}
	};
	protected final ICommandFactory moveIndexedFeature = new ICommandFactory() {
		public Command create(PartRequest request) {
			Command remove = orphanIndexedFeature.create(request);
			Command insert = insertIndexedFeature.create(request);

			CompoundCommand compound = new CompoundCommand();
			compound.add(remove);
			compound.add(insert);
			return compound.unwrap();
		}
	};

	protected final ICommandFactory unexecutableFeature = new UnexecutableCommandFactory();
	protected final ICommandFactory replaceFeature = new ReplaceChildCommandFactory(IFeatureTransformer.IDENTITY);
	protected final ICommandFactory replaceClonedFeature = new ReplaceChildCommandFactory(CLONE());
	protected final ICommandFactory replaceSharedFeature = new ReplaceChildCommandFactory(SHARE());
	protected final ICommandFactory compoundReplaceFeature = new CompoundReplaceChildCommandFactory(IFeatureTransformer.IDENTITY);
	protected final ICommandFactory compoundReplaceClonedFeature = new CompoundReplaceChildCommandFactory(CLONE());
	protected final ICommandFactory compoundReplaceSharedFeature = new CompoundReplaceChildCommandFactory(SHARE());
	protected final ICommandFactory insertIndexedFeature = new CompositeAddCommandFactory(IFeatureTransformer.IDENTITY);
	protected final ICommandFactory insertClonedIndexedFeature = new CompositeAddCommandFactory(CLONE());
	protected final ICommandFactory insertSharedIndexedFeature = new CompositeAddCommandFactory(SHARE());

	protected synchronized void addOverSimpleConstraints(final Object[][] dndRules) {
		EnablerPredicateFactory pf = getEnablerPredicateFactory();
		List<IPartRequestHandler> cloneList = new ArrayList<IPartRequestHandler>(dndRules.length);
		List<IPartRequestHandler> shareList = new ArrayList<IPartRequestHandler>(dndRules.length);
		for (Object[] dndRule : dndRules) {
			EntityDescriptor<?> dndED = (EntityDescriptor<?>) dndRule[0];
			EntityDescriptor<?> targetED = (EntityDescriptor<?>) dndRule[1];
			IFeatureTransformer featureTransformer = (IFeatureTransformer) dndRule[2];
			boolean isExecutable = (Boolean) dndRule[3];

			cloneList.add(new PartRequestHandler(pf.dndSingleOver(dndED, targetED),
					isExecutable ? new ReplaceChildCommandFactory(CLONE(featureTransformer)) : unexecutableFeature));
			shareList.add(new PartRequestHandler(pf.dndSingleOver(dndED, targetED),
					isExecutable ? new ReplaceChildCommandFactory(SHARE(featureTransformer)) : unexecutableFeature));
		}
		addHandlers(PartRequest.CLONE_CHILD, cloneList);
		addHandlers(PartRequest.SHARE_CHILD, shareList);
	}

	protected synchronized void addOverCompositeConstraints(final Object[][] dndRules) {	
		EnablerPredicateFactory pf = getEnablerPredicateFactory();
		List<IPartRequestHandler> addList = new ArrayList<IPartRequestHandler>(dndRules.length*3);
		List<IPartRequestHandler> cloneList = new ArrayList<IPartRequestHandler>(dndRules.length*3);
		List<IPartRequestHandler> shareList = new ArrayList<IPartRequestHandler>(dndRules.length*3);

		for (Object[] dndRule : dndRules) {
			EntityDescriptor<?> dndED = (EntityDescriptor<?>) dndRule[0];
			EntityDescriptor<?> targetED = (EntityDescriptor<?>) dndRule[1];
			IFeatureTransformer featureTransformer = (IFeatureTransformer) dndRule[2];
			boolean isExecutable = (Boolean) dndRule[3];

			addList.add(new PartRequestHandler(pf.dndSingleOverResolverIn(dndED, targetED),
					isExecutable ? new ReplaceChildCommandFactory(featureTransformer) : unexecutableFeature));
			cloneList.add(new PartRequestHandler(pf.dndSingleOverResolverIn(dndED, targetED),
					isExecutable ? new ReplaceChildCommandFactory(CLONE(featureTransformer)) : unexecutableFeature));
			shareList.add(new PartRequestHandler(pf.dndSingleOverResolverIn(dndED, targetED),
					isExecutable ? new ReplaceChildCommandFactory(SHARE(featureTransformer)) : unexecutableFeature));

			addList.add(new PartRequestHandler(pf.dndOverResolverIn(dndED, targetED),
					isExecutable ? new CompoundReplaceChildCommandFactory(featureTransformer) : unexecutableFeature));
			cloneList.add(new PartRequestHandler(pf.dndOverResolverIn(dndED, targetED),
					isExecutable ? new CompoundReplaceChildCommandFactory(CLONE(featureTransformer)) : unexecutableFeature));
			shareList.add(new PartRequestHandler(pf.dndOverResolverIn(dndED, targetED),
					isExecutable ? new CompoundReplaceChildCommandFactory(SHARE(featureTransformer)) : unexecutableFeature));

			addList.add(new PartRequestHandler(pf.dndOver(dndED, targetED),
					isExecutable ? new CompositeAddCommandFactory(featureTransformer) : unexecutableFeature));
			cloneList.add(new PartRequestHandler(pf.dndOver(dndED, targetED),
					isExecutable ? new CompositeAddCommandFactory(CLONE(featureTransformer)) : unexecutableFeature));
			shareList.add(new PartRequestHandler(pf.dndOver(dndED, targetED),
					isExecutable ? new CompositeAddCommandFactory(SHARE(featureTransformer)) : unexecutableFeature));			
		}
		addHandlers(PartRequest.MOVE_ADD_CHILD, addList);
		addHandlers(PartRequest.CLONE_CHILD, cloneList);
		addHandlers(PartRequest.SHARE_CHILD, shareList);				
	}

	protected EnablerPredicateFactory getEnablerPredicateFactory() {
		return EnablerPredicateFactory.instance;
	}
	protected IFeatureTransformer CLONE() {
		return CLONE(IFeatureTransformer.IDENTITY);
	}
	protected IFeatureTransformer SHARE() {
		return SHARE(IFeatureTransformer.IDENTITY);
	}
	
	protected IFeatureTransformer CLONE(final IFeatureTransformer innerFeatureTransformer) {
		return new IFeatureTransformer() {
			public IEntity transform(IEntity newFeature) {
				return innerFeatureTransformer.transform(EntityUtils.clone(newFeature));
			}
		};
	}
	//FIXME implement share behavior
	protected IFeatureTransformer SHARE(final IFeatureTransformer innerFeatureTransformer) {
		return new IFeatureTransformer() {
			public IEntity transform(IEntity newFeature) {
				return innerFeatureTransformer.transform(EntityUtils.clone(newFeature));
			}
		};
	}
	
	protected synchronized void addHandlers(String requestType, List<IPartRequestHandler> handlers) {
		List<IPartRequestHandler> handlerList = handlersMap.get(requestType);

		if (handlerList == null)
			handlersMap.put(requestType, handlers);
		else
			handlerList.addAll(handlers);
	}
	protected synchronized void addHandlers(String requestType, IPartRequestHandler[] handlers) {
		List<IPartRequestHandler> handlerList = handlersMap.get(requestType);

		if (handlerList == null) {
			handlerList = new ArrayList<IPartRequestHandler>(handlers.length);
			handlersMap.put(requestType, handlerList);
		}

		for (IPartRequestHandler handler : handlers)
			handlerList.add(handler);
	}

	public Command create(PartRequest request) {
		IPartRequestHandler handler;

		// tries to handle operation with custom handlers
		List<IPartRequestHandler> handlerList = handlersMap.get(request.getRequestType());
		if (handlerList != null && !handlerList.isEmpty()) {
			Iterator<IPartRequestHandler> handlerIterator = handlerList.iterator();
			while (handlerIterator.hasNext()) {
				handler = (IPartRequestHandler)handlerIterator.next();
				if (handler.canHandlePartRequest(request))
					return handler.handlePartRequest(request);
			}
		}

		// handle basic requests
		if (EntityUtils.isComposite(request.getModelEntity()) && request.getRequestType() == PartRequest.MOVE_CHILD)
			return moveIndexedFeature.create(request);

		if (request.getRequestType() == PartRequest.MOVE_ORPHAN_CHILD) {
			if (EntityUtils.isComposite(request.getModelEntity()))
				return orphanIndexedFeature.create(request);
			else
				return orphanFeature.create(request);
		}

		if (request.getRequestType() == PartRequest.DELETE) {
			if (EntityUtils.isComposite(request.getParentModelEntity()))
				return removeIndexedFeature.create(request);
			else //was else if (EntityUtils.isSimple(request.getParentModelEntity()))
				return removeFeature.create(request);
		}

		// handle composite and simple requests
		if (isDnDRequest(request)) {
			boolean isCompositeAddCommand, isReplaceCommand;
			isCompositeAddCommand = isReplaceCommand = request.size()>0;
			IEntity targetEntity = request.getModelEntity();
			boolean isCloneRequest = request.getRequestType() == PartRequest.CLONE_CHILD;

			HashSet<IEntity> targetEntityAncestors = new HashSet<IEntity>();
			GenericTraversalFactory tf = GenericTraversalFactory.instance;
			IBinaryVisitor ancestorsVisitor = tf.ancestors(tf.collect(tf.identity(), targetEntityAncestors));
			ancestorsVisitor.visit(targetEntity);

			for (IEntityPart dndPart : request) {
				IEntity dndEntity = dndPart.getModelEntity();
				if (targetEntityAncestors.contains(dndEntity) && !isCloneRequest)
					return UnexecutableCommand.INSTANCE;
				EntityDescriptor<?> dndEntityDescriptor = dndEntity.wGetEntityDescriptor();
				isCompositeAddCommand &= EntityUtils.isAddable(targetEntity, dndEntityDescriptor) ||
						EntityUtils.isComposite(targetEntity);
				isReplaceCommand &= EntityUtils.isReplaceable(targetEntity, dndEntityDescriptor);
			}
			if (isCompositeAddCommand)
				return createCompositeAddCommand(request);
			else if (isReplaceCommand)
				return createReplaceCommand(request);
			else
				return UnexecutableCommand.INSTANCE;
		}
		return null;
	}

	private boolean isDnDRequest(PartRequest request) {
		return request.getRequestType() == PartRequest.MOVE_ADD_CHILD ||
			request.getRequestType() == PartRequest.CLONE_CHILD ||
			request.getRequestType() == PartRequest.SHARE_CHILD;
	}

	private Command createReplaceCommand(PartRequest request) {
		if (request.getRequestType() == PartRequest.MOVE_ADD_CHILD)
			return (request.size() == 1 ? replaceFeature : compoundReplaceFeature).create(request);
		else if (request.getRequestType() == PartRequest.CLONE_CHILD)
			return (request.size() == 1 ? replaceClonedFeature : compoundReplaceClonedFeature).create(request);
		else if (request.getRequestType() == PartRequest.SHARE_CHILD)
			return (request.size() == 1 ? replaceSharedFeature: compoundReplaceSharedFeature).create(request);
		else
			return null;
	}

	private Command createCompositeAddCommand(PartRequest request) {
		if (request.getRequestType() == PartRequest.MOVE_ADD_CHILD)
			return insertIndexedFeature.create(request);
		else if (request.getRequestType() == PartRequest.CLONE_CHILD)
			return insertClonedIndexedFeature.create(request);
		else if (request.getRequestType() == PartRequest.SHARE_CHILD)
			return insertSharedIndexedFeature.create(request);
		else
			return null;
	}

	public static class UnexecutableCommandFactory implements ICommandFactory {
		public final Command create(PartRequest request) {
			return UnexecutableCommand.INSTANCE;
		}
	};

	public static class CompositeAddCommandFactory implements ICommandFactory {
		private IFeatureTransformer featureTransformer;

		public CompositeAddCommandFactory(IFeatureTransformer featureTransformer) {
			this.featureTransformer = featureTransformer;
		}

		public final Command create(PartRequest request) {
			DnDOverCompositeRequest overCompositeRequest = (DnDOverCompositeRequest)request;
			CompositeAddCommand cmd = new CompositeAddCommand();
			cmd.setComposite(overCompositeRequest.getModelEntity());
			cmd.setNewChild(featureTransformer.transform(overCompositeRequest.getDnDChildEntity()));
			if (overCompositeRequest.getCompositePrevChild() != null)
				cmd.setPrevChild(overCompositeRequest.getCompositePrevChild().getModelEntity());
			return cmd;
		}
	};

	public static class ReplaceChildWithEmptyCommandFactory implements ICommandFactory {
		public final Command create(PartRequest request) {
			ReplaceChildCommand cmd = new ReplaceChildCommand();
			cmd.setParent(request.getParentModelEntity());
			cmd.setOldChild(request.getModelEntity());
			if (request instanceof DnDOverPartRequest) {
				DnDOverPartRequest overPartRequest = (DnDOverPartRequest)request;
				cmd.setNewChild(createEmpty(request.getParentModelEntity(), ((IEntityPart)overPartRequest.iterator().next()).getModelEntity()));
			} else
				cmd.setNewChild(createEmpty(request.getParentModelEntity(), request.getModelEntity()));
			return cmd;
		}
	};

	public static class ReplaceChildCommandFactory implements ICommandFactory {
		private IFeatureTransformer featureTransformer;

		public ReplaceChildCommandFactory(IFeatureTransformer featureTransformer) {
			this.featureTransformer = featureTransformer;
		}

		public final Command create(PartRequest request) {
			ReplaceChildCommand cmd = new ReplaceChildCommand();
			cmd.setParent(request.getParentModelEntity());
			cmd.setOldChild(request.getModelEntity());
			if (request instanceof DnDOverPartRequest) {
				DnDOverPartRequest overPartRequest = (DnDOverPartRequest)request;
				cmd.setNewChild(featureTransformer.transform(((IEntityPart)overPartRequest.iterator().next()).getModelEntity()));
			} else {
				DnDOverCompositeRequest overCompositeRequest = (DnDOverCompositeRequest)request;
				cmd.setNewChild(featureTransformer.transform(((IEntityPart)overCompositeRequest.iterator().next()).getModelEntity()));
			}
			return cmd;
		}
	};

	public static class CompoundReplaceChildCommandFactory implements ICommandFactory {
		private IFeatureTransformer featureTransformer;

		public CompoundReplaceChildCommandFactory(IFeatureTransformer featureTransformer) {
			this.featureTransformer = featureTransformer;
		}

		public final Command create(PartRequest request) {
			CompoundCommand compound = new CompoundCommand();

			Iterator<IEntityPart> i = request.iterator();
			while (i.hasNext()) {
				IEntityPart part = (IEntityPart)i.next();
				if (i.hasNext())
					compound.add(new CompositeAddCommandFactory(featureTransformer).create(new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD,
							(IEntityPart)request.getPart().getParent(),
							part,
							request.getPart())));
				else {
					List<IEntityPart> newList = new ArrayList<IEntityPart>(1);
					newList.add(part);
					compound.add(new ReplaceChildCommandFactory(featureTransformer).create(new DnDOverPartRequest(PartRequest.MOVE_ADD_CHILD,
							request.getPart(), newList)));
				}
			}
			return compound.unwrap();
		}
	};
}
