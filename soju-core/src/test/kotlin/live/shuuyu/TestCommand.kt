

package live.shuuyu

import live.shuuyu.soju.commands.CommandBase
import live.shuuyu.soju.commands.CommandContext

class TestCommand : CommandBase(
    name = "test",
) {
    override suspend fun execute(ctx: CommandContext) {
        TODO("Not yet implemented")
    }
}