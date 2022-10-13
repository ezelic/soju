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

package live.shuuyu.soju.keyboards


/**
 * All the keys on the keyboard according to LWJGL.
 * If you actually use a tenkey keyboard with all the
 * f1 - f 23 keys, please never speak to me.
 *
 * @since 0.1-SNAPSHOT
 * @author yujin
 */
enum class KeyboardEnum(val key: String, val lwjglKey: Int) {
}