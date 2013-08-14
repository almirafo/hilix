package br.com.supportcomm.freecall.exception;

public class FreeCallException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public FreeCallException()
    {
        super();
    }

    public FreeCallException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FreeCallException(String message)
    {
        super(message);
    }

    public FreeCallException(Throwable cause)
    {
        super(cause);
    }

}
