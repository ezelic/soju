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

package live.shuuyu.soju.system

object GetSystemInfo {
    val getOs = try {
        System.getProperty("os.name")
    } catch (e: SecurityException) {
        throw SecurityException("")
    }

    /**
     * Executes something if the system OS is
     * detected to be windows.
     *
     * @since 0.1-SNAPSHOT
     * @author yujin
     */
    val isWindows = getOs != null && getOs.startsWith("Windows")

    /**
     * Executes something if the system OS is detected
     * to be MacOS.
     *
     * @since 0.1-SNAPSHOT
     * @author yujin
     */
    val isMacOS = getOs != null && getOs.startsWith("MacOS")
    

    /**
     * Executes something if the system OS is detected
     * to be Linux, and if the correct distributions match.
     *
     * @since 0.1-SNAPSHOT
     * @author yujin
     */
    val isLinux = getOs != null && getOs.startsWith("linux")

    /**
     * Determines the distribution of Linux. This includes:
     * Arch (aarch64)
     * Debian
     */

    /**
     * Checks if you have dark mode enabled in either
     * MacOS, Windows, or Linux, then executes if dark mode
     * is enabled.
     *
     * @since 0.1-SNAPSHOT
     * @author yujin
     */


}