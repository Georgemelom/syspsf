package record;

import javax.microedition.rms.RecordComparator;

import midlet.Ficha;

public class NameComparatorFd implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Ficha c1 = new Ficha(rec1);
		Ficha c2 = new Ficha(rec2);

		String s1 = c1.fdID;
		String s2 = c2.fdID;

		if (s1.compareTo(s2) == 0) {
			return RecordComparator.EQUIVALENT;
		} else if (s1.compareTo(s2) > 0) {
			System.out.println(c1 + " then " + c2);
			return RecordComparator.FOLLOWS;
		} else {
			System.out.println(c2 + " then " + c1);
			return RecordComparator.PRECEDES;
		}
	}
}
