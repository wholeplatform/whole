package org.whole.lang.iterators.instrumentation;

import java.time.Duration;
import java.time.Instant;

import org.whole.lang.operations.ICloneContext;

public class ProfilerData extends AbstractInstrumentationData {
	public int cloneCalls;
	public int setBindingsCalls;
	public int resetCalls;
	public int hasNextCalls;
	public int lookaheadCalls;
	public int nextCalls;

	public Duration cloneDuration = Duration.ZERO;
	public Duration setBindingsDuration = Duration.ZERO;
	public Duration resetDuration = Duration.ZERO;
	public Duration hasNextDuration = Duration.ZERO;
	public Duration lookaheadDuration = Duration.ZERO;
	public Duration nextDuration = Duration.ZERO;

	@Override
	public ProfilerData clone(ICloneContext cc) {
		ProfilerData data = (ProfilerData) super.clone(cc);
		data.cloneDuration = Duration.from(cloneDuration);
		data.setBindingsDuration = Duration.from(setBindingsDuration);
		data.resetDuration = Duration.from(resetDuration);
		data.hasNextDuration = Duration.from(hasNextDuration);
		data.lookaheadDuration = Duration.from(lookaheadDuration);
		data.nextDuration = Duration.from(nextDuration);
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
		sb.append("\nclone      :");
		sb.append(cloneCalls);
		sb.append("  ");
		sb.append(cloneDuration);

		sb.append("\nsetBindings:");
		sb.append(setBindingsCalls);
		sb.append("  ");
		sb.append(setBindingsDuration);

		sb.append("\nreset      :");
		sb.append(resetCalls);
		sb.append("  ");
		sb.append(resetDuration);

		sb.append("\nhasNext    :");
		sb.append(hasNextCalls);
		sb.append("  ");
		sb.append(hasNextDuration);

		sb.append("\nlookahead  :");
		sb.append(lookaheadCalls);
		sb.append("  ");
		sb.append(lookaheadDuration);

		sb.append("\nnext       :");
		sb.append(nextCalls);
		sb.append("  ");
		sb.append(nextDuration);
		return sb.toString();
	}
}