package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class Grammars2ModelsVisitorTest extends TestCase {

    protected static IEntity create(String templateName) {
        return Grammars2ModelsVisitorTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testMappingRules() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment");
        assertThat("at /testCases/1/tests/0/body/0", subject, matches(create("fragment1")));
        subject = evaluate("fragment2");
        assertThat("at /testCases/1/tests/0/body/1", subject, matches(create("fragment3")));
        subject = evaluate("fragment4");
        assertThat("at /testCases/1/tests/0/body/2", subject, matches(create("fragment5")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingTestGrammar1() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment6");
        assertThat("at /testCases/1/tests/1/body/0", subject, matches(create("fragment7")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingDataTypesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment8");
        assertThat("at /testCases/1/tests/2/body/0", subject, matches(create("fragment9")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingMessagesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment10");
        assertThat("at /testCases/1/tests/3/body/0", subject, matches(create("fragment11")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingStateMachineGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment12");
        assertThat("at /testCases/1/tests/4/body/0", subject, matches(create("fragment13")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingStateMachine2Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment14");
        assertThat("at /testCases/1/tests/5/body/0", subject, matches(create("fragment15")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingFamilyGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment16");
        assertThat("at /testCases/1/tests/6/body/0", subject, matches(create("fragment17")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingMT3Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment18");
        assertThat("at /testCases/1/tests/7/body/0", subject, matches(create("fragment19")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingXmlGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment20");
        assertThat("at /testCases/1/tests/8/body/0", subject, matches(create("fragment21")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingDTAUSGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment22");
        assertThat("at /testCases/1/tests/9/body/0", subject, matches(create("fragment23")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingMotoGPCSVGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment24");
        assertThat("at /testCases/1/tests/10/body/0", subject, matches(create("fragment25")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testMappingMotoGPFLFGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment26");
        assertThat("at /testCases/1/tests/11/body/0", subject, matches(create("fragment27")));
        bindings().wExitScope();
    }
}
