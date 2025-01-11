package com.jpacourse.mapper;
import java.util.stream.Collectors;
import com.jpacourse.dto.ToDoctor;
import com.jpacourse.persistence.entity.DoctorEntity;

public final class MapperDoctor
{

    public static ToDoctor mapToTO(final DoctorEntity doctorEntity)
    {
        if (doctorEntity == null) {return null; }

        final ToDoctor todoctor = new ToDoctor();
        todoctor.setId(doctorEntity.getId());
        todoctor.setFirstName(doctorEntity.getFirstName());
        todoctor.setLastName(doctorEntity.getLastName());
        todoctor.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        todoctor.setEmail(doctorEntity.getEmail());
        todoctor.setDoctorNumber(doctorEntity.getDoctorNumber());
        todoctor.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        todoctor.setSpecialization(doctorEntity.getSpecialization());

        return todoctor;
    }

    public static DoctorEntity mapToEntity(final ToDoctor todoctor)
    {
        if(todoctor == null)
        {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId(todoctor.getId());
        doctorEntity.setFirstName(todoctor.getFirstName());
        doctorEntity.setLastName(todoctor.getLastName());
        doctorEntity.setTelephoneNumber(todoctor.getTelephoneNumber());
        doctorEntity.setEmail(todoctor.getEmail());
        doctorEntity.setDoctorNumber(todoctor.getDoctorNumber());
        doctorEntity.setAddress(AddressMapper.mapToEntity(todoctor.getAddress()));
        doctorEntity.setSpecialization(todoctor.getSpecialization());
        return doctorEntity;
    }
}
