package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Barline;

public class BarlineNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Barline> {

    @Override
    protected void handleNoteOrBackupOrForward(Barline noteOrBackupOrForward) {
        /* TODO */
        System.out.println("Processing: " + noteOrBackupOrForward.getClass());
    }

}
