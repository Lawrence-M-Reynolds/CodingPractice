package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Sound;

public class SoundNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Sound> {

    @Override
    protected void handleNoteOrBackupOrForward(Sound noteOrBackupOrForward) {
        throw new UnsupportedOperationException("No implementation to process class type: " + noteOrBackupOrForward.getClass());
    }

}
