package org.whole.lang.executables.instrumentation;

import java.time.Duration;
import java.time.Instant;

import org.whole.lang.operations.ICloneContext;

public class ProfilerData extends AbstractInstrumentationData {
	public int cloneCalls;
	public int setBindingsCalls;
	public int resetCalls;
	public int evaluateNextCalls;
	public int evaluateRemainingCalls;
	public int callNextCalls;
	public int callRemainingCalls;
	public int doNextCalls;
	public int doEndCalls;
	
	public Duration cloneDuration = Duration.ZERO;
	public Duration setBindingsDuration = Duration.ZERO;
	public Duration resetDuration = Duration.ZERO;
	public Duration evaluateNextDuration = Duration.ZERO;
	public Duration evaluateRemainingDuration = Duration.ZERO;
	public Duration callNextDuration = Duration.ZERO;
	public Duration callRemainingDuration = Duration.ZERO;
	public Duration doNextDuration = Duration.ZERO;
	public Duration doEndDuration = Duration.ZERO;

	@Override
	public ProfilerData clone(ICloneContext cc) {
		ProfilerData data = (ProfilerData) super.clone(cc);
		data.cloneDuration = Duration.from(cloneDuration);
		data.setBindingsDuration = Duration.from(setBindingsDuration);
		data.resetDuration = Duration.from(resetDuration);
		data.evaluateNextDuration = Duration.from(evaluateNextDuration);
		data.evaluateRemainingDuration = Duration.from(evaluateRemainingDuration);
		data.callNextDuration = Duration.from(callNextDuration);
		data.callRemainingDuration = Duration.from(callRemainingDuration);
		data.doNextDuration = Duration.from(doNextDuration);
		data.doEndDuration = Duration.from(doEndDuration);

		data.startInstant = Instant.from(startInstant);
		return data;
	}

	protected Instant startInstant;
	public void startTimer() {
		startInstant = Instant.now();
	}
	public Duration endTimer() {
		return Duration.between(startInstant, Instant.now());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nclone            :");
		sb.append(cloneCalls);
		sb.append("  ");
		sb.append(cloneDuration);

		sb.append("\nsetBindings      :");
		sb.append(setBindingsCalls);
		sb.append("  ");
		sb.append(setBindingsDuration);

		sb.append("\nreset            :");
		sb.append(resetCalls);
		sb.append("  ");
		sb.append(resetDuration);

		sb.append("\nevaluateNext     :");
		sb.append(evaluateNextCalls);
		sb.append("  ");
		sb.append(evaluateNextDuration);

		sb.append("\nevaluateRemaining:");
		sb.append(evaluateRemainingCalls);
		sb.append("  ");
		sb.append(evaluateRemainingDuration);

		sb.append("\ncallNext         :");
		sb.append(callNextCalls);
		sb.append("  ");
		sb.append(callNextDuration);

		sb.append("\ncallRemaining    :");
		sb.append(callRemainingCalls);
		sb.append("  ");
		sb.append(callRemainingDuration);

		sb.append("\ndoNext           :");
		sb.append(doNextCalls);
		sb.append("  ");
		sb.append(doNextDuration);

		sb.append("\ndoEnd            :");
		sb.append(doEndCalls);
		sb.append("  ");
		sb.append(doEndDuration);
		return sb.toString();
	}
}