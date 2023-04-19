package iti.jets.service.impls;

import iti.jets.database.entities.Category;
import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmCategory;
import iti.jets.database.repos.impls.CategoryRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.interfaces.CategoryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.CategoryMapper;
import iti.jets.utils.mappers.FilmMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CategoryServicesImpl implements CategoryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CategoryRepoImpl categoryRepo = new CategoryRepoImpl(entityManager);
    CategoryMapper mapper = CategoryMapper.INSTANCE;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> listOfCategories = categoryRepo.getAll();
        List<CategoryDto> listOfCategoriesDto = new ArrayList<>();
        for (Category category : listOfCategories) {
            listOfCategoriesDto.add(mapper.toDto(category));
        }
        return listOfCategoriesDto;
    }

    @Override
    public CategoryDto getById(Integer id) {
        return mapper.toDto(categoryRepo.getById(id));
    }

    @Override
    public List<FilmDto> getCategoryForActor(CategoryDto categoryDto) {
        List<FilmCategory> listOfFilmCategory = categoryRepo.getById(mapper.toEntity(categoryDto).getId()).getFilmCategoryList();
        List<FilmDto> listOfFilm = new ArrayList<>();
        FilmMapper filmMapper = FilmMapper.INSTANCE;
        for (FilmCategory filmCategory: listOfFilmCategory) {
            listOfFilm.add(filmMapper.toDto(filmCategory.getFilm()));
        }
        return listOfFilm;
    }

    @Override
    public void insert(CategoryDto categoryDto) {
        categoryDto.setLastUpdate(Instant.now());
        categoryRepo.insert(mapper.toEntity(categoryDto));
    }

    @Override
    public void update(CategoryDto categoryDto) {
        categoryDto.setLastUpdate(Instant.now());
        categoryRepo.update(mapper.toEntity(categoryDto));
    }

    @Override
    public void delete(CategoryDto categoryDto) {
        categoryRepo.delete(categoryRepo.getById(categoryDto.getId()));
    }
}
