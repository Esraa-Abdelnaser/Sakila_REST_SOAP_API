package iti.jets.utils.mappers;

import iti.jets.database.entities.Staff;
import iti.jets.service.dtos.StaffDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper( StaffMapper.class );
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffDto staffDto, @MappingTarget Staff staff);
}