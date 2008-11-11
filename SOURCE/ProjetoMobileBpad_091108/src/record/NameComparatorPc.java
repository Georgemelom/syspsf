package record;

import javax.microedition.rms.RecordComparator;



public class NameComparatorPc implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		RecordPaciente c1 = new RecordPaciente(rec1);
		RecordPaciente c2 = new RecordPaciente(rec2);

		String s1 = c1.pcCns;
		String s2 = c2.pcCns;

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
