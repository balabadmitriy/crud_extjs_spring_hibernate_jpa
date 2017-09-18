package com.camera.of.city.mvc.dao.impl;

import com.camera.of.city.mvc.dao.AbstractDAO;
import com.camera.of.city.mvc.domain.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class PhotoDAO extends AbstractDAO<Photo>{

    public PhotoDAO() {
        super(Photo.class);
    }

    @Transactional
    public boolean update(Photo photo){
        List<Photo> cameras = searchPhoto(photo.getCamera().getIdDevice().toString());
        if (cameras != null && cameras.size()!=0) {
            try {
                Files.delete(Paths.get(cameras.get(0).getUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            cameras.get(0).setUrl(photo.getUrl());
            getEntityManager().merge(cameras.get(0));
            return true;
        }
        return false;
    }

    public List<Photo> searchPhoto(String attributeName) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = builder.createQuery(Photo.class);
        Root<Photo> cameraRoot =  criteriaQuery.from(Photo.class);
        Predicate predicate=builder.like(cameraRoot.<String >get("url"), "%"+attributeName+"%");
        criteriaQuery.where(predicate);
        criteriaQuery.select(cameraRoot);
        TypedQuery q = getEntityManager().createQuery(criteriaQuery);

        return (List<Photo>) q.getResultList();
    }

}
