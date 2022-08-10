package live.shuuyu

import live.shuuyu.soju.commands.CommandBase
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

public class TestCommandGroovy extends CommandBase {
     TestCommandGroovy(@NotNull String name, @Nullable String description) {
        super(name, description)
    }
}