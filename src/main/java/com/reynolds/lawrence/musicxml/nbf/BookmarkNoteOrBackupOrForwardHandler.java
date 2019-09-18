package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Bookmark;

public class BookmarkNoteOrBackupOrForwardHandler extends BaseNoteOrBackupOrForwardHandler<Bookmark> {

    @Override
    protected void handleNoteOrBackupOrForward(Bookmark noteOrBackupOrForward) {
        throw new UnsupportedOperationException("No implementation to process class type: " + noteOrBackupOrForward.getClass());
    }

}
