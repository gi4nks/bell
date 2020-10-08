package io.streamtune.bell.services.fallbacks;

import java.time.Instant;
import java.util.Collections;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import io.streamtune.bell.services.models.Note;


public class NoteFallback implements FallbackHandler<Note> {

    private static final Note EMPTY_NOTE = Note.of("empty", Collections.EMPTY_LIST, Instant.now());
    @Override
    public Note handle(ExecutionContext context) {
        return EMPTY_NOTE;
    }

}
