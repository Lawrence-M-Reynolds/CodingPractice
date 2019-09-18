package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Backup;

public class BackupNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Backup> {

    @Override
    protected void handleNoteOrBackupOrForward(Backup noteOrBackupOrForward) {
        throw new UnsupportedOperationException("No implementation to process class type: " + noteOrBackupOrForward.getClass());
    }

}
