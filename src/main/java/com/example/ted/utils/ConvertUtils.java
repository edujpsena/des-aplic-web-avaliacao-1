package com.example.ted.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public record ConvertUtils<T>(ModelMapperConfiguration modelMapperConfiguration) {

    public List<T> convertToListResponse(List<T> responses, Class<T> type) {
        return responses
                    .stream()
                    .map(response -> modelMapperConfiguration.modelMapper().map(response, type))
                    .collect(Collectors.toList());
    }

    public T convertRequestToEntity(T request, Class<T> type) {
        return modelMapperConfiguration.modelMapper().map(request, type);
    }

    public T convertEntityToResponse(T entity, Class<T> type) {
        return modelMapperConfiguration.modelMapper().map(entity, type);
    }

}
