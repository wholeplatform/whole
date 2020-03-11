package org.whole.lang.swift.tabularui;

import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;

public class SwiftTabularUIDeployer extends AbstractLanguageExtensionDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addEditorKit(SwiftTabularEditorKit.ID);
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeEditorKit(SwiftTabularEditorKit.ID);
    }
}
