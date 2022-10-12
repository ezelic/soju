package live.shuuyu;

import live.shuuyu.soju.commands.CommandBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestCommandJava extends CommandBase {

    public TestCommandJava(@NotNull String name, @Nullable List<String> alias, @Nullable String description) {
        super(name, alias, description);
    }
}