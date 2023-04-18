package iti.jets.service.impls;

import iti.jets.database.entities.Staff;
import iti.jets.database.repos.impls.StaffRepoImpl;
import iti.jets.service.dtos.StaffDto;
import iti.jets.service.interfaces.StaffServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.StaffMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StaffServicesImpl implements StaffServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    StaffRepoImpl staffRepo = new StaffRepoImpl(entityManager);
    StaffMapper mapper = StaffMapper.INSTANCE;

    @Override
    public List<StaffDto> getAll() {
        List<Staff> listOfStaff = staffRepo.getAll();
        List<StaffDto> listOfStaffDto = new ArrayList<>();
        for (Staff staff : listOfStaff) {
            listOfStaffDto.add(mapper.toDto(staff));
        }
        return listOfStaffDto;
    }

    @Override
    public StaffDto getById(Integer id) {
        return mapper.toDto(staffRepo.getById(id));
    }

    @Override
    public void insert(StaffDto staffDto) {
        staffRepo.insert(mapper.toEntity(staffDto));
    }

    @Override
    public void update(StaffDto staffDto) {
        staffRepo.update(mapper.toEntity(staffDto));
    }

    @Override
    public void delete(StaffDto staffDto) {
        staffRepo.delete(staffRepo.getById(staffDto.getId()));
    }
}
