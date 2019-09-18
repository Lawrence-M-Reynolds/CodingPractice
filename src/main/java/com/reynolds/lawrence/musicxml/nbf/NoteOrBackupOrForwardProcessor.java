package com.reynolds.lawrence.musicxml.nbf;

import com.reynolds.lawrence.musicxml.generatedModel.Note;
import com.reynolds.lawrence.musicxml.generatedModel.Backup;
import com.reynolds.lawrence.musicxml.generatedModel.Forward;
import com.reynolds.lawrence.musicxml.generatedModel.Direction;
import com.reynolds.lawrence.musicxml.generatedModel.Attributes;
import com.reynolds.lawrence.musicxml.generatedModel.Harmony;
import com.reynolds.lawrence.musicxml.generatedModel.FiguredBass;
import com.reynolds.lawrence.musicxml.generatedModel.Print;
import com.reynolds.lawrence.musicxml.generatedModel.Sound;
import com.reynolds.lawrence.musicxml.generatedModel.Barline;
import com.reynolds.lawrence.musicxml.generatedModel.Grouping;
import com.reynolds.lawrence.musicxml.generatedModel.Link;
import com.reynolds.lawrence.musicxml.generatedModel.Bookmark;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NoteOrBackupOrForwardProcessor {

    private static Map<Class, ? extends BaseNoteOrBackupOrForwardHandler> handlerRegister;

    static {

        Map<Class, BaseNoteOrBackupOrForwardHandler> handlerRegisterTemp = new HashMap<>();
        handlerRegisterTemp.put(Note.class, new NoteNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Backup.class, new BackupNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Forward.class, new ForwardNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Direction.class, new DirectionNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Attributes.class, new AttributesNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Harmony.class, new HarmonyNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(FiguredBass.class, new FiguredBassNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Print.class, new PrintNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Sound.class, new SoundNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Barline.class, new BarlineNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Grouping.class, new GroupingNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Link.class, new LinkNoteOrBackupOrForwardHandler());
        handlerRegisterTemp.put(Bookmark.class, new BookmarkNoteOrBackupOrForwardHandler());

        handlerRegister = Collections.unmodifiableMap(handlerRegisterTemp);

    }

    public static void process(Object noteOrBackupOrForwardValue) {
        Class type = noteOrBackupOrForwardValue.getClass();

        BaseNoteOrBackupOrForwardHandler handler = handlerRegister.get(type);
        if(handler == null) {
            throw new IllegalArgumentException("No handler for class type: [" + type +
                    "], Object: " + noteOrBackupOrForwardValue);
        } else {
            handler.invoke(noteOrBackupOrForwardValue);
        }

    }

}
