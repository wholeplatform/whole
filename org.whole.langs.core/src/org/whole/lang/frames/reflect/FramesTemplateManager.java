package org.whole.lang.frames.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.frames.model.Frame;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class FramesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final FramesTemplateManager instance = new FramesTemplateManager();
	}

	public static FramesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private FramesTemplateManager() {
		put("empty", new AbstractTemplateFactory<Frame>() {
			public Frame create() {
				return GenericEntityFactory.instance
						.create(FramesEntityDescriptorEnum.Frame);
			}
		});
	}
}
