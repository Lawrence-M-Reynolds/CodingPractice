package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Harmony;

public class HarmonyNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Harmony> {

    @Override
    protected void handleNoteOrBackupOrForward(Harmony noteOrBackupOrForward) {
        throw new UnsupportedOperationException("No implementation to process class type: " + noteOrBackupOrForward.getClass());
    }

}
