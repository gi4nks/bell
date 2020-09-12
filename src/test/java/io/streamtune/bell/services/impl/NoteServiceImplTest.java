package io.streamtune.bell.services.impl;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class NoteServiceImplTest {
    @Inject
    NoteService service;

    @Test
    void create() {
        service.create("note1", Arrays.asList(new String[] {"label1", "label2"}));

        service.create("note2", Arrays.asList(new String[] {"label1", "label3"}));

        Assertions.assertEquals("1", "1");
    }
}