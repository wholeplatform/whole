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
package org.whole.lang.ui.commands;

import org.eclipse.gef.commands.Command;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractConnectionCommand extends Command implements ILegacyCommand {
	private FeatureDescriptorEnum connectionFeatures;
	private IEntity connection;

	protected boolean canConnect(IEntity entity, FeatureDescriptor fd) {
		if (!EntityUtils.isComposite(entity.wGet(fd)))
			return EntityUtils.isResolver(entity.wGet(fd));
		return true;
	}

	protected void connect(IEntity entity, FeatureDescriptor fd, IEntity child) {
		if (entity.wGetEntityDescriptor(fd).isPlatformSupertypeOf(child.wGetEntityDescriptor())) {
			entity.wSet(fd, child);
		} else
			entity.wGet(fd).wAdd(child);
	}

	protected void disconnect(IEntity entity, FeatureDescriptor fd, IEntity child) {
		if (entity.wGetEntityDescriptor(fd).isPlatformSupertypeOf(child.wGetEntityDescriptor())) {
			entity.wRemove(fd);
		} else
			entity.wGet(fd).wRemove(child);
	}

	public void setConnection(IEntity newConnection) {
		this.connection = newConnection;
		connectionFeatures = newConnection.wGetEntityDescriptor().getFeatureDescriptorEnum();
	}
	public IEntity getConnection() {
		return connection;
	}
	public FeatureDescriptor getConnectionFeature(String featureName) {
		return connectionFeatures == null ?
				null : connectionFeatures.valueOf(featureName);
	}

	protected FeatureDescriptor getConnectionConnectedFeature(IEntity node) {
		FeatureDescriptor fd = null;
		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(node);
		for (IEntity child : i)
			if ((EntityUtils.isComposite(child) && child.wContains(getConnection())) ||
				(EntityUtils.isSimple(child) && child.wEquals(getConnection())))
				fd = node.wGetFeatureDescriptor(child);
		return fd;
	}

	protected boolean connectionExists(IEntity source, FeatureDescriptor sourceFD, IEntity target, FeatureDescriptor targetFD) {
		if (sourceFD != null && targetFD != null) {
			IEntity sourceTransistion = source.wGet(sourceFD);
			IEntity targetTransistion = target.wGet(targetFD);
			return connectionExists(sourceTransistion, targetTransistion);
		}
		return false;
	}

	protected boolean connectionExists(IEntity sourceTransistion, IEntity targetTransistion) {
		if (EntityUtils.isNotResolver(sourceTransistion) && EntityUtils.isNotResolver(targetTransistion)) {
			IEntityIterator<IEntity> sourceChildrenIterator = EntityUtils.isComposite(sourceTransistion) ?
					IteratorFactory.childIterator() : IteratorFactory.selfIterator();
			sourceChildrenIterator.reset(sourceTransistion);
			
			IEntityIterator<IEntity> targetChildrenIterator = EntityUtils.isComposite(targetTransistion) ?
					IteratorFactory.childIterator() : IteratorFactory.selfIterator();
			targetChildrenIterator.reset(targetTransistion);
			
			for (IEntity sourceEntity : sourceChildrenIterator) {
				for (IEntity targetEntity : targetChildrenIterator)
					if (sourceEntity.equals(targetEntity))
						return true;
			}
		}
		return false;
	}
}
