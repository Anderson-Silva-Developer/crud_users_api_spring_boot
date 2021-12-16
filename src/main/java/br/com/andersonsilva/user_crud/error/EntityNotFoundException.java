package br.com.andersonsilva.user_crud.error;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msm) {
        super(msm);
    }

}
