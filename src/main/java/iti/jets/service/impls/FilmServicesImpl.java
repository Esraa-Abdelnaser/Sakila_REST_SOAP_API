package iti.jets.service.impls;

import iti.jets.database.entities.Film;
import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmCategory;
import iti.jets.database.repos.impls.FilmRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.interfaces.FilmServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.CategoryMapper;
import iti.jets.utils.mappers.FilmMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FilmServicesImpl implements FilmServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    FilmRepoImpl filmRepo = new FilmRepoImpl(entityManager);
    FilmMapper mapper = FilmMapper.INSTANCE;

    @Override
    public List<FilmDto> getAll() {
        List<Film> listOfFilms = filmRepo.getAll();
        List<FilmDto> listOfFilmDto = new ArrayList<>();
        for (Film film : listOfFilms) {
            listOfFilmDto.add(mapper.toDto(film));
        }
        return listOfFilmDto;
    }

    @Override
    public List<ActorDto> getActorsForFilm(FilmDto FilmDto) {
        List<FilmActor> listOfFilmActor = filmRepo.getById(mapper.toEntity(FilmDto).getId()).getFilmActorList();
        List<ActorDto> listOfActors = new ArrayList<>();
        ActorMapper actorMapper = ActorMapper.INSTANCE;
        for (FilmActor filmActor : listOfFilmActor) {
            listOfActors.add(actorMapper.toDto(filmActor.getActor()));
        }
        return listOfActors;
    }

    @Override
    public List<CategoryDto> getCategoriesForFilm(FilmDto FilmDto) {
        List<FilmCategory> listOfFilmCategory = filmRepo.getById(mapper.toEntity(FilmDto).getId()).getFilmCategoryList();
        List<CategoryDto> listOfCategories = new ArrayList<>();
        CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
        for (FilmCategory filmCategory : listOfFilmCategory) {
            listOfCategories.add(categoryMapper.toDto(filmCategory.getCategory()));
        }
        return listOfCategories;
    }

    @Override
    public FilmDto getById(Integer id) {
        return mapper.toDto(filmRepo.getById(id));
    }

    @Override
    public void insert(FilmDto filmDto) {
        filmDto.setLastUpdate(Instant.now());
        filmRepo.insert(mapper.toEntity(filmDto));
    }

    @Override
    public void update(FilmDto filmDto) {
        filmDto.setLastUpdate(Instant.now());
        filmRepo.update(mapper.toEntity(filmDto));
    }

    @Override
    public void delete(FilmDto filmDto) {

        filmRepo.delete(filmRepo.getById(filmDto.getId()));
    }
}
