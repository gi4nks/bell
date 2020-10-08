package io.streamtune.bell.services.fallbacks;

import java.util.Collections;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import io.streamtune.bell.services.models.Label;


public class LabelFallback implements FallbackHandler<Label> {

    private static final Label EMPTY_LABEL = Label.of("empty", Collections.EMPTY_LIST);
    @Override
    public Label handle(ExecutionContext context) {
        return EMPTY_LABEL;
    }

}
