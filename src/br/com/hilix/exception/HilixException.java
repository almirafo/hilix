package br.com.hilix.exception;

public class HilixException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public HilixException()
    {
        super();
    }

    public HilixException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public HilixException(String message)
    {
        super(message);
    }

    public HilixException(Throwable cause)
    {
        super(cause);
    }

}
