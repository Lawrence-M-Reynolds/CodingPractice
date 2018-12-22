package com.reynolds.lawrence.midi.composition;

import javax.sound.midi.Sequence;

public class CompositionMetaData {

	private final int[] supportedMidiFileTypes;
	private final float divisionType;
	private final int resolution;

	public CompositionMetaData(final int[] supportedMidiFileTypes, final float divisionType, final int resolution) {
		this.supportedMidiFileTypes = supportedMidiFileTypes;
		this.divisionType = divisionType;
		this.resolution = resolution;
	}

	/*
	 * We expect to only work in "pulses (ticks) per quarter note". Not frames per
	 * second.
	 */
	public boolean isPPQ() {
		return this.divisionType == Sequence.PPQ;
	}

	/* This is ticks per beat. */
	public int resolution() {
		return this.resolution;
	}

	public boolean isMidiFileTypeSupported(final int midiFileType) {
		for (final int type : this.supportedMidiFileTypes) {
			if (type == midiFileType) {
				return true;
			}
		}
		return false;
	}
}
