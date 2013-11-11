package utils;

import java.sql.SQLException;

public class NotFoundException extends RuntimeException {

	public NotFoundException(SQLException e) {
		super(e);
	}

	public NotFoundException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3084169823543317917L;

}
