package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Note;

public class NoteNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Note> {

    @Override
    protected void handleNoteOrBackupOrForward(Note noteOrBackupOrForward) {
        /* TODO */
        System.out.println("Processing: " + noteOrBackupOrForward.getClass());
    }

}
