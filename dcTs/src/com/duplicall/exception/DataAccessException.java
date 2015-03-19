package com.duplicall.exception;

import java.sql.SQLException;

public class DataAccessException extends SQLException
{
 private static final long serialVersionUID = 1L;
    
    public DataAccessException()
    {
        super();
    }
    
    public DataAccessException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DataAccessException(String message)
    {
        super(message);
    }
    
    public DataAccessException(Throwable cause)
    {
        super(cause);
    }
}
