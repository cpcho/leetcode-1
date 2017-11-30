package string;

/**
 * 
 * Problem:
 * 
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 'A' : Absent. 'L' : Late. 'P' : Present. A student could be rewarded if his
 * attendance record doesn't contain more than one 'A' (absent) or more than two
 * continuous 'L' (late).
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1: Input: "PPALLP" Output: True
 * 
 * Example 2: Input: "PPALLL" Output: False
 *
 */
public class _551_StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int A = 0;
		int L = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				A++;
				L = 0;
				if (A > 1) {
					return false;
				}
			} else if (s.charAt(i) == 'L') {
				L++;
				if (L > 2) {
					return false;
				}
			} else {
				L = 0;
			}
		}
		return true;
	}
}
