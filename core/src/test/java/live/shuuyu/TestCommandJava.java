package live.shuuyu;

import live.shuuyu.champagne.commands.CommandBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TestCommandJava extends CommandBase {

    public TestCommandJava(@NotNull String name, @Nullable String description) {
        super(name, description);
    }
}