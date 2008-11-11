package record;

import javax.microedition.rms.RecordFilter;


public class NameFilterPc implements RecordFilter {
	public String criteria;
	NameComparatorPc orderby;

	public NameFilterPc(NameComparatorPc orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new RecordPaciente(candidate).pcCns.startsWith(criteria);
	}
}
