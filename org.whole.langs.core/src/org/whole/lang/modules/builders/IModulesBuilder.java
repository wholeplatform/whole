package org.whole.lang.modules.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator  Whole
 */
public interface IModulesBuilder extends IBuilder {


    public void visit();

    public void registry();

    public void persistence();

    public void locator();

    public void variant();

    public void adapted();

    public void original();

    public void adapter();

    public void resource();

    public void content();

    public void Module();

    public void Module_();

    public void _Module();

    public void Include();

    public void Include_();

    public void _Include();

    public void Reuse();

    public void Reuse_();

    public void _Reuse();

    public void Resource();

    public void Resource_();

    public void _Resource();

    public void WorkspacePath();

    public void WorkspacePath(String value);

    public void FileSystemPath();

    public void FileSystemPath(String value);

    public void ClassPathURI();

    public void ClassPathURI(String value);

    public void URI();

    public void URI(String value);

    public void Persistence();

    public void Persistence(String value);

    public void Registry();

    public void Registry(String value);
}
