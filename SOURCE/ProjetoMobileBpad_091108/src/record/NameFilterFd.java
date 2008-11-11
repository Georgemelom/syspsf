package record;

import javax.microedition.rms.RecordFilter;

import midlet.Ficha;

public class NameFilterFd implements RecordFilter {
	public String criteria;
	NameComparatorFd orderby;

	public NameFilterFd(NameComparatorFd orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new Ficha(candidate).fdID.startsWith(criteria);
	}
}
