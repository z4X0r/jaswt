package jaswt.listener.selection;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import jaswt.core.Jaswt;
import jutilas.core.Jutilas;

/**
 * Class that extends SelectionAdapter for launch a System File Explorer
 * @author Andrea Serra
 *
 */
public class OpenFileFromOSSelectionAdapter extends SelectionAdapter {
	private Shell shellParent;
	private String path;

	/* ################################################################################# */
	/* START CONSTRUCT */
	/* ################################################################################# */

	/**
	 * constructor that sets Shell parent and path
	 * @param shellParent parent
	 * @param path to be open on file explorer
	 */
	public OpenFileFromOSSelectionAdapter(Shell shellParent, String path) {
		this.shellParent = shellParent;
		this.path = path;
	}

	/**
	 * constructor that sets Shell parent
	 * @param shellParent parent
	 */
	public OpenFileFromOSSelectionAdapter(Shell shellParent) {
		this.shellParent = shellParent;
	}

	/* ################################################################################# */
	/* END CONSTRUCT */
	/* ################################################################################# */

	/* ################################################################################# */
	/* START GET SET */
	/* ################################################################################# */

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	/* ################################################################################# */
	/* END GET SET */
	/* ################################################################################# */

	@Override
	public void widgetSelected(SelectionEvent se) {
		try {
			Jutilas.getInstance().openFileFromOS(path);
		} catch (Exception e) {
			Jaswt.getInstance().launchMBError(shellParent, e);
		}
	}
}
