package io.streamtune.bell.commands;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class GetNoteCommandTest {

    @Inject
    GetNoteCommand command;

    @Test
    public void test_create() {
        command.id = "1";
        command.run();
    }
}