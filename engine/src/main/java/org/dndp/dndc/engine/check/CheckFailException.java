package org.dndp.dndc.engine.check;

/**
 * Wyjątek nie spełnienia warunków.
 * 
 * Stworzony na wewnętrzne potrzeby programu,
 * tylko po to by wewnętrzne catche były ładne.
 * 
 * @author bambucha
 */
public class CheckFailException extends Exception
{

    /**
     * 
     */
    public CheckFailException()
    {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public CheckFailException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message
     */
    public CheckFailException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public CheckFailException(Throwable cause)
    {
        super(cause);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
