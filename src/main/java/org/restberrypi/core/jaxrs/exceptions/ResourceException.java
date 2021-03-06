package org.restberrypi.core.jaxrs.exceptions;

/**
 * Generic exception that can be thrown by a REST resource interface.
 */
public class ResourceException extends Exception {

	private static final long serialVersionUID = 3064239701419273259L;

	public ResourceException() {
	}

	public ResourceException(String message) {
		super(message);
	}

	public ResourceException(Throwable cause) {
		super(cause);
	}

	public ResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
