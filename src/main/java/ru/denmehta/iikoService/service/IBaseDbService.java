package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.List;

public interface IBaseDbService<T, M> {

    default List<T> findAll(){
       return getRepository().findAll();
    };

    default void save(T entity){
        getRepository().save(entity);
    }

    default void delete(M id){
        getRepository().delete(getById(id));
    };

    default T getById(M id){
        return getRepository().findById(id).orElseThrow(() -> new RestApiException(HttpStatus.NOT_FOUND, getName() + " not found"));
    }

    default void deleteById(M id) {
        getRepository().delete(getById(id));
    }

    String getName();

    JpaRepository<T, M> getRepository();

}
