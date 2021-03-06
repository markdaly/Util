/*---------------------------------------------------------------
*  Copyright 2014 by the Radiological Society of North America
*
*  This source software is released under the terms of the
*  RSNA Public License (http://mirc.rsna.org/rsnapubliclicense)
*----------------------------------------------------------------*/

package org.rsna.ui;

import java.awt.AWTEvent;
import java.io.File;

/**
 * The event that passes the result of a file operation to FileListeners.
 */
public class FileEvent extends AWTEvent {

	public static final int FILE_EVENT = AWTEvent.RESERVED_ID_MAX + 4269;
	public static final int NULL = 0;
	public static final int SELECT = 1;
	public static final int DELETE = 2;
	public static final int STORE = 3;
	public static final int MOVE = 4;

	public final File file;
	public final File dest;
	public final int type;

	/**
	 * Private class constructor capturing a file event.
	 * @param source the source of the event.
	 * @param type the type of the event.
	 * @param file the file on which the event occurred.
	 * @param dest the destination file (only when the event is a MOVE).
	 */
	private FileEvent(Object source, int type, File file, File dest) {
		super(source, FILE_EVENT);
		this.type = type;
		this.file = file;
		this.dest = dest;
	}

	/**
	 * Get a FileEvent capturing a SELECT file event.
	 * @param source the source of the event.
	 * @param file the file on which the event occurred.
	 */
	public static FileEvent SELECT(Object source, File file) {
		return new FileEvent(source, SELECT, file, null);
	}

	/**
	 * Get a FileEvent capturing a DELETE file event.
	 * @param source the source of the event.
	 * @param file the file on which the event occurred.
	 */
	public static FileEvent DELETE(Object source, File file) {
		return new FileEvent(source, DELETE, file, null);
	}

	/**
	 * Get a FileEvent capturing a STORE file event.
	 * @param source the source of the event.
	 * @param file the file on which the event occurred.
	 */
	public static FileEvent STORE(Object source, File file) {
		return new FileEvent(source, STORE, file, null);
	}

	/**
	 * Get a FileEvent capturing a MOVE file event.
	 * @param source the source of the event.
	 * @param from the original location of the file which was moved.
	 * @param to the final location of the file which was moved.
	 */
	public static FileEvent MOVE(Object source, File from, File to) {
		return new FileEvent(source, MOVE, from, to);
	}

	public File getFile() {
		return file;
	}

	public File getDestination() {
		return dest;
	}

	public boolean isSELECT() {
		return (type == SELECT);
	}

	public boolean isDELETE() {
		return (type == DELETE);
	}

	public boolean isSTORE() {
		return (type == STORE);
	}

	public boolean isMOVE() {
		return (type == MOVE);
	}

}
