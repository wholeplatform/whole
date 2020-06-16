/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.events.ui.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.jobs.EntityEditDomainJob;
import org.whole.lang.events.util.WebSocketsUtils;
import org.whole.lang.events.util.WebSocketsUtils.IPeerEventsExecutor;
import org.whole.lang.events.util.WebSocketsUtils.PeerEventSource;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class PeerEventsExecutor implements IPeerEventsExecutor {
	public static final String APPLY_PATCH_URI = "whole:org.whole.lang.events:EventsLibrarySemantics#applyPatch";
	protected IEntity model;
	protected EntityEditDomain editDomain;

	public PeerEventsExecutor(IEntity model, EntityEditDomain editDomain) {
		this.model = model;
		this.editDomain = editDomain;
		//TODO test only
		WebSocketsUtils.peerEventsExecutor = this;
	}

	public void asyncExecPeerEvents(PeerEventSource peerEventSource) {
		EntityEditDomainJob.asyncExec("Peer events executor", editDomain, (monitor) -> {
			ModelTransactionCommand command = new ModelTransactionCommand(model);
			try {
				command.begin();
				for (IEntity event : peerEventSource.drainPeerEvents()) {
					//TODO filter compensated events
					peerEventSource.peerEventSyncQueue.add(event);
					IBindingManager args = BindingManagerFactory.instance.createArguments();
					args.wDef("resource", model);
					BehaviorUtils.apply(APPLY_PATCH_URI, event, args);
					//InterpreterOperation.interpret(event, args);
				}
				command.commit();
				editDomain.getCommandStack().execute(command);
			} catch (Exception e) {
				command.rollbackIfNeeded();
				throw e;
			}
		});
	}
}

