package live.shuuyu.champagne.system

object GetSystemInfo {
    val getOS = try {
        System.getProperty("os.name")
    } catch (e: SecurityException) {
        null
    }

    /**
     * Executes something if the system OS is
     * detected to be windows.
     *
     * @since 0.1-SNAPSHOT
     */
    val isWindows = getOS != null && getOS.startsWith("Windows")
}