#Understanding midi

##Reference
- [API](https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/MidiEvent.html)
- [Midi Message bytes](https://www.midi.org/specifications/item/table-1-summary-of-midi-message)
- [Midi notes](http://www.indiana.edu/~emusic/etext/MIDI/chapter3_MIDI4.shtml)


- [Midi overview](https://www.recordingblogs.com/wiki/musical-instrument-digital-interface-midi)
- [Midi Header](https://www.recordingblogs.com/wiki/header-chunk-of-a-midi-file)
- [MIDI event (4 types)](https://www.recordingblogs.com/wiki/midi-event)
  - [MIDI meta messages](https://www.recordingblogs.com/wiki/midi-meta-messages)
    - Only exist in midi files. Never sent in real-time over ports.
    - Message consists of: Status, Meta type, length, data. 
      - Always have a status byte of 0xFF.
      - Meta type byte may indicate it is for a key change for example.
  - [MIDI voice messages](https://www.recordingblogs.com/wiki/midi-voice-messages)
    - Status byte specific to the type of voice message. For each value refer to
    [Status byte](https://www.recordingblogs.com/wiki/status-byte-of-a-midi-message). 
    - Note these messages are associated with a channel, and the channel number is stored in the lower 4 bits of the
    status byte (providing a possible association with 0-16 channels). So the actual type of the message can be
    determined by masking the status byte with 0xF0. 
  - [MIDI system common messages](https://www.recordingblogs.com/wiki/midi-system-common-messages) /
  [MIDI system realtime messages](https://www.recordingblogs.com/wiki/midi-system-realtime-messages)
    - It's not clear whether these are ever expected in MIDI files. But the reset message also has a status byte of
    0xFF. Considering the name, it appears as though these would only be sent over ports and not within midi files. And
    perhaps system common messages are expected within both cases.

##Points to note:
Status byte may not always be present. Turning notes off may sometimes be carried out using the velocity:
>It is permitted in the MIDI protocol to omit the status byte of a MIDI message. If the status byte is omitted, it
will be assumed to be the same as the status byte of the message in the previous event. Most commonly, after sending /
receiving a note on message with some velocity to play a note, MIDI devices can send or receive a note on message with
zero velocity to turn off that same note. The status byte of the second note on message can be omitted as it is the
same as the status byte of the previous note on message (assuming there are no messages in between).

##Interpreting the messages.

