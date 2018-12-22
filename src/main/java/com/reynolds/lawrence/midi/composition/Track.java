package com.reynolds.lawrence.midi.composition;

import java.util.ArrayList;
import java.util.List;

import com.reynolds.lawrence.midi.composition.event.NoteEvent;
import com.reynolds.lawrence.midi.composition.event.TrackEvent;

public class Track {

	List<TrackEvent> metaEvents = new ArrayList<>();
	List<TrackEvent> systemExclusiveEvents = new ArrayList<>();
	List<TrackEvent> trackEvents = new ArrayList<>();
	List<NoteEvent> noteEvents = new ArrayList<>();

	public void addMetaEvent(final TrackEvent metaEvent) {
		this.metaEvents.add(metaEvent);
	}

	public void addSystemExclusiveEvent(final TrackEvent otherEvent) {
		this.systemExclusiveEvents.add(otherEvent);
	}

	public void addTrackEvent(final TrackEvent trackEvent) {
		this.trackEvents.add(trackEvent);
	}

	public void addNoteEvent(final NoteEvent metaEvent) {
		this.noteEvents.add(metaEvent);
	}

}
