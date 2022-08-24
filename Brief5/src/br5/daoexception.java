package br5;

public class daoexception extends RuntimeException {

	public daoexception( String message ) {
        super( message );
    }

    public daoexception( String message, Throwable cause ) {
        super( message, cause );
    }

    public daoexception( Throwable cause ) {
        super( cause );
    }
}
