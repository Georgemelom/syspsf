package record;

import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreNotOpenException;

public class ChangeNotifierPc implements RecordListener {
	public void recordAdded(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Adcionado registro para " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordChanged(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Alterado o registro no " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordDeleted(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Deletado registro de " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}
}
