package Negocio;

import Persistencia.*;

/**
 *
 * @author Ryzen 5
 */
public class NegocioException extends Exception
{

    /**
     *
     * @param ex
     */
    public NegocioException(String ex)
    {
        super(ex);
    }
}
