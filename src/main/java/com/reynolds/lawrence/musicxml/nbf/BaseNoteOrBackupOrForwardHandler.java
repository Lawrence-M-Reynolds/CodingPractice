package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Note;

public abstract class BaseNoteOrBackupOrForwardHandler<T> {

    void invoke(Object noteOrBackupOrForwardValueObject) {
        T noteOrBackupOrForwardValue = (T) noteOrBackupOrForwardValueObject;

        handleNoteOrBackupOrForward(noteOrBackupOrForwardValue);
    }

    protected abstract void handleNoteOrBackupOrForward(T noteOrBackupOrForward);

}
