package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Category;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.CategoryRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.interfaces.CategoryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.CategoryMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CategoryServicesImpl implements CategoryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CategoryRepoImpl actorRepoImpl = new CategoryRepoImpl(entityManager);
    CategoryMapper mapper = CategoryMapper.INSTANCE;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> listOfCategories = actorRepoImpl.getAll();
        List<CategoryDto> listOfCategoriesDto = new ArrayList<>();
        for (Category category : listOfCategories) {
            listOfCategoriesDto.add(mapper.toDto(category));
        }
        return listOfCategoriesDto;
    }

    @Override
    public CategoryDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(CategoryDto categoryDto) {
        actorRepoImpl.insert(mapper.toEntity(categoryDto));
    }

    @Override
    public void update(CategoryDto categoryDto) {
        actorRepoImpl.update(mapper.toEntity(categoryDto));
    }

    @Override
    public void delete(CategoryDto categoryDto) {
        actorRepoImpl.delete(mapper.toEntity(categoryDto));
    }
}
