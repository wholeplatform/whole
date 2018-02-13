package org.whole.lang.flowchart.factories;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.flowchart.model.Flowchart;
import org.whole.lang.flowchart.model.Transitions;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/** 
 * @generator Whole
 */
public class FlowchartDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		FlowchartEntityFactory ef = FlowchartEntityFactory.instance(er);

		er.put(ef.create(FlowchartEntityDescriptorEnum.Entry,
				ef.createPixels(0),
				ef.createPixels(0),
				ef.createPixels(16),
				ef.createPixels(16),
				ef.createText("entry")
				));
		er.put(ef.create(FlowchartEntityDescriptorEnum.Exit,
				ef.createPixels(0),
				ef.createPixels(0),
				ef.createPixels(16),
				ef.createPixels(16),
				ef.createText("exit")
				));
		er.put(ef.create(FlowchartEntityDescriptorEnum.Block,
				ef.createPixels(0),
				ef.createPixels(0),
				ef.createPixels(50),
				ef.createPixels(40),
				ef.createText("block")
				));
		er.put(ef.create(FlowchartEntityDescriptorEnum.Choice,
				ef.createPixels(0),
				ef.createPixels(0),
				ef.createPixels(40),
				ef.createPixels(30),
				ef.createText("choice")
				));
		Transitions joinTransitions = ef.createTransitions(0);
		er.put(ef.create(FlowchartEntityDescriptorEnum.Join,
				ef.createPixels(0),
				ef.createPixels(0),
				ef.createPixels(50),
				ef.createPixels(16),
				ef.createText("join"),
				joinTransitions
				));
		Flowchart flowchart = ef.create(FlowchartEntityDescriptorEnum.Flowchart,
				ef.createNodes(0),
				ef.createTransitions(0)
				);
		er.put(flowchart);

		flowchart.wAddChangeEventHandler(new IdentityChangeEventHandler() {
			private static final long serialVersionUID = 1L;

			public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
				if (FlowchartFeatureDescriptorEnum.transitions.equals(fd)) {
					newValue.wAddChangeEventHandler(new IdentityChangeEventHandler() {
						private static final long serialVersionUID = 1L;

						@Override
						public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
							super.notifyRemoved(source, featureDesc, index, oldValue);
							if (Matcher.match(FlowchartEntityDescriptorEnum.Flowchart, source.wGetParent()) && EntityUtils.isNotResolver(oldValue)) {
								removeCrossReferences(oldValue, FlowchartFeatureDescriptorEnum.target);
								removeCrossReferences(oldValue, FlowchartFeatureDescriptorEnum.source);
							}
						}

						private void removeCrossReferences(IEntity transition, FeatureDescriptor fd) {
							IEntity referrer = transition.wGet(fd);

							for (int i=referrer.wSize(), size=i+referrer.wAdjacentSize(); i<size; i++) {
								IEntity adjacent = referrer.wGet(i);

								if (EntityUtils.isComposite(adjacent) && adjacent.wContains(transition))
									referrer.wGet(i).wRemove(transition);
								else if (adjacent == transition) // referece modifier check not needed
									referrer.wSet(i, CommonsEntityAdapterFactory.createResolver(adjacent.wGetEntityDescriptor()));
							}
						}
					});
				}
			}
		});

		//FIXME workaround for misbehaving event handling on composite entities with relationship modifier.
		// AbstractEntity.notifyAdded() should have notified the composite owner's event handler (Join),
		// consequently we redirect any change event of the composite to the owner entity.
		joinTransitions.wAddChangeEventHandler(new IdentityChangeEventHandler() {
			private static final long serialVersionUID = 1L;

			@Override
			public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
				IEntity targetJoin = newValue.wGet(FlowchartFeatureDescriptorEnum.target);
				IChangeEventHandler changeEventHandler = targetJoin.wGetModel().getCompoundModel().getChangeEventHandler();
				changeEventHandler.notifyChanged(targetJoin, FlowchartFeatureDescriptorEnum.targetTransitions, source, source);
			}

			@Override
			public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
				IEntity targetJoin = newValue.wGet(FlowchartFeatureDescriptorEnum.target);
				IChangeEventHandler changeEventHandler = targetJoin.wGetModel().getCompoundModel().getChangeEventHandler();
				changeEventHandler.notifyChanged(targetJoin, FlowchartFeatureDescriptorEnum.targetTransitions, source, source);
			}
		});
	}
}
