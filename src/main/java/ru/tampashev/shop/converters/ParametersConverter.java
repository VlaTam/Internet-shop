package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.entities.ParametersEntity;

@Component("parametersConverter")
@SuppressWarnings("all")
public class ParametersConverter implements Converter<ParametersEntity, Parameters> {

    @Override
    public Parameters convertToDto(ParametersEntity parametersEntity) {
        Parameters parameters = new Parameters();
        parameters.setId(parametersEntity.getId());
        parameters.setBrand(parametersEntity.getBrand());
        parameters.setWidth(parametersEntity.getWidth());
        parameters.setHeight(parametersEntity.getHeight());
        parameters.setRadius(parametersEntity.getRadius());
        return parameters;
    }

    @Override
    public ParametersEntity convertToEntity(Parameters parameters) {
        ParametersEntity parametersEntity = new ParametersEntity();
        parametersEntity.setId(parameters.getId());
        parametersEntity.setBrand(parameters.getBrand());
        parametersEntity.setWidth(parameters.getWidth());
        parametersEntity.setHeight(parameters.getHeight());
        parametersEntity.setRadius(parameters.getRadius());
        return parametersEntity;
    }
}
