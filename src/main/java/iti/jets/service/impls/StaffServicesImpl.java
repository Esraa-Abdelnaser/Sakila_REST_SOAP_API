package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Staff;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.StaffRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.StaffDto;
import iti.jets.service.interfaces.StaffServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.StaffMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StaffServicesImpl implements StaffServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    StaffRepoImpl actorRepoImpl = new StaffRepoImpl(entityManager);
    StaffMapper mapper = StaffMapper.INSTANCE;

    @Override
    public List<StaffDto> getAll() {
        List<Staff> listOfStaff = actorRepoImpl.getAll();
        List<StaffDto> listOfStaffDto = new ArrayList<>();
        for (Staff staff : listOfStaff) {
            listOfStaffDto.add(mapper.toDto(staff));
        }
        return listOfStaffDto;
    }

    @Override
    public StaffDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(StaffDto staffDto) {
        actorRepoImpl.insert(mapper.toEntity(staffDto));
    }

    @Override
    public void update(StaffDto staffDto) {
        actorRepoImpl.update(mapper.toEntity(staffDto));
    }

    @Override
    public void delete(StaffDto staffDto) {
        actorRepoImpl.delete(mapper.toEntity(staffDto));
    }
}
