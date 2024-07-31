package xy.christina.game.util

import java.time.LocalTime
import java.time.format.{DateTimeFormatter, DateTimeParseException}

object TimeUtil {
  val TIME_PATTERN = "HH:mm:ss"
  val TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN)

  implicit class TimeFormatter(val time: LocalTime) {

    /**
     * Returns the given time as a well formatted String.
     *
     * @param time the time to be returned as a string
     * @return formatted string
     */
    def asString: String = {
      if (time == null) {
        return null
      }
      TIME_FORMATTER.format(time)
    }
  }

  implicit class StringFormatter(val data: String) {

    /**
     * Converts a String in the format of the defined TIME_PATTERN
     * to a LocalTime object.
     *
     * Returns null if the String could not be converted.
     *
     * @param timeString the time as String
     * @return the time object or null if it could not be converted
     */
    def parseLocalTime: LocalTime = {
      try {
        LocalTime.parse(data, TIME_FORMATTER)
      } catch {
        case e: DateTimeParseException => null
      }
    }

    /**
     * Checks if the string is a valid time based on the TIME_PATTERN.
     *
     * @param timeString the time as String
     * @return true if valid, false otherwise
     */
    def isValidTime: Boolean = {
      data.parseLocalTime != null
    }
  }
}
