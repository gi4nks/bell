package io.streamtune.bell.services.fallbacks;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import io.streamtune.bell.services.models.Note;


public class NotesFallback implements FallbackHandler<List<Note>> {

    private static final List<Note> EMPTY_NOTES = Collections.EMPTY_LIST;
    @Override
    public List<Note> handle(ExecutionContext context) {
        return EMPTY_NOTES;
    }

}
