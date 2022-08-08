

package live.shuuyu

import live.shuuyu.champagne.commands.CommandBase

class TestCommand : CommandBase("test") {
    override var alias: String = listOf("testing", "tust", "Ididthisfornoreasonidk").toString()
}