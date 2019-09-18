package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Attributes;

public class AttributesNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Attributes> {

    @Override
    protected void handleNoteOrBackupOrForward(Attributes noteOrBackupOrForward) {
        /* TODO */
        System.out.println("Processing: " + noteOrBackupOrForward.getClass());
    }

}
