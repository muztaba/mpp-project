package com.mpp.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandParserTest {

    @Test
    public void parseCommand() {
        // setup
        String loginCmd = "login username password";
        CommandParser cp = new CommandParser();

        // when
        Command actual = cp.parse(loginCmd);

        // then
        Assertions.assertThat(actual).isEqualByComparingTo(Command.LOGIN);
    }

}
