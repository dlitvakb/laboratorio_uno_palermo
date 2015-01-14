package utils;

import java.sql.SQLException;

public class CouldNotSaveException extends RuntimeException {
    public CouldNotSaveException(SQLException e) {
        super(e);
    }

    /**
	 * 
	 */
    private static final long serialVersionUID = -4601029174092995754L;
}
