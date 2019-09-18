package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Forward;

public class ForwardNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Forward> {

    @Override
    protected void handleNoteOrBackupOrForward(Forward noteOrBackupOrForward) {
        throw new UnsupportedOperationException("No implementation to process class type: " + noteOrBackupOrForward.getClass());
    }

}
