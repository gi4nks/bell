package io.streamtune.bell.commands;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
public class CreateNoteCommandTest {
    @Inject
    CreateNoteCommand command;

    @Test
    public void test_create() {
        command.note = "my note";
        command.labels = "label1,label2,label3";
        command.run();
    }
}