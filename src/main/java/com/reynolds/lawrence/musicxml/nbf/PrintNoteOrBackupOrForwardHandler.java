package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Print;

public class PrintNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Print> {

    @Override
    protected void handleNoteOrBackupOrForward(Print noteOrBackupOrForward) {
        /* TODO */
        System.out.println("Processing: " + noteOrBackupOrForward.getClass());
    }

}
