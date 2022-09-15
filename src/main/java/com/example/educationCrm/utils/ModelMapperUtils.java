package com.example.educationCrm.utils;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtils {

    @Autowired
    private ModelMapper modelMapper;

    public <T,K> T convertToModel(K obje,Class<T> classObject) {
        T convertedObje = modelMapper
                .map(obje, classObject);
        return convertedObje;
    }

    public <D ,T> List<D> mapAll(final Collection<T> entityList,
                                 Class<D> outClass){
        return entityList.stream()
                .map(entity->convertToModel(entity,outClass))
                .collect(Collectors.toList());
    }

}

