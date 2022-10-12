/*
 * Champagne
 * Copyright (C) 2022 Shuuyu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package live.shuuyu.soju.chat

import java.awt.Color

/**
 * Special formatting that Minecraft has.
 * This is all based off of the Minecraft wiki.
 * I don't know where to turn to for this information that
 * I obviously couldn't store in my head.
 *
 * @since 0.1-SNAPSHOT
 * @author yujin
 */
enum class ChatFormatting(val color: Color) {
    BLACK(Color(0, 0 ,0))
}