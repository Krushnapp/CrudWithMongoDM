package com.Alphaware.CrudWithMongoDM.CustomException;



public class CustomExceptions {

    public static class CustomException extends RuntimeException {

        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidDataException extends RuntimeException {

        public InvalidDataException(String message) {
            super(message);
        }
    }


}

